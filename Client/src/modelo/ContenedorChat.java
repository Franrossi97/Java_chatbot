package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;

public class ContenedorChat extends Observable
{
    /**
     * Esta clase es el recurso compartido<br>
     * Implementa el patron "Singleton"<br>
     */
    private static ContenedorChat instancia=null;
    private ArrayList<Chat> chats=new ArrayList<Chat>();
    
    private ContenedorChat(){}
    
    public void agregarChat(Chat chat)
    {
        this.chats.add(chat);
    }
    
    public void eliminarChat(Chat chat)
    {
        this.chats.remove(chat);
        chat.cerrarChat();
    }
    
    public ArrayList<Chat> getChats()
    {
        return chats;
    }
    
    public static ContenedorChat getInstance()
    {
        if (instancia==null)
            instancia=new ContenedorChat();
        return instancia;
    }
    
    /**
     * Busca entre los chats y crea un ArrayList de chats donde se puede preguntar.<br>
     * <b>Pre:</b> se recibe un ArrayList de todos los chats que posee un participante, puede estar vacio o no.<br>
     * <b>Post:</b> se crea un chat con los chats disponibles para preguntar.<br>
     * @param chats ArrayList de chats que posee cada Participante con todos lo chats disponibles.<br>
     * @return ArrayList de chats disponibles para realizar una pregunta.<br>
     */
    
    public ArrayList<Chat> chatsPreguntar(ArrayList<Chat> chats)
    {
        ArrayList<Chat> c=null;
        if (chats.size()!=0)
        {
            c=new ArrayList<Chat>();
            Iterator<Chat> it=chats.iterator();
            while(it.hasNext())
            {
                Chat chat=it.next();
                if (chat.getPEsperandoRta()==null)
                    c.add(chat);
            }
        }
        return c;
    }
    
    /**
     * Busca entre los chats y crea un ArrayList de chats donde se puede responder.<br>
     * <b>Pre:</b> se recibe un ArrayList de todos los chats que posee un participante, puede estar vacio o no.<br>
     * <b>Post:</b> se crea un chat con los chats disponibles para responder.<br>
     * @param p robot que invoca el metodo. Se lo utiliza para evitar indicar que debe responder a su propia pregunta.<br>
     * @param chats ArrayList de chats que posee cada Participante con todos lo chats disponibles. Debe ser distinto de null<br>
     * @return ArrayList de chats disponibles para dar un respuesta.<br>
     */
    
    public ArrayList<Chat> chatsResponder(Participante p,ArrayList<Chat> chats)
    {
        ArrayList<Chat> c=null;
        if (chats.size()!=0)
        {
            c=new ArrayList<Chat>();
            Iterator<Chat> it=chats.iterator();
            while(it.hasNext())
            {
                Chat chat=it.next();
                if (chat.getPEsperandoRta()!=null &&chat.getPEsperandoRta()!=p)
                    c.add(chat);
            }
        }
        return c;
    }
    
    public static int random(int n) {
        int r = 0;
        for (int i =0; i <n;i++) {
            r+=helper();
        }
        return r;
    }

    // helper that returns 0 or 1
    private static int helper() {
        long t = System.nanoTime();
        if (t%2 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * Este es el metodo encargado de invocar los metodos, dependiendo del estado de el participante, para preguntar o responder.<br>
     * <b>Pre:</b> el robot quiere realizar una acción(preguntar/responder).<br>
     * <b>Post:</b> el robot realizo la accion(preguntar/responder) que deseaba realizar.<br>
     * @param r es el Robot que preguntara o respondera. Debe ser distinto de null.<br>
     * @param c es el ArrayList de chats donde participa el Robot.<br>
     */
    
    public synchronized void accion(Robot r,ArrayList<Chat> c)
    {
        Chat chat;
        while(this.chatsPreguntar(c)==null && this.chatsResponder(r,c)==null)
        {
            try
            {
                wait();
            } catch (InterruptedException e){}
        }
        int aux=c.size()-1;
        if (aux==0)
            chat=c.get(0);
        else
        {
            //chat=c.get(random.nextInt(aux));
            chat=c.get(random(aux));
        }
        chat.getEstado(r).enviarMensajeRobot(r);
    }
    
    /* public synchronized void preguntar(Robot r)
    {
        Chat chat=this.getChatEsperando(r);
        if(chat!=null)
            this.responder(r,chat);
        while(this.getChatEsperando(r)==null)
        {
            try
            {
                wait();
            } catch (InterruptedException e){}
        }
    } */
    
    /**
     * Se encarga de notficar en la vista genral de los chats la pregunta que se realizo.<br>
     * <b>Pre:</b> la pantalla se encuentra con la ultima pregunta/respuesta de cualquiera de los chats.<br>
     * <b>Post:</b> la pantalla se encuentra con la pregunta realizada por el Robot.<br>
     * @param chat es el chat donde se realizara la pregunta, se utiliza para poder actualizar la vista del chat privado.<br>
     * @param r es el Robot que realiza pregunta.<br>
     * @param preg es la pregunta que se va a ser realizada por el Robot.<br>
     */
    
    public synchronized void preguntar(Chat chat,Robot r,Pregunta preg)
    {
        chat.pregunta(r, preg);
        setChanged();
        if (chat.getOtroParticipante(r)==Humano.getInstancia())
            notifyObservers(this.horaSistema()+": " + r.getNombre() + " a mi: " + preg);
        else
            notifyObservers(this.horaSistema()+": " + r.getNombre() + " a " + chat.getOtroParticipante(r).getNombre() + ": " + preg);
        notifyAll();
    }
    
    /**
     * Se encarga de notficar en la vista genral de los chats la pregunta que se realizo.<br>
     * <b>Pre:</b> la pantalla se encuentra con la ultima pregunta/respuesta de cualquiera de los chats.<br>
     * <b>Post:</b> la pantalla se encuentra con la respuesta dada por el Robot.<br>
     * @param chat es el chat donde se dara la respuesta, se utiliza para poder actualizar la vista del chat privado.<br>
     * @param r es el Robot que da la respuesta.<br>
     * @param res es la respuesta que se va a ser dada por el Robot.<br>
     */
    
    public synchronized void responder(Chat chat,Robot r,Respuesta res)
    {
        chat.responde(r, res);
        setChanged();
        if (chat.getOtroParticipante(r)==Humano.getInstancia())
            notifyObservers(this.horaSistema()+": " + r.getNombre() + " a mi: " + res);
        else
            notifyObservers(this.horaSistema()+": " + r.getNombre() + " a " + chat.getOtroParticipante(r).getNombre() + ": " + res);
        notifyAll();
    }
    
    /**
     * Notifica por pantalla la pregunta realizada por el Humano.<br>
     * <b>Pre:</b> la pantalla se encuentra con la ultima pregunta/respuesta de cualquiera de los chats.<br>
     * <b>Post:</b> la pantalla se encuentra con la pregunta realizada por el Humano.<br>
     * @param chat chat es el chat donde se realizara la pregunta, se utiliza para poder actualizar la vista del chat privado.<br>
     * @param p es el Humano que realizara la pregunta.<br>
     * @param preg es la pregunta que realizara el Humano.<br>
     */
    
    public synchronized void preguntaHumano(Chat chat,Participante p,Pregunta preg)
    {
        chat.preguntaHumano(p,preg);
        setChanged();
        notifyObservers(this.horaSistema()+": " + "Yo a " + chat.getOtroParticipante(p).getNombre() + ": " + preg);
        notifyAll();
    }
    
    /**
     * Notifica por pantalla la respuesta dada por el Humano.<br>
     * <b>Pre:</b> la pantalla se encuentra con la ultima pregunta/respuesta de cualquiera de los chats.<br>
     * <b>Post:</b> la pantalla se encuentra con la respuesta dada por el Humano.<br>
     * @param chat chat es el chat donde se realizara la respuesta, se utiliza para poder actualizar la vista del chat privado.<br>
     * @param res es la respuesta que dara el Humano.<br>
     */
    
    public synchronized void respuestaHumano(Chat chat,Respuesta res)
    {
        chat.respuestaHumano(res);
        setChanged();
        notifyObservers(this.horaSistema()+": " + "Yo a " + chat.getOtroParticipante(Humano.getInstancia()).getNombre() + ": " + res);
        notifyAll();
    }
    
    public synchronized void notificarNuevoChat()
    {
        notifyAll();
    }
    
    public String horaSistema()
    {
        Calendar time=new GregorianCalendar();
        int hora, minutos, segundos;
        hora =time.get(Calendar.HOUR_OF_DAY);
        minutos = time.get(Calendar.MINUTE);
        segundos = time.get(Calendar.SECOND);
        return ""+hora+":"+minutos+":"+segundos;
    }
    
    /**
     * Actualiza el HashMap de preguntas hechas de todos los chats agregando una pregunta nueva que se haya agregado a la base de datos.<br>
     * <b>Pre:</b> el HashMap de preguntas hechas se encuentra vacio o con las preguntas que hay en la base de datos.<br>
     * <b>Post:</b> el HashMap de preguntas hechas se encuentra con la nueva pregunta que se guarda en el HashMap.<br>
     * @param p es la pregunta que va a ser agregada al HashMap de todos los chats.<br>
     */
    
    public void actualizarRobotsPregHechas(Pregunta p)
    {
        Participante participante;
        Iterator<Chat> it=this.chats.iterator();
        Chat chat;
        ArrayList<Participante> participantes;
        while(it.hasNext())
        {
            chat=it.next();
            participantes=chat.getIntegrantes();
            Iterator<Participante> it2=participantes.iterator();
            while(it2.hasNext())
            {
                participante=it2.next();
                if(participante!=Humano.getInstancia())
                {
                    HashMap<Pregunta,Boolean>aux=chat.getPregsHechas().get(participante);
                    aux.put(p,false);   
                }
            }
        }
        
        /*Iterator<Robot> it=this.robots.values().iterator();//No anda Juani!!!!
        while(it.hasNext())
            it.next().addPregHecha(p);*/
    }
}

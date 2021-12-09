package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class Chat extends Observable
{
    private ArrayList<Participante> integrantes=new ArrayList <Participante>();
    private HashMap<Participante,IEstado> estados=new HashMap<Participante,IEstado>();
    private HashMap<Participante,HashMap<Pregunta,Boolean>> pregsHechas=new HashMap<Participante,HashMap<Pregunta,Boolean>>();
    private Participante pEsperandoRta=null;
    private Pregunta pregActual=null;
    public static final String CERRAR= "CERRAR";
     
    /**
     * Constructor del chat
     */
    
    public Chat(){}
    
    /**
     * Metodo que notifica si un Robot debe responder una pregunta, y devuelve cual es la pregunta que se debe responder<br>
     * <b>Pre:</b> el parametro p debe ser distinto de null.<br>
     * <b>Post:</b> devuelve la respuesta que el robot debe responder, si no devuelve null.<br>
     * @param p Es el robot al cual se le va a indicar si debe responder, debe ser distinto de null
     * @return pregunta que debe responder el Robot que invoco el metodo.<br>
     */
    
    public Pregunta deboResponder(Participante p)
    {
        Pregunta res=null;
        if (this.pEsperandoRta!=null && this.pEsperandoRta!=p)
            //res=this.pEsperandoRta.pregunta;
            res=pregActual;
        return res;
    }
    
    /**
     * El metodo se encarga de cerrar el chat luego de presionar en la vista el botón "Cerrar Chat", también se ejecuta al elimnar uno de los integrantes.<br>
     * <b>Pre:</b>la lista de integrantes es distinto de null, y posee más de un elemento.<br>
     * <b>Post:</b>la lista de integrantes se vacía, y se elimina de cada integrante el chat de la lista de chats de cada uno.<br>
     */
    
    public void cerrarChat()
    {
        Iterator<Participante> it=this.integrantes.iterator();
        while(it.hasNext())
        {
            Participante p=it.next();
            p.setEsperandoRta(false);
            p.eliminarChat(this);
        }
        ContenedorChat.getInstance().notificarNuevoChat();
    }
    
    /**
     *El metodo se encarga de notificar en el chat particular quien y que le pregunta al otro robot/humano. Además modificara el estado de los participantes al que corresponda.<br>
     * <b>Pre:</b> ambos parametros deben ser distinto de null. La pantalla se encuentra desactualizada con la útlima respuesta que se realizo por el robot/Humano.<br>
     * <b>Post:</b> se actualiza la pantalla con la pregunta que realiza el robot y se cambia el estado de este y del resto.<br>
     * @param p robot que realizara la pregunta. Debe ser distinto de null.<br>
     * @param pregunta pregunta que realizara un robot. Debe ser distinto de null.<br>
     */
    
    public void pregunta(Participante p,Pregunta pregunta)
    {
        setChanged();
        notifyObservers(p.getNombre()+": "+pregunta.toString());
        p.setEsperandoRta(true);
        this.pEsperandoRta=p;
        this.pregActual=pregunta;
        this.setEstado(p, new EsperandoRtaState(this));
        this.setEstado(this.getOtroParticipante(p), new RespondoState(this));
    }
    
    /**
     * El metodo se encarga de notificar la respuesta del robot por pantalla, además desencadena el proceso de agregado de una pregunta nueva. Además modificara el estado de los participantes a los que corresponda.<br>
     * <b>Pre:</b> los dos parametros deben ser null. La pantalla se encuentra desactualizada con la última pregunta realizada por el Robot/Humano.<br>
     * <b>Post:</b> la pantalla se actualiza con la respuesta que realiza el robot y se cambia el estado de este y del resto.<br>
     * @param p es el robot que respondera a la pregunta del otro Robot/Humano. Debe ser didtinto de null.<br>
     * @param respuesta es la respuesta que dará el robot a la pregunta realizada por el otro Robot/Humano. Debe ser distinto de null.<br>
     */
                    
    public void responde(Participante p,Respuesta respuesta)
    {
        setChanged();
        notifyObservers(p.getNombre()+": "+respuesta.toString());
        this.pEsperandoRta.setEsperandoRta(false);
        if (respuesta.equals(Participante.RTAPREGNUEVA))
        {
            //this.pregunta(p, Participante.DAMERTA);
            ContenedorChat.getInstance().preguntar(this,(Robot) p, Participante.DAMERTA);
        }
        else //PEsperandoRta es Humano
        {
            this.setEstado(p,new PreguntoState(this));
            this.setEstado(this.getOtroParticipante(p),new PreguntoState(this));
            this.pEsperandoRta=null;
        }
        //notifyAll();
    }
    
    /**
     *Este metodo notificara por pantalla la pregunta que el humano le realiza al robot.<br>
     * <b>Pre:</b> la pantalla se encuentra con la respuesta realizada por el Robot/Humano.<br>
     * <b>Post:</b> se visualiza por pantalla la pregunta realizada por el Humano.<br>
     * @param p es el humano que realiza la pregunta. Debe ser distinto de null.<br>
     * @param pregunta es la pregunta que el humano va a realizar, se obtiene a traves de la vista y es ingresada por el Humano.<br>
     */
    
    public void preguntaHumano(Participante p,Pregunta pregunta)
    {
        setChanged();
        notifyObservers("Yo: " + pregunta.toString());
        p.setEsperandoRta(true);
        this.pEsperandoRta=p;
        this.pregActual=pregunta;
    }
    
    /**
     * Notifica por pantalla la respuesta que realiza el humano a la pregunta del Robot, y se encarga de invocar el metodo que agrega una pregunta nueva si es necesario.<br>
     * <b>Pre:</b> la pantalla se encuentra con la ultima pregunta que realiza el Robot, o con el prdido de proveer una respuesta a la pregunta desconocida que realizó el humano.<br>
     * <b>Post:</b> se ve por pantalla la respuesta ingresada por el Humano en la ventana, y de haber sido necesario se guarda la pregunta.<br>
     * @param respuesta es la respuesta que de el Humano, es ingresada por el usuario en la ventana. Debe ser distinto de null.<br>
     */
    
    public void respuestaHumano(Respuesta respuesta)
    {
        setChanged();
        notifyObservers("Yo: " + respuesta.toString());
        this.pEsperandoRta.setEsperandoRta(false);
        if (pregActual.equals(Participante.DAMERTA))
        {
            Robot r=(Robot)pEsperandoRta;
            r.registrarPregunta(respuesta);
        }
        else
            this.pEsperandoRta.registrarRta(respuesta,pregActual);   
        this.pEsperandoRta=null;
    }
    
    /**
     * Desencadena el proceso de cerrado del chat luego de haber eliminado uno de los participantes<br>
     * <b>Pre:</b> se ve por pantalla el chat.<br>
     * <b>Post:</b> el chat es eliminado de la pantalla.<br>
     */
    
    public void notificarCerrar()
    {
        setChanged();
        notifyObservers(CERRAR);
    }
    
    /**
     * Se encarga de agregar un integrante nuevo el chat.<br>
     * <b>Pre:</b> la lista de integrantes se encuentra vacia o con un integrante.<br>
     * <b>Post:</b> se agrega un integrante a la lista.<br>
     * @param p es el participante que se va a agregar, puede ser un Humano o un Robot. Debe ser distinto de null.<br>
     */
    
    public void agregarIntegrante(Participante p)
    {
        integrantes.add(p);
        if(p!=Humano.getInstancia())
            this.cargarHashMap((Robot)p);
    }

    public ArrayList<Participante> getIntegrantes()
    {
        return integrantes;
    }

    public Participante getPEsperandoRta()
    {
        return pEsperandoRta;
    }

    public void setEstado(Participante p,IEstado estado)
    {
        this.estados.put(p,estado);
    }

    public IEstado getEstado(Participante p)
    {
        return this.estados.get(p);
    }

    public Pregunta getPregActual()
    {
        return pregActual;
    }
    
    public Participante getOtroParticipante(Participante p)
    {
        Participante res;
        if(p!=this.integrantes.get(0))
            res=this.integrantes.get(0);
        else
            res=this.integrantes.get(1);
        return res;
    }

    public HashMap<Participante, HashMap<Pregunta, Boolean>> getPregsHechas()
    {
        return pregsHechas;
    }
    
    /**
     * Setea todos los valores del HashMap en "false".<br>
     * <b>Pre:</b> el HashMap se encuentra con valores por defecto o con todos sus valores en "true".<br>
     * <b>Post:</b> todos los valores del HashMap quedan seteados en "false".<br>
     * @param r la lista de preguntas usadas corresponde a el robot idicado por el parámetro. Debe ser distinto de null.
     */
    
    public void cargarHashMap(Robot r)
    {
        ArrayList<Pregunta> aux=new ArrayList<Pregunta>(Deserializador.getPreguntas().keySet());
        Iterator<Pregunta> it=aux.iterator();
        HashMap<Pregunta,Boolean> cont=new HashMap<Pregunta,Boolean>();
        while(it.hasNext())
            cont.put(it.next(),false);
        this.pregsHechas.put(r,cont);
    }
    
    /**
     * Analisa si el robot ha hecho todas las preguntas disponibles en el chat.<br>
     * <b>Pre:</b> los valores del HashMap pueden estar todos en "true" o no.<br>
     * <b>Post:</b> se devuelve "true" si todos los valores del HashMap son "true".<br>
     * @param r Robot sobre el que se analizara los valores del HashMap.<br>
     * @return devuelve "true" o "false".<br>
     */
    
    public boolean todosTrue(Robot r)
    {
        boolean cond=true;
        Iterator<Boolean> it=this.pregsHechas.get(r).values().iterator();
        while(it.hasNext()&&cond)
            if(!it.next())
                cond=false;
        return cond;
    }

    public Map<Pregunta, Boolean> getPregHecha(Robot r)
    {
        return this.pregsHechas.get(r);
    }
    
    public void usoPregunta(Robot r,Pregunta p)
    {
        this.pregsHechas.get(r).put(p,true);
    }
    
    public void addPregHecha(Robot r,Pregunta p)
    {
        this.pregsHechas.get(r).put(p,false);
    }
}

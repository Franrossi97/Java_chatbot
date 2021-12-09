package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Humano extends Decorator
{
    /**
     * Forma parte del Patron Decorator y modifica los signos.<br>
     * Implementa el Patron Singleton.<br>
     */
    private static Humano instancia=null;
    private HashMap <String,Robot> robots=new HashMap<String,Robot>();
    
    private Humano(Participante p)
    {
        super(p);
    }
    
    public static boolean isHumanoNull()
    {
        return instancia==null;
    }
    
    public static Humano getInstancia()
    {
        if (instancia==null)
        {
            Random r=new Random();
            int signo=r.nextInt(3);
            Participante p=null;
            switch(signo)
            {
                case 0: p=new Tierra();
                break;
                case 1: p=new Fuego();
                break;
                case 2: p=new Agua();
                break;
                case 3: p=new Aire();
                break;
            }
            instancia=new Humano(p);
        }
        return instancia;
    }

    public Iterator<String> getListaNombres()
    {
        return this.robots.keySet().iterator();
    }

    public Robot getRobot(String nombre)
    {
        return robots.get(nombre);
    }

    public HashMap<String, Robot> getRobots()
    {
        return robots;
    }
    
    /**
     * Agrega un nuevo Robot y se ejecuta el Start del mismo.<br>
     * @param signo Debe ser mayor/igual a cero y menor a cuatro.<br>
     * @param nombre Debe ser distinto de "".<br>
     * @throws RepiteNombreException
     * @throws NombreNullException
     */

    public void agregarRobot(int signo,String nombre) throws RepiteNombreException, NombreNullException
    {
        if (nombre==null)
            throw new NombreNullException();
        else
            if (robots.containsKey(nombre))
                throw new RepiteNombreException(nombre);
                //se informa al usuario que no hubo exito
            else
            {
                Robot r=RobotFactory.getInstancia(signo, nombre);
                robots.put(nombre, r);
                new Thread(r).start();
            }
    }
    
    public void eliminarRobot(Robot r)
    {
        String s=r.getNombre();
        r.desconectar();
        robots.remove(s);
    }
    
    /**
     * Se agrega a la lista de chats un nuevo chat, y cada participante agrega un chat a su lista de chats.<br>
     * @param chat es el chat donde se van agregar todos los Participantes.<br>
     * @param r1 Debe ser distinto de null.<br>
     * @param r2 Si es distinto de null, el segundo participante es el Humano.<br>
     */
    
    //public void nuevoChat(Chat chat,Robot r1,Robot r2)
    public void nuevoChat(Chat chat,Robot r1,Robot r2)
    {
        if (r2==null)
            this.agregarChat(chat);
        else
        {
            r2.conectar();
            r2.agregarChat(chat);
        }
        r1.conectar();
        r1.agregarChat(chat);
        ContenedorChat.getInstance().agregarChat(chat);
        ContenedorChat.getInstance().notificarNuevoChat();
    }
    
    public void enviarMensaje(String mensaje,Chat chat)
    {
        chat.getEstado(this).enviarMensaje(mensaje);
        //this.estado.enviarMensaje(mensaje, chat);
    }

    /* @Override
    public void respondido(Chat chat)
    {
        chat.setEstado(this,new PreguntoState(chat));
    } */

    @Override
    public void registrarRta(Respuesta r, Pregunta p){}

    @Override
    public String compatible(Participante p)
    {
        return this.participante.compatible(p);
    }

    @Override
    public void conectar(){}

    @Override
    public void desconectar(){}
}

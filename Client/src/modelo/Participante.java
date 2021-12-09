package modelo;

import java.util.ArrayList;

public abstract class Participante //Sino no anda
{
    protected String nombre;
    protected boolean esperandoRta=false;
    protected Pregunta pregunta;
    public static final Respuesta RTAPREGNUEVA=new Respuesta("No entiendo tu pregunta");
    public static final Pregunta PREGSIGNOS=new Pregunta("Tomamos un cafe?");
    public static final Pregunta DAMERTA=new Pregunta("Dame una respuesta");
    ArrayList <Chat>chats = new ArrayList<Chat>();
    
    public Participante(){}
    
    public Participante(String nombre)
    {
        this.nombre=nombre;
    }
    
    /**
     * Agrega un nuevo chat a la lista de chats de el participante.<br>
     * <b>Pre:</b> la lista de chats se encuentra vacia o con otros chats.<br>
     * <b>Post:</b> la lista de chats se carga con el nuevo chat.<br>
     * @param chat es el chat que se va a agregar a la lista. Debe ser disitinto de null.<br>
     */
    
    public void agregarChat(Chat chat)
    {
        chats.add(chat);
        chat.agregarIntegrante(this);
        chat.setEstado(this, new PreguntoState(chat));
    }

    public ArrayList<Chat> getChats()
    {
        return chats;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setEsperandoRta(boolean esperandoRta)
    {
        this.esperandoRta = esperandoRta;
    }

    public boolean isEsperandoRta()
    {
        return esperandoRta;
    }


    public Pregunta getPregunta()
    {
        return pregunta;
    }
    
    public void eliminarChat(Chat chat)
    {
        this.chats.remove(chat);
    }

    public abstract void respondido(Chat chat);
    public abstract void registrarRta(Respuesta r,Pregunta p);
    public abstract void conectar();
    public abstract void desconectar();
    
    public abstract String compatible(Participante p);
}
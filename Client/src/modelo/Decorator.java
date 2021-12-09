package modelo;

public abstract class Decorator extends Participante
{
    protected Participante participante;

    public Decorator(Participante participante)
    {
        this.participante = participante;
    }
    
    public Decorator()
    {
        super();
    }
    
    public Decorator(String nombre)
    {
        super(nombre);
    }

    @Override
    public void respondido(Chat chat){}

    @Override
    public void registrarRta(Respuesta r, Pregunta p){}

    @Override
    public void conectar()
    {
        this.participante.conectar();
    }
    
    @Override
    public void desconectar()
    {
        this.participante.desconectar();
    }
    
    public String getNombre()
    {
        return this.participante.getNombre();
    }

    @Override
    public Pregunta getPregunta()
    {
        return super.getPregunta();
    }

    @Override
    public boolean isEsperandoRta()
    {
        return super.isEsperandoRta();
    }

    public void agregarChat(Chat chat)
    {
        super.agregarChat(chat);
    }

    @Override
    public void setEsperandoRta(boolean esperandoRta)
    {
        super.setEsperandoRta(esperandoRta);
    }
    
    public void eliminarChat(Chat chat)
    {
        super.eliminarChat(chat);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}

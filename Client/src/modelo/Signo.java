package modelo;

public abstract class Signo extends Participante implements ISigno
{
    public Signo(String string)
    {
        super(string);
    }

    public Signo()
    {
        super();
    }

    @Override
    public void respondido(Chat chat)
    {}

    @Override
    public void registrarRta(Respuesta r, Pregunta p)
    {}

    @Override
    public void conectar()
    {}

    @Override
    public void desconectar()
    {}
}

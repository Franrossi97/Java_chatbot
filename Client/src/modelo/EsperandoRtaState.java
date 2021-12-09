package modelo;

public class EsperandoRtaState implements IEstado
{
    Chat chat;
    
    public EsperandoRtaState(Chat c)
    {
        chat=c;
    }
    
    @Override
    public void enviarMensaje(String mensaje){}

    @Override
    public void enviarMensajeRobot(Robot r){}
}

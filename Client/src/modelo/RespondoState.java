package modelo;

import java.util.ArrayList;

public class RespondoState implements IEstado
{
    Chat chat;
    
    public RespondoState(Chat c)
    {
        chat=c;
    }
    
    @Override
    public void enviarMensaje(String mensaje)
    {
        Respuesta r=new Respuesta(mensaje);
        //chat.respuestaHumano(r);
        ContenedorChat.getInstance().respuestaHumano(chat,r);
        chat.setEstado(Humano.getInstancia(),new PreguntoState(chat));
        chat.setEstado(chat.getOtroParticipante(Humano.getInstancia()),new PreguntoState(chat));
    }

    @Override
    public void enviarMensajeRobot(Robot r)
    {
        ArrayList<Pregunta> preg=new ArrayList<Pregunta>(Deserializador.getPreguntas().keySet());
        Respuesta res;
        if (chat.getPregActual().equals(Participante.PREGSIGNOS))
            res=new Respuesta(chat.getPEsperandoRta().compatible(r.participante));
        else
        {
            res=r.buscoRespuesta(chat.getPregActual(),preg);
        }
        ContenedorChat.getInstance().responder(chat,r,res);
    }
}
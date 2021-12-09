package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PreguntoState implements IEstado
{
    Chat chat;
    
    public PreguntoState(Chat c)
    {
        this.chat=c;
    }
    
    /**
     * Se selecciona la pregunta que se va a realizar de forma azarosa.<br>
     * @param r es el Robot que va a realizar la pregunta.<br>
     * @param aux es la cantidad de preguntas disponibles menos 1.<br>
     * @return pregunta que va a realizar el Robot.<br>
     */
    
    public Pregunta getPregunta(Robot r,int aux)
    {
        ArrayList<Pregunta> preguntas=new ArrayList<Pregunta>(Deserializador.getPreguntas().keySet());
        HashMap<Pregunta,Boolean> pregsHechas=this.chat.getPregsHechas().get(r);
        Pregunta pregunta,x=null;
        int i=ContenedorChat.random(aux);
        if (aux==0)
            pregunta=preguntas.get(0);
        else
            pregunta=preguntas.get(i);
        while(x==null&&!this.chat.todosTrue(r))
        {
            if(i<pregsHechas.size())
            {
                if(!pregsHechas.get(pregunta))
                {
                    this.chat.usoPregunta(r,pregunta);
                    x=pregunta;
                }
                else
                {
                    i++;
                    pregunta=preguntas.get(i);
                }   
            }
            else
            {
                i=0;
                pregunta=preguntas.get(i);
            }
        }
        if(x==null)
        {
            this.chat.cargarHashMap(r);
            if (aux==0)
                x=preguntas.get(0);
            else
                x=preguntas.get(ContenedorChat.random(aux));
            this.chat.usoPregunta(r, pregunta);
        }
        return x;
    }    
    
    /**
     * Invoca a el metodo que realizara la pregunta al Robot. Además de cambiar los estados de cada participante.<br>
     * @param mensaje es la pregunta que se va a realizar.<br>
     */
    
    @Override
    public void enviarMensaje(String mensaje)
    {
        Pregunta p=new Pregunta(mensaje);
        ContenedorChat.getInstance().preguntaHumano(chat,Humano.getInstancia(), p);
        chat.setEstado(Humano.getInstancia(),new EsperandoRtaState(chat));
        chat.setEstado(chat.getOtroParticipante(Humano.getInstancia()),new RespondoState(chat));
    }
    
    /**
     * Invoca a el metodo que realizara la pregunta al Robot/Humano. Además de cambiar los estados de cada participante.<br>
     * @param r es el robot que va a realizar la pregunta.<br>
     */

    @Override
    public void enviarMensajeRobot(Robot r)
    {
        ArrayList<Pregunta> preguntas=new ArrayList<Pregunta>(Deserializador.getPreguntas().keySet());
        Pregunta pregunta;
        int aux1=preguntas.size()-1;
        pregunta=this.getPregunta(r,aux1);
        ContenedorChat.getInstance().preguntar(chat,r,pregunta);
    }
}
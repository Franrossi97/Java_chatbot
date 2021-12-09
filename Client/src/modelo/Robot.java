package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Robot extends Decorator implements Runnable
{ 
    Random r=new Random();
    Random r1=new Random();
    Random r2=new Random();
    private IEstado estado=null;
    private boolean conectado;
    private Pregunta preguntaARegistrar=null;
    private boolean startOK=false;
    //private Map<Pregunta,Boolean> pregHecha =new HashMap<Pregunta,Boolean>();
    
    public Robot(Participante p)
    {
        super(p);
        this.conectado=false;
    }
    
    public Respuesta buscoRespuesta(Pregunta p,ArrayList<Pregunta> preguntas)
    {
        boolean esta=false;
        Respuesta respuesta;
        ArrayList<Respuesta> res=null;
        Pregunta pregunta=null;
        ArrayList<String> tags;
        int cont,cant,t,max=3,cant2;
        HashMap<Pregunta,ArrayList<Respuesta>> pyr =Deserializador.getPreguntas();
        for(int j=0;j<preguntas.size() && !esta;j++) // recorre las preguntas
        {
            if (preguntas.get(j).equals(p))
            {
                pregunta=preguntas.get(j);
            }
            else
            {
                cant=preguntas.get(j).getTags().size();
                cant2=p.getTags().size();
                tags=preguntas.get(j).getTags();
                cont=0;t=0;
                for (int i=0;i<cant&&t<cant2;i++) //recorre las palabras de la pregunta
                {
                    if(t<cant&&tags.get(i).equalsIgnoreCase(p.getTags().get(t)))
                        cont++;
                    t++;
                }
                if (cont>max)
                {
                    max=cont;
                    pregunta=preguntas.get(j);
                }
            }
        }
        if(pregunta!=null)
        {
            res=pyr.get(pregunta);
            int aux=res.size()-1;
            if(aux==0)
                respuesta=res.get(0);
            else
            {
                //r2.setSeed(Math.abs(System.currentTimeMillis()));
                respuesta=res.get(r2.nextInt(aux));
                //respuesta=res.get((int) Math.random()*aux);
            }
        }
        else
        {
            respuesta=Participante.RTAPREGNUEVA;
            this.preguntaARegistrar=p;
        }
        return respuesta;
    }
    
    @Override
    public void run()
    {
        while (conectado) //Variable booleana de la ventana que indica que se cerro
        {
            //Respuesta res;
            //Pregunta p=null;
            //Chat chat;
            //int aux=this.chats.size()-1;
            //ArrayList<Pregunta> preguntas=new ArrayList<Pregunta>(Deserializador.getPreguntas().keySet());
            //int aux1=preguntas.size()-1;
            if (this.chats.size()!=0)
            {
                UtilThread.espera();
                ContenedorChat.getInstance().accion(this,this.chats);
            }
        }
    }
    
    public void conectar()
    {
        this.conectado=true;
    }

    public void desconectar()   //fin del hilo
    {
        //ArrayList<Participante> integrantes;
        this.conectado = false;
        for (int i=0;i<this.chats.size();i++)
        {
            /* integrantes=chats.get(i).getIntegrantes();
            Iterator<Participante> it=integrantes.iterator();
            while (it.hasNext())
            {
                it.next().eliminarChat(chats.get(i));
            } */
            ContenedorChat.getInstance().eliminarChat(chats.get(i));
            //chats.get(i).cerrarChat();
        }
    }

    public boolean isConectado()
    {
        return conectado;
    }
    
    public void registrarPregunta(Respuesta r)
    {
        HashMap<Pregunta,ArrayList<Respuesta>> pyr =Deserializador.getPreguntas();
        ArrayList<Respuesta> res=new ArrayList<Respuesta>();
        res.add(r);
        pyr.put(preguntaARegistrar,res);
        ContenedorChat.getInstance().actualizarRobotsPregHechas(preguntaARegistrar);
        Deserializador.setPreguntas(pyr);
        try
        {
            Serializador.generoDB(pyr);
        } catch (IOException e)
        {
        }
    }

    @Override
    public void registrarRta(Respuesta r,Pregunta p)
    {
        HashMap<Pregunta,ArrayList<Respuesta>> pyr =Deserializador.getPreguntas();
        ArrayList<Respuesta> res= pyr.get(p);
        if (res!=null && !res.contains(r))
        {
            res.add(r);
            pyr.put(p,res);
            Deserializador.setPreguntas(pyr);
            try
            {
                Serializador.generoDB(pyr);
            } catch (IOException e)
            {
            }
        }
    }


    @Override
    public void agregarChat(Chat chat)
    {
        super.agregarChat(chat);
        if (this.chats.size()==1 && !this.startOK)
        {
            new Thread(this).start();
            this.startOK=true;
        }
    }

    @Override
    public void respondido(Chat chat){}

    @Override
    public String compatible(Participante p)
    {
        return this.participante.compatible(p);
    }    
}

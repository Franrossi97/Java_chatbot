package Controlador;

import Vista.IVista;

import Vista.PanelChat;
import Vista.VentanaChat;
import Vista.VentanaException;
import Vista.VentanaException;
import Vista.VentanaNuevo;
import Vista.VentanaNuevoHumano;

import Vista.VentanaUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import modelo.Chat;
import modelo.ChatExistenteException;
import modelo.ContenedorChat;
import modelo.Humano;
import modelo.NombreNullException;
import modelo.NuevoHumanoException;
import modelo.Participante;
import modelo.RepiteNombreException;
import modelo.Robot;
import modelo.SeleccionNullException;

public class ControladorUsuario implements ActionListener
{
    public static final String NUEVO="NUEVO";
    public static final String ABRIR="ABRIR";
    public static final String ELIMINAR="ELIMINAR";
    public static final String INGRESAR="INGRESAR";
    public static final String CERRARSESION="CERRARSESION";
    IVista vista = new VentanaUsuario();
    VentanaChat vistaChat=VentanaChat.getInstance();//Habría que sacarlo de aca
    
    public ControladorUsuario()
    {
        super();
        this.vista.addActionListener(this);
    }
    
    public VentanaUsuario getVista()
    {
        return (VentanaUsuario)vista;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (actionEvent.getActionCommand().equals(ControladorUsuario.ABRIR))
        {
            Participante p1,p2;
            Robot r1,r2=null;
            Chat chat;
            VentanaUsuario vUsuario=(VentanaUsuario) vista;
            List<String> lista=vUsuario.getSeleccion();
            if (lista.isEmpty())
                try
                {
                    throw new SeleccionNullException();
                } 
                catch (SeleccionNullException e)
                {
                    VentanaException exp=new VentanaException();
                    exp.imprime(e.getMensaje());
                }
            else
            {
                if (lista.size() == 2)
                {
                    r2 = Humano.getInstancia().getRobot(lista.get(1));
                    p2=r2;
                }
                else
                    p2=Humano.getInstancia();
                r1 = Humano.getInstancia().getRobot(lista.get(0));
                Iterator<Chat> it=ContenedorChat.getInstance().getChats().iterator();
                
                boolean existe=false;
                while (it.hasNext() && !existe)
                {
                    Chat c=it.next();
                    if (c.getIntegrantes().contains(r1) && c.getIntegrantes().contains(p2))
                        existe=true;
                }
                if(existe)
                    try
                    {
                        throw new ChatExistenteException();
                    } catch (ChatExistenteException e)
                    {
                        VentanaException exp=new VentanaException();
                        exp.imprime(e.getMensaje());
                    }
                else
                {
                    chat = new Chat();
                    PanelChat p = new PanelChat();
    
                    p.añadirObservable(chat);
                    if (r2 == null)
                        vistaChat.addChat(r1.getNombre(), p);
                    else
                        vistaChat.addChat(r1.getNombre() + " - " + r2.getNombre(), p);
                    //ControladorChat.getInstance().agregarActionListener(p);
                    new ControladorChat(p);
                    Humano.getInstancia().nuevoChat(chat, r1, r2);
                }
            }
        }
        if (actionEvent.getActionCommand().equals(ControladorUsuario.ELIMINAR))
        {
            Robot robot;
            //Robot r;
            VentanaUsuario u=(VentanaUsuario) vista;
            List<String> lista=u.getSeleccion();
            if(!lista.isEmpty())
            {
                for(int i=0;i<lista.size();i++)
                {
                    robot=Humano.getInstancia().getRobot(lista.get(i));
                    ArrayList<Chat> chats=robot.getChats();
                    int cant=chats.size();
                    while (cant>0)
                    {
                        chats.get(cant-1).notificarCerrar();
                        cant--;
                    }
                    Humano.getInstancia().eliminarRobot(robot);
                    u.elimiarRobot(lista.get(i));
                }
            }
            else
                try
                {
                    throw new SeleccionNullException();
                } 
                catch (SeleccionNullException e)
                {
                    VentanaException exp=new VentanaException();
                    exp.imprime(e.getMensaje());
                }
            //new VentanaEliminarNullException();
        }
        if (actionEvent.getActionCommand().equals(ControladorUsuario.NUEVO))
        {
            Random r=new Random();
            //VentanaNuevo vNuevo=new VentanaNuevo();
            //ControladorNuevo.getInstancia().NOMBRE=null;
            ControladorNuevo.getInstancia().setVentana(new VentanaNuevo());
            //ControladorNuevo c=new ControladorNuevo();
            VentanaUsuario u=(VentanaUsuario) vista;
            /* String nombre=v.getNombre();
            v.cerrar(); //la cierro despues de haber obtenido el nombre del robot */
            try
            {
                Humano.getInstancia().agregarRobot(r.nextInt(3), ControladorNuevo.NOMBRE);
            } 
            catch (RepiteNombreException e)
            {
                VentanaException exp=new VentanaException();
                exp.imprime(e.getMensaje());
            } 
            catch (NombreNullException e)
            {
                VentanaException exp=new VentanaException();
                exp.imprime(e.getMensaje());
            }

            u.agregarRobot(ControladorNuevo.NOMBRE);
        }
        if (actionEvent.getActionCommand().equals(ControladorUsuario.INGRESAR))
        {
            if(Humano.isHumanoNull())
            {
                VentanaNuevoHumano ventana=new VentanaNuevoHumano();
                VentanaUsuario v=(VentanaUsuario)vista;
                v.setNombre(ventana.getNombre());
                Humano.getInstancia();
            }
            else
                try
                {
                    throw new NuevoHumanoException();
                } 
                catch (NuevoHumanoException e)
                {
                    VentanaException exp=new VentanaException();
                    exp.imprime(e.getMensaje());
                }
        }
        if (actionEvent.getActionCommand().equals(ControladorUsuario.CERRARSESION))
        {
            Iterator<Robot> it=Humano.getInstancia().getRobots().values().iterator();
            while (it.hasNext())
            {
                it.next().desconectar();
            }
            VentanaChat.getInstance().cerrar();
            VentanaUsuario v=(VentanaUsuario)vista;
            v.cerrar();
        }
    }
}

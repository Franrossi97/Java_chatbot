package Controlador;

import Vista.IVista;
import Vista.PanelChat;
import Vista.VentanaChat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Chat;
import modelo.ContenedorChat;
import modelo.Humano;
import modelo.Participante;
import modelo.Pregunta;
import modelo.Respuesta;

public class ControladorChat implements ActionListener
{
    private static ControladorChat controladorChat=null;
    public static final String ENVIAR="ENVIAR";
    public static final String CERRAR="CERRAR";
    private Chat chat;
    IVista vista;
    
    public ControladorChat(PanelChat panel)
    {
        this.vista=panel;
        panel.addActionListener(this);
        this.chat=panel.getChat();
    }
    

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getActionCommand().equals(ControladorChat.ENVIAR))
        {
            //PanelChat panel=(PanelChat)actionEvent.getSource();
            PanelChat panel=(PanelChat) vista;
            if (panel.getChat().getIntegrantes().get(0).equals(Humano.getInstancia()) || panel.getChat().getIntegrantes().get(1).equals(Humano.getInstancia()))
            {
                String mensaje= panel.getMensaje();
                Humano.getInstancia().enviarMensaje(mensaje, chat);
            }
        }
        if(actionEvent.getActionCommand().equals(ControladorChat.CERRAR))
        {
            //PanelChat panel=(PanelChat)actionEvent.getSource();
            PanelChat panel=(PanelChat) vista;
            VentanaChat.getInstance().remChat(panel);
            ContenedorChat.getInstance().eliminarChat(chat);
            //chat.cerrarChat();
        }
    }
}

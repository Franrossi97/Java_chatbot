package modelo;

import Controlador.ControladorChat;
import Controlador.ControladorNuevo;
import Controlador.ControladorUsuario;

import java.io.IOException;

public class Prueba
{
    public static void main(String[] args)
    {
        Serializador s=new Serializador();
        Deserializador d=new Deserializador();
        d.cargoDB();
        /*d.getPreguntas().put(Participante.PREGSIGNOS,null);
        try
        {
            s.generoDB(d.getPreguntas());
        } catch (IOException e){}*/
        ControladorUsuario cUsuario=new ControladorUsuario();
        cUsuario.getVista().iniciar();
        //ControladorChat cChat=ControladorChat.getInstance();
        //ControladorNuevo cNuevo=new ControladorNuevo();
    }
}
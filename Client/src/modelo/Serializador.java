package modelo;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializador
{
    private static FileOutputStream file;
    private static ObjectOutputStream output;
    private static final String name="DB.xml";
    
    public static void abrir() throws IOException
    {
        file=new FileOutputStream(name);
        //output=new ObjectOutputStream(file);
    }
    
    public void cerrar() throws IOException
    {
        if(output!=null)
            output.close();
    }
    
    public static void generoDB(HashMap<Pregunta,ArrayList<Respuesta>> p) throws IOException
    {
        abrir();
        XMLEncoder encoder=new XMLEncoder(new BufferedOutputStream(file));
        encoder.writeObject(p);
        encoder.close();
    }
}

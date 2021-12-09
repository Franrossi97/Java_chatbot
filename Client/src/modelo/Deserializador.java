package modelo;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Deserializador
{
    /**
     * Contiene a la Base de Datos durante la ejecución.<br>
     */
    private FileInputStream file;
    private ObjectInputStream input;
    private static final String name="DB.xml";
    private static HashMap<Pregunta,ArrayList<Respuesta>> preguntas=new HashMap<Pregunta,ArrayList<Respuesta>>();

    public static void setPreguntas(HashMap<Pregunta, ArrayList<Respuesta>> preguntas)
    {
        Deserializador.preguntas=preguntas;
    }

    public static HashMap<Pregunta, ArrayList<Respuesta>> getPreguntas()
    {
        return preguntas;
    }

    /**
     * Se abre el archivo donde se va a almacenar la Base de Datos.<br>
     * @throws IOException
     */
    
    public void abrir() throws IOException
    {
        file=new FileInputStream(name);
        //input=new ObjectInputStream(file);
    }
    
    public void cerrar() throws IOException
    {
        if(input!=null)
            input.close();
    }
    
    /**
     * Carag la base de datos en un archivo XML.<br>
     * <b>Pre:</b> el archivo se encuentra vacio o con las preguntas que se agregaron previamente. "file" debe ser distinto de null.<br>
     * <b>Post:</b> el archivo se encuentra actualizado con ultima pregunta.<br>
     */
    
    public void cargoDB()
    {
        try
        {
            this.abrir();
        } catch (IOException e){}
        XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(file));
        preguntas=(HashMap<Pregunta,ArrayList<Respuesta>>)decoder.readObject();
        decoder.close();
    }
    
    public String toString()
    {
        String cadena="DB:\n";
        Iterator<Pregunta> it=preguntas.keySet().iterator();
        Iterator<Respuesta> itR;
        while(it.hasNext())
        {
            cadena+=it.next().toString()+"\n";
            itR=preguntas.get(it.next()).iterator();
            while(itR.hasNext())
            {
                cadena+=itR.next().toString()+"\n";
            }
        }
        return cadena;
    }
}

package modelo;

import java.io.Serializable;

import java.util.ArrayList;

public class Pregunta implements Serializable
{
    private String[] pregunta;
    private ArrayList<String> tags=new ArrayList<String>();
    
    public Pregunta(){}
    
    public Pregunta(String pregunta)
    {
        this.pregunta=pregunta.split(" ");
        this.generoTags();
    }
    
    /**
     * Se generan los tags que se van a usar para encontrar un respuesta adecuada.<br>
     * <b>Pre:</b> el array de chats se encuentra vacio.<br>
     * <b>Post:</b> el array de chats se encuentra cargado con los Tags de la pregunta.<br>
     */
    
    private void generoTags()
    {
         for(int i=0;i<this.pregunta.length;i++)
            if(this.pregunta[i].length()>2)
                this.tags.add(this.pregunta[i]);
    }

    public String[] getPregunta()
    {
        return pregunta;
    }

    public ArrayList<String> getTags()
    {
        return tags;
    }
    
    @Override
    public boolean equals(Object o)
    {
        int i=0;
        Pregunta p=(Pregunta)o;
        while (i<this.pregunta.length && p.getPregunta()[i].equalsIgnoreCase(this.pregunta[i]))
            i++;
        return i==this.pregunta.length;
        //return this.toString().equalsIgnoreCase(p.toString());  //arreglar, comparar el vector de palabras. ver hashcod
    }

    
    @Override
    public String toString()
    {
        String cadena="";
        for(int i=0;i<this.pregunta.length;i++)
            cadena+=this.pregunta[i]+" ";
        return cadena;
    }

    public void setPregunta(String[] pregunta)
    {
        this.pregunta = pregunta;
    }

    public void setTags(ArrayList<String> tags)
    {
        this.tags = tags;
    }
}

package modelo;

import java.io.Serializable;

public class Respuesta implements Serializable
{
    private String respuesta;
    
    public Respuesta(){}
    
    public Respuesta(String res)
    {
        respuesta=res;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Respuesta r=(Respuesta)o;
        return this.respuesta.equals(r.getRespuesta());
    }
    
    @Override
    public String toString()
    {
        return respuesta;
    }

    public void setRespuesta(String respuesta)
    {
        this.respuesta = respuesta;
    }

    public String getRespuesta()
    {
        return respuesta;
    }
}

package modelo;

public class NuevoHumanoException extends Exception
{
    /**
     * Exception para cuando se intenta crear otra instacia del humano.<br>
     */
    private String mensaje="Ya ha ingresado un usuario";
    
    public NuevoHumanoException()
    {
        super();
    }
    
    public String getMensaje()
    {
        return mensaje;
    }
}

package modelo;

public class RepiteNombreException extends Exception
{
    /**
     * Exception para cuando se ingresa un nombre que ya se encuentra guardado.<br>
     */
    private String mensaje;
    
    public RepiteNombreException(String nombre)
    {
        super();
        this.mensaje="Nombre repetido: "+ nombre;
    }

    public RepiteNombreException()
    {
        super();
    }

    public String getMensaje()
    {
        return mensaje;
    }
}

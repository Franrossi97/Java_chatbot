package modelo;

public class NombreNullException extends Exception
{
    /**
     * Exception para cuando se ingresa un nombre con valor null.<br>
     */
    private String mensaje="Nombre inválido";
    public NombreNullException(String string)
    {
        super(string);
    }

    public NombreNullException()
    {
        super();
    }

    public String getMensaje()
    {
        return mensaje;
    }
}

package modelo;

import Vista.VentanaException;

public class SeleccionNullException extends Exception
{
    /**
     * Exception para cuando no se selecciona ningun robot.<br>
     */
    private String mensaje="Advertencia: No se ha seleccionado ning�n robot";
    
    public SeleccionNullException()
    {
        super();
    }

    public String getMensaje()
    {
        return mensaje;
    }
}

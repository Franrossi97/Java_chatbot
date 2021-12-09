package modelo;
/**
 * La excepcion que se encarga de tratar el intento de abrir dos chats iguales.<br>
 */
public class ChatExistenteException extends Exception
{
    private String mensaje="Ya se ha abierto el chat";
    
    public ChatExistenteException(String string)
    {
        super(string);
    }

    public ChatExistenteException()
    {
        super();
    }
    
    public String getMensaje()
    {
        return mensaje;
    }
}

package modelo;

public class Fuego extends Signo
{
    public Fuego(String nombre)
    {
        super(nombre);
    }
    
    public Fuego()
    {
        super();
    }
    
    public String compatible(Participante p)
    {
        Signo s=(Signo)p;
        return s.esFuego();
    }
    
    public String esTierra()
    {
        return "Mas adelante";
    }
    
    public String esFuego()
    {
        return "Si";
    }
    
    public String esAgua()
    {
        return "No";
    }
    
    public String esAire()
    {
        return "Yo te llamo";
    }
}

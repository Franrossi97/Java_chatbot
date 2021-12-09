package modelo;

public class Tierra extends Signo
{
    public Tierra(String nombre)
    {
        super(nombre);
    }
    
    public Tierra()
    {
        super();
    }
    
    public String compatible(Participante p)
    {
        Signo s=(Signo)p;
        return s.esTierra();
    }
    
    public String esTierra()
    {
        return "Si";
    }
    
    public String esFuego()
    {
        return "Yo te llamo";
    }
    
    public String esAgua()
    {
        return "Mas adelante";
    }
    
    public String esAire()
    {
        return "Si";
    }
}

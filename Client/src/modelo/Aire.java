package modelo;

public class Aire extends Signo
{
    public Aire(String nombre)
    {
        super(nombre);
    }
    
    public Aire()
    {
        super();
    }
    
    public String compatible(Participante p)
    {
        Signo s=(Signo)p;
        return s.esAire();
    }
    
    public String esTierra()
    {
        return "Yo te llamo";
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

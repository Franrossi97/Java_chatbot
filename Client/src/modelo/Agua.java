package modelo;

public class Agua extends Signo
{
    public Agua(String nombre)
    {
        super(nombre);
    }
    
    public Agua()
    {
        super();
    }
    
    public String compatible(Participante p)
    {
        Signo s=(Signo)p;
        return s.esAgua();
    }
    
    public String esTierra()
    {
        return "No";
    }
    
    public String esFuego()
    {
        return "No";
    }
    
    public String esAgua()
    {
        return "Si";
    }
    
    public String esAire()
    {
        return "Mas adelante";
    }
}

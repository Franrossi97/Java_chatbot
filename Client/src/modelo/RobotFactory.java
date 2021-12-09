package modelo;

public class RobotFactory
{
    private static final int TIERRA=0;
    private static final int FUEGO=1;
    private static final int AGUA=2;
    private static final int AIRE=3;
    
    public static Robot getInstancia(int signo,String nombre)
    {
        Participante p=null;
        switch(signo)
        {
            case TIERRA: p=new Tierra(nombre);
            break;
            case FUEGO: p=new Fuego(nombre);
            break;
            case AGUA: p=new Agua(nombre);
            break;
            case AIRE: p=new Aire(nombre);
            break;
        }
        Robot r = new Robot(p);
        return r;
    }
}

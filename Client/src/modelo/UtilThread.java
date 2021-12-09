package modelo;

import java.util.Random;

public class UtilThread
{
    private static Random r = new Random();
    
    public static void espera()
    {
        try
        {
            Thread.sleep(7000 + r.nextInt(12000));
        } catch (InterruptedException e)
        {
        }
    }
}

package Controlador;

import Vista.IVista;
import Vista.VentanaNuevo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorNuevo implements ActionListener
{
    public static final String ACEPTAR="ACEPTAR";
    private IVista vista; //= (IVista) new VentanaNuevo();
    public static String NOMBRE=null;
    
    private static ControladorNuevo instancia=null;
    
    private ControladorNuevo()
    {
        super();
    }
    
    public static ControladorNuevo getInstancia()
    {
        if (instancia==null)
            instancia=new ControladorNuevo();
        return instancia;
    }
 
    public void setVentana(IVista vista)
    {
        this.vista=vista;
        this.vista.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (actionEvent.getActionCommand().equals(ControladorNuevo.ACEPTAR))
        {
            /* VentanaNuevo v=(VentanaNuevo) vista;
            this.NOMBRE=v.getNombre();
            v.dispose(); */
        }
    }
}

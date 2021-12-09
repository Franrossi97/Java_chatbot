package Vista;

import Controlador.ControladorChat;

import java.awt.GridLayout;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import modelo.Chat;
import modelo.ContenedorChat;

public class VentanaChat extends JFrame implements Observer
{    
    private static VentanaChat ventana=null;
    private int cont=0;
    JTabbedPane pesta�as= new JTabbedPane();
    JTextArea historial;
    Observable ContenedorChats;
    
    private VentanaChat()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(false);
        this.setSize(1300,700);
        this.setLayout(new GridLayout(1,2));
        this.setTitle("Conversaciones");
        historial=new JTextArea();
        JScrollPane scroll=new JScrollPane(historial);
        historial.setEditable(false);
        historial.setAutoscrolls(true);
        //this.add(historial);
        this.add(scroll);
        this.add(pesta�as);
        this.ContenedorChats=ContenedorChat.getInstance();
        ContenedorChats.addObserver(this);
        //this.add(new VentanaChat());
        //this.getContentPane().add(new PanelChat());
    }
    
    public static VentanaChat getInstance()
    {
        if(ventana==null)
            ventana=new VentanaChat();
        return ventana;
    }
    
    public void addChat(String titulo,PanelChat p)
    {
        pesta�as.addTab(titulo, p);
        pesta�as.setVisible(true);
        this.getContentPane().add(pesta�as);
        this.cont++;
        //ControladorChat.getInstance().arrancaThread();
        this.setVisible(true);
    }
    
    public void remChat(PanelChat p)
    {
        p.setVisible(false);
        //this.getContentPane().remove(p);
        pesta�as.remove(p);
        this.cont--;
        if (cont==0)
            this.setVisible(false);
    }
    
    public void a�adirObservable(Observable contenedor)
    {
        this.ContenedorChats=contenedor;
        contenedor.addObserver(this);
    }
    
    public void cerrar()
    {
        pesta�as.removeAll();
        this.dispose();
    }
    
    public void update(Observable obs,Object o)
    {
        String cartel=(String)o;
        if (this.ContenedorChats==obs)
            this.historial.append(cartel+"\n");
        else
            throw new IllegalArgumentException();
    }
}

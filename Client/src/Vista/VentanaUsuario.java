
package Vista;

import Controlador.ControladorUsuario;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

import modelo.Humano;

/**
 *
 * @author usuario
 */
public class VentanaUsuario extends javax.swing.JFrame implements IVista
{
    private DefaultListModel modeloLista = new DefaultListModel();
    
    /** Creates new form VentanaUsuario */
    public VentanaUsuario()
    {
        super("MSN");
        initComponents();
        this.setSize(1300,700);
        /* this.panelUsuario.setMaximumSize(new Dimension(1024,300));
        this.panelUsuario.setPreferredSize(new Dimension(1024,300));
        this.panelUsuario.setMinimumSize(new Dimension(1024,300)); */
        this.setVisible(true);
        this.botonAbrirChat.setActionCommand(ControladorUsuario.ABRIR);
        this.botonEliminar.setActionCommand(ControladorUsuario.ELIMINAR);
        this.botonNuevoContacto.setActionCommand(ControladorUsuario.NUEVO);
        this.BotonIngresar.setActionCommand(ControladorUsuario.INGRESAR);
        this.BotonCerrarSesion.setActionCommand(ControladorUsuario.CERRARSESION);
        
        /*this.jScrollPane1.setPreferredSize(new Dimension(200,100));
        this.jScrollPane1.setMaximumSize(new Dimension(200,100));
        this.jScrollPane1.setMinimumSize(new Dimension(200,100));*/
        this.ListaRobots.setModel(modeloLista);
        this.Nombre.setEditable(false);
    }
    
    public void iniciar()
    {
        this.BotonIngresar.doClick();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()//GEN-BEGIN:initComponents
    {

        panelUsuario = new javax.swing.JPanel();
        Nombre = new javax.swing.JTextArea();
        BotonIngresar = new javax.swing.JButton();
        BotonCerrarSesion = new javax.swing.JButton();
        panelImagen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TextFieldMensajePersonal = new javax.swing.JTextField();
        panelContactos = new javax.swing.JPanel();
        labelContactos = new javax.swing.JLabel();
        PanelBotonesInferiores = new javax.swing.JPanel();
        botonAbrirChat = new javax.swing.JButton();
        botonNuevoContacto = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaRobots = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelUsuario.setBackground(new java.awt.Color(153, 204, 255));

        Nombre.setColumns(20);
        Nombre.setRows(5);

        BotonIngresar.setBackground(new java.awt.Color(204, 255, 255));
        BotonIngresar.setText("Ingresar");
        BotonIngresar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BotonIngresarActionPerformed(evt);
            }
        });

        BotonCerrarSesion.setBackground(new java.awt.Color(204, 255, 255));
        BotonCerrarSesion.setText("Cerrar sesion");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/perro.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TextFieldMensajePersonal.setText("<Escribe un mensaje personal>");

        javax.swing.GroupLayout panelUsuarioLayout = new javax.swing.GroupLayout(panelUsuario);
        panelUsuario.setLayout(panelUsuarioLayout);
        panelUsuarioLayout.setHorizontalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldMensajePersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(BotonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BotonCerrarSesion)
                .addGap(56, 56, 56))
        );
        panelUsuarioLayout.setVerticalGroup(
            panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuarioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelUsuarioLayout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BotonCerrarSesion)
                                .addComponent(BotonIngresar))
                            .addComponent(TextFieldMensajePersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );

        panelContactos.setBackground(new java.awt.Color(204, 255, 255));

        labelContactos.setText("Lista de Contactos");

        PanelBotonesInferiores.setBackground(new java.awt.Color(204, 255, 255));
        PanelBotonesInferiores.setLayout(new java.awt.GridLayout(1, 0));

        botonAbrirChat.setText("Abrir Chat");
        PanelBotonesInferiores.add(botonAbrirChat);

        botonNuevoContacto.setText("Nuevo Contacto");
        PanelBotonesInferiores.add(botonNuevoContacto);

        botonEliminar.setText("Eliminar");
        PanelBotonesInferiores.add(botonEliminar);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 1300));
        jScrollPane1.setWheelScrollingEnabled(false);

        ListaRobots.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaRobots.setMaximumSize(new java.awt.Dimension(50, 200));
        ListaRobots.setMinimumSize(new java.awt.Dimension(50, 200));
        ListaRobots.setPreferredSize(new java.awt.Dimension(50, 200));
        jScrollPane1.setViewportView(ListaRobots);

        jPanel1.add(jScrollPane1);

        javax.swing.GroupLayout panelContactosLayout = new javax.swing.GroupLayout(panelContactos);
        panelContactos.setLayout(panelContactosLayout);
        panelContactosLayout.setHorizontalGroup(
            panelContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
            .addGroup(panelContactosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelBotonesInferiores, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGroup(panelContactosLayout.createSequentialGroup()
                        .addComponent(labelContactos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelContactosLayout.setVerticalGroup(
            panelContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactosLayout.createSequentialGroup()
                .addComponent(labelContactos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelBotonesInferiores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContactos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContactos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void BotonIngresarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BotonIngresarActionPerformed
    {//GEN-HEADEREND:event_BotonIngresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaUsuario.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaUsuario.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaUsuario.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaUsuario.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable()
            {
                public void run()
                {
                    new VentanaUsuario().setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCerrarSesion;
    private javax.swing.JButton BotonIngresar;
    private javax.swing.JList<String> ListaRobots;
    private javax.swing.JTextArea Nombre;
    private javax.swing.JPanel PanelBotonesInferiores;
    private javax.swing.JTextField TextFieldMensajePersonal;
    private javax.swing.JButton botonAbrirChat;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonNuevoContacto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelContactos;
    private javax.swing.JPanel panelContactos;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JPanel panelUsuario;
    // End of variables declaration//GEN-END:variables

    public void setNombre(String nombre)
    {
        this.Nombre.append(nombre);
    }
    public void actualizarLista()
    {
        this.modeloLista.clear();
        Iterator<String> it=Humano.getInstancia().getListaNombres();
        while(it.hasNext())
            this.modeloLista.addElement(it.next());
    }
    
    @Override
    public void addActionListener(ActionListener a)
    {
        this.botonAbrirChat.addActionListener(a);
        this.botonEliminar.addActionListener(a);
        this.botonNuevoContacto.addActionListener(a);
        this.BotonIngresar.addActionListener(a);
        this.BotonCerrarSesion.addActionListener(a);
    }
    
    public void agregarRobot(String nombre)
    {
        /* VentanaNuevo nuevo = new VentanaNuevo(this,true);
        String nombre = nuevo.getName(); */
        //this.ListaRobots.add(nombre);
        this.ListaRobots.add(new JTextArea(nombre));
        this.actualizarLista();
    }
    
    public void elimiarRobot(String nombre)
    {
        this.ListaRobots.remove(new JTextArea(nombre));
        this.actualizarLista();
    }
    
    public List<String> getSeleccion()
    {
        return this.ListaRobots.getSelectedValuesList();
    }

    /* public JList<String> getListaRobots()
    {
        return ListaRobots;
    } */
    
    public void cerrar()
    {
        this.dispose();
        System.exit(0);
    }
}

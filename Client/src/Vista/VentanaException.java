
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author fran
 */
public class VentanaException extends javax.swing.JDialog
{
    /** Creates new form VentanaElimanarNullException */
    public VentanaException()
    {
        super();
        this.setTitle("Error");
        initComponents();
        this.setModal(true);
        this.MensajeMuestra.setEditable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()//GEN-BEGIN:initComponents
    {

        jPanel1 = new javax.swing.JPanel();
        Aceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MensajeMuestra = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AceptarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setMaximumSize(new java.awt.Dimension(100, 60));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/danger.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 60));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 60));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 60));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        MensajeMuestra.setColumns(20);
        MensajeMuestra.setRows(5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(Aceptar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(MensajeMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MensajeMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Aceptar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AceptarActionPerformed
    {//GEN-HEADEREND:event_AceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

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
                .getLogger(VentanaException.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaException.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaException.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VentanaException.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt
            .EventQueue
            .invokeLater(new Runnable()
            {
                public void run()
                {
                    VentanaException dialog =
                        new VentanaException();
                    dialog.addWindowListener(new java.awt.event.WindowAdapter()
                    {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e)
                        {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextArea MensajeMuestra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    
    public void imprime(String mensaje)
    {
        this.MensajeMuestra.append(mensaje);
        this.setVisible(true);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Frames.sinCuenta.sinCuentaFrame;

/**
 *
 * @author lv1821
 */
public class MenuFrame extends javax.swing.JFrame {
    int num;
    String contra;
    /**
     * Creates new form IniciarFrame
     */
    public MenuFrame(int numCuenta, String contraseña) {
        this.contra = contraseña;
        this.num = numCuenta;
        initComponents();
    }

    public MenuFrame(int numCuenta) {
        this.num = numCuenta;
        initComponents();
    }
    
    public MenuFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        sinCuentaItem = new javax.swing.JMenuItem();
        transferirItem = new javax.swing.JMenuItem();
        depositoItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        tusDatosItem = new javax.swing.JMenuItem();
        cancelarCuentaItem = new javax.swing.JMenuItem();
        crearCuentaItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        historialItem = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        salirItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 80)); // NOI18N
        jLabel1.setText("VVBA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(226, 226, 226))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Transacciones");

        sinCuentaItem.setText("Sin cuenta");
        sinCuentaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinCuentaItemActionPerformed(evt);
            }
        });
        jMenu1.add(sinCuentaItem);

        transferirItem.setText("Transferir");
        transferirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferirItemActionPerformed(evt);
            }
        });
        jMenu1.add(transferirItem);

        depositoItem.setText("Deposito");
        depositoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositoItemActionPerformed(evt);
            }
        });
        jMenu1.add(depositoItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Perfil");

        tusDatosItem.setText("Tus datos");
        tusDatosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tusDatosItemActionPerformed(evt);
            }
        });
        jMenu2.add(tusDatosItem);

        cancelarCuentaItem.setText("Cancelar cuenta");
        cancelarCuentaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCuentaItemActionPerformed(evt);
            }
        });
        jMenu2.add(cancelarCuentaItem);

        crearCuentaItem.setText("Crear cuenta");
        crearCuentaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearCuentaItemActionPerformed(evt);
            }
        });
        jMenu2.add(crearCuentaItem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Consultas");

        historialItem.setText("Historial");
        historialItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialItemActionPerformed(evt);
            }
        });
        jMenu3.add(historialItem);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Salir");

        salirItem.setText("Salir");
        salirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirItemActionPerformed(evt);
            }
        });
        jMenu5.add(salirItem);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sinCuentaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinCuentaItemActionPerformed
        sinCuentaFrame i = new sinCuentaFrame();
        i.show();
    }//GEN-LAST:event_sinCuentaItemActionPerformed

    private void transferirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferirItemActionPerformed
        TransferirFrame i = new TransferirFrame(num);
        i.show();
    }//GEN-LAST:event_transferirItemActionPerformed

    private void depositoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositoItemActionPerformed
        DepositoFrame i = new DepositoFrame(num);
        i.show();
    }//GEN-LAST:event_depositoItemActionPerformed

    private void tusDatosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tusDatosItemActionPerformed
        TusDatosFrame i = new TusDatosFrame(num);
        i.show();
    }//GEN-LAST:event_tusDatosItemActionPerformed

    private void cancelarCuentaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCuentaItemActionPerformed
        CancelarCuentaFrame i = new CancelarCuentaFrame(num, contra);
        i.show();
    }//GEN-LAST:event_cancelarCuentaItemActionPerformed

    private void crearCuentaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearCuentaItemActionPerformed
        CrearCuentaFrame i = new CrearCuentaFrame();
        i.show();
    }//GEN-LAST:event_crearCuentaItemActionPerformed

    private void historialItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialItemActionPerformed
        HistorialFrame i = new HistorialFrame();
        i.show();
    }//GEN-LAST:event_historialItemActionPerformed

    private void salirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirItemActionPerformed
        IniciarFrame i = new IniciarFrame();
        i.show();
        dispose();
    }//GEN-LAST:event_salirItemActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cancelarCuentaItem;
    private javax.swing.JMenuItem crearCuentaItem;
    private javax.swing.JMenuItem depositoItem;
    private javax.swing.JMenuItem historialItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem salirItem;
    private javax.swing.JMenuItem sinCuentaItem;
    private javax.swing.JMenuItem transferirItem;
    private javax.swing.JMenuItem tusDatosItem;
    // End of variables declaration//GEN-END:variables
}

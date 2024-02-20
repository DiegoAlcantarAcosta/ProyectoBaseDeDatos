/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Controlador.Controlador;
import Encriptador.Encriptador;
import Frames.registrarseFrames.RegistrarFrame;
import Frames.sinCuenta.RetirarFrame;
import javax.swing.JOptionPane;

/**
 * Ventana para hacer un deposito
 * Permite ingresar usuario y contraseña para el inicio de sesion
 * @author lv1821
 */
public class IniciarFrame extends javax.swing.JFrame {
    Encriptador e = new Encriptador();
    Controlador c = new Controlador();
    /**
     * Creates new form IniciarFrame
     */
    public IniciarFrame() {
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
        jLabel2 = new javax.swing.JLabel();
        contraseñaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        usuarioTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        registrarseButton = new javax.swing.JButton();
        cobrarSinTarjetaButton1 = new javax.swing.JButton();
        iniciarSesionButton1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 48)); // NOI18N
        jLabel1.setText("VVBA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Iniciar Sesion:");

        contraseñaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Contraseña:");

        usuarioTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Usuario:");

        registrarseButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registrarseButton.setText("Registrarse");
        registrarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseButtonActionPerformed(evt);
            }
        });

        cobrarSinTarjetaButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cobrarSinTarjetaButton1.setText("Cobrar sin tarjeta");
        cobrarSinTarjetaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrarSinTarjetaButton1ActionPerformed(evt);
            }
        });

        iniciarSesionButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        iniciarSesionButton1.setText("Iniciar sesion");
        iniciarSesionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesionButton1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cobrarSinTarjetaButton1)
                        .addGap(18, 18, 18)
                        .addComponent(registrarseButton)
                        .addGap(28, 28, 28)
                        .addComponent(iniciarSesionButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(contraseñaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(jLabel4)
                    .addContainerGap(414, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(usuarioTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cobrarSinTarjetaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciarSesionButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addComponent(jLabel4)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraseñaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaTextFieldActionPerformed

    private void usuarioTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTextField1ActionPerformed

    /**
     * Boton para registrar un cliente
     * @param evt  evento
     */
    private void registrarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseButtonActionPerformed
        RegistrarFrame i = new RegistrarFrame();
        i.show();
        dispose();
    }//GEN-LAST:event_registrarseButtonActionPerformed

    /**
     * Boton para hacer un cobro sin tarjeta
     * @param evt  evento
     */
    private void cobrarSinTarjetaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrarSinTarjetaButton1ActionPerformed
        RetirarFrame i = new RetirarFrame();
        i.show();
       
    }//GEN-LAST:event_cobrarSinTarjetaButton1ActionPerformed

    /**
     * Boton para iniciar sesion
     * @param evt  evento
     */
    private void iniciarSesionButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesionButton1ActionPerformed
        if (! (usuarioTextField1.getText().equalsIgnoreCase("") || contraseñaTextField.getText().equalsIgnoreCase(""))) {
        int idUsuario = c.idUsuario(e.encriptador(contraseñaTextField.getText()), usuarioTextField1.getText());
        if (c.autenticarUsuario(usuarioTextField1.getText(), e.encriptador(contraseñaTextField.getText()))){
            SeleccionarCuentaFrame i = new SeleccionarCuentaFrame(idUsuario, contraseñaTextField.getText());
            i.show();
            JOptionPane.showMessageDialog(this, "BIENVENDIO!!");
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
        }else{
            JOptionPane.showMessageDialog(this, "Algun campo esta vacio");
        }
    }//GEN-LAST:event_iniciarSesionButton1ActionPerformed

    /**
     * Boton para salir a la ventana anterior
     * @param evt  evento
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cobrarSinTarjetaButton1;
    private javax.swing.JTextField contraseñaTextField;
    private javax.swing.JButton iniciarSesionButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton registrarseButton;
    private javax.swing.JTextField usuarioTextField1;
    // End of variables declaration//GEN-END:variables
}

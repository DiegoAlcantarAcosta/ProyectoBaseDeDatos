/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames.registrarseFrames;

import Controlador.Controlador;
import Controlador.IControlador;
import DTO.ClienteDTO;
import DTO.CuentaDTO;
import DTO.DireccionDTO;
import DTO.UsuariosDTO;
import Encriptador.Encriptador;
import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Direccion;
import Entidades.Usuario;
import Excepciones.PersistenciaExcepcion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lv1821
 */
public class RegistrarFrame extends javax.swing.JFrame {
    Encriptador e = new Encriptador();

    IControlador c = new Controlador();

    /**
     * Creates new form IniciarFrame
     */
    public RegistrarFrame() {
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
        jLabel4 = new javax.swing.JLabel();
        usuarioTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        contraseñaTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        apellidoPaternoTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fechaNacimientoDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        apellidoMaternoTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        calleTextField = new javax.swing.JTextField();
        coloniaTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        numeroTextField = new javax.swing.JTextField();
        codigoPostalTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        registrarseButton = new javax.swing.JButton();

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
                .addGap(219, 219, 219))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Registrarse");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Nombre:");

        usuarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Usuario:");

        contraseñaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Calle:");

        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Apellido Paterno:");

        apellidoPaternoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoPaternoTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Apellido Materno:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento:");

        apellidoMaternoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoMaternoTextFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Contraseña:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Direccion");

        calleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calleTextFieldActionPerformed(evt);
            }
        });

        coloniaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coloniaTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Colonia:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setText("Numero:");

        numeroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroTextFieldActionPerformed(evt);
            }
        });

        codigoPostalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoPostalTextFieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setText("Codigo Postal:");

        registrarseButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        registrarseButton.setText("Registrarse");
        registrarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(202, 202, 202))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(apellidoPaternoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(contraseñaTextField)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                            .addComponent(usuarioTextField)
                            .addComponent(fechaNacimientoDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apellidoMaternoTextField)
                            .addComponent(coloniaTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numeroTextField)
                            .addComponent(codigoPostalTextField)
                            .addComponent(calleTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(registrarseButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoPaternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoMaternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaNacimientoDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coloniaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoPostalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTextFieldActionPerformed

    private void contraseñaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaTextFieldActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void apellidoPaternoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoPaternoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoPaternoTextFieldActionPerformed

    private void apellidoMaternoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoMaternoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoMaternoTextFieldActionPerformed

    private void calleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calleTextFieldActionPerformed

    private void coloniaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coloniaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coloniaTextFieldActionPerformed

    private void numeroTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroTextFieldActionPerformed

    private void codigoPostalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoPostalTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoPostalTextFieldActionPerformed

    private void registrarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseButtonActionPerformed
        GregorianCalendar calendario = new GregorianCalendar();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formatoFecha.format(calendario.getTime());

        Usuario usuario = new Usuario(usuarioTextField.getText(), e.encriptador(contraseñaTextField.getText()));
        Direccion direccion = new Direccion(calleTextField.getText(), coloniaTextField.getText(), numeroTextField.getText(), codigoPostalTextField.getText());
        Cliente cliente = new Cliente(nombreTextField.getText(), apellidoPaternoTextField.getText(), apellidoMaternoTextField.getText(), formatoFecha.format(fechaNacimientoDateChooser.getDate()));

        try {
            c.registrarCliente(cliente);
            c.registrarDireccion(direccion);
            c.registrarUsuario(usuario);
            Cuenta cuenta = new Cuenta(0, fechaFormateada, c.idCliente(nombreTextField.getText(), apellidoPaternoTextField.getText()));
            c.crearCuenta(cuenta);
            int idCliente = c.idCliente(nombreTextField.getText(), apellidoPaternoTextField.getText());
            registradoFrame registrado = new registradoFrame(idCliente, contraseñaTextField.getText());
            registrado.show();
            dispose();
        } catch (PersistenciaExcepcion ex) {
            Logger.getLogger(RegistrarFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_registrarseButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoMaternoTextField;
    private javax.swing.JTextField apellidoPaternoTextField;
    private javax.swing.JTextField calleTextField;
    private javax.swing.JTextField codigoPostalTextField;
    private javax.swing.JTextField coloniaTextField;
    private javax.swing.JTextField contraseñaTextField;
    private com.toedter.calendar.JDateChooser fechaNacimientoDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField numeroTextField;
    private javax.swing.JButton registrarseButton;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables
}

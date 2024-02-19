/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames.sinCuenta;

import Controlador.Controlador;
import DTO.RetiroSinDTO;
import Entidades.Operaciones;
import Frames.MenuFrame;
import Validadores.NumberDocumentFilter;
import Validadores.NumberInputVerifier;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Diego
 */
public class sinCuentaFrame extends javax.swing.JFrame {

    Controlador c = new Controlador();
    /**
     * Creates new form registradoFrame
     *
     */
    int idCuenta;

    public sinCuentaFrame(int num) {
        this.idCuenta = num;
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
        jLabel4 = new javax.swing.JLabel();
        montoTextField = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        aceptarButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 48)); // NOI18N
        jLabel1.setText("VVBA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Monto:");

        aceptarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        aceptarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        aceptarButton1.setText("Salir");
        aceptarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(aceptarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aceptarButton)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel4)
                .addContainerGap(246, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(montoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(montoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        montoTextField.setInputVerifier(new NumberInputVerifier());
       ((AbstractDocument) montoTextField.getDocument()).setDocumentFilter(new NumberDocumentFilter());
        if (!(montoTextField.getText().equalsIgnoreCase(""))) {
        int contra = 0;
        contra = c.generarContraseña();
        LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraString = fechaHora.format(formatter);
        Operaciones operacion = new Operaciones(c.idCuenta(idCuenta), "RETIRO SIN CUENTA", fechaHoraString, Float.parseFloat(montoTextField.getText()) );
        RetiroSinDTO retiro = new RetiroSinDTO(c.idCuenta(idCuenta), 1000, contra, "Procesando", fechaHoraString, Float.parseFloat(montoTextField.getText()), "RETIRO SIN CUENTA");
        c.agregarOperacion(operacion);
        c.generarSinCuenta(retiro,c.idOperacion(fechaHoraString));
        infoSinCuentaFrame info = new infoSinCuentaFrame(c.obtenerFolio(),contra);
        info.show();
        JOptionPane.showMessageDialog(this, "Solicitud aceptada");
        dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Algun registro esta vacio");
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void aceptarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_aceptarButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton aceptarButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField montoTextField;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames.sinCuenta;

import Controlador.Controlador;
import Controlador.IControlador;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author lv1821
 */
public class RetirarFrame extends javax.swing.JFrame {

    IControlador c = new Controlador();

    /**
     * Creates new form IniciarFrame
     */
    public RetirarFrame() {
        initComponents();
        ((AbstractDocument) contraseñaPasswordField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Sonido de advertencia
                }
            }

            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
                if (newText.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Sonido de advertencia
                }
            }
        });
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
        cobrarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        folioTextField1 = new javax.swing.JTextField();
        contraseñaPasswordField = new javax.swing.JPasswordField();
        cobrarButton1 = new javax.swing.JButton();

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
                .addGap(215, 215, 215))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cobrarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cobrarButton.setText("Cobrar");
        cobrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrarButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Cobrar sin tarjeta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Contraseña:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Folio:");

        folioTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folioTextField1ActionPerformed(evt);
            }
        });

        contraseñaPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaPasswordFieldActionPerformed(evt);
            }
        });

        cobrarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cobrarButton1.setText("Salir");
        cobrarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrarButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(folioTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contraseñaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(cobrarButton1)
                .addGap(79, 79, 79)
                .addComponent(cobrarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(jLabel5)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(folioTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contraseñaPasswordField))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cobrarButton)
                    .addComponent(cobrarButton1))
                .addGap(34, 34, 34))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(jLabel5)
                    .addContainerGap(173, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void folioTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folioTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folioTextField1ActionPerformed

    private void contraseñaPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaPasswordFieldActionPerformed

    private void cobrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrarButtonActionPerformed
        try {
            if (!(folioTextField1.getText().equalsIgnoreCase("") || contraseñaPasswordField.getText().equalsIgnoreCase(""))) {

                if (c.autenticarCobro(Integer.parseInt(folioTextField1.getText()), Integer.parseInt(contraseñaPasswordField.getText()))) {
                    c.actualizarEstado(c.idRetiro(Integer.parseInt(folioTextField1.getText()), Integer.parseInt(contraseñaPasswordField.getText())));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No coincide con ningun retiro");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Algun registro esta vacio");
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("El monto del depósito debe ser mínimo $1 y máximo $10,000.")) {
                JOptionPane.showMessageDialog(null, "El monto del depósito debe ser mínimo $1 y máximo $10,000.", "Error de depósito", JOptionPane.ERROR_MESSAGE);
            } else if (e.getMessage().contains("Los depósitos mayores a $1 deben ser de $100 en $100.")) {
                JOptionPane.showMessageDialog(null, "Los depósitos mayores a $1 deben ser de $100 en $100.", "Error de depósito", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la transferencia o el depósito.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_cobrarButtonActionPerformed

    private void cobrarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrarButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_cobrarButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cobrarButton;
    private javax.swing.JButton cobrarButton1;
    private javax.swing.JPasswordField contraseñaPasswordField;
    private javax.swing.JTextField folioTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

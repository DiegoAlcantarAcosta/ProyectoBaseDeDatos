/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Controlador.Controlador;
import Controlador.IControlador;
import DTO.TransferenciaDTO;
import Validadores.NumberDocumentFilter;
import Validadores.NumberInputVerifier;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Ventana para hacer acceder a los dos tipos de consultas Permite ingresar
 * numero de cuenta y monto para hacer la transferencia
 *
 * @author lv1821
 */
public class TransferirFrame extends javax.swing.JFrame {

    IControlador c = new Controlador();
    GregorianCalendar g = new GregorianCalendar();
    int idCliente;

    /**
     * Creates new form IniciarFrame
     */
    public TransferirFrame(int numCuenta) {
        this.idCliente = numCuenta;
        initComponents();
        ((AbstractDocument) montoTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
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
        ((AbstractDocument) numCuentaTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
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
        jLabel2 = new javax.swing.JLabel();
        montoTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numCuentaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        salirButton = new javax.swing.JButton();
        transferirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

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
        jLabel2.setText("Transferir");

        montoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Monto:");

        numCuentaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numCuentaTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Numero de cuenta:");

        salirButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        transferirButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        transferirButton.setText("Transferir");
        transferirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(montoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numCuentaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(215, 215, 215))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(salirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transferirButton)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCuentaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transferirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void montoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTextFieldActionPerformed

    private void numCuentaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numCuentaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numCuentaTextFieldActionPerformed

    /**
     * Boton para salir a la ventana anterior
     *
     * @param evt evento
     */
    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    /**
     * Boton para transferir a una cuenta
     *
     * @param evt evento
     */
    private void transferirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferirButtonActionPerformed

        try {
            montoTextField.setInputVerifier(new NumberInputVerifier());

            ((AbstractDocument) montoTextField.getDocument()).setDocumentFilter(new NumberDocumentFilter());
            if (!(numCuentaTextField.getText().equalsIgnoreCase("") || montoTextField.getText().equalsIgnoreCase(""))) {
                float numeroFloat = Float.parseFloat(montoTextField.getText());
                int numeroInt = Integer.parseInt(numCuentaTextField.getText());
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String fechaPerrona = formatoFecha.format(g.getTime());

                TransferenciaDTO t = new TransferenciaDTO(c.idCuenta(idCliente), c.idCuenta(numeroInt), "TRANSFERENCIA", fechaPerrona, numeroFloat);
                c.realizarTransferencia(t);

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
        dispose();
    }//GEN-LAST:event_transferirButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField montoTextField;
    private javax.swing.JTextField numCuentaTextField;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton transferirButton;
    // End of variables declaration//GEN-END:variables
}

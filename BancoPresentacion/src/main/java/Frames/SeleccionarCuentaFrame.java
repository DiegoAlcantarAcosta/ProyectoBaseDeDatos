/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Controlador.Controlador;
import Controlador.IControlador;
import Entidades.Cuenta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Ventana para hacer seleccionar una cuenta
 *
 * @author lv1821
 */
public class SeleccionarCuentaFrame extends javax.swing.JFrame {

    IControlador c = new Controlador();
    private static final Logger LOG = Logger.getLogger(SeleccionarCuentaFrame.class.getName());
    int idUsuario;
    String contra;

    /**
     * Creates new form IniciarFrame
     */
    public SeleccionarCuentaFrame(int id, String contraseña) {
        this.contra = contraseña;
        this.idUsuario = id;
        initComponents();
        añadirAlComboBox();
    }

    public SeleccionarCuentaFrame(int id) {
        this.idUsuario = id;
        initComponents();
        añadirAlComboBox();
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
        salirButton = new javax.swing.JButton();
        seleccionarButton = new javax.swing.JButton();
        cuentassComboBoxModel = new javax.swing.JComboBox<>();

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
        jLabel2.setText("Seleccionar cuenta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Cuenta:");

        salirButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        seleccionarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        seleccionarButton.setText("Seleccionar");
        seleccionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarButtonActionPerformed(evt);
            }
        });

        cuentassComboBoxModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentassComboBoxModelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seleccionarButton)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)
                        .addComponent(cuentassComboBoxModel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cuentassComboBoxModel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton para salir a la ventana anterior
     *
     * @param evt evento
     */
    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    /**
     * Metodo para rellenar los espacios en al tabla
     */
    public void añadirAlComboBox() {
        try {
            List<Cuenta> cuenta = c.obtenerCuentasCliente(idUsuario);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();

            for (int i = 0; i < cuenta.size(); i++) {
                modelo.addElement(cuenta.get(i).getNumCuenta());
            }

            cuentassComboBoxModel.setModel(modelo);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo mostrar el id");
        }
    }

    /**
     * Boton para seleccionar una cuenta
     * @param evt  evento
     */
    private void seleccionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarButtonActionPerformed
        int numCuenta = (int) cuentassComboBoxModel.getSelectedItem();
        if (numCuenta != 0) {
            MenuFrame menu = new MenuFrame(numCuenta, contra);
            menu.show();
            dispose();
        } else {
            JOptionPane o = new JOptionPane("No existe esa cuenta");
        }
    }//GEN-LAST:event_seleccionarButtonActionPerformed

    private void cuentassComboBoxModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentassComboBoxModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuentassComboBoxModelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cuentassComboBoxModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton seleccionarButton;
    // End of variables declaration//GEN-END:variables
}

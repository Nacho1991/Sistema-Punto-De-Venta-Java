/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.EmpleadoD;
import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author Ignacio
 */
public class frmCambiarContrasenna extends javax.swing.JDialog {

    private boolean crear;
    private EmpleadoD oEmpleadoD;
    private String errorMessage;
    private boolean error;
    private String cedula;
    private boolean aceptar;

    public frmCambiarContrasenna(java.awt.Frame parent, boolean modal, String pNombreUsuario, String pCedula, boolean pCrear, AccesoDatosMySql pCnx) {
        super(parent, modal);
        initComponents();
        aceptar = false;
        crear = pCrear;
        error = false;
        oEmpleadoD = new EmpleadoD(pCnx);
        errorMessage = "";
        txtNombreUsuario.setText(pNombreUsuario);
        cedula = pCedula;
        setLocationRelativeTo(null);
    }

    private boolean isPasswordCorrect(char[] pPasswordUno, char[] pPasswordDos) {
        boolean valor = true;
        int puntero = 0;
        if (pPasswordUno.length != pPasswordDos.length) {
            valor = false;
        } else {
            while ((valor) && (puntero < pPasswordUno.length)) {
                if (pPasswordUno[puntero] != pPasswordDos[puntero]) {
                    valor = false;
                }
                puntero++;
            }
        }
        return valor;
    }

    public String traducirContrasenna(char[] pass) {
        pass = txtContrasenna.getPassword();
        String contrasenna = "";
        for (int pos = 0; pos < pass.length; pos++) {
            contrasenna += pass[pos];
        }
        return contrasenna;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtContrasenna = new javax.swing.JPasswordField();
        txtVerificaContrasenna = new javax.swing.JPasswordField();
        lblContrasenna = new javax.swing.JLabel();
        lblVerificaContrasenna = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar contraseña");
        setMaximumSize(new java.awt.Dimension(614, 153));
        setMinimumSize(new java.awt.Dimension(614, 153));
        setResizable(false);

        lblNombreUsuario.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblNombreUsuario.setText("Nombre de usuario:");

        txtNombreUsuario.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtContrasenna.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtVerificaContrasenna.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        lblContrasenna.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblContrasenna.setText("Contraseña:");

        lblVerificaContrasenna.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblVerificaContrasenna.setText("Verificar contraseña:");

        btnAceptar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblContrasenna)
                    .addComponent(lblVerificaContrasenna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(txtContrasenna)
                    .addComponent(txtVerificaContrasenna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreUsuario)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContrasenna)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVerificaContrasenna)
                    .addComponent(txtVerificaContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        char[] passUno;
        passUno = txtContrasenna.getPassword();
        char[] passDos;
        passDos = txtVerificaContrasenna.getPassword();
        if (crear == true) {
            if (isPasswordCorrect(passUno, passDos)) {
                Empleado oEmpleado = new Empleado(
                        cedula, txtNombreUsuario.getText(), traducirContrasenna(passUno)
                );
                oEmpleadoD.registrarAccesoSistema(oEmpleado);
                if (oEmpleadoD.isError()) {
                    JOptionPane.showMessageDialog(null, "Error inesperado al intentar registrar los datos de acceso. Detalle técnico: " + oEmpleadoD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso registrados satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                }
            }
        } else {
            Empleado oEmpleado = new Empleado(
                    cedula, txtNombreUsuario.getText(), traducirContrasenna(passUno)
            );
            oEmpleadoD.actualizarAccesoSistema(oEmpleado);
            if (oEmpleadoD.isError()) {
                JOptionPane.showMessageDialog(null, "Error inesperado al intentar cambiar los datos de acceso. Detalle técnico: " + oEmpleadoD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Datos de acceso modificados satisfactoriamente.", "Error", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblContrasenna;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblVerificaContrasenna;
    private javax.swing.JPasswordField txtContrasenna;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtVerificaContrasenna;
    // End of variables declaration//GEN-END:variables
}

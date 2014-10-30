/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.EmpleadoD;
import accesoDatos.InventarioD;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.Empleado;
import org.edisoncor.gui.util.WindowDragger;
import org.edisoncor.gui.util.WindowsUtil;

/**
 *
 * @author ignacio
 */
public class frmLogin extends javax.swing.JFrame {

    AccesoDatosMySql cnx;
    static List<Empleado> login;
    private EmpleadoD oEmpleadoD;

    public frmLogin(AccesoDatosMySql pCnx) {
        cnx = pCnx;
        oEmpleadoD = new EmpleadoD(cnx);
        setUndecorated(true);
        initComponents();
        txtContrasenna.setHorizontalAlignment(JTextField.CENTER);
        txtNombreUsuario.setHorizontalAlignment(JTextField.CENTER);
        WindowsUtil.makeWindowsShape(this, pnlBackground.getShape());
        new WindowDragger(this, pnlBackground);

        tleBarraTitulo.addCloseAction(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        tleBarraTitulo = new org.edisoncor.gui.varios.TitleBar();
        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        panelShadow2 = new org.edisoncor.gui.panel.PanelShadow();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtContrasenna = new org.edisoncor.gui.passwordField.PasswordField();
        txtNombreUsuario = new org.edisoncor.gui.textField.TextField();
        btnIniciarSesion = new org.edisoncor.gui.button.ButtonSeven();
        btnSalir = new org.edisoncor.gui.button.ButtonSeven();
        chkMostrarCaracteres = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        panel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlBackground.setBackground(new java.awt.Color(204, 204, 255));
        pnlBackground.setBorderColor(new java.awt.Color(0, 0, 0));

        panelShadow1.setBackground(new java.awt.Color(153, 153, 255));

        panelCurves1.setBackground(new java.awt.Color(153, 153, 255));

        panelShadow2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Acceso");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Por favor ingrese el nombre de usuario y la contraseña");

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(21, 21, 21))
        );

        panelCurves1.add(panelShadow2, java.awt.BorderLayout.CENTER);

        txtContrasenna.setText("1");
        txtContrasenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasennaActionPerformed(evt);
            }
        });

        txtNombreUsuario.setText("Nacho");

        btnIniciarSesion.setBackground(new java.awt.Color(0, 153, 153));
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        btnIniciarSesion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnIniciarSesionKeyReleased(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 153, 153));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        chkMostrarCaracteres.setText("Mostrar caracteres");

        jLabel1.setText("Nombre de usuario:");

        jLabel2.setText("Contraseña:");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurves1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkMostrarCaracteres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMostrarCaracteres)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pnlBackground.add(panelShadow1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        String contrasenna = new String(txtContrasenna.getPassword());
        String nombreUsuario = txtNombreUsuario.getText();
        if (nombreUsuario.equals("") || contrasenna.equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor coriija para iniciar sesión.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            login = oEmpleadoD.iniciarSesion(nombreUsuario, contrasenna);
            if (oEmpleadoD.isError()) {
                JOptionPane.showMessageDialog(null, "Error inesperado al intentar iniciar sesión. Detalle técnico: " + oEmpleadoD.getErrorMsg(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else if (login.size() == 1) {
                frmPrincipal oPrincipal = new frmPrincipal(cnx, (ArrayList<Empleado>) login);
                this.setVisible(false);
                oPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no econtrado dentro de los registros.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarSesionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIniciarSesionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarSesionKeyReleased

    private void txtContrasennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasennaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasennaActionPerformed

    public List<Empleado> getLogin() {
        return login;
    }

    public void setLogin(List<Empleado> login) {
        login = login;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonSeven btnIniciarSesion;
    private org.edisoncor.gui.button.ButtonSeven btnSalir;
    private javax.swing.JCheckBox chkMostrarCaracteres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow2;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private org.edisoncor.gui.varios.TitleBar tleBarraTitulo;
    private org.edisoncor.gui.passwordField.PasswordField txtContrasenna;
    private org.edisoncor.gui.textField.TextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}

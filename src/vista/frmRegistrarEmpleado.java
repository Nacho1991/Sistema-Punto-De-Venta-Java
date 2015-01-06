/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Utilidades.Utilidades;
import TxtL.GestionTxt;
import accesoDatos.AccesoDatosMySql;
import accesoDatos.EmpleadoD;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author Ignacio
 */
public class frmRegistrarEmpleado extends javax.swing.JDialog {

    private String fechaNacimiento;
    private EmpleadoD oEmpleadoD;
    private Utilidades oEncriptacion;
    private String usuario;
    private String adminClientes;
    private String adminInventario;
    private String adminFacturas;
    private String adminEmpleados;
    private String adminCajas;

    public frmRegistrarEmpleado(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx, String pUsuario) {
        super(parent, modal);
        initComponents();
        fechaNacimiento = "";
        usuario = pUsuario;
        oEncriptacion = new Utilidades();
        oEmpleadoD = new EmpleadoD(pCnx);
        setLocationRelativeTo(null);
    }

    public void obtenerPrivilegios() {
        if (chkAdministrarCajas.isSelected()) {
            adminCajas = "true";
        } else {
            adminCajas = "false";
        }
        if (chkAdministrarClientes.isSelected()) {
            adminClientes = "true";
        } else {
            adminClientes = "false";
        }
        if (chkAdministrarEmpleados.isSelected()) {
            adminEmpleados = "true";
        } else {
            adminEmpleados = "false";
        }
        if (chkAdministrarInventarios.isSelected()) {
            adminInventario = "true";
        } else {
            adminInventario = "false";
        }
        if (chkAdministrarFacturas.isSelected()) {
            adminFacturas = "true";
        } else {
            adminFacturas = "false";
        }
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

    public boolean comprobarDatos() {
        boolean error = true;
        if (txtCedula.getText().equals("")
                || txtNombre.getText().equals("")
                || txtContrasenna.getPassword().equals("")
                || txtNombreUsuario.getText().equals("")
                || txtDireccion.getText().equals("")
                || txtEdad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor corrija para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Date date = dtpFechaNacimiento.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                fechaNacimiento = formato.format(date);
                error = false;
            } catch (Exception xp) {
                JOptionPane.showMessageDialog(null, "Error al intentar obtener la fecha, posible formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return error;
    }

    public boolean verificarCorreo() {
        boolean isCorrect = false;
        int longitud = txtCorreoElectronico.getText().length();
        char valor;

        for (char i = 0; i < longitud; i++) {
            valor = txtCorreoElectronico.getText().charAt(i);
            if (valor == '@') {
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    public int calculaEdad(String pFechaNacimiento) {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String hoy = formato.format(fechaActual);
        String[] dat1 = pFechaNacimiento.split("/");
        String[] dat2 = hoy.split("/");
        int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            anos = anos - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                anos = anos - 1;
            }
        }
        return anos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatosEmpleado = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox();
        lblDepartamento = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox();
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        dtpFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnTomarFoto = new javax.swing.JButton();
        pnlAsignacionPrivilegios = new javax.swing.JPanel();
        chkAdministrarFacturas = new javax.swing.JCheckBox();
        chkAdministrarCajas = new javax.swing.JCheckBox();
        chkAdministrarInventarios = new javax.swing.JCheckBox();
        chkAdministrarEmpleados = new javax.swing.JCheckBox();
        chkAdministrarClientes = new javax.swing.JCheckBox();
        pnlDatosAcceso = new javax.swing.JPanel();
        lblContrasenna = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblVerificarContrasenna = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        lblCorreoElectronico = new javax.swing.JLabel();
        txtVerificarContrasenna = new javax.swing.JPasswordField();
        txtContrasenna = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar empleado");

        pnlDatosEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        pnlDatosEmpleado.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N

        lblCedula.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblCedula.setText("Cédula:");

        txtCedula.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblFechaNacimiento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblFechaNacimiento.setText("Fecha de nacimiento");

        lblTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblTelefono.setText("Télefono:");

        txtTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblCelular.setText("Celular:");

        lblSexo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblSexo.setText("Sexo:");

        cmbSexo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino ", "Femenino" }));

        lblDepartamento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblDepartamento.setText("Departamento:");

        cmbDepartamento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cajas", "Bodega", "Administración" }));

        lblEdad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblEdad.setText("Edad:");

        txtEdad.setEditable(false);
        txtEdad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        btnRegistrar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        dtpFechaNacimiento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        dtpFechaNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtpFechaNacimientoPropertyChange(evt);
            }
        });

        btnTomarFoto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnTomarFoto.setText("Tomar foto");
        btnTomarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosEmpleadoLayout = new javax.swing.GroupLayout(pnlDatosEmpleado);
        pnlDatosEmpleado.setLayout(pnlDatosEmpleadoLayout);
        pnlDatosEmpleadoLayout.setHorizontalGroup(
            pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(lblTelefono)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 154, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDepartamento, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSexo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCelular, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, 0, 210, Short.MAX_VALUE)
                                .addComponent(cmbSexo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(txtDireccion))
                .addGap(43, 43, 43)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTomarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDatosEmpleadoLayout.setVerticalGroup(
            pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartamento)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFechaNacimiento)
                        .addComponent(lblEdad)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion)
                    .addComponent(btnTomarFoto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAsignacionPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignación de privilegios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
        pnlAsignacionPrivilegios.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        chkAdministrarFacturas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        chkAdministrarFacturas.setText("Administrar facturas");

        chkAdministrarCajas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        chkAdministrarCajas.setText("Administrar cajas");

        chkAdministrarInventarios.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        chkAdministrarInventarios.setText("Administrar inventarios");

        chkAdministrarEmpleados.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        chkAdministrarEmpleados.setText("Administrar empleados");

        chkAdministrarClientes.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        chkAdministrarClientes.setText("Administrar clientes");

        javax.swing.GroupLayout pnlAsignacionPrivilegiosLayout = new javax.swing.GroupLayout(pnlAsignacionPrivilegios);
        pnlAsignacionPrivilegios.setLayout(pnlAsignacionPrivilegiosLayout);
        pnlAsignacionPrivilegiosLayout.setHorizontalGroup(
            pnlAsignacionPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionPrivilegiosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlAsignacionPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkAdministrarClientes)
                    .addComponent(chkAdministrarEmpleados)
                    .addComponent(chkAdministrarInventarios)
                    .addComponent(chkAdministrarCajas)
                    .addComponent(chkAdministrarFacturas))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        pnlAsignacionPrivilegiosLayout.setVerticalGroup(
            pnlAsignacionPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionPrivilegiosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(chkAdministrarFacturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAdministrarCajas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAdministrarInventarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAdministrarEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAdministrarClientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosAcceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        lblContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblContrasenna.setText("Contraseña:");

        lblNombreUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblNombreUsuario.setText("Nombre de usuario:");

        txtNombreUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblVerificarContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblVerificarContrasenna.setText("Verificar contraseña:");

        txtCorreoElectronico.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblCorreoElectronico.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblCorreoElectronico.setText("Correo electrónico:");

        txtVerificarContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDatosAccesoLayout = new javax.swing.GroupLayout(pnlDatosAcceso);
        pnlDatosAcceso.setLayout(pnlDatosAccesoLayout);
        pnlDatosAccesoLayout.setHorizontalGroup(
            pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAccesoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContrasenna)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblVerificarContrasenna)
                    .addComponent(lblCorreoElectronico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreUsuario)
                    .addComponent(txtContrasenna)
                    .addComponent(txtVerificarContrasenna, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(txtCorreoElectronico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDatosAccesoLayout.setVerticalGroup(
            pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosAccesoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreoElectronico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasenna)
                    .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVerificarContrasenna)
                    .addComponent(txtVerificarContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDatosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAsignacionPrivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlAsignacionPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatosAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        Date date = new Date();
        char[] pass;
        pass = txtContrasenna.getPassword();
        String contrasenna = "";
        for (int pos = 0; pos < pass.length; pos++) {
            contrasenna += pass[pos];
        }
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaCreacion = hourdateFormat.format(date);
        if (isPasswordCorrect(txtContrasenna.getPassword(), txtVerificarContrasenna.getPassword())) {
            if (comprobarDatos() == false) {
                if (verificarCorreo() == false) {
                    JOptionPane.showMessageDialog(null, "Correo electrónico inválido. Por favor corrija para contimuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    obtenerPrivilegios();
                    Empleado oEmpleado = new Empleado(
                            txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCelular.getText(),
                            fechaNacimiento, cmbDepartamento.getSelectedItem().toString(), txtEdad.getText(), cmbSexo.getSelectedItem().toString(),
                            txtCorreoElectronico.getText(), fechaCreacion, "", usuario, "", txtNombreUsuario.getText(),
                            contrasenna, adminClientes, adminInventario, adminFacturas, adminEmpleados,
                            adminCajas
                    );
                    oEmpleadoD.registrarEmpleado(oEmpleado);
                    if (oEmpleadoD.isError()) {
                        JOptionPane.showMessageDialog(null,
                                "Error consultando a la base de datos, detalle técnico: " + oEmpleadoD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        txtCedula.setText("");
                        txtEdad.setText("");
                        txtNombre.setText("");
                        txtContrasenna.setText("");
                        txtNombreUsuario.setText("");
                        txtCorreoElectronico.setText("");
                        txtDireccion.setText("");
                        txtTelefono.setText("");
                        txtCelular.setText("");
                        txtVerificarContrasenna.setText("");
                        txtContrasenna.setText("");
                        chkAdministrarCajas.setSelected(false);
                        chkAdministrarClientes.setSelected(false);
                        chkAdministrarEmpleados.setSelected(false);
                        chkAdministrarFacturas.setSelected(false);
                        chkAdministrarInventarios.setSelected(false);
                        JOptionPane.showMessageDialog(null,
                                "Empleado registrado satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, por favor corrija para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void dtpFechaNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtpFechaNacimientoPropertyChange
        // TODO add your handling code here:
        try {
            Date date = dtpFechaNacimiento.getDate();
            if (date != null) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                fechaNacimiento = formato.format(date);
                txtEdad.setText(String.valueOf(calculaEdad(fechaNacimiento)));
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error de datos, posible fecha incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dtpFechaNacimientoPropertyChange

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnTomarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarFotoActionPerformed
        GestionTxt oTxt = new GestionTxt();
        if (txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el número de cédula para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            oTxt.escrituraDatosFotoPerfil(txtNombre.getText(), txtCedula.getText());
            if (oTxt.isError()) {
                JOptionPane.showMessageDialog(null, "Error al intentar abrir la aplicación. Detalle técnico: " + oTxt.getErrorDescripcion(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    File miDir = new File("C:\\Sistema Punto Venta\\frmTomarFoto\\bin\\Debug\\");
                    if (miDir.exists()) {
                        Process proceso = Runtime.getRuntime().exec("C:\\Sistema Punto Venta\\frmTomarFoto\\bin\\Debug\\frmTomarFoto.exe");
                    } else {
                        JOptionPane.showMessageDialog(null, "Problemas al intentar iniciar la aplicación, posible inexistencia de ésta herramienta.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException | HeadlessException xp) {
                    JOptionPane.showMessageDialog(null, "Error al intentar ejecutar la aplicación. Detalle técnico: " + xp.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnTomarFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnTomarFoto;
    private javax.swing.JCheckBox chkAdministrarCajas;
    private javax.swing.JCheckBox chkAdministrarClientes;
    private javax.swing.JCheckBox chkAdministrarEmpleados;
    private javax.swing.JCheckBox chkAdministrarFacturas;
    private javax.swing.JCheckBox chkAdministrarInventarios;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbSexo;
    private com.toedter.calendar.JDateChooser dtpFechaNacimiento;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblContrasenna;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblVerificarContrasenna;
    private javax.swing.JPanel pnlAsignacionPrivilegios;
    private javax.swing.JPanel pnlDatosAcceso;
    private javax.swing.JPanel pnlDatosEmpleado;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JPasswordField txtContrasenna;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JPasswordField txtVerificarContrasenna;
    // End of variables declaration//GEN-END:variables
}

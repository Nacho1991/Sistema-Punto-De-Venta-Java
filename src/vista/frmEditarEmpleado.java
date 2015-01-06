/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Utilidades.Utilidades;
import accesoDatos.AccesoDatosMySql;
import accesoDatos.EmpleadoD;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.text.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author Ignacio
 */
public class frmEditarEmpleado extends javax.swing.JDialog {

    private final Image image = null;
    private final Date fechaActual;
    private String fechaNacimiento;
    private EmpleadoD oEmpleadoD;
    private boolean sinPrivilegios;
    private String nombreUsuario;
    private String creadoPor;
    private String fechaCreacion;
    private boolean aceptar;
    private final int id;
    private String adminClientes;
    private String adminInventario;
    private String adminFacturas;
    private String adminEmpleados;
    private String adminCajas;
    private Icon icon;
    String ruta;
    AccesoDatosMySql cnx;

    public frmEditarEmpleado(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx, String pNombreUsuario) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cnx = pCnx;
        sinPrivilegios = false;
        aceptar = false;
        nombreUsuario = pNombreUsuario;
        id = 0;
        btnRegistrar.setVisible(false);
        oEmpleadoD = new EmpleadoD(pCnx);
        fechaActual = new Date();
    }

    public class Imagen extends javax.swing.JPanel {

        Utilidades oUtilidades = new Utilidades();

        public Imagen(String pCedula) {
            this.setSize(157, 150); //se selecciona el tamaño del panel
            ruta = oUtilidades.obtenerFotoPerfil(pCedula);
        }
//Se crea un método cuyo parámetro debe ser un objeto Graphics

        @Override
        public void paint(Graphics grafico) {
            Dimension height = getSize();
//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(ruta);

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

            setOpaque(false);
            super.paintComponent(grafico);
        }
    }

    public void cargarImagen(String pCedula) {
        Imagen Imagen = new Imagen(pCedula);
        File file = new File(ruta);
        if (file.exists()) {
            pnlFotoPerfil.add(Imagen);
            pnlFotoPerfil.repaint();
        }
    }

    public int calculaEdad(String pFechaNacimiento) {
        java.util.Date fechaActual = new java.util.Date();
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

    public void obtenerPrivilegios() {
        if (chkAdminCajas.isSelected()) {
            adminCajas = "true";
        } else {
            adminCajas = "false";
        }
        if (chkAdminClientes.isSelected()) {
            adminClientes = "true";
        } else {
            adminClientes = "false";
        }
        if (chkAdminEmpleados.isSelected()) {
            adminEmpleados = "true";
        } else {
            adminEmpleados = "false";
        }
        if (chkAdminFacturas.isSelected()) {
            adminFacturas = "true";
        } else {
            adminFacturas = "false";
        }
        if (chkAdminInventarios.isSelected()) {
            adminInventario = "true";
        } else {
            adminInventario = "false";
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatosEmpleado = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        dtpFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        pnlBackGroundFotoPerfil = new javax.swing.JPanel();
        pnlFotoPerfil = new org.edisoncor.gui.panel.PanelImage();
        txtEdad = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox();
        cmbDepartamento = new javax.swing.JComboBox();
        lblDepartamento = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblNumeroRegistro = new javax.swing.JLabel();
        txtNumeroRegistro = new javax.swing.JTextField();
        pnlDatosAcceso = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblContrasenna = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        lblCorreoElectronico = new javax.swing.JLabel();
        btnCambiarContrasenna = new javax.swing.JButton();
        txtContrasenna = new javax.swing.JPasswordField();
        pnlPrivilegios = new javax.swing.JPanel();
        chkAdminCajas = new javax.swing.JCheckBox();
        chkAdminClientes = new javax.swing.JCheckBox();
        chkAdminEmpleados = new javax.swing.JCheckBox();
        chkAdminFacturas = new javax.swing.JCheckBox();
        chkAdminInventarios = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        pnlBotones = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar empleado");
        setResizable(false);

        pnlDatosEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        lblCedula.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblCedula.setText("Cédula:");

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblFechaNacimiento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblFechaNacimiento.setText("Fecha de nacimiento:");

        lblTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono:");

        lblCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblCelular.setText("Celular:");

        txtCedula.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        dtpFechaNacimiento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        dtpFechaNacimiento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtpFechaNacimientoPropertyChange(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtCelular.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        pnlBackGroundFotoPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto de perfil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        javax.swing.GroupLayout pnlFotoPerfilLayout = new javax.swing.GroupLayout(pnlFotoPerfil);
        pnlFotoPerfil.setLayout(pnlFotoPerfilLayout);
        pnlFotoPerfilLayout.setHorizontalGroup(
            pnlFotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlFotoPerfilLayout.setVerticalGroup(
            pnlFotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBackGroundFotoPerfilLayout = new javax.swing.GroupLayout(pnlBackGroundFotoPerfil);
        pnlBackGroundFotoPerfil.setLayout(pnlBackGroundFotoPerfilLayout);
        pnlBackGroundFotoPerfilLayout.setHorizontalGroup(
            pnlBackGroundFotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBackGroundFotoPerfilLayout.setVerticalGroup(
            pnlBackGroundFotoPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtEdad.setEditable(false);
        txtEdad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblEdad.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblEdad.setText("Edad:");

        lblSexo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblSexo.setText("Sexo:");

        cmbSexo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        cmbDepartamento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cajas", "Bodega", "Administración" }));
        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        lblDepartamento.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblDepartamento.setText("Departamento");

        lblDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtDireccion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");

        lblNumeroRegistro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblNumeroRegistro.setText("N° Registro:");

        txtNumeroRegistro.setEditable(false);
        txtNumeroRegistro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDatosEmpleadoLayout = new javax.swing.GroupLayout(pnlDatosEmpleado);
        pnlDatosEmpleado.setLayout(pnlDatosEmpleadoLayout);
        pnlDatosEmpleadoLayout.setHorizontalGroup(
            pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDireccion)
                    .addComponent(lblCedula)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblNombre)
                    .addComponent(lblTelefono)
                    .addComponent(lblNumeroRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosEmpleadoLayout.createSequentialGroup()
                                .addComponent(txtNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEdad))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDatosEmpleadoLayout.createSequentialGroup()
                                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefono)
                                    .addComponent(dtpFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(116, 116, 116)))
                                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(lblSexo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosEmpleadoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDepartamento, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCelular, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cmbDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addContainerGap())
                    .addComponent(pnlBackGroundFotoPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlDatosEmpleadoLayout.setVerticalGroup(
            pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                .addComponent(pnlBackGroundFotoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlDatosEmpleadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroRegistro)
                    .addComponent(txtNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(dtpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCelular)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion))
                .addGap(17, 17, 17))
        );

        pnlDatosAcceso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de acceso", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        lblNombreUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblNombreUsuario.setText("Nombre de usuario:");

        txtNombreUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblContrasenna.setText("Contraseña:");

        txtCorreoElectronico.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        lblCorreoElectronico.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lblCorreoElectronico.setText("Correo electronico:");

        btnCambiarContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnCambiarContrasenna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/change_password_2.png"))); // NOI18N
        btnCambiarContrasenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContrasennaActionPerformed(evt);
            }
        });

        txtContrasenna.setEditable(false);
        txtContrasenna.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDatosAccesoLayout = new javax.swing.GroupLayout(pnlDatosAcceso);
        pnlDatosAcceso.setLayout(pnlDatosAccesoLayout);
        pnlDatosAccesoLayout.setHorizontalGroup(
            pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAccesoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblContrasenna)
                    .addComponent(lblCorreoElectronico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContrasenna, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiarContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        pnlDatosAccesoLayout.setVerticalGroup(
            pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosAccesoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreUsuario)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosAccesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblContrasenna)
                        .addComponent(txtContrasenna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCambiarContrasenna))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPrivilegios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilegios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        chkAdminCajas.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        chkAdminCajas.setText("Administración de cajas");

        chkAdminClientes.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        chkAdminClientes.setText("Administración de clientes");

        chkAdminEmpleados.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        chkAdminEmpleados.setText("Administración de empleados");

        chkAdminFacturas.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        chkAdminFacturas.setText("Administración de facturas");

        chkAdminInventarios.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        chkAdminInventarios.setText("Administración de inventarios");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrivilegiosLayout = new javax.swing.GroupLayout(pnlPrivilegios);
        pnlPrivilegios.setLayout(pnlPrivilegiosLayout);
        pnlPrivilegiosLayout.setHorizontalGroup(
            pnlPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrivilegiosLayout.createSequentialGroup()
                        .addComponent(chkAdminCajas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar))
                    .addGroup(pnlPrivilegiosLayout.createSequentialGroup()
                        .addGroup(pnlPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkAdminFacturas)
                            .addComponent(chkAdminInventarios)
                            .addComponent(chkAdminEmpleados)
                            .addComponent(chkAdminClientes))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPrivilegiosLayout.setVerticalGroup(
            pnlPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addComponent(chkAdminCajas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAdminClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAdminEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAdminInventarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkAdminFacturas)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnActualizar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(282, 282, 282))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnlDatosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDatosAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDatosEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatosAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPrivilegios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        pnlFotoPerfil.setIcon(null);
        frmBuscarEmpleado oSearch = new frmBuscarEmpleado(null, rootPaneCheckingEnabled, cnx);
        oSearch.setVisible(true);
        if (oSearch.isAceptar()) {
            try {
                txtNumeroRegistro.setText(String.valueOf(oSearch.getId()));
                txtCedula.setText(oSearch.getCedula());
                txtNombre.setText(oSearch.getNombre());
                fechaCreacion = oSearch.getFechaCreacion();
                creadoPor = oSearch.getCreadoPor();
                //dtpFechaNacimiento.setDateFormatString(oSearch.getFechaNacimiento());
                txtTelefono.setText(oSearch.getTelefono());
                txtDireccion.setText(oSearch.getDireccion());
                txtEdad.setText(oSearch.getEdad());
                cmbSexo.setSelectedItem(oSearch.getSexo());
                cmbDepartamento.setSelectedItem(oSearch.getDepartamento());
                txtCelular.setText(oSearch.getCelular());
                //Datos de acceso al sistema
                txtCorreoElectronico.setText(oSearch.getEmail());
                txtNombreUsuario.setText(oSearch.getNombreUsuario());
                txtContrasenna.setText(oSearch.getContrasenna());
                //Datos de privilegios del sistema
                sinPrivilegios = oSearch.isSinPrivilegios();
                if (sinPrivilegios == true) {
                    btnRegistrar.setVisible(true);
                    JOptionPane.showMessageDialog(null, "No existe privilegios asociados a éste empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    btnRegistrar.setVisible(false);
                    chkAdminCajas.setSelected(Boolean.parseBoolean(oSearch.getAdminCajas()));
                    chkAdminClientes.setSelected(Boolean.parseBoolean(oSearch.getAdminClientes()));
                    chkAdminEmpleados.setSelected(Boolean.parseBoolean(oSearch.getAdminEmpleados()));
                    chkAdminFacturas.setSelected(Boolean.parseBoolean(oSearch.getAdminFacturas()));
                    chkAdminInventarios.setSelected(Boolean.parseBoolean(oSearch.getAdminInventario()));
                    cargarImagen(txtCedula.getText());
                }
            } catch (Exception xp) {
                JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void dtpFechaNacimientoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtpFechaNacimientoPropertyChange
        // TODO add your handling code here:
        try {
            java.util.Date date = dtpFechaNacimiento.getDate();
            if (date != null) {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                fechaNacimiento = formato.format(date);
                txtEdad.setText(String.valueOf(calculaEdad(fechaNacimiento)));
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error de datos, posible fecha incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_dtpFechaNacimientoPropertyChange

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Date date = new Date();
        char[] pass;
        pass = txtContrasenna.getPassword();
        String contrasenna = "";
        for (int pos = 0; pos < pass.length; pos++) {
            contrasenna += pass[pos];
        }
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaModificacion = hourdateFormat.format(date);
        if (comprobarDatos() == false) {
            if (verificarCorreo() == false) {
                JOptionPane.showMessageDialog(null, "Correo electrónico inválido. Por favor corrija para contimuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                obtenerPrivilegios();
                Empleado oEmpleado = new Empleado(
                        txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCelular.getText(),
                        fechaNacimiento, cmbDepartamento.getSelectedItem().toString(), txtEdad.getText(), cmbSexo.getSelectedItem().toString(),
                        txtCorreoElectronico.getText(), fechaCreacion, fechaModificacion, creadoPor, nombreUsuario, txtNombreUsuario.getText(),
                        contrasenna, adminClientes, adminInventario, adminFacturas, adminEmpleados,
                        adminCajas
                );
                oEmpleadoD.actualizarEmpleado(oEmpleado, Integer.parseInt(txtNumeroRegistro.getText()));
                if (oEmpleadoD.isError()) {
                    JOptionPane.showMessageDialog(null,
                            "Error consultando a la base de datos, detalle técnico: " + oEmpleadoD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    txtNumeroRegistro.setText("");
                    txtCedula.setText("");
                    txtEdad.setText("");
                    txtNombre.setText("");
                    txtContrasenna.setText("");
                    txtNombreUsuario.setText("");
                    txtCorreoElectronico.setText("");
                    txtDireccion.setText("");
                    txtTelefono.setText("");
                    txtCelular.setText("");
                    txtContrasenna.setText("");
                    chkAdminCajas.setSelected(false);
                    chkAdminClientes.setSelected(false);
                    chkAdminEmpleados.setSelected(false);
                    chkAdminFacturas.setSelected(false);
                    chkAdminInventarios.setSelected(false);
                    JOptionPane.showMessageDialog(null,
                            "Empleado actualizado satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCambiarContrasennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContrasennaActionPerformed
        // TODO add your handling code here:
        char[] pass;
        int confirmado = 0;
        boolean crear = false;
        pass = txtContrasenna.getPassword();
        String contrasenna = "";
        for (int pos = 0; pos < pass.length; pos++) {
            contrasenna += pass[pos];
        }
        if (txtCedula.getText().equals("") || txtNumeroRegistro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay datos cargados para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txtNombreUsuario.getText().equals("") && contrasenna.equals("")) {
                confirmado = JOptionPane.showConfirmDialog(
                        null,
                        "No hay datos de acceso registrados. ¿Desea asignar nombre usuario y contraseña?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (confirmado == 0) {
                    crear = true;
                    frmCambiarContrasenna oChange = new frmCambiarContrasenna(null, true, txtNombreUsuario.getText(), txtCedula.getText(), crear, cnx);
                    oChange.setVisible(true);
                }
            } else {
                frmCambiarContrasenna oChange = new frmCambiarContrasenna(null, true, txtNombreUsuario.getText(), txtCedula.getText(), crear, cnx);
                oChange.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnCambiarContrasennaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Empleado oEmpleado = new Empleado();
        obtenerPrivilegios();
        oEmpleado.registrarPrivilegios(txtCedula.getText(), adminClientes, adminInventario, adminFacturas, adminEmpleados,
                adminCajas
        );
        oEmpleadoD.registrarPrivilegios(oEmpleado);
        if (oEmpleadoD.isError()) {
            JOptionPane.showMessageDialog(null, "Error inesperado al intentar asociar los privilegios. Detalle técnico: " + oEmpleadoD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            btnRegistrar.setVisible(false);
            JOptionPane.showMessageDialog(null, "Privilegios asociados satisfactoriamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCambiarContrasenna;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JCheckBox chkAdminCajas;
    private javax.swing.JCheckBox chkAdminClientes;
    private javax.swing.JCheckBox chkAdminEmpleados;
    private javax.swing.JCheckBox chkAdminFacturas;
    private javax.swing.JCheckBox chkAdminInventarios;
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
    private javax.swing.JLabel lblNumeroRegistro;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel pnlBackGroundFotoPerfil;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDatosAcceso;
    private javax.swing.JPanel pnlDatosEmpleado;
    private org.edisoncor.gui.panel.PanelImage pnlFotoPerfil;
    private javax.swing.JPanel pnlPrivilegios;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JPasswordField txtContrasenna;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNumeroRegistro;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}

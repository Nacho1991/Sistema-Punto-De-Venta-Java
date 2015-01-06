/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.EmpleadoD;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logica.Empleado;

/**
 *
 * @author Ignacio
 */
public class frmBuscarEmpleado extends javax.swing.JDialog {

    ArrayList registros;
    EmpleadoD oEmpleadoD;
    private boolean sinPrivilegios;
    AccesoDatosMySql cnx;
    private int id;
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String celular;
    private String fechaNacimiento;
    private String departamento;
    private String edad;
    private String sexo;
    private String email;
    private String fechaCreacion;
    private String fechaModificacion;
    private String creadoPor;
    private String modificadoPor;
    private boolean aceptar;
    //Variables para los datos de acceso
    private String nombreUsuario;
    private String contrasenna;
    //Variables para los privilegios
    private String adminClientes;
    private String adminInventario;
    private String adminFacturas;
    private String adminEmpleados;
    private String adminCajas;
    //Cabeceras de la tabla
    private String[] cabeceras = {
        "N° Registro", "Cédula", "Nombre",
        "Dirección", "Telefono", "Celular",
        "Fecha de nacimiento", "Departamento", "Edad",
        "Sexo", "Email", "Fecha de creación", "Fecha de modificación",
        "Creado por", "Modificado por"
    };
    private String[][] datos = new String[0][15];

    public frmBuscarEmpleado(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        initComponents();
        oEmpleadoD = new EmpleadoD(pCnx);
        setLocationRelativeTo(null);
        cnx = pCnx;
        sinPrivilegios = false;
        refrescar();
        setJTexFieldChanged(txtDatoFiltro);
    }
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //Metodo para el evnto de cambio
    private void setJTexFieldChanged(JTextField txt) {
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                printIt(documentEvent);
            }
        };
        txt.getDocument().addDocumentListener(documentListener);
    }

    //Metodo que permite mostrar los datos que se ingresan al TextBox
    private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();
        if (type.equals(DocumentEvent.EventType.CHANGE)) {

        } else if (type.equals(DocumentEvent.EventType.INSERT)) {
            txtEjemploJTextFieldChanged();
        } else if (type.equals(DocumentEvent.EventType.REMOVE)) {
            txtEjemploJTextFieldChanged();
        }
    }

    //Envocamos el evento de cambio de texto
    private void txtEjemploJTextFieldChanged() {
        String opcion = cmbOpcionesBusqueda.getSelectedItem().toString();
        switch (opcion) {
            case "Cédula":
                opcion = "Cedula";
                mostrarFiltro(txtDatoFiltro.getText(), opcion);
                break;
            case "Nombre":
                opcion = "Nombre";
                mostrarFiltro(txtDatoFiltro.getText(), opcion);
                break;
        }
    }

    private void mostrarFiltro(String pFiltro, String pOpcion) {
        registros = (ArrayList) oEmpleadoD.filtrarDatos(pFiltro, pOpcion);
        if (oEmpleadoD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oEmpleadoD.getErrorMsg());
        } else {
            this.datos = new String[registros.size()][15];
            for (int i = 0; i < registros.size(); i++) {
                Empleado aux = (Empleado) registros.get(i);
                this.datos[i][0] = String.valueOf(aux.getId());
                this.datos[i][1] = aux.getCedula();
                this.datos[i][2] = aux.getNombre();
                this.datos[i][3] = aux.getDireccion();
                this.datos[i][4] = aux.getTelefono();
                this.datos[i][5] = aux.getCelular();
                this.datos[i][6] = aux.getFechaNacimiento();
                this.datos[i][7] = aux.getDepartamento();
                this.datos[i][8] = aux.getEdad();
                this.datos[i][9] = aux.getSexo();
                this.datos[i][10] = aux.getEmail();
                this.datos[i][11] = aux.getFechaCreacion();
                this.datos[i][12] = aux.getFechaModificion();
                this.datos[i][13] = aux.getCreadoPor();
                this.datos[i][14] = aux.getModificadoPor();

            }
            this.modelo.setDataVector(datos, cabeceras);
            this.tblRegistros.setModel(modelo);
        }
    }

    private void obtenerDatosAcceso(String pCedula) {
        registros = (ArrayList) oEmpleadoD.obtenerDatosAcceso(pCedula);
        if (oEmpleadoD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oEmpleadoD.getErrorMsg());
        } else {
            for (int i = 0; i < registros.size(); i++) {
                Empleado aux = (Empleado) registros.get(i);
                nombreUsuario = aux.getNombreUsuario();
                contrasenna = aux.getContrasenna();
            }
        }
    }

    private void obtenerPrivilegios(String pCedula) {
        registros = (ArrayList) oEmpleadoD.obtenerPrivilegios(pCedula);
        if (oEmpleadoD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oEmpleadoD.getErrorMsg());
        } else {
            if (registros.isEmpty()) {
                sinPrivilegios = true;
            } else {
                for (Object registro : registros) {
                    Empleado aux = (Empleado) registro;
                    adminCajas = aux.getAdminCajas();
                    adminClientes = aux.getAdminClientes();
                    adminEmpleados = aux.getAdminEmpleados();
                    adminFacturas = aux.getAdminFacturas();
                    adminInventario = aux.getAdminFacturas();
                }
            }
        }
    }

    private void refrescar() {
        registros = (ArrayList) oEmpleadoD.consultarRegistro();
        if (oEmpleadoD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oEmpleadoD.getErrorMsg());
        } else {
            this.datos = new String[registros.size()][15];
            for (int i = 0; i < registros.size(); i++) {
                Empleado aux = (Empleado) registros.get(i);
                this.datos[i][0] = String.valueOf(aux.getId());
                this.datos[i][1] = aux.getCedula();
                this.datos[i][2] = aux.getNombre();
                this.datos[i][3] = aux.getDireccion();
                this.datos[i][4] = aux.getTelefono();
                this.datos[i][5] = aux.getCelular();
                this.datos[i][6] = String.valueOf(aux.getFechaNacimiento());
                this.datos[i][7] = aux.getDepartamento();
                this.datos[i][8] = aux.getEdad();
                this.datos[i][9] = aux.getSexo();
                this.datos[i][10] = aux.getEmail();
                this.datos[i][11] = String.valueOf(aux.getFechaCreacion());
                this.datos[i][12] = String.valueOf(aux.getFechaModificion());
                this.datos[i][13] = aux.getCreadoPor();
                this.datos[i][14] = aux.getModificadoPor();

            }
            this.modelo.setDataVector(datos, cabeceras);
            this.tblRegistros.setModel(modelo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDatoFiltro = new javax.swing.JTextField();
        cmbOpcionesBusqueda = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar empleado");

        pnlRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de registros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout pnlRegistrosLayout = new javax.swing.GroupLayout(pnlRegistros);
        pnlRegistros.setLayout(pnlRegistrosLayout);
        pnlRegistrosLayout.setHorizontalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlRegistrosLayout.setVerticalGroup(
            pnlRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel1.setText("Buscar:");

        txtDatoFiltro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        cmbOpcionesBusqueda.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        cmbOpcionesBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cédula", "Nombre" }));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel2.setText("Opciones de búsqueda:");

        btnSeleccionar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbOpcionesBusqueda, 0, 432, Short.MAX_VALUE)
                    .addComponent(txtDatoFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar)
                .addContainerGap(475, Short.MAX_VALUE))
            .addComponent(pnlRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSeleccionar)
                    .addComponent(txtDatoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbOpcionesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        try {
            int numeroProductos = tblRegistros.getRowCount();
            int fila = tblRegistros.getSelectedRow();
            if (fila >= 0) {
                if (numeroProductos > 0) {
                    id = Integer.parseInt(modelo.getValueAt(tblRegistros.getSelectedRow(), 0).toString());
                    cedula = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 1));
                    nombre = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 2));
                    direccion = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 3));
                    telefono = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 4));
                    celular = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 5));
                    fechaNacimiento = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 6));
                    departamento = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 7));
                    edad = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 8));
                    sexo = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 9));
                    email = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 10));
                    fechaCreacion = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 11));
                    fechaModificacion = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 12));
                    creadoPor = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 13));
                    modificadoPor = String.valueOf(modelo.getValueAt(tblRegistros.getSelectedRow(), 14));
                    obtenerPrivilegios(cedula);
                    obtenerDatosAcceso(cedula);
                    aceptar = true;
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No hay productos en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Por favor seleccione una fila.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException | HeadlessException xp) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado al intentar cargar los datos del producto. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    public String getAdminClientes() {
        return adminClientes;
    }

    public void setAdminClientes(String adminClientes) {
        this.adminClientes = adminClientes;
    }

    public String getAdminInventario() {
        return adminInventario;
    }

    public void setAdminInventario(String adminInventario) {
        this.adminInventario = adminInventario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public boolean isSinPrivilegios() {
        return sinPrivilegios;
    }

    public void setSinPrivilegios(boolean sinPrivilegios) {
        this.sinPrivilegios = sinPrivilegios;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getAdminFacturas() {
        return adminFacturas;
    }

    public void setAdminFacturas(String adminFacturas) {
        this.adminFacturas = adminFacturas;
    }

    public String getAdminEmpleados() {
        return adminEmpleados;
    }

    public void setAdminEmpleados(String adminEmpleados) {
        this.adminEmpleados = adminEmpleados;
    }

    public String getAdminCajas() {
        return adminCajas;
    }

    public void setAdminCajas(String adminCajas) {
        this.adminCajas = adminCajas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public String[] getCabeceras() {
        return cabeceras;
    }

    public void setCabeceras(String[] cabeceras) {
        this.cabeceras = cabeceras;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox cmbOpcionesBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlRegistros;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtDatoFiltro;
    // End of variables declaration//GEN-END:variables
}

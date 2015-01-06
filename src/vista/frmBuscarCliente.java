/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import XmlD.Cliente;
import accesoDatos.AccesoDatosMySql;
import accesoDatos.ClientesD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logica.Clientes;
import logica.Inventario;

/**
 *
 * @author ignacio
 */
public class frmBuscarCliente extends javax.swing.JDialog {

    AccesoDatosMySql cnx;
    private ClientesD oClienteD;
    private ArrayList registros;
    private String[][] datos = new String[0][11];
    private String[] cabeceras = {
        "N° Registro", "Cédula", "Nombre", "Telefono", "Dirección",
        "Estado", "Tipo de cliente", "Fecha de creación", "Fecha de modificación",
        "Modificado por", "Creado por"
    };

    public frmBuscarCliente(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        initComponents();
        oClienteD = new ClientesD(pCnx);
        cnx = pCnx;
        refrescar();
        setLocationRelativeTo(null);
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
            case "Código":
                opcion = "Id_Producto";
                mostrarFiltro(txtFiltroBusqueda.getText(), opcion);
                break;
            case "Descripción":
                opcion = "Descripcion";
                mostrarFiltro(txtFiltroBusqueda.getText(), opcion);
                break;
            case "Marca":
                opcion = "Marca";
                mostrarFiltro(txtFiltroBusqueda.getText(), opcion);
                break;
        }
    }

    private void mostrarFiltro(String pFiltro, String pOpcion) {
        registros = (ArrayList) oClienteD.filtrarCliente(pFiltro, pOpcion);
        if (oClienteD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oClienteD.getErrorMsg());
        } else {
            this.datos = new String[registros.size()][10];
            for (int i = 0; i < registros.size(); i++) {
                Inventario aux = (Inventario) registros.get(i);
                this.datos[i][0] = String.valueOf(aux.getId());
                this.datos[i][1] = aux.getCodigoArticulo();
                this.datos[i][2] = aux.getNombre();
                this.datos[i][3] = aux.getMarca();
                this.datos[i][4] = aux.getDescripcion();
                this.datos[i][5] = String.valueOf(aux.getPrecioCompra());
                this.datos[i][6] = String.valueOf(aux.getPrecioVenta());
                this.datos[i][7] = aux.getExistencia();
                this.datos[i][8] = String.valueOf(aux.getCantidad());
                this.datos[i][9] = aux.getFechaEntrada();

            }
            this.modelo.setDataVector(datos, cabeceras);
            this.tblaRegistroClientes.setModel(modelo);
        }
    }

    private void refrescar() {
        registros = (ArrayList) oClienteD.consultarRegistro();
        if (oClienteD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oClienteD.getErrorMsg());
        } else {
            this.datos = new String[registros.size()][11];
            try {
                if (registros.isEmpty() == false) {
                    for (int i = 0; i < registros.size(); i++) {
                        Clientes aux = (Clientes) registros.get(i);
                        this.datos[i][0] = String.valueOf(aux.getCodCliente());
                        this.datos[i][1] = aux.getCedula();
                        this.datos[i][2] = aux.getNombre();
                        this.datos[i][3] = aux.getTelefono();
                        this.datos[i][4] = aux.getDireccion();
                        this.datos[i][5] = aux.getEstado();
                        this.datos[i][6] = aux.getTipoCliente();
                        this.datos[i][7] = aux.getFechaCreacion();
                        this.datos[i][8] = aux.getFechaModificacion();
                        this.datos[i][9] = aux.getCreadoPor();
                        this.datos[i][10] = aux.getModificadoPor();

                    }
                    this.modelo.setDataVector(datos, cabeceras);
                    this.tblaRegistroClientes.setModel(modelo);
                } else {
                    JOptionPane.showMessageDialog(null, "No existen registros de clientes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception xp) {
                JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        pnlVisor = new org.edisoncor.gui.panel.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFiltroBusqueda = new javax.swing.JTextField();
        cmbOpcionesBusqueda = new javax.swing.JComboBox();
        buttonColoredAction1 = new org.edisoncor.gui.button.ButtonColoredAction();
        pnlRegistrosCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaRegistroClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscador de clientes");

        pnlBackground.setBackground(new java.awt.Color(138, 138, 138));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Buscar cliente:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Opciones de búsqueda:");

        cmbOpcionesBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por cédula", "Por nombre", "Por código" }));

        buttonColoredAction1.setText("Seleccionar");

        pnlRegistrosCliente.setBackground(new java.awt.Color(138, 138, 138));
        pnlRegistrosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros de clientes"));

        tblaRegistroClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblaRegistroClientes);

        javax.swing.GroupLayout pnlRegistrosClienteLayout = new javax.swing.GroupLayout(pnlRegistrosCliente);
        pnlRegistrosCliente.setLayout(pnlRegistrosClienteLayout);
        pnlRegistrosClienteLayout.setHorizontalGroup(
            pnlRegistrosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlRegistrosClienteLayout.setVerticalGroup(
            pnlRegistrosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlVisorLayout = new javax.swing.GroupLayout(pnlVisor);
        pnlVisor.setLayout(pnlVisorLayout);
        pnlVisorLayout.setHorizontalGroup(
            pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisorLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFiltroBusqueda)
                    .addComponent(cmbOpcionesBusqueda, 0, 326, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonColoredAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
            .addComponent(pnlRegistrosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlVisorLayout.setVerticalGroup(
            pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisorLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColoredAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOpcionesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(pnlRegistrosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlVisor, java.awt.BorderLayout.CENTER);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction1;
    private javax.swing.JComboBox cmbOpcionesBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private javax.swing.JPanel pnlRegistrosCliente;
    private org.edisoncor.gui.panel.PanelShadow pnlVisor;
    private javax.swing.JTable tblaRegistroClientes;
    private javax.swing.JTextField txtFiltroBusqueda;
    // End of variables declaration//GEN-END:variables
}

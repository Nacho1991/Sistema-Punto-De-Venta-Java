/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Componentes.*;
import accesoDatos.AccesoDatosMySql;
import accesoDatos.InventarioD;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logica.Inventario;

/**
 *
 * @author ignacio
 */
public class frmControlTotalInventario extends javax.swing.JFrame {

    private InventarioD oInventarioD;
    private Date date;
    ArrayList tarjetas;
    private String[] cabeceras = {"N° Registro", "Código", "Nombre", "Marca", "Descripción", "Precio de compra", "Precio de venta", "Existencia", "Cantidad", "Fecha de entrada"};
    private String[][] datos = new String[0][10];

    public frmControlTotalInventario(AccesoDatosMySql pCnx) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        oInventarioD = new InventarioD(pCnx);
        refrescar();
        txtFiltroDatos.setSize(300, 300);
        date = new Date();
        setLocationRelativeTo(null);
        setJTexFieldChanged(txtFiltroDatos);
    }
    private final DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            switch (column) {
                case 7:
                    return true;
                default:
                    return false;
            }
        }
    };

    private void refrescar() {
        ArrayList tarjetas = (ArrayList) oInventarioD.consultarRegistro();
        if (oInventarioD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oInventarioD.getErrorMsg());
        } else {
            this.datos = new String[tarjetas.size()][10];
            for (int i = 0; i < tarjetas.size(); i++) {
                Inventario aux = (Inventario) tarjetas.get(i);
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
            this.tblRegistros.setModel(modelo);

        }
    }

    public void eliminarSeleccion() {
        try {
            int fila = this.tblRegistros.getSelectedRow();
            if (this.datos.length > 0) {
                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (respuesta == JOptionPane.YES_OPTION) {

                        Inventario oInventario = new Inventario(
                                Integer.parseInt(this.datos[fila][0]), this.datos[fila][1], this.datos[fila][2], this.datos[fila][3],
                                this.datos[fila][4], Double.parseDouble(this.datos[fila][5]),
                                Double.parseDouble(this.datos[fila][6]), this.datos[fila][7],
                                Integer.parseInt(this.datos[fila][8]), this.datos[fila][9]);
                        oInventarioD.borrarProducto(oInventario);
                        if (oInventarioD.isError()) {
                            JOptionPane.showMessageDialog(null,
                                    "Error consultando a la base de datos, detalle técnico:" + oInventarioD.getErrorMsg());
                        } else {
                            this.refrescar();
                            JOptionPane.showMessageDialog(null,
                                    "Producto eliminado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "No se ha seleccionado ningún producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "No hay registros en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException xp) {
            JOptionPane.showMessageDialog(null, "Error inesperado durante el proceso. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
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
            txtJTextFieldChanged();
        } else if (type.equals(DocumentEvent.EventType.REMOVE)) {
            txtJTextFieldChanged();
        }
    }

    private void txtJTextFieldChanged() {
        String opcion = cmbOpcionesBusquedaAgregar.getSelectedItem().toString();
        switch (opcion) {
            case "Por código":
                opcion = "Codigo_Articulo";
                mostrarFiltro(txtFiltroDatos.getText(), opcion);
                break;
            case "Por descripción":
                opcion = "Descripcion";
                mostrarFiltro(txtFiltroDatos.getText(), opcion);
                break;
            case "Por marca":
                opcion = "Marca";
                mostrarFiltro(txtFiltroDatos.getText(), opcion);
                break;
        }
    }

    private void mostrarFiltro(String pFiltro, String pOpcion) {
        tarjetas = (ArrayList) oInventarioD.filtrarInventario(pFiltro, pOpcion);
        if (oInventarioD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oInventarioD.getErrorMsg());
        } else {
            this.datos = new String[tarjetas.size()][10];
            for (int i = 0; i < tarjetas.size(); i++) {
                Inventario aux = (Inventario) tarjetas.get(i);
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
            this.tblRegistros.setModel(modelo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new org.edisoncor.gui.panel.PanelNice();
        tabAgregarProducto = new org.edisoncor.gui.tabbedPane.TabbedSelector2();
        pnlAgregarProducto = new org.edisoncor.gui.panel.PanelNice();
        pnlComponentesAgregar = new org.edisoncor.gui.panel.PanelShadow();
        numPorcentajeAgregar = new javax.swing.JSpinner();
        numCantidadAgregar = new javax.swing.JSpinner();
        numPrecioVentaAgregar = new javax.swing.JSpinner();
        numPrecioCompraAgregar = new javax.swing.JSpinner();
        btnCancelarAgregar = new org.edisoncor.gui.button.ButtonAction();
        btnAgregar = new org.edisoncor.gui.button.ButtonAction();
        lblCodProductoAgregar = new javax.swing.JLabel();
        lblNombreProductoAgregar = new javax.swing.JLabel();
        lblMarcaAgregar = new javax.swing.JLabel();
        lblDescripcionAgregar = new javax.swing.JLabel();
        lblPrecioCompraAgregar = new javax.swing.JLabel();
        lblPrecioVentaAgregar = new javax.swing.JLabel();
        lblCantidadAgregar = new javax.swing.JLabel();
        lblPorcentajeAgregar = new javax.swing.JLabel();
        txtCodigoProductoAgregar = new javax.swing.JTextField();
        txtNombreProductoAgregar = new javax.swing.JTextField();
        txtMarcaAgregar = new javax.swing.JTextField();
        txtDescripcionAgregar = new javax.swing.JTextField();
        lblExistenciaAgregar = new javax.swing.JLabel();
        chkExistenciaAgregar = new javax.swing.JCheckBox();
        pnlModificarProductos = new org.edisoncor.gui.panel.PanelNice();
        pnlComponentesModificar = new org.edisoncor.gui.panel.PanelShadow();
        numPorcentajeModificar = new javax.swing.JSpinner();
        numCantidadModificar = new javax.swing.JSpinner();
        numPrecioVentaModificar = new javax.swing.JSpinner();
        numPrecioCompraModificar = new javax.swing.JSpinner();
        btnCancelarModificar = new org.edisoncor.gui.button.ButtonAction();
        btnModificar = new org.edisoncor.gui.button.ButtonAction();
        lblCodigoProductoModificar = new javax.swing.JLabel();
        lblNombreProductoModificar = new javax.swing.JLabel();
        lblMarcaModificar = new javax.swing.JLabel();
        lblDescripcionModificar = new javax.swing.JLabel();
        lblPrecioCompraModificar = new javax.swing.JLabel();
        lblPrecioVentaModificar = new javax.swing.JLabel();
        lblCantidadModificar = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        txtCodigoProductoModificar = new javax.swing.JTextField();
        txtNombreProductoModificar = new javax.swing.JTextField();
        txtMarcaModificar = new javax.swing.JTextField();
        txtDescripcionModificar = new javax.swing.JTextField();
        txtNumeroRegistro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblExistenciaModificar = new javax.swing.JLabel();
        chkExistenciaModificar = new javax.swing.JCheckBox();
        pnlTablaRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        tlbOpciones = new javax.swing.JToolBar();
        btnEliminar = new org.edisoncor.gui.button.ButtonSeven();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnActualizar = new org.edisoncor.gui.button.ButtonSeven();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        lblFiltrar = new javax.swing.JLabel();
        txtFiltroDatos = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        lblOpcionesBusqueda = new javax.swing.JLabel();
        cmbOpcionesBusquedaAgregar = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controlador total de inventario");

        pnlPrincipal.setBackground(new java.awt.Color(242, 242, 242));

        tabAgregarProducto.setForeground(new java.awt.Color(1, 1, 1));
        tabAgregarProducto.setColorBackGround(new java.awt.Color(242, 242, 242));
        tabAgregarProducto.setColorDeBorde(new java.awt.Color(1, 1, 1));
        tabAgregarProducto.setColorDeSegundoBorde(new java.awt.Color(1, 1, 1));
        tabAgregarProducto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        tabAgregarProducto.setListColor(new java.awt.Color(1, 1, 1));
        tabAgregarProducto.setSelectionColor(new java.awt.Color(1, 1, 1));

        pnlAgregarProducto.setBackground(new java.awt.Color(242, 242, 242));
        pnlAgregarProducto.setBorderColor(new java.awt.Color(1, 1, 1));
        pnlAgregarProducto.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        pnlComponentesAgregar.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos a registrar"));
        pnlComponentesAgregar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        numPorcentajeAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        numPorcentajeAgregar.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        numPorcentajeAgregar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPorcentajeAgregarStateChanged(evt);
            }
        });

        numCantidadAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        numPrecioVentaAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        numPrecioVentaAgregar.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 2.147483647E9d, 1.0d));
        numPrecioVentaAgregar.setDoubleBuffered(true);
        numPrecioVentaAgregar.setEnabled(false);

        numPrecioCompraAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        numPrecioCompraAgregar.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E26d, 1.0d));
        numPrecioCompraAgregar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPrecioCompraAgregarStateChanged(evt);
            }
        });

        btnCancelarAgregar.setText("Cancelar");
        btnCancelarAgregar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgregarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblCodProductoAgregar.setBackground(new java.awt.Color(254, 254, 254));
        lblCodProductoAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCodProductoAgregar.setText("Código del producto:");

        lblNombreProductoAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblNombreProductoAgregar.setText("Nombre del producto:");

        lblMarcaAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblMarcaAgregar.setText("Marca:");

        lblDescripcionAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblDescripcionAgregar.setText("Descripción:");

        lblPrecioCompraAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPrecioCompraAgregar.setText("Precio de compra:");

        lblPrecioVentaAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPrecioVentaAgregar.setText("Precio de venta:");

        lblCantidadAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCantidadAgregar.setText("Cantidad:");

        lblPorcentajeAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPorcentajeAgregar.setText("Porcentaje:");

        txtCodigoProductoAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtNombreProductoAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtMarcaAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtDescripcionAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblExistenciaAgregar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblExistenciaAgregar.setText("Existencia:");

        chkExistenciaAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlComponentesAgregarLayout = new javax.swing.GroupLayout(pnlComponentesAgregar);
        pnlComponentesAgregar.setLayout(pnlComponentesAgregarLayout);
        pnlComponentesAgregarLayout.setHorizontalGroup(
            pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesAgregarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodProductoAgregar)
                    .addComponent(lblNombreProductoAgregar)
                    .addComponent(lblMarcaAgregar)
                    .addComponent(lblDescripcionAgregar)
                    .addComponent(lblPrecioCompraAgregar)
                    .addComponent(lblPrecioVentaAgregar)
                    .addComponent(lblCantidadAgregar)
                    .addComponent(lblPorcentajeAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlComponentesAgregarLayout.createSequentialGroup()
                        .addComponent(numPorcentajeAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblExistenciaAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkExistenciaAgregar))
                    .addComponent(numPrecioVentaAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(numPrecioCompraAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(txtDescripcionAgregar)
                    .addComponent(txtMarcaAgregar)
                    .addComponent(txtNombreProductoAgregar)
                    .addComponent(numCantidadAgregar)
                    .addComponent(txtCodigoProductoAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        pnlComponentesAgregarLayout.setVerticalGroup(
            pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlComponentesAgregarLayout.createSequentialGroup()
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodProductoAgregar)
                            .addComponent(txtCodigoProductoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreProductoAgregar)
                            .addComponent(txtNombreProductoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarcaAgregar)
                            .addComponent(txtMarcaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcionAgregar)
                            .addComponent(txtDescripcionAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioCompraAgregar)
                            .addComponent(numPrecioCompraAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioVentaAgregar)
                            .addComponent(numPrecioVentaAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantidadAgregar)
                            .addComponent(numCantidadAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkExistenciaAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlComponentesAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPorcentajeAgregar)
                                .addComponent(numPorcentajeAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblExistenciaAgregar))))
                    .addGroup(pnlComponentesAgregarLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pnlAgregarProducto.add(pnlComponentesAgregar, java.awt.BorderLayout.CENTER);
        pnlComponentesAgregar.getAccessibleContext().setAccessibleName("Datos a modificar");

        tabAgregarProducto.addTab("Agregar producto", pnlAgregarProducto);

        pnlModificarProductos.setBackground(new java.awt.Color(242, 242, 242));
        pnlModificarProductos.setBorderColor(new java.awt.Color(1, 1, 1));

        pnlComponentesModificar.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos a registrar"));
        pnlComponentesModificar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        numPorcentajeModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        numPorcentajeModificar.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        numPorcentajeModificar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPorcentajeModificarStateChanged(evt);
            }
        });

        numCantidadModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        numPrecioVentaModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        numPrecioVentaModificar.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E45d, 1.0d));
        numPrecioVentaModificar.setDoubleBuffered(true);
        numPrecioVentaModificar.setEnabled(false);

        numPrecioCompraModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        numPrecioCompraModificar.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E46d, 1.0d));
        numPrecioCompraModificar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPrecioCompraModificarStateChanged(evt);
            }
        });

        btnCancelarModificar.setText("Cancelar");
        btnCancelarModificar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnCancelarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarModificarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblCodigoProductoModificar.setBackground(new java.awt.Color(254, 254, 254));
        lblCodigoProductoModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCodigoProductoModificar.setText("Código del producto:");

        lblNombreProductoModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblNombreProductoModificar.setText("Nombre del producto:");

        lblMarcaModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblMarcaModificar.setText("Marca:");

        lblDescripcionModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblDescripcionModificar.setText("Descripción:");

        lblPrecioCompraModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPrecioCompraModificar.setText("Precio de compra:");

        lblPrecioVentaModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPrecioVentaModificar.setText("Precio de venta:");

        lblCantidadModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCantidadModificar.setText("Cantidad:");

        lblPorcentaje.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPorcentaje.setText("Porcentaje:");

        txtCodigoProductoModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtNombreProductoModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtMarcaModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtDescripcionModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        txtNumeroRegistro.setEditable(false);
        txtNumeroRegistro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("N° Registro:");

        lblExistenciaModificar.setBackground(new java.awt.Color(0, 0, 0));
        lblExistenciaModificar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblExistenciaModificar.setText("Existencia:");

        chkExistenciaModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlComponentesModificarLayout = new javax.swing.GroupLayout(pnlComponentesModificar);
        pnlComponentesModificar.setLayout(pnlComponentesModificarLayout);
        pnlComponentesModificarLayout.setHorizontalGroup(
            pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesModificarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigoProductoModificar)
                    .addComponent(lblNombreProductoModificar)
                    .addComponent(lblMarcaModificar)
                    .addComponent(lblDescripcionModificar)
                    .addComponent(lblPrecioCompraModificar)
                    .addComponent(lblPrecioVentaModificar)
                    .addComponent(lblCantidadModificar)
                    .addComponent(lblPorcentaje)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlComponentesModificarLayout.createSequentialGroup()
                        .addComponent(numPorcentajeModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblExistenciaModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkExistenciaModificar))
                    .addComponent(numPrecioVentaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(numPrecioCompraModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(txtDescripcionModificar)
                    .addComponent(txtMarcaModificar)
                    .addComponent(txtNombreProductoModificar)
                    .addComponent(txtCodigoProductoModificar)
                    .addComponent(txtNumeroRegistro)
                    .addComponent(numCantidadModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnCancelarModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlComponentesModificarLayout.setVerticalGroup(
            pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelarModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlComponentesModificarLayout.createSequentialGroup()
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoProductoModificar)
                            .addComponent(txtCodigoProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreProductoModificar)
                            .addComponent(txtNombreProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarcaModificar)
                            .addComponent(txtMarcaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcionModificar)
                            .addComponent(txtDescripcionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioCompraModificar)
                            .addComponent(numPrecioCompraModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioVentaModificar)
                            .addComponent(numPrecioVentaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantidadModificar)
                            .addComponent(numCantidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkExistenciaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlComponentesModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPorcentaje)
                                .addComponent(numPorcentajeModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblExistenciaModificar)))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pnlModificarProductos.add(pnlComponentesModificar, java.awt.BorderLayout.CENTER);

        tabAgregarProducto.addTab("Modificar productos", pnlModificarProductos);

        pnlPrincipal.add(tabAgregarProducto, java.awt.BorderLayout.CENTER);

        pnlTablaRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos registrados"));
        pnlTablaRegistros.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        tblRegistros.setBackground(new java.awt.Color(242, 242, 242));
        tblRegistros.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblRegistros.setModel(modelo);
        tblRegistros.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tblRegistrosComponentMoved(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout pnlTablaRegistrosLayout = new javax.swing.GroupLayout(pnlTablaRegistros);
        pnlTablaRegistros.setLayout(pnlTablaRegistrosLayout);
        pnlTablaRegistrosLayout.setHorizontalGroup(
            pnlTablaRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlTablaRegistrosLayout.setVerticalGroup(
            pnlTablaRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        tlbOpciones.setFloatable(false);
        tlbOpciones.setRollover(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        tlbOpciones.add(btnEliminar);
        tlbOpciones.add(jSeparator1);

        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        tlbOpciones.add(btnActualizar);
        tlbOpciones.add(jSeparator2);

        lblFiltrar.setText("Filtrar:");
        tlbOpciones.add(lblFiltrar);

        txtFiltroDatos.setPreferredSize(new java.awt.Dimension(150, 28));
        tlbOpciones.add(txtFiltroDatos);
        tlbOpciones.add(jSeparator3);

        lblOpcionesBusqueda.setText("Opciones de búsqueda:");
        tlbOpciones.add(lblOpcionesBusqueda);

        cmbOpcionesBusquedaAgregar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Por código", "Por descripción", "Por marca" }));
        cmbOpcionesBusquedaAgregar.setPreferredSize(new java.awt.Dimension(150, 28));
        tlbOpciones.add(cmbOpcionesBusquedaAgregar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTablaRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tlbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tlbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablaRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgregarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarAgregarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtCodigoProductoAgregar.getText().equals("") && txtDescripcionAgregar.getText().equals("") && txtMarcaAgregar.getText().equals("") && txtNombreProductoAgregar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor coriija para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fecha = hourdateFormat.format(date);
                String existencia = "true";
                double precioVenta = Double.parseDouble(numPrecioVentaAgregar.getValue().toString());
                double precioCompra = Double.parseDouble(numPrecioCompraAgregar.getValue().toString());
                int cantidad = Integer.parseInt(numCantidadAgregar.getValue().toString());
                Inventario oInventario = new Inventario(1, txtCodigoProductoAgregar.getText(), txtNombreProductoAgregar.getText(), txtMarcaAgregar.getText(), txtDescripcionAgregar.getText(), precioCompra, precioVenta, existencia, cantidad, fecha);
                oInventarioD.insertarProducto(oInventario);
                if (oInventarioD.isError()) {
                    JOptionPane.showMessageDialog(null,
                            "Error consultando a la base de datos, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    txtCodigoProductoAgregar.setText("");
                    txtDescripcionAgregar.setText("");
                    txtMarcaAgregar.setText("");
                    txtNombreProductoAgregar.setText("");
                    numCantidadAgregar.setValue(0);
                    numPorcentajeAgregar.setValue(0);
                    numPrecioCompraAgregar.setValue(0);
                    numPrecioVentaAgregar.setValue(0);
                    this.refrescar();
                    JOptionPane.showMessageDialog(null,
                            "Producto agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException | HeadlessException xp) {
                JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarSeleccion();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        refrescar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarModificarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarModificarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtNumeroRegistro.getText().equals("") || txtCodigoProductoModificar.getText().equals("") || txtDescripcionModificar.getText().equals("")
                || txtMarcaModificar.getText().equals("") || txtNombreProductoModificar.getText().equals("") || numCantidadModificar.getValue().equals(0)
                || numPorcentajeModificar.getValue().equals(0) || numPrecioCompraModificar.getValue().equals(0) || numPrecioVentaModificar.getValue().equals(0)) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor corrija para continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Date date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fecha = hourdateFormat.format(date);
                String existencia;
                double precioVenta = Double.parseDouble(numPrecioVentaModificar.getValue().toString());
                double precioCompra = Double.parseDouble(numPrecioCompraModificar.getValue().toString());
                int cantidad = Integer.parseInt(numCantidadModificar.getValue().toString());
                if (chkExistenciaModificar.isSelected() == true) {
                    existencia = "true";
                } else {
                    existencia = "false";
                }
                Inventario oInventario = new Inventario(
                        Integer.parseInt(txtNumeroRegistro.getText()), txtCodigoProductoModificar.getText(),
                        txtNombreProductoModificar.getText(), txtMarcaModificar.getText(), txtDescripcionModificar.getText(),
                        precioCompra, precioVenta, existencia, cantidad, fecha
                );
                oInventarioD.actualizarProducto(oInventario, txtNumeroRegistro.getText());
                if (oInventarioD.isError()) {
                    JOptionPane.showMessageDialog(null,
                            "Error al intentar modificar el producto, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Producto modificado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                setVisible(false);
            } catch (NumberFormatException | HeadlessException xp) {
                JOptionPane.showMessageDialog(null, "Problema en algunos de los campos. Detalle técnico: " + xp.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblRegistrosComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblRegistrosComponentMoved

    }//GEN-LAST:event_tblRegistrosComponentMoved

    private void numPrecioCompraAgregarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPrecioCompraAgregarStateChanged
        // TODO add your handling code here:
         /*
         Este evento se encarga de calcular el precio de venta despues de
         ingresar el porcentaje y el precio de compra
         */
        try {
            if (Double.parseDouble(numPrecioCompraAgregar.getValue().toString()) < 0) {
                numPrecioCompraAgregar.setValue(0);
            } else {
                double precioCompra = Double.parseDouble(numPrecioCompraAgregar.getValue().toString());
                double porcentaje = Double.parseDouble(numPorcentajeAgregar.getValue().toString());
                double precioVenta = precioCompra * ((100 + porcentaje) / 100);
                numPrecioVentaAgregar.setValue(precioVenta);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPrecioCompraAgregarStateChanged

    private void numPorcentajeAgregarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPorcentajeAgregarStateChanged
        // TODO add your handling code here:
        try {
            if (Double.parseDouble(numPrecioCompraAgregar.getValue().toString()) < 0) {
                numPrecioCompraAgregar.setValue(0);
            } else {
                double precioCompra = Double.parseDouble(numPrecioCompraAgregar.getValue().toString());
                double porcentaje = Double.parseDouble(numPorcentajeAgregar.getValue().toString());
                double precioVenta = precioCompra * ((100 + porcentaje) / 100);
                numPrecioVentaAgregar.setValue(precioVenta);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPorcentajeAgregarStateChanged

    private void numPrecioCompraModificarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPrecioCompraModificarStateChanged
        // TODO add your handling code here:
                /*
         Este evento se encarga de calcular el precio de venta despues de
         ingresar el porcentaje y el precio de compra
         */
        try {
            if (Double.parseDouble(numPrecioCompraModificar.getValue().toString()) < 0) {
                numPrecioCompraModificar.setValue(0);
            } else {
                double precioCompra = Double.parseDouble(numPrecioCompraModificar.getValue().toString());
                double porcentaje = Double.parseDouble(numPorcentajeModificar.getValue().toString());
                double precioVenta = precioCompra * ((100 + porcentaje) / 100);
                numPrecioVentaModificar.setValue(precioVenta);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPrecioCompraModificarStateChanged

    private void numPorcentajeModificarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPorcentajeModificarStateChanged
        // TODO add your handling code here:
        try {
            if (Double.parseDouble(numPrecioCompraModificar.getValue().toString()) < 0) {
                numPrecioCompraModificar.setValue(0);
            } else {
                double precioCompra = Double.parseDouble(numPrecioCompraModificar.getValue().toString());
                double porcentaje = Double.parseDouble(numPorcentajeModificar.getValue().toString());
                double precioVenta = precioCompra * ((100 + porcentaje) / 100);
                numPrecioVentaModificar.setValue(precioVenta);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPorcentajeModificarStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonSeven btnActualizar;
    private org.edisoncor.gui.button.ButtonAction btnAgregar;
    private org.edisoncor.gui.button.ButtonAction btnCancelarAgregar;
    private org.edisoncor.gui.button.ButtonAction btnCancelarModificar;
    private org.edisoncor.gui.button.ButtonSeven btnEliminar;
    private org.edisoncor.gui.button.ButtonAction btnModificar;
    private javax.swing.JCheckBox chkExistenciaAgregar;
    private javax.swing.JCheckBox chkExistenciaModificar;
    private javax.swing.JComboBox cmbOpcionesBusquedaAgregar;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JLabel lblCantidadAgregar;
    private javax.swing.JLabel lblCantidadModificar;
    private javax.swing.JLabel lblCodProductoAgregar;
    private javax.swing.JLabel lblCodigoProductoModificar;
    private javax.swing.JLabel lblDescripcionAgregar;
    private javax.swing.JLabel lblDescripcionModificar;
    private javax.swing.JLabel lblExistenciaAgregar;
    private javax.swing.JLabel lblExistenciaModificar;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblMarcaAgregar;
    private javax.swing.JLabel lblMarcaModificar;
    private javax.swing.JLabel lblNombreProductoAgregar;
    private javax.swing.JLabel lblNombreProductoModificar;
    private javax.swing.JLabel lblOpcionesBusqueda;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblPorcentajeAgregar;
    private javax.swing.JLabel lblPrecioCompraAgregar;
    private javax.swing.JLabel lblPrecioCompraModificar;
    private javax.swing.JLabel lblPrecioVentaAgregar;
    private javax.swing.JLabel lblPrecioVentaModificar;
    private javax.swing.JSpinner numCantidadAgregar;
    private javax.swing.JSpinner numCantidadModificar;
    private javax.swing.JSpinner numPorcentajeAgregar;
    private javax.swing.JSpinner numPorcentajeModificar;
    private javax.swing.JSpinner numPrecioCompraAgregar;
    private javax.swing.JSpinner numPrecioCompraModificar;
    private javax.swing.JSpinner numPrecioVentaAgregar;
    private javax.swing.JSpinner numPrecioVentaModificar;
    private org.edisoncor.gui.panel.PanelNice pnlAgregarProducto;
    private org.edisoncor.gui.panel.PanelShadow pnlComponentesAgregar;
    private org.edisoncor.gui.panel.PanelShadow pnlComponentesModificar;
    private org.edisoncor.gui.panel.PanelNice pnlModificarProductos;
    private org.edisoncor.gui.panel.PanelNice pnlPrincipal;
    private javax.swing.JPanel pnlTablaRegistros;
    private org.edisoncor.gui.tabbedPane.TabbedSelector2 tabAgregarProducto;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JToolBar tlbOpciones;
    private javax.swing.JTextField txtCodigoProductoAgregar;
    private javax.swing.JTextField txtCodigoProductoModificar;
    private javax.swing.JTextField txtDescripcionAgregar;
    private javax.swing.JTextField txtDescripcionModificar;
    private javax.swing.JTextField txtFiltroDatos;
    private javax.swing.JTextField txtMarcaAgregar;
    private javax.swing.JTextField txtMarcaModificar;
    private javax.swing.JTextField txtNombreProductoAgregar;
    private javax.swing.JTextField txtNombreProductoModificar;
    private javax.swing.JTextField txtNumeroRegistro;
    // End of variables declaration//GEN-END:variables
}

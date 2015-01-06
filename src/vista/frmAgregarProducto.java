/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.InventarioD;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import logica.Inventario;

/**
 *
 * @author Ignacio
 */
public class frmAgregarProducto extends javax.swing.JDialog {

    private InventarioD oInventarioD;
    private AccesoDatosMySql cnx;
    private Date date;

    public frmAgregarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        initComponents();
        date = new Date();
        oInventarioD = new InventarioD(pCnx);
        cnx = pCnx;
        refrescar();
        establecerAnchos();
        tbleRegsitros.setAutoResizeMode(tbleRegsitros.AUTO_RESIZE_ALL_COLUMNS);
        setLocationRelativeTo(null);
        setJTexFieldChanged(txtFiltroBusqueda);
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

    public void establecerAnchos() {
        try {
            //declaramos un arreglo de enteros con los anchos que deseamo
//para nuestra tabla
            int[] anchos = {45, 60, 45, 35, 200, 40, 40, 40, 40, 40};
//hacemos un bucle FOR desde cero hasta la cantidad de columnas
//de nuestra tabla
            for (int i = 0; i < tbleRegsitros.getColumnCount(); i++) {
//Sacamos el modelo de columnas de nuestra tabla
//luego obtenemos la columna en la posicion "i"
//invocamos el metodo setPreferrefWidth para ajustar el ancho
//y le damos el valor del entero que esta en el arreglo en la posicion "i"
                tbleRegsitros.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, xp.getMessage());
        }
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
                opcion = "Codigo_Articulo";
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
        ArrayList registros = (ArrayList) oInventarioD.filtrarInventario(pFiltro, pOpcion);
        if (oInventarioD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oInventarioD.getErrorMsg());
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
            this.tbleRegsitros.setModel(modelo);
        }
    }
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void close() {
        setVisible(false);
    }
    private String[] cabeceras = {"N° Registro", "Código", "Nombre", "Marca", "Descripción", "Precio de compra", "Precio de venta", "Existencia", "Cantidad", "Fecha de entrada"};
    private String[][] datos = new String[0][10];

    private void refrescar() {
        ArrayList registros = (ArrayList) oInventarioD.consultarRegistro();
        if (oInventarioD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oInventarioD.getErrorMsg());
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
            this.tbleRegsitros.setModel(modelo);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClickDerecho = new javax.swing.JPopupMenu();
        subActualizar = new javax.swing.JMenuItem();
        subCopiarDatoCelda = new javax.swing.JMenuItem();
        subEliminar = new javax.swing.JMenuItem();
        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        pnlDatos = new org.edisoncor.gui.panel.Panel();
        lblCodProducto = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblPrecioCompra = new javax.swing.JLabel();
        lblPrecioVenta = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblExistencia = new javax.swing.JLabel();
        txtCodProducto = new org.edisoncor.gui.textField.TextField();
        txtNombre = new org.edisoncor.gui.textField.TextField();
        txtMarca = new org.edisoncor.gui.textField.TextField();
        txtDescripcion = new org.edisoncor.gui.textField.TextField();
        numPrecioCompra = new javax.swing.JSpinner();
        numPrecioVenta = new javax.swing.JSpinner();
        numCantidad = new javax.swing.JSpinner();
        numPorcentaje = new javax.swing.JSpinner();
        lblSignoPorcentaje = new javax.swing.JLabel();
        chkExistencia = new javax.swing.JCheckBox();
        btnRegistrar = new org.edisoncor.gui.button.ButtonAction();
        btnCancelar = new org.edisoncor.gui.button.ButtonAction();
        pnlCntenedorTabla = new org.edisoncor.gui.panel.PanelRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbleRegsitros = new javax.swing.JTable();
        pnlOpciones = new java.awt.Panel();
        jtbOpciones = new javax.swing.JToolBar();
        btnModificar = new javax.swing.JButton();
        sptUno = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        sptDos = new javax.swing.JToolBar.Separator();
        btnActualizar = new javax.swing.JButton();
        sptTres = new javax.swing.JToolBar.Separator();
        lblBuscarProducto = new javax.swing.JLabel();
        txtFiltroBusqueda = new javax.swing.JTextField();
        sptCuatro = new javax.swing.JToolBar.Separator();
        lblOpcionesBusqueda = new javax.swing.JLabel();
        cmbOpcionesBusqueda = new javax.swing.JComboBox();

        subActualizar.setText("Actualizar");
        subActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        subActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActualizarActionPerformed(evt);
            }
        });
        menuClickDerecho.add(subActualizar);

        subCopiarDatoCelda.setText("Copiar dato de la celda");
        subCopiarDatoCelda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subCopiarDatoCeldaActionPerformed(evt);
            }
        });
        menuClickDerecho.add(subCopiarDatoCelda);

        subEliminar.setText("Eliminar");
        subEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subEliminarActionPerformed(evt);
            }
        });
        menuClickDerecho.add(subEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar producto");

        pnlBackground.setBackground(new java.awt.Color(138, 138, 138));

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));
        pnlDatos.setForeground(new java.awt.Color(255, 255, 255));
        pnlDatos.setColorPrimario(new java.awt.Color(153, 153, 153));
        pnlDatos.setColorSecundario(new java.awt.Color(255, 255, 255));

        lblCodProducto.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblCodProducto.setText("Código del producto:");

        lblNombre.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblMarca.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblMarca.setText("Marca:");

        lblDescripcion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblDescripcion.setText("Descripción:");

        lblPrecioCompra.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblPrecioCompra.setText("Precio de compra:");

        lblPrecioVenta.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblPrecioVenta.setText("Precio de venta:");

        lblCantidad.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblCantidad.setText("Cantidad:");

        lblPorcentaje.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblPorcentaje.setText("Porcentaje:");

        lblExistencia.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblExistencia.setText("Existencia:");

        txtCodProducto.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtMarca.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N

        numPrecioCompra.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPrecioCompra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPrecioCompraStateChanged(evt);
            }
        });

        numPrecioVenta.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPrecioVenta.setEnabled(false);

        numCantidad.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        numPorcentaje.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPorcentajeStateChanged(evt);
            }
        });

        lblSignoPorcentaje.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblSignoPorcentaje.setText("%");

        chkExistencia.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        btnRegistrar.setText("Registrar");
        btnRegistrar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPrecioVenta)
                                    .addComponent(lblCantidad)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblPrecioCompra)
                                    .addComponent(lblMarca)
                                    .addComponent(lblNombre))
                                .addGap(1, 1, 1)))
                        .addGap(19, 19, 19)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(numCantidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(lblExistencia)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkExistencia))
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(lblPorcentaje)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblSignoPorcentaje))))
                            .addComponent(numPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblCodProducto)
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodProducto)
                            .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarca))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescripcion))
                .addGap(12, 12, 12)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioCompra))
                .addGap(10, 10, 10)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioVenta)
                    .addComponent(lblPorcentaje)
                    .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSignoPorcentaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCantidad)
                        .addComponent(lblExistencia))
                    .addComponent(chkExistencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbleRegsitros.setComponentPopupMenu(menuClickDerecho);
        jScrollPane1.setViewportView(tbleRegsitros);

        javax.swing.GroupLayout pnlCntenedorTablaLayout = new javax.swing.GroupLayout(pnlCntenedorTabla);
        pnlCntenedorTabla.setLayout(pnlCntenedorTablaLayout);
        pnlCntenedorTablaLayout.setHorizontalGroup(
            pnlCntenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCntenedorTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlCntenedorTablaLayout.setVerticalGroup(
            pnlCntenedorTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCntenedorTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        jtbOpciones.setFloatable(false);
        jtbOpciones.setRollover(true);

        btnModificar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jtbOpciones.add(btnModificar);
        jtbOpciones.add(sptUno);

        btnEliminar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jtbOpciones.add(btnEliminar);
        jtbOpciones.add(sptDos);

        btnActualizar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jtbOpciones.add(btnActualizar);
        jtbOpciones.add(sptTres);

        lblBuscarProducto.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblBuscarProducto.setText("Buscar producto:");
        jtbOpciones.add(lblBuscarProducto);

        txtFiltroBusqueda.setName(""); // NOI18N
        txtFiltroBusqueda.setPreferredSize(new java.awt.Dimension(150, 27));
        txtFiltroBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFiltroBusquedaMouseClicked(evt);
            }
        });
        txtFiltroBusqueda.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtFiltroBusquedaVetoableChange(evt);
            }
        });
        jtbOpciones.add(txtFiltroBusqueda);
        jtbOpciones.add(sptCuatro);

        lblOpcionesBusqueda.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblOpcionesBusqueda.setText("Opciones de búsqueda:");
        jtbOpciones.add(lblOpcionesBusqueda);

        cmbOpcionesBusqueda.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        cmbOpcionesBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Descripción", "Marca" }));
        cmbOpcionesBusqueda.setPreferredSize(new java.awt.Dimension(150, 27));
        cmbOpcionesBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOpcionesBusquedaActionPerformed(evt);
            }
        });
        jtbOpciones.add(cmbOpcionesBusqueda);

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addComponent(jtbOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCntenedorTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlCntenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (this.datos.length > 0) {
            int fila = this.tbleRegsitros.getSelectedRow();
            if (fila >= 0) {
                frmEditarProducto oEdit = new frmEditarProducto(null, rootPaneCheckingEnabled, cnx,
                        datos[fila][0], datos[fila][1], datos[fila][2], datos[fila][3], datos[fila][4],
                        Double.parseDouble(datos[fila][5]), Double.parseDouble(datos[fila][6]),
                        Boolean.parseBoolean(datos[fila][7]), Integer.parseInt(datos[fila][8]));
                oEdit.setVisible(true);
                if (oEdit.isAceptar()) {
                    refrescar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún registro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = this.tbleRegsitros.getSelectedRow();
            if (this.datos.length > 0) {
                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (respuesta == JOptionPane.YES_OPTION) {

                        Inventario oInventario = new Inventario(
                                Integer.parseInt(this.datos[fila][0]), this.datos[fila][1], this.datos[fila][2],
                                this.datos[fila][3], this.datos[fila][4], Double.parseDouble(this.datos[fila][5]),
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
                        "No hay registros en la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error inesperado durante el proceso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        refrescar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtFiltroBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltroBusquedaMouseClicked
        // TODO add your handling code here:
        txtFiltroBusqueda.setEditable(true);
    }//GEN-LAST:event_txtFiltroBusquedaMouseClicked

    private void txtFiltroBusquedaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtFiltroBusquedaVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroBusquedaVetoableChange

    private void cmbOpcionesBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOpcionesBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOpcionesBusquedaActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txtCodProducto.getText().equals("") && txtDescripcion.getText().equals("") && txtMarca.getText().equals("") && txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor coriija para continuar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            date = new Date();
            DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fecha = hourdateFormat.format(date);
            String existencia = "";
            double precioVenta = Double.parseDouble(numPrecioVenta.getValue().toString());
            double precioCompra = Double.parseDouble(numPrecioCompra.getValue().toString());
            int cantidad = Integer.parseInt(numCantidad.getValue().toString());
            if (chkExistencia.isSelected() == true) {
                existencia = "true";
            } else {
                existencia = "false";
            }
            Inventario oInventario = new Inventario(0, txtCodProducto.getText(), txtNombre.getText(), txtMarca.getText(), txtDescripcion.getText(), precioCompra, precioVenta, existencia, cantidad, fecha);
            oInventarioD.insertarProducto(oInventario);
            if (oInventarioD.isError()) {
                JOptionPane.showMessageDialog(null,
                        "Error consultando a la base de datos, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                txtCodProducto.setText("");
                txtDescripcion.setText("");
                txtMarca.setText("");
                txtNombre.setText("");
                numCantidad.setValue(0);
                numPorcentaje.setValue(0);
                numPrecioCompra.setValue(0);
                numPrecioVenta.setValue(0);
                chkExistencia.setSelected(false);
                this.refrescar();
                JOptionPane.showMessageDialog(null,
                        "Producto agregado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void subActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActualizarActionPerformed
        // TODO add your handling code here:
        refrescar();
    }//GEN-LAST:event_subActualizarActionPerformed

    private void subCopiarDatoCeldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCopiarDatoCeldaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subCopiarDatoCeldaActionPerformed

    private void subEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = this.tbleRegsitros.getSelectedRow();
            if (this.datos.length > 0) {
                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (respuesta == JOptionPane.YES_OPTION) {

                        Inventario oInventario = new Inventario(Integer.parseInt(this.datos[fila][0]), this.datos[fila][1], this.datos[fila][2],
                                this.datos[fila][3], this.datos[fila][4], Double.parseDouble(this.datos[fila][5]),
                                Double.parseDouble(this.datos[fila][6]), this.datos[fila][7], Integer.parseInt(this.datos[fila][8].toString()),
                                this.datos[fila][9]);
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
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error inesperado durante el proceso.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_subEliminarActionPerformed

    private void numPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPorcentajeStateChanged
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            if (Double.parseDouble(numPorcentaje.getValue().toString()) < 0 || Double.parseDouble(numPorcentaje.getValue().toString()) > 100) {
                numPorcentaje.setValue(0);
            } else {
                double precioCompra = Double.parseDouble(numPrecioCompra.getValue().toString());
                double porcentaje = Double.parseDouble(numPorcentaje.getValue().toString());
                double precioVenta = precioCompra * ((100 + porcentaje) / 100);
                numPrecioVenta.setValue(precioVenta);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPorcentajeStateChanged

    private void numPrecioCompraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPrecioCompraStateChanged
        // TODO add your handling code here:
        try {
            if (Double.parseDouble(numPrecioCompra.getValue().toString()) < 0) {
                numPrecioCompra.setValue(0);
            } else {
                double precioCompra = Double.parseDouble(numPrecioCompra.getValue().toString());
                double porcentaje = Double.parseDouble(numPorcentaje.getValue().toString());
                double precioVenta = precioCompra * ((100 + porcentaje) / 100);
                numPrecioVenta.setValue(precioVenta);
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPrecioCompraStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private org.edisoncor.gui.button.ButtonAction btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private org.edisoncor.gui.button.ButtonAction btnRegistrar;
    private javax.swing.JCheckBox chkExistencia;
    private javax.swing.JComboBox cmbOpcionesBusqueda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jtbOpciones;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodProducto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOpcionesBusqueda;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblPrecioCompra;
    private javax.swing.JLabel lblPrecioVenta;
    private javax.swing.JLabel lblSignoPorcentaje;
    private javax.swing.JPopupMenu menuClickDerecho;
    private javax.swing.JSpinner numCantidad;
    private javax.swing.JSpinner numPorcentaje;
    private javax.swing.JSpinner numPrecioCompra;
    private javax.swing.JSpinner numPrecioVenta;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private org.edisoncor.gui.panel.PanelRect pnlCntenedorTabla;
    private org.edisoncor.gui.panel.Panel pnlDatos;
    private java.awt.Panel pnlOpciones;
    private javax.swing.JToolBar.Separator sptCuatro;
    private javax.swing.JToolBar.Separator sptDos;
    private javax.swing.JToolBar.Separator sptTres;
    private javax.swing.JToolBar.Separator sptUno;
    private javax.swing.JMenuItem subActualizar;
    private javax.swing.JMenuItem subCopiarDatoCelda;
    private javax.swing.JMenuItem subEliminar;
    private javax.swing.JTable tbleRegsitros;
    private org.edisoncor.gui.textField.TextField txtCodProducto;
    private org.edisoncor.gui.textField.TextField txtDescripcion;
    private javax.swing.JTextField txtFiltroBusqueda;
    private org.edisoncor.gui.textField.TextField txtMarca;
    private org.edisoncor.gui.textField.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

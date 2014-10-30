/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logica.*;
import logica.Tarjeta_Cliente_Prepago;
import org.edisoncor.gui.Dialogo;
import org.edisoncor.gui.panel.PanelGlassTinte;

/**
 *
 * @author ignacio
 */
public class frmAgregarProducto extends javax.swing.JDialog {

    private boolean aceptar = false;
    private boolean opcion1 = false;
    private boolean opcion2 = false;
    private InventarioD oInventarioD;
    private AccesoDatosMySql cnx;
    Date date;

    public frmAgregarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pConexion) {
        super(parent, modal);
        initComponents();
        oInventarioD = new InventarioD(pConexion);
        cnx = pConexion;
        refrescar();
        setLocationRelativeTo(null); 
    }
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private String[] cabeceras = {"Código", "Nombre", "Marca", "Descripción", "Precio de compra", "Precio de venta", "Existencia", "Cantidad", "Fecha de entrada"};
    private String[][] datos = new String[0][9];

    private void refrescar() {
        ArrayList tarjetas = (ArrayList) oInventarioD.consultarRegistro();
        if (oInventarioD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oInventarioD.getErrorMsg());
        } else {
            this.datos = new String[tarjetas.size()][9];
            for (int i = 0; i < tarjetas.size(); i++) {
                Inventario aux = (Inventario) tarjetas.get(i);
                this.datos[i][0] = aux.getCodProducto();
                this.datos[i][1] = aux.getNombre();
                this.datos[i][2] = aux.getMarca();
                this.datos[i][3] = aux.getDescripcion();
                this.datos[i][4] = String.valueOf(aux.getPrecioCompra());
                this.datos[i][5] = String.valueOf(aux.getPrecioVenta());
                this.datos[i][6] = aux.getExistencia();
                this.datos[i][7] = String.valueOf(aux.getCantidad());
                this.datos[i][8] = aux.getFechaEntrada();

            }
            this.modelo.setDataVector(datos, cabeceras);
            this.tblRegistros.setModel(modelo);
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
        subEditar = new javax.swing.JMenuItem();
        subEliminar = new javax.swing.JMenuItem();
        grbRegistros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        grbDatos = new javax.swing.JPanel();
        lblCodigoProducto = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecioCompra = new javax.swing.JLabel();
        lblPrecioVenta = new javax.swing.JLabel();
        numPrecioCompra = new javax.swing.JSpinner();
        numPrecioVenta = new javax.swing.JSpinner();
        lblExistencia = new javax.swing.JLabel();
        chkExistencia = new javax.swing.JCheckBox();
        lblCantidad = new javax.swing.JLabel();
        numCantidad = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblPorcentaje = new javax.swing.JLabel();
        numPorcentaje = new javax.swing.JSpinner();
        lblSignoPorcentaje = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btnModificar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnActualizar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        lblBuscarProducto = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        lblOpcionesBusqueda = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

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

        subEditar.setText("Editar");
        subEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subEditarActionPerformed(evt);
            }
        });
        menuClickDerecho.add(subEditar);

        subEliminar.setText("Eliminar");
        subEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subEliminarActionPerformed(evt);
            }
        });
        menuClickDerecho.add(subEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar productos");

        grbRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros"));

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRegistros.setComponentPopupMenu(menuClickDerecho);
        tblRegistros.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblRegistrosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout grbRegistrosLayout = new javax.swing.GroupLayout(grbRegistros);
        grbRegistros.setLayout(grbRegistrosLayout);
        grbRegistrosLayout.setHorizontalGroup(
            grbRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        grbRegistrosLayout.setVerticalGroup(
            grbRegistrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        grbDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        lblCodigoProducto.setText("Códio del producto:");

        lblDescripcion.setText("Descripción:");

        lblNombre.setText("Nombre:");

        lblMarca.setText("Marca:");

        txtCodigoProducto.setToolTipText("Edite el código de barras del producto para registrarlo");

        txtNombre.setToolTipText("Nombre común del producto");

        txtMarca.setToolTipText("Marca del producto a registrar");

        txtDescripcion.setToolTipText("Descripción total del producto");

        lblPrecioCompra.setText("Precio de compra:");

        lblPrecioVenta.setText("Precio de venta:");

        numPrecioCompra.setToolTipText("Precio costo del producto sin impuesto");
        numPrecioCompra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPrecioCompraStateChanged(evt);
            }
        });

        numPrecioVenta.setEnabled(false);

        lblExistencia.setText("Existencia:");

        chkExistencia.setToolTipText("Valida si el producto existe en el inventario");

        lblCantidad.setText("Cantidad:");

        numCantidad.setToolTipText("Cantidad por unidad del producto");
        numCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numCantidadStateChanged(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblPorcentaje.setText("Porcentaje:");

        numPorcentaje.setToolTipText("Cantidad de impuesto o porcentaje de venta del producto");
        numPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPorcentajeStateChanged(evt);
            }
        });

        lblSignoPorcentaje.setText("%");

        javax.swing.GroupLayout grbDatosLayout = new javax.swing.GroupLayout(grbDatos);
        grbDatos.setLayout(grbDatosLayout);
        grbDatosLayout.setHorizontalGroup(
            grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grbDatosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPrecioCompra)
                    .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCodigoProducto)
                        .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(lblPrecioVenta)
                    .addComponent(lblCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grbDatosLayout.createSequentialGroup()
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtMarca)
                            .addComponent(txtDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(grbDatosLayout.createSequentialGroup()
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(grbDatosLayout.createSequentialGroup()
                                .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblExistencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkExistencia))
                            .addGroup(grbDatosLayout.createSequentialGroup()
                                .addComponent(numPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPorcentaje)
                                .addGap(6, 6, 6)
                                .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSignoPorcentaje)))
                        .addGap(0, 551, Short.MAX_VALUE)))
                .addContainerGap())
        );
        grbDatosLayout.setVerticalGroup(
            grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grbDatosLayout.createSequentialGroup()
                .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grbDatosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigoProducto)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioCompra)
                            .addComponent(numPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioVenta)
                            .addComponent(lblPorcentaje)
                            .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSignoPorcentaje))
                        .addGap(18, 18, 18)
                        .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkExistencia)
                            .addGroup(grbDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCantidad)
                                .addComponent(lblExistencia))))
                    .addGroup(grbDatosLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(5, 5, 5)
                        .addComponent(btnCancelar)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnModificar.setText("Modificar");
        btnModificar.setFocusable(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);
        jToolBar1.add(jSeparator1);

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator2);

        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);
        jToolBar1.add(jSeparator3);

        lblBuscarProducto.setText("Buscar producto:");
        jToolBar1.add(lblBuscarProducto);

        txtBuscarProducto.setText("Escriba aquí el dato para filtrar");
        txtBuscarProducto.setName(""); // NOI18N
        txtBuscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarProductoMouseClicked(evt);
            }
        });
        txtBuscarProducto.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtBuscarProductoVetoableChange(evt);
            }
        });
        jToolBar1.add(txtBuscarProducto);
        jToolBar1.add(jSeparator4);

        lblOpcionesBusqueda.setText("Opciones de búsqueda:");
        jToolBar1.add(lblOpcionesBusqueda);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Descripción", "Marca" }));
        jToolBar1.add(jComboBox1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(grbRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
            .addComponent(grbDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(grbDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grbRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (txtCodigoProducto.getText().equals("") && txtDescripcion.getText().equals("") && txtMarca.getText().equals("") && txtNombre.getText().equals("")) {
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
            Inventario oInventario = new Inventario(txtCodigoProducto.getText(), txtNombre.getText(), txtMarca.getText(), txtDescripcion.getText(), precioCompra, precioVenta, existencia, cantidad, fecha);
            oInventarioD.insertarProducto(oInventario);
            if (oInventarioD.isError()) {
                JOptionPane.showMessageDialog(null,
                        "Error consultando a la base de datos, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                txtCodigoProducto.setText("");
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
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void numPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPorcentajeStateChanged
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

    private void numCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numCantidadStateChanged
        // TODO add your handling code here:
        if (Double.parseDouble(numCantidad.getValue().toString()) < 0) {
            numCantidad.setValue(0);
        }
    }//GEN-LAST:event_numCantidadStateChanged

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (this.datos.length > 0) {
            int fila = this.tblRegistros.getSelectedRow();
            if (fila >= 0) {
                String pCedulaAnterior = this.datos[fila][0];
                frmEditarProductos oEdit = new frmEditarProductos(null, true,datos[fila][0].toString(),datos[fila][1].toString(),datos[fila][2].toString(),datos[fila][3].toString(),Double.parseDouble(datos[fila][4].toString()),Double.parseDouble(datos[fila][5].toString()),Boolean.parseBoolean(datos[fila][6].toString()),Integer.parseInt(datos[fila][7].toString()));
                oEdit.setVisible(true);
                if (oEdit.isAceptar()) {
                    date = new Date();
                    DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String fecha = hourdateFormat.format(date);
                    String existencia = "";
                    double precioVenta = Double.parseDouble(oEdit.getNumPrecioVenta().getValue().toString());
                    double precioCompra = Double.parseDouble(oEdit.getNumPrecioCompra().getValue().toString());
                    int cantidad = Integer.parseInt(oEdit.getNumCantidad().getValue().toString());
                    if (oEdit.getChkExistencia().isSelected() == true) {
                        existencia = "true";
                    } else {
                        existencia = "false";
                    }
                    Inventario oInventario = new Inventario(oEdit.getTxtCodProducto().getText(), oEdit.getTxtNombreProducto().getText(), oEdit.getTxtMarca().getText(), oEdit.getTxtDescripcion().getText(), precioCompra, precioVenta, existencia, cantidad, fecha);
                    oInventarioD.actualizarProducto(oInventario, oEdit.getTxtCodProducto().getText());
                    if (oInventarioD.isError()) {
                        JOptionPane.showMessageDialog(null,
                                "Error al intentar modificar el producto, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        this.refrescar();
                        JOptionPane.showMessageDialog(null,
                                "Producto modificado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún registro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay registros en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblRegistrosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblRegistrosPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRegistrosPropertyChange

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = this.tblRegistros.getSelectedRow();
            if (this.datos.length > 0) {
                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (respuesta == JOptionPane.YES_OPTION) {

                        Inventario oInventario = new Inventario(this.datos[fila][0], this.datos[fila][1], this.datos[fila][2], this.datos[fila][3], Double.parseDouble(this.datos[fila][4].toString()), Double.parseDouble(this.datos[fila][5].toString()), this.datos[fila][6], Integer.parseInt(this.datos[fila][7].toString()), this.datos[fila][8]);
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
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarProductoMouseClicked
        // TODO add your handling code here:
        txtBuscarProducto.setEditable(true);
    }//GEN-LAST:event_txtBuscarProductoMouseClicked

    private void subActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActualizarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_subActualizarActionPerformed

    private void subCopiarDatoCeldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subCopiarDatoCeldaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subCopiarDatoCeldaActionPerformed

    private void subEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subEditarActionPerformed

    private void subEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = this.tblRegistros.getSelectedRow();
            if (this.datos.length > 0) {
                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (respuesta == JOptionPane.YES_OPTION) {

                        Inventario oInventario = new Inventario(this.datos[fila][0], this.datos[fila][1], this.datos[fila][2], this.datos[fila][3], Double.parseDouble(this.datos[fila][4].toString()), Double.parseDouble(this.datos[fila][5].toString()), this.datos[fila][6], Integer.parseInt(this.datos[fila][7].toString()), this.datos[fila][8]);
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        refrescar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtBuscarProductoVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtBuscarProductoVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductoVetoableChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox chkExistencia;
    private javax.swing.JPanel grbDatos;
    private javax.swing.JPanel grbRegistros;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblBuscarProducto;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigoProducto;
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
    private javax.swing.JMenuItem subActualizar;
    private javax.swing.JMenuItem subCopiarDatoCelda;
    private javax.swing.JMenuItem subEditar;
    private javax.swing.JMenuItem subEliminar;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

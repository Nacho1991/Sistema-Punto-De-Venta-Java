package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.InventarioD;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import logica.Inventario;

public class frmEditarProducto extends javax.swing.JDialog {

    private boolean aceptar;
    private AccesoDatosMySql cnx;
    private InventarioD oInventarioD;

    /*
     Este constructor solamente recibe la conexion de la base de datos
     para despues poder buscar el producto que se desea modificar, este constructor
     se establece cuando se desea editar desde la ventana principal.
     */
    public frmEditarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        cnx = pCnx;
        oInventarioD = new InventarioD(pCnx);
        aceptar = false;
        initComponents();
        setLocationRelativeTo(null);
    }

    /*
     Este metodo se encarga de cargar los datos del producto 
     especificamente seleccionado en la parte o ventana de
     agregar un nuevo producto.
     */
    public frmEditarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx, String pId, String pCodigoProducto, String pNombreProducto,
            String pMarca, String pDescripcion,
            double pPrecioCompra, double pPrecioVenta, boolean pExitencia, int pCantidad) {
        super(parent, modal);
        initComponents();
        oInventarioD = new InventarioD(pCnx);
        setLocationRelativeTo(null);
        btnBuscar.setEnabled(false);
        txtNumeroRegistro.setText(pId);
        txtCodProducto.setText(pCodigoProducto);
        txtNombreProducto.setText(pNombreProducto);
        txtMarca.setText(pMarca);
        txtDescripcion.setText(pDescripcion);
        numPrecioCompra.setValue(pPrecioCompra);
        numPrecioVenta.setValue(pPrecioVenta);
        chkExistencia.setSelected(pExitencia);
        numCantidad.setValue(pCantidad);

    }

    //Gets y Sets
    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    //
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        pnlContenedor = new org.edisoncor.gui.panel.PanelShadow();
        pnlDAtosProducto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        numPrecioCompra = new javax.swing.JSpinner();
        numPrecioVenta = new javax.swing.JSpinner();
        numCantidad = new javax.swing.JSpinner();
        numPorcentaje = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        chkExistencia = new javax.swing.JCheckBox();
        btnBuscar = new org.edisoncor.gui.button.ButtonAction();
        btnLimpiar = new org.edisoncor.gui.button.ButtonAction();
        jLabel11 = new javax.swing.JLabel();
        txtNumeroRegistro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new org.edisoncor.gui.button.ButtonAction();
        btnSalir = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editador de productos");

        pnlBackground.setBackground(new java.awt.Color(240, 240, 240));

        pnlDAtosProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));
        pnlDAtosProducto.setForeground(new java.awt.Color(254, 254, 254));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel1.setText("Código del producto:");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel2.setText("Nombre del producto:");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel4.setText("Descripción:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel5.setText("Precio de compra:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel6.setText("Precio de venta:");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel7.setText("Cantidad:");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel8.setText("Porcentaje:");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel9.setText("Existencia:");

        txtCodProducto.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtNombreProducto.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtMarca.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        numPrecioCompra.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPrecioCompra.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E27d, 1.0d));
        numPrecioCompra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPrecioCompraStateChanged(evt);
            }
        });

        numPrecioVenta.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPrecioVenta.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 1.0E35d, 1.0d));
        numPrecioVenta.setEnabled(false);

        numCantidad.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        numPorcentaje.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        numPorcentaje.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        numPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPorcentajeStateChanged(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel10.setText("%");

        chkExistencia.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        jLabel11.setText("N° Registro:");

        txtNumeroRegistro.setEditable(false);
        txtNumeroRegistro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlDAtosProductoLayout = new javax.swing.GroupLayout(pnlDAtosProducto);
        pnlDAtosProducto.setLayout(pnlDAtosProductoLayout);
        pnlDAtosProductoLayout.setHorizontalGroup(
            pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescripcion)
                    .addComponent(txtMarca)
                    .addComponent(txtNombreProducto)
                    .addComponent(txtCodProducto)
                    .addComponent(txtNumeroRegistro)
                    .addComponent(numPrecioCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, Short.MAX_VALUE)
                    .addComponent(numPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkExistencia)))
                .addGap(109, 109, 109)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDAtosProductoLayout.setVerticalGroup(
            pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNumeroRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9))
                    .addComponent(chkExistencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlDAtosProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                .addGap(0, 367, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContenedorLayout.createSequentialGroup()
                    .addComponent(pnlDAtosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 60, Short.MAX_VALUE)))
        );

        pnlBackground.add(pnlContenedor, java.awt.BorderLayout.CENTER);

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

    private void numPrecioCompraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPrecioCompraStateChanged
        /*
         Este evento se encarga de calcular el precio de venta despues de
         ingresar el porcentaje y el precio de compra
         */
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
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPrecioCompraStateChanged

    private void numPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPorcentajeStateChanged
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
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPorcentajeStateChanged

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txtNumeroRegistro.getText().equals("") || txtCodProducto.getText().equals("") || txtDescripcion.getText().equals("") || txtMarca.getText().equals("") || txtNombreProducto.getText().equals("")
                || numCantidad.getValue().equals(0) || numPorcentaje.getValue().equals(0) || numPrecioCompra.getValue().equals(0) || numPrecioVenta.getValue().equals(0)) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor corrija para continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Date date = new Date();
                DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fecha = hourdateFormat.format(date);
                String existencia;
                double precioVenta = Double.parseDouble(numPrecioVenta.getValue().toString());
                double precioCompra = Double.parseDouble(numPrecioCompra.getValue().toString());
                int cantidad = Integer.parseInt(numCantidad.getValue().toString());
                if (chkExistencia.isSelected() == true) {
                    existencia = "true";
                } else {
                    existencia = "false";
                }
                Inventario oInventario = new Inventario(Integer.parseInt(txtNumeroRegistro.getText()), txtCodProducto.getText(), txtNombreProducto.getText(), txtMarca.getText(), txtDescripcion.getText(), precioCompra, precioVenta, existencia, cantidad, fecha);
                oInventarioD.actualizarProducto(oInventario, txtNumeroRegistro.getText());
                if (oInventarioD.isError()) {
                    JOptionPane.showMessageDialog(null,
                            "Error al intentar modificar el producto, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Producto modificado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                aceptar = true;
                setVisible(false);
            } catch (NumberFormatException | HeadlessException xp) {
                JOptionPane.showMessageDialog(null, "Problema en algunos de los campos. Detalle técnico: " + xp.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscarProducto oSearch = new frmBuscarProducto(null, true, cnx);
        oSearch.setVisible(true);
        if (oSearch.isAceptar()) {
            txtNumeroRegistro.setText(oSearch.getId());
            txtCodProducto.setText(oSearch.getCodigo());
            txtNombreProducto.setText(oSearch.getNombre());
            txtMarca.setText(oSearch.getMarca());
            txtDescripcion.setText(oSearch.getDescripcion());
            numPrecioCompra.setValue(Double.parseDouble(oSearch.getPrecioCompra()));
            numPrecioVenta.setValue(Double.parseDouble(oSearch.getPrecioVenta()));
            numCantidad.setValue(Integer.parseInt(oSearch.getCantidad()));
            chkExistencia.setSelected(Boolean.parseBoolean(oSearch.getExistencia()));
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCodProducto.setText("");
        txtDescripcion.setText("");
        txtMarca.setText("");
        txtNombreProducto.setText("");
        numCantidad.setValue(0);
        numPorcentaje.setValue(0);
        numPrecioCompra.setValue(0);
        numPrecioVenta.setValue(0);
        chkExistencia.setSelected(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    public JCheckBox getChkExistencia() {
        return chkExistencia;
    }

    public void setChkExistencia(JCheckBox chkExistencia) {
        this.chkExistencia = chkExistencia;
    }

    public JSpinner getNumCantidad() {
        return numCantidad;
    }

    public void setNumCantidad(JSpinner numCantidad) {
        this.numCantidad = numCantidad;
    }

    public JSpinner getNumPorcentaje() {
        return numPorcentaje;
    }

    public void setNumPorcentaje(JSpinner numPorcentaje) {
        this.numPorcentaje = numPorcentaje;
    }

    public JSpinner getNumPrecioCompra() {
        return numPrecioCompra;
    }

    public void setNumPrecioCompra(JSpinner numPrecioCompra) {
        this.numPrecioCompra = numPrecioCompra;
    }

    public JSpinner getNumPrecioVenta() {
        return numPrecioVenta;
    }

    public void setNumPrecioVenta(JSpinner numPrecioVenta) {
        this.numPrecioVenta = numPrecioVenta;
    }

    public JTextField getTxtCodProducto() {
        return txtCodProducto;
    }

    public void setTxtCodProducto(JTextField txtCodProducto) {
        this.txtCodProducto = txtCodProducto;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public void setTxtNombreProducto(JTextField txtNombreProducto) {
        this.txtNombreProducto = txtNombreProducto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnBuscar;
    private org.edisoncor.gui.button.ButtonAction btnEditar;
    private org.edisoncor.gui.button.ButtonAction btnLimpiar;
    private org.edisoncor.gui.button.ButtonAction btnSalir;
    private javax.swing.JCheckBox chkExistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner numCantidad;
    private javax.swing.JSpinner numPorcentaje;
    private javax.swing.JSpinner numPrecioCompra;
    private javax.swing.JSpinner numPrecioVenta;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private org.edisoncor.gui.panel.PanelShadow pnlContenedor;
    private javax.swing.JPanel pnlDAtosProducto;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNumeroRegistro;
    // End of variables declaration//GEN-END:variables
}

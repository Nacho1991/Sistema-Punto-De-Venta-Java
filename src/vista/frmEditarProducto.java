package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.InventarioD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import logica.Inventario;
import org.edisoncor.gui.util.WindowDragger;
import org.edisoncor.gui.util.WindowsUtil;

public class frmEditarProducto extends javax.swing.JDialog {

    private boolean aceptar;
    private AccesoDatosMySql cnx;
    private InventarioD oInventarioD;

    public frmEditarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        setUndecorated(true);
        cnx = pCnx;
        oInventarioD = new InventarioD(pCnx);
        aceptar = false;
        initComponents();
        WindowsUtil.makeWindowsShape(this, pnlBackground.getShape());
        new WindowDragger(this, pnlBackground);

        tleBarraTitulo.addCloseAction(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        setLocationRelativeTo(null);
    }

    public frmEditarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx, String pCodigoProducto, String pNombreProducto,
            String pMarca, String pDescripcion,
            double pPrecioCompra, double pPrecioVenta, boolean pExitencia, int pCantidad) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        WindowsUtil.makeWindowsShape(this, pnlBackground.getShape());
        new WindowDragger(this, pnlBackground);

        tleBarraTitulo.addCloseAction(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        setLocationRelativeTo(null);
        txtCodProducto.setText(pCodigoProducto);
        txtNombreProducto.setText(pNombreProducto);
        txtMarca.setText(pMarca);
        txtDescripcion.setText(pDescripcion);
        numPrecioCompra.setValue(pPrecioCompra);
        numPrecioVenta.setValue(pPrecioVenta);
        chkExistencia.setSelected(pExitencia);
        numCantidad.setValue(pCantidad);

    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        tleBarraTitulo = new org.edisoncor.gui.varios.TitleBar();
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
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new org.edisoncor.gui.button.ButtonAction();
        btnSalir = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(138, 138, 138));

        tleBarraTitulo.setTitulo("Editar producto");
        pnlBackground.add(tleBarraTitulo, java.awt.BorderLayout.PAGE_START);

        pnlDAtosProducto.setBackground(new java.awt.Color(138, 138, 138));
        pnlDAtosProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));
        pnlDAtosProducto.setForeground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Código del producto:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Nombre del producto:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Descripción:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Precio de compra:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Precio de venta:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Cantidad:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Porcentaje:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Existencia:");

        numPrecioCompra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPrecioCompraStateChanged(evt);
            }
        });

        numPrecioVenta.setEnabled(false);

        numPorcentaje.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numPorcentajeStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("%");

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

        javax.swing.GroupLayout pnlDAtosProductoLayout = new javax.swing.GroupLayout(pnlDAtosProducto);
        pnlDAtosProducto.setLayout(pnlDAtosProductoLayout);
        pnlDAtosProductoLayout.setHorizontalGroup(
            pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkExistencia))
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(numPrecioVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(numPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodProducto, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30)
                        .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlDAtosProductoLayout.setVerticalGroup(
            pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDAtosProductoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(numPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkExistencia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDAtosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(numCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(numPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(138, 138, 138));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
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
                .addContainerGap(21, Short.MAX_VALUE))
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
                .addGap(0, 345, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlContenedorLayout.createSequentialGroup()
                    .addComponent(pnlDAtosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 65, Short.MAX_VALUE)))
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
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            JOptionPane.showMessageDialog(null, "Error al intentar calcular el porcentaje de venta. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numPrecioCompraStateChanged

    private void numPorcentajeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_numPorcentajeStateChanged
        // TODO add your handling code here
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

        if (txtCodProducto.getText().equals("") || txtDescripcion.getText().equals("") || txtMarca.getText().equals("") || txtNombreProducto.getText().equals("")
                || numCantidad.getValue().equals(0) || numPorcentaje.getValue().equals(0) || numPrecioCompra.getValue().equals(0) || numPrecioVenta.getValue().equals(0)) {
            JOptionPane.showMessageDialog(null, "Faltan datos importantes, por favor corrija para continuar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
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
            Inventario oInventario = new Inventario(txtCodProducto.getText(), txtNombreProducto.getText(), txtMarca.getText(), txtDescripcion.getText(), precioCompra, precioVenta, existencia, cantidad, fecha);
            oInventarioD.actualizarProducto(oInventario, txtCodProducto.getText());
            if (oInventarioD.isError()) {
                JOptionPane.showMessageDialog(null,
                        "Error al intentar modificar el producto, detalle técnico: " + oInventarioD.getErrorMsg(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Producto modificado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            aceptar = true;
            setVisible(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        frmBuscarProducto oSearch = new frmBuscarProducto(null, true, cnx);
        oSearch.setVisible(true);
        if (oSearch.isAceptar()) {
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
    private org.edisoncor.gui.varios.TitleBar tleBarraTitulo;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}

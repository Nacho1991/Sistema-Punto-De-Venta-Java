/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import ImpresoraD.Factura;
import ImpresoraD.MaestroFactura;
import ImpresoraD.Producto;
import ImpresoraL.Impresion;
import ImpresoraL.Matematicas;
import XmlD.Pedido;
import XmlL.GuardarPendientes;
import accesoDatos.AccesoDatosMySql;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import logica.Inventario;
import org.edisoncor.gui.util.WindowDragger;

/**
 *
 * @author Ignacio
 */
public class frmFacturacion extends javax.swing.JFrame {

    AccesoDatosMySql cnx;
    Calendar fecha = new GregorianCalendar();
    private String[] cabeceras = {"Código", "Descripción", "Cantidad", "Disponible", "Precio unitario", "Precio total"};
    private String[][] datos = new String[0][5];
    private int descuento;
    private int pago;
    private int cambio;

    public frmFacturacion(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        setUndecorated(true);
        initComponents();
        fecha = new GregorianCalendar();
        establecerFecha();
        cnx = pCnx;
        pago = 0;
        descuento = 0;
        refrescar();
        new WindowDragger(this, pnlBackground);
        eventoChangeTable();
        WindowDragger w = new WindowDragger(this, tleBarraTitulo);
        setLocationRelativeTo(null);
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public void establecerFecha() {
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        txtFecha.setText(dia + "/" + (mes + 1) + "/" + año);
    }
    private DefaultTableModel modelo = new DefaultTableModel() {
        boolean[] canEdit = new boolean[]{
            false, false, true, false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public void eventoChangeTable() {
        tblaListProductos.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                double suma = 0;
                int cantidad = 0;
                for (int a = 0; a < tblaListProductos.getRowCount(); a++) //recorro las columnas
                {
                    try {
//                        cantidad = Integer.parseInt(tblaListProductos.getValueAt(a, 2).toString());
//                        double totalProducto = Double.parseDouble(tblaListProductos.getValueAt(a, 5).toString());
//                        tblaListProductos.setValueAt(totalProducto, a, 5);
                        suma += Double.parseDouble(tblaListProductos.getValueAt(a, 5).toString());
                        txtTotalPagar.setText("" + suma);
                    } catch (Exception xp) {
                        JOptionPane.showMessageDialog(null, "Error inesperado. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void refrescar() {
        this.modelo.setDataVector(datos, cabeceras);
        this.tblaListProductos.setModel(modelo);
    }

    public void imprimirFactura(int pNumeroMateriales) {
        try {
            //Se hace una instancia de la clase MaestroFactura que es la que se encarga
            //de almacenar todos los datos de la factura
            MaestroFactura maestro = new MaestroFactura();
            //Se crea una lista de la clase anterior
            List<Producto> productos = new ArrayList<Producto>();
            //Se setea todos los datos obtenidos en TextBox
            maestro.setNombreCliente(txtNombre.getText());
            maestro.setCedulaCliente(txtCedula.getText());
            maestro.setDireccionCliente(txtDireccion.getText());
            maestro.setNumeroFactura(txtNumeroFactura.getText());
            maestro.setCondicionPago((String) cmbTipoCliente.getSelectedItem());
            maestro.setTelefono(txtTelefono.getText());
            maestro.setNombreVendedor(txtNombreVendedor.getText());
            maestro.setObservacion(txtObservación.getText());
            maestro.setFechaEmision(txtFecha.getText());
            //Se hace una instancia de la clase Factura
            Factura factura = new Factura();
            //Se setea los datos de la lista a la lista de maestro
            factura.setMaestro(maestro);
            //Se crea una variable subtotal
            double subtotal = 0d;
            //Se hace un for con todos los productos encontrados en la tabla
            for (int i = 0; i < pNumeroMateriales; i++) {
                //Se hace variable que se encarga de almacenar la observacion escrita por el cajero
                String descripcion = (String) tblaListProductos.getValueAt(i, 1);
                //Se obtiene la cantidad de cada fila de la tabla
                int cantidad = Integer.parseInt(tblaListProductos.getValueAt(i, 2).toString());
                //Se hace una variable para almacenar el precio unitario de cada producto
                double precioUnitario = Double.parseDouble(tblaListProductos.getValueAt(i, 4).toString());
                //Se realiza el calculo total a pagar por cada producto por cada fila
                int precioTotal = (int) precioUnitario * cantidad;
                //La variable subtotal se carga con el calculo realizado anteriormente
                subtotal += precioTotal;
                //Se hace una instancia de la clase Producto que es la que se encarga de alamcenar los datos de cada producto
                Producto producto = new Producto();
                //Se le setean los datos a esa clase
                producto.setCantidad(cantidad);
                producto.setDescripcion(descripcion);
                producto.setPrecioTotal(precioTotal);
                producto.setPrecioUnitario(precioUnitario);
                producto.setPago(pago);
                producto.setDescuento(descuento);
                producto.setVuelto(cambio);
                //Se le agrega los datos a la lista creada al principio del metodo
                productos.add(producto);
            }
            //En el TextBox se le escribe el subtotal para ser mostrado
            txtTotalPagar.setText("" + (int) (subtotal));
            //A la factura se le setea los productos para ser impresos
            factura.setProductos(productos);
            //Se crea una instancia de la clase Impresion
            Impresion p = new Impresion(factura);
            //Se envoca el metodo generar PDF para despues ser impreso como factura
            p.generarArchivoPDF(txtNumeroFactura.getText());
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado al intentar enviar los parametros necesarios para emitir la impresión. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean existeCodigo(String pCodigo) {
        boolean existe = false;
        for (int a = 0; a < tblaListProductos.getRowCount(); a++) //recorro las columnas
        {
            if (pCodigo.equals(modelo.getValueAt(a, 0).toString())) {
                existe = true;
            }
        }
        return existe;
    }

    public int comprobarCantidad(String pCodigo) {
        int nuevaCantidad = 0;
        double precioUnitario = 0;
        double precioTotal = 0;
        int materiales = tblaListProductos.getRowCount();
        for (int a = 0; a < materiales; a++) //recorro las columnas
        {
            if (pCodigo.equals(modelo.getValueAt(a, 0).toString())) {
                nuevaCantidad = Integer.parseInt(String.valueOf(modelo.getValueAt(a, 2)));
                nuevaCantidad++;
                precioUnitario = Double.parseDouble(String.valueOf(modelo.getValueAt(a, 4)));
                precioTotal = precioUnitario * nuevaCantidad;
                modelo.setValueAt(nuevaCantidad, a, 2); // Row/Col
                modelo.setValueAt(precioTotal, a, 5); // Row/Col
                break;
            }
        }
        return nuevaCantidad;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClickDerecho = new javax.swing.JPopupMenu();
        menuEliminar = new javax.swing.JMenuItem();
        menuIngresarCantidad = new javax.swing.JMenuItem();
        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        tleBarraTitulo = new org.edisoncor.gui.varios.BarraTitle();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        pnlEncabezado = new org.edisoncor.gui.panel.PanelShadow();
        txtCedula = new org.edisoncor.gui.textField.TextField();
        txtDireccion = new org.edisoncor.gui.textField.TextField();
        txtNombre = new org.edisoncor.gui.textField.TextField();
        txtTelefono = new org.edisoncor.gui.textField.TextField();
        cmbTipoCliente = new org.edisoncor.gui.comboBox.ComboBoxRectIcon();
        txtNumeroFactura = new org.edisoncor.gui.textField.TextField();
        txtLimiteCredito = new org.edisoncor.gui.textField.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tbrOpciones = new javax.swing.JToolBar();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnBuscarProductos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnProductosVarios = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnEliminarProducto = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnLimpiar = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnDescuentosPorProducto = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnImprimirFactura = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnPausarFactura = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnVerFacturasPendientes = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaListProductos = new javax.swing.JTable();
        panelNice2 = new org.edisoncor.gui.panel.PanelNice();
        pnlPieFrame = new org.edisoncor.gui.panel.PanelShadow();
        txtNombreVendedor = new org.edisoncor.gui.textField.TextField();
        txtFecha = new org.edisoncor.gui.textField.TextField();
        txtTotalPagar = new org.edisoncor.gui.textField.TextField();
        txtObservación = new org.edisoncor.gui.textField.TextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        txtDescuento = new org.edisoncor.gui.textField.TextField();

        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        menuClickDerecho.add(menuEliminar);

        menuIngresarCantidad.setText("Ingresar cantidad");
        menuClickDerecho.add(menuIngresarCantidad);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(204, 204, 204));
        pnlBackground.add(tleBarraTitulo, java.awt.BorderLayout.PAGE_START);

        panelShadow1.setBackground(new java.awt.Color(204, 204, 204));

        panelNice1.setBackground(new java.awt.Color(204, 204, 204));

        txtCedula.setEditable(false);

        txtDireccion.setEditable(false);

        txtNombre.setEditable(false);

        txtTelefono.setEditable(false);

        cmbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Contado", "Crédito" }));

        txtNumeroFactura.setEditable(false);
        txtNumeroFactura.setText("1");

        txtLimiteCredito.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Cédula:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Dirección:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Telefono:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Tipo cliente:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("No. Factura:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Límite de crédito:");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3))
                    .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel1))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(494, Short.MAX_VALUE))
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimiteCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelNice1.add(pnlEncabezado, java.awt.BorderLayout.CENTER);

        tbrOpciones.setFloatable(false);
        tbrOpciones.setRollover(true);

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator11);

        btnBuscarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Icono_Buscar.png"))); // NOI18N
        btnBuscarProductos.setText("Buscar productos");
        btnBuscarProductos.setFocusable(false);
        btnBuscarProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarProductos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductosActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnBuscarProductos);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(240, 240, 240));
        tbrOpciones.add(jSeparator1);

        btnProductosVarios.setText("Productos varios");
        btnProductosVarios.setFocusable(false);
        btnProductosVarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductosVarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProductosVarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosVariosActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnProductosVarios);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(240, 240, 240));
        tbrOpciones.add(jSeparator2);

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancelar-icono.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setFocusable(false);
        btnEliminarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnEliminarProducto);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator3);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clear.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setFocusable(false);
        btnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnLimpiar);

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator9);

        btnDescuentosPorProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/percentage.png"))); // NOI18N
        btnDescuentosPorProducto.setText("Descuentos por producto");
        btnDescuentosPorProducto.setFocusable(false);
        btnDescuentosPorProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDescuentosPorProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbrOpciones.add(btnDescuentosPorProducto);

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator4);

        btnImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/money.png"))); // NOI18N
        btnImprimirFactura.setText("Facturar");
        btnImprimirFactura.setFocusable(false);
        btnImprimirFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimirFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnImprimirFactura);

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator5);

        btnPausarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pausar.png"))); // NOI18N
        btnPausarFactura.setText("Pausar factura");
        btnPausarFactura.setFocusable(false);
        btnPausarFactura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPausarFactura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPausarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarFacturaActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnPausarFactura);

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator7);

        btnVerFacturasPendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pendientes.png"))); // NOI18N
        btnVerFacturasPendientes.setText("Ver facturas pendientes");
        btnVerFacturasPendientes.setFocusable(false);
        btnVerFacturasPendientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerFacturasPendientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVerFacturasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFacturasPendientesActionPerformed(evt);
            }
        });
        tbrOpciones.add(btnVerFacturasPendientes);

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator8);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Buscar-Clientes.png"))); // NOI18N
        jButton1.setText("Buscar clientes");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbrOpciones.add(jButton1);

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        tbrOpciones.add(jSeparator10);

        tblaListProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Cantidad", "Disponible", "Precio unitario", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblaListProductos.setComponentPopupMenu(menuClickDerecho);
        jScrollPane1.setViewportView(tblaListProductos);

        panelNice2.setBackground(new java.awt.Color(204, 204, 204));

        txtNombreVendedor.setEditable(false);

        txtFecha.setEditable(false);

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setText("0");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Vendedor:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Observación:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Total a pagar:");

        lblDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescuento.setText("Descuento:");

        txtDescuento.setEditable(false);
        txtDescuento.setText("0");

        javax.swing.GroupLayout pnlPieFrameLayout = new javax.swing.GroupLayout(pnlPieFrame);
        pnlPieFrame.setLayout(pnlPieFrameLayout);
        pnlPieFrameLayout.setHorizontalGroup(
            pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieFrameLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPieFrameLayout.createSequentialGroup()
                        .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 610, Short.MAX_VALUE))
                    .addGroup(pnlPieFrameLayout.createSequentialGroup()
                        .addComponent(txtObservación, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addGap(22, 22, 22)
                .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(lblDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        pnlPieFrameLayout.setVerticalGroup(
            pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPieFrameLayout.createSequentialGroup()
                        .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtObservación, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPieFrameLayout.createSequentialGroup()
                        .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescuento)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPieFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        panelNice2.add(pnlPieFrame, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNice1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(tbrOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(panelNice2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelNice1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbrOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNice2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnBuscarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductosActionPerformed
        // TODO add your handling code here:
        frmBuscarProducto oSearch = new frmBuscarProducto(this, rootPaneCheckingEnabled, cnx);
        oSearch.setVisible(true);
        if (oSearch.isAceptar()) {
            if (existeCodigo(oSearch.getCodigo()) == false) {
                modelo.addRow(new Object[]{oSearch.getCodigo(), oSearch.getDescripcion(), "1", oSearch.getExistencia(), oSearch.getPrecioVenta(), oSearch.getPrecioVenta()});
                tblaListProductos.updateUI();
            } else {
                comprobarCantidad(oSearch.getCodigo());
            }
        }
    }//GEN-LAST:event_btnBuscarProductosActionPerformed

    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed
        // TODO add your handling code here:
        try {
            frmPagoFactura oPagar = new frmPagoFactura(this, rootPaneCheckingEnabled, txtTotalPagar.getText(), txtNumeroFactura.getText(), tblaListProductos.getRowCount());
            oPagar.setVisible(true);
            if (oPagar.isAceptar()) {
                int numeroMateriales = tblaListProductos.getRowCount();
                String tipoCliente = cmbTipoCliente.getSelectedItem().toString();
                pago = oPagar.getPagoCon();
                cambio = oPagar.getCambio();
                descuento = oPagar.getDescuento();
                if (tipoCliente.equals("Contado")) {
                    if (numeroMateriales > 0) {
                        imprimirFactura(numeroMateriales);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Sin productos a facturar", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    if (txtCedula.getText().equals("") || txtDireccion.getText().equals("") || txtNombre.getText().equals("") || txtTelefono.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,
                                "Faltan datos importantes para poder emitir la factura a crédito", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    } else {
                        imprimirFactura(numeroMateriales);
                    }
                }
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado al intentar emitir la factura. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImprimirFacturaActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
        if (tblaListProductos.getRowCount() > 0) {
            int fila = tblaListProductos.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
                tblaListProductos.updateUI();
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se ha seleccionado ninguna fila.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sin productos a facturar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        int fila = tblaListProductos.getRowCount();
        if (fila > 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar todos los productos de la tabla?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == 0) {
                modelo.setRowCount(0);
                tblaListProductos.updateUI();
                txtTotalPagar.setText("0");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay productos en la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        // TODO add your handling code here:
        if (tblaListProductos.getRowCount() > 0) {
            int fila = tblaListProductos.getSelectedRow();
            if (fila >= 0) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == 0) {
                    modelo.removeRow(fila);
                    tblaListProductos.updateUI();
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se ha seleccionado ninguna fila.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sin productos a facturar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void btnProductosVariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosVariosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnProductosVariosActionPerformed

    private void btnPausarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarFacturaActionPerformed
        // TODO add your handling code here:
        String[] lista = new String[6];
        int columns = tblaListProductos.getColumnCount();
        int filas = tblaListProductos.getRowCount();
        if (filas > 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea guardar temporalmente ésta factura?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == 0) {
                boolean existe = false;
                do {
                    String nombreOrden = JOptionPane.showInputDialog(null, "Por favor, ingrese algún nombre ferencial para la orden a pausar.", "Ingresar", JOptionPane.QUESTION_MESSAGE);
                    GuardarPendientes oSave = new GuardarPendientes(nombreOrden);
                    if (null == nombreOrden) {
                        break;
                    } else {
                        if (oSave.comprobarExistencia(nombreOrden + ".xml") != true) {
                            oSave = new GuardarPendientes(txtCedula.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), cmbTipoCliente.getSelectedItem().toString(), nombreOrden);
                            for (int posFila = 0; posFila < filas; posFila++) {//Se recorren las filas de la tabla
                                for (int posColumns = 0; posColumns < columns; posColumns++) {//Se recorren las columnas de la tabla
                                    lista[posColumns] = modelo.getValueAt(posFila, posColumns).toString();
                                }
                                oSave.generarFacturaPendiente(lista[0], lista[1], lista[2], lista[3], lista[4], lista[5]);
                                modelo.setRowCount(0);
                                tblaListProductos.updateUI();
                            }
                            existe = false;
                            oSave.crearXml(nombreOrden+".xlm");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede pausar la factura, ya existe una con el mismo nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                            existe = true;
                        }
                    }
                } while (existe == true);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sin productos en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPausarFacturaActionPerformed

    private void btnVerFacturasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFacturasPendientesActionPerformed
        // TODO add your handling code here:
        frmVerFacturasPendientes oShow = new frmVerFacturasPendientes(this, rootPaneCheckingEnabled);
        oShow.setVisible(true);
        if (oShow.isAceptar()) {
            try {
                txtCedula.setText(oShow.cliente.get(0).getCedula());
                txtNombre.setText(oShow.cliente.get(0).getNombre());
                txtDireccion.setText(oShow.cliente.get(0).getDireccion());
                txtTelefono.setText(oShow.cliente.get(0).getTelefono());
                cmbTipoCliente.setSelectedItem(oShow.cliente.get(0).getTipoCliente());
                //Se empieza a cargar la tabla con los productos guardados en la lista
                this.datos = new String[oShow.productos.size()][9];
                for (int i = 0; i < oShow.productos.size(); i++) {
                    this.datos[i][0] = oShow.productos.get(i).getCodigo();
                    this.datos[i][1] = oShow.productos.get(i).getDescripcion();
                    this.datos[i][2] = oShow.productos.get(i).getCantidad();
                    this.datos[i][3] = oShow.productos.get(i).getDisponible();
                    this.datos[i][4] = oShow.productos.get(i).getPrecioUnitario();
                    this.datos[i][5] = oShow.productos.get(i).getPrecioTotal();

                }
                this.modelo.setDataVector(datos, cabeceras);
                this.tblaListProductos.setModel(modelo);
            } catch (Exception xp) {
                JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnVerFacturasPendientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProductos;
    private javax.swing.JButton btnDescuentosPorProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnImprimirFactura;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPausarFactura;
    private javax.swing.JButton btnProductosVarios;
    private javax.swing.JButton btnVerFacturasPendientes;
    private org.edisoncor.gui.comboBox.ComboBoxRectIcon cmbTipoCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JPopupMenu menuClickDerecho;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JMenuItem menuIngresarCantidad;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    private org.edisoncor.gui.panel.PanelNice panelNice2;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private org.edisoncor.gui.panel.PanelShadow pnlEncabezado;
    private org.edisoncor.gui.panel.PanelShadow pnlPieFrame;
    private javax.swing.JTable tblaListProductos;
    private javax.swing.JToolBar tbrOpciones;
    private org.edisoncor.gui.varios.BarraTitle tleBarraTitulo;
    private org.edisoncor.gui.textField.TextField txtCedula;
    private org.edisoncor.gui.textField.TextField txtDescuento;
    private org.edisoncor.gui.textField.TextField txtDireccion;
    private org.edisoncor.gui.textField.TextField txtFecha;
    private org.edisoncor.gui.textField.TextField txtLimiteCredito;
    private org.edisoncor.gui.textField.TextField txtNombre;
    private org.edisoncor.gui.textField.TextField txtNombreVendedor;
    private org.edisoncor.gui.textField.TextField txtNumeroFactura;
    private org.edisoncor.gui.textField.TextField txtObservación;
    private org.edisoncor.gui.textField.TextField txtTelefono;
    private org.edisoncor.gui.textField.TextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
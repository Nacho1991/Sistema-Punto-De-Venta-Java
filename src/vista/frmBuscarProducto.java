/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.InventarioD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logica.Inventario;
import org.edisoncor.gui.util.WindowDragger;
import org.edisoncor.gui.util.WindowsUtil;

/**
 *
 * @author Ignacio
 */
public class frmBuscarProducto extends javax.swing.JDialog {

    private AccesoDatosMySql cnx;
    private boolean aceptar;
    ArrayList tarjetas;
    private String codigo;
    private String nombre;
    private String marca;
    private String descripcion;
    private String precioCompra;
    private String precioVenta;
    private String existencia;
    private String cantidad;
    private String fechaEntrada;
    private InventarioD oInventarioD;
    private String[] cabeceras = {"Código", "Nombre", "Marca", "Descripción", "Precio de compra", "Precio de venta", "Existencia", "Cantidad", "Fecha de entrada"};
    private String[][] datos = new String[0][9];

    public frmBuscarProducto(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        setUndecorated(true);
        oInventarioD = new InventarioD(pCnx);
        cnx = pCnx;
        initComponents();
        refrescar();
        WindowsUtil.makeWindowsShape(this, pnlBackground.getShape());
        new WindowDragger(this, pnlBackground);

        tleBarraTitulo.addCloseAction(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        setLocationRelativeTo(null);
        //Cargamos en el constructor el evento de cambio
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
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private void mostrarFiltro(String pFiltro, String pOpcion) {
        tarjetas = (ArrayList) oInventarioD.filtrarInventario(pFiltro, pOpcion);
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
            this.tblaRegistros.setModel(modelo);
        }
    }

    private void refrescar() {
        tarjetas = (ArrayList) oInventarioD.consultarRegistro();
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
            this.tblaRegistros.setModel(modelo);
        }
    }

    public ArrayList getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList tarjetas) {
        this.tarjetas = tarjetas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String[][] getDatos() {
        return datos;
    }

    public void setDatos(String[][] datos) {
        this.datos = datos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClickDerecho = new javax.swing.JPopupMenu();
        smnSeleccionar = new javax.swing.JMenuItem();
        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        tleBarraTitulo = new org.edisoncor.gui.varios.TitleBar();
        pnlContenedor = new org.edisoncor.gui.panel.PanelShadow();
        btnSeleccionar = new org.edisoncor.gui.button.ButtonColoredAction();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaRegistros = new javax.swing.JTable();
        cmbOpcionesBusqueda = new javax.swing.JComboBox();
        txtFiltroBusqueda = new javax.swing.JTextField();

        smnSeleccionar.setText("Seleccionar");
        smnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smnSeleccionarActionPerformed(evt);
            }
        });
        menuClickDerecho.add(smnSeleccionar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(138, 138, 138));
        pnlBackground.setForeground(new java.awt.Color(0, 51, 255));

        tleBarraTitulo.setBackground(new java.awt.Color(0, 0, 0));
        tleBarraTitulo.setTitulo("Buscar productos");
        pnlBackground.add(tleBarraTitulo, java.awt.BorderLayout.PAGE_START);

        pnlContenedor.setBackground(new java.awt.Color(50, 50, 50));
        pnlContenedor.setForeground(new java.awt.Color(0, 51, 255));

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Buscar producto:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Opciones de búsqueda:");

        jPanel1.setBackground(new java.awt.Color(138, 138, 138));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de registros"));

        tblaRegistros.setBackground(new java.awt.Color(254, 254, 254));
        tblaRegistros.setForeground(new java.awt.Color(1, 1, 1));
        tblaRegistros.setComponentPopupMenu(menuClickDerecho);
        jScrollPane1.setViewportView(tblaRegistros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );

        cmbOpcionesBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descripción", "Marca", "Código" }));

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbOpcionesBusqueda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbOpcionesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        try {
            int numeroProductos = tblaRegistros.getRowCount();
            int fila = tblaRegistros.getSelectedRow();
            if (fila >= 0) {
                if (numeroProductos > 0) {
                    codigo = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 0));
                    nombre = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 1));
                    marca = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 2));
                    descripcion = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 3));
                    precioCompra = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 4));
                    precioVenta = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 5));
                    existencia = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 6));
                    cantidad = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 7));
                    fechaEntrada = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 8));
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
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado al intentar cargar los datos del producto. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void smnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smnSeleccionarActionPerformed
        // TODO add your handling code here:
        try {
            int numeroProductos = tblaRegistros.getRowCount();
            int fila = tblaRegistros.getSelectedRow();
            if (fila >= 0) {
                if (numeroProductos > 0) {
                    codigo = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 0));
                    nombre = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 1));
                    marca = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 2));
                    descripcion = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 3));
                    precioCompra = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 4));
                    precioVenta = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 5));
                    existencia = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 6));
                    cantidad = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 7));
                    fechaEntrada = String.valueOf(modelo.getValueAt(tblaRegistros.getSelectedRow(), 8));
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
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null,
                    "Error inesperado al intentar cargar los datos del producto. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_smnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction btnSeleccionar;
    private javax.swing.JComboBox cmbOpcionesBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuClickDerecho;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private org.edisoncor.gui.panel.PanelShadow pnlContenedor;
    private javax.swing.JMenuItem smnSeleccionar;
    private javax.swing.JTable tblaRegistros;
    private org.edisoncor.gui.varios.TitleBar tleBarraTitulo;
    private javax.swing.JTextField txtFiltroBusqueda;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import XmlD.Cliente;
import XmlD.Pedido;
import XmlD.Producto;
import XmlL.GuardarPendientes;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Inventario;
import org.edisoncor.gui.util.WindowDragger;

/**
 *
 * @author ignacio
 */
public class frmVerFacturasPendientes extends javax.swing.JDialog {

    private boolean aceptar;
    File archivos;
    GuardarPendientes oGuardarPendientes;
    ArrayList<Producto> productos;
    ArrayList<Cliente> cliente;
    private String[] cabeceras = {"Código", "Descripción", "Cantidad", "Disponible", "Precio unitario", "Precio total"};
    private String[][] datos = new String[0][6];

    public frmVerFacturasPendientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        oGuardarPendientes = new GuardarPendientes();
        aceptar = false;
        productos = new ArrayList<>();
        cliente = new ArrayList<>();
        comprobarSistema();
        cargarListaFacturas();
        
        setLocationRelativeTo(null);
    }

    public void comprobarSistema() {
        try {
            String TypeOS = System.getProperty("os.name");
            switch (TypeOS) {
                case "Linux":
                    archivos = new File("/home/ignacio/Escritorio/Facturas pausadas");
                    break;
                case "Windows 7":
                    archivos = new File("C:\\Sistema Punto Venta\\Facturas pausadas");
                    break;
            }
        } catch (Exception xp) {
            JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Se crea un modelo para la tabla de productos
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public void cargarTablaProductos(ArrayList<Producto> listaProductos) {
        this.datos = new String[listaProductos.size()][6];
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto aux = (Producto) listaProductos.get(i);
            this.datos[i][0] = aux.getCodigo();
            this.datos[i][1] = aux.getDescripcion();
            this.datos[i][2] = aux.getCantidad();
            this.datos[i][3] = aux.getDisponible();
            this.datos[i][4] = aux.getPrecioUnitario();
            this.datos[i][5] = aux.getPrecioTotal();
        }
        this.modelo.setDataVector(datos, cabeceras);
        this.tblaRegistros.setModel(modelo);
    }

    //Carga la lista con todos los archivos xml generados en la determinada carpeta
    public void cargarListaFacturas() {
        DefaultListModel modeloLista = new DefaultListModel();
        String[] ficheros = archivos.list();
        if (ficheros == null || ficheros.length == 0) {
            modeloLista.addElement("¡Sin facturas pendientes!");
            lstListaFacturas.setModel(modeloLista);
            lstListaFacturas.setEnabled(false);
            btnEliminarTodo.setEnabled(false);
        } else {
            for (String fichero : ficheros) {
                modeloLista.addElement(fichero);
            }
            lstListaFacturas.setModel(modeloLista);
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Cliente> cliente) {
        this.cliente = cliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuClikDerechoList = new javax.swing.JPopupMenu();
        mnuEliminar = new javax.swing.JMenuItem();
        mnuVerDetalles = new javax.swing.JMenuItem();
        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        pnlVisor = new org.edisoncor.gui.panel.PanelShadow();
        pnlGeneralContainer = new javax.swing.JPanel();
        pnlScllLst = new javax.swing.JScrollPane();
        lstListaFacturas = new javax.swing.JList();
        pnlDatosCliente = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblTipoCliente = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtTipoCliente = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnCargarFactura = new org.edisoncor.gui.button.ButtonAction();
        pnlContainer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblaRegistros = new javax.swing.JTable();
        btnEliminarTodo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        mnuEliminar.setText("Eliminar");
        menuClikDerechoList.add(mnuEliminar);

        mnuVerDetalles.setText("Ver detalles");
        menuClikDerechoList.add(mnuVerDetalles);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver facturas pendientes");
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(0, 0, 0));

        pnlGeneralContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de facturas"));

        lstListaFacturas.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lstListaFacturas.setComponentPopupMenu(menuClikDerechoList);
        lstListaFacturas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstListaFacturasValueChanged(evt);
            }
        });
        pnlScllLst.setViewportView(lstListaFacturas);

        pnlDatosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));
        pnlDatosCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        lblNombre.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblCedula.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblCedula.setText("Cédula:");

        lblDireccion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección:");

        lblTelefono.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono:");

        lblTipoCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N
        lblTipoCliente.setText("Tipo de cliente:");

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtTipoCliente.setEditable(false);
        txtTipoCliente.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        txtTelefono.setEditable(false);
        txtTelefono.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 18)); // NOI18N

        btnCargarFactura.setText("Cargar factura");
        btnCargarFactura.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnCargarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosClienteLayout = new javax.swing.GroupLayout(pnlDatosCliente);
        pnlDatosCliente.setLayout(pnlDatosClienteLayout);
        pnlDatosClienteLayout.setHorizontalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosClienteLayout.createSequentialGroup()
                        .addComponent(lblCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(lblDireccion)
                            .addComponent(lblTelefono)
                            .addComponent(lblTipoCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTipoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDatosClienteLayout.setVerticalGroup(
            pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClienteLayout.createSequentialGroup()
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCedula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoCliente)))
                    .addComponent(btnCargarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de productos"));

        jScrollPane2.setViewportView(tblaRegistros);

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );

        btnEliminarTodo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnEliminarTodo.setText("Eliminar todo");
        btnEliminarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTodoActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGeneralContainerLayout = new javax.swing.GroupLayout(pnlGeneralContainer);
        pnlGeneralContainer.setLayout(pnlGeneralContainerLayout);
        pnlGeneralContainerLayout.setHorizontalGroup(
            pnlGeneralContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralContainerLayout.createSequentialGroup()
                .addGroup(pnlGeneralContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralContainerLayout.createSequentialGroup()
                        .addComponent(btnEliminarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlScllLst, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlGeneralContainerLayout.setVerticalGroup(
            pnlGeneralContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralContainerLayout.createSequentialGroup()
                .addGroup(pnlGeneralContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlGeneralContainerLayout.createSequentialGroup()
                        .addComponent(pnlScllLst, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGeneralContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnlDatosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlVisorLayout = new javax.swing.GroupLayout(pnlVisor);
        pnlVisor.setLayout(pnlVisorLayout);
        pnlVisorLayout.setHorizontalGroup(
            pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneralContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlVisorLayout.setVerticalGroup(
            pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisorLayout.createSequentialGroup()
                .addComponent(pnlGeneralContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void lstListaFacturasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstListaFacturasValueChanged
        // TODO add your handling code here:
        if (lstListaFacturas.getModel().getSize() > 0 && lstListaFacturas.getSelectedIndex() >= 0) {
            cliente = oGuardarPendientes.leerClientesXml(lstListaFacturas.getSelectedValue().toString());
            productos = oGuardarPendientes.leerProductosXml(lstListaFacturas.getSelectedValue().toString());
            if (oGuardarPendientes.isIsError()) {
                JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación. Detalle técnico: " + oGuardarPendientes.getErrorDescripcion(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                txtCedula.setText(cliente.get(0).getCedula());
                txtNombre.setText(cliente.get(0).getNombre());
                txtDireccion.setText(cliente.get(0).getDireccion());
                txtTelefono.setText(cliente.get(0).getTelefono());
                txtTipoCliente.setText(cliente.get(0).getTipoCliente());
                cargarTablaProductos(productos);
            }
        }
    }//GEN-LAST:event_lstListaFacturasValueChanged

    private void btnCargarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFacturaActionPerformed
        // TODO add your handling code here:
        int num = lstListaFacturas.getModel().getSize();
        int index = lstListaFacturas.getSelectedIndex();
        if (index >= 0) {
            if (num > 0) {
                aceptar = true;
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnCargarFacturaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int index = lstListaFacturas.getSelectedIndex();
        if (index >= 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar la factura seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == 0) {
                if (oGuardarPendientes.eliminarFicheroXml(lstListaFacturas.getSelectedValue().toString())) {
                    cargarListaFacturas();
                    tblaRegistros.setModel(new DefaultTableModel());
                    JOptionPane.showMessageDialog(null, "Factura eliminada con éxito.", "Información", JOptionPane.QUESTION_MESSAGE);
                } else if (oGuardarPendientes.isIsError()) {
                    JOptionPane.showMessageDialog(null, "Error inesperado al intentar eliminar la factura seleccionada. Detalle técnico: " + oGuardarPendientes.getErrorDescripcion());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún archivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTodoActionPerformed
        // TODO add your handling code here:
        int index = lstListaFacturas.getModel().getSize();
        if (index > 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar todas las facturas pendientes?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == 0) {
                if (oGuardarPendientes.eliminarAllFicheros() == true) {
                    if (oGuardarPendientes.isIsError()) {
                        JOptionPane.showMessageDialog(null, "Error inesperado por parte de la aplicación al intentar eliminar las facturas. Detalle técnico: " + oGuardarPendientes.getErrorDescripcion(), "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        cargarListaFacturas();
                        tblaRegistros.setModel(new DefaultTableModel());
                        JOptionPane.showMessageDialog(null, "¡Se han eliminado con éxito!", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay facturas pendientes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTodoActionPerformed

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction btnCargarFactura;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarTodo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoCliente;
    private javax.swing.JList lstListaFacturas;
    private javax.swing.JPopupMenu menuClikDerechoList;
    private javax.swing.JMenuItem mnuEliminar;
    private javax.swing.JMenuItem mnuVerDetalles;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JPanel pnlDatosCliente;
    private javax.swing.JPanel pnlGeneralContainer;
    private javax.swing.JScrollPane pnlScllLst;
    private org.edisoncor.gui.panel.PanelShadow pnlVisor;
    private javax.swing.JTable tblaRegistros;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipoCliente;
    // End of variables declaration//GEN-END:variables
}

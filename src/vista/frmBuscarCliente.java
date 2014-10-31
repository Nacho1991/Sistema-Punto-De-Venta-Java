/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.ClientesD;
import accesoDatos.InventarioD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Inventario;

/**
 *
 * @author ignacio
 */
public class frmBuscarCliente extends javax.swing.JDialog {

    AccesoDatosMySql cnx;
    private ClientesD oClienteD;
    private String[] cabeceras = {"Código", "Nombre", "Marca", "Descripción", "Precio de compra", "Precio de venta", "Existencia", "Cantidad", "Fecha de entrada"};
    private String[][] datos = new String[0][9];
    ArrayList tarjetas;

    public frmBuscarCliente(java.awt.Frame parent, boolean modal, AccesoDatosMySql pCnx) {
        super(parent, modal);
        initComponents();
        oClienteD = new ClientesD(pCnx);
        cnx = pCnx;
        refrescar();
    }

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private void refrescar() {
        tarjetas = (ArrayList) oClienteD.consultarRegistro();
        if (oClienteD.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + oClienteD.getErrorMsg());
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
            this.tblaRegistroClientes.setModel(modelo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new org.edisoncor.gui.panel.PanelNice();
        titleBar1 = new org.edisoncor.gui.varios.TitleBar();
        pnlVisor = new org.edisoncor.gui.panel.PanelShadow();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDatoFiltrar = new javax.swing.JTextField();
        cmbOpcionesBusqueda = new javax.swing.JComboBox();
        buttonColoredAction1 = new org.edisoncor.gui.button.ButtonColoredAction();
        pnlRegistrosCliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaRegistroClientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(138, 138, 138));

        titleBar1.setTitulo("Buscar clientes");
        pnlBackground.add(titleBar1, java.awt.BorderLayout.PAGE_START);

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

        jScrollPane1.setViewportView(tblaRegistroClientes);

        javax.swing.GroupLayout pnlRegistrosClienteLayout = new javax.swing.GroupLayout(pnlRegistrosCliente);
        pnlRegistrosCliente.setLayout(pnlRegistrosClienteLayout);
        pnlRegistrosClienteLayout.setHorizontalGroup(
            pnlRegistrosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlRegistrosClienteLayout.setVerticalGroup(
            pnlRegistrosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrosClienteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setText("Código del producto:");

        jLabel4.setText("Código del producto:");

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
                    .addComponent(txtDatoFiltrar)
                    .addComponent(cmbOpcionesBusqueda, 0, 326, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonColoredAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
            .addComponent(pnlRegistrosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlVisorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVisorLayout.createSequentialGroup()
                    .addContainerGap(322, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(481, Short.MAX_VALUE)))
        );
        pnlVisorLayout.setVerticalGroup(
            pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisorLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatoFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColoredAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOpcionesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addComponent(pnlRegistrosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlVisorLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlVisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVisorLayout.createSequentialGroup()
                    .addContainerGap(192, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addContainerGap(192, Short.MAX_VALUE)))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelNice pnlBackground;
    private javax.swing.JPanel pnlRegistrosCliente;
    private org.edisoncor.gui.panel.PanelShadow pnlVisor;
    private javax.swing.JTable tblaRegistroClientes;
    private org.edisoncor.gui.varios.TitleBar titleBar1;
    private javax.swing.JTextField txtDatoFiltrar;
    // End of variables declaration//GEN-END:variables
}

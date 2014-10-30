/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.Registro_ParqueoD;
import accesoDatos.Tarjeta_Cliente_PrepagoD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Registro_Parqueo;
import logica.Tarjeta_Cliente_Prepago;



/**
 *
 * @author Esmar
 */
public class ofrmRegistroParqueo extends javax.swing.JDialog {
    AccesoDatosMySql conexion;
    
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private String[] cabeceras = {"Placa", "Fecha Entrada", "Tipo Vehiculo", "Nombre Cliente", 
        "Fecha Salida","Tarjeta Prepago", "Cantidad Horas", "Tarifa Hora", "Porcentaje Descuento", "Monto Descuento", "Total Pagar"};
    private String[][] datos = new String[0][11];

    private void refrescar() {
        Registro_ParqueoD pRegistro = new Registro_ParqueoD(this.conexion);
        ArrayList registros = (ArrayList) pRegistro.consultarRegistro();
        if (pRegistro.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + pRegistro.getErrorMsg());
        } else {
            this.datos = new String[registros.size()][11];
            for (int i = 0; i <registros.size(); i++) {
                Registro_Parqueo aux = (Registro_Parqueo) registros.get(i);
                this.datos[i][0] = aux.getPlaca();
                this.datos[i][1] = aux.getFecha_hora_entrada();
                this.datos[i][2] = aux.getTipo_vehiculo();
                this.datos[i][3] = aux.getNombre_cliente();
                this.datos[i][4] = aux.getFecha_hora_salida();
                this.datos[i][5] = aux.getTarjeta_prepago();
                this.datos[i][6] = String.valueOf(aux.getCantidad_horas());
                this.datos[i][7] = String.valueOf(aux.getTarifa_hora());
                this.datos[i][8] = String.valueOf(aux.getPorcentaje_descuento());
                this.datos[i][9] = String.valueOf(aux.getMonto_descuento());
                this.datos[i][10] = String.valueOf(aux.getTotal_pagar());
                
                
            }
            this.modelo.setDataVector(datos, cabeceras);
            this.tblRegistros.setModel(modelo);
        }
    }
    /**
     * Creates new form ofrmRegistroParqueo
     */
    public ofrmRegistroParqueo(java.awt.Frame parent, boolean modal,AccesoDatosMySql pConexion) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.conexion = pConexion;
        this.refrescar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        btnCobro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        btnFiltro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEntrada.setText("Entrada");
        btnEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaActionPerformed(evt);
            }
        });

        btnSalida.setText("Salida");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        btnCobro.setText("Cobro");
        btnCobro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobroActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tblRegistros);

        btnFiltro.setText("Filtro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCobro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltro)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrada)
                    .addComponent(btnSalida)
                    .addComponent(btnCobro)
                    .addComponent(btnFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaActionPerformed
//        // TODO add your handling code here:
//        frmNuevoRegistro frmNuevo = new frmNuevoRegistro(null, true, conexion);
//        frmNuevo.setVisible(true);
//        if (frmNuevo.isAceptar()) {
//            if (frmNuevo.isOpcion1()) {
//                Registro_Parqueo NuevoRegsitro = new Registro_Parqueo(frmNuevo.getTxtPlaca(),frmNuevo.getTxtFechaEntrada(),frmNuevo.getCmbVehiculo().getCodigo(),frmNuevo.getCmbCliente().getNombre_cliente(),"", frmNuevo.getCmbCliente().getCodigo(), 0, frmNuevo.getCmbVehiculo().getTarifa_por_hora(), frmNuevo.getCmbCliente().getPorcentaje_descuento(), 0, 0);
//                Registro_ParqueoD oParqueoD = new Registro_ParqueoD(conexion);
//                oParqueoD.insertarParqueo(NuevoRegsitro);
//                if (oParqueoD.isError()) {
//                    JOptionPane.showMessageDialog(null,
//                            "Error consultando a la base de datos, detalle técnico:" + oParqueoD.getErrorMsg());
//                } else {
//                    this.refrescar();
//                }
//            }else{
//                Registro_Parqueo NuevoRegsitro = new Registro_Parqueo(frmNuevo.getTxtPlaca(),frmNuevo.getTxtFechaEntrada(),frmNuevo.getCmbVehiculo().getCodigo(),frmNuevo.getTxtNombre(),"", "", 0, 0, 0, 0, 0);
//                Registro_ParqueoD oParqueoD = new Registro_ParqueoD(conexion);
//                oParqueoD.insertarParqueo(NuevoRegsitro);
//                if (oParqueoD.isError()) {
//                    JOptionPane.showMessageDialog(null,
//                            "Error consultando a la base de datos, detalle técnico:" + oParqueoD.getErrorMsg());
//                } else {
//                    this.refrescar();
//                }
//            }
//           
//        }
            
        
    }//GEN-LAST:event_btnEntradaActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
//        if (this.datos.length > 0) {
//            int fila = this.tblRegistros.getSelectedRow();
//            if (fila >= 0) {
//                String pPlacaAnterior = this.datos[fila][0];
//                frmSalidaRegistro frmSalida = new frmSalidaRegistro(null,true, this.datos[fila][0], this.datos[fila][1], this.datos[fila][2], this.datos[fila][3],Double.parseDouble(this.datos[fila][7]),Double.parseDouble(this.datos[fila][8]));
//                frmSalida.setVisible(true);
//                if (frmSalida.isAceptar()) {
//                    Registro_Parqueo oRegistro = new Registro_Parqueo(this.datos[fila][0], this.datos[fila][1], this.datos[fila][2], this.datos[fila][3], frmSalida.getTxtFechaSalida(), this.datos[fila][5], frmSalida.getTxtCantHoras(), Double.parseDouble(this.datos[fila][7]), Double.parseDouble(this.datos[fila][8]), frmSalida.calcularMontoDescuento(), frmSalida.calcularTotalPagar());
//                    Registro_ParqueoD oRegistroD = new Registro_ParqueoD(this.conexion);
//                    oRegistroD.actualizarParqueo(oRegistro, pPlacaAnterior);
//                    if (oRegistroD.isError()) {
//                        JOptionPane.showMessageDialog(null,
//                            "Error consultando a la base de datos, detalle técnico:" + oRegistroD.getErrorMsg());
//                    } else {
//                        this.refrescar();
//                    }
//                }
//            }
//         }
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void btnCobroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobroActionPerformed
        // TODO add your handling code here:
//        if (this.datos.length > 0) {
//          // int respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que desealo Eliminarlo? Si o No?", "Confirmación", JOptionPane.YES_NO_OPTION);
//            // if (respuesta == JOptionPane.YES_OPTION) {
//            int fila = this.tblRegistros.getSelectedRow();
//            if (fila >= 0) {
//
//                Registro_Parqueo oRegistro = new Registro_Parqueo(this.datos[fila][0], this.datos[fila][1], this.datos[fila][2], this.datos[fila][3], this.datos[fila][4], this.datos[fila][5], Double.parseDouble(this.datos[fila][6]), Double.parseDouble(this.datos[fila][7]), Double.parseDouble(this.datos[fila][8]), Double.parseDouble(this.datos[fila][9]), Double.parseDouble(this.datos[fila][10]));
//                Registro_ParqueoD oRegistroD = new Registro_ParqueoD(this.conexion);
//                oRegistroD.borrarRegistro(oRegistro);
//                if (oRegistroD.isError()) {
//                    JOptionPane.showMessageDialog(null,
//                            "Error consultando a la base de datos, detalle técnico:" + oRegistroD.getErrorMsg());
//                } else {
//                    this.refrescar();
//                }
//
//            }
//
//           // }
//        }
    }//GEN-LAST:event_btnCobroActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobro;
    private javax.swing.JButton btnEntrada;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnSalida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}

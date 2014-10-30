  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import accesoDatos.AccesoDatosMySql;
import accesoDatos.Tipo_VehiculoD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Tipo_Vehiculo;

/**
 *
 * @author Esmar
 */
public class ofrmMantenimientoVehiculo extends javax.swing.JDialog {

    AccesoDatosMySql conexion;

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private String[] cabeceras = {"Código", "Descripción", "Tarifa por Hora"};
    private String[][] datos = new String[0][3];

    private void refrescar() {
        Tipo_VehiculoD pVehiculo = new Tipo_VehiculoD(this.conexion);
        ArrayList vehiculos = (ArrayList) pVehiculo.consultarVehiculo();
        if (pVehiculo.isError()) {
            JOptionPane.showMessageDialog(null,
                    "Error consultando a la base de datos, detalle técnico:" + pVehiculo.getErrorMsg());
        } else {
            this.datos = new String[vehiculos.size()][3];
            for (int i = 0; i < vehiculos.size(); i++) {
                Tipo_Vehiculo aux = (Tipo_Vehiculo) vehiculos.get(i);
                this.datos[i][0] = aux.getCodigo();
                this.datos[i][1] = aux.getDescripcion();
                this.datos[i][2] = String.valueOf(aux.getTarifa_por_hora());

            }
            this.modelo.setDataVector(datos, cabeceras);
            this.tblVehiculos.setModel(modelo);
        }
    }

    /**
     * Creates new form ofrmMantenimientoVehiculo
     */
    public ofrmMantenimientoVehiculo(java.awt.Frame parent, boolean modal, AccesoDatosMySql pConexion) {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tblVehiculos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        // TODO add your handling code here:
//        //Tipo_Vehiculo oVehiculo = new Tipo_Vehiculo(ofrmVehiculo.getTxtCodigo(), ofrmVehiculo.getTxtDescripcion(), ofrmVehiculo.getSpnTarifa());
//        //Tipo_VehiculoD oVehiculoD = new Tipo_VehiculoD(conexion);
//        //oVehiculoD.insertarVehiculo(oVehiculo);
//        if (oVehiculoD.isError()) {
//            JOptionPane.showMessageDialog(null,
//                    "Error consultando a la base de datos, detalle técnico: " + oVehiculoD.getErrorMsg());
//        } else {
//            this.refrescar();
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        if (this.datos.length > 0) {
//            int fila = this.tblVehiculos.getSelectedRow();
//            if (fila >= 0) {
//                String pCedulaAnterior = this.datos[fila][0];
//                frmEdicionVehiculos ofrm = new frmEdicionVehiculos(null, true, this.datos[fila][0], this.datos[fila][1], Double.parseDouble(this.datos[fila][2]));
//                ofrm.setVisible(true);
//                if (ofrm.isAceptar()) {
//                    Tipo_Vehiculo oVehiculo = new Tipo_Vehiculo(ofrm.getTxtCodigo(), ofrm.getTxtDescripcion(), ofrm.getSpnTarifa());
//                    Tipo_VehiculoD oVehiculoD = new Tipo_VehiculoD(this.conexion);
//                    oVehiculoD.actualizarVehiculo(oVehiculo, pCedulaAnterior);
//                    if (oVehiculoD.isError()) {
//                        JOptionPane.showMessageDialog(null,
//                                "Error consultando a la base de datos, detalle técnico:" + oVehiculoD.getErrorMsg());
//                    } else {
//                        this.refrescar();
//                    }
//                }
//            }
//        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        if (this.datos.length > 0) {
//            int respuesta = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que desealo Eliminarlo? Si o No?", "Confirmación", JOptionPane.YES_NO_OPTION);
//            if (respuesta == JOptionPane.YES_OPTION) {
//                int fila = this.tblVehiculos.getSelectedRow();
//                if (fila >= 0) {
//                    Tipo_Vehiculo oVehiculo = new Tipo_Vehiculo(this.datos[fila][0], this.datos[fila][1], Double.parseDouble(this.datos[fila][2]));
//                    Tipo_VehiculoD oVehiculoD = new Tipo_VehiculoD(this.conexion);
//                    oVehiculoD.borrarVehiculo(oVehiculo);
//                    if (oVehiculoD.isError()) {
//                        JOptionPane.showMessageDialog(null,
//                                "Error consultando a la base de datos, detalle técnico:" + oVehiculoD.getErrorMsg());
//                    } else {
//                        this.refrescar();
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
}
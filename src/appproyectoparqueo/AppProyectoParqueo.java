/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appproyectoparqueo;

import accesoDatos.AccesoDatosMySql;
import java.io.IOException;
import javax.swing.JOptionPane;
import logica.Empleado;
import org.hyperic.sigar.*;
import vista.frmLogin;
import vista.frmPrincipal;

/**
 * Empresa: SoftValue Software: Area De Mercadeo Desarrollador: Ignacio Valerio
 */
public class AppProyectoParqueo {

    static AccesoDatosMySql oAccesoDatos;

    public static void main(String[] args) throws IOException {
        
        Config cfg = new Config(System.getProperty("user.dir")
                + "//config.cfg");
        String[] param = cfg.leerConfiguracion();
        if (cfg.getIsError()) {
            JOptionPane.showMessageDialog(null, "Error inesperado durante la ejecución del programa. Detalle técnico:\n" + cfg.getErrorDescripcion(), "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            oAccesoDatos = new AccesoDatosMySql(param[3], param[4], param[2], param[0], param[1],
                    "com.mysql.jdbc.Driver", param[5]);
            oAccesoDatos.conectar();
            if (oAccesoDatos.isError()) {
                JOptionPane.showMessageDialog(null,
                        "Error conectando a la base de datos, detalle técnico: \n" + oAccesoDatos.getErrorMsg());
            } else {

                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 */
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new frmLogin(oAccesoDatos).setVisible(true);
                    }
                });
            }
        }
    }
}

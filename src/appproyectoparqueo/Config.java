/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appproyectoparqueo;

/**
 *
 * @author MainorAlonso
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Config {

    private Properties configFile;
    private boolean isError = false;
    private String errorDescripcion = "";

    public Config(String pRutaArchivo) throws IOException {
        configFile = new java.util.Properties();
        File ruta = new File("C:\\Sistema Punto Venta\\Archivo configuración\\");
        if (!ruta.exists()) {
                try {
                    ruta.mkdirs();
                } catch (Exception xp) {
                    JOptionPane.showMessageDialog(null, "Error al intentar crear el directorio. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        String fileName = pRutaArchivo;
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            configFile.load(is);
        } catch (FileNotFoundException e) {
            isError = true;
            errorDescripcion = e.getMessage();
        }
    }

    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }

    public boolean getIsError() {
        return isError;
    }

    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }

    public String[] leerConfiguracion() {
        String[] parametros = new String[6];
        for (int k = 0; k < parametros.length; k++) {
            parametros[k] = "";
        }
        //Cargo variables                      
        parametros[0] = this.getProperty("Server");
        parametros[1] = this.getProperty("Port");
        parametros[2] = this.getProperty("Base");
        parametros[3] = this.getProperty("User");
        parametros[4] = this.getProperty("Pass");
        parametros[5] = this.getProperty("Schema");
        return parametros;
    }

    public void escribirConfiguracion(String [] pPrarametros) {
    }
}

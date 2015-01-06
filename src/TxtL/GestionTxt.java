/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TxtL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Ignacio
 */
public class GestionTxt {

    private String errorDescripcion;
    private boolean error;
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    public GestionTxt() {
        errorDescripcion = "";
        error = false;
    }

    public String[] leerConexionTxt() {

        //Lectura del fichero
        String linea = "";
        int line = 0;
        String[] datos = new String[6];
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("src\\frmCodigoBarras\\bin\\Debug\\ConexionTemp.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                datos[line] = linea;
                line++;
            }
            br.close();
            fr.close();

        } catch (Exception e) {
            error = true;
            errorDescripcion = e.getMessage();
        }
        return datos;
    }

    public void escrituraDatosFotoPerfil(String pNombreEmpleado, String pNumeroCedula) {
        FileWriter fichero = null;
        File directorio;
        PrintWriter pw = null;
        try {
            directorio = new File("C:\\Sistema Punto Venta\\frmTomarFoto\\bin\\Debug\\Carpeta temporal");
            if (!directorio.exists()) {
                try {
                    directorio.mkdirs();
                } catch (Exception xp) {
                    JOptionPane.showMessageDialog(null, "Error al intentar crear el directorio. Detalle técnico: " + xp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            fichero = new FileWriter("C:\\Sistema Punto Venta\\frmTomarFoto\\bin\\Debug\\Carpeta temporal\\DatosTempEmpleado.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        pw.print(pNumeroCedula);
                        break;
                    case 1:
                        pw.print("," + pNombreEmpleado);
                        break;
                    case 2:
                    default:;
                }
            }
        } catch (Exception e) {
            error = true;
            errorDescripcion = e.getMessage();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                error = true;
                errorDescripcion = e2.getMessage();
            }
        }
    }

    public void escrituraConexionTxt(
            String pServidor, String pPuerto, String pBaseDatos,
            String pUsuario, String pContrasenna, String pEsquema
    ) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Sistema Punto Venta\\frmCodigoBarras\\bin\\Debug\\ConexionTemp.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        pw.print(pServidor);
                        break;
                    case 1:
                        pw.print("," + pPuerto);
                        break;
                    case 2:
                        pw.print("," + pBaseDatos);
                        break;
                    case 3:
                        pw.print("," + pUsuario);
                        break;
                    case 4:
                        pw.print("," + pContrasenna);
                        break;
                    case 5:
                        pw.print("," + pEsquema);
                }
            }
        } catch (Exception e) {
            error = true;
            errorDescripcion = e.getMessage();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                error = true;
                errorDescripcion = e2.getMessage();
            }
        }
    }

    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import XmlD.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logica.Clientes;
import logica.Inventario;

/**
 *
 * @author Ignacio
 */
public class ClientesD {

    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;

    public ClientesD(AccesoDatosMySql pConexion) {
        conexion = pConexion;
        error = false;
        errorMsg = "";
    }
 public List<Inventario> filtrarCliente(String pFiltro, String pOpcion) {

        ArrayList registros = new ArrayList();
        //"SELECT * FROM Inventario WHERE Descripcion LIKE '%" + pFiltro + "'"
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM CLIENTE WHERE " + pOpcion + " like '%" + pFiltro + "%'");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Clientes oCliente = new Clientes(
                            rs.getInt("Id"),
                            rs.getString("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Telefono"),
                            rs.getString("Direccion"),
                            rs.getString("Estado_Cliente_FK"),
                            rs.getString("Fecha_Creacion"),
                            rs.getString("Fecha_Modificacion"),
                            rs.getInt("Modificado_Por"),
                            rs.getShort("Creado_Por")
                    );
                    registros.add(oCliente);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }
    public List<Inventario> consultarRegistro() {

        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM CLIENTE");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Clientes oCliente = new Clientes(
                            rs.getInt("Id"),
                            rs.getString("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Telefono"),
                            rs.getString("Direccion"),
                            rs.getString("Estado_Cliente_FK"),
                            rs.getString("Tipo_Cliente_FK"),
                            rs.getString("Fecha_Creacion"),
                            rs.getString("Fecha_Modificacion"),
                            rs.getString("Modificado_Por"),
                            rs.getString("Creado_Por")
                    );
                    registros.add(oCliente);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}

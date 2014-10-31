/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

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

    public List<Inventario> consultarRegistro() {

        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM Cliente_Credito");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Clientes oCliente = new Clientes(
                            rs.getInt(Integer.parseInt("Id_Cod_Cliente")),
                            rs.getInt("Cedula"),
                            rs.getString("Nombre"),
                            rs.getString("Apellidos"),
                            rs.getString("Telefono"),
                            rs.getString("Celular"),
                            rs.getString("Direccion"),
                            rs.getString("Email"),
                            rs.getString("Fax"),
                            rs.getString("Observacion"),
                            rs.getDouble("Limite_Credito"),
                            rs.getDouble("Monto_Actual")
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

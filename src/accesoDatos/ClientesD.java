/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

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

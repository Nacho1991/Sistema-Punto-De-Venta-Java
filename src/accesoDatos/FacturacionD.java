package accesoDatos;

/**
 *
 * @author Ignacio
 */
public class FacturacionD {

    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;

    public FacturacionD(AccesoDatosMySql pConexion) {
        this.conexion = pConexion;
        this.error = false;
        this.errorMsg = "";
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

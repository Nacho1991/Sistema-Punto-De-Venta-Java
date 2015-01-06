package accesoDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logica.Facturacion;
import logica.Inventario;

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

    public List<Facturacion> obtenerUltimaFactura() {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL(
                "SELECT IFNULL(MAX(CAST(Numero_Factura AS UNSIGNED)),0)Numero_Factura FROM FACTURACION"
        );
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {
                    Facturacion oUltimaFactura = new Facturacion(
                            rs.getInt("Numero_Factura")
                    );
                    registros.add(oUltimaFactura);
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

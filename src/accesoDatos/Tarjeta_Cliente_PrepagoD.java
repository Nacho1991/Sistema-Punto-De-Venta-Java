/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logica.Tarjeta_Cliente_Prepago;

/**
 *
 * @author Esmar
 */
public class Tarjeta_Cliente_PrepagoD {
    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;

    public Tarjeta_Cliente_PrepagoD(AccesoDatosMySql pConexion) {
        this.conexion = pConexion;
        this.error = false;
        this.errorMsg = "";
    }
    
     public void insertarTarjetaPrepago(Tarjeta_Cliente_Prepago pTarjeta_Cliente_Prepago) {
        this.limpiarError();
        String sql = "INSERT INTO "+this.conexion.getEsquema()+"tarjeta_cliente_prepago(codigo, cedula_cliente, nombre_cliente, saldo_actual, porcentaje_descuento)"
                + "VALUES (?, ?, ?, ?, ?)";
        Parametro[] oP = new Parametro[5];
        oP[0] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getCodigo());
        oP[1] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getCedula_cliente());
        oP[2] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getNombre_cliente());
        oP[3] = new Parametro(Parametro.DOUBLE, pTarjeta_Cliente_Prepago.getSaldo_actual());
        oP[4] = new Parametro(Parametro.DOUBLE,pTarjeta_Cliente_Prepago.getPorcentaje_descuento());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
     
    
    public void actualizarTarjetaPrepago(Tarjeta_Cliente_Prepago pTarjeta_Cliente_Prepago, String pCodigoAnterior){
        this.limpiarError();
        String sql = "UPDATE "+this.conexion.getEsquema()+"tarjeta_cliente_prepago SET codigo = ?, cedula_cliente = ?, nombre_cliente = ?, saldo_actual = ?, porcentaje_descuento = ? " +
                     "WHERE  codigo = ?";
        Parametro[] oP = new Parametro[6];
        oP[0] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getCodigo());
        oP[1] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getCedula_cliente());
        oP[2] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getNombre_cliente());
        oP[3] = new Parametro(Parametro.DOUBLE, pTarjeta_Cliente_Prepago.getSaldo_actual());
        oP[4] = new Parametro(Parametro.DOUBLE, pTarjeta_Cliente_Prepago.getPorcentaje_descuento());
        oP[5] = new Parametro(Parametro.STRING, pCodigoAnterior);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();            
        }
    }
    
     public void borrarTarjetaPrepago(Tarjeta_Cliente_Prepago pTarjeta_Cliente_Prepago){
        this.limpiarError();
        String sql = "DELETE FROM "+this.conexion.getEsquema()+"tarjeta_cliente_prepago WHERE codigo = ?";
        Parametro[] oP = new Parametro[1];
        oP[0] = new Parametro(Parametro.STRING, pTarjeta_Cliente_Prepago.getCodigo());        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();            
        }
    }
     
     

     public List<Tarjeta_Cliente_Prepago> consultarTarjetaPrepago(){
        this.limpiarError();
        List<Tarjeta_Cliente_Prepago> tarjetas = new ArrayList();        
        
        ResultSet rsTarjetas = this.conexion.ejecutarConsultaSQL("select * from " + 
                                                         conexion.getEsquema() + 
                                                         "tarjeta_cliente_prepago");
        this.error = this.conexion.isError();
        this.errorMsg = this.conexion.getErrorMsg();
        if (!this.isError()){
            try{
                while(rsTarjetas.next()){
                    Tarjeta_Cliente_Prepago oTarjetas = new Tarjeta_Cliente_Prepago(rsTarjetas.getString("codigo"),
                                             rsTarjetas.getString("cedula_cliente"),
                                             rsTarjetas.getString("nombre_cliente"),
                                             rsTarjetas.getDouble("saldo_actual"),
                                             rsTarjetas.getDouble("porcentaje_descuento"));
                    tarjetas.add(oTarjetas);
                }
                 rsTarjetas.close();
            }catch(Exception e){   
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return tarjetas;
    }
    
    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }


    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @return the error
     */
    public boolean isError() {
        return error;
    }
    
    
    
    
}

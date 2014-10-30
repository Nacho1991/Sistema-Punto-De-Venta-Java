/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logica.*;
/**
 *
 * @author Esmar
 */
public class Tipo_VehiculoD {
    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;

    public Tipo_VehiculoD(AccesoDatosMySql pConexion) {
        this.conexion = pConexion;
        this.error = false;
        this.errorMsg = "";
        
        
    }
    
 
    public void insertarVehiculo(Tipo_Vehiculo oTipo_Vehiculo){
        limpiarError();
        String sql = "INSERT INTO " + conexion.getEsquema() + "tipo_vehiculo "
                + "(codigo, descripcion, tarifa_por_hora) "
                + "VALUES (?, ?, ?)";
        Parametro[] oP = new Parametro[3];
        oP[0] = new Parametro(Parametro.STRING, oTipo_Vehiculo.getCodigo());
        oP[1] = new Parametro(Parametro.STRING, oTipo_Vehiculo.getDescripcion());
        oP[2] = new Parametro(Parametro.DOUBLE, oTipo_Vehiculo.getTarifa_por_hora());
        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    } 
   
    public void actualizarVehiculo(Tipo_Vehiculo pTipo_Vehiculo, String pCedulaAnterior){        
        limpiarError();
        String sql = "UPDATE " + conexion.getEsquema() + "tipo_vehiculo " +
                     "set codigo = ?, descripcion = ?, tarifa_por_hora = ? " +
                     "where codigo = ?";
        Parametro[] oP = new Parametro[4];
        oP[0] = new Parametro(Parametro.STRING, pTipo_Vehiculo.getCodigo());
        oP[1] = new Parametro(Parametro.STRING, pTipo_Vehiculo.getDescripcion());
        oP[2] = new Parametro(Parametro.DOUBLE, pTipo_Vehiculo.getTarifa_por_hora());
        oP[3] = new Parametro(Parametro.STRING, pCedulaAnterior);         
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();            
        }
    }
    
   
    
    public void borrarVehiculo(Tipo_Vehiculo pTipo_Vehiculo){
        limpiarError();
        String sql = "DELETE FROM " + conexion.getEsquema() + "tipo_vehiculo " +
                     "WHERE codigo = ?";
        Parametro[] oP = new Parametro[1];
        oP[0] = new Parametro(Parametro.STRING, pTipo_Vehiculo.getCodigo());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();            
        }
    }
    
    public List<Tipo_Vehiculo> consultarVehiculo(){
        this.limpiarError();
        List<Tipo_Vehiculo>  vehiculos= new ArrayList();        
       
        ResultSet rsVehiculo = this.conexion.ejecutarConsultaSQL("SELECT * FROM " + 
                                                         conexion.getEsquema() + 
                                                         "tipo_vehiculo");
        this.error = this.conexion.isError();
        this.errorMsg = this.conexion.getErrorMsg();
        if (!this.error){
            try{
                while(rsVehiculo.next()){
                    Tipo_Vehiculo oVehiculo = new Tipo_Vehiculo(rsVehiculo.getString("codigo"),
                                             rsVehiculo.getString("descripcion"),
                                             rsVehiculo.getDouble("tarifa_por_hora"));
                    vehiculos.add(oVehiculo);
                }
            }catch(Exception e){   
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return vehiculos;
    }
    
     private void limpiarError()
    {
        this.error = false;
        this.errorMsg = "";
    }

    /**
     * @return the error
     */
    public boolean isError() {
        return error;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }
     
     
     
}

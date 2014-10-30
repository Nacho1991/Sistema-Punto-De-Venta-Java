/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logica.Registro_Parqueo;



/**
 *
 * @author Esmar
 */
public class Registro_ParqueoD {
    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;

    public Registro_ParqueoD(AccesoDatosMySql pConexion) {
        this.conexion = pConexion;
        this.error = false;
        this.errorMsg = "";
    }
    
     public void insertarParqueo(Registro_Parqueo pRegistroParqueo){
        limpiarError();
        String sql = "INSERT INTO " + conexion.getEsquema() + "registro_parqueo "
                + "(placa, fecha_hora_entrada, tipo_vehiculo, nombre_cliente, fecha_hora_salida,"
                + " tarjeta_prepago, cantidad_horas, tarifa_hora, porcentaje_descuento, monto_descuento, total_pagar) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Parametro[] oP = new Parametro[11];
        oP[0] = new Parametro(Parametro.STRING, pRegistroParqueo.getPlaca());
        oP[1] = new Parametro(Parametro.STRING, pRegistroParqueo.getFecha_hora_entrada());
        oP[2] = new Parametro(Parametro.STRING, pRegistroParqueo.getTipo_vehiculo());
        oP[3] = new Parametro(Parametro.STRING, pRegistroParqueo.getNombre_cliente());
        oP[4] = new Parametro(Parametro.STRING, pRegistroParqueo.getFecha_hora_salida());
        oP[5] = new Parametro(Parametro.STRING, pRegistroParqueo.getTarjeta_prepago());
        oP[6] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getCantidad_horas());
        oP[7] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getTarifa_hora());
        oP[8] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getPorcentaje_descuento());
        oP[9] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getMonto_descuento());
        oP[10] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getTotal_pagar());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
      public void actualizarParqueo(Registro_Parqueo pRegistroParqueo, String pPlacaAnterior){        
        limpiarError();
        String sql = "UPDATE " + conexion.getEsquema() + "registro_parqueo " +
                     "set placa = ?, fecha_hora_entrada = ?, tipo_vehiculo = ?, nombre_cliente = ?, fecha_hora_salida = ?,"
                +" tarjeta_prepago = ?, cantidad_horas = ?, tarifa_hora = ?, porcentaje_descuento = ?, monto_descuento = ?, total_pagar = ? " +
                     "WHERE placa = ?";
        Parametro[] oP = new Parametro[12];
        oP[0] = new Parametro(Parametro.STRING, pRegistroParqueo.getPlaca());
        oP[1] = new Parametro(Parametro.STRING, pRegistroParqueo.getFecha_hora_entrada());
        oP[2] = new Parametro(Parametro.STRING, pRegistroParqueo.getTipo_vehiculo());
        oP[3] = new Parametro(Parametro.STRING, pRegistroParqueo.getNombre_cliente());
        oP[4] = new Parametro(Parametro.STRING, pRegistroParqueo.getFecha_hora_salida());
        oP[5] = new Parametro(Parametro.STRING, pRegistroParqueo.getTarjeta_prepago());
        oP[6] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getCantidad_horas());
        oP[7] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getTarifa_hora());
        oP[8] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getPorcentaje_descuento());
        oP[9] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getMonto_descuento());
        oP[10] = new Parametro(Parametro.DOUBLE, pRegistroParqueo.getTotal_pagar());
        oP[11] = new Parametro(Parametro.STRING, pPlacaAnterior);         
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();            
        }
    }
     public void borrarRegistro(Registro_Parqueo pRegistro_Parqueo)
    {
        String sql = "delete from " + conexion.getEsquema() + "registro_parqueo " +
                     "where placa = ?";
        Parametro[] oP = new Parametro[1];
        oP[0] = new Parametro(Parametro.STRING, pRegistro_Parqueo.getPlaca());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();            
        }
    }
    public List<Registro_Parqueo> consultarRegistro(){
     
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("select * from " + conexion.getEsquema() +"registro_parqueo ");
                                                
        if (this.conexion.isError())
        {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();                        
        }else{                                
            try{                
                while (rs.next()){
                    
                    Registro_Parqueo oRegistro =new Registro_Parqueo(rs.getString("placa"),
                                                  rs.getString("fecha_hora_entrada"),
                                                  rs.getString("tipo_vehiculo"),
                                                  rs.getString("nombre_cliente"),
                                                  rs.getString("fecha_hora_salida"),
                                                  rs.getString("tarjeta_prepago"),
                                                  rs.getDouble("cantidad_horas"),
                                                  rs.getDouble("tarifa_hora"),
                                                  rs.getDouble("porcentaje_descuento"),
                                                  rs.getDouble("monto_descuento"),
                                                  rs.getDouble("total_pagar")
                                                );
                    registros.add(oRegistro);
                }
                rs.close();
            }catch(Exception e){
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
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

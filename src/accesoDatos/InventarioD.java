/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.*;
import java.util.*;
import logica.*;

public class InventarioD {

    private AccesoDatosMySql conexion;
    private boolean error;
    private String errorMsg;

    public InventarioD(AccesoDatosMySql pConexion) {
        this.conexion = pConexion;
        this.error = false;
        this.errorMsg = "";
    }

    public List<Inventario> consultarRegistro() {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM INVENTARIO");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Inventario oInventario = new Inventario(
                            rs.getInt("Id"),
                            rs.getString("Codigo_Articulo"),
                            rs.getString("Nombre"),
                            rs.getString("Marca"),
                            rs.getString("Descripcion"),
                            rs.getDouble("Precio_Compra"),
                            rs.getDouble("Precio_Venta"),
                            rs.getString("Existencia"),
                            rs.getInt("Cantidad"),
                            rs.getString("Fecha_Entrada")
                    );
                    registros.add(oInventario);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public List<Inventario> obtenerProducto(String pCodigo) {
        ArrayList registros = new ArrayList();
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM INVENTARIO WHERE Codigo_Articulo=" + pCodigo);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Inventario oInventario = new Inventario(
                            rs.getInt("Id"),
                            rs.getString("Codigo_Articulo"),
                            rs.getString("Nombre"),
                            rs.getString("Marca"),
                            rs.getString("Descripcion"),
                            rs.getDouble("Precio_Compra"),
                            rs.getDouble("Precio_Venta"),
                            rs.getString("Existencia"),
                            rs.getInt("Cantidad"),
                            rs.getString("fecha_entrada")
                    );
                    registros.add(oInventario);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    

    public List<Inventario> filtrarInventario(String pFiltro, String pOpcion) {

        ArrayList registros = new ArrayList();
        //"SELECT * FROM Inventario WHERE Descripcion LIKE '%" + pFiltro + "'"
        ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM INVENTARIO WHERE " + pOpcion + " like '%" + pFiltro + "%'");

        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        } else {
            try {
                while (rs.next()) {

                    Inventario oInventario = new Inventario(
                            rs.getInt("Id"),
                            rs.getString("Codigo_Articulo"),
                            rs.getString("Nombre"),
                            rs.getString("Marca"),
                            rs.getString("Descripcion"),
                            rs.getDouble("Precio_Compra"),
                            rs.getDouble("Precio_Venta"),
                            rs.getString("Existencia"),
                            rs.getInt("Cantidad"),
                            rs.getString("fecha_entrada")
                    );
                    registros.add(oInventario);
                }
                rs.close();
            } catch (Exception e) {
                this.error = true;
                this.errorMsg = e.getMessage();
            }
        }
        return registros;
    }

    public void insertarProducto(Inventario pInventario) {
        limpiarError();
        String sql
                = "INSERT INTO INVENTARIO (Codigo_Articulo,Nombre, Marca, Descripcion, Precio_Compra, Precio_Venta, Existencia, Cantidad, Fecha_Entrada) VALUES (?,?,?,?,?,?,?,?,?)";
        Parametro[] oP = new Parametro[9];
        oP[0] = new Parametro(Parametro.STRING, pInventario.getCodigoArticulo());
        oP[1] = new Parametro(Parametro.STRING, pInventario.getNombre());
        oP[2] = new Parametro(Parametro.STRING, pInventario.getMarca());
        oP[3] = new Parametro(Parametro.STRING, pInventario.getDescripcion());
        oP[4] = new Parametro(Parametro.DOUBLE, pInventario.getPrecioCompra());
        oP[5] = new Parametro(Parametro.DOUBLE, pInventario.getPrecioVenta());
        oP[6] = new Parametro(Parametro.STRING, pInventario.getExistencia());
        oP[7] = new Parametro(Parametro.INT, pInventario.getCantidad());
        oP[8] = new Parametro(Parametro.STRING, pInventario.getFechaEntrada());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public void actualizarProducto(Inventario pInventario, String pCodProducto) {
        limpiarError();
        String sql = "UPDATE INVENTARIO SET Codigo_Articulo = ?, Nombre = ?, Marca = ?, Descripcion = ?, Precio_Compra = ?, Precio_Venta = ?, Existencia = ?, Cantidad = ?, fecha_entrada = ? WHERE Id = ?";
        Parametro[] oP = new Parametro[10];
        oP[0] = new Parametro(Parametro.STRING, pInventario.getCodigoArticulo());
        oP[1] = new Parametro(Parametro.STRING, pInventario.getNombre());
        oP[2] = new Parametro(Parametro.STRING, pInventario.getMarca());
        oP[3] = new Parametro(Parametro.STRING, pInventario.getDescripcion());
        oP[4] = new Parametro(Parametro.DOUBLE, pInventario.getPrecioCompra());
        oP[5] = new Parametro(Parametro.DOUBLE, pInventario.getPrecioVenta());
        oP[6] = new Parametro(Parametro.STRING, pInventario.getExistencia());
        oP[7] = new Parametro(Parametro.INT, pInventario.getCantidad());
        oP[8] = new Parametro(Parametro.STRING, pInventario.getFechaEntrada());
        oP[9] = new Parametro(Parametro.STRING, pCodProducto);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    public void borrarProducto(Inventario pInventario) {
        String sql = "DELETE FROM INVENTARIO "
                + "WHERE Codigo_Articulo = ?";
        Parametro[] oP = new Parametro[1];
        oP[0] = new Parametro(Parametro.STRING, pInventario.getCodigoArticulo());
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }

    private void limpiarError() {
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

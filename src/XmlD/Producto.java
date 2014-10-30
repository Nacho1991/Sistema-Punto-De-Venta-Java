/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XmlD;

import java.util.Date;

/**
 *
 * @author ignacio
 */
public class Producto {

    //Variables encargadas para los datos de los productos
    private String codigo;
    private String descripcion;
    private String cantidad;
    private String disponible;
    private String precioUnitario;
    private String precioTotal;

    //Constructor
    public Producto(String pCodigo, String pDescripcion, String pCantidad, String pDisponible, String pPrecioUnitario, String pPrecioTotal) {
        codigo = pCodigo;
        descripcion = pDescripcion;
        cantidad = pCantidad;
        disponible = pDisponible;
        precioUnitario = pPrecioUnitario;
        precioTotal = pPrecioTotal;
    }

    //Gets y Sets
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(String precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCodprecioTotal() {
        return precioTotal;
    }

    public void setCodprecioTotal(String codprecioTotal) {
        this.precioTotal = codprecioTotal;
    }

}

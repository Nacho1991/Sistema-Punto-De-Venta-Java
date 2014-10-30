/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.sql.Date;

/**
 *
 * @author ignacio
 */
public class Inventario {
    
    private String codProducto;
    private String nombre;
    private String marca;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private String existencia;
    private int cantidad;
    private String fechaEntrada;

    public Inventario(String pCodigo, String pNombre, String pMarca, String pDescripcion, double pPrecioCompra,double pPrecioVenta, String pExistencia,int pCantidad,String pFechaEntrada) {
        this.codProducto = pCodigo;
        this.nombre = pNombre;
        this.marca = pMarca;
        this.descripcion = pDescripcion;
        this.precioCompra = pPrecioCompra;
        this.precioVenta = pPrecioVenta;
        this.existencia = pExistencia;
        this.cantidad = pCantidad;
        this.fechaEntrada = pFechaEntrada;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    
}

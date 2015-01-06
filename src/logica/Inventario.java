/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author ignacio
 */
public class Inventario {

    private int id;
    private String codigoArticulo;
    private String nombre;
    private String marca;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private String existencia;
    private int cantidad;
    private String fechaEntrada;

    public Inventario(int pId, String pCodigo, String pNombre, String pMarca, String pDescripcion, double pPrecioCompra, double pPrecioVenta, String pExistencia, int pCantidad, String pFechaEntrada) {
        this.id = pId;
        this.codigoArticulo = pCodigo;
        this.nombre = pNombre;
        this.marca = pMarca;
        this.descripcion = pDescripcion;
        this.precioCompra = pPrecioCompra;
        this.precioVenta = pPrecioVenta;
        this.existencia = pExistencia;
        this.cantidad = pCantidad;
        this.fechaEntrada = pFechaEntrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
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

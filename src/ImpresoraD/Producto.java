/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresoraD;

/**
 *
 * @author Rolando
 */
public class Producto {
    
    //Variables para la tabla de los productos de la factura
    private int cantidad;
    private int condigo;
    private String descripcion;
    private double precioUnitario;
    private int precioTotal;
    private int descuento;
    private int pago;
    private int vuelto;

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public int getVuelto() {
        return vuelto;
    }

    public void setVuelto(int vuelto) {
        this.vuelto = vuelto;
    }
    
    //Gets y Sets
    public int getCondigo() {
        return condigo;
    }

    public void setCondigo(int condigo) {
        this.condigo = condigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Ignacio
 */
public class Facturacion {

    private int numeroFactura;
    private String cedulaCliente;
    private String cedulaEmpleado;
    private String observacion;
    private String fechaEmitida;
    private String vendidoPor;
    

    public Facturacion(int pNumeroFactura) {
        numeroFactura = pNumeroFactura;
    }

    public Facturacion(int numeroFactura, String cedulaCliente, String cedulaEmpleado, String observacion, String fechaEmitida, String vendidoPor) {
        this.numeroFactura = numeroFactura;
        this.cedulaCliente = cedulaCliente;
        this.cedulaEmpleado = cedulaEmpleado;
        this.observacion = observacion;
        this.fechaEmitida = fechaEmitida;
        this.vendidoPor = vendidoPor;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFechaEmitida() {
        return fechaEmitida;
    }

    public void setFechaEmitida(String fechaEmitida) {
        this.fechaEmitida = fechaEmitida;
    }

    public String getVendidoPor() {
        return vendidoPor;
    }

    public void setVendidoPor(String vendidoPor) {
        this.vendidoPor = vendidoPor;
    }

}

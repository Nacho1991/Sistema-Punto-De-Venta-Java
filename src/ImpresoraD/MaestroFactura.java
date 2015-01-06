/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresoraD;

/**
 *
 * @author Ignacio
 */
public class MaestroFactura {

    //Variables para los datos de la factura
    private String nombreCliente;
    private String cedulaCliente;
    private String numeroFactura;
    private String direccionCliente;
    private String condicionPago;
    private String fechaEmision;
    private String telefono;
    private String nombreVendedor;
    private String observacion;

    //Gets y Sets
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setCedulaCliente(String apellidoCliente) {
        this.cedulaCliente = apellidoCliente;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}

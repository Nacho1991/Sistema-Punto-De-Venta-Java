/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XmlD;

/**
 *
 * @author ignacio
 */
public class Cliente {

    //Variables para los datos de los clientes
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tipoCliente;

    //Constructor
    public Cliente(String pCedula, String pNombre, String pDireccion, String pTelefono, String pTipoCliente) {
        cedula = pCedula;
        nombre = pNombre;
        direccion = pDireccion;
        telefono = pTelefono;
        tipoCliente = pTipoCliente;
    }

    //gets y sets
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}

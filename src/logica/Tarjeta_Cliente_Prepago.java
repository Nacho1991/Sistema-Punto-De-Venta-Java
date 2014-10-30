/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Esmar
 */
public class Tarjeta_Cliente_Prepago {
    private String codigo; 
    private String cedula_cliente;
    private String nombre_cliente;
    private double saldo_actual;
    private double porcentaje_descuento;

    public Tarjeta_Cliente_Prepago(String codigo, String cedula_cliente, String nombre_cliente, double saldo_actual, double porcentaje_descuento) {
        this.codigo = codigo;
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.saldo_actual = saldo_actual;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }
    
    @Override
    public String toString(){
        return //"Codigo "+this.codigo+"Cedula Cliente "+this.cedula_cliente+
                //"Nombre_Cliente "+
                this.nombre_cliente;//+"Saldo actual "+this.saldo_actual+
                //"Porcentaje Descuento "+this.porcentaje_descuento;
        
    }
}

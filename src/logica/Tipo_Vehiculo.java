/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Esmar
 */
public class Tipo_Vehiculo {
    private String codigo;
    private String descripcion;
    private double tarifa_por_hora;

    public Tipo_Vehiculo(String codigo, String descripcion, double tarifa_por_hora) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tarifa_por_hora = tarifa_por_hora;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTarifa_por_hora() {
        return tarifa_por_hora;
    }

    public void setTarifa_por_hora(double tarifa_por_hora) {
        this.tarifa_por_hora = tarifa_por_hora;
    }
    
    @Override
    public String toString(){
       return //"codigo "+this.codigo+
               //"descripcion "+
               this.descripcion;
               //+"tarifa por hora" +this.tarifa_por_hora; 
    }
}

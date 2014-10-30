/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Esmar
 */
public class Registro_Parqueo {
    private String placa;
    private String fecha_hora_entrada;
    private String tipo_vehiculo;
    private String nombre_cliente;
    private String fecha_hora_salida;
    private String tarjeta_prepago;
    private double cantidad_horas;
    private double tarifa_hora;
    private double porcentaje_descuento;
    private double monto_descuento;
    private double total_pagar;

    public Registro_Parqueo(String placa, String fecha_hora_entrada, String pTipo_vehiculo, String nombre_cliente, String fecha_hora_salida,String tarjeta_prepago, double cantidad_horas,double tarifa_hora,double porcentaje_descuento, double monto_descuento, double total_pagar) {
        this.placa = placa;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.tipo_vehiculo = pTipo_vehiculo;
        this.nombre_cliente = nombre_cliente;
        this.fecha_hora_salida = fecha_hora_salida;
        this.tarjeta_prepago = tarjeta_prepago;
        this.cantidad_horas = cantidad_horas;
        this.tarifa_hora = tarifa_hora;
        this.porcentaje_descuento = porcentaje_descuento;
        this.monto_descuento = monto_descuento;
        this.total_pagar = total_pagar;
    }
    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getTarjeta_prepago() {
        return tarjeta_prepago;
    }

    public void setTarjeta_prepago(String tarjeta_prepago) {
        this.tarjeta_prepago = tarjeta_prepago;
    }

    public double getCantidad_horas() {
        return cantidad_horas;
    }

    public void setCantidad_horas(double cantidad_horas) {
        this.cantidad_horas = cantidad_horas;
    }

    public double getTarifa_hora() {
        return tarifa_hora;
    }

    public void setTarifa_hora(double tarifa_hora) {
        this.tarifa_hora = tarifa_hora;
    }

    public double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }
    
    public String getFecha_hora_entrada() {
        return fecha_hora_entrada;
    }

    public void setFecha_hora_entrada(String fecha_hora_entrada) {
        this.fecha_hora_entrada = fecha_hora_entrada;
    }

    public String getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(String fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }

    public double getMonto_descuento() {
        return monto_descuento;
    }

    public void setMonto_descuento(double monto_descuento) {
        this.monto_descuento = monto_descuento;
    }

    public double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(double total_pagar) {
        this.total_pagar = total_pagar;
    }
    public Double calcularMontoDescuento(){
        double monDescuento;
            monDescuento=this.porcentaje_descuento * this.tarifa_hora;
        return monDescuento;
        }
    public Double calcularTotalPagar(){
        double subtotal;
        subtotal=calcularMontoDescuento()-(this.tarifa_hora*this.cantidad_horas);
        return subtotal;
    }
    @Override
    public String toString(){
        return "Parqueo "+" Placa "+this.placa+" Tipo Vehiculo"+this.tipo_vehiculo+
                "Nombre Cliente"+this.nombre_cliente;
        
    }
    
}

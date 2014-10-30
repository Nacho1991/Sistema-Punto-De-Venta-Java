/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XmlD;

import java.util.ArrayList;

/**
 *
 * @author ignacio
 */
public class Pedido {

    //Variables
    private String nombrePedido;
    private Cliente cliente;
    //Se crea una variable para guardar la lista de los prodcutos
    private ArrayList<Producto> listaProductos;

    //Constructor
    public Pedido(String nombrePedido, Cliente cliente) {
        this.nombrePedido = nombrePedido;
        this.cliente = cliente;
        this.listaProductos = new ArrayList<Producto>();
    }

    //Gets y Sets
    public String getNombrePedido() {
        return nombrePedido;
    }

    public void setNombrePedido(String nombrePedido) {
        this.nombrePedido = nombrePedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void addProducto(Producto producto) {
        this.listaProductos.add(producto);
    }

}

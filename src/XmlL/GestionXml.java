/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XmlL;

import XmlD.Cliente;
import XmlD.Pedido;
import XmlD.Producto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author ignacio
 */
public class GestionXml {

    private Document dom;
    private boolean isError;
    private String errorDescripcion;

    public GestionXml() {
        dom = null;
        isError = false;
        errorDescripcion = "";
    }

    //Añade los datos de los clientes en archivo xml
    //Recibiendo por parametro la clase cliente y un Nodo Element
    private void addCliente(Cliente cliente, Element nodoCliente) {
        Element cedula = dom.createElement("Cedula");
        Text textoCedula = dom.createTextNode(cliente.getCedula());
        cedula.appendChild(textoCedula);

        Element nombre = dom.createElement("Nombre");
        Text textoNombre = dom.createTextNode(cliente.getNombre());
        nombre.appendChild(textoNombre);

        Element direccion = dom.createElement("Dirección");
        Text textoDireccion = dom.createTextNode(cliente.getDireccion());
        direccion.appendChild(textoDireccion);

        Element telefono = dom.createElement("Telefono");
        Text textoTelefono = dom.createTextNode(cliente.getTelefono());
        telefono.appendChild(textoTelefono);

        Element tipoCliente = dom.createElement("TipoCliente");
        Text textoTipoCliente = dom.createTextNode(cliente.getTipoCliente());
        tipoCliente.appendChild(textoTipoCliente);

        //Se agregan las lineas con sus respectivos datos
        nodoCliente.appendChild(cedula);
        nodoCliente.appendChild(nombre);
        nodoCliente.appendChild(direccion);
        nodoCliente.appendChild(telefono);
        nodoCliente.appendChild(tipoCliente);
    }

    //Añade el producto en el archivo xml
    //Recibiendo por parametro la clase Producto y un nodo Element
    private void addProducto(Producto producto, Element nodoProducto) {
        Element codigo = dom.createElement("Código");
        Text textoCodigo = dom.createTextNode(producto.getCodigo());
        codigo.appendChild(textoCodigo);

        Element descripcion = dom.createElement("Descripción");
        Text textoDescripcion = dom.createTextNode(String.valueOf(producto.getDescripcion()));
        descripcion.appendChild(textoDescripcion);

        Element cantidad = dom.createElement("Cantidad");
        Text textoCantidad = dom.createTextNode(String.valueOf(producto.getCantidad()));
        cantidad.appendChild(textoCantidad);

        Element disponible = dom.createElement("Disponible");
        Text textoDisponible = dom.createTextNode(String.valueOf(producto.getDisponible()));
        disponible.appendChild(textoDisponible);

        Element precioUnitario = dom.createElement("PrecioUnitario");
        Text textoPrecioUnitario = dom.createTextNode(String.valueOf(producto.getPrecioUnitario()));
        precioUnitario.appendChild(textoPrecioUnitario);

        Element precioTotal = dom.createElement("PrecioTotal");
        Text textoPrecioTotal = dom.createTextNode(String.valueOf(producto.getPrecioTotal()));
        precioTotal.appendChild(textoPrecioTotal);

        //Se escriben las lineas xml con sus datos respectivos
        nodoProducto.appendChild(codigo);
        nodoProducto.appendChild(descripcion);
        nodoProducto.appendChild(cantidad);
        nodoProducto.appendChild(disponible);
        nodoProducto.appendChild(precioUnitario);
        nodoProducto.appendChild(precioTotal);
    }

    //Metodo encargado de recorrer la lista de los productos y los escribe por medio de la
    //invocacion del metodo addProducto
    private void addProductos(ArrayList<Producto> listaProductos, Element nodoListaProductos) {
        for (int i = 0; i < listaProductos.size(); i++) {
            Element producto = dom.createElement("Producto");
            addProducto(listaProductos.get(i), producto);
            nodoListaProductos.appendChild(producto);
        }
    }

    //Metodo encargado de escribir la raiz y subraiz del archivo xml
    private void addPedido(Pedido pedido) {
        try {
            // seleccionamos la raiz
            Element root = dom.getDocumentElement();
            // creamos un nuevo elemento con el atributo del numero de producto
            Element unPedido = dom.createElement("Pedido");
            // creamos un nuevo elemento para el cliente
            Element cliente = dom.createElement("Cliente");
            addCliente(pedido.getCliente(), cliente);
            // creamos un nuevo elemento para los productos de los que consta el pedido
            Element productos = dom.createElement("Productos");
            addProductos(pedido.getListaProductos(), productos);
            // insertamos el cliente y los productos en el elemento del pedido
            unPedido.appendChild(cliente);
            unPedido.appendChild(productos);
            // insertamos el pedido en la raiz
            root.appendChild(unPedido);
            // insertamos el pedido en la raiz
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        // insertamos el pedido en la raiz
    }

    /*
     * Escribe en el fichero la representacion del árbol XML
     */
    private void write(StringWriter sw, String path) {
        try {
            // creamos fichero para escribir en modo texto
            PrintWriter writer = new PrintWriter(new FileWriter(path));
            // escribimos todo el arbol en XML
            writer.println(sw.toString());
            // cerramos el fichero
            writer.close();
        } catch (IOException e) {
            isError = true;
            errorDescripcion = e.getMessage();
        }
    }

    /*
     * Transforma el árbol, agregando la cabecera y añadiendo sangrados
     */
    private void toFile(String ruta) {
        try {
            // volcamos el XML al fichero
            TransformerFactory transFact = TransformerFactory.newInstance();

            // añadimos sangrado
            Transformer trans = transFact.newTransformer();
            // incluimos la cabecera XML y el sangrado
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            // hacemos la transformacion
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource domSource = new DOMSource(dom);
            trans.transform(domSource, sr);
            // escribimos en el fichero
            write(sw, ruta);
            sw.close();
        } catch (Exception ex) {
            isError = true;
            errorDescripcion = ex.getMessage();
        }
    }

    /*
     * Creamos un fichero XML a partir de una lista de pedidos
     */
    public void pedidosToXML(ArrayList<Pedido> pedidos, String ruta) {
        // creamos un nuevo Document donde vamos a guardar toda la estructura
        try {
            dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = dom.createElement("Pedidos");
            dom.appendChild(root);
        } catch (ParserConfigurationException e) {
            isError = true;
            errorDescripcion = e.getMessage();
        }
        for (int i = 0; i < pedidos.size(); i++) {
            addPedido(pedidos.get(i));
        }
        // volcamos por pantalla
        toFile(ruta);
    }

    // Lectura de XML con DOM
    private Cliente readClientes(Node nodoUsuario) {
        Element elementoUsuario = (Element) nodoUsuario;
        String cedula = elementoUsuario.getElementsByTagName("Cédula").item(0).getTextContent();
        String nombre = elementoUsuario.getElementsByTagName("Nombre").item(0).getTextContent();
        String direccion = elementoUsuario.getElementsByTagName("Direccion").item(0).getTextContent();
        String telefono = elementoUsuario.getElementsByTagName("Telefono").item(0).getTextContent();
        String tipoCliente = elementoUsuario.getElementsByTagName("Tipo cliente").item(0).getTextContent();
        return new Cliente(cedula, nombre, direccion, telefono, tipoCliente);
    }

    private Producto readProducto(Node nodoProducto) {
        Element elementoProducto = (Element) nodoProducto;

        String codigo = elementoProducto.getElementsByTagName("Código").item(0).getTextContent();
        String descripcion = elementoProducto.getElementsByTagName("Descripción").item(0).getTextContent();
        String cantidad = elementoProducto.getElementsByTagName("Cantidad").item(0).getTextContent();
        String disponible = elementoProducto.getElementsByTagName("Disponible").item(0).getTextContent();
        String precioUnitario = elementoProducto.getElementsByTagName("PrecioUnitario").item(0).getTextContent();
        String precioTotal = elementoProducto.getElementsByTagName("PrecioTotal").item(0).getTextContent();

        return new Producto(codigo, descripcion, cantidad, disponible, precioUnitario, precioTotal);
    }

    //Validamos si el archivo existe en la ruta recibida por parametro
    public boolean existeArchivo(String pRuta) {
        boolean existe = false;
        File fichero = new File(pRuta);
        if (fichero.exists()) {
            existe = true;
        }
        return existe;
    }

    private Pedido readPedido(Node nodoPedido) {
        Element elementoPedido = (Element) nodoPedido;

        String nombrePedido = elementoPedido.getAttribute("numeroPedido");
        Cliente user = readClientes(elementoPedido.getElementsByTagName("Cliente").item(0));
        Pedido pedido = new Pedido(nombrePedido, user);

        NodeList productos = elementoPedido.getElementsByTagName("Productos");
        for (int i = 0; i < productos.getLength(); i++) {
            pedido.addProducto(readProducto((Element) productos.item(0)));
        }
        return pedido;
    }

    /*
     * Creamos una lista de pedidos procesando un fichero XML
     */
    public ArrayList<Pedido> XMLtoPedidos(String ruta) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(new File(ruta));
            dom.getDocumentElement().normalize();

            // seleccionamos todos los pedidos y vamos leyendo
            NodeList listaPedidos = dom.getDocumentElement().getElementsByTagName("Pedido");
            for (int i = 0; i < listaPedidos.getLength(); i++) {
                pedidos.add(readPedido(listaPedidos.item(i)));
            }
        } catch (Exception e) {
            isError = true;
            errorDescripcion = e.getMessage();
        }
        return pedidos;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }
    
}

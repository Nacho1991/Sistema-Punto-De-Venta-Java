/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XmlL;

import XmlD.Producto;
import XmlD.Cliente;
import XmlD.Pedido;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Builder;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import logica.Clientes;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author ignacio
 */
public class GuardarPendientes {

    private String nombreOrden;
    private String errorDescripcion;
    private String rutaPendientes;
    private boolean isError;
    private GestionXml dom;
    private Pedido pedido1;
    private ArrayList<Pedido> pedidos;
    private Producto products;
    private Cliente clienteUno;

    public GuardarPendientes(String pCedula, String pNombre,
            String pDireccion, String pTelefono, String pTipoCliente, String pNombreOrden) {
        dom = new GestionXml();
        clienteUno = new Cliente(pCedula, pNombre, pDireccion, pTelefono, pTipoCliente);
        // productos
        nombreOrden = pNombreOrden;
        pedido1 = new Pedido(pNombreOrden, clienteUno);
        pedidos = new ArrayList<>();
        errorDescripcion = "";
        isError = false;
        comprobarDirectorio();
    }

     //Limpia los estados de error y descripcion
    public void limpiarEstado() {
        isError = false;
        errorDescripcion = "";
    }

    public GuardarPendientes(String pNombreOrden) {
        nombreOrden = pNombreOrden;
    }

    public GuardarPendientes() {
    }

    public void generarFacturaPendiente(String pCodigo, String pDescripcion, String pCantidad,
            String pDisponible, String pPrecioUnitario, String pPrecioTotal) {
        products = new Producto(pCodigo, pDescripcion, pCantidad, pDisponible, pPrecioUnitario, pPrecioTotal);
        pedido1.addProducto(products);
    }

    //Comprueba si el archivo ya existe para no ser remplazado por una factura ya existente
    public boolean comprobarExistencia(String pNombreArchivo) {
        limpiarEstado(); //Limpia los estados de error y descripcion
        comprobarDirectorio();//Comprueba si existe el directorio
        boolean existe = false;
        rutaPendientes += pNombreArchivo;
        try {
            File fichero = new File(rutaPendientes);
            if (fichero.exists()) {
                existe = true;
            }
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        return existe;
    }

    //Comprueba el tipo de sistema operativo
    //Tambien crea el directorio en caso de que no exista en el sistema
    public void comprobarDirectorio() {
        limpiarEstado(); //Limpia los estados de error y descripcion
        File folder;
        String pTypeOs = System.getProperty("os.name");
        try {
            switch (pTypeOs) {
                case "Linux":
                    folder = new File("/home/ignacio/Escritorio/Facturas pausadas");
                    rutaPendientes = "/home/ignacio/Escritorio/Facturas pausadas/";
                    if (!folder.exists()) {
                        folder.mkdirs();
                    }
                    break;
                case "Microsoft":
                    folder = new File("C:\\Facturas pausadas");
                    rutaPendientes = "C:\\Facturas pausadas\\";
                    if (!folder.exists()) {
                        folder.mkdirs();

                    }
                    break;
            }
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }

    }

    //Elimina todo el contenido de la carpeta que almacena todas las facturas pausadas por el cajero
    public boolean eliminarAllFicheros() {
        limpiarEstado(); //Limpia los estados de error y descripcion
        comprobarDirectorio();//Comprueba si existe el directorio
        boolean limpio = false;
        try {
            File prueba = new File(rutaPendientes);
            File[] ficheros = prueba.listFiles();
            File f;
            if (prueba.exists()) {
                for (File fichero : ficheros) {
                    f = new File(fichero.toString());
                    f.delete();
                }
                limpio = true;
            }
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        return limpio;
    }

    //Elimina especificamente el archivo xml seleccionado
    public boolean eliminarFicheroXml(String pNombreArchivo) {
        limpiarEstado(); //Limpia los estados de error y descripcion
        comprobarDirectorio();//Comprueba si existe el directorio
        boolean eliminado = false;
        try {
            comprobarDirectorio();
            if (comprobarExistencia(pNombreArchivo)) {
                File fichero = new File(rutaPendientes);
                if (fichero.delete()) {
                    eliminado = true;
                }
            }
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        return eliminado;
    }

    //Lee especificamente la parte de los PRODUCTOS del archivo xml
    public ArrayList leerProductosXml(String pNombreArchivo) {
        limpiarEstado(); //Limpia los estados de error y descripcion
        comprobarDirectorio();//Comprueba si existe el directorio
        //Creamos un array para los PRODUCTOS del xml
        ArrayList productos = new ArrayList();
        try {
            //Creamos un vector para cuardar los datos en cada recorrido de los nodos
            String datos[];
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse(rutaPendientes + pNombreArchivo);
            //Obtener el elemento raíz del documento
            Element raiz = documento.getDocumentElement();
            //Obtener la lista de nodos que tienen etiqueta "PRODUCTO"
            NodeList listaProductos = raiz.getElementsByTagName("Producto");
            //Recorrer la lista de los PRODUCTOS
            int pos = 0;
            for (int i = 0; i < listaProductos.getLength(); i++) {
                pos = 0;
                //Obtener de la lista un PRODUCTO tras otro
                Node empleado = listaProductos.item(i);
                //Obtener la lista de los datos que contiene ese PRODUCTO
                NodeList datosProductos = empleado.getChildNodes();
                //Recorrer la lista de los datos que contiene el PRODUCTO
                datos = new String[6];
                for (int j = 0; j < datosProductos.getLength(); j++) {
                    //Obtener de la lista de datos un dato tras otro
                    Node dato = datosProductos.item(j);
                    //Comprobar que el dato se trata de un nodo de tipo Element
                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        //El valor está contenido en un hijo del nodo Element
                        Node datoContenido = dato.getFirstChild();
                        //Mostrar el valor contenido en el nodo que debe ser de tipo Text
                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            datos[pos] = datoContenido.getNodeValue().toString();
                            pos++;
                        }
                    }
                }
                //Se deja un salto de línea de separación entre cada PRODUCTO
                Producto oProductos = new Producto(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
                //Añadimos los productos a la lista
                productos.add(oProductos);
            }

        } catch (Exception ex) {
            isError = true;
            errorDescripcion = ex.getMessage();
        }
        return productos;
    }

    //Lee especificamente la parte de los CLIENTE del xml
    public ArrayList leerClientesXml(String pNombreArchivo) {
        limpiarEstado(); //Limpia los estados de error y descripcion
        comprobarDirectorio();//Comprueba si existe el directorio
        //Se crea una lista para almacenar los datos del CLIENTE
        ArrayList clientes = new ArrayList();
        try {
            //Creamos un arreglo para almacenar los datos del CLIENTE en cada recorrido
            String datos[] = new String[5];
            DocumentBuilderFactory fábricaCreadorDocumento = DocumentBuilderFactory.newInstance();
            DocumentBuilder creadorDocumento = fábricaCreadorDocumento.newDocumentBuilder();
            Document documento = creadorDocumento.parse(rutaPendientes + pNombreArchivo);
            //Obtener el elemento raíz del documento
            Element raiz = documento.getDocumentElement();
            //Obtener la lista de nodos que tienen etiqueta "CLIENTE"
            NodeList listaEmpleados = raiz.getElementsByTagName("Cliente");
            //Recorrer la lista de los CLIENTES
            int pos = 0;
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                //Obtener de la lista un CLIENTE tras otro
                Node empleado = listaEmpleados.item(i);
                //Obtener la lista de los datos que contiene ese CLIENTE
                NodeList datosEmpleado = empleado.getChildNodes();
                //Recorrer la lista de los datos que contiene el CLIENTE
                for (int j = 0; j < datosEmpleado.getLength(); j++) {
                    //Obtener de la lista de datos un dato tras otro
                    Node dato = datosEmpleado.item(j);
                    //Comprobar que el dato se trata de un nodo de tipo Element
                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        //El valor está contenido en un hijo del nodo Element
                        Node datoContenido = dato.getFirstChild();
                        //Mostrar el valor contenido en el nodo que debe ser de tipo Text
                        if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE) {
                            datos[pos] = datoContenido.getNodeValue().toString();
                        } else {
                            datos[pos] = "Sin datos";
                        }
                        pos++;
                    }
                }
                //Se deja un salto de línea de separación entre cada CLIENTE
                Cliente oCliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
                clientes.add(oCliente);
            }

        } catch (Exception ex) {
            isError = true;
            errorDescripcion = ex.getMessage();
        }
        return clientes;
    }

    //Se encarga de crear el archivo xml en su respectiva ruta
    public void crearXml(String pNombrePendiente) {
        limpiarEstado(); //Limpia los estados de error y descripcion
        comprobarDirectorio();//Comprueba si existe el directorio
        // añadimos los pedidos a la lista
        pedidos.add(pedido1);
        // creamos los procesadores en DOM y en SAX
        dom.pedidosToXML(pedidos, rutaPendientes + pNombrePendiente);
        isError = dom.isIsError();
        errorDescripcion = dom.getErrorDescripcion();
    }

    //Gets y Sets
    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

}

package ImpresoraD;

import java.util.List;

public class Factura {

    //Variables
    private MaestroFactura maestro;
    //Lista de la clase productos
    private List<Producto> productos;

    //Gets y Sets
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public MaestroFactura getMaestro() {
        return maestro;
    }

    public void setMaestro(MaestroFactura maestro) {
        this.maestro = maestro;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresoraL;

import ImpresoraD.Factura;
import ImpresoraD.Producto;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.getProperty;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolando
 */
public class Impresion {

    private boolean isError;
    private String errorDescripcion;
    //Variables para el formato de la factura
    private Font fuenteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private Font fuenteTextos = new Font(Font.FontFamily.TIMES_ROMAN, 6f, Font.NORMAL);
    private Font fuenteEtiquetas = new Font(Font.FontFamily.TIMES_ROMAN, 5f, Font.BOLD);
    private Factura factura;

    //Constructor
    public Impresion(Factura factura) {
        this.factura = factura;
        isError = false;
        errorDescripcion = "";
    }

    //Metodo encargado para agregar un espacio a un texto a la factura
    private void agregarTextoNormal(Document pDocumento, String pCadena,
            Font font, int align) {
        try {
            Chunk espacio = new Chunk(pCadena, font);
            Paragraph p = new Paragraph(espacio);
            p.setAlignment(align);
            pDocumento.add(p);
        } catch (DocumentException ex) {
            isError = true;
            errorDescripcion = ex.getMessage();
        }
    }
//Metodo encargado para agregar una separacion entre los productos y encabezado de la factura

    private void agregarSeparacion(Document document) {
        try {
            Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 4, Font.NORMAL);
            Chunk espacio = new Chunk("\n", fuente);
            document.add(new Paragraph(espacio));
        } catch (DocumentException ex) {
            isError = true;
            errorDescripcion = ex.getMessage();
        }
    }

    //Metodo encargado de agregar etiquetas en la factura 
    private void agregarEtiqueta(PdfPTable table, String string, int align,
            boolean isBorder, int colspan) {
        try {
            // Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Chunk c = new Chunk(string, fuenteEtiquetas);
            PdfPCell cell = new PdfPCell(new Phrase(c));
            if (!isBorder) {
                cell.setBorder(Rectangle.NO_BORDER);
            }
            cell.setColspan(colspan);
            cell.setVerticalAlignment(align);
            cell.setHorizontalAlignment(align);
            table.addCell(cell);
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
    }

    //Encargado de escribir texto de todos los productos de la tabla en la factura
    private void agregarTexto(PdfPTable table, String string, int align,
            boolean isBorder, int colspan) {
        try {
            Chunk c = new Chunk(string, fuenteTextos);
            PdfPCell cell = new PdfPCell(new Phrase(c));
            if (!isBorder) {
                cell.setBorder(Rectangle.NO_BORDER);
            }
            cell.setColspan(colspan);
            cell.setHorizontalAlignment(align);
            table.addCell(cell);
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
    }
//Este metodo se encarga de crear el encabezado de la factura con los datos del cliente

    private PdfPTable crearMaestroFactura() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        try {
            table.setWidthPercentage(100f);
            agregarEtiqueta(table, "CEDULA:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getCedulaCliente(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "NOMBRE:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getNombreCliente(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "DIRECCIÓN:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getDireccionCliente(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "NUMERO DE FACTURA:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getNumeroFactura(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "CONDICIÓN DE PAGO:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getCondicionPago(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "FECHA DE EMISIÓN:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getFechaEmision(), Element.ALIGN_LEFT, false, 1);
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        return table;
    }
//Este metodo se encarga de crear los detalles de cada producto en la tabla

    private PdfPTable crearDetalleFactura() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        try {
            table.setWidthPercentage(100f);
            String descuento = "0";
            String pagoCon = "0";
            String vuelto = "0";
            List<Producto> productos = factura.getProductos();
            agregarEtiqueta(table, "CANTIDAD", Element.ALIGN_CENTER, true, 1);
            agregarEtiqueta(table, "DESCRIPCIÓN", Element.ALIGN_CENTER, true, 1);
            agregarEtiqueta(table, "PREC. UNIT.", Element.ALIGN_CENTER, true, 1);
            agregarEtiqueta(table, "PREC. PARCIAL", Element.ALIGN_CENTER, true, 1);
            int parcial = 0;
            for (Producto producto : productos) {
                agregarTexto(table, "" + producto.getCantidad(), Element.ALIGN_CENTER, true, 1);
                agregarTexto(table, producto.getDescripcion(), Element.ALIGN_CENTER, true, 1);
                agregarTexto(table, "" + Matematicas.redondear(producto.getPrecioUnitario()), Element.ALIGN_RIGHT, true, 1);
                agregarTexto(table, "" + Matematicas.redondear(producto.getPrecioTotal()), Element.ALIGN_RIGHT, true, 1);
                parcial += producto.getPrecioTotal();
                descuento = "" + producto.getDescuento();
                pagoCon = "" + producto.getPago();
                vuelto = "" + producto.getVuelto();

            }

            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "TOTAL I.V.I", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, "" + parcial, Element.ALIGN_RIGHT, true, 1);//parcial * 1.18

            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "PAGÓ:", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, pagoCon, Element.ALIGN_RIGHT, true, 1);

            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "DESCUENTO:", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, descuento, Element.ALIGN_RIGHT, true, 1);

            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "VUELTO::", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, vuelto, Element.ALIGN_RIGHT, true, 1);
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        return table;
    }

    public void generarArchivoPDF(String pNumFactura) {
        try {
            Rectangle pagesize = new Rectangle(300f, 150f + (10f * factura.getProductos().size()));
            Document document = new Document(pagesize, 5, 5, 0, 0);
            PdfWriter.getInstance(document, new FileOutputStream(
                    "numero_factura.pdf"));
            document.open();
            agregarTextoNormal(document, Constantes.VENDEDOR, fuenteTitulo, Element.ALIGN_CENTER);
            agregarTextoNormal(document, Constantes.BLOG, fuenteTitulo, Element.ALIGN_CENTER);
            agregarSeparacion(document);
            agregarSeparacion(document);
            agregarSeparacion(document);
            document.add(crearMaestroFactura());
            agregarSeparacion(document);
            document.add(crearDetalleFactura());
            document.close();
            String TypeOS = System.getProperty("os.name");
            switch (TypeOS) {
                case "Linux":
                    File path = new File("numero_factura.pdf");
                    Desktop.getDesktop().open(path);
                    break;
                case "Windows":
                    Runtime.getRuntime().exec("cmd.exe /c start numero_factura.pdf");
                    break;
            }
        } catch (DocumentException | IOException xe) {
            isError = true;
            errorDescripcion = xe.getMessage();
        }
    }

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

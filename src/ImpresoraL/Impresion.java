package ImpresoraL;

import ImpresoraD.Factura;
import ImpresoraD.Producto;
import com.itextpdf.text.*;
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
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

/**
 *
 * @author Ignacio
 */
public class Impresion {

    private boolean isError;
    private String errorDescripcion;
    //Variables para el formato de la factura
    private Font fuenteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private Font fuenteTextos = new Font(Font.FontFamily.TIMES_ROMAN, 6f, Font.NORMAL);
    private Font fuenteEtiquetas = new Font(Font.FontFamily.TIMES_ROMAN, 5f, Font.BOLD);
    private Factura factura;
    private String rutaFacturas;

    //Constructor
    public Impresion(Factura factura) {
        this.factura = factura;
        isError = false;
        errorDescripcion = "";
    }

    /*
     Se encarga de limpiar los estados de error de la clase
     */
    private void limpiarEstado() {
        isError = false;
        errorDescripcion = "";
    }

    /*
     Este metodo se encarga de combrobar y crear el directorio
     en caso de que no exista y estabelece ese direcctorio en una variable global
     */
    public void comprobarDirectorio() {
        limpiarEstado();
        File folder;
        String pTypeOs = System.getProperty("os.name");
        try {
            switch (pTypeOs) {
                case "Linux":
                    folder = new File("/home/ignacio/Escritorio/Sistema Punto Venta/Facturas pausadas");
                    rutaFacturas = "/home/ignacio/Escritorio/Sistema Punto Venta/Facturas pausadas/";
                    if (!folder.exists()) {
                        folder.mkdirs();
                    }
                    break;
                case "Windows 7":
                    folder = new File("C:\\Sistema Punto Venta\\Facturas generadas");
                    rutaFacturas = "C:\\Sistema Punto Venta\\Facturas generadas\\";
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

    /*
     Este metodo se encarga de escribir los datos de las etiquetas ya sea 
     para el encabezado, cuerpo o pie de la factura
     */
    private void agregarTextoNormal(Document pDocumento, String pCadena,
            Font font, int align) {
        limpiarEstado();
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
    /*
     Este metodo se encarga de agregar una separacion ya sea entre celdas de la tabla
     o separacion entre etiquetas de la factura 
     */

    private void agregarSeparacion(Document document) {
        limpiarEstado();
        try {
            Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 4, Font.NORMAL);
            Chunk espacio = new Chunk("\n", fuente);
            document.add(new Paragraph(espacio));
        } catch (DocumentException ex) {
            isError = true;
            errorDescripcion = ex.getMessage();
        }
    }

    /*
     Este metodo se encarga de establecer la etiquetas ya sea para la tabla,
     encabezado o cuerpo de la factura
     */
    private void agregarEtiqueta(PdfPTable table, String string, int align,
            boolean isBorder, int colspan) {
        limpiarEstado();
        try {
            // Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Chunk c = new Chunk(string, fuenteEtiquetas);
            PdfPCell cell = new PdfPCell(new Phrase(c));
            if (!isBorder) {
                cell.setBorder(Rectangle.NO_BORDER);
            }
            cell.setColspan(colspan);
            cell.setHorizontalAlignment(align);
            cell.setHorizontalAlignment(align);
            table.addCell(cell);
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
    }

    /*
     Este metodo se encarga de establecer la configuracion, alineacion y el texto
     de los detalles de los productos comprados
     */
    private void agregarTexto(PdfPTable table, String string, int align,
            boolean isBorder, int colspan) {
        limpiarEstado();
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

    /*
     Este metodo se enarga de escribir los datos del cliente que 
     realizo la compra ya sea de crédito o de contado
     */
    private PdfPTable crearMaestroFactura() throws DocumentException {
        PdfPTable table = new PdfPTable(4);
        limpiarEstado();
        try {
            table.setWidthPercentage(100f);
            agregarEtiqueta(table, "CEDULA:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getCedulaCliente(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "NOMBRE:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getNombreCliente(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "DIRECCIÓN:", Element.ALIGN_LEFT, false, 1);
            agregarTexto(table, factura.getMaestro().getDireccionCliente(), Element.ALIGN_LEFT, false, 1);
            agregarEtiqueta(table, "N° FACTURA:", Element.ALIGN_LEFT, false, 1);
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
    /*
     Este metodo se encarga de detallar la factura con todos los productos
     ya comprados, creando al mismo tiempo una tabla que ordena todos los productos
     dentro de ella
     */

    private PdfPTable crearDetalleFactura() throws DocumentException {
        limpiarEstado();
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
            /////////////////////////////////////////////////////////////
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "TOTAL I.V.I", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, "" + parcial, Element.ALIGN_RIGHT, true, 1);//parcial * 1.18
            //////////////////////////////////////////////////////////////
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "PAGÓ:", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, pagoCon, Element.ALIGN_RIGHT, true, 1);
            //////////////////////////////////////////////////////////////
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "DESCUENTO:", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, descuento, Element.ALIGN_RIGHT, true, 1);
            //////////////////////////////////////////////////////////////
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "", Element.ALIGN_RIGHT, false, 1);
            agregarEtiqueta(table, "VUELTO::", Element.ALIGN_RIGHT, true, 1);
            agregarTexto(table, vuelto, Element.ALIGN_RIGHT, true, 1);
            //////////////////////////////////////////////////////////////
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
        return table;
    }

    /*
     Este metodo es el encargado de abrir el documento ya 
     creado con todos los datos de la factura emitidad
     enviandole por parametro el nombre especifico de la 
     factura emitidda
     */
    public void abrirFacturaPDF(String pNumeroFactura) {
        try {
            String TypeOS = System.getProperty("os.name");
            File path = new File(rutaFacturas + pNumeroFactura + ".pdf");
            imprimirPDF(rutaFacturas + pNumeroFactura + ".pdf");
            switch (TypeOS) {
                case "Linux":
                    Desktop.getDesktop().open(path);
                    break;
                case "Windows XP":
                    Desktop.getDesktop().open(path);
                    break;
                case "Windows 7":
                    Desktop.getDesktop().open(path);
                    break;
                case "Windows 8":
                    Desktop.getDesktop().open(path);
                    break;
                case "Windows 8.1":
                    Desktop.getDesktop().open(path);
                    break;
                case "Windows 10":
                    Desktop.getDesktop().open(path);
                    break;
                default:
                    break;
            }
        } catch (Exception xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
        }
    }

    /*
     Este metodo se encarga de generar el Documento PDF
     con todas sus dimensiones y tamaños de pagina
     */
    public void generarArchivoPDF(String pNumFactura, String pObservacion) {
        try {
            //Establece el tamaño de la pagina
            Rectangle pagesize = new Rectangle(250f, 300f + (100f * factura.getProductos().size()));
            Document document = new Document(pagesize, 5, 5, 0, 0);
            //Llama al metodo que se encarga de validar la exitencia del direcctorio
            comprobarDirectorio();
            //Crea el directorio en la ruta especifica
            PdfWriter.getInstance(document, new FileOutputStream(rutaFacturas + pNumFactura + ".pdf"));
            //Abre el documento para empezar la escritura de los datos
            document.open();
            //Se encarga de imprimir el encabezado de la factura
            agregarTextoNormal(document, Constantes.VENDEDOR, fuenteTitulo, Element.ALIGN_CENTER);
            agregarTextoNormal(document, Constantes.BLOG, fuenteTitulo, Element.ALIGN_CENTER);
            //Se encarga de establecer una separación entre el encabezado y el cuerpo de la factura
            agregarSeparacion(document);
            //Se encarga de escribir los datos del cliente
            document.add(crearMaestroFactura());
            //Agrega una separacion
            agregarSeparacion(document);
            //Escribi la tabla con todos los productos seleccionados en la factura
            document.add(crearDetalleFactura());
            //Se encarga de escribir la observación emitida por el vendedor
            agregarTextoNormal(document, "Observación: " + pObservacion, fuenteTextos, Element.ALIGN_LEFT);
            //Cierra el proceso de escritura del documento
            document.close();
            //Lama al metodo imprimir PDF
            imprimirPDF(rutaFacturas + pNumFactura + ".pdf");
        } catch (DocumentException | IOException xe) {
            isError = true;
            errorDescripcion = xe.getMessage();
        }
    }

    //Se encarga de imprimir el documento pdf que contiene la factura
    public final void imprimirPDF(String pNombreFactura) {
        limpiarEstado();
        try {
            DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
            PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
            patts.add(Sides.DUPLEX);
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
            if (ps.length == 0) {
                throw new IllegalStateException("Impresora no encontrada");
            }
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            try (FileInputStream fis = new FileInputStream(pNombreFactura)) {
                Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
            }
        } catch (IllegalStateException | HeadlessException | PrintException | IOException xp) {
            isError = true;
            errorDescripcion = xp.getMessage();
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

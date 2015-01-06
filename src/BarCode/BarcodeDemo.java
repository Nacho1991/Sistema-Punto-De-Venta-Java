package BarCode;

import com.barcodelib.barcode.Linear;
import java.awt.*;

public class BarcodeDemo {

    public BarcodeDemo() {

    }

    public static void testCODABAR() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODABAR);
        // barcode data to encode
        barcode.setData("123456789012");
        barcode.setN(3);
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("C://Facturas generadas/codabar.gif");
    }

    public static void testCODE11() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE11);
        // barcode data to encode
        barcode.setData("1234567890-12");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://code11.gif");
    }

    public static void testCODE2OF5() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE2OF5);
        // barcode data to encode
        barcode.setData("123456789012");
        // wide bar width vs narrow bar width ratio
        barcode.setN(3.0f);
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://code2of5.gif");
    }

    public static void testCODE39() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE39);
        // barcode data to encode
        barcode.setData("CODE39-123456789012");
        // wide bar width vs narrow bar width ratio
        barcode.setN(3.0f);
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.setAddCheckSum(true);
        barcode.renderBarcode("c://code39.gif");
    }

    public static void testCODE39EX() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE39EX);
        // barcode data to encode
        barcode.setData("code39-ex-123456789012");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.setAddCheckSum(true);
        barcode.renderBarcode("c://code39ex.gif");
    }

    public static void testCODE93() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE93);
        // barcode data to encode
        barcode.setData("CODE93-123456789012");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://code93.gif");
    }

    public static void testEAN8() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN8);
        // barcode data to encode
        // should be 7 digits
        barcode.setData("1234567");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://ean8.gif");
    }

    public static void testEAN8_2() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN8_2);
        // barcode data to encode
        // should be 7 digits
        barcode.setData("1234567");
        barcode.setSData("12");

        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://ean8_2.gif");
    }

    public static void testEAN8_5() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN8_5);
        // barcode data to encode
        // should be 7 digits
        barcode.setData("1234567");
        barcode.setSData("12345");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://ean8_5.gif");
    }

    public static void testEAN13() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN13);
        // barcode data to encode
        // should be 12 digits
        barcode.setData("768965000052");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("C://Facturas generadas/asdasd.gif");
    }

    public static void testEAN13_2() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN13_2);
        // barcode data to encode
        // should be 12 digits
        barcode.setData("123456789012");
        barcode.setSData("12");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://ean13_2.gif");
    }

    public static void testEAN13_5() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN13_5);
        // barcode data to encode
        // should be 12 digits
        barcode.setData("768965000052");
        barcode.setSData("12345");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("C://Facturas generadas/ean13_5.gif");

    }

    public static void testISBN() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.ISBN);
        // barcode data to encode
        // should be 12 digits
        barcode.setData("978047082163");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://isbn.gif");
    }

    public void testISBN_5() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.ISBN_5);
        // barcode data to encode
        // should be 12 digits
        barcode.setData("978047082163");
        barcode.setSData("53999");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://isbn_5.gif");
    }

    public static void testISSN() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.ISSN);
        // barcode data to encode
        // should be 9 digits, excluding starting "977"
        barcode.setData("456789012");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://issn.gif");
    }

    public static void testISSN_2() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.ISSN_2);
        // barcode data to encode
        // should be 9 digits, excluding starting "977"
        barcode.setData("456789012");
        barcode.setSData("01");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://issn_2.gif");
    }

    public static void testITF14() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.ITF14);
        // barcode data to encode
        // should be 13 digits
        barcode.setData("3011234500001");
        barcode.setBearerBar(Linear.BEARERBAR_FRAME);
        // wide bar width vs narrow bar width ratio
        barcode.setN(3.0f);
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://itf14.gif");
    }

    public static void testINTERLEAVED25() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.INTERLEAVED25);
        // barcode data to encode
        barcode.setData("012345");
        // wide bar width vs narrow bar width ratio
        barcode.setN(3.0f);
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.setAddCheckSum(true);
        barcode.renderBarcode("c://interleaved2of5.gif");
    }

    public static void testIDENTCODE() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.IDENTCODE);
        // barcode data to encode
        // should be 11 digits
        barcode.setData("56400000005");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://identcode.gif");
    }

    public static void testLEITCODE() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.LEITCODE);
        // barcode data to encode
        // should be 13 digits
        barcode.setData("8173908300200");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://leitcode.gif");
    }

    public static void testMSI() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.MSI);
        // barcode data to encode
        barcode.setData("1234567890");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.setAddCheckSum(true);
        barcode.renderBarcode("c://msi.gif");
    }

    public static void testONECODE() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.ONECODE);
        // barcode data to encode
        // should be 20, 25, 29, or 31 digits.
        barcode.setData("0123456709498765432101234567891");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://onecode.gif");
    }

    public static void testPLANET() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.PLANET);
        // barcode data to encode
        // should be 11 or 13 digits
        barcode.setData("1234567890123");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://planet.gif");
    }

    public static void testPOSTNET() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.POSTNET);
        // barcode data to encode
        // should be 5, 6, 9, 11 digits
        barcode.setData("12345678901");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://postnet.gif");
    }

    public static void testRM4SCC() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.RM4SCC);
        // barcode data to encode
        barcode.setData("ABC123");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://rm4scc.gif");
    }

    public static void testUPCA() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.UPCA);
        // barcode data to encode
        // should be 11 digits
        barcode.setData("12345678901");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://upca.gif");
    }

    public static void testUPCA_2() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.UPCA_2);
        // barcode data to encode
        // should be 11 digits
        barcode.setData("12345678901");
        barcode.setSData("12");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://upca_2.gif");
    }

    public static void testUPCA_5() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.UPCA_5);
        // barcode data to encode
        // should be 11 digits
        barcode.setData("12345678901");
        barcode.setSData("12345");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://upca_5.gif");
    }

    public static void testUPCE() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.UPCE);
        // barcode data to encode
        // should be 6 digits
        barcode.setData("123456");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://upce.gif");
    }

    public static void testUPCE_2() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.UPCE_2);
        // barcode data to encode
        // should be 6 digits
        barcode.setData("123456");
        barcode.setSData("12");
        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);
        barcode.renderBarcode("c://upce_2.gif");
    }

    public static void testUPCE_5() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.UPCE_5);
        // barcode data to encode
        // should be 6 digits
        barcode.setData("123456");
        barcode.setSData("12345");

        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);

        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);

        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);

        barcode.renderBarcode("c://upce_5.gif");
    }

    public static void testCODE128() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE128);
        // barcode data to encode
        barcode.setData("123456789012");

        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);

        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);

        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);

        barcode.renderBarcode("c://code128.gif");
    }

    public static void testEAN128() throws Exception {
        Linear barcode = new Linear();
        barcode.setType(Linear.EAN128);
        // barcode data to encode
        barcode.setData("10012345777675446712345678");

        barcode.setProcessTilde(true);

        // unit of measure for X, Y, LeftMargin, RightMargin, TopMargin, BottomMargin
        barcode.setUOM(Linear.UOM_PIXEL);
        // barcode module width in pixel
        barcode.setX(3f);
        // barcode module height in pixel
        barcode.setY(75f);
        barcode.setLeftMargin(0f);
        barcode.setRightMargin(0f);
        barcode.setTopMargin(0f);
        barcode.setBottomMargin(0f);
        // barcode image resolution in dpi
        barcode.setResolution(72);
        // disply human readable text under the barcode
        barcode.setShowText(true);
        // human reable text font style
        barcode.setTextFont(new Font("Arial", 0, 12));
        //  ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270
        barcode.setRotate(Linear.ANGLE_0);

        barcode.renderBarcode("C://Facturas generadas/ean128.gif");
    }
}

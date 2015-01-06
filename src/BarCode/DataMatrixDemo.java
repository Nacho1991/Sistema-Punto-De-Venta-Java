package BarCode;

import com.barcodelib.barcode.DataMatrix;

public class DataMatrixDemo {

    private static int uom = 0;        //  0 - Pixel, 1 - CM, 2 - Inch
    private static int resolution = 72;
    private static float leftMargin = 80.000f;
    private static float rightMargin = 80.000f;
    private static float topMargin = 80.000f;
    private static float bottomMargin = 80.000f;
    private static int rotate = 0;     //  0 - 0, 1 - 90, 2 - 180, 3 - 270

    private static float moduleSize = 3f;
}

//        DataMatrix barcode = new DataMatrix();
//        barcode.setDataMode(DataMatrix.MODE_AUTO);
//
//        barcode.setFormatMode(9);
//        barcode.setProcessTilde(true);
//        barcode.setData("This is a testing string. It contains a digit stream" +
//                "12345678901234567890 and special characters ^&^*&^#@*&$^#@&*.");
//
//        barcode.setUOM(uom);
//        barcode.setModuleSize(moduleSize);
//        barcode.setLeftMargin(leftMargin);
//        barcode.setRightMargin(rightMargin);
//        barcode.setTopMargin(topMargin);
//        barcode.setBottomMargin(bottomMargin);
//        barcode.setResolution(resolution);
//        barcode.setRotate(rotate);
//        barcode.renderBarcode("c://datamatrix.gif");
//        System.out.println("After creating barcode image.");
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.gainde2000.orbuslink.visa.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author isow
 */
public class QRCodeGenerator {
    
    //private static final String QR_CODE_IMAGE_PATH = "./qrcode.png";

	/*
	 * public static void generateQRCodeImage(String text, int width, int height,
	 * String filePath) { try { com.google.zxing.qrcode.QRCodeWriter qrCodeWriter =
	 * new com.google.zxing.qrcode.QRCodeWriter(); com.google.zxing.common.BitMatrix
	 * bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	 * 
	 * Path path = FileSystems.getDefault().getPath(filePath);
	 * MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path); } catch
	 * (WriterException ex) {
	 * Logger.getLogger(QRCodeGenerator.class.getName()).log(Level.SEVERE, null,
	 * ex); } catch (IOException ex) {
	 * Logger.getLogger(QRCodeGenerator.class.getName()).log(Level.SEVERE, null,
	 * ex); } }
	 */
    
    public static Image getQRCodeImage(String text, int width, int height) {
        
            BufferedImage image = null;       
            try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();
            
            ByteArrayInputStream input = new ByteArrayInputStream(pngData);
            image = ImageIO.read(input);
            
            
        } catch (WriterException | IOException ex) {
            Logger.getLogger(QRCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
    
//    public static void main(String[] args) throws IOException {
//        //generateQRCodeImage("This is my first QR Code", 100, 100, QR_CODE_IMAGE_PATH);
//
//        getQRCodeImage("This is my first QR Code", 100, 100);
//    }
    
}

package sn.gainde2000.orbuslink.visa.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCode {

    /*public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        System.out.println("1111111111111111111111111111111111111111111111111");
        String qrCodeData = "pricey wireless plan, so I got a free phone number from TextNow and I use the app to talk to my frien";
////        String filePath = "C:\\work\\download\\visa\\QRCode.png";
        String filePath = "qrcode.jpg";
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

       createQRCode(qrCodeData, filePath, hintMap, 200, 200);
////        System.out.println("QR Code image created successfully!");

        String qrcodeData = readQRCode(filePath, hintMap);

        System.out.println("Data read from QR Code: " + qrcodeData);

        FileUtils.writeStringToFile(new File(filePath + "test.txt"), qrcodeData, "UTF-8");

        System.out.println("2222222222222222222222222222222222222222222222222");
    }
*/
    public static void createQRCode(String qrCodeData, String filePath, Map hintMap, int qrCodeheight, int qrCodewidth)
            throws WriterException, IOException {
        String charset = "UTF-8";
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
    }

    public static String readQRCode(String filePath, Map hintMap) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(fileInputStream))));

            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);

            fileInputStream.close();

            return qrCodeResult.getText();
        } catch (Exception ex) {
            System.out.println("***** Dans readQRCode *****");
            //System.out.println(ex.getMessage());
            //ex.printStackTrace();
            return "";
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception ex) {
                System.out.println("***** Dans readQRCode finally *****");
            }
        }
    }

    public static String readQRCode(String filePath) {

        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        return readQRCode(filePath, hintMap);
    }
}

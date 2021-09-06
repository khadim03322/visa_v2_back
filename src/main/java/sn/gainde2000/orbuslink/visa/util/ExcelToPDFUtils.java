package sn.gainde2000.orbuslink.visa.util;


import com.aspose.cells.*;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Auteur: Mbaye Sokhna THIAM
 * Date: 15/12/2020
 */
public class ExcelToPDFUtils {

    public static final String ECURRENT_PICTURE_FILE_PATH = "tmp.png";
    public static final String EEXPORTED_FILE_PATH = "export.pdf";


    /**
     * Fonction qui convert un document Excel en PDF
     * @param path
     * @param fileName
     * @throws Exception
     */
    
    
    public static void convertExcelToPDFWithQRCODE(String excel,String path, String fileName,String qrCodeData,String imageQrCode) throws Exception {
    	String time = Long.toString(new Date().getTime());
    	System.out.println(time+" Time, Path "+path);
    	String CURRENT_PICTURE_FILE_PATH = path+time+"tmp.png";
        String XLSX_FILE_PATH = excel;
        String EXPORTED_FILE_PATH = path+fileName;
    	
    	Workbook workbook = new Workbook(XLSX_FILE_PATH);


        Document document = new Document(PageSize.A3, 20, 20, 20, 20);

        PdfWriter.getInstance(document, new FileOutputStream(EXPORTED_FILE_PATH));
        document.open();
        
      //Create formatter
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                 
        //Local date instance
        LocalDate localDate = LocalDate.now();
         
        //Get formatted String
        String dateToday = FOMATTER.format(localDate);
         
 

        for (int i=0; i < workbook.getWorksheets().getCount();i++) {

            document.newPage();
            sheetToImage(workbook.getWorksheets().get(i),CURRENT_PICTURE_FILE_PATH);

            File input = new File(CURRENT_PICTURE_FILE_PATH);
            BufferedImage image = ImageIO.read(input);

            BufferedImage resized = crop(image, 2080, 3000);

            File output = new File(CURRENT_PICTURE_FILE_PATH);
            ImageIO.write(resized, "png", output);

            Image img = Image.getInstance(CURRENT_PICTURE_FILE_PATH);



            int indentation = 0;

            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - indentation) / img.getWidth()) * 100;

            img.scalePercent(scaler);

            document.add(img);

        }
        document.close();

        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        QRCode.createQRCode(qrCodeData,
        		imageQrCode, hintMap, 200, 200);
        addImageAndTextToPDFFile(EXPORTED_FILE_PATH,imageQrCode,"OrbusLink le "+dateToday );
    }

    
    
	

    /**
     * Fonction qui convertit un worksheet en image
     * @param sheet
     * @throws Exception
     */
    public static void sheetToImage(Worksheet sheet, String path) throws Exception {
        ImageOrPrintOptions options = new ImageOrPrintOptions();

        options.setImageType(ImageType.PNG);
        options.setQuality(100);
        options.setDesiredSize(2080,3600);

        SheetRender render = new SheetRender(sheet, options);
        for (int j = 0; j < render.getPageCount(); j++) {
            render.toImage(j, path);
        }




    }


    /**
     *
     * Fonction qui met le QrCode dqns chaque page du PDF
     * @param path
     * @param pdfFileName
     * @param imageFileName
     * @param texte
     * @return boolean
     */
    public static boolean addImageAndTextToPDFFile(String pdfFileName, String imageFileName, String texte) {
        boolean isDone = false;
        PDDocument document = null;
        PDPageContentStream contents = null;
        PDImageXObject pdImage = null;
        //PDImageXObject pdImageheader = null;

        try{
            File file = new File(pdfFileName);
            PDDocument doc = PDDocument.load(file);

            int pageNumber = doc.getNumberOfPages();
            for (int i = 0; i < pageNumber; i++) {
                //Retrieving the page
                PDPage page = doc.getPage(i);

                //Creating PDImageXObject object
                pdImage = PDImageXObject.createFromFile(imageFileName, doc);
                //pdImageheader = PDImageXObject.createFromFile("qr_code.png", doc);
                //creating the PDPageContentStream object
                contents = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);

                //Debut ajout image
                System.out.println("Taille Height : " + page.getMediaBox().getWidth());
                System.out.println("Taille Width : " + page.getMediaBox().getHeight());
                contents.drawImage(pdImage, (page.getMediaBox().getWidth()-110), 10, 80, 80);

                //Fin ajout image

                //Debut ajout text
                contents.beginText();
                contents.newLineAtOffset((page.getMediaBox().getWidth()-230), 20);
                contents.setFont(PDType1Font.TIMES_BOLD, 9);
                //contents.showText("Numero visa : ");

                contents.setFont(PDType1Font.TIMES_ROMAN, 9);
                contents.showText(texte);
                contents.endText();
                //Fin ajout text

                //Closing the PDPageContentStream object
                contents.close();
            }

            //Saving the document
            doc.save(pdfFileName);

            //Closing the document
            doc.close();

            isDone = true;
            System.out.println("Image inserted");
        } catch (Exception e){
            System.err.println("Erreur insertion image pdf. " + e);
        } finally {
            try{
                if(document != null){
                    document.close();
                }
                if(contents != null){
                    contents.close();
                }
            } catch (Exception sqlEx) {
                System.err.println("Erreur insertion image pdf finally. " + sqlEx);
            }
        }

        return isDone;
    }

    //Couper la partie ou il ya le texte de la licence
    public static BufferedImage crop(BufferedImage src, int width, int height) {
        int x = src.getWidth()/2 - width/2;
        int y = src.getHeight()/2 - height/2;


        BufferedImage clipping = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//src.getType());
        Graphics2D area = (Graphics2D) clipping.getGraphics().create();
        area.drawImage(src, 0, 0, clipping.getWidth(), clipping.getHeight(), x, y, x + clipping.getWidth(),
                y + clipping.getHeight(), null);
        area.dispose();

        return clipping;
    }







}

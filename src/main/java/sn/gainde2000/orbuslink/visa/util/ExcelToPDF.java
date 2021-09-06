package sn.gainde2000.orbuslink.visa.util;

import com.spire.xls.*;

import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.Document;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class ExcelToPDF {

	static void mergePdfFiles(List<InputStream> inputPdfList,
	        OutputStream outputStream) throws Exception{
	    //Create document and pdfReader objects.
	    Document document = new Document();
	    List<PdfReader> readers = 
	            new ArrayList<PdfReader>();
	    int totalPages = 0;

	    //Create pdf Iterator object using inputPdfList.
	    Iterator<InputStream> pdfIterator = 
	            inputPdfList.iterator();

	    // Create reader list for the input pdf files.
	    while (pdfIterator.hasNext()) {
	            InputStream pdf = pdfIterator.next();
	            PdfReader pdfReader = new PdfReader(pdf);
	            readers.add(pdfReader);
	            totalPages = totalPages + pdfReader.getNumberOfPages();
	    }

	    // Create writer for the outputStream
	    PdfWriter writer = PdfWriter.getInstance(document, outputStream);

	    //Open document.
	    document.open();

	    //Contain the pdf data.
	    PdfContentByte pageContentByte = writer.getDirectContent();

	    PdfImportedPage pdfImportedPage;
	    int currentPdfReaderPage = 1;
	    Iterator<PdfReader> iteratorPDFReader = readers.iterator();

	    // Iterate and process the reader list.
	    while (iteratorPDFReader.hasNext()) {
	            PdfReader pdfReader = iteratorPDFReader.next();
	            //Create page and add content.
	            while (currentPdfReaderPage <= pdfReader.getNumberOfPages()) {
	                  document.newPage();
	                  pdfImportedPage = writer.getImportedPage(
	                          pdfReader,currentPdfReaderPage);
	                  pageContentByte.addTemplate(pdfImportedPage, 0, 0);
	                  currentPdfReaderPage++;
	            }
	            currentPdfReaderPage = 1;
	    }

	    //Close document and outputStream.
	    outputStream.flush();
	    document.close();
	    outputStream.close();

	    System.out.println("Pdf files merged successfully.");
	}
	
	static  String generateurPDFFromExcel(String excel,String UPLOADED_FOLDER, Depot depot, Utilisateur utilisateur,String lienQrCode,String nomFichierSigne)
	{
		String EXPORTED_FILE_PATH;
		
		
		 DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 //Local date instance
        LocalDate localDate = LocalDate.now();
         
        //Get formatted String
        String dateToday = FOMATTER.format(localDate);
        
		//Load the input Excel file
        Workbook workbook = new Workbook();
        //System.out.println("--------------------"+UPLOADED_FOLDER+excel+"----------------fin");
        workbook.loadFromFile(UPLOADED_FOLDER+excel);

        //Get the second worksheet
        
       int  nombrePageExcel=workbook.getWorksheets().getCount();
        
       workbook.getConverterSetting().setSheetFitToPage(true);
       
     //Fit to page
       
       
       SimpleDateFormat dateActuelleFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       String dateActuelle = dateActuelleFormat.format(new Date());

       DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
       DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

       symbols.setGroupingSeparator(' ');
       formatter.setDecimalFormatSymbols(symbols);

       String ninea = depot.getContribuable().getNinea();
       String annee = depot.getAnneeExcercice();
       
       String fileName = null;
       
       String time = Long.toString(new Date().getTime());
      // fileName = ninea+"_"+ "_EtafiEnPDF_" + annee+"_"+time+".pdf";
       fileName=nomFichierSigne;
       

       String qrCodeData = generateTextQrCodeForPython(depot,utilisateur,lienQrCode);
       
       
       
     
	
        try {
            //Prepare input pdf file list as list of input stream.
            List<InputStream> inputPdfList = new ArrayList<InputStream>();
            PDFMergerUtility PDFmerger = new PDFMergerUtility();
           // time = Long.toString(new Date().getTime());
            PDFmerger.setDestinationFileName(UPLOADED_FOLDER+fileName);
            EXPORTED_FILE_PATH=UPLOADED_FOLDER+fileName;
            
            for(int i=0;i<nombrePageExcel;i++) {
          
            	
            	 Worksheet worksheet = workbook.getWorksheets().get(i);
                 //Save as PDF document
               worksheet.saveToPdf(UPLOADED_FOLDER+"pdf_"+i+"_"+time+".pdf");
            	
            	
            	 File file2 = new File(UPLOADED_FOLDER+"pdf_"+i+"_"+time+".pdf"); 
            	  PDFmerger.addSource(file2);
            }
            

        		
              //Merging the two documents
              PDFmerger.mergeDocuments();
              
              
              
              Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
              hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

           String  imageQrCode = UPLOADED_FOLDER + time + "_qrcode.png";
      	    
              
              QRCode.createQRCode(qrCodeData,imageQrCode, hintMap, 50, 50);
              		
              
             addImageAndTextToPDFFile(EXPORTED_FILE_PATH,imageQrCode,"OrbusLink le "+dateToday );
              
             File dossier ;
             
             for(int i=0;i<nombrePageExcel;i++) { 
           	  
            	 dossier = new File(UPLOADED_FOLDER+"pdf_"+i+"_"+time+".pdf");
            	  
            	 if(dossier.delete()){
            		 
            	 }
            	  
              }
              
               dossier = new File(imageQrCode);
       	  
        	 if(dossier.delete()){
        		 
        	 }
        	 
              System.out.println("Documents merged");
      		
              
              
              
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return fileName;
		
		
	} 
	
	
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
	               // contents = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);

	                contents = new PDPageContentStream(doc, page,PDPageContentStream.AppendMode.APPEND, true, true);
	                
	                //Debut ajout image
	               // System.out.println("Taille Height : " + page.getMediaBox().getWidth());
	               // System.out.println("Taille Width : " + page.getMediaBox().getHeight());
	                contents.drawImage(pdImage, (page.getMediaBox().getWidth()-110),(page.getMediaBox().getHeight()-50), 50, 50);

	                //Fin ajout image

	                //contents.showText("tttttttttttt");
	                
	                
	                //Debut ajout text
	                contents.beginText();
	                contents.newLineAtOffset(50,(page.getMediaBox().getHeight()-20));
	               // contents.newLineAtOffset((page.getMediaBox().getWidth()-230),(page.getMediaBox().getHeight()-50));
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

	 private static String generateTextQrCodeForPython(Depot depot,Utilisateur utilisateur,String lienQrCode) {
	        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	        String dateSoumission = dt.format(java.sql.Timestamp.valueOf(depot.getDep_DateSoumission()));

	        
	        String texteQrCode = "Contribuable: " + depot.getContribuable().getNomOuRaisonSocial()
	                + "\\nNinéa: " + depot.getContribuable().getNinea()
	                + "\\nSignataire: " +utilisateur.getPrenom() + " " + utilisateur.getNom()
	                + "\\nN° identification: " + utilisateur.getMatricule()
	                + "\\nAnnée : " + depot.getAnneeExcercice()
	                + "\\nDate de dépôt: " + dateSoumission
	                + "\\nLien: " + String.format(lienQrCode, depot.getContribuable().getNinea(), depot.getAnneeExcercice());
	        return texteQrCode;
	    }
	
	
	public static void main(String[] args) {
      
		
		System.out.println("-----------------Debut------------------");
		
		 String time = Long.toString(new Date().getTime());
    	// String nomFichierSigne="pdf_ETAFI_Signer_"+time+".pdf";   
		
    	 Depot  demande= new Depot(); 
     	demande.setNumero("0001");
     	demande.setAnneeExcercice("2012");
     	demande.setCapitauxPropre(Double.valueOf(10000));
     	demande.setChiffreAffaire(Double.valueOf(10001));
     	demande.setResultatNet(Double.valueOf(10002));
     	demande.setTotalBilan(Double.valueOf(10003));
     	demande.setTotalProduit(Double.valueOf(10004));
     	demande.setDep_DateSoumission(LocalDateTime.now());
     	  Contribuable cont= new Contribuable();
     	  
     	 
     	  cont.setNomOuRaisonSocial("GAINDE 2000");
     	  cont.setAdresseComplete("Point E");
     	  cont.setNinea("098765544");
     	  cont.setResponsableMorale("IPIPIPI");
     	
     	  Fonction fonction= new Fonction();
     	  fonction.setId(Long.valueOf(1));
     	  fonction.setLibelle("Fonction");
     	  cont.setFonction(fonction);
     	  demande.setContribuable(cont);
     	  
     	  
     	int nbrPage=36;
     	String cheminFichier="F://Projet_DDL//orbusLink//visa_v2_back//upload/";
     	Utilisateur utilisateur = new Utilisateur();
     	utilisateur.setNom("Demba");
     	utilisateur.setPrenom("Ndiaye");
     	utilisateur.setSignatureKeyId("cle_02FOR_App_136948");
     	utilisateur.setDelagation("105964");
    	 
     	    String fileNamePDF = "_EtafiEnPDF_"+time+".pdf";
    	 
	String fileName= generateurPDFFromExcel("modele_etats_financiers_DGID (Nouveau) Test.xlsx",
				"F://Projet_DDL//orbusLink//visa_v2_back//upload/",
				demande, utilisateur,
				"imageQrCode",fileNamePDF);
		
		
		
		
		/*//Load the input Excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("F://TesteAccuse//modele_etats_financiers_DGID (Nouveau) Test.xlsx");

        //Get the second worksheet
        
       int  nombrePageExcel=workbook.getWorksheets().getCount();
        
       workbook.getConverterSetting().setSheetFitToPage(true);
       
       
       
     //Fit to page
       
     
	
        try {
            //Prepare input pdf file list as list of input stream.
            List<InputStream> inputPdfList = new ArrayList<InputStream>();
            PDFMergerUtility PDFmerger = new PDFMergerUtility();
            String time = Long.toString(new Date().getTime());
            PDFmerger.setDestinationFileName("F://TesteAccuse//MergeFile_1234_new_"+time+".pdf");
            
            for(int i=0;i<nombrePageExcel;i++) {
          
            	
            	 Worksheet worksheet = workbook.getWorksheets().get(i);
                 //Save as PDF document
               worksheet.saveToPdf("F://TesteAccuse//pdf_"+i+"_"+time+".pdf");
            	
            	
            	 File file2 = new File("F://TesteAccuse//pdf_"+i+"_"+time+".pdf"); 
            	  PDFmerger.addSource(file2);
            }
            

        		
              //Merging the two documents
              PDFmerger.mergeDocuments();
              
              for(int i=0;i<nombrePageExcel;i++) { 
            	  
            	 File dossier = new File("F://TesteAccuse//pdf_"+i+"_"+time+".pdf");
            	  
            	 if(dossier.delete()){
            		 
            	 }
            	  
              }
              
              
              
              
              System.out.println("Documents merged");
      		
              
              
              
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        */
		
		
		
        
        System.out.println("-----------------Fin------------------");
	
	}
	
}

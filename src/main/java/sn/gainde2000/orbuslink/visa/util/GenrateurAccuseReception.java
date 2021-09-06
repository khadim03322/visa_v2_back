package sn.gainde2000.orbuslink.visa.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import sn.gainde2000.orbuslink.visa.model.PieceJoint;


public class GenrateurAccuseReception {

	
	
	public static   String createPdfAccuseReception() {
		
        String signataire = ""; //utilisateur.getPrenom() + " " + utilisateur.getNom()+" "+utilisateur.getMatricule();

        String  UPLOADED_FOLDER= "F://TesteAccuse/";
        
        
        Document document = new Document();
        
        document.addAuthor("République du Sénégal");
        document.addCreationDate();
        document.addCreator("République du Sénégal");
        document.addTitle("Accusé de reception");
        document.addSubject("Accusé de receptions PDF");
        document.addKeywords("pdf, accuse");

        document.addHeader("type", "document, accuse");

        String denominationSociale = "demande.getContribuableCopie().getDenominationSocial()";
        String anneeExercice = "demande.getAnneeDExercice().toString()";
        String nbrPage = String.valueOf("");
        String dateSoumission = null;
        String dateActuelle = null;

        SimpleDateFormat dateActuelleFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateActuelle = dateActuelleFormat.format(new Date());

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
//        if (demande.getInfoDepot().getCreateDateTime() != null) {
//
//            dateSoumission = dt.format(java.sql.Timestamp.valueOf(demande.getInfoDepot().getCreateDateTime()));
//        }
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        String totalBilan = "excelData.getTotalBilan()";
        String capitauxPropres = "excelData.getCapitalPropre()";  //formatter.format(88888);
        String resultatNet = "excelData.getResultatNet();//formatter.format(88888)";
        String totalChiffreAffaire = "excelData.getChiffreAffaire()";// formatter.format(demande.getChiffreDAffaire());
        String totalProduit = "To Replace After";//formatter.format(888888);

        String comptable;


        comptable = "utilisateur.getPrenom() "+ " " + "utilisateur.getNom()";
        String ninea = "demande.getContribuableCopie().getNinea()";
        String annee = "demande.getAnneeDExercice()";
       // NatureFichier natureFichier = "--";
        String nomFichier = ninea+"_"+"demande.getContribuable().getCofi()" + "_AccuseReception_";
        PieceJoint pieceJointe = new PieceJoint();
      //  pieceJointe.setNatureFichier(natureFichier);
        pieceJointe.setLibelle(nomFichier);
        
        String time = Long.toString(new Date().getTime());
        nomFichier = nomFichier + "AAAA_BBBB" + time + "_.pdf";
      
          
     

        //System.out.println("nouveau fichier " + UPLOADED_FOLDER + nomFichier);
        try {
            //Font arial = FontFactory.getFont("/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font sousTitreFont = FontFactory.getFont(null, 8, Font.BOLD, new CMYKColor(255, 255, 255, 1));
            //Font defaultFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font defaultFontGras = FontFactory.getFont("/fonts/arial.ttf", 9, Font.BOLD, new CMYKColor(255, 255, 255, 1));
            Font defaultFont = FontFactory.getFont("/fonts/arial.ttf", 9, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font smallFont = FontFactory.getFont("/fonts/arial.ttf", 9, Font.NORMAL, new CMYKColor(255, 255, 255, 1));

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(UPLOADED_FOLDER + nomFichier));
            document.open();

            Image image2;
            Image image3;
            Image logo;

            try {
                String texteQrCode = "generateTextQrCode(demande)";
                //System.out.println("string: "+texteQrCode);
                //image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage(getCryptedQrCode(demande), 100, 100), null);
                image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage(texteQrCode, 125, 125), null);
                image2.setAbsolutePosition(470f, 40f);
                image2.scaleAbsolute(100, 100);


                Paragraph titreParagraphe02 = new Paragraph("Date de réception : " + dt.format(new Date()), defaultFont);
                titreParagraphe02.setAlignment(Element.ALIGN_RIGHT);
                titreParagraphe02.setSpacingBefore(0);
                document.add(titreParagraphe02);


                Paragraph titreParagraphe = new Paragraph(
                        "               REPLUBIQUE DU SENEGAL         \n"
                                + "            UN PEUPLE – UN BUT – UNE FOI     \n"
                                + "                           -----------------           \n"
                                + "     MINISTERE DES FINANCES ET DU BUDGET  \n"
                                + "                           ------------------           ", defaultFont);
                titreParagraphe.setAlignment(Element.ALIGN_LEFT);
                titreParagraphe.setSpacingBefore(0);
                document.add(titreParagraphe);


                Paragraph titreParagraphe05 = new Paragraph("DIRECTION GENERALE DES IMPOTS ET DES DOMAINES   ", defaultFontGras);
                titreParagraphe05.setAlignment(Element.ALIGN_LEFT);
                titreParagraphe05.setSpacingBefore(0);
                document.add(titreParagraphe05);


                Paragraph sousTitreParagraphe1 = new Paragraph("     CENTRE DES SERVICES FISCAUX : " + "demande.getContribuableCopie().getCentreServiceFiscal().getLibelle()", defaultFontGras);
                sousTitreParagraphe1.setAlignment(Element.ALIGN_LEFT);
                sousTitreParagraphe1.setSpacingBefore(30);
                document.add(sousTitreParagraphe1);


             

                Paragraph sousTitreParagraphe = new Paragraph("ACCUSE DE RECEPTION    \nDU DEPOT DES ETATS FINACIERS  \n DE L’ANNEE  " + anneeExercice, sousTitreFont);
                sousTitreParagraphe.setAlignment(Element.ALIGN_CENTER);
                sousTitreParagraphe.setSpacingBefore(20);
                document.add(sousTitreParagraphe);


                Paragraph sousTitreParagraphe2 = new Paragraph("     REGIME D’IMPOSITION : " +" demande.getContribuableCopie().getRegimeDimposition().getLibelle()", defaultFontGras);
                sousTitreParagraphe2.setAlignment(Element.ALIGN_LEFT);
                sousTitreParagraphe2.setSpacingBefore(20);
                document.add(sousTitreParagraphe2);

                Paragraph sousTitreParagraphe3 = new Paragraph("        DOCUMENTS DEPOSES : ", defaultFontGras);
                sousTitreParagraphe3.setAlignment(Element.ALIGN_LEFT);
                sousTitreParagraphe3.setSpacingBefore(20);
                document.add(sousTitreParagraphe3);


                Paragraph documentParagraphe01 = new Paragraph("                - Fiche d'identification et renseignements divers ", defaultFont);
                documentParagraphe01.setSpacingBefore(10);
                document.add(documentParagraphe01);

                Paragraph documentParagraphe02 = new Paragraph("                - Bilan  ", defaultFont);
                documentParagraphe02.setSpacingBefore(0);
                document.add(documentParagraphe02);


                Paragraph documentParagraphe03 = new Paragraph("                - Compte de résultat   ", defaultFont);
                documentParagraphe03.setSpacingBefore(0);
                document.add(documentParagraphe03);

                Paragraph documentParagraphe04 = new Paragraph("                - Flux de trésorerie    ", defaultFont);
                documentParagraphe04.setSpacingBefore(0);
                document.add(documentParagraphe04);

                Paragraph documentParagraphe05 = new Paragraph("                - Notes     ", defaultFont);
                documentParagraphe05.setSpacingBefore(0);
                document.add(documentParagraphe05);


                Paragraph sousTitreParagraphe4 = new Paragraph("           NINEA : " + "demande.getContribuableCopie().getNinea()", defaultFontGras);
                sousTitreParagraphe4.setAlignment(Element.ALIGN_LEFT);
                sousTitreParagraphe4.setSpacingBefore(20);
                document.add(sousTitreParagraphe4);

                Paragraph declarant1Paragraphe = new Paragraph("                Nom ou Dénomination sociale : " + denominationSociale, defaultFont);
                declarant1Paragraphe.setSpacingBefore(10 );
                document.add(declarant1Paragraphe);

                Paragraph declarant2Paragraphe = new Paragraph("                Adresse : " + "demande.getContribuableCopie().getAdresseComplete()", defaultFont);
                declarant2Paragraphe.setSpacingBefore(0);
                document.add(declarant2Paragraphe);

                Paragraph declarant3Paragraphe = new Paragraph("                Nom de l’Agent Réceptionnaire : DGID ", defaultFont);
                declarant3Paragraphe.setSpacingBefore(0);
                document.add(declarant3Paragraphe);

                Paragraph declarant4Paragraphe = new Paragraph("                Fonction : Inspecteur des impôts ", defaultFont);
                declarant4Paragraphe.setSpacingBefore(0);
                document.add(declarant4Paragraphe);

                image3 = Image.getInstance(QRCodeGenerator.getQRCodeImage(texteQrCode, 25, 25), null);
                image3.setAbsolutePosition(460f, 15f);
                image3.scaleAbsolute(100, 100);
                document.add(image3);


                
                
                //debut gestion bg
                String IMAGEBG =  UPLOADED_FOLDER +"QRcode-bg.jpg";
                
                
                PdfContentByte canvas = writer.getDirectContentUnder();
                Image image = Image.getInstance(IMAGEBG);
               // image.scaleAbsolute(0f, 0f);
              //  image.scaleAbsolute(PageSize.A4.rotate());
                image.setAbsolutePosition(0, 0);
                canvas.addImage(image);
                
                //Fin gestion BG
                
                
                
                
                document.close();
                writer.close();
               // pieceJointeRepository.save(pieceJointe);

            } catch (BadElementException ex) {
                //   Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();

            } catch (IOException ex) {
                //  Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                ex.printStackTrace();

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "pieceJointe" ;
    }
	
	
	public static void main (String[] args)

    {

  System.out.println("Debut Génération");


    String result=createPdfAccuseReception();


   System.out.println("Fin Génération");




    }
	
	
}

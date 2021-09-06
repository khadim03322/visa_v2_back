package sn.gainde2000.orbuslink.visa.util;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class PDFGenerator {
	
	
	

    public static ByteArrayInputStream createPdfStream() {

        ByteArrayInputStream inputStream = null;

        String denominationSociale = "X";
        String anneeExercice = "2019";
        String ninea = "XXXXXX";
        String nbrPage = "X1";
        String dateSoumission = "XXXXXX";
        String totalBilan = "";
        String capitauxPropres = "";
        String resultatNet = "";
        String totalChiffreAffaire = "";
        String totalProduit = "";

        try {

            Font sousTitreFont = FontFactory.getFont(null, 8, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font defaultFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Document document = new Document();

            document.addAuthor("République du Sénégal");
            document.addCreationDate();
            document.addCreator("République du Sénégal");
            document.addTitle("Attestation Des Etats Financiers");
            document.addSubject("Attestation Des Etats Financiers PDF");
            document.addKeywords("pdf, etafi");

            //document.addLanguage(Locale.ENGLISH.getLanguage());
            document.addHeader("content-type", "application/pdf");

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();

            document.add(new Paragraph("REPUBLIQUE DU SENEGAL"));

            Image image1;
            Image image2;

            String base64Drapeau = "iVBORw0KGgoAAAANSUhEUgAAADwAAAAnCAYAAABT7SsqAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAACXBIWXMAAA7EAAAOxAGVKw4bAAAAAWJLR0SKhWh3dgAAAAd0SU1FB+EICQsZJhnspcgAAAAldEVYdGRhdGU6Y3JlYXRlADIwMTctMDgtMDlUMTE6MjU6MzgrMDA6MDCIxnEmAAAAJXRFWHRkYXRlOm1vZGlmeQAyMDE3LTA4LTA5VDExOjI1OjM4KzAwOjAw+ZvJmgAAApFJREFUaEPtmU1rU0EUht+Ze5NG6kKUVsSVoOLHRv+AxYVV2pW4KbrTjW4EN66KUsWFiD9B8B8UBSkiqDtB0AiCi1btQhQliEIT8kHujO+ZScCNQjUz2uG+cMhkzrl37pMzZyaZKNyYshiFDK1tYOcrQA8o+F4p71q35Il4Gz2usFp7i2yrhs609/2lRnOXDaQSOHWVwKmrBE5dJXDqKoFjyPKro9i/UHRgy+/YWeZN2rEVFViSmuXA84alGdeOnei4GR78Crr3xjiTdmzioMBSp0qABsZZjA5HfLJiab4tfUO/xIau7XDADsKim1noGgcaY8cm4NOawbN3lmbwcc33iU9ieoyVa0JCBzsAcNkdMzj3wKJK+onNCuN0rXy1uFP3Q549rLB3m0KrDzQI3+bj3J1VsEy9DXQAEAy4XwB51eLRF+DyUh+vlunfovycqsoFVJcmo3+3OLQHuDmTY3o7r+0paMZsqBMPOd6RBz+2Q6F+voLrsxkyQ7pczn0GVlGub2FGo36hgmnGOlhxB1K4GqY0797vsNEE5o9rLEyxo8mpIFmVOd+0uHpE4coJ9rd8rFwTUoFv7wFczbQtFpfZYlbR5WtH2sB9rtYsXscfGlYUfgiCKNbj6wbwcpVvWhYP5zQen+GGxAy/eG+dT2L8JxNWwYGlbMEt59rTApNcke0tLky7NY7u4kp8O8fOSUUfpzljXGxgBQeWxbX5DZjbp/H5ErPaUShY0wVrFi2FDxcznN7vY0a0EP9WUTJcY9meOsihuoTlVqTYFCu4/4Kr8skD2sUkkWHZnmSbMcN/I34aUXzSZwZb0R//U7EOBQd2EpBfALm+oUVQHOD/SCVw6iqBU1cJnLpK4NRVAqct4AeCJ+wf9jSN6QAAAABJRU5ErkJggg==";
            try {
                image1 = Image.getInstance(decodeToImage(base64Drapeau), null);
                image1.setAbsolutePosition(500f, 780f);
                document.add(image1);

                image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage("pause le micro", 100, 100), null);
                image2.setAbsolutePosition(470f, 50f);
                document.add(image2);

                //document.add(new Paragraph("ATTESTATION PORTANT VISA DES ETATS FINANCIERS SOCIETE "+denominationSociale));
                Paragraph titreParagraphe = new Paragraph("ATTESTATION PORTANT VISA DES ETATS FINANCIERS SOCIETE " + denominationSociale);
                titreParagraphe.setAlignment(Element.ALIGN_CENTER);
                titreParagraphe.setSpacingBefore(20);
                document.add(titreParagraphe);

                Paragraph sousTitreParagraphe = new Paragraph("ATTESTATION DE VISA DES ETATS FINANCIERS ANNUELS DE SYNTHESE \nEXERCICE CLOS LE 31 DECEMBRE " + anneeExercice, sousTitreFont);
                sousTitreParagraphe.setAlignment(Element.ALIGN_CENTER);
                sousTitreParagraphe.setSpacingBefore(20);
                document.add(sousTitreParagraphe);

                Paragraph destinataireParagraphe = new Paragraph("DESTINATAIRE : Directeur Général/Gérant");
                destinataireParagraphe.setSpacingBefore(20);
                document.add(destinataireParagraphe);

                Paragraph paragraphe1 = new Paragraph("En exécution de la mission de délivrance du visa des états financiers annuels de synthèse qui nous a été confiée par l’entité " + denominationSociale + " enregistrée sous le NINEA " + ninea + ", suivant la lettre de mission en date du " + dateSoumission + ", nous avons établi la présente attestation conformément aux dispositions de l’arrêté N° 01954 du 09/02/2018 fixant les modalités du visa des états financiers annuels de synthèse. Nous avons mis en œuvre les procédures décrites dans la norme professionnelle relative au visa des états financiers annuels de synthèse.\n"
                        + "\n"
                        + "Les états financiers annuels de l’entité " + denominationSociale + " au 31 décembre " + anneeExercice + ", visés par la présente attestation, comportent " + nbrPage + " pages et se caractérisent par les chiffres clés suivants en francs CFA :", defaultFont);
                //paragraphe1.setAlignment(Element.ALIGN_CENTER);
                paragraphe1.setSpacingBefore(10);
                document.add(paragraphe1);

                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100); //Width 100%
                table.setSpacingBefore(10f); //Space before table
                table.setSpacingAfter(10f); //Space after table

                //Set Column widths
                float[] columnWidths = {0.6f, 0.4f};
                table.setWidths(columnWidths);

                PdfPCell cell1 = new PdfPCell(new Paragraph("Libellés"));

                cell1.setPaddingLeft(10);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell2 = new PdfPCell(new Paragraph("31.12." + anneeExercice));

                cell2.setPaddingLeft(10);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell3 = new PdfPCell(new Paragraph("Total Bilan"));

                cell3.setPaddingLeft(10);
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell4 = new PdfPCell(new Paragraph(totalBilan));

                cell4.setPaddingLeft(10);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell5 = new PdfPCell(new Paragraph("Capitaux Propres"));

                cell5.setPaddingLeft(10);
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell6 = new PdfPCell(new Paragraph(capitauxPropres));

                cell6.setPaddingLeft(10);
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell7 = new PdfPCell(new Paragraph("Résultat Net"));

                cell7.setPaddingLeft(10);
                cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell8 = new PdfPCell(new Paragraph(resultatNet));

                cell8.setPaddingLeft(10);
                cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell9 = new PdfPCell(new Paragraph("Total Chiffre d'affaires"));

                cell9.setPaddingLeft(10);
                cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell10 = new PdfPCell(new Paragraph(totalChiffreAffaire));

                cell10.setPaddingLeft(10);
                cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell11 = new PdfPCell(new Paragraph("Total Produits"));

                cell11.setPaddingLeft(10);
                cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell12 = new PdfPCell(new Paragraph(totalProduit));

                cell12.setPaddingLeft(10);
                cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
                table.addCell(cell10);
                table.addCell(cell11);
                table.addCell(cell12);

                document.add(table);

                Paragraph paragraphe2 = new Paragraph("Conformément aux dispositions de l’Acte uniforme de l’OHADA relatif au droit des sociétés commerciales et du groupement d’intérêt économique, l’organe de direction de votre société est responsable de la bonne tenue des livres comptables et de la préparation de comptes réguliers et sincères, donnant une image fidèle du résultat des opérations de l’exercice écoulé ainsi que de la situation financière et du patrimoine de la société à la fin de cet exercice. Il revient aux organes de direction de votre société de définir, de mettre en œuvre et de superviser un système de contrôle interne approprié, ainsi que de mettre en place des mesures de sauvegarde des actifs, de prévention et de détection des irrégularités et fraudes.", defaultFont);
                paragraphe2.setAlignment(Element.ALIGN_JUSTIFIED);
                //paragraphe2.setSpacingBefore(0);
                document.add(paragraphe2);

                Paragraph paragraphe3 = new Paragraph("La mission de délivrance du visa n’est ni une mission présentation de comptes, ni de compilation de comptes, ni un examen limité, ni un audit et en conséquence, nous ne donnons aucune assurance sur les informations financières (ou non financières).", defaultFont);
                paragraphe3.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe3.setSpacingBefore(10);
                document.add(paragraphe3);

                Paragraph paragraphe4 = new Paragraph("A l’issue de nos travaux, nous n’avons pas relevé d’éléments remettant en cause la vraisemblance, la cohérence d’ensemble, l’homogénéité et la comparabilité des états financiers.", defaultFont);
                paragraphe4.setAlignment(Element.ALIGN_JUSTIFIED);
                document.add(paragraphe4);

                PdfPTable table2 = new PdfPTable(1);
                table2.setWidthPercentage(50f); //Width 100%

                table2.setSpacingAfter(10f); //Space after table
                table2.setSpacingBefore(8f); //Space before table
                table2.setHorizontalAlignment(Element.ALIGN_LEFT);
                //Set Column widths
                //float[] columnWidths2 = {1};
                //table.setWidths(columnWidths2);

                PdfPCell cell13 = new PdfPCell(new Paragraph("Date \nProfessionnel membre de l’ONECCA \n(signature)", defaultFont));

                cell13.setPaddingLeft(10);
                cell13.setPaddingBottom(30);
                cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table2.addCell(cell13);

                document.add(table2);

                /*
                 HeaderFooter footer = new HeaderFooter(new Phrase("- "), new Phrase("Conformément aux dispositions de l’article 31 du Code général des Impôts, le visa obligatoire des états financiers de synthèse est institué par l’arrêté n° 01954 du 09 février 2018 en vue de renforcer la fiabilité et la transparence de l’information financière"));
                 footer.setAlignment(Element.ALIGN_CENTER);
                 footer.setBorder(Rectangle.NO_BORDER);
                 document.setFooter(footer);
                
                 writer.setFooter(footer);*/
                document.close();
                writer.close();

                //System.out.println("outputStream " + outputStream.size());
                inputStream = new ByteArrayInputStream(outputStream.toByteArray());
                System.out.println("stream 1 " + inputStream.read());
            } catch (BadElementException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static void createPdfEC(Depot demande, int nbrPagePieceJointe, String cheminFichier, Utilisateur utilisateur, int choixSignature,String nomFichierSigne) {
        String signataire = utilisateur.getPrenom() + " " + utilisateur.getNom()+" "+utilisateur.getMatricule();
        
        Document document = new Document();
        document.addAuthor("République du Sénégal");
        document.addCreationDate();
        document.addCreator("République du Sénégal");
        document.addTitle("Attestation Des Etats Financiers");
        document.addSubject("Attestation Des Etats Financiers PDF");
        document.addKeywords("pdf, etafi");
        //document.addLanguage(Locale.ENGLISH.getLanguage());

        document.addHeader("type", "document, etafi");

        String denominationSociale = demande.getContribuable().getNomOuRaisonSocial();
        String anneeExercice = demande.getAnneeExcercice().toString();
        String ninea = demande.getContribuable().getNinea();
        String nbrPage = String.valueOf(nbrPagePieceJointe);
        String dateSoumission = null;
        String dateActuelle = null;
        
        SimpleDateFormat dateActuelleFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateActuelle = dateActuelleFormat.format(new Date());
                        
        if (demande.getDep_DateSoumission() != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            dateSoumission = dt.format(DateUtils.convertLocalDateTimeToDateUsingInstant(demande.getDep_DateSoumission().minusDays(2)));
        }
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        String totalBilan = formatter.format(demande.getTotalBilan());
        String capitauxPropres = formatter.format(demande.getCapitauxPropre());
        String resultatNet = formatter.format(demande.getResultatNet());
        String totalChiffreAffaire = formatter.format(demande.getChiffreAffaire());
        String totalProduit = formatter.format(demande.getTotalProduit());
        
        String comptable;
        
        if(choixSignature == 1)
        {
            comptable=demande.getUtilisateurReceive().getStructure().getNomOuRaisonSocial()+" / "+ utilisateur.getPrenom() + " " + utilisateur.getNom();
        }
        else
        {
            comptable=utilisateur.getPrenom() + " " + utilisateur.getNom();        
        }

        String nomFichier = nomFichierSigne;
////        String nomFichier = "attestation_temp_" + demande.getId() + ".pdf";
        //System.out.println("nouveau fichier " + cheminFichier + nomFichier);
        try {
            //Font arial = FontFactory.getFont("/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font sousTitreFont = FontFactory.getFont(null, 8, Font.BOLD, new CMYKColor(255, 255, 255, 1));
            //Font defaultFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font defaultFontGras = FontFactory.getFont("/fonts/arial.ttf", 9, Font.BOLD, new CMYKColor(255, 255, 255, 1));
            Font defaultFont = FontFactory.getFont("/fonts/arial.ttf", 9, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font smallFont = FontFactory.getFont("/fonts/arial.ttf", 9, Font.NORMAL, new CMYKColor(255, 255, 255, 1));            
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(cheminFichier + nomFichier));
            document.open();

            Image image2;
            
            try {

                String texteQrCode="Signataire= "+signataire+"!Entreprise= "+demande.getContribuable().getNomOuRaisonSocial()+" !Total Bilan= "+totalBilan+" !Capitaux Propres= "+capitauxPropres+" !Résultat Net= "+resultatNet+" !Total Chiffre d'affaires= "+totalChiffreAffaire+" !Total Produits= "+totalProduit+" !Date= "+dateActuelle;
                //System.out.println("string: "+texteQrCode);
                //image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage(getCryptedQrCode(demande), 100, 100), null);
                image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage(texteQrCode, 125, 125), null);
                image2.setAbsolutePosition(470f, 60f);
                image2.scaleAbsolute(100, 100);
                document.add(image2);

                //document.add(new Paragraph("ATTESTATION PORTANT VISA DES ETATS FINANCIERS SOCIETE "+denominationSociale));
                Paragraph titreParagraphe = new Paragraph("ATTESTATION PORTANT VISA DES ETATS FINANCIERS");
                titreParagraphe.setAlignment(Element.ALIGN_CENTER);
                titreParagraphe.setSpacingBefore(0);
                document.add(titreParagraphe);

                Paragraph sousTitreParagraphe = new Paragraph("ATTESTATION DE VISA DES ETATS FINANCIERS ANNUELS DE SYNTHESE \nEXERCICE CLOS LE 31 DECEMBRE " + anneeExercice, sousTitreFont);
                sousTitreParagraphe.setAlignment(Element.ALIGN_CENTER);
                sousTitreParagraphe.setSpacingBefore(20);
                document.add(sousTitreParagraphe);
                
                Paragraph declarant1Paragraphe = new Paragraph("Madame/Monsieur: "+demande.getContribuable().getResponsableMorale(), defaultFontGras);
                declarant1Paragraphe.setSpacingBefore(10);
                document.add(declarant1Paragraphe);
                
                Paragraph declarant2Paragraphe = new Paragraph("Fonction: "+demande.getContribuable().getFonction().getLibelle(), defaultFont);
                declarant2Paragraphe.setSpacingBefore(0);
                document.add(declarant2Paragraphe);
                
                Paragraph declarant3Paragraphe = new Paragraph("Société: "+denominationSociale, defaultFont);
                declarant3Paragraphe.setSpacingBefore(0);
                document.add(declarant3Paragraphe);
                
                Paragraph declarant4Paragraphe = new Paragraph("Adresse: "+demande.getContribuable().getAdresseComplete(), defaultFont);
                declarant4Paragraphe.setSpacingBefore(0);
                document.add(declarant4Paragraphe);

                Paragraph destinataireParagraphe = new Paragraph("DESTINATAIRE : Directeur Général/Gérant", defaultFontGras);
                destinataireParagraphe.setSpacingBefore(20);
                document.add(destinataireParagraphe);

                Paragraph paragraphe1 = new Paragraph("En exécution de la mission de délivrance du visa des états financiers annuels de synthèse qui nous a été confiée par l’entité " + denominationSociale + " enregistrée sous le NINEA " + ninea + ", suivant la lettre de mission en date du " + dateSoumission + ", nous avons établi la présente attestation conformément aux dispositions de l’arrêté N° 01954 du 09/02/2018 fixant les modalités du visa des états financiers annuels de synthèse. Nous avons mis en œuvre les procédures décrites dans la norme professionnelle relative au visa des états financiers annuels de synthèse.\n"
                        + "\n"
                        + "Les états financiers annuels de l’entité " + denominationSociale + " au 31 décembre " + anneeExercice + ", visés par la présente attestation, comportent " + nbrPage + " pages et se caractérisent par les chiffres clés suivants en francs CFA :", defaultFont);
                //paragraphe1.setAlignment(Element.ALIGN_CENTER);
                paragraphe1.setSpacingBefore(10);
                document.add(paragraphe1);

                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100); //Width 100%
                table.setSpacingBefore(10f); //Space before table
                table.setSpacingAfter(10f); //Space after table

                //Set Column widths
                float[] columnWidths = {0.6f, 0.4f};
                table.setWidths(columnWidths);

                PdfPCell cell1 = new PdfPCell(new Paragraph("Libellés", defaultFontGras));

                cell1.setPaddingLeft(10);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell2 = new PdfPCell(new Paragraph("31.12." + anneeExercice, defaultFontGras));

                cell2.setPaddingLeft(10);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell3 = new PdfPCell(new Paragraph("Total Bilan", defaultFont));

                cell3.setPaddingLeft(10);
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);                

                PdfPCell cell4 = new PdfPCell(new Paragraph(totalBilan, defaultFont));

                cell4.setPaddingRight(10);
                cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell5 = new PdfPCell(new Paragraph("Capitaux Propres", defaultFont));

                cell5.setPaddingLeft(10);
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell6 = new PdfPCell(new Paragraph(capitauxPropres, defaultFont));

                cell6.setPaddingRight(10);
                cell6.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell7 = new PdfPCell(new Paragraph("Résultat Net", defaultFont));

                cell7.setPaddingLeft(10);
                cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell8 = new PdfPCell(new Paragraph(resultatNet, defaultFont));

                cell8.setPaddingRight(10);
                cell8.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell9 = new PdfPCell(new Paragraph("Total Chiffre d'affaires", defaultFont));

                cell9.setPaddingLeft(10);
                cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell10 = new PdfPCell(new Paragraph(totalChiffreAffaire, defaultFont));

                cell10.setPaddingRight(10);
                cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell11 = new PdfPCell(new Paragraph("Total Produits", defaultFont));

                cell11.setPaddingLeft(10);
                cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell12 = new PdfPCell(new Paragraph(totalProduit, defaultFont));

                cell12.setPaddingRight(10);
                cell12.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
                table.addCell(cell10);
                table.addCell(cell11);
                table.addCell(cell12);

                document.add(table);

                Paragraph paragraphe2 = new Paragraph("Conformément aux dispositions de l’Acte uniforme de l’OHADA relatif au droit des sociétés commerciales et du groupement d’intérêt économique, l’organe de direction de votre société est responsable de la bonne tenue des livres comptables et de la préparation de comptes réguliers et sincères, donnant une image fidèle du résultat des opérations de l’exercice écoulé ainsi que de la situation financière et du patrimoine de la société à la fin de cet exercice. Il revient aux organes de direction de votre société de définir, de mettre en œuvre et de superviser un système de contrôle interne approprié, ainsi que de mettre en place des mesures de sauvegarde des actifs, de prévention et de détection des irrégularités et fraudes.", defaultFont);
                paragraphe2.setAlignment(Element.ALIGN_JUSTIFIED);
                //paragraphe2.setSpacingBefore(0);
                document.add(paragraphe2);

                Paragraph paragraphe3 = new Paragraph("La mission de délivrance du visa n’est ni une mission présentation de comptes, ni de compilation de comptes, ni un examen limité, ni un audit et en conséquence, nous ne donnons aucune assurance sur les informations financières (ou non financières).", defaultFont);
                paragraphe3.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe3.setSpacingBefore(10);
                document.add(paragraphe3);

                Paragraph paragraphe4 = new Paragraph("A l’issue de nos travaux, nous n’avons pas relevé d’éléments remettant en cause la vraisemblance, la cohérence d’ensemble, l’homogénéité et la comparabilité des états financiers.", defaultFontGras);
                paragraphe4.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe4.setSpacingBefore(10);
                paragraphe4.setSpacingAfter(10);
                document.add(paragraphe4);
                
                Paragraph paragraphe5 = new Paragraph(comptable, defaultFontGras);
                paragraphe5.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe5.setSpacingBefore(10);
                paragraphe5.setSpacingAfter(10);
                document.add(paragraphe5);

                PdfPTable table2 = new PdfPTable(1);
                table2.setWidthPercentage(50f); //Width 100%

                table2.setSpacingAfter(10f); //Space after table
                table2.setSpacingBefore(8f); //Space before table
                table2.setHorizontalAlignment(Element.ALIGN_LEFT);

                PdfPCell cell13 = new PdfPCell(new Paragraph("Date \nProfessionnel membre de l’ONECCA \n(signature)", defaultFontGras));

                cell13.setPaddingLeft(10);
                cell13.setPaddingBottom(20);
                cell13.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table2.addCell(cell13);

                document.add(table2);
                
                Paragraph paragraphe6 = new Paragraph("Numéro VISA\n  "+demande.getNumero(), smallFont);
                //paragraphe5.setAlignment(Element.ALIGN_CENTER);
                paragraphe6.setSpacingBefore(-50);
                paragraphe6.setIndentationLeft(310);                
                
                document.add(paragraphe6);

                document.close();
                writer.close();

            } catch (BadElementException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    public static void createPdfCAC(Depot demande, int nbrPagePieceJointe, String cheminFichier, Utilisateur utilisateur, int choixSignature,String nomFichierSigne) {
        String signataire = utilisateur.getPrenom() + " " + utilisateur.getNom()+" "+utilisateur.getMatricule();

        Document document = new Document();
        document.addAuthor("République du Sénégal");
        document.addCreationDate();
        document.addCreator("République du Sénégal");
        document.addTitle("Attestation Des Etats Financiers");
        document.addSubject("Attestation Des Etats Financiers PDF");
        document.addKeywords("pdf, etafi");

        document.addHeader("type", "document, etafi");

        String denominationSociale = demande.getContribuable().getNomOuRaisonSocial();
        String anneeExercice = demande.getAnneeExcercice().toString();
        String nbrPage = String.valueOf(nbrPagePieceJointe);
        String dateSoumission = null;
        String dateActuelle = null;
        
        SimpleDateFormat dateActuelleFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateActuelle = dateActuelleFormat.format(new Date());
            
        if (demande.getDep_DateSoumission() != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            
            dateSoumission = dt.format(DateUtils.convertLocalDateTimeToDateUsingInstant(demande.getDep_DateSoumission()));
        }
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        String totalBilan = formatter.format(demande.getTotalBilan());
        String capitauxPropres = formatter.format(demande.getCapitauxPropre());
        String resultatNet = formatter.format(demande.getResultatNet());
        String totalChiffreAffaire = formatter.format(demande.getChiffreAffaire());
        String totalProduit = formatter.format(demande.getTotalProduit());
        
        String comptable;
        
        if(choixSignature == 1)
        {
            comptable=demande.getUtilisateurReceive().getStructure().getNomOuRaisonSocial() +" / "+ utilisateur.getPrenom() + " " + utilisateur.getNom();
        }
        else
        {
            comptable=utilisateur.getPrenom() + " " + utilisateur.getNom();        
        }

        String nomFichier = nomFichierSigne;
        //System.out.println("nouveau fichier " + cheminFichier + nomFichier);
        try {
            //Font arial = FontFactory.getFont("/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font sousTitreFont = FontFactory.getFont(null, 8, Font.BOLD, new CMYKColor(255, 255, 255, 1));
            //Font defaultFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            Font defaultFontGras = FontFactory.getFont("/fonts/arial.ttf", 9, Font.BOLD, new CMYKColor(255, 255, 255, 1));
            Font defaultFont = FontFactory.getFont("/fonts/arial.ttf", 9, Font.NORMAL, new CMYKColor(255, 255, 255, 1));
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(cheminFichier + nomFichier));
            document.open();

            Image image2;
            Image image3;

            try {
                String texteQrCode="Signataire= "+signataire+"!Entreprise= "+demande.getContribuable().getNomOuRaisonSocial()+" !Total Bilan= "+totalBilan+" !Capitaux Propres= "+capitauxPropres+" !Résultat Net= "+resultatNet+" !Total Chiffre d'affaires= "+totalChiffreAffaire+" !Total Produits= "+totalProduit+" !Date= "+dateActuelle;
                //System.out.println("string: "+texteQrCode);
                //image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage(getCryptedQrCode(demande), 100, 100), null);
                image2 = Image.getInstance(QRCodeGenerator.getQRCodeImage(texteQrCode, 125, 125), null);
                image2.setAbsolutePosition(470f, 40f);
                image2.scaleAbsolute(100, 100);                              

                
                //document.add(new Paragraph("ATTESTATION PORTANT VISA DES ETATS FINANCIERS SOCIETE "+denominationSociale));
                Paragraph titreParagraphe = new Paragraph("MODELE D'ATTESTATION DE VISA DES ETATS FINANCIERS DE SYNTHESE ", defaultFontGras);
                titreParagraphe.setAlignment(Element.ALIGN_CENTER);
                titreParagraphe.setSpacingBefore(0);
                document.add(titreParagraphe);
                
                Paragraph sousTitreParagraphe1 = new Paragraph("(à adapter au contexte de la mission tout en respectant les dispositions de la norme relative au visa des états financiers de synthèse)", defaultFontGras);
                sousTitreParagraphe1.setAlignment(Element.ALIGN_CENTER);
                sousTitreParagraphe1.setSpacingBefore(0);
                document.add(sousTitreParagraphe1);

                Paragraph sousTitreParagraphe = new Paragraph("ATTESTATION DE VISA DES ETATS FINANCIERS ANNUELS DE SYNTHESE \nEXERCICE CLOS LE 31 DECEMBRE " + anneeExercice, sousTitreFont);
                sousTitreParagraphe.setAlignment(Element.ALIGN_CENTER);
                sousTitreParagraphe.setSpacingBefore(20);
                document.add(sousTitreParagraphe);
                
                Paragraph declarant1Paragraphe = new Paragraph("Madame/Monsieur: "+demande.getContribuable().getResponsableMorale(), defaultFontGras);
                declarant1Paragraphe.setSpacingBefore(10);
                document.add(declarant1Paragraphe);
                
                Paragraph declarant2Paragraphe = new Paragraph("Fonction: "+demande.getContribuable().getFonction().getLibelle(), defaultFont);
                declarant2Paragraphe.setSpacingBefore(0);
                document.add(declarant2Paragraphe);
                
                Paragraph declarant3Paragraphe = new Paragraph("Société: "+denominationSociale, defaultFont);
                declarant3Paragraphe.setSpacingBefore(0);
                document.add(declarant3Paragraphe);
                
                Paragraph declarant4Paragraphe = new Paragraph("Adresse: "+demande.getContribuable().getAdresseComplete(), defaultFont);
                declarant4Paragraphe.setSpacingBefore(0);
                document.add(declarant4Paragraphe);

                Paragraph destinataireParagraphe = new Paragraph("Madame/Monsieur", defaultFont);
                destinataireParagraphe.setSpacingBefore(15);
                document.add(destinataireParagraphe);

                Paragraph paragraphe1 = new Paragraph("Dans le cadre de notre mandat de commissaire aux comptes, nous avons établi la présente attestation conformément aux dispositions de l’arrêté N° 01954 du 09/02/2018 fixant les modalités du visa des états financiers annuels de synthèse dans le seul but de délivrer l’attestation portant VISA des états financiers à déposer au Guichet Unique de Dépôt des Etats financiers (GUDEF). Nous avons mis en œuvre les procédures décrites dans la norme professionnelle relative au visa des états financiers annuels de synthèse.\n"
                        + "\n"
                        + "Les états financiers annuels, visés par la présente attestation, comportent "+nbrPage+" pages et se caractérisent par les chiffres clés suivants en francs CFA : ", defaultFont);
                //paragraphe1.setAlignment(Element.ALIGN_CENTER);
                paragraphe1.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe1.setSpacingBefore(10);
                document.add(paragraphe1);

                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100); //Width 100%
                table.setSpacingBefore(10f); //Space before table
                table.setSpacingAfter(10f); //Space after table

                //Set Column widths
                float[] columnWidths = {0.6f, 0.4f};
                table.setWidths(columnWidths);

                PdfPCell cell1 = new PdfPCell(new Paragraph("Libellés", defaultFontGras));

                cell1.setPaddingLeft(10);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell2 = new PdfPCell(new Paragraph("31.12." + anneeExercice, defaultFontGras));

                cell2.setPaddingLeft(10);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell3 = new PdfPCell(new Paragraph("Total Bilan", defaultFont));

                cell3.setPaddingLeft(10);
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                
                PdfPCell cell4 = new PdfPCell(new Paragraph(totalBilan, defaultFont));

                cell4.setPaddingRight(10);
                cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell5 = new PdfPCell(new Paragraph("Capitaux Propres", defaultFont));

                cell5.setPaddingLeft(10);
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell6 = new PdfPCell(new Paragraph(capitauxPropres, defaultFont));

                cell6.setPaddingRight(10);
                cell6.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell7 = new PdfPCell(new Paragraph("Résultat Net", defaultFont));

                cell7.setPaddingLeft(10);
                cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell8 = new PdfPCell(new Paragraph(resultatNet, defaultFont));

                cell8.setPaddingRight(10);
                cell8.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell9 = new PdfPCell(new Paragraph("Total Chiffre d'affaires", defaultFont));

                cell9.setPaddingLeft(10);
                cell9.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell10 = new PdfPCell(new Paragraph(totalChiffreAffaire, defaultFont));

                cell10.setPaddingRight(10);
                cell10.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell11 = new PdfPCell(new Paragraph("Total Produits", defaultFont));

                cell11.setPaddingLeft(10);
                cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell12 = new PdfPCell(new Paragraph(totalProduit, defaultFont));

                cell12.setPaddingRight(10);
                cell12.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                table.addCell(cell7);
                table.addCell(cell8);
                table.addCell(cell9);
                table.addCell(cell10);
                table.addCell(cell11);
                table.addCell(cell12);

                document.add(table);

                Paragraph paragraphe2 = new Paragraph("Au stade actuel de nos travaux, les états financiers annuels n’ont pas encore fait l’objet d’arrêté par le conseil d’administration/l’administrateur général/le gérant.", defaultFont);
                paragraphe2.setAlignment(Element.ALIGN_JUSTIFIED);
                //paragraphe2.setSpacingBefore(0);
                document.add(paragraphe2);

                Paragraph paragraphe3 = new Paragraph("Nous nous permettons d’attirer votre attention sur le fait que conformément à l’article 710 de l’Acte Uniforme relatif au droit des Sociétés Commerciales et du Groupement d’Intérêt Economique "
                + "(AUSCGIE), les états financiers annuels doivent être réguliers, sincères et donner une image fidèle du patrimoine, de la situation financière et du résultat de votre entité. Vous restez ainsi responsables à l’égard des tiers de l’exhaustivité, "
                + "de la fiabilité, de l’exactitude des informations comptables et financières concourant à la présentation des comptes, de définir, de mettre en œuvre et de superviser un système de contrôle interne approprié, ainsi que de mettre en place des mesures "
                + "de sauvegarde des actifs, de prévention et de détection des irrégularités et fraudes. Cela implique notamment le respect des règles applicables à la tenue d’une comptabilité au Sénégal et du référentiel comptable applicable à votre secteur d’activité.\n" +
                "Vous êtes en outre responsable de la bonne application de la législation et des règlements fiscaux en vigueur ; nous ne pourrons être considérés comme se substituant à vos obligations du fait de cette attestation.", defaultFont);
                paragraphe3.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe3.setSpacingBefore(10);
                document.add(paragraphe3);

                Paragraph paragraphe4 = new Paragraph("Les procédures ci-après ont été mises en œuvre dans le seul but de délivrer l’attestation portant VISA des états financiers à déposer au Guichet Unique de Dépôt des Etats financiers (GUDEF).", defaultFont);
                paragraphe4.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe4.setSpacingBefore(10);
                document.add(paragraphe4);
                
                Paragraph paragraphe5 = new Paragraph("1.    Nous avons obtenu les balances générale et auxiliaires de la société, procédé à leur contrôle arithmétique et vérifié que :", defaultFont);
                paragraphe5.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe5.setSpacingBefore(10);
                document.add(paragraphe5);
                
                Paragraph paragraphe6 = new Paragraph("-  les soldes d’ouverture concordent bien avec les soldes de clôture de l’exercice précédent sauf exception dûment justifiée ;", defaultFont);
                paragraphe6.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe6.setSpacingBefore(10);
                paragraphe6.setIndentationLeft(15);
                document.add(paragraphe6);
                //document.newPage();
                
                Paragraph paragraphe7 = new Paragraph("-  les balances (générale et auxiliaires) à partir desquelles sont effectués les contrôles sont équilibrées ;", defaultFont);
                paragraphe7.setAlignment(Element.ALIGN_JUSTIFIED);                
                paragraphe7.setIndentationLeft(15);
                paragraphe7.setSpacingBefore(5);
                document.add(paragraphe7);
                
                Paragraph paragraphe8 = new Paragraph("-  tous les comptes de la balance générale sont bien pris en compte dans les états financiers annuels à déposer au GUDEF ;", defaultFont);
                paragraphe8.setAlignment(Element.ALIGN_JUSTIFIED);                
                paragraphe8.setIndentationLeft(15);
                paragraphe8.setSpacingBefore(5);
                document.add(paragraphe8);
                
                Paragraph paragraphe9 = new Paragraph("-  tous les contrôles arithmétiques nécessaires sont satisfaisants.", defaultFont);
                paragraphe9.setAlignment(Element.ALIGN_JUSTIFIED);                
                paragraphe9.setIndentationLeft(15);
                paragraphe9.setSpacingBefore(5);
                document.add(paragraphe9);
                
                image3 = Image.getInstance(QRCodeGenerator.getQRCodeImage(texteQrCode, 125, 125), null);
                image3.setAbsolutePosition(470f, 10f);
                image3.scaleAbsolute(100, 100);
                document.add(image3);
                
                document.newPage();
                
                Paragraph paragraphe10 = new Paragraph("2.    Nous avons procédé à la vérification de la conformité des principes, règles et méthodes comptables appliqués avec le référentiel comptable en vigueur sur la base de la déclaration de la direction et/ou la revue par le professionnel de l’expertise comptable membre de l’ONECCA desdits principes, règles et méthodes comptables.", defaultFont);
                paragraphe10.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe10.setSpacingBefore(10);
                document.add(paragraphe10);
                
                Paragraph paragraphe11 = new Paragraph("3.    Nous avons vérifié l’existence d’éléments constitutifs d’une comptabilité générale (pièces comptables, grands livres, balance générale).", defaultFont);
                paragraphe11.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe11.setSpacingBefore(10);
                document.add(paragraphe11);
                
                Paragraph paragraphe12 = new Paragraph("4.    Nous avons vérifié la validité des informations présentées dans les états financiers annuels et non directement issues de la comptabilité.", defaultFont);
                paragraphe12.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe12.setSpacingBefore(10);
                document.add(paragraphe12);
                
                Paragraph paragraphe13 = new Paragraph("5.    Nous avons procédé à la vérification portant sur les informations suivantes : la forme juridique, le régime fiscal, l'actionnariat, les activités de l'entité.", defaultFont);
                paragraphe13.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe13.setSpacingBefore(10);
                document.add(paragraphe13);
                
                Paragraph paragraphe14 = new Paragraph("6.    Nous avons effectué la vérification de la page de garde pour nous assurer qu'elle contient les informations suivantes : le système comptable appliqué par le contribuable, l'année d'exercice, le nom et la raison sociale, le numéro de compte contribuable.", defaultFont);
                paragraphe14.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe14.setSpacingBefore(10);
                document.add(paragraphe14);
                
                Paragraph paragraphe15 = new Paragraph("7.    Nous avons vérifié l'exactitude du numéro de compte contribuable déclaré.", defaultFont);
                paragraphe15.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe15.setSpacingBefore(10);
                document.add(paragraphe15);
                
                Paragraph paragraphe16 = new Paragraph("8.    Nous avons procédé à la vérification de la fiche d'identification et renseignements divers, notamment, la désignation précise de l'activité principale, les domiciliations bancaires, le nom et la qualité du signataire des états financiers.", defaultFont);
                paragraphe16.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe16.setSpacingBefore(10);
                document.add(paragraphe16);
                
                Paragraph paragraphe17 = new Paragraph("9.    Nous avons vérifié la structure des états financiers tel qu'exigée par les dispositions légales et réglementaires.", defaultFont);
                paragraphe17.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe17.setSpacingBefore(10);
                document.add(paragraphe17);
                
                Paragraph paragraphe18 = new Paragraph("Les travaux effectués nous conduisent aux constatations suivantes :", defaultFontGras);
                paragraphe18.setSpacingBefore(20);
                document.add(paragraphe18);
                
                Paragraph paragraphe19 = new Paragraph("1.    Les vérifications relatées au point 1 n'ont pas révélé d'erreur.", defaultFont);
                paragraphe19.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe19.setSpacingBefore(20);
                document.add(paragraphe19);
                
                Paragraph paragraphe20 = new Paragraph("2.    Les vérifications visées au point 2 n'ont pas révélé d'anomalies.", defaultFont);
                paragraphe20.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe20.setSpacingBefore(10);
                document.add(paragraphe20);
                
                Paragraph paragraphe21 = new Paragraph("3.    Nous avons examiné par sondage les pièces comptables constitutives de la comptabilité et ayant servi de base à l’élaboration des états financiers.", defaultFont);
                paragraphe21.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe21.setSpacingBefore(10);
                document.add(paragraphe21);
                
                Paragraph paragraphe22 = new Paragraph("4.    Les vérifications visées au point 4 n’ont pas révélé d’anomalies significatives.", defaultFont);
                paragraphe22.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe22.setSpacingBefore(10);
                document.add(paragraphe22);
                
                Paragraph paragraphe23 = new Paragraph("5.   Concernant les procédures relatées au point 5, nous avons examiné la documentation juridique, fiscale et vérifié la concordance des informations y figurant avec celles mentionnées sur les états financiers.", defaultFont);
                paragraphe23.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe23.setSpacingBefore(10);
                document.add(paragraphe23);
                
                Paragraph paragraphe24 = new Paragraph("6.    Les vérifications de la page de garde visées au point 5 n’ont pas révélé d’anomalies.", defaultFont);
                paragraphe24.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe24.setSpacingBefore(10);
                document.add(paragraphe24);
                
                Paragraph paragraphe25 = new Paragraph("7.    Le contrôle du numéro de compte contribuable déclaré n’a pas révélé d’erreur.", defaultFont);
                paragraphe25.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe25.setSpacingBefore(10);
                document.add(paragraphe25);
                
                Paragraph paragraphe26 = new Paragraph("8.    La vérification de la fiche d'identification et renseignements divers, notamment, la désignation précise de l'activité principale, les domiciliations bancaires, le nom et la qualité du signataire des états financiers n’a pas révélé d’anomalies.", defaultFont);
                paragraphe26.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe26.setSpacingBefore(10);
                document.add(paragraphe26);
                
                Paragraph paragraphe27 = new Paragraph("9.    La vérification de la structure des états financiers tel qu'exigée par les dispositions légales et réglementaires ne révèle pas d’anomalies.", defaultFont);
                paragraphe27.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe27.setSpacingBefore(10);
                document.add(paragraphe27);
                
                Paragraph paragraphe28 = new Paragraph("A l’issue de nos travaux, nous n’avons pas relevé d’éléments remettant en cause la vraisemblance, la cohérence d’ensemble, l’homogénéité et la comparabilité des états financiers.", defaultFont);
                paragraphe28.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe28.setSpacingBefore(10);
                document.add(paragraphe28);
                
                Paragraph paragraphe29 = new Paragraph("Notre attestation n'a pour seul objectif que celui indiqué dans le premier paragraphe et est réservé au dépôt des états financiers annuels au GUDEF. Il ne peut être utilisé à d'autres fins, ni diffusé à d'autres parties.", defaultFont);
                paragraphe29.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe29.setSpacingBefore(10);
                document.add(paragraphe29);
                
                Paragraph paragraphe30 = new Paragraph(comptable, defaultFontGras);
                paragraphe30.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe30.setSpacingBefore(10);
                document.add(paragraphe30);
                
                Paragraph paragraphe31 = new Paragraph("Date \nProfessionnel membre de l’ONECCA \n(signature)", defaultFontGras);
                paragraphe31.setAlignment(Element.ALIGN_JUSTIFIED);
                paragraphe31.setSpacingBefore(10);
                document.add(paragraphe31);
                
                image3 = Image.getInstance(QRCodeGenerator.getQRCodeImage(texteQrCode, 125, 125), null);
                image3.setAbsolutePosition(470f, 10f);
                image3.scaleAbsolute(100, 100);
                document.add(image3);

                document.close();
                writer.close();

            } catch (BadElementException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String Pdf2Base64(String filePath, String originalFileName, String newFileName) throws FileNotFoundException, IOException {
 
        byte[] input_file = Files.readAllBytes(Paths.get(filePath + originalFileName));
        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
        String encodedString = new String(encodedBytes);
        System.out.println("code base64 du pdf \n");
        // System.out.println(encodedString);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());

        return encodedString;
        /*FileOutputStream fos = new FileOutputStream(filePath+newFileName);
         fos.write(decodedBytes);
         fos.flush();
         fos.close();*/
    }

    public static int base64ToPdf(String fileName, String payload) {
        FileOutputStream fos = null;
        int resultat = 0;

        try {
            // System.out.println(encodedString);
            byte[] decodedBytes = Base64.getDecoder().decode(payload.getBytes());
            fos = new FileOutputStream(fileName);
            fos.write(decodedBytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultat;
    }

    public static String inputStream2Base64(ByteArrayInputStream input_file) throws FileNotFoundException, IOException {
        byte[] imageBytes = new byte[(int) input_file.available()];
        input_file.read(imageBytes, 0, imageBytes.length);
        input_file.close();
        String imageStr = Base64.getEncoder().encodeToString(imageBytes);
        return imageStr;

    }

    public static BufferedImage decodeToImage(String imageString) {
        BufferedImage image = null;
        byte[] imageByte;
        try {
            imageByte = Base64.getMimeDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("erreur: " + e);
        }
        return image;
    }

    public static String getCryptedQrCode(Depot demande) {
        //System.out.println("demande: "+demande);
/*
        String encryptedMessage = "";
        String uncryptedMessage = "Denomination sociale: " + demande.getStructureDemande().getDenominationSociale() + " \n NINEA: " + demande.getStructureDemande().getNinea() + " \n Date soumission: " + demande.getDateSoumission();
        try {
            String certLocation = new ClassPathResource(sslFileLocation).getFile().getAbsolutePath();
            char[] password = "cosecorbus".toCharArray();
            KeyStore ks = RsaCryptDecrypt.getCertificat(certLocation, password);

            PublicKey publickey = getPublicKey(ks);
            encryptedMessage = RsaCryptDecrypt.cryptMessage(publickey, uncryptedMessage);
            System.out.println("encryptedMessage = " + encryptedMessage);
        } catch (IOException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return "message vide";
    }

    public static void main(String[] args) {

        try {
        	
        	
        	System.out.println("Debut de la Génération ");
        	
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
        	String cheminFichier="F://TesteAccuse/";
        	Utilisateur utilisateur = new Utilisateur();
        	utilisateur.setNom("Demba");
        	utilisateur.setPrenom("Ndiaye");
        	 int choixSignature=1;
        	 //PDFGenerator.createPdfCAC(demande, nbrPage, cheminFichier, utilisateur, choixSignature);
        	 PDFGenerator.createPdfEC(demande, nbrPage, cheminFichier, utilisateur, choixSignature,"signer.pdf");
        	
        	System.out.println("FIn de la Génération ");
            
        } catch (Exception ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //accuse de recception
	
	

}

package sn.gainde2000.orbuslink.visa.util;
import java.io.IOException;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
public class SignatureWebServiceRequester {

    //static final String URL_SIGNATURE = "http://172.16.3.253/PORTAILVISA/CallForSigning.asmx" ;

    //static final String URL_SIGNATURE = "http://10.6.1.12/PORTAILVISA/CallForSigning.asmx" ;

    //static final String NOMFICHIER = "attestation.pdf";
    //static final String NEWNAME = "attestation.pdf";

    // static final String NAMEPDFSIGNER = "document-output.pdf";


    public static String signerDocumentAttestation(Depot demande, String nomFichierSigne, String cheminFichier, int nbrPage, Utilisateur utilisateur, String codePin, String typeMission, int choixSignature, String URL_SIGNATURE,String NEWNAME) {
        //System.out.println("debut requete");

        String url = URL_SIGNATURE;
        String delegation;
        String key;

        if(choixSignature == 1) {
            delegation = utilisateur.getDelagation();
            key = utilisateur.getSignatureKeyId();
        }else {
            delegation = utilisateur.getDelagationProf();
            key = utilisateur.getSignatureKeyIdProf();
        }

        System.out.println((choixSignature == 1) ? utilisateur.getDelagation() : utilisateur.getDelagationProf());
        String payload1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:btr=\"http://btrust360.com/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <btr:Signing>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:delegationID>" + delegation + "</btr:delegationID>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:signatureKeyId>" + key + "</btr:signatureKeyId>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:codeSecretUtilisateur>" + codePin + "</btr:codeSecretUtilisateur>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:binaryData>";



        String payload2 = "";
        try {
            //String signataire = utilisateur.getPrenom() + " " + utilisateur.getNom()+" "+utilisateur.getMatricule();
            //QRCodeGenerator.generateQRCodeImage("gfdgfd+cvfdgfggd-gfdgfd+gfdgfgfc+4654dgfd+Agfgdfg+gfdgvbdfgfhgfg+54gdfgfdsfdsf+vbfdgfdgdfgfdggfdg+gdfgdfgfdbcvbdbgfhgfh",100,100,"./qrcode.png");
            if (typeMission.equals("CAC")) {
                PDFGenerator.createPdfCAC(demande, nbrPage, cheminFichier, utilisateur, choixSignature,nomFichierSigne);
            } else {
                PDFGenerator.createPdfEC(demande, nbrPage, cheminFichier, utilisateur, choixSignature,nomFichierSigne);
            }

            payload2 = PDFGenerator.Pdf2Base64(cheminFichier, nomFichierSigne, NEWNAME);
            //;PDFGenerator.Pdf2Base64("D:\\PDF\\","test1.pdf","testout2.pdf");
        } catch (IOException ex) {
            Logger.getLogger(SignatureWebServiceRequester.class.getName()).log(Level.SEVERE, null, ex);
        }

        String payload3 = "</btr:binaryData>"
                + "       </btr:Signing>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        String time = Long.toString(new Date().getTime());
        String payload = payload1 + payload2 + payload3;
        String result1 = envoyerPayload(payload, url, nomFichierSigne,cheminFichier);

        if (result1.contains("MSIGN_SRV_STATUS_SUCCESS")) {
            return "success";
        } else if (result1.contains("Could not sign specified Document. Caller not cleared for delegation")) {
            return "Echec de l'authentification, veuillez vérifier le code PIN";
        } else if (result1.contains("Could not sign specified Document. Could not activate signature key !!!")) {
            return "Echec de l'authentification, veuillez vérifier le code PIN";
        } else if (result1.contains("it should be a userID")) {
            return "Echec de l'authentification, vous n'avez pas d'informations de signature enregistrées";
        } else if (result1.contains("Wrong 'inDelegationOf'")) {
            return "Echec de l'authentification, votre delegation n'est pas reconnue par le service, veuillez contacter le support technique";
        } else if (result1.contains("invalid activation data")) {
            return "Echec de l'authentification, votre clé de signature n'est pas reconnue par le service, veuillez contacter le support technique";
        } else {
            return "Erreur non specifiée, veuillez contacter le support technique";
        }

    }


    public static String signerDocumentPdfQRCodeFromExcel(String nomFichier,Depot depot, Utilisateur utilisateur,String UPLOADED_FOLDER,String lienQrCode, String codePin,String nomFichierSigne, String URL_SIGNATURE,String NEWNAME) throws Exception {


        String url = URL_SIGNATURE;

        String payload1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:btr=\"http://btrust360.com/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + "      <btr:Signing>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:delegationID>" + utilisateur.getDelagation() + "</btr:delegationID>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:signatureKeyId>" + utilisateur.getSignatureKeyId() + "</btr:signatureKeyId>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:codeSecretUtilisateur>" + codePin + "</btr:codeSecretUtilisateur>\n"
                + "         <!--Optional:-->\n"
                + "         <btr:binaryData>";

        String payload2 = "";
        try {

            //	String nomFichierASigne= SignatureWebServiceRequester.genererDocumentPdfQRCodeFromExcel(nomFichier,depot, utilisateur, UPLOADED_FOLDER, lienQrCode);
            //String nomFichierASigne="attestation-Signer02.pdf";
            //String nomFichierASigne="098765544__EtafiEnPDF_2012.pdf";
            //String nomFichierASigne="MergeFile_1234_new_1617639988931.pdf";
            String nomFichierASigne = ExcelToPDF.generateurPDFFromExcel(nomFichier,
                    UPLOADED_FOLDER, depot, utilisateur, lienQrCode,nomFichierSigne);

            nomFichierSigne=nomFichierASigne;


            payload2 = PDFGenerator.Pdf2Base64(UPLOADED_FOLDER, nomFichierASigne, NEWNAME);
            //;PDFGenerator.Pdf2Base64("D:\\PDF\\","test1.pdf","testout2.pdf");

            return "success";

        } catch (IOException ex) {
            Logger.getLogger(SignatureWebServiceRequester.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }

//        String payload3 = "</btr:binaryData>"
//                + "       </btr:Signing>\n"
//                + "   </soapenv:Body>\n"
//                + "</soapenv:Envelope>";
//
//        String time = Long.toString(new Date().getTime());
//        String payload = payload1 + payload2 + payload3;
//        String result1 = envoyerPayload(payload, url, nomFichierSigne,UPLOADED_FOLDER);
////        System.out.println("result " + result1);
//
//        if (result1.contains("MSIGN_SRV_STATUS_SUCCESS")) {
//            return "success";
//        } else if (result1.contains("Could not sign specified Document. Caller not cleared for delegation")) {
//            return "Echec de l'authentification, veuillez vérifier le code PIN";
//        } else if (result1.contains("Could not sign specified Document. Could not activate signature key !!!")) {
//            return "Echec de l'authentification, veuillez vérifier le code PIN";
//        } else if (result1.contains("it should be a userID")) {
//            return "Echec de l'authentification, vous n'avez pas d'informations de signature enregistrées";
//        } else if (result1.contains("Wrong 'inDelegationOf'")) {
//            return "Echec de l'authentification, votre delegation n'est pas reconnue par le service, veuillez contacter le support technique";
//        } else if (result1.contains("invalid activation data")) {
//            return "Echec de l'authentification, votre clé de signature n'est pas reconnue par le service, veuillez contacter le support technique";
//        } else {
//            return "Erreur non specifiée, veuillez contacter le support technique";
//        }

    }




    public static String genererDocumentPdfQRCodeFromExcel(String nomFichier,Depot depot, Utilisateur utilisateur,String UPLOADED_FOLDER,String lienQrCode) throws Exception {

        SimpleDateFormat dateActuelleFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateActuelle = dateActuelleFormat.format(new Date());

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        String ninea = depot.getContribuable().getNinea();
        String annee = depot.getAnneeExcercice();

        String libelle = null;

        String time = Long.toString(new Date().getTime());
        libelle = ninea+"_"+ "_EtafiEnPDF_" + annee+"_"+time+".pdf";


        String texteQrCode = generateTextQrCode(depot,utilisateur,lienQrCode);

        //Debut generation pdf EF
        String nomFichierSansExtension = "";
        try {
            String[] part = nomFichier.split("\\.");
            nomFichierSansExtension = part[0];
        } catch (Exception ex) {
            nomFichierSansExtension = "xxxxx";
        }


        String path_modele = UPLOADED_FOLDER + nomFichier;

        //String time = Long.toString(new Date().getTime());

        String path_qr_code = UPLOADED_FOLDER + nomFichierSansExtension + "_" + time + "qrcode.png";


        ExcelToPDFUtils.convertExcelToPDFWithQRCODE(path_modele,UPLOADED_FOLDER,libelle, texteQrCode, path_qr_code);


        return libelle ;
    }



    public static String envoyerPayload(String payload, String url, String nomFichierSigne,String FILEPATH) {
        String result = "";
        String responseCode = "-1";
        String responsePayload = "-1";
        int creationPdf = -1;
        String sw;

        try {
            sw = payload;
            //System.out.println("payload: "+payload);
            // result = HttpRequester2.SendRequest(url, sw);

            result = HttpRequester2.SendRequest(url, sw);
            //System.out.println("le resultat: "+result);
            Document document = null;
            DocumentBuilderFactory factory = null;
            DocumentBuilder builder = null;

            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();

            if (result != null) {
                InputSource source = new InputSource(new StringReader(result));
                //System.out.println("reponse: "+source);
                document = builder.parse(source);

                NodeList statusNode = document.getElementsByTagName("returnStatus");

                responseCode = statusNode.item(0).getTextContent();

                if (responseCode.equals("MSIGN_SRV_STATUS_SUCCESS")) {
                    NodeList contenuNode = document.getElementsByTagName("contenuSigne");
                    responsePayload = contenuNode.item(0).getTextContent();
                    creationPdf = PDFGenerator.base64ToPdf(FILEPATH + nomFichierSigne, responsePayload);
                } else {
                    NodeList errorNode = document.getElementsByTagName("errorInfo");
                    responseCode = errorNode.item(0).getTextContent();
                }

                //System.out.println("response code: "+responseCode);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SignatureWebServiceRequester.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("erreur builder: "+ex);
        } catch (SAXException ex) {
            Logger.getLogger(SignatureWebServiceRequester.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("erreur SAX: "+ex);
        } catch (IOException ex) {
            Logger.getLogger(SignatureWebServiceRequester.class.getName()).log(Level.SEVERE, null, ex);
        }

        return responseCode;
    }


    private static String generateTextQrCode(Depot depot,Utilisateur utilisateur,String lienQrCode) {
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


        try {


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
            int choixSignature=1;
            //String typeMission="EC";
            String typeMission="CAC";
            //PDFGenerator.createPdfCAC(demande, nbrPage, cheminFichier, utilisateur, choixSignature);
            // PDFGenerator.createPdfEC(demande, nbrPage, cheminFichier, utilisateur, choixSignature);
            String time = Long.toString(new Date().getTime());
            String nomFichierSigne="attestation_Signer_"+time+".pdf";
            String codePin="password";




            System.out.println("Debut de la Génération Attestation ");
            //Attestation
//    	  SignatureWebServiceRequester.signerDocumentAttestation(demande, nomFichierSigne,
//    			 cheminFichier,nbrPage,
//    			 utilisateur, codePin, typeMission,choixSignature);

            System.out.println("FIn de la Génération Attestion ");



            System.out.println("Debut de la Génération PDF ");

            String  nomFichier="modele_etats_financiers_DGID (Nouveau) Test.xlsx";
            String lienQrCode="http://localhost:4200/#/main/ajout-agent";
            String fileNamePDF = "EtafiEnPDF_Signer_"+time+".pdf";

            //Generer PDF
            //SignatureWebServiceRequester.signerDocumentPdfQRCodeFromExcel(nomFichier,demande, utilisateur, cheminFichier, lienQrCode,codePin,fileNamePDF);

            System.out.println("FIn de la Génération PDF ");


        } catch (Exception ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}

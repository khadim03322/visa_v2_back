package sn.gainde2000.orbuslink.visa.ef;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javassist.bytecode.stackmap.BasicBlock.Catch;



public class MccExcelReport {

	

	
	
    public static Report verifyExcelSystemeNormal(String filePath, String fileName, String rapportFileName,String formJuridique) {
        Report report = null;
        String designationValue = "";
        String adresseValue = "";
        String numIdentificationValue = "";
        String sigleValue = "";
        String exerciceValue = "";

        String totalBilan = "";//Bilan paysage : F31
        String capitalPropre = "";//Bilan paysage : K13
        String resultatNet = "";//Compte resultat : E43
        String chiffreAffaire = "";//Compte resultat : E9
        
        int nombrePageExcel=0;
        double total=0;
         
       List<String> nomDesOnglet = new ArrayList<>();
       nomDesOnglet.add("Page de garde");
       nomDesOnglet.add("Fiche de renseignement R1");
       nomDesOnglet.add("Activités de l'entreprise R2");
       nomDesOnglet.add("Dirigeants R3");
       nomDesOnglet.add("Tableau des Notes R4");
       nomDesOnglet.add("BILAN PAYSAGE");
       nomDesOnglet.add("COMPTE DE RESULTAT");
       nomDesOnglet.add("FLUX DE TRESORERIE");
       nomDesOnglet.add("Note 1");
       nomDesOnglet.add("Note 2");
       nomDesOnglet.add("Note 3A");
       nomDesOnglet.add("Note 3B");
       nomDesOnglet.add("Note 3C");
       nomDesOnglet.add("Note 3C Bis");
       nomDesOnglet.add("Note 3D");
       nomDesOnglet.add("Note 3E");
       nomDesOnglet.add("Note 4");
       nomDesOnglet.add("Note 5");
       nomDesOnglet.add("Note 6");
       nomDesOnglet.add("Note 7");
       nomDesOnglet.add("Note 8");
       nomDesOnglet.add("Note 8A");
       nomDesOnglet.add("Note 8B");
       nomDesOnglet.add("Note 8C");
       
       nomDesOnglet.add("Note 9");
       nomDesOnglet.add("Note 10");
       nomDesOnglet.add("Note 11");
       nomDesOnglet.add("Note 12");
       nomDesOnglet.add("Note 13");
       nomDesOnglet.add("Note 14");
       nomDesOnglet.add("Note 15A");
       nomDesOnglet.add("Note 15B");
       nomDesOnglet.add("Note 16A");
       nomDesOnglet.add("Note 16B");
       nomDesOnglet.add("Note 16B bis");
       nomDesOnglet.add("Note 16C");
       nomDesOnglet.add("Note 17");
       nomDesOnglet.add("Note 18");
       nomDesOnglet.add("Note 19");
       nomDesOnglet.add("Note 20");
       nomDesOnglet.add("Note 21");
       nomDesOnglet.add("Note 22");
       nomDesOnglet.add("Note 23");
       nomDesOnglet.add("Note 24");
       nomDesOnglet.add("Note 25");
       nomDesOnglet.add("Note 26");
       nomDesOnglet.add("Note 27A");
       nomDesOnglet.add("Note 27B");
       nomDesOnglet.add("Note 28");
       nomDesOnglet.add("Note 29");
       nomDesOnglet.add("Note 30");
       nomDesOnglet.add("Note 31");
       nomDesOnglet.add("Note 32");
       nomDesOnglet.add("Note 33");
       nomDesOnglet.add("Note 34");
       nomDesOnglet.add("Note 35");
       nomDesOnglet.add("Note 36");
       nomDesOnglet.add("Codes activités");
       
       
       List<String> referrenceBilan1 = new ArrayList<>();
      
       referrenceBilan1.add("REF");
       referrenceBilan1.add("REF");
       referrenceBilan1.add("AD");
       referrenceBilan1.add("AE");
       referrenceBilan1.add("AF");
       referrenceBilan1.add("AG");
       referrenceBilan1.add("AH");
       referrenceBilan1.add("AI");
       referrenceBilan1.add("AJ");
       referrenceBilan1.add("AK");
       referrenceBilan1.add("AL");
       referrenceBilan1.add("AM");
       referrenceBilan1.add("AN");
       referrenceBilan1.add("AP");
       referrenceBilan1.add("AQ");
       referrenceBilan1.add("AR");
       referrenceBilan1.add("AS");
       referrenceBilan1.add("AZ");
       referrenceBilan1.add("BA");
       referrenceBilan1.add("BB");
       referrenceBilan1.add("BG");
       referrenceBilan1.add("BH");
       referrenceBilan1.add("BI");
       referrenceBilan1.add("BJ");
       referrenceBilan1.add("BK");
       referrenceBilan1.add("BQ");
       referrenceBilan1.add("BR");
       referrenceBilan1.add("BS");
       referrenceBilan1.add("BT");
       referrenceBilan1.add("BU");
       referrenceBilan1.add("BZ");
       
       List<String> referrenceBilan2 = new ArrayList<>();
       referrenceBilan2.add("REF");
       referrenceBilan2.add("REF");
       referrenceBilan2.add("CA");
       referrenceBilan2.add("CB");
       referrenceBilan2.add("CD");
       referrenceBilan2.add("CE");
       referrenceBilan2.add("CF");
       referrenceBilan2.add("CG");
       referrenceBilan2.add("CH");
       referrenceBilan2.add("CJ");
       referrenceBilan2.add("CL");
       referrenceBilan2.add("CM");
       referrenceBilan2.add("CP");
       referrenceBilan2.add("DA");
       referrenceBilan2.add("DB");
       referrenceBilan2.add("DC");
       referrenceBilan2.add("DD");
       referrenceBilan2.add("DF");
       referrenceBilan2.add("DH");
       referrenceBilan2.add("DI");
       referrenceBilan2.add("DJ");
       referrenceBilan2.add("DK");
       referrenceBilan2.add("DM");
       referrenceBilan2.add("DN");
       referrenceBilan2.add("DP");
       referrenceBilan2.add("");
       referrenceBilan2.add("DQ");
       referrenceBilan2.add("DR");
       referrenceBilan2.add("DT");
       referrenceBilan2.add("DV");
       referrenceBilan2.add("DZ");
      
       
       List<String> referrenceComptat1 = new ArrayList<>();
       referrenceComptat1.add("REF");
       referrenceComptat1.add("TA");
       referrenceComptat1.add("RA");
       referrenceComptat1.add("RB");
       referrenceComptat1.add("XA");
       referrenceComptat1.add("TB");
       referrenceComptat1.add("TC");
       referrenceComptat1.add("TD");
       referrenceComptat1.add("XB");
       referrenceComptat1.add("TE");
       referrenceComptat1.add("TF");
       referrenceComptat1.add("TG");
       referrenceComptat1.add("TH");
       referrenceComptat1.add("TI");
       referrenceComptat1.add("RC");
       referrenceComptat1.add("RD");
       referrenceComptat1.add("RE");
       referrenceComptat1.add("RF");
       referrenceComptat1.add("RG");
       referrenceComptat1.add("RH");
       referrenceComptat1.add("RI");
       referrenceComptat1.add("RJ");
       referrenceComptat1.add("XC");
       referrenceComptat1.add("RK");
       referrenceComptat1.add("XD");
       referrenceComptat1.add("TJ");
       referrenceComptat1.add("RL");
       referrenceComptat1.add("XE");
       referrenceComptat1.add("TK");
       referrenceComptat1.add("TL");
       referrenceComptat1.add("TM");
       referrenceComptat1.add("RM");
       referrenceComptat1.add("RN");
       referrenceComptat1.add("XF");
       referrenceComptat1.add("XG");
       referrenceComptat1.add("TN");
       referrenceComptat1.add("TO");
       referrenceComptat1.add("RO");
       referrenceComptat1.add("RP");
       referrenceComptat1.add("XH");
       referrenceComptat1.add("RQ");
       referrenceComptat1.add("RS");
       referrenceComptat1.add("XI");
       
       List<String> referrenceTresorerie1 = new ArrayList<>();
       referrenceTresorerie1.add("REF");
       referrenceTresorerie1.add("ZA");
       referrenceTresorerie1.add("");
       referrenceTresorerie1.add("FA");
       referrenceTresorerie1.add("FB");
       referrenceTresorerie1.add("FC");
       referrenceTresorerie1.add("FD");
       referrenceTresorerie1.add("FE");
       referrenceTresorerie1.add("");
       referrenceTresorerie1.add("ZB");
       referrenceTresorerie1.add("");
       referrenceTresorerie1.add("FF");
       referrenceTresorerie1.add("FG");
       referrenceTresorerie1.add("FH");
       referrenceTresorerie1.add("FI");
       referrenceTresorerie1.add("FJ");
       referrenceTresorerie1.add("ZC");
       referrenceTresorerie1.add("");
       referrenceTresorerie1.add("FK");
       referrenceTresorerie1.add("FL");
       referrenceTresorerie1.add("FM");
       referrenceTresorerie1.add("FN");
       referrenceTresorerie1.add("ZD");
       referrenceTresorerie1.add("");
       referrenceTresorerie1.add("FO");
       referrenceTresorerie1.add("FP");
       referrenceTresorerie1.add("FQ");
       referrenceTresorerie1.add("ZE");
       referrenceTresorerie1.add("ZF");
       referrenceTresorerie1.add("ZG");
       referrenceTresorerie1.add("ZH");
      
       
       //Note 13
       
       
     
        //1111111111111111111111111111111111111111111111111111111111111111111111
        System.out.println("======> Debut verification excel  systeme normal");
        String fileLocation = filePath + fileName;
        FileInputStream excelFile = null;

        try {
            excelFile = new FileInputStream(new File(fileLocation));

            Workbook workbook = new XSSFWorkbook(excelFile);
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            //Workbook workbook = com.monitorjbl.xlsx.StreamingReader.StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(excelFile));

            System.out.println("--> Nombre de page du document = [" + workbook.getNumberOfSheets() + "]");

            CellReference cellReference;
            Row rowCase;
            Cell cellCase;
            CellValue cellValue;
            
            CellReference cellReference2;
            Row rowCase2;
            Cell cellCase2;
            CellValue cellValue2;


            report = new Report();
            
            nombrePageExcel=workbook.getNumberOfSheets();

            //11111111
            PageGardeReport pageGardeReport = null;
            FicheRenseignementReport ficheRenseignementReport = null;
            ActiviteEntrepriseReport activiteEntrepriseReport = null;
            DirigeantsReport dirigeantsReport = null;
            BalanceReport balanceReport = null;
            BilanReport bilanReport = null;
            CompteResultatReport compteResultatReport = null;
            FluxTresorerieReport fluxTresorerieReport = null;
            Note13 note13 = null;
            //22222222
            report.errorFormatExist=false;
            
            
            if(nombrePageExcel < 58) {
            	
            	report.observationFormat.add("Des feuilles/rubriques ont été supprimées");
            	report.errorFormatExist=true;
            	report.errorExist=true;
            	
              /* for(int i=nombrePageExcel;i<55;i++) {
         
            	report.listfeuillesManquantes.add(nomDesOnglet.get(i));
            	
            }*/
            	
            	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été supprimées");
              
            }
            
            else
            	
                if(nombrePageExcel > 58)   //le nombre de ligne du fichier Excel
                {
                	report.observationFormat.add("Des feuilles/rubriques ont été ajoutées");
                	report.errorFormatExist=true;
                	report.errorExist=true;
                	
                	
                	/*for(int i=0;i<58;i++) {
               		 
               		 Sheet datatypeSheet02 = workbook.getSheetAt(i);   
               		 
               	  System.out.println("--> Onglet"+i+" [" + datatypeSheet02.getSheetName() + "]");
                    
                 
                    	
                    }*/
                	
                	
                	
                	/*for(int i=(nombrePageExcel-1);i>=55;i--) {
                        
                		Sheet datatypeSheet01 = workbook.getSheetAt(i);
                    	report.listfeuillesManquantes.add(datatypeSheet01.getSheetName());
                    	
                    }*/
                	
                	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été ajoutées");
                	
                	
                	report.errorExist=true;
                }
            
            else
            	
                  //le nombre de ligne du fichier Excel   if(nombrePageExcel==55)   
            {
            	
            	
            	
            	//controle des nms des onglets
            	
            	
            
            	
            	
            	 for(int i=0;i<58;i++) {
            		 
            		 Sheet datatypeSheet02 = workbook.getSheetAt(i);   
            		 
            		 
             // System.out.println("--> Onglet "+i+" [" + datatypeSheet02.getSheetName() + "]");
            		 
            		 if(!datatypeSheet02.getSheetName().equalsIgnoreCase(nomDesOnglet.get(i))) {
            		 
                 	report.listongletsnomsModifies.add(datatypeSheet02.getSheetName());
                 	
                 	report.errorMaplistongletsnomsModifies.put(datatypeSheet02.getSheetName(), "Le mon de la feuille a éte modifié. L'appellation conforme est :"+nomDesOnglet.get(i));
                 	
            		 }
                 	
                 }
            	
       
            	 if(report.listongletsnomsModifies.size()>0) 
            	 {
            		
            		 
                 report.errorFormatExist=true;
            		 
            	report.observationFormat.add("Les noms de certaines rubriques ont été changés");
            	   
            	report.errorExist=true;
            		 
            		 
            	 }else {
            	
            		 

            	//Fin controle des noms onglets
            		 
            
            	
            //*** Debut verification page de garde
            	
            	
            	
            Sheet datatypeSheet = workbook.getSheetAt(0);
            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

             	
            
            //Centre de dépôt
            cellReference = new CellReference("B15");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);

            //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setCentreDepotObservation("Information non renseignée");
               
                pageGardeReport.setCentreDepotCellule("B15");
                pageGardeReport.setCentreDepotIsCorrect(false);
            } else {
                try {
                    if ((cellCase.getStringCellValue().split(":")[1] != null) && (!cellCase.getStringCellValue().split(":")[1].trim().equalsIgnoreCase(""))) {
                    } else {
                        if (pageGardeReport == null) {
                            pageGardeReport = new PageGardeReport();
                            report.setErrorExist(true);
                        }
                        pageGardeReport.setCentreDepotObservation("Information non renseignée");
                       
                        pageGardeReport.setCentreDepotCellule("B15");
                        pageGardeReport.setCentreDepotIsCorrect(false);
                    }
                } catch (Exception ie) {
                    if (pageGardeReport == null) {
                        pageGardeReport = new PageGardeReport();
                        report.setErrorExist(true);
                    }
                    pageGardeReport.setCentreDepotObservation("Information non renseignée");
                   
                    pageGardeReport.setCentreDepotCellule("B15");
                    pageGardeReport.setCentreDepotIsCorrect(false);
                }
            }

            //Exercice clos
            cellReference = new CellReference("M25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            //System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");

            if(cellValue==null) {
            
            	 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setExerciceClosObservation("Information non renseignée");
                
                 pageGardeReport.setExerciceClosCellule("M25");
                 pageGardeReport.setExerciceClosIsCorrect(false);
            	
            	
            }
            else
                if (cellValue.getCellType() == CellType.STRING || cellValue.getCellType() == CellType.NUMERIC) {

                	 try {
                         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                         DataFormatter dataFormatter = new DataFormatter();
                         
                         Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                        
                         date.getTime();
                         
                         
                         exerciceValue = dataFormatter.formatCellValue(cellCase);
                         
                     } catch (Exception e) {
                         e.printStackTrace();
                        
                         if (pageGardeReport == null) {
                             pageGardeReport = new PageGardeReport();
                             report.setErrorExist(true);
                         }
                         pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                        
                         pageGardeReport.setExerciceClosCellule("M25");
                         pageGardeReport.setExerciceClosIsCorrect(false);
                         
                     }
                	
                }
            /*else
            if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {

                //gestion avancee de la date
            	 
            	System.out.println("Date  2-------------------------->");
            	
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                    DataFormatter dataFormatter = new DataFormatter();
                    
                    Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                   
                    date.getTime();
                } catch (Exception e) {
                    e.printStackTrace();
                    
                    
                }
                
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
               
                pageGardeReport.setExerciceClosCellule("M25");
                pageGardeReport.setExerciceClosIsCorrect(false);
                
                
            } */
            
            else {
                DataFormatter df = new DataFormatter();
                exerciceValue = df.formatCellValue(cellCase);
            }
            
            

            //Denomination sociale
            cellReference = new CellReference("L33");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            //System.out.println("[ligne L33 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            
            
            
            
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setDenominationSocialeObservation("Information non renseignée");
              
                pageGardeReport.setDenominationSocialeCellule("L33");
                pageGardeReport.setDenominationSocialeIsCorrect(false);
                
            } else {
                designationValue = cellCase.getStringCellValue();
            }

            //Adresse
            cellReference = new CellReference("J44");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setAdresseObservation("Information non renseignée");
                
                pageGardeReport.setAdresseCellule("J44");
                pageGardeReport.setAdresseIsCorrect(false);
            } else {
                adresseValue = cellCase.getStringCellValue();
            }

            //Identification fiscal
            cellReference = new CellReference("N49");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne N49 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());

            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setIdFiscaleObservation("Information non renseignée");
                
                pageGardeReport.setIdFiscaleCellule("N49");
                //pageGardeReport.setCelluleFiscale("N49");
                pageGardeReport.setIdFiscaleIsCorrect(false);
                
            } else {
                numIdentificationValue = cellCase.getStringCellValue();
            }

            //Recuperation sigleValue header
            cellReference = new CellReference("H39");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne H39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() == CellType.STRING) {
                sigleValue = cellCase.getStringCellValue();
            }

////            //Recuperation exerciceValue header
////            cellReference = new CellReference("B25");
////            rowCase = datatypeSheet.getRow(cellReference.getRow());
////            cellCase = rowCase.getCell(cellReference.getCol());
////            System.out.println("[ligne B25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
////            if (cellCase.getCellType() == CellType.STRING) {
////                exerciceValue = cellCase.getStringCellValue();
////            }

            if (pageGardeReport != null) {
                report.setPageGardeReport(pageGardeReport);
            }
            
            
            
            
            //*** Fin verification page de garde

            //*** Debut verification fiche renseignement
            datatypeSheet = workbook.getSheetAt(1);
            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

            /* ??
            //Centre de dépôt
            cellReference = new CellReference("B15");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            System.out.println(cellCase.getStringCellValue());
            if (cellCase.getCellType() != CellType.STRING) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setCentreDepotObservation("Information non renseignée");
                ficheRenseignementReport.setCentreDepotIsCorrect(false);
            }
            */

            //Exercice clos
            try {
                cellReference = new CellReference("V9");
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                System.out.println("[ligne V9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                //System.out.println(cellCase.getCachedFormulaResultType());
                cellValue = evaluator.evaluate(cellCase);
                System.out.println(cellValue.getCellType());
               
                
                if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                    if (ficheRenseignementReport == null) {
                        ficheRenseignementReport = new FicheRenseignementReport();
                        report.setErrorExist(true);
                    }
                    ficheRenseignementReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                    
                    ficheRenseignementReport.setExerciceClosCellule("V9");
                    ficheRenseignementReport.setExerciceClosIsCorrect(false);
                }
            } catch (Exception ie) {// driver not found
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceClosObservation("Information non renseignée");
                
                ficheRenseignementReport.setExerciceClosCellule("V9");
                ficheRenseignementReport.setExerciceClosIsCorrect(false);
            }

            /*??
            //Denomination sociale
            cellReference = new CellReference("B15");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            System.out.println(cellCase.getStringCellValue());
            if (cellCase.getCellType() != CellType.STRING) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDenominationSocialeObservation("Information non renseignée");
                ficheRenseignementReport.setDenominationSocialeIsCorrect(false);
            }
            */

            //Adress
            
            cellReference = new CellReference("J6");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne J6 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
          //  System.out.println(cellCase.getStringCellValue());
            cellValue = evaluator.evaluate(cellCase);
            //System.out.println(cellValue.getCellType());
            
            if ( cellValue ==null || (cellValue.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setAdresseObservation("Information non renseignée");
                
                ficheRenseignementReport.setAdresseCellule("J6");
                ficheRenseignementReport.setAdresseIsCorrect(false);
            }
            
            

            //Id fiscal
            try {
                cellReference = new CellReference("J9");
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                System.out.println("[ligne J9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                //if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
                if (cellCase.getCellType() == CellType.BLANK) {
                    if (ficheRenseignementReport == null) {
                        ficheRenseignementReport = new FicheRenseignementReport();
                        report.setErrorExist(true);
                    }
                    ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée");
                    
                    ficheRenseignementReport.setIdFiscaleCellule("J6");
                    ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                }
            } catch (Exception ie) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setIdFiscaleObservation("Format incorrect de l'information renseignée");
                
                ficheRenseignementReport.setIdFiscaleCellule("J6");
                ficheRenseignementReport.setIdFiscaleIsCorrect(false);
            }

            //Exerice comptable debut
            cellReference = new CellReference("Y12");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne Y12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            cellValue = evaluator.evaluate(cellCase);
            
            if (cellValue==null  || (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING))) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée / Format incorrect de l'information renseignée");
               
                ficheRenseignementReport.setExerciceComptableCellule("Y12");
                ficheRenseignementReport.setExerciceComptableIsCorrect(false);
            }
            

            //Exerice comptable fin
            cellReference = new CellReference("AH12");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
           // System.out.println(cellValue.getCellType());
            if (cellValue==null || (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING))) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée / Format incorrect de l'information renseignée");
               
                ficheRenseignementReport.setExerciceComptableCellule("AH12");
                ficheRenseignementReport.setExerciceComptableIsCorrect(false);
            }

            //Date arret compte
            try {
                cellReference = new CellReference("U15");
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                System.out.println("[ligne U15 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                //System.out.println(cellCase.getCachedFormulaResultType());
                cellValue = evaluator.evaluate(cellCase);
                System.out.println(cellValue.getCellType());
                if (cellValue==null ||(!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING))) {
                    if (ficheRenseignementReport == null) {
                        ficheRenseignementReport = new FicheRenseignementReport();
                        report.setErrorExist(true);
                    }
                    ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée /Format incorrect de l'information renseignée");
                    
                    ficheRenseignementReport.setDateArreteComptesCellule("U15");
                    ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                }
            } catch (Exception ie) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée");
                
                ficheRenseignementReport.setDateArreteComptesCellule("U15");
                ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
            }

            //Greffe
            cellReference = new CellReference("F23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne F23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
//            if (cellCase.getCellType() != CellType.STRING) {
//                if (ficheRenseignementReport == null) {
//                    ficheRenseignementReport = new FicheRenseignementReport();
//                    report.setErrorExist(true);
//                }
//                ficheRenseignementReport.setGreffeObservation("Information non renseignée");
//                ficheRenseignementReport.setGreffeIsCorrect(false);
//            }

            //Num registre commerce
            cellReference = new CellReference("I23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne I23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setNumRegistreCommerceObservation("Information non renseignée");
               
                ficheRenseignementReport.setNumRegistreCommerceCellule("I23");
                ficheRenseignementReport.setNumRegistreCommerceIsCorrect(false);
            }

            //Num Securite Sociale
            cellReference = new CellReference("G27");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//            if (cellCase.getCellType() == CellType.BLANK) {
//                if (ficheRenseignementReport == null) {
//                    ficheRenseignementReport = new FicheRenseignementReport();
//                    report.setErrorExist(true);
//                }
//                ficheRenseignementReport.setNumSecuriteSocialeObservation("Information non renseignée");
//                ficheRenseignementReport.setNumSecuriteSocialeIsCorrect(false);
//            }

            //Designation Entreprise
            //1
            cellReference = new CellReference("J3");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne J3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() == CellType.BLANK) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
               
                ficheRenseignementReport.setDesignationEntrepriseCellule("J3");
                ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
                
            }
            //2
            cellReference = new CellReference("D31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne D31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() == CellType.BLANK) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
                
                ficheRenseignementReport.setDesignationEntrepriseCellule("D31");
                ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
            }

            //Telephone
            cellReference = new CellReference("G35");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if ((cellCase.getCellType() != CellType.STRING) && (cellCase.getCellType() != CellType.NUMERIC)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setNumTelephoneObservation("Information non renseignée");
               
                ficheRenseignementReport.setNumTelephoneCellule("G35");
                ficheRenseignementReport.setNumTelephoneIsCorrect(false);
            }

            //Ville
            cellReference = new CellReference("AE35");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne AE35 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setVilleObservation("Information non renseignée");
               
                ficheRenseignementReport.setVilleCellule("AE35");
                ficheRenseignementReport.setVilleIsCorrect(false);
            }

            //Adresse Geographique
            cellReference = new CellReference("D39");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne D39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase.getCellType() == CellType.BLANK) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setAdresseGeographiqueObservation("Information non renseignée");
               
                ficheRenseignementReport.setAdresseGeographiqueCellule("D39");
                ficheRenseignementReport.setAdresseGeographiqueIsCorrect(false);
            }

            //Designation Activite Exercee
            cellReference = new CellReference("D43");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            //System.out.println("[ligne D43 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDesignationActiviteExerceeObservation("Information non renseignée");
                
                ficheRenseignementReport.setDesignationActiviteExerceeCellule("D43");
                ficheRenseignementReport.setDesignationActiviteExerceeIsCorrect(false);
            }

            //Personne A Contacter
            cellReference = new CellReference("D47");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne D47 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setPersonneAContacterObservation("Information non renseignée");
               
                ficheRenseignementReport.setPersonneAContacterCellule("D47");
                ficheRenseignementReport.setPersonneAContacterIsCorrect(false);
            }

            //Professionnel Ou Cabinet Comptable AuteurEF
            cellReference = new CellReference("D51");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFObservation("Information non renseignée");
              
                ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFCellule("D51");
                ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFIsCorrect(false);
            }

            //Commissaire Au Compte
            cellReference = new CellReference("D55");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
//            if (cellCase.getCellType() != CellType.STRING) {
//                if (ficheRenseignementReport == null) {
//                    ficheRenseignementReport = new FicheRenseignementReport();
//                    report.setErrorExist(true);
//                }
//                ficheRenseignementReport.setCommissaireAuCompteObservation("Information non renseignée");
//                ficheRenseignementReport.setCommissaireAuCompteIsCorrect(false);
//            }

            //Qualite du Signataire
            cellReference = new CellReference("D71");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null ||(cellCase.getCellType() != CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setQualiteDuSignataireObservation("Information non renseignée");
               
                ficheRenseignementReport.setQualiteDuSignataireCellule("D71");
                ficheRenseignementReport.setQualiteDuSignataireIsCorrect(false);
                
            }

            //Date Signature
            cellReference = new CellReference("D74");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne D74 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase==null || (cellCase.getCellType() != CellType.NUMERIC)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDateSignatureObservation("Information non renseignée");
             
                ficheRenseignementReport.setDateSignatureCellule("D74");
                ficheRenseignementReport.setDateSignatureIsCorrect(false);
            }

            //Banque
            String [] cellulesBanques = {"T70", "T71", "T72"}  ; // tableau de cellules à verifier
            Boolean isEmptyName = true;
            for(int i=0; i<cellulesBanques.length; i++) {
                cellReference = new CellReference(cellulesBanques[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if (cellCase.getCellType() == CellType.STRING) {
                	isEmptyName = false ;
                    break;
                }
               }
            if(isEmptyName) {
            	
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                   report.setErrorExist(true);
               }
                /*ficheRenseignementReport.setBanqueObservation("Nom banque non renseignée");
                ficheRenseignementReport.setBanqueIsCorrect(false);*/
                
                ficheRenseignementReport.errorMap.put("Banque(s)", "Nom banque non renseignée");
                ficheRenseignementReport.errorCelluleMap.put("Banque(s)", "Cellule[T70-T71-T72]");
           		
                
                
                
            }
            //Numero
            String [] cellulesNumero = {"AD70", "AD71", "AD72"}  ; // tableau de cellules à verifier
            Boolean isEmptyNumero  = true ;
            for(int i=0; i<cellulesNumero.length; i++) {
                cellReference = new CellReference(cellulesNumero[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                //System.out.println(cellCase.getStringCellValue());

                if (cellCase.getCellType() == CellType.STRING) {
                	isEmptyNumero = false ;
                    break;
                }

            }
            if (isEmptyNumero) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                
                /*ficheRenseignementReport.setNumeroObservation("compte bancaire non renseignée");
                ficheRenseignementReport.setNumeroIsCorrect(false);*/
                
                ficheRenseignementReport.errorMap.put("Numéro(s)", "Compte bancaire non renseignée");
                ficheRenseignementReport.errorCelluleMap.put("Numéro(s)", "Cellule[AD70-AD71-AD72]");
                
            }
            
            //FIn  bank
            if (ficheRenseignementReport != null) {
                report.setFicheRenseignementReport(ficheRenseignementReport);
            }
            //*** Fin verification fiche renseignement

            //*** Debut activite entreprise
            datatypeSheet = workbook.getSheetAt(2);
            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

            //Exercice Clos
            try {
                cellReference = new CellReference("L5");
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                if (cellValue==null  || (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) ){
                    if (activiteEntrepriseReport == null) {
                        activiteEntrepriseReport = new ActiviteEntrepriseReport();
                        report.setErrorExist(true);
                    }
                    activiteEntrepriseReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                    
                    activiteEntrepriseReport.setExerciceClosCellule("L5");
                    activiteEntrepriseReport.setExerciceClosIsCorrect(false);
                }
            } catch (Exception ie) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
               
                activiteEntrepriseReport.setExerciceClosCellule("L5");
                activiteEntrepriseReport.setExerciceClosIsCorrect(false);
            }

            //Adresse
            try {
                cellReference = new CellReference("B3");
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                System.out.println("[ligne B3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                //System.out.println(cellCase.getStringCellValue());
                if (!evaluateStringCell(cellCase, evaluator)) {
                    if (activiteEntrepriseReport == null) {
                        activiteEntrepriseReport = new ActiviteEntrepriseReport();
                        report.setErrorExist(true);
                    }
                    activiteEntrepriseReport.setAdresseObservation("Information non renseignée");
                    
                    activiteEntrepriseReport.setAdresseCellule("B3");
                    activiteEntrepriseReport.setAdresseIsCorrect(false);
                }
            } catch (Exception ie) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setAdresseObservation("Information non renseignée");
                
                activiteEntrepriseReport.setAdresseCellule("B3");
                activiteEntrepriseReport.setAdresseIsCorrect(false);
            }

            //Id fiscal
            try {
                cellReference = new CellReference("B5");
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                System.out.println("[ligne B5 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if (cellCase.getCellType() == CellType.BLANK) {
                    if (activiteEntrepriseReport == null) {
                        activiteEntrepriseReport = new ActiviteEntrepriseReport();
                        report.setErrorExist(true);
                    }
                    activiteEntrepriseReport.setIdFiscaleObservation("Information non renseignée ");
                   
                    activiteEntrepriseReport.setIdFiscaleCellule("B5");
                    activiteEntrepriseReport.setIdFiscaleIsCorrect(false);
                }
            } catch (Exception ie) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setIdFiscaleObservation("Format incorrect de l'information renseignée");
              
                activiteEntrepriseReport.setIdFiscaleCellule("B5");
                activiteEntrepriseReport.setIdFiscaleIsCorrect(false);
            }

            //Designation Activite
//            String [] cellulesNumero = {"B28", "B28", "B28"}  ; // tableau de cellules à verifier
//            isEmpty  = true ;
//            for(int i=0; i<cellulesBanques.length; i++) {
            cellReference = new CellReference("B28");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            
            System.out.println("[--------------------------->ligne : B28 " +cellCase.getStringCellValue() );
           // System.out.println("[--------------------------->ligne : B28 " +cellCase.getStringCellValue() + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
           try {
            if (cellCase.getCellType() == CellType.BLANK) {
            	 if (activiteEntrepriseReport == null) {
                     activiteEntrepriseReport = new ActiviteEntrepriseReport();
                     report.setErrorExist(true);
                 }
                 activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
                
                 activiteEntrepriseReport.setDesignationActiviteCellule("B28");
                 activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
            }
        } catch (Exception ie) {
        	 if (activiteEntrepriseReport == null) {
                 activiteEntrepriseReport = new ActiviteEntrepriseReport();
                 report.setErrorExist(true);
             }
             activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
            
             activiteEntrepriseReport.setDesignationActiviteCellule("B28");
             activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
        }
            
            
          /* if(cellCase==null) 
           {
        	   
        	   if (activiteEntrepriseReport == null) {
                   activiteEntrepriseReport = new ActiviteEntrepriseReport();
                   report.setErrorExist(true);
               }
               activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
               activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
               activiteEntrepriseReport.setDesignationActiviteCellule("B28");
        	   
           }
          */
           
           /*else
            
            if (cellCase.getCellType() != CellType.STRING) {
            	
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
                activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
                activiteEntrepriseReport.setDesignationActiviteCellule("B28");
            }*/

            if (activiteEntrepriseReport != null) {
                report.setActiviteEntrepriseReport(activiteEntrepriseReport);
            }
            //*** Fin activite entreprise

            //*** Debut dirigeant
            datatypeSheet = workbook.getSheetAt(3);
            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

            //Adresse Complete
//            try{
//                String [] cellulesAdresses = {"E8", "E9", "E10"}  ; // tableau de cellules à verifier
//                isEmpty  = true ;
//                for (int i = 0; i < cellulesAdresses.length; i++) {
//                    cellReference = new CellReference(cellulesAdresses[i]);
//                    rowCase = datatypeSheet.getRow(cellReference.getRow());
//                    cellCase = rowCase.getCell(cellReference.getCol());
//                    cellValue = evaluator.evaluate(cellCase);
//                    System.out.println("[ligne E10 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//                    if (cellCase.getCellType() == CellType.STRING) {
//                        isEmpty = false ;
//
//                        break;
//                    }
//                }
//                if (isEmpty) {
//                    if (dirigeantsReport == null) {
//                        dirigeantsReport = new DirigeantsReport();
//                        report.setErrorExist(true);
//                    }
//                    dirigeantsReport.setAdresseCompleteObservation("Information non renseignée");
//                    dirigeantsReport.setAdresseCompleteIsCorrect(false);
//                }
//            } catch (Exception ie) {
//                if (dirigeantsReport == null) {
//                    dirigeantsReport = new DirigeantsReport();
//                    report.setErrorExist(true);
//                }
//                dirigeantsReport.setAdresseCompleteObservation("Information non renseignée");
//                dirigeantsReport.setAdresseCompleteIsCorrect(false);
//            }

            //IdFiscale
//            try {
//                cellReference = new CellReference("B3");
//                rowCase = datatypeSheet.getRow(cellReference.getRow());
//                cellCase = rowCase.getCell(cellReference.getCol());
//                cellValue = evaluator.evaluate(cellCase) ;
//                System.out.println("[ligne B3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
////                if (cellValue.getCellType() != CellType.NUMERIC) {
////                    if (dirigeantsReport == null) {
////                        dirigeantsReport = new DirigeantsReport();
////                        report.setErrorExist(true);
////                    }
////                    dirigeantsReport.setIdFiscaleObservation("Information non renseignée / Format incorrect");
////                    dirigeantsReport.setIdFiscaleIsCorrect(false);
////                }
//            } catch (Exception ie) {
//                if (dirigeantsReport == null) {
//                    dirigeantsReport = new DirigeantsReport();
//                    report.setErrorExist(true);
//                }
//                dirigeantsReport.setIdFiscaleObservation("Information non renseignée / Format incorrect");
//                dirigeantsReport.setIdFiscaleIsCorrect(false);
//            }

            //Nom
            String [] cellulesNoms = {"A8", "A9", "A10", "A11", "A12"}  ; // tableau de cellules à verifier
           boolean isEmptyNom  = true ;
            for(int i=0; i<cellulesNoms.length; i++) {
                cellReference = new CellReference(cellulesNoms[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ( cellCase.getCellType() == CellType.STRING) {
                	isEmptyNom = false ;
                    break;
                }
            }
            if (isEmptyNom) {
               if (dirigeantsReport == null) {
                    dirigeantsReport = new DirigeantsReport();
                    report.setErrorExist(true);
                }
               /* dirigeantsReport.setNomObservation("Information non renseignée");
                dirigeantsReport.setNomIsCorrect(false);*/
               
               dirigeantsReport.errorMap.put("Nom dirigeant", "Information non renseignée");
               dirigeantsReport.errorCelluleMap.put("Nom dirigeant", "[A8]");
               
            }
            //Prenom
            String [] cellulesPrenoms = {"B8", "B9", "B10","B11","B12"}  ; // tableau de cellules à verifier
            boolean  isEmptyPrenom  = true ;
            for(int i=0; i<cellulesPrenoms.length; i++) {
                cellReference = new CellReference(cellulesPrenoms[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if (cellCase.getCellType() == CellType.STRING) {
                	isEmptyPrenom = false ;
                    break;
                }
            }
            if (isEmptyPrenom) {
                if (dirigeantsReport == null) {
                    dirigeantsReport = new DirigeantsReport();
                    report.setErrorExist(true);
                }
                /*dirigeantsReport.setPrenomObservation("Information non renseignée");
                dirigeantsReport.setPrenomIsCorrect(false);*/
                
            dirigeantsReport.errorMap.put("Prénom dirigeant", "Information non renseignée");
            dirigeantsReport.errorCelluleMap.put("Prénom dirigeant", "[B8]");
               
            }

            //Qualite
            String [] cellulesQualite = {"C8", "C9", "C10","C11","C12"}  ; // tableau de cellules à verifier
            boolean isEmptyQualite  = true ;
            for(int i=0; i<cellulesQualite.length; i++) {
                cellReference = new CellReference(cellulesQualite[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);

                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if (cellCase.getCellType() == CellType.STRING) {
                	isEmptyQualite = false ;
                    break;
                }
            }
            if(isEmptyQualite)  {
                if (dirigeantsReport == null) {
                    dirigeantsReport = new DirigeantsReport();
                    report.setErrorExist(true);
                }
              /*  dirigeantsReport.setQualiteObservation("Information non renseignée");
                dirigeantsReport.setQualiteIsCorrect(false);*/
                
                dirigeantsReport.errorMap.put("Qualite dirigeant", "Information non renseignée");
                dirigeantsReport.errorCelluleMap.put("Qualite dirigeant", "[C8]");
            }
            /*
          //NumeroIF
            String [] cellulesNumeroIF = {"D8", "D9", "D10","D11","D12"}  ; // tableau de cellules à verifier
            boolean isEmptyNumeroIF  = true ;
            for(int i=0; i<cellulesQualite.length; i++) {
                cellReference = new CellReference(cellulesNumeroIF[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);

                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ((cellCase.getCellType() == CellType.NUMERIC) ||(cellCase.getCellType() == CellType.STRING) ) {
                	isEmptyNumeroIF = false ;
                    break;
                }
            }
            if(isEmptyNumeroIF)  {
                if (dirigeantsReport == null) {
                    dirigeantsReport = new DirigeantsReport();
                    report.setErrorExist(true);
                }
             
                
                dirigeantsReport.errorMap.put("N° d'identification", "Information non renseignée");
                dirigeantsReport.errorCelluleMap.put("N° d'identification", "[D8]");
            }
            
            */
            
            //Adresse
              String [] cellulesAdresse = {"E8", "E9", "E10","E11","E12","F8", "F9", "F10","F11","F12"}  ; // tableau de cellules à verifier
              boolean isEmptyAdresse  = true ;
              for(int i=0; i<cellulesQualite.length; i++) {
                  cellReference = new CellReference(cellulesAdresse[i]);
                  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);

                  System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                  if (cellCase.getCellType() == CellType.STRING) {
                	  isEmptyAdresse = false ;
                      break;
                  }
              }
              if(isEmptyAdresse)  {
                  if (dirigeantsReport == null) {
                      dirigeantsReport = new DirigeantsReport();
                      report.setErrorExist(true);
                  }
                /*  dirigeantsReport.setQualiteObservation("Information non renseignée");
                  dirigeantsReport.setQualiteIsCorrect(false);*/
                  
                  dirigeantsReport.errorMap.put("Adresse dirigeant", "Information non renseignée");
                  dirigeantsReport.errorCelluleMap.put("Adresse dirigeant", "[E8]");
              }
              
            
            
            //Adresse

            cellReference = new CellReference("B2");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            System.out.println("[ligne B2 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellValue.getCellType() == CellType.BLANK) {
                if (dirigeantsReport == null) {
                    dirigeantsReport = new DirigeantsReport();
                    report.setErrorExist(true);
                }
                dirigeantsReport.setAdresseObservation("Information non renseignée");
                dirigeantsReport.setAdresseIsCorrect(false);
            }

            if (dirigeantsReport != null) {
                report.setDirigeantsReport(dirigeantsReport);
            }
            //*** Fin dirigeant

            //*** Debut bilan
            datatypeSheet = workbook.getSheetAt(5);
            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
            
            

            //Fin Gestion du nombre de ligne
            
            
           int noOfColumns = datatypeSheet.getRow(0).getLastCellNum();
          // System.out.println("-------------------------------colonee>> = [" + noOfColumns + "]");
           
          //int nombrecolum =getLastCellWithData(datatypeSheet);
           
         boolean    nombreColonneOk=true;
           
         
         //exerciceValue
           cellReference = new CellReference("L1");
           rowCase = datatypeSheet.getRow(cellReference.getRow());
           cellCase = rowCase.getCell(cellReference.getCol());
           cellValue = evaluator.evaluate(cellCase);
           
                if(cellValue==null) {
                	 nombreColonneOk=false;
                	
                } else
              if (cellValue.getCellType() == CellType.BLANK) 
              {
            	  nombreColonneOk=false;
            }
              else
        	   if (cellValue.getCellType() == CellType.STRING) 
        	   {
        		   String cellVal1= cellValue.getStringValue();
        		   String cellVal2= exerciceValue;
        		  
        		//   System.out.print();
        		   
        		  /*System.out.print("cellValue.getStringValue()"+cellValue.getStringValue() +"----"+"Exercice au "+exerciceValue+ "compaison"
        	   +exerciceValue.substring(exerciceValue.length()-2, exerciceValue.length())+"--------"+ cellval.substring(cellval.length()-2, cellval.length()));
        		   */
        		   boolean testok=false;
        		   
        		   if(cellVal2.length()>0 && cellVal1.length()>0){
        		   
        		   try {
        			    String val1=cellVal1.substring(cellVal1.length()-2, cellVal1.length());
        			    int val2= Integer.parseInt(cellVal2.substring(cellVal2.length()-2, cellVal2.length()))-1;
        			   System.out.print("val1"+val1);
        			   System.out.print("val2"+val2);
        			   
        		  testok=val1.equals(String.valueOf(val2));
        		 
        		   }
        		   catch(Exception e) 
        		   {
        			   
        		   }
        		   
        		   }
        		   
        		   if(cellValue.getStringValue().equalsIgnoreCase("Exercice au 31/12/N-1")
        				
        				   || testok
        				   
        				   
        				   
        				   )
        		   {
        			   nombreColonneOk=true;
        			   
        		   }
        		   else
        		   {
        			   nombreColonneOk=false;
        		   }
        		   
        		   
        	   }else
        	   {
        		   nombreColonneOk=false;  
        		   
        	   }
        	   
        	   
      System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
          
          
           
            
        // System.out.println("-------------------------------tester>> = [" + noOfColumns + "]");
        
          if(!nombreColonneOk) 
          {
          	
        	  if (bilanReport == null) {
                  bilanReport = new BilanReport();
                  report.setErrorExist(true);
              }
        	  
            bilanReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
            bilanReport.errorCelluleMap.put("Nombre de colonne"," il ya une incohérence entre l'exercicle clos au nivdeau de la page et la date renseignée au niveau de la cellule L1");
          	
          } else {
            
            
            // Fin Gestion du nombre de ligne
            
            
            int j = getLastRowWithData(datatypeSheet);

            if (j != 30) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setNombreDeLigneIsCorrect(false);
            }else {
            
            
            
//            int[] counters = new int[4];
//            counters[0] = 0; // number of columns
//            counters[1] = 0; // number of rows in colA
//            counters[2] = 0; // number of rows in colB
//            counters[3] = 0; // number of rows in colC
//            datatypeSheet.
//            while(rowIterator.hasNext()) {
//                /*
//                 * keep track of columns. Useful if colD and more may exist too, but
//                 * you don't want them counted
//                 */
//                int col = 0;
//                while(cellIterator.hasNext()) {
//                    switch(col) {
//                        case 0 : counters[1]++; break; // add row to colA counter
//                        case 1 : counters[2]++; break; // add row to colB counter
//                        case 2 : counters[3]++; break; // add row to colC counter
//                    }
//                    col++;
//                }
//                counters[0] = col; // save number of columns
//            }
//

            //TotalActifImmobilise
            //1
            
            //gestion de la  verification des cellule (D3 - G31) 
            
            
              for (int index=3 ;index<=31;index++) 
              {
            	  
            	 // Debut cellule D
            	  
            	  cellReference = new CellReference("D"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                 // System.out.println("erreur de format[" +"D"+index+ "]  "+ cellValue  +"--");
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                  {
                	  
                	  System.out.println("erreur de format[" +"D"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
                	  
                	  String nomCellule="[" +"D"+index+ "]";
                	  
                	  cellReference = new CellReference("B"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  
                	  
                	  bilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  bilanReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
                	  
                	  
                  }
                  
               // Fin cellule D
                  
                  
                  
                // Debut cellule E
            	  
            	  cellReference = new CellReference("E"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                  {
                	  
                	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
                	  
                	  
                    String nomCellule="[" +"E"+index+ "]";
                	  
                	  cellReference = new CellReference("B"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  
                	  bilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  bilanReport.errorCelluleMap.put(nomCellule, "[" +"E"+index+ "]");
                	  
                	  
                  }
                  
                 // Fin cellule E
                  
                  
               // Debut cellule F
            	  
            	  cellReference = new CellReference("F"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                  {
                	  
                	  System.out.println("erreur de format[" +"F"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
                	  
                	  
                    String nomCellule="[" +"F"+index+ "]";
                	  
                	  cellReference = new CellReference("B"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  bilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  bilanReport.errorCelluleMap.put(nomCellule, "[" +"F"+index+ "]");
                	  
                	  
                  }
                  
                 // Fin cellule F
                  
                  
                  
              // Debut cellule G
            	  
            	  cellReference = new CellReference("G"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                  {
                	  
                	  System.out.println("erreur de format[" +"G"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
                	  
                	  
             String nomCellule="[" +"G"+index+ "]";
                	  
                	  cellReference = new CellReference("B"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  bilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  bilanReport.errorCelluleMap.put(nomCellule, "[" +"G"+index+ "]");
                  	
                  }
                  
                 // Fin cellule G
                  
                  
                  
                 // Debut cellule K
            	  
            	  cellReference = new CellReference("K"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                  {
                	  
                	  System.out.println("erreur de format[" +"K"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
                	  
                      String nomCellule="[" +"K"+index+ "]";
                	  
                	  cellReference = new CellReference("I"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  bilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  
                	  bilanReport.errorCelluleMap.put(nomCellule, "[" +"k"+index+ "]");
                    	
                	  
                  }else 
                  {
                  	
                  	if(index==3)
                  	{
                  		
                  		if ( (cellValue!=null) && (cellValue.getCellType() == CellType.NUMERIC))
                          {
                        	  
                         total=cellValue.getNumberValue();	
                          }
                  		
                  		
                  	}
                  	
                  	
                  }

                  
                 // Fin cellule K
                  
                  
              // Debut cellule L
            	  
            	  cellReference = new CellReference("L"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                  {
                	  
                	  System.out.println("erreur de format[" +"L"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
                	  
                	  
                   String nomCellule="[" +"L"+index+ "]";
                	  
                	  cellReference = new CellReference("I"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  bilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  bilanReport.errorCelluleMap.put(nomCellule, "[" +"L"+index+ "]");
                    	
                	  
                	  
                  }
                  
                 // Fin cellule L
                  
                  
              }
              
              
              
              //Gestion des references
              
          
              
              for (int index=1 ;index<=31 ;index++) 
              {
            	  
            	  
            	  if(index!=2) {
            	  
            		//  referrenceBilan1
                 cellReference = new CellReference("A"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
              //  referrenceBilan2
                  
                  cellReference2 = new CellReference("H"+index); 
            	  
            	  rowCase2 = datatypeSheet.getRow(cellReference2.getRow());
                  cellCase2 = rowCase.getCell(cellReference2.getCol());
                  cellValue2 = evaluator.evaluate(cellCase2);
                  
              //  referrenceBilan1
                  if (!(cellValue == null ))
                  {
                	  
                	  if (!(cellValue.getStringValue().equals(referrenceBilan1.get((index-1)))) )
                	  {
                		
                		  if (bilanReport == null) {
                              bilanReport = new BilanReport();
                              report.setErrorExist(true);
                          }
                		
                		bilanReport.errorMap.put(referrenceBilan1.get((index-1)), "Libellé référence modifiée");
                		 bilanReport.errorCelluleMap.put(referrenceBilan1.get((index-1)), "[" +"A"+index+ "]");
                         
                		  
                	  }
                	  
                	  
                	  
                	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
                    	  
                  } else 
                  {
                	
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
            		
            		bilanReport.errorMap.put(referrenceBilan1.get((index-1)), "Référence inexistante");
            		 bilanReport.errorCelluleMap.put(referrenceBilan1.get((index-1)), "[" +"A"+index+ "]");
                     
                	  
                  }
                  
              //  referrenceBilan1
                  
                  
                  //  referrenceBilan2   &&(cellValue2.getCellType() == CellType.BLANK)
                  
                  if ( cellValue2 != null )
                  {
                	  
                	  if (!(cellValue2.getStringValue().equals(referrenceBilan2.get((index-1)))) )
                	  {
                		
                		  if (bilanReport == null) {
                              bilanReport = new BilanReport();
                              report.setErrorExist(true);
                          }
                		
                		bilanReport.errorMap.put(referrenceBilan2.get((index-1)), "Libellé référence modifiée");
                		 bilanReport.errorCelluleMap.put(referrenceBilan2.get((index-1)), "[" +"H"+index+ "]");
                		  
                	  }
                	  
                	  
                	  
                	  System.out.println("refernce H"+index+ "]  "+ cellValue2.getStringValue()  +"--");
                    	  
                  } else 
                  {
                	
                	  if((index!=26)) {
                	  
                	  
                	  if (bilanReport == null) {
                          bilanReport = new BilanReport();
                          report.setErrorExist(true);
                      }
            		
            		bilanReport.errorMap.put(referrenceBilan2.get((index-1)), "Référence inexistante");
            		 bilanReport.errorCelluleMap.put(referrenceBilan2.get((index-1)), "[" +"H"+index+ "]");
                	 
                	  }
            		
                  }
                  
                  
                  //  referrenceBilan2
                  
                  
            	  }  //index!=2
                 
            	  //  fin referrenceBilan1 
            	  
            	  
            	  
            	  //  referrenceBilan2
                  
                  
                  // fin referrenceBilan2
            	  
            	  
              }
              
        
              
              
              
              //Fin de la gestion du nombre de ligne
              
              
              
          
            
             //FIn de la gestion des references
            /*
            cellReference = new CellReference("D18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if (cellValue == null)
            {
            	
            	 if (bilanReport == null) {
                     bilanReport = new BilanReport();
                     report.setErrorExist(true);
                 }
                 bilanReport.setTotalActifImmobiliseObservation("Information non renseignée");
                 bilanReport.setTotalActifImmobiliseIsCorrect(false);
                 bilanReport.setTotalActifImmobiliseCellule("D18"); 
            	
            }else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation(" Format incorrect de l'information renseignée");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
                bilanReport.setTotalActifImmobiliseCellule("D18"); 
            }
            //2
            cellReference = new CellReference("E18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	  if (bilanReport == null) {
                      bilanReport = new BilanReport();
                      report.setErrorExist(true);
                  }
                  bilanReport.setTotalActifImmobiliseObservation("Information non renseignée");
                  bilanReport.setTotalActifImmobiliseIsCorrect(false);
                  bilanReport.setTotalActifImmobiliseCellule("E18");
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
                bilanReport.setTotalActifImmobiliseCellule("E18");
            }
            //3
            cellReference = new CellReference("F18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());

            cellValue = evaluator.evaluate(cellCase);
            if(cellValue == null ) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Information non renseignée");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
                bilanReport.setTotalActifImmobiliseCellule("F18");
            	
            } else
            
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
                bilanReport.setTotalActifImmobiliseCellule("F18");
            }
            //1
            cellReference = new CellReference("G18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            System.out.println("[ligne G18 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
           
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Information non renseignée");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
                bilanReport.setTotalActifImmobiliseCellule("G18");
            }
            else
            	
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
                bilanReport.setTotalActifImmobiliseCellule("G18");
            }

            //Total Ressource stable
            //1
            cellReference = new CellReference("K18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalRessourceObservation("Information non renseignée");
                bilanReport.setTotalRessourceIsCorrect(false);
                bilanReport.setTotalRessourceCellule("K18");
            }
            else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalRessourceObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalRessourceIsCorrect(false);
                bilanReport.setTotalRessourceCellule("K18");
                
            }
            //2
            cellReference = new CellReference("L18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalRessourceObservation("Information non renseignée");
                bilanReport.setTotalRessourceIsCorrect(false);
                bilanReport.setTotalRessourceCellule("L18");
            	
            }else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalRessourceObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalRessourceIsCorrect(false);
                bilanReport.setTotalRessourceCellule("L18");
            }

            //TotalActifCirculant
            //1
            cellReference = new CellReference("D25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("D25");
            	
            } else
            	
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("D25");
            }
            //2
            cellReference = new CellReference("E25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("E25");
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("E25");
            }
            //3
            cellReference = new CellReference("F25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("F25");
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("F25");
            }
            //4
            cellReference = new CellReference("G25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null){
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("G25");
            	
            }else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalActifCirculantIsCorrect(false);
                bilanReport.setTotalActifCirculantCellule("G25");
            }

            //TotalPassif
            //1
            cellReference = new CellReference("K25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalPassifObservation("Information non renseignée");
                bilanReport.setTotalPassifIsCorrect(false);
                bilanReport.setTotalPassifCellule("K25");
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalPassifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalPassifIsCorrect(false);
                bilanReport.setTotalPassifCellule("K25");
            }
            //2
            cellReference = new CellReference("L25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if( cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalPassifObservation("Information non renseignée");
                bilanReport.setTotalPassifIsCorrect(false);
                bilanReport.setTotalPassifCellule("L25");
            	
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalPassifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalPassifIsCorrect(false);
                bilanReport.setTotalPassifCellule("L25");
            }
            //TotalTresorerieActif
            //1
            cellReference = new CellReference("D29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Information non renseignée");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
                bilanReport.setTotalTresorerieActifCellule("D29");
            	
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
                bilanReport.setTotalTresorerieActifCellule("D29");
            }
            //2
            cellReference = new CellReference("F29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	 if (bilanReport == null) {
                     bilanReport = new BilanReport();
                     report.setErrorExist(true);
                 }
                 bilanReport.setTotalTresorerieActifObservation("Information non renseignée");
                 bilanReport.setTotalTresorerieActifIsCorrect(false);
                 bilanReport.setTotalTresorerieActifCellule("F29");
            	
            } else
            
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
                bilanReport.setTotalTresorerieActifCellule("F29");
            }
            //3
            cellReference = new CellReference("F29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null ) 
            {
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Information non renseignée");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
                bilanReport.setTotalTresorerieActifCellule("F29");
            	
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
                bilanReport.setTotalTresorerieActifCellule("F29");
            }
            //4
            cellReference = new CellReference("G29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if(cellValue == null) {
            	
            	
            	 if (bilanReport == null) {
                     bilanReport = new BilanReport();
                     report.setErrorExist(true);
                 }
                 bilanReport.setTotalTresorerieActifObservation("Information non renseignée");
                 bilanReport.setTotalTresorerieActifIsCorrect(false);
                 bilanReport.setTotalTresorerieActifCellule("G29");
            	
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
                bilanReport.setTotalTresorerieActifCellule("G29");
            }

            //TotalTresoreriePassif
            //1
            cellReference = new CellReference("K29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) 
            {
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresoreriePassifObservation("Information non renseignée");
                bilanReport.setTotalTresoreriePassifIsCorrect(false);
                bilanReport.setTotalTresoreriePassifCellule("K29");
            	
            }else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresoreriePassifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalTresoreriePassifIsCorrect(false);
                bilanReport.setTotalTresoreriePassifCellule("K29");
            }
            //2
            cellReference = new CellReference("L29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresoreriePassifObservation("Information non renseignée");
                bilanReport.setTotalTresoreriePassifIsCorrect(false);
                bilanReport.setTotalTresoreriePassifCellule("L29");
            } else
            	
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresoreriePassifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalTresoreriePassifIsCorrect(false);
                bilanReport.setTotalTresoreriePassifCellule("L29");
            }

            //TotalGeneralActif
            //1
            cellReference = new CellReference("D31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("D31");
            } else
            
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("D31");
            }
            //2
            cellReference = new CellReference("E31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("E31");
            	
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("E31");
            }
            //3
            cellReference = new CellReference("F31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if(cellValue == null) {
            	
            	 if (bilanReport == null) {
                     bilanReport = new BilanReport();
                     report.setErrorExist(true);
                 }
                 bilanReport.setTotalGeneralActifObservation("Information non renseignée");
                 bilanReport.setTotalGeneralActifIsCorrect(false);
                 bilanReport.setTotalGeneralActifCellule("F31");
            	
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("F31");
            } else {
                totalBilan = String.valueOf((long) cellCase.getNumericCellValue());
            }
            //4
            cellReference = new CellReference("G31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("G31");
            	
            }else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalGeneralActifIsCorrect(false);
                bilanReport.setTotalGeneralActifCellule("G31");
            }
            //capitalPropre
            cellReference = new CellReference("K13");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne K13 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() == CellType.NUMERIC) {
                capitalPropre = String.valueOf((long) cellCase.getNumericCellValue());
                System.out.println("capitalPropre = " + capitalPropre);
            }

            //TotalGeneralPassif
            //1
            cellReference = new CellReference("K31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
           
            if(cellValue == null)  
            {
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralPassifObservation("Information non renseignée");
                bilanReport.setTotalGeneralPassifIsCorrect(false);
                bilanReport.setTotalGeneralPassifCellule("K31");
            	
            } else
            
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralPassifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalGeneralPassifIsCorrect(false);
                bilanReport.setTotalGeneralPassifCellule("K31");
            }
            //2
            cellReference = new CellReference("L31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if(cellValue == null) 
            {
            	
            	if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralPassifObservation("Information non renseignée");
                bilanReport.setTotalGeneralPassifIsCorrect(false);
                bilanReport.setTotalGeneralPassifCellule("L31");
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralPassifObservation("Format incorrect de l'information renseignée");
                bilanReport.setTotalGeneralPassifIsCorrect(false);
                bilanReport.setTotalGeneralPassifCellule("L31");
            }

            
            
            cellReference = new CellReference("K3");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue != null && cellValue.getCellType() == CellType.NUMERIC) {
                
            	total=cellValue.getNumberValue();
            }
            
            */
            
            //Gestion colonne
            //Gestion nom reference
            //Gestion ligne
              
              System.out.println("---------------------------------->"+total+"-------------------->");

            
         }
          }
            if (bilanReport != null) {
                report.setBilanReport(bilanReport);
            }
            //*** Fin bilan

            
        
            //*** Debut compte resultat
            datatypeSheet = workbook.getSheetAt(6);


            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
           
            
            /* noOfColumns = datatypeSheet.getRow(0).getLastCellNum();
            
            
            System.out.println("------------------------------->> = [" + noOfColumns + "]");*/
            
            
             nombreColonneOk=true;
            
            cellReference = new CellReference("F1");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
               
            if(cellValue==null) {
           	 nombreColonneOk=false;
           	
           } else
            if (cellValue.getCellType() == CellType.BLANK) 
               {
             	  nombreColonneOk=false;
             }
               else
         	   if (cellValue.getCellType() == CellType.STRING) 
         	   {
         		  String cellVal1= cellValue.getStringValue();
       		      String cellVal2= exerciceValue;
       		   boolean testok=false;
       		      
       		      if(cellVal2.length()>0 && cellVal1.length()>0) {
       		    	  
       		   String val1=cellVal1.substring(cellVal1.length()-2, cellVal1.length());
			    int val2= Integer.parseInt(cellVal2.substring(cellVal2.length()-2, cellVal2.length()))-1;
			   System.out.print("val1"+val1);
			   System.out.print("val2"+val2);
       		      
		     
         		   
         		   
       		
    		   try {
    			   testok=val1.equals(String.valueOf(val2));
    		   }
    		   catch(Exception e) 
    		   {
    			   
    		   }
       		      }
         		   if(cellValue.getStringValue().equalsIgnoreCase("31/12/N-1") || testok) 
         		   {
         			   nombreColonneOk=true;
         			   
         		   }
         		   else
         		   {
         			   nombreColonneOk=false;
         		   }
         		   
         		   
         	   }else
         	   {
         		   nombreColonneOk=false;  
         		   
         	   }
            
           
             if(!nombreColonneOk) 
             {
             	
            	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
              	  
           	  
            	 compteResultatReport.errorMap.put("Nombre de colonne", "le nombre de colonne est différent de celui du modèle");
            	 compteResultatReport.errorCelluleMap.put("Nombre de colonne"," il ya une incohérence entre l'exercicle clos au nivdeau de la page et la date renseignée au niveau de la cellule F1");
                  
             	
             } else {
            
            
            
            int n = getLastRowWithData(datatypeSheet);
            if (n != 42) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setNombreDeLigneIsCorrect(false);
            }
            
            else {

            
            //Debut gestion des plages e cellules (E3 - F43) de l'onglet Compte de Résultat 
            for (int index=2 ;index<=43;index++) 
            {
            
            // Debut cellule E
          	  
               	
          	  cellReference = new CellReference("E"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                
                 
                if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                {
              	  
              	  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
              	  
              	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
              	  
              	 
              	String nomCellule="[" +"E"+index+ "]";
          	  
          	  cellReference = new CellReference("B"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                
                
                if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                {
              	  nomCellule=cellValue.getStringValue();
              	 
              	  
                }
          	  
              	 
              	 
              	  
              	compteResultatReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
              	compteResultatReport.errorCelluleMap.put(nomCellule, "[" +"E"+index+ "]");	  
              	  
              	  
                }else 
                {
                	
                	if(index==9)
                	{
                		
                		if ((cellValue!=null) && (cellValue.getCellType() == CellType.NUMERIC))
                        {
                      	  
                       chiffreAffaire=cellValue.getNumberValue()+"";	
                        }
                		
                		
                	}
                	
                	
                	
                	if(index==43)
                	{
                		
                		if ((cellValue!=null) && (cellValue.getCellType() == CellType.NUMERIC))
                        {
                      	resultatNet=cellValue.getNumberValue()+"";	
                        }
                		
                		
                	}
                	
                }
                
             // Fin cellule E
                
            
             // Debut cellule F
            	  
            	  cellReference = new CellReference("F"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                  {
                	  
                	  System.out.println("erreur de format[" +"F"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (compteResultatReport == null) {
                          compteResultatReport = new CompteResultatReport();
                          report.setErrorExist(true);
                      }
                	  
                		String nomCellule="[" +"F"+index+ "]";
                    	  
                    	  cellReference = new CellReference("B"+index); 
                    	  
                    	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                          cellCase = rowCase.getCell(cellReference.getCol());
                          cellValue = evaluator.evaluate(cellCase);
                          
                          
                          if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                          {
                        	  nomCellule=cellValue.getStringValue();
                        	 
                        	  
                          }
                	  
                	  
                	  
                	  
                	  compteResultatReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  compteResultatReport.errorCelluleMap.put(nomCellule, "[" +"F"+index+ "]");	  
                    	
                	  
                	  
                  }
                  
               // Fin cellule F
            	
            	
            	
            }
            //Fin gestion des plages e cellules (E3 - F43) de l'onglet Compte de Résultat
            
            
            
          //Gestion des references  referrenceComptat1
            
           
            
            for (int index=1 ;index<=43 ;index++) 
            {
          	  
            	//  referrencecompteResultat
               cellReference = new CellReference("A"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
            
            //  referrencecompteResultat
                if (!(cellValue == null ))
                {
              	  
              	  if (!(cellValue.getStringValue().equals(referrenceComptat1.get((index-1)))) )
              	  {
              		
              		 if (compteResultatReport == null) {
                         compteResultatReport = new CompteResultatReport();
                         report.setErrorExist(true);
                     }
              		
              		 
              		 
              		 
              		
              		compteResultatReport.errorMap.put(referrenceComptat1.get((index-1)), "Libellé référence modifiée");
                      
              	  compteResultatReport.errorCelluleMap.put(referrenceComptat1.get((index-1)), "[" +"A"+index+ "]");	  
                  
              	  }
              	  
              	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
                  	  
                } else 
                {
              	
                	 if (compteResultatReport == null) {
                         compteResultatReport = new CompteResultatReport();
                         report.setErrorExist(true);
                     }
          		
                	 compteResultatReport.errorMap.put(referrenceComptat1.get((index-1)), "Référence inexistante");
                	  compteResultatReport.errorCelluleMap.put(referrenceComptat1.get((index-1)), "[" +"A"+index+ "]");	  
                      
              	  
                }
               
                
            }
            //  referrencecompteResultat
            
            
            
            
            
            
            
            //ChiffreAffaire
            //1
          /*  cellReference = new CellReference("E9");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null) {
            	
            	if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setChiffreAffaireObservation("Information non renseignée");
                compteResultatReport.setChiffreAffaireIsCorrect(false);
            	
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setChiffreAffaireObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setChiffreAffaireIsCorrect(false);
            } else {
                chiffreAffaire = String.valueOf((long) cellValue.getNumberValue());
            }
            //2
            cellReference = new CellReference("F9");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setChiffreAffaireObservation("Information non renseignée");
                compteResultatReport.setChiffreAffaireIsCorrect(false);
                compteResultatReport.setChiffreAffaireCellule("F9"); 
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setChiffreAffaireObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setChiffreAffaireIsCorrect(false);
                compteResultatReport.setChiffreAffaireCellule("F9"); 
            }

            //resultatNet
            cellReference = new CellReference("E43");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne E43 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                // something miss here
            } else {
                resultatNet = String.valueOf((long) cellValue.getNumberValue());
                System.out.println("kkg");
            }

            //ValeurAjoutee
            //1
            cellReference = new CellReference("E23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setValeurAjouteeObservation("Information non renseignée ");
                compteResultatReport.setValeurAjouteeIsCorrect(false);
                compteResultatReport.setValeurAjouteeCellule("E23");
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setValeurAjouteeObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setValeurAjouteeIsCorrect(false);
                compteResultatReport.setValeurAjouteeCellule("E23");
            }
            //2
            cellReference = new CellReference("F23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
                 compteResultatReport.setValeurAjouteeObservation("Information non renseignée");
                 compteResultatReport.setValeurAjouteeIsCorrect(false);
                 compteResultatReport.setValeurAjouteeCellule("F23");
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setValeurAjouteeObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setValeurAjouteeIsCorrect(false);
                compteResultatReport.setValeurAjouteeCellule("F23");
            }

            //Exedent
            //1
            cellReference = new CellReference("E25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null) {
            	
            	if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setExedentObservation("Information non renseignée");
                compteResultatReport.setExedentIsCorrect(false);
                compteResultatReport.setExedentCellule("E25");
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setExedentObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setExedentIsCorrect(false);
                compteResultatReport.setExedentCellule("E25");
            }
            //2
            cellReference = new CellReference("F25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
                 compteResultatReport.setExedentObservation("Information non renseignée");
                 compteResultatReport.setExedentIsCorrect(false);
                 compteResultatReport.setExedentCellule("E25");
            	
            } else
            	
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setExedentObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setExedentIsCorrect(false);
                compteResultatReport.setExedentCellule("E25");
            }

            //Resultat exploitation
            //1
            cellReference = new CellReference("E28");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null ) {
            	
            	if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatObservation("Information non renseignée");
                compteResultatReport.setResultatIsCorrect(false);
                compteResultatReport.setResultatCellule("E28");
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setResultatIsCorrect(false);
                compteResultatReport.setResultatCellule("E28");
            }
            //2
            cellReference = new CellReference("F28");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
          
            if(cellValue == null)  
            {
            	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
                 compteResultatReport.setResultatObservation("Information non renseignée");
                 compteResultatReport.setResultatIsCorrect(false);
                 compteResultatReport.setResultatCellule("F28");
            	
            	
            } else
            
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setResultatIsCorrect(false);
                compteResultatReport.setResultatCellule("F28");
            }

            //ResultatNet
            //1
            cellReference = new CellReference("E43");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null ) {
            	
            	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
                 compteResultatReport.setResultatNetObservation("Information non renseignée");
                 compteResultatReport.setResultatNetIsCorrect(false);
                 compteResultatReport.setResultatNetCellule("E43");
            } else
            	
            
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatNetObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setResultatNetIsCorrect(false);
                compteResultatReport.setResultatNetCellule("E43");
            }
            //2
            cellReference = new CellReference("F43");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null ) {
            	
            	 if (compteResultatReport == null) {
                     compteResultatReport = new CompteResultatReport();
                     report.setErrorExist(true);
                 }
                 compteResultatReport.setResultatNetObservation("Information non renseignée");
                 compteResultatReport.setResultatNetIsCorrect(false);
                 compteResultatReport.setResultatNetCellule("F43");
            	
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatNetObservation("Format incorrect de l'information renseignée");
                compteResultatReport.setResultatNetIsCorrect(false);
                compteResultatReport.setResultatNetCellule("F43");
            }
*/
            //Gestion colonne
            //Gestion nom reference
            //Gestion ligne

             }
             }
             
            if (compteResultatReport != null) {
                report.setCompteResultatReport(compteResultatReport);
            }
            //*** Fin compte resultat

            //*** Debut flux tresorerie
            datatypeSheet = workbook.getSheetAt(7);
            System.out.println("--> Nom premiere page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
           
            noOfColumns = datatypeSheet.getRow(0).getLastCellNum();
            
                nombreColonneOk=true;
            
            cellReference = new CellReference("F1");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if(cellValue==null) {
           	 nombreColonneOk=false;
           	
           } else
            if (cellValue.getCellType() == CellType.BLANK) 
               {
             	  nombreColonneOk=false;
             }
               else
         	   if (cellValue.getCellType() == CellType.STRING) 
         	   {
         		  String cellVal1= cellValue.getStringValue();
       		   String cellVal2= exerciceValue;
       		   
       		boolean testok=false;
       		
       		   if(cellVal2.length()>0 && cellVal1.length()>0){
       		   
     
       		String val1=cellVal1.substring(cellVal1.length()-2, cellVal1.length());
		    int val2= Integer.parseInt(cellVal2.substring(cellVal2.length()-2, cellVal2.length()))-1;
		   System.out.print("val1"+val1);
		   System.out.print("val2"+val2);
		   
	
       		   
       		
 		   try {
 			  testok=val1.equals(String.valueOf(val2));
 		   }
 		   catch(Exception e) 
 		   {
 			   
 		   }
 		   
       		   }
         		   
         		   if(cellValue.getStringValue().equalsIgnoreCase("31/12/N-1")  || testok) 
         		   {
         			   nombreColonneOk=true;
         			   
         		   }
         		   else
         		   {
         			   nombreColonneOk=false;
         		   }
         		   
         		   
         	   }else
         	   {
         		   nombreColonneOk=false;  
         		   
         	   }
            
            
            
            if(!nombreColonneOk) 
            {
            	
            	 if (fluxTresorerieReport == null) {
                     fluxTresorerieReport = new FluxTresorerieReport();
                     report.setErrorExist(true);
                 }
             	  
          	  
            	 fluxTresorerieReport.errorMap.put("Nombre de colonne", "Le nombre de colonne est différent de celui du modèle");
            	 fluxTresorerieReport.errorCelluleMap.put("Nombre de colonne"," il ya une incohérence entre l'exercicle clos au nivdeau de la page et la date renseignée au niveau de la cellule F1");
            	  
            	
            } else {
            
            
            int b = getLastRowWithData(datatypeSheet);
            if (b != 31) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setNombreDeLigneIsCorrect(false);
            }
            else {
            //Tresorerie
            //1
            
            
          //Debut gestion des plages e cellules (E3 - F43) de l'onglet 
            for (int index=2 ;index<=31;index++) 
            {
            
            // Debut cellule D
          	  
               	
          	  cellReference = new CellReference("D"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                
                 
                if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                {
              	  
              	 // System.out.println("erreur de format[" +"D"+index+ "]  "+ cellValue  +"--");
              	  
              	  if (fluxTresorerieReport == null) {
                      fluxTresorerieReport = new FluxTresorerieReport();
                      report.setErrorExist(true);
                  }
              	  
              	  
              	String nomCellule="[" +"D"+index+ "]";
          	  
          	  cellReference = new CellReference("B"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                
                
                if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                {
              	  nomCellule=cellValue.getStringValue();
              	 
              	  
                }
          	  
              	  
              	  
              	fluxTresorerieReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
              	  
              	fluxTresorerieReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
              	  
                }
                
             // Fin cellule D
              
             // Debut cellule E
            	  
               	
            	  cellReference = new CellReference("E"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                  {
                	  
                	  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (fluxTresorerieReport == null) {
                          fluxTresorerieReport = new FluxTresorerieReport();
                          report.setErrorExist(true);
                      }
                	  
                	  
                    	String nomCellule="[" +"E"+index+ "]";
                	  
                	  cellReference = new CellReference("B"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  
                	  fluxTresorerieReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  
                   	fluxTresorerieReport.errorCelluleMap.put(nomCellule, "[" +"E"+index+ "]");
                    
                	  
                  }
                  
               // Fin cellule E  
                
                
                
                  // Debut cellule F
            	  
                 	
            	  cellReference = new CellReference("F"+index); 
            	  
            	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                  cellCase = rowCase.getCell(cellReference.getCol());
                  cellValue = evaluator.evaluate(cellCase);
                  
                   
                  if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                  {
                	  
                	  System.out.println("erreur de format[" +"F"+index+ "]  "+ cellValue  +"--");
                	  
                	  if (fluxTresorerieReport == null) {
                          fluxTresorerieReport = new FluxTresorerieReport();
                          report.setErrorExist(true);
                      }
                	  
                	  
                      String nomCellule="[" +"F"+index+ "]";
                	  
                	  cellReference = new CellReference("B"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                      
                      if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                      {
                    	  nomCellule=cellValue.getStringValue();
                    	 
                    	  
                      }
                	  
                	  
                	  
                	  
                	  fluxTresorerieReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                	  
                	  	fluxTresorerieReport.errorCelluleMap.put(nomCellule, "[" +"F"+index+ "]");
                        
                	  
                  }
                  
               // Fin cellule F 
                
                
                
                
            }
            
            
            
        //Gestion des references  referrenceTresorerie1
            
           
            
            for (int index=1 ;index<=31 ;index++) 
            {
          	  
            	//  referrencecompteResultat
               cellReference = new CellReference("A"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
            
            //  referrencecompteResultat
                if (!(cellValue == null ))
                {
              	  
              	  if (!(cellValue.getStringValue().equals(referrenceTresorerie1.get((index-1)))) )
              	  {
              		
              		if (fluxTresorerieReport == null) {
                        fluxTresorerieReport = new FluxTresorerieReport();
                        report.setErrorExist(true);
                    }
              		fluxTresorerieReport.errorMap.put(referrenceTresorerie1.get((index-1)), "Libellé référence modifiée");
              	 	fluxTresorerieReport.errorCelluleMap.put(referrenceTresorerie1.get((index-1)), "[" +"A"+index+ "]");
                    
              	  }
              	  
              	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
                  	  
                } else 
                {
                	if( (index!=18) && (index!=9) && (index!=3)  && (index!=24)  && (index!=11)) {
              	
                	if (fluxTresorerieReport == null) {
                        fluxTresorerieReport = new FluxTresorerieReport();
                        report.setErrorExist(true);
                    }
          		
                	fluxTresorerieReport.errorMap.put(referrenceTresorerie1.get((index-1)), "Référence inexistante");
                	fluxTresorerieReport.errorCelluleMap.put(referrenceTresorerie1.get((index-1)), "[" +"A"+index+ "]");
                    
                	
                	
                	}
              	  
                }
               
                
            }
            //  referrenceTresorerie1
            
            
            
          /*  
            
            
            cellReference = new CellReference("E2");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null) {
            	
            	 if (fluxTresorerieReport == null) {
                     fluxTresorerieReport = new FluxTresorerieReport();
                     report.setErrorExist(true);
                 }
                 fluxTresorerieReport.setTresorerieObservation("Information non renseignée");
                 fluxTresorerieReport.setTresorerieIsCorrect(false);
                 fluxTresorerieReport.setTresorerieCellule("E2"); 
            	
            } else
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setTresorerieIsCorrect(false);
                fluxTresorerieReport.setTresorerieCellule("E2");   
            }
            //2
            cellReference = new CellReference("F2");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
           
            if(cellValue == null) 
            
            {
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieObservation("Information non renseignée");
                fluxTresorerieReport.setTresorerieIsCorrect(false);
                fluxTresorerieReport.setTresorerieCellule("F2");   
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setTresorerieIsCorrect(false);
                fluxTresorerieReport.setTresorerieCellule("F2");   
            }

            //fluxActiviteOperationnelle
            //1
            cellReference = new CellReference("E10");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null ) {
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteOperationnelleObservation("Information non renseignée");
                fluxTresorerieReport.setFluxActiviteOperationnelleIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteOperationnelleCellule("E10"); 
            	
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteOperationnelleObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setFluxActiviteOperationnelleIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteOperationnelleCellule("E10");  
            }
            //2
            cellReference = new CellReference("F10");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null ) {
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteOperationnelleObservation("Information non renseignée");
                fluxTresorerieReport.setFluxActiviteOperationnelleIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteOperationnelleCellule("F10");  
            	
            } else
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteOperationnelleObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setFluxActiviteOperationnelleIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteOperationnelleCellule("F10");  
            }

            //fluxActiviteInvestissement
            //1
            cellReference = new CellReference("E23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if( cellValue == null) {
            	
            	
            	 if (fluxTresorerieReport == null) {
                     fluxTresorerieReport = new FluxTresorerieReport();
                     report.setErrorExist(true);
                 }
                 fluxTresorerieReport.setFluxActiviteInvestissementObservation("Information non renseignée");
                 fluxTresorerieReport.setFluxActiviteInvestissementIsCorrect(false);
                 fluxTresorerieReport.setFluxActiviteInvestissementCellule("E23");  
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteInvestissementObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setFluxActiviteInvestissementIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteInvestissementCellule("E23");  
            }
            //2
            cellReference = new CellReference("F23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            
            if(cellValue == null) {
            	
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteInvestissementObservation("Information non renseignée");
                fluxTresorerieReport.setFluxActiviteInvestissementIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteInvestissementCellule("F23"); 
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteInvestissementObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setFluxActiviteInvestissementIsCorrect(false);
                fluxTresorerieReport.setFluxActiviteInvestissementCellule("F23"); 
            }

            //fluxCapitauxEtranger
            //1
            cellReference = new CellReference("E29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null ) {
            	
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxCapitauxEtrangerObservation("Information non renseignée");
                fluxTresorerieReport.setFluxCapitauxEtrangerIsCorrect(false);
                fluxTresorerieReport.setFluxCapitauxEtrangerCellule("E29"); 
            	
            } else
            
            if (cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxCapitauxEtrangerObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setFluxCapitauxEtrangerIsCorrect(false);
                fluxTresorerieReport.setFluxCapitauxEtrangerCellule("E29"); 
            }
            //2
            cellReference = new CellReference("F29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxCapitauxEtrangerObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxCapitauxEtrangerIsCorrect(false);
                fluxTresorerieReport.setFluxCapitauxEtrangerCellule("F29"); 
            	
            	
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxCapitauxEtrangerObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxCapitauxEtrangerIsCorrect(false);
                fluxTresorerieReport.setFluxCapitauxEtrangerCellule("F29"); 
            }

            //tresorerieNette
            //1
            cellReference = new CellReference("E31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieNetteObservation("Information non renseignée");
                fluxTresorerieReport.setTresorerieNetteIsCorrect(false);
                fluxTresorerieReport.setTresorerieNetteCellule("E31");
            	
            	
            } else
            
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieNetteObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setTresorerieNetteIsCorrect(false);
                fluxTresorerieReport.setTresorerieNetteCellule("E31");
            }
            //2
            cellReference = new CellReference("F31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if( cellValue == null) {
            	
            	if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieNetteObservation("Information non renseignée");
                fluxTresorerieReport.setTresorerieNetteIsCorrect(false);
                fluxTresorerieReport.setTresorerieNetteCellule("F31");
            	
            } else
            if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieNetteObservation("Format incorrect de l'information renseignée");
                fluxTresorerieReport.setTresorerieNetteIsCorrect(false);
                fluxTresorerieReport.setTresorerieNetteCellule("F31");
            }*/

            
           }
            }
            if (fluxTresorerieReport != null) {
                report.setFluxTresorerieReport(fluxTresorerieReport);
            }
            //*** Fin flux tresorerie

            
            
            //*** Debut flux Note 13
            datatypeSheet = workbook.getSheetAt(28);
            System.out.println("--> Nom premiere page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
          
           
            
            if(
                    formJuridique.equals("31")|| formJuridique.equals("32")
                 || formJuridique.equals("33") || formJuridique.equals("34")
                 || formJuridique.equals("35") || formJuridique.equals("36")
                 || formJuridique.equals("37") || formJuridique.equals("38")
                 || formJuridique.equals("39") || formJuridique.equals("40")
                 		 
                 ) {
                 	 
            
            
            /*
          //NomPrenom
            String [] cellulesNomPrenom = {"A10", "A11", "A12",}  ; // tableau de cellules à verifier
            Boolean isEmptyNomPrenom = true;
            for(int i=0; i<cellulesNomPrenom.length; i++) {
                cellReference = new CellReference(cellulesNomPrenom[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
             //   System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ((cellCase.getCellType() == CellType.STRING)|| (cellCase.getCellType() == CellType.NUMERIC)) {
                	isEmptyNomPrenom = false ;
                    break;
                }
               }
            if(isEmptyNomPrenom) {
            	
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
               }
                
                
                note13.errorMap.put("Liste actionnaires", " informations manquantes");
                note13.errorCelluleMap.put("Liste actionnaires", "A10");
       		 
            }
            */
            /*
          //Nationalite
            String [] cellulesNationalite = {"B10", "B11", "B12",}  ; // tableau de cellules à verifier
            Boolean isEmptyNationalite = true;
            for(int i=0; i<cellulesNationalite.length; i++) {
                cellReference = new CellReference(cellulesNationalite[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
             //   System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ((cellCase.getCellType() == CellType.STRING)|| (cellCase.getCellType() == CellType.NUMERIC)) {
                	isEmptyNationalite = false ;
                    break;
                }
               }
            if(isEmptyNationalite) {
            	
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
               }
                
                
                note13.errorMap.put("Liste actionnaires", " informations manquantes");
                note13.errorCelluleMap.put("Liste actionnaires", "B10");
           		
       		 
            }
            */
            /*
          //Nature
            String [] cellulesNature = {"C10", "C11", "C12",}  ; // tableau de cellules à verifier
            Boolean isEmptyNature = true;
            for(int i=0; i<cellulesNature.length; i++) {
                cellReference = new CellReference(cellulesNature[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
             //   System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ((cellCase.getCellType() == CellType.STRING)|| (cellCase.getCellType() == CellType.NUMERIC)) {
                	isEmptyNature = false ;
                    break;
                }
               }
            if(isEmptyNature) {
            	
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
               }
                
                
                note13.errorMap.put("Liste actionnaires", " informations manquantes");
                note13.errorCelluleMap.put("Liste actionnaires", "C10");
               	
       		 
            }*/
            
            
            /*
          //Nombre
            String [] cellulesNombre = {"E10", "E11", "E12",}  ; // tableau de cellules à verifier
            Boolean isEmptyNombre = true;
            for(int i=0; i<cellulesNombre.length; i++) {
                cellReference = new CellReference(cellulesNombre[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
             //   System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ((cellCase.getCellType() == CellType.STRING)|| (cellCase.getCellType() == CellType.NUMERIC)) {
                	isEmptyNombre = false ;
                    break;
                }
               }
            if(isEmptyNombre) {
            	
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
               }
                
                
                note13.errorMap.put("Liste actionnaires", " informations manquantes");
                note13.errorCelluleMap.put("Liste actionnaires", "E10");
                
       		 
            }*/
            /*
          //Montant
            String [] cellulesMontant = {"F10", "F11", "F12",}  ; // tableau de cellules à verifier
            Boolean isEmptyMontant = true;
            for(int i=0; i<cellulesMontant.length; i++) {
                cellReference = new CellReference(cellulesMontant[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
             //   System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
               // if ((cellCase.getCellType() == CellType.STRING)|| (cellCase.getCellType() == CellType.NUMERIC)) {
                if ( (cellCase.getCellType() != CellType.BLANK)) {
                	
                	try {
                	 double nomtant=cellCase.getNumericCellValue();
                	 
                	 isEmptyMontant = false ;
                    
                	} catch (Exception ie) {// driver not found
                	
                	 isEmptyMontant = false ;
                        
                         if (note13 == null) {
                         	note13 = new Note13();
                             report.setErrorExist(true);
                        }
                	 note13.errorMap.put("Liste actionnaires", "Format incorrect de l'information renseignée");
                      note13.errorCelluleMap.put("Liste actionnaires", "F10");
                      break;
                	}
                	
                	 break;
                }
               }
            if(isEmptyMontant) {
            	
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
               }
                
                
                note13.errorMap.put("Liste actionnaires", " informations manquantes");
                note13.errorCelluleMap.put("Liste actionnaires", "F10");
                
       		 
            }*/
            
            /*
            //Cession
            String [] cellulesCession = {"G10", "G11", "G12",}  ; // tableau de cellules à verifier
            Boolean isEmptyCession = true;
            for(int i=0; i<cellulesCession.length; i++) {
                cellReference = new CellReference(cellulesCession[i]);
                rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
             //   System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                if ((cellCase.getCellType() == CellType.STRING)|| (cellCase.getCellType() == CellType.NUMERIC)) {
                	isEmptyCession = false ;
                    break;
                }
               }
            if(isEmptyCession) {
            	
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
               }
                
                
                note13.errorMap.put("Liste actionnaires", "informations manquantes");
                note13.errorCelluleMap.put("Liste actionnaires", "G10");
                
            }*/
            
            //
           /* cellReference = new CellReference("F19");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            
            if(cellValue == null) {
            	
            	if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
                }
                
                note13.errorMap.put("Total", "Information non renseignée");
                note13.errorCelluleMap.put("Total", "F19");
            	
            } else*/
            
            
            /*if ( cellValue.getCellType() != CellType.NUMERIC) {
                if (note13 == null) {
                	note13 = new Note13();
                    report.setErrorExist(true);
                }
                
                note13.errorMap.put("Total", "Format incorrect de l'information renseignée");
                note13.errorCelluleMap.put("Total", "F19");
                
            }else
            {
            	
           
             System.out.println("------------->"+cellValue.getNumberValue()+"---"+total);
               
             
          
            	 
            	 
             
            	
            	if(!(cellValue.getNumberValue()==total))
              {
            		 if (note13 == null) {
                     	note13 = new Note13();
                         report.setErrorExist(true);
                     }
            		note13.errorMap.put("Montant des actions", "Le total de la valeur des actions est différent  du Capital (Bilan Paysage)");  
            		 note13.errorCelluleMap.put("Montant des actions", "F19/K3");
              }
            	
            	
             }	*/
            	
            	
            }
            
            
            
            
            
            if (note13 != null) {
                report.setNote13(note13);
            }
            
            //note13
            
            
            }  //fin nombre de page
            
            }
            
            if (report.errorExist) {
                HeaderReport headerReport = new HeaderReport();

                headerReport.setDesignationValue(designationValue);
                headerReport.setAdresseValue(adresseValue);
                headerReport.setNumIdentificationValue(numIdentificationValue);
                headerReport.setSigleValue(sigleValue);
                headerReport.setExerciceValue(exerciceValue);

                report.setHeaderReport(headerReport);
            } else {
                ExcelData excelData = new ExcelData();

                excelData.setEntreprise(designationValue);
                excelData.setNinea(numIdentificationValue);
                excelData.setTotalBilan(totalBilan);
                excelData.setCapitalPropre(capitalPropre);
                excelData.setResultatNet(resultatNet);
                excelData.setChiffreAffaire(chiffreAffaire);
                
                
                System.out.println("chiffreAffaire ------------->"+chiffreAffaire);
                System.out.println("resultatNet------------->"+resultatNet);
                
                

                report.setExcelData(excelData);
            }

            //String reportFileName = "Rapport de conformité_test.xlsx";
            excelFile.close();
            createReport(report, filePath, rapportFileName);
        } catch (Exception e) {
            report = null;
            System.out.println("xxxxxxx");
            e.printStackTrace();
            System.out.println("yyyyyyy");


        } finally {

            try {
                // He was careful to close streams in finally block, but it’s not complete
                // Can you spot error?

                if (excelFile != null)
                    excelFile.close();

            } catch (IOException e) {
                System.out.println("Failed to close streams");
            }

        }

        System.out.println("======> Fin verification excel");
        //2222222222222222222222222222222222222222222222222222222222222222222222

        return report;
    }

    
    
    
    
    public static void createReport(Report report, String filePath, String reportFileName) {
        System.out.println("======> Debut creation rapport");
        if (report.errorExist) {
            System.out.println("--> Avec creation rapport");
////            String fileLocation = "E:\\Bassirou\\ProjetOrbusLinkComptable\\docs\\Bassirou\\Tests\\Rapport_de_conformite_Bass.xlsx";
            String fileLocation = filePath + reportFileName;

            try {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet();

                //Taille colonne B
                sheet.setColumnWidth(1, 9500);
                //Taille colonne C
                sheet.setColumnWidth(2, 10000);
                //Taille colonne E
                sheet.setColumnWidth(4, 4000);
                //Fusion cellule
                
                //gestion de la nouvelle version
                
                sheet.addMergedRegion(CellRangeAddress.valueOf("A1:E1"));
                sheet.addMergedRegion(CellRangeAddress.valueOf("A9:E9"));
                //Fin de la Nouvelle version
                
                
              

                CellStyle styleHeaderDoc = workbook.createCellStyle();
                styleHeaderDoc.setWrapText(true);
                styleHeaderDoc.setAlignment(HorizontalAlignment.RIGHT);

                CellStyle styleTitle = workbook.createCellStyle();
                styleTitle.setWrapText(true);
                styleTitle.setAlignment(HorizontalAlignment.CENTER);

                CellStyle styleHeaderTab = workbook.createCellStyle();
                styleHeaderTab.setWrapText(true);
                styleHeaderTab.setAlignment(HorizontalAlignment.CENTER);
                Font underlineFont = workbook.createFont();
                underlineFont.setUnderline(HSSFFont.U_SINGLE);
                styleHeaderTab.setFont(underlineFont);
                
                

                CellStyle styleTitleTab = workbook.createCellStyle();
                styleTitleTab.setWrapText(true);
                //styleTitleTab.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                styleTitleTab.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                styleTitleTab.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                CellStyle styleDefault = workbook.createCellStyle();
                styleDefault.setWrapText(true);
                
                
                CellStyle style = workbook.createCellStyle();//Create style
                Font font = workbook.createFont();//Create font
                font.setBold(true);//Make font bold
                font.setFontHeight((short)300);
                
                Font fontDoc = workbook.createFont();//Create font
                fontDoc.setBold(true);//Make font bold
                fontDoc.setUnderline(HSSFFont.U_SINGLE);
                

                
                
                CellStyle styleTitleTabgreen = workbook.createCellStyle();
                styleTitleTabgreen.setWrapText(true);
               
                styleTitleTabgreen.setFont(font);//set it to bold
                styleTitleTabgreen.setAlignment(HorizontalAlignment.CENTER);
                 styleTitleTabgreen.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                styleTitleTabgreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                
                CellStyle styleHeaderDocNew = workbook.createCellStyle();
                styleHeaderDocNew.setWrapText(true);
                styleHeaderDocNew.setAlignment(HorizontalAlignment.LEFT);
                styleHeaderDocNew.setFont(underlineFont);
                styleHeaderDocNew.setFont(fontDoc);//set it to bold
                
                
                CellStyle styleHeaderDocNew2 = workbook.createCellStyle();
                styleHeaderDocNew2.setWrapText(true);
                styleHeaderDocNew2.setAlignment(HorizontalAlignment.CENTER);
                styleHeaderDocNew2.setFont(underlineFont);
                styleHeaderDocNew2.setFont(fontDoc);//set it to bold
                

                //Debut creation header
                HeaderReport headerReport = report.getHeaderReport();

                int rowNum;
                int colNum;

                sheet.addMergedRegion(CellRangeAddress.valueOf("B8:E8"));
                //Data row 1 (ligne 1)
                rowNum = 0;
                Row row0 = sheet.createRow(rowNum);
                row0.setHeightInPoints((short)25);
                //B2
                colNum = 0;
                Cell cellB1 = row0.createCell(colNum);
                cellB1.setCellValue(headerReport.getDesignationName());
                cellB1.setCellStyle(styleTitleTabgreen);
                
                Cell cellule;
                rowNum = 1;
                Row row = sheet.createRow(rowNum);
                colNum = 1;
                cellule = row.createCell(colNum);
                cellule.setCellValue(headerReport.getDesignationName());
                cellule.setCellStyle(styleHeaderDocNew);
                colNum = 2;
                cellule = row.createCell(colNum);
                cellule.setCellValue(headerReport.getDesignationValue());
                cellule.setCellStyle(styleDefault);
                
                
                
                rowNum = 2;
                 row = sheet.createRow(rowNum);
                colNum = 1;
                cellule = row.createCell(colNum);
                cellule.setCellValue(headerReport.getSigleName());
                cellule.setCellStyle(styleHeaderDocNew);
                colNum = 2;
                cellule = row.createCell(colNum);
                cellule.setCellValue(headerReport.getSigleValue());
                cellule.setCellStyle(styleDefault);
                
                
                rowNum = 3;
                row = sheet.createRow(rowNum);
               colNum = 1;
               cellule = row.createCell(colNum);
               cellule.setCellValue(headerReport.getNumIdentificationName());
               cellule.setCellStyle(styleHeaderDocNew);
               colNum = 2;
               cellule = row.createCell(colNum);
               cellule.setCellValue(headerReport.getNumIdentificationValue());
               cellule.setCellStyle(styleDefault);
               
               rowNum = 4;
               row = sheet.createRow(rowNum);
              colNum = 1;
              cellule = row.createCell(colNum);
              cellule.setCellValue(headerReport.getAdresseName());
              cellule.setCellStyle(styleHeaderDocNew);
              colNum = 2;
              cellule = row.createCell(colNum);
              cellule.setCellValue(headerReport.getAdresseValue());
              cellule.setCellStyle(styleDefault);
                
               
              rowNum = 5;
              row = sheet.createRow(rowNum);
             colNum = 1;
             cellule = row.createCell(colNum);
             cellule.setCellValue(headerReport.getExerciceName());
             cellule.setCellStyle(styleHeaderDocNew);
             colNum = 2;
             cellule = row.createCell(colNum);
             cellule.setCellValue(headerReport.getExerciceValue());
             cellule.setCellStyle(styleDefault);
              
              
             
                
                
               
                //Data row 1 (ligne 1)
                rowNum = 8;
                 row = sheet.createRow(rowNum);
                 row.setHeightInPoints((short)25);
                //B2
                colNum = 0;
                cellule = row.createCell(colNum);
                cellule.setCellValue(headerReport.getTitleResults());
                cellule.setCellStyle(styleTitleTabgreen);
                
                
                
                //debut de la gestion des erreur de form
                
                int numeroLigne = 9;

                Row myRow;
                Cell myCell;
                
                if (report.getPageGardeReport() != null) {
                    PageGardeReport pageGardeReport = report.getPageGardeReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec page de garde");

                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(pageGardeReport.getTitle());
                    myCell.setCellStyle(styleHeaderTab);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(pageGardeReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(pageGardeReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                   // Cellule new
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(pageGardeReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : pageGardeReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                      //Cellule
                        myCell = myRow.createCell(3);
                        myCell.setCellValue(String.valueOf(pageGardeReport.getErrorCelluleMap().get(errorMap.getKey())));
                        myCell.setCellStyle(styleDefault);
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans page de garde");
                }
                
                //Fin de la gestion des erreur de form
                
                
                int numeroLigneE = 9;

                Row myRowE;
                Cell myCellE;
                //Gestion gestion des erreur de form
                if (report.listfeuillesManquantes.size()>0 || report.listongletsnomsModifies.size()>0) {
                     //Ajout gestion des erreur de form
                    System.out.println("Rapport avec page erreur mise en form");

                    //Titre
                    rowNum = numeroLigneE;
                    colNum = 1;
                    myRowE = sheet.createRow(rowNum);
                    myCellE = myRowE.createCell(colNum);
                    //report.observationFormat.toString()
                    myCellE.setCellValue("Non-conformités sur le format du fichier");
                    myCellE.setCellStyle(styleHeaderTab);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigneE + 1) + ":C" + (numeroLigneE + 1)));
                    numeroLigneE++;

                    //Entete tab
                    rowNum = numeroLigneE;
                    //Donnee
                    myRowE = sheet.createRow(rowNum);
                    myCellE = myRowE.createCell(1);
                    myCellE.setCellValue("Donnée concernée");
                    myCellE.setCellStyle(styleTitleTab);
                    //Obervation
                    myCellE = myRowE.createCell(2);
                    myCellE.setCellValue("Observations");
                    myCellE.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRowE.createCell(3);
                    myCell.setCellValue("Cellule");
                    myCell.setCellStyle(styleTitleTab);
                    numeroLigneE++;

                    
                    //Liste erreur manquante
                    for (int i=0; i< report.listfeuillesManquantes.size() ;i++) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigneE;
                        //Donnee
                        myRowE = sheet.createRow(rowNum);
                        myCellE = myRowE.createCell(1);
                        myCellE.setCellValue(String.valueOf("Nombre de feuilles"));
                        myCellE.setCellStyle(styleDefault);
                        //Obervation
                        myCellE = myRowE.createCell(2);
                        myCellE.setCellValue(String.valueOf(report.listfeuillesManquantes.get(i)));
                        myCellE.setCellStyle(styleDefault);
                        
                        
                        
                        
                        numeroLigneE++;
                    }
                    
                    
                    //Liste erreur modification
                    for (int i=0; i< report.listongletsnomsModifies.size() ;i++) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigneE;
                        //Donnee
                        myRowE = sheet.createRow(rowNum);
                        myCellE = myRowE.createCell(1);
                        myCellE.setCellValue(String.valueOf(report.listongletsnomsModifies.get(i)));
                        myCellE.setCellStyle(styleDefault);
                        //Obervation
                        myCellE = myRowE.createCell(2);
                        myCellE.setCellValue(String.valueOf(report.errorMaplistongletsnomsModifies.get(report.listongletsnomsModifies.get(i))));
                        myCellE.setCellStyle(styleDefault);
                        
                       
                        
                        
                        numeroLigneE++;
                    }
                    
                    
                    
                } else {
                    System.out.println("Rapport sans erreur de forme");
                }

                //Gestion fiche de renseignement
                if (report.getFicheRenseignementReport() != null) {
                    FicheRenseignementReport ficheRenseignementReport = report.getFicheRenseignementReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec fiche de renseignement");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(ficheRenseignementReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(ficheRenseignementReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(ficheRenseignementReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(ficheRenseignementReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : ficheRenseignementReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
            if(ficheRenseignementReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(ficheRenseignementReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans fiche de renseignement");
                }
                //Gestion activité entreprise
                if (report.getActiviteEntrepriseReport() != null) {
                    ActiviteEntrepriseReport activiteEntrepriseReport = report.getActiviteEntrepriseReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec activité entreprise");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(activiteEntrepriseReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(activiteEntrepriseReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(activiteEntrepriseReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(activiteEntrepriseReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : activiteEntrepriseReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                        System.out.println("A----------------> " +errorMap.getKey()+"---------------->"+errorMap.getValue());
                        
                      if(activiteEntrepriseReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                           
                    	  System.out.println("B----------------> " +errorMap.getKey()+"---------------->"+errorMap.getValue());
                          
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(activiteEntrepriseReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                           }
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans activite entreprise");
                }
                //Gestion dirigeant
                if (report.getDirigeantsReport() != null) {
                    DirigeantsReport dirigeantsReport = report.getDirigeantsReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec dirigeant");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(dirigeantsReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(dirigeantsReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(dirigeantsReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(dirigeantsReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : dirigeantsReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                       if(dirigeantsReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(dirigeantsReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans dirigeant");
                }
                //Gestion balance
                if (report.getBalanceReport() != null) {
                    BalanceReport balanceReport = report.getBalanceReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec balance");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(balanceReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(balanceReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(balanceReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                 // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(balanceReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : balanceReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                      if(balanceReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(balanceReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans balance");
                }
                //Gestion bilan
                if (report.getBilanReport() != null) {
                    BilanReport bilanReport = report.getBilanReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec bilan");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(bilanReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(bilanReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(bilanReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(bilanReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : bilanReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                    if(bilanReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(bilanReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans Bilan");
                }
                //Gestion compte de résultat
                if (report.getCompteResultatReport() != null) {
                    CompteResultatReport compteResultatReport = report.getCompteResultatReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec compte de résultat");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(compteResultatReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(compteResultatReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(compteResultatReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(compteResultatReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : compteResultatReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                     if(compteResultatReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(compteResultatReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans compte de résultat");
                }
                //Gestion flux tresorerie
                if (report.getFluxTresorerieReport() != null) {
                    FluxTresorerieReport fluxTresorerieReport = report.getFluxTresorerieReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec flux tresorerie");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(fluxTresorerieReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(fluxTresorerieReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(fluxTresorerieReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                 // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(fluxTresorerieReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : fluxTresorerieReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                        if(fluxTresorerieReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(fluxTresorerieReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans flux tresorerie");
                }

                
                
                //Debut Gestion note13
                
                
                if (report.getNote13() != null) {
                	
                    Note13 note13 = report.getNote13();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec note13");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(note13.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(note13.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(note13.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                  // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(note13.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : note13.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                      //Obervation
                        
                        if(note13.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                        
                        myCell = myRow.createCell(3);
                        myCell.setCellValue(String.valueOf(note13.getErrorCelluleMap().get(errorMap.getKey())));
                        myCell.setCellStyle(styleDefault);
                        }
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans flux note13");
                }

                
                
              //Fin Gestion note13
                
                
              //Gestion bilan actif
                if (report.getBilanActifReport() != null) {
                    BilanActifReport bilanReport = report.getBilanActifReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec bila actif");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(bilanReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(bilanReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(bilanReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(bilanReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : bilanReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                    if(bilanReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(bilanReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans Bilan actif");
                }
                
                //Fin  bilan actif
                
                
                
                
              //Gestion bilan passif
                if (report.getBilanPassifReport() != null) {
                    BilanPassifReport bilanReport = report.getBilanPassifReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec bilan passif");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(bilanReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(bilanReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(bilanReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(bilanReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : bilanReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                    if(bilanReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(bilanReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans Bilan passif");
                }
                
                //FIn Gestion bilan passif
                
                
              //Gestion  hors bilan
                if (report.getHorsBilanReport() != null) {
                    HorsBilanReport bilanReport = report.getHorsBilanReport();
                    //Ajout page de garde dans le rapport
                    System.out.println("Rapport avec hors bilan");

                    numeroLigne++;
                    //Titre
                    rowNum = numeroLigne;
                    colNum = 1;
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(colNum);
                    myCell.setCellValue(bilanReport.getTitle());
                    myCell.setCellStyle(styleHeaderDocNew2);
                    sheet.addMergedRegion(CellRangeAddress.valueOf("B" + (numeroLigne + 1) + ":C" + (numeroLigne + 1)));
                    numeroLigne++;

                    //Entete tab
                    rowNum = numeroLigne;
                    //Donnee
                    myRow = sheet.createRow(rowNum);
                    myCell = myRow.createCell(1);
                    myCell.setCellValue(bilanReport.getDonnee());
                    myCell.setCellStyle(styleTitleTab);
                    //Obervation
                    myCell = myRow.createCell(2);
                    myCell.setCellValue(bilanReport.getObservation());
                    myCell.setCellStyle(styleTitleTab);
                    
                    // Cellule
                    myCell = myRow.createCell(3);
                    myCell.setCellValue(bilanReport.getCellule());
                    myCell.setCellStyle(styleTitleTab);
                    
                    numeroLigne++;

                    //Liste erreur
                    for (Map.Entry errorMap : bilanReport.getErrorMap().entrySet()) {
                        //System.out.println(errorMap.getKey() + " : " + errorMap.getValue());

                        rowNum = numeroLigne;
                        //Donnee
                        myRow = sheet.createRow(rowNum);
                        myCell = myRow.createCell(1);
                        myCell.setCellValue(String.valueOf(errorMap.getKey()));
                        myCell.setCellStyle(styleDefault);
                        //Obervation
                        myCell = myRow.createCell(2);
                        myCell.setCellValue(String.valueOf(errorMap.getValue()));
                        myCell.setCellStyle(styleDefault);
                        
                    if(bilanReport.getErrorCelluleMap().get(errorMap.getKey())!= null) {
                            
                            myCell = myRow.createCell(3);
                            myCell.setCellValue(String.valueOf(bilanReport.getErrorCelluleMap().get(errorMap.getKey())));
                            myCell.setCellStyle(styleDefault);
                            }
                        
                        
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans hors Bilan");
                }
                
                //Fin gestion hors bilan
                
                //Creation du document
                try {
                    FileOutputStream outputStream = new FileOutputStream(fileLocation);
                    workbook.write(outputStream);
                    workbook.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Done");

            } catch (Exception e) {
                System.out.println("xxxxxxx");
                e.printStackTrace();
                System.out.println("yyyyyyy");
            }
        } else {
            System.out.println("--> Sans creation rapport");
        }
        System.out.println("======> Fin creation rapport");
    }

 
    public static int getLastRowWithData(Sheet sheet) {
        int rowCount = 0;
        Iterator<Row> iter = sheet.rowIterator();

        while (iter.hasNext()) {
            Row r = iter.next();
            if (!isRowBlank(r)) {
                rowCount = r.getRowNum();
            }
        }

        return rowCount;
    }
    
    
    public static int getLastCellWithData(Sheet sheet) {
        int cellCount = 0;
        
        
        
        
        
       /* Row currentRow = sheet.getRow(0);
       
        Iterator<Cell> cellIterator = currentRow.iterator();
        */
        
        /*while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            // getCellTypeEnum shown as deprecated for version 3.15
            // getCellTypeEnum ill be renamed to getCellType starting
            // from version 4.0
            if (currentCell.getCellType() == CellType.STRING) {
             //  System.out.print(currentCell.getStringCellValue() + "-- String");
            } else if (currentCell.getCellType() == CellType.NUMERIC) {
             //   System.out.print(currentCell.getNumericCellValue() + "--");
            }
        
            cellCount++;
        }*/
        
        System.out.println("@========================================>" + "--"+cellCount+"@");
    
        return cellCount;
    }
    
    
    

    public static boolean isRowBlank(Row r) {
        boolean ret = true;

        /*
         * If a row is null, it must be blank.
         */
        if (r != null) {
            Iterator<Cell> cellIter = r.cellIterator();
            /*
             * Iterate through all cells in a row.
             */
            while (cellIter.hasNext()) {
                /*
                 * If one of the cells in given row contains data, the row is
                 * considered not blank.
                 */
                if (!isCellBlank(cellIter.next())) {
                    ret = false;
                    break;
                }
            }
        }

        return ret;
    }

    public static boolean isCellBlank(Cell c) {
        return (c == null || c.getCellType() == CellType.BLANK);
    }

    public static boolean isCellEmpty(Cell c) {
        return (c == null || c.getCellType() == CellType.BLANK || (c
                .getCellType() == CellType.STRING && c
                .getStringCellValue().isEmpty()));
    }

    // By moi (Alioune Seck Bien sur ) Ce code devrait etre plus organisé . 3500 lignes plein de duplicats c'est à améliorer (Bon, on fait avec)
    static Boolean evaluateStringCell(Cell c, FormulaEvaluator evaluator) {
        CellValue cellValue = evaluator.evaluate(c);
        CellType type = c.getCellType();
        String value = c.getStringCellValue();
        if (cellValue != null) {
            type = cellValue.getCellType();
            value = cellValue.getStringValue();
        }
        if (type == CellType.STRING && value != null && value.length() != 0)
            return true;
        return false;
    }

    
    //Gestion pour le depot Assurance
	
	
 	 public static Report verifyExcelAssurance(String filePath, String fileName, String rapportFileName,String formJuridique) {
 		
 		 
 		 Report report = null;
         String designationValue = "";
         String adresseValue = "";
         String numIdentificationValue = "";
         String sigleValue = "";
         String exerciceValue = "";

         String totalBilan = "";//Bilan paysage : F31
         String capitalPropre = "";//Bilan paysage : K13
         String resultatNet = "";//Compte resultat : E50  /new
         String chiffreAffaire = "";//Compte resultat : E51 /new
         
         int nombrePageExcel=0;
         double total=0;
         
        List<String> nomDesOnglet = new ArrayList<>();
        nomDesOnglet.add("Page de garde");
        nomDesOnglet.add("Fiche de renseignement R1");
        nomDesOnglet.add("Bilan Actif");
        nomDesOnglet.add("Bilan Passif");
        nomDesOnglet.add("CEG-ASSURANCES DE DOMMAGES");
        nomDesOnglet.add("CEG-ASSURANCES DE DOMMAGES2");
        nomDesOnglet.add("PERTES ET PROFITS DEBIT");
        nomDesOnglet.add("PERTES ET PROFITS CREDIT");
        nomDesOnglet.add("REGLEMENTES ET LEUR COUVERTURE");
        nomDesOnglet.add("liste placements 1");
        nomDesOnglet.add("liste placement 2");
        nomDesOnglet.add("liste placement 3");
        
        
        List<String> referrenceBilan1 = new ArrayList<>();
       
        referrenceBilan1.add("REF");
        referrenceBilan1.add("REF");
        referrenceBilan1.add("AD");
        referrenceBilan1.add("AE");
        referrenceBilan1.add("AF");
        referrenceBilan1.add("AG");
        referrenceBilan1.add("AH");
        referrenceBilan1.add("AI");
        referrenceBilan1.add("AJ");
        referrenceBilan1.add("AK");
        referrenceBilan1.add("AL");
        referrenceBilan1.add("AM");
        referrenceBilan1.add("AN");
        referrenceBilan1.add("AP");
        referrenceBilan1.add("AQ");
        referrenceBilan1.add("AR");
        referrenceBilan1.add("AS");
        referrenceBilan1.add("AZ");
        referrenceBilan1.add("BA");
        referrenceBilan1.add("BB");
        referrenceBilan1.add("BG");
        referrenceBilan1.add("BH");
        referrenceBilan1.add("BI");
        referrenceBilan1.add("BJ");
        referrenceBilan1.add("BK");
        referrenceBilan1.add("BQ");
        referrenceBilan1.add("BR");
        referrenceBilan1.add("BS");
        referrenceBilan1.add("BT");
        referrenceBilan1.add("BU");
        referrenceBilan1.add("BZ");
        
        List<String> referrenceBilan2 = new ArrayList<>();
        referrenceBilan2.add("REF");
        referrenceBilan2.add("REF");
        referrenceBilan2.add("CA");
        referrenceBilan2.add("CB");
        referrenceBilan2.add("CD");
        referrenceBilan2.add("CE");
        referrenceBilan2.add("CF");
        referrenceBilan2.add("CG");
        referrenceBilan2.add("CH");
        referrenceBilan2.add("CJ");
        referrenceBilan2.add("CL");
        referrenceBilan2.add("CM");
        referrenceBilan2.add("CP");
        referrenceBilan2.add("DA");
        referrenceBilan2.add("DB");
        referrenceBilan2.add("DC");
        referrenceBilan2.add("DD");
        referrenceBilan2.add("DF");
        referrenceBilan2.add("DH");
        referrenceBilan2.add("DI");
        referrenceBilan2.add("DJ");
        referrenceBilan2.add("DK");
        referrenceBilan2.add("DM");
        referrenceBilan2.add("DN");
        referrenceBilan2.add("DP");
        referrenceBilan2.add("");
        referrenceBilan2.add("DQ");
        referrenceBilan2.add("DR");
        referrenceBilan2.add("DT");
        referrenceBilan2.add("DV");
        referrenceBilan2.add("DZ");
       
        
        List<String> referrenceComptat1 = new ArrayList<>();
        referrenceComptat1.add("REF");
        referrenceComptat1.add("TA");
        referrenceComptat1.add("RA");
        referrenceComptat1.add("RB");
        referrenceComptat1.add("XA");
        referrenceComptat1.add("TB");
        referrenceComptat1.add("TC");
        referrenceComptat1.add("TD");
        referrenceComptat1.add("XB");
        referrenceComptat1.add("TE");
        referrenceComptat1.add("TF");
        referrenceComptat1.add("TG");
        referrenceComptat1.add("TH");
        referrenceComptat1.add("TI");
        referrenceComptat1.add("RC");
        referrenceComptat1.add("RD");
        referrenceComptat1.add("RE");
        referrenceComptat1.add("RF");
        referrenceComptat1.add("RG");
        referrenceComptat1.add("RH");
        referrenceComptat1.add("RI");
        referrenceComptat1.add("RJ");
        referrenceComptat1.add("XC");
        referrenceComptat1.add("RK");
        referrenceComptat1.add("XD");
        referrenceComptat1.add("TJ");
        referrenceComptat1.add("RL");
        referrenceComptat1.add("XE");
        referrenceComptat1.add("TK");
        referrenceComptat1.add("TL");
        referrenceComptat1.add("TM");
        referrenceComptat1.add("RM");
        referrenceComptat1.add("RN");
        referrenceComptat1.add("XF");
        referrenceComptat1.add("XG");
        referrenceComptat1.add("TN");
        referrenceComptat1.add("TO");
        referrenceComptat1.add("RO");
        referrenceComptat1.add("RP");
        referrenceComptat1.add("XH");
        referrenceComptat1.add("RQ");
        referrenceComptat1.add("RS");
        referrenceComptat1.add("XI");
        
        List<String> referrenceTresorerie1 = new ArrayList<>();
        referrenceTresorerie1.add("REF");
        referrenceTresorerie1.add("ZA");
        referrenceTresorerie1.add("");
        referrenceTresorerie1.add("FA");
        referrenceTresorerie1.add("FB");
        referrenceTresorerie1.add("FC");
        referrenceTresorerie1.add("FD");
        referrenceTresorerie1.add("FE");
        referrenceTresorerie1.add("");
        referrenceTresorerie1.add("ZB");
        referrenceTresorerie1.add("");
        referrenceTresorerie1.add("FF");
        referrenceTresorerie1.add("FG");
        referrenceTresorerie1.add("FH");
        referrenceTresorerie1.add("FI");
        referrenceTresorerie1.add("FJ");
        referrenceTresorerie1.add("ZC");
        referrenceTresorerie1.add("");
        referrenceTresorerie1.add("FK");
        referrenceTresorerie1.add("FL");
        referrenceTresorerie1.add("FM");
        referrenceTresorerie1.add("FN");
        referrenceTresorerie1.add("ZD");
        referrenceTresorerie1.add("");
        referrenceTresorerie1.add("FO");
        referrenceTresorerie1.add("FP");
        referrenceTresorerie1.add("FQ");
        referrenceTresorerie1.add("ZE");
        referrenceTresorerie1.add("ZF");
        referrenceTresorerie1.add("ZG");
        referrenceTresorerie1.add("XI");
       
        
        Map<String,Integer> ReferencePosteMap= new HashMap<String, Integer>();
        ReferencePosteMap.put("18", 1);
        ReferencePosteMap.put("20", 2);
        ReferencePosteMap.put("22", 3);
        ReferencePosteMap.put("24", 4);
        ReferencePosteMap.put("26", 5);
        ReferencePosteMap.put("28", 6);
        ReferencePosteMap.put("30", 7);
        ReferencePosteMap.put("32", 8);
        ReferencePosteMap.put("34", 9);
        ReferencePosteMap.put("36", 10);
        ReferencePosteMap.put("38", 11);
        ReferencePosteMap.put("40", 12);
        ReferencePosteMap.put("42", 13);
        ReferencePosteMap.put("44", 14);
        ReferencePosteMap.put("46", 15);
        ReferencePosteMap.put("48", 16);
        ReferencePosteMap.put("50", 17);
        ReferencePosteMap.put("52", 18);
        ReferencePosteMap.put("54", 19);
        ReferencePosteMap.put("56", 20);
        
        
        
        Map<String,Integer> ReferencePosteHorsBilanMap= new HashMap<String, Integer>();
       
        ReferencePosteHorsBilanMap.put("20", 1);
        ReferencePosteHorsBilanMap.put("22", 2);
        ReferencePosteHorsBilanMap.put("24", 3);
        ReferencePosteHorsBilanMap.put("29", 4);
        ReferencePosteHorsBilanMap.put("31", 5);
        ReferencePosteHorsBilanMap.put("33", 6);
       
       
        
        
        
        //Note 13
        
        
      
         //1111111111111111111111111111111111111111111111111111111111111111111111
         System.out.println("======> Debut verification excel  systeme Assurance");
         String fileLocation = filePath + fileName;
         FileInputStream excelFile = null;

         try {
             excelFile = new FileInputStream(new File(fileLocation));

             Workbook workbook = new XSSFWorkbook(excelFile);
             FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

             //Workbook workbook = com.monitorjbl.xlsx.StreamingReader.StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(excelFile));

             System.out.println("--> Nombre de page du document = [" + workbook.getNumberOfSheets() + "]");

             CellReference cellReference;
             Row rowCase;
             Cell cellCase;
             CellValue cellValue;
             
             CellReference cellReference2;
             Row rowCase2;
             Cell cellCase2;
             CellValue cellValue2;


             report = new Report();
             
             nombrePageExcel=workbook.getNumberOfSheets();

             //11111111
             PageGardeReport pageGardeReport = null;
             FicheRenseignementReport ficheRenseignementReport = null;
             ActiviteEntrepriseReport activiteEntrepriseReport = null;
             DirigeantsReport dirigeantsReport = null;
             BalanceReport balanceReport = null;
             BilanActifReport bilanActifReport = null;
             BilanPassifReport bilanPassifReport = null;
             HorsBilanReport horsBilanReport = null;
             CompteResultatReport compteResultatReport = null;
             FluxTresorerieReport fluxTresorerieReport = null;
             Note13 note13 = null;
             //22222222
             report.errorFormatExist=false;
             
             
             if(nombrePageExcel < 12) {
             	
             	report.observationFormat.add("Des feuilles/rubriques ont été supprimées");
             	report.errorFormatExist=true;
             	report.errorExist=true;
             	
               /* for(int i=nombrePageExcel;i<55;i++) {
          
             	report.listfeuillesManquantes.add(nomDesOnglet.get(i));
             	
             }*/
             	
             	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été supprimées");
               
             }
             
             else
             	
                 if(nombrePageExcel > 12)   //le nombre de ligne du fichier Excel
                 {
                 	report.observationFormat.add("Des feuilles/rubriques ont été ajoutées");
                 	report.errorFormatExist=true;
                 	report.errorExist=true;
                 	
                 	
                 	/*for(int i=(nombrePageExcel-1);i>=55;i--) {
                         
                 		Sheet datatypeSheet01 = workbook.getSheetAt(i);
                     	report.listfeuillesManquantes.add(datatypeSheet01.getSheetName());
                     	
                     }*/
                 	
                 	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été ajoutées");
                 	
                 	
                 	report.errorExist=true;
                 }
             
             else
             	
                   //le nombre de ligne du fichier Excel   if(nombrePageExcel==55)   
             {
             	
             	
            	/* for(int i=0;i<12;i++) {
            		 Sheet datatypeSheet = workbook.getSheetAt(i);   
            	  System.out.println("--> Onglet = [" + datatypeSheet.getSheetName() + "]");
            	 
            	 }*/
             	
             	//controle des nms des onglets
             	
             	
             	 for(int i=0;i<12;i++) {
             		 
             		 Sheet datatypeSheet02 = workbook.getSheetAt(i);   
             		 
             		 if(!datatypeSheet02.getSheetName().trim().equalsIgnoreCase(nomDesOnglet.get(i).trim())) {
             		 
             			 
          
                  	report.listongletsnomsModifies.add(datatypeSheet02.getSheetName());
                  	
                  	
                  	
                  	report.errorMaplistongletsnomsModifies.put(datatypeSheet02.getSheetName(), "Le mon de la feuille a éte modifié. L'appellation conforme est :"+nomDesOnglet.get(i));
                  	
             		 }
                  	
                  }
             	
        
             	 if(report.listongletsnomsModifies.size()>0) 
             	 {
             		
             		 
                  report.errorFormatExist=true;
             		 
             	report.observationFormat.add("Les noms de certaines rubriques ont été changés");
             	   
             	report.errorExist=true;
             		 
             		 
             	 }else {
             	
             		 

             	//Fin controle des noms onglets
             		 
             
             	
             //*** Debut verification page de garde
             	
             	
             	
             Sheet datatypeSheet = workbook.getSheetAt(0);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

              	
             
             //Centre de dépôt
             cellReference = new CellReference("B15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);

             //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if ( cellValue==null || (cellValue.getCellType() != CellType.STRING)) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setCentreDepotObservation("Information non renseignée");
                 pageGardeReport.setCentreDepotIsCorrect(false);
                 pageGardeReport.setCentreDepotCellule("B15");
             } else {
                 try {
                     if ((cellCase.getStringCellValue().split(":")[1] != null) && (!cellCase.getStringCellValue().split(":")[1].trim().equalsIgnoreCase(""))) {
                     } else {
                         if (pageGardeReport == null) {
                             pageGardeReport = new PageGardeReport();
                             report.setErrorExist(true);
                         }
                         pageGardeReport.setCentreDepotObservation("Information non renseignée");
                         pageGardeReport.setCentreDepotIsCorrect(false);
                         pageGardeReport.setCentreDepotCellule("B15");
                     }
                 } catch (Exception ie) {
                     if (pageGardeReport == null) {
                         pageGardeReport = new PageGardeReport();
                         report.setErrorExist(true);
                     }
                     pageGardeReport.setCentreDepotObservation("Information non renseignée");
                     pageGardeReport.setCentreDepotIsCorrect(false);
                     pageGardeReport.setCentreDepotCellule("B15");
                 }
             }

             //Exercice clos
             cellReference = new CellReference("M25");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
             //System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");

             if(cellValue==null) {
             
             	 if (pageGardeReport == null) {
                      pageGardeReport = new PageGardeReport();
                      report.setErrorExist(true);
                  }
                  pageGardeReport.setExerciceClosObservation("Information non renseignée");
                  pageGardeReport.setExerciceClosIsCorrect(false);
                  pageGardeReport.setExerciceClosCellule("M25");
             	
             	
             }
             else
                 if (cellValue.getCellType() == CellType.STRING || cellValue.getCellType() == CellType.NUMERIC) {

                 	 try {
                          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                          DataFormatter dataFormatter = new DataFormatter();
                          
                          Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                         
                          date.getTime();
                          
                          exerciceValue = dataFormatter.formatCellValue(cellCase);
                      } catch (Exception e) {
                          e.printStackTrace();
                         
                          if (pageGardeReport == null) {
                              pageGardeReport = new PageGardeReport();
                              report.setErrorExist(true);
                          }
                          pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                         
                          pageGardeReport.setExerciceClosCellule("M25");
                          pageGardeReport.setExerciceClosIsCorrect(false);
                          
                      }
                 	
                 }
             /*else
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {

                 //gestion avancee de la date
                 try {
                     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                     DataFormatter dataFormatter = new DataFormatter();
                     Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                     date.getTime();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                 pageGardeReport.setExerciceClosIsCorrect(false);
                 pageGardeReport.setExerciceClosCellule("M25");
                 
             }*/ else {
                 DataFormatter df = new DataFormatter();
                 exerciceValue = df.formatCellValue(cellCase);
             }
             
             

             //Denomination sociale
             cellReference = new CellReference("L33");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             //System.out.println("[ligne L33 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             
             
             
             
             if (cellCase.getCellType() != CellType.STRING) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setDenominationSocialeObservation("Information non renseignée");
                 pageGardeReport.setDenominationSocialeIsCorrect(false);
                 pageGardeReport.setDenominationSocialeCellule("L33");
                 
             } else {
                 designationValue = cellCase.getStringCellValue();
             }

             //Adresse
             cellReference = new CellReference("J44");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setAdresseObservation("Information non renseignée");
                 pageGardeReport.setAdresseIsCorrect(false);
                 pageGardeReport.setAdresseCellule("J44");
             } else {
                 adresseValue = cellCase.getStringCellValue();
             }

             //Identification fiscal
             cellReference = new CellReference("N49");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne N49 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());

             if (cellCase.getCellType() != CellType.STRING) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setIdFiscaleObservation("Information non renseignée");
                 pageGardeReport.setIdFiscaleIsCorrect(false);
                 pageGardeReport.setIdFiscaleCellule("N49");
             } else {
                 numIdentificationValue = cellCase.getStringCellValue();
             }

             //Recuperation sigleValue header
             cellReference = new CellReference("H39");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne H39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.STRING) {
                 sigleValue = cellCase.getStringCellValue();
             }

////             //Recuperation exerciceValue header
////             cellReference = new CellReference("B25");
////             rowCase = datatypeSheet.getRow(cellReference.getRow());
////             cellCase = rowCase.getCell(cellReference.getCol());
////             System.out.println("[ligne B25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
////             if (cellCase.getCellType() == CellType.STRING) {
////                 exerciceValue = cellCase.getStringCellValue();
////             }

             if (pageGardeReport != null) {
                 report.setPageGardeReport(pageGardeReport);
             }
             
             
             //*** Fin verification page de garde

             //*** Debut verification fiche renseignement
             datatypeSheet = workbook.getSheetAt(1);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

             /* ??
             //Centre de dépôt
             cellReference = new CellReference("B15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setCentreDepotObservation("Information non renseignée");
                 ficheRenseignementReport.setCentreDepotIsCorrect(false);
             }
             */

             //Exercice clos
             try {
                 cellReference = new CellReference("V9");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne V9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getCachedFormulaResultType());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println(cellValue.getCellType());
                
                 
                 if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                     if (ficheRenseignementReport == null) {
                         ficheRenseignementReport = new FicheRenseignementReport();
                         report.setErrorExist(true);
                     }
                     ficheRenseignementReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                     ficheRenseignementReport.setExerciceClosIsCorrect(false);
                     ficheRenseignementReport.setExerciceClosCellule("V9");
                 }
             } catch (Exception ie) {// driver not found
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceClosObservation("Information non renseignée");
                 ficheRenseignementReport.setExerciceClosIsCorrect(false);
                 ficheRenseignementReport.setExerciceClosCellule("V9");
             }

             /*??
             //Denomination sociale
             cellReference = new CellReference("B15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDenominationSocialeObservation("Information non renseignée");
                 ficheRenseignementReport.setDenominationSocialeIsCorrect(false);
             }
             */

             //Adress
             cellReference = new CellReference("J6");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne J6 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             cellValue = evaluator.evaluate(cellCase);
             System.out.println(cellValue.getCellType());
             
             if (cellValue.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setAdresseObservation("Information non renseignée");
                 ficheRenseignementReport.setAdresseIsCorrect(false);
                 ficheRenseignementReport.setAdresseCellule("J6");
             }

             //Id fiscal
             try {
                 cellReference = new CellReference("J9");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne J9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
                 if (cellCase.getCellType() == CellType.BLANK) {
                     if (ficheRenseignementReport == null) {
                         ficheRenseignementReport = new FicheRenseignementReport();
                         report.setErrorExist(true);
                     }
                     ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée");
                     ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                     ficheRenseignementReport.setIdFiscaleCellule("J6");
                 }
             } catch (Exception ie) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setIdFiscaleObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                 ficheRenseignementReport.setIdFiscaleCellule("J6");
             }

             //Exerice comptable debut
             cellReference = new CellReference("Y12");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne Y12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             cellValue = evaluator.evaluate(cellCase);
             
             if(cellValue==null) 
             {
            	 
            	 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("Y12");
            	 
             } else
             
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("Y12");
             }
             

             //Exerice comptable fin
             cellReference = new CellReference("AH12");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
            // System.out.println(cellValue.getCellType());
             
             if(cellValue==null) 
             {
            	
            	 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("AH12");
            	 
             } else
             
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("AH12");
             }

             //Date arret compte
             try {
                 cellReference = new CellReference("U15");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne U15 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getCachedFormulaResultType());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println(cellValue.getCellType());
                 if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                     if (ficheRenseignementReport == null) {
                         ficheRenseignementReport = new FicheRenseignementReport();
                         report.setErrorExist(true);
                     }
                     ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée ");
                     ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                     ficheRenseignementReport.setDateArreteComptesCellule("U15");
                 }
             } catch (Exception ie) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDateArreteComptesObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                 ficheRenseignementReport.setDateArreteComptesCellule("U15");
             }

             //Greffe
             cellReference = new CellReference("F23");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne F23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
//             if (cellCase.getCellType() != CellType.STRING) {
//                 if (ficheRenseignementReport == null) {
//                     ficheRenseignementReport = new FicheRenseignementReport();
//                     report.setErrorExist(true);
//                 }
//                 ficheRenseignementReport.setGreffeObservation("Information non renseignée");
//                 ficheRenseignementReport.setGreffeIsCorrect(false);
//             }

             //Num registre commerce
             cellReference = new CellReference("I23");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne I23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setNumRegistreCommerceObservation("Information non renseignée");
                 ficheRenseignementReport.setNumRegistreCommerceIsCorrect(false);
                 ficheRenseignementReport.setNumRegistreCommerceCellule("I23");
             }

             //Num Securite Sociale
             cellReference = new CellReference("G27");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//             if (cellCase.getCellType() == CellType.BLANK) {
//                 if (ficheRenseignementReport == null) {
//                     ficheRenseignementReport = new FicheRenseignementReport();
//                     report.setErrorExist(true);
//                 }
//                 ficheRenseignementReport.setNumSecuriteSocialeObservation("Information non renseignée");
//                 ficheRenseignementReport.setNumSecuriteSocialeIsCorrect(false);
//             }

             //Designation Entreprise
             //1
             cellReference = new CellReference("J3");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne J3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
                 ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
                 ficheRenseignementReport.setDesignationEntrepriseCellule("J3");
                 
             }
             //2
             cellReference = new CellReference("D31");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
                 ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
                 ficheRenseignementReport.setDesignationEntrepriseCellule("D31");
             }

             //Telephone
             cellReference = new CellReference("G35");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if ((cellCase.getCellType() != CellType.STRING) && (cellCase.getCellType() != CellType.NUMERIC)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setNumTelephoneObservation("Information non renseignée");
                 ficheRenseignementReport.setNumTelephoneIsCorrect(false);
                 ficheRenseignementReport.setNumTelephoneCellule("G35");
             }

             //Ville
             cellReference = new CellReference("AE35");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne AE35 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setVilleObservation("Information non renseignée");
                 ficheRenseignementReport.setVilleIsCorrect(false);
                 ficheRenseignementReport.setVilleCellule("AE35");
             }

             //Adresse Geographique
             cellReference = new CellReference("D39");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setAdresseGeographiqueObservation("Information non renseignée");
                 ficheRenseignementReport.setAdresseGeographiqueIsCorrect(false);
                 ficheRenseignementReport.setAdresseGeographiqueCellule("D39");
             }

             //Designation Activite Exercee
             cellReference = new CellReference("D43");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D43 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDesignationActiviteExerceeObservation("Information non renseignée");
                 ficheRenseignementReport.setDesignationActiviteExerceeIsCorrect(false);
                 ficheRenseignementReport.setDesignationActiviteExerceeCellule("D43");
             }

             //Personne A Contacter
             cellReference = new CellReference("D47");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D47 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setPersonneAContacterObservation("Information non renseignée");
                 ficheRenseignementReport.setPersonneAContacterIsCorrect(false);
                 ficheRenseignementReport.setPersonneAContacterCellule("D47");
             }

             //Professionnel Ou Cabinet Comptable AuteurEF
             cellReference = new CellReference("D51");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFObservation("Information non renseignée");
                 ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFIsCorrect(false);
                 ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFCellule("D51");
             }

             //Commissaire Au Compte
             cellReference = new CellReference("D55");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
//             if (cellCase.getCellType() != CellType.STRING) {
//                 if (ficheRenseignementReport == null) {
//                     ficheRenseignementReport = new FicheRenseignementReport();
//                     report.setErrorExist(true);
//                 }
//                 ficheRenseignementReport.setCommissaireAuCompteObservation("Information non renseignée");
//                 ficheRenseignementReport.setCommissaireAuCompteIsCorrect(false);
//             }

             //Qualite du Signataire
             cellReference = new CellReference("D71");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setQualiteDuSignataireObservation("Information non renseignée");
                 ficheRenseignementReport.setQualiteDuSignataireIsCorrect(false);
                 ficheRenseignementReport.setQualiteDuSignataireCellule("D71");
                 
             }

             //Date Signature
             cellReference = new CellReference("D74");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D74 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.NUMERIC) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDateSignatureObservation("Information non renseignée");
                 ficheRenseignementReport.setDateSignatureIsCorrect(false);
                 ficheRenseignementReport.setDateSignatureCellule("D74");
             }

             //Banque
             String [] cellulesBanques = {"T70", "T71", "T72"}  ; // tableau de cellules à verifier
             Boolean isEmptyName = true;
             for(int i=0; i<cellulesBanques.length; i++) {
                 cellReference = new CellReference(cellulesBanques[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if (cellCase.getCellType() == CellType.STRING) {
                 	isEmptyName = false ;
                     break;
                 }
                }
             if(isEmptyName) {
             	
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                 /*ficheRenseignementReport.setBanqueObservation("Nom banque non renseignée");
                 ficheRenseignementReport.setBanqueIsCorrect(false);*/
                 
                 ficheRenseignementReport.errorMap.put("Banque(s)", "Nom banque non renseignée");
                 ficheRenseignementReport.errorCelluleMap.put("Banque(s)", "Cellule[T70-T71-T72]");
            		
                 
                 
                 
             }
             //Numero
             String [] cellulesNumero = {"AD70", "AD71", "AD72"}  ; // tableau de cellules à verifier
             Boolean isEmptyNumero  = true ;
             for(int i=0; i<cellulesNumero.length; i++) {
                 cellReference = new CellReference(cellulesNumero[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getStringCellValue());

                 if (cellCase.getCellType() == CellType.STRING) {
                 	isEmptyNumero = false ;
                     break;
                 }

             }
             if (isEmptyNumero) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 
                 /*ficheRenseignementReport.setNumeroObservation("compte bancaire non renseignée");
                 ficheRenseignementReport.setNumeroIsCorrect(false);*/
                 
                 ficheRenseignementReport.errorMap.put("Numéro(s)", "Compte bancaire non renseignée");
                 ficheRenseignementReport.errorCelluleMap.put("Numéro(s)", "Cellule[AD70-AD71-AD72]");
                 
             }
             
             //FIn  bank
             if (ficheRenseignementReport != null) {
                 report.setFicheRenseignementReport(ficheRenseignementReport);
             }
             //*** Fin verification fiche renseignement

             
             //debut de verification bilan actif
             
             
            //Debut bilan
             datatypeSheet = workbook.getSheetAt(2);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
             
             
             
             boolean    nombreColonneOk=true;
             
             cellReference = new CellReference("E7");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
             
                  if(cellValue==null) {
                  	 nombreColonneOk=false;
                  	
                  } else
                if (cellValue.getCellType() == CellType.BLANK) 
                {
              	  nombreColonneOk=false;
              }
                else
          	   if (cellValue.getCellType() == CellType.STRING) 
          	   {
          		   
          		   if(cellValue.getStringValue().equalsIgnoreCase("Montant net")) 
          		   {
          			   nombreColonneOk=true;
          			   
          		   }
          		   else
          		   {
          			   nombreColonneOk=false;
          		   }
          		   
          		   
          	   }else
          	   {
          		   nombreColonneOk=false;  
          		   
          	   }
          	   
          	   
        System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
            
            
        if(!nombreColonneOk) 
        {
        	
      	  if (bilanActifReport == null) {
      		bilanActifReport = new BilanActifReport();
                report.setErrorExist(true);
            }
      	  
      	bilanActifReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
   		
        	
        } else {
        	
        	
 // Fin Gestion du nombre de ligne
            
            
        	
     boolean    nombreLigneOk=true;
             
             cellReference = new CellReference("A54");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
             
                  if(cellValue==null) {
                	  nombreLigneOk=false;
                  	
                  } else
                if (cellValue.getCellType() == CellType.BLANK) 
                {
                	nombreLigneOk=false;
              }
                else
          	   if (cellValue.getCellType() == CellType.STRING) 
          	   {
          		   
          		   if(cellValue.getStringValue().equalsIgnoreCase("09. Autres valeurs detenues par l'entreprise")) 
          		   {
          			 nombreLigneOk=true;
          			   
          		   }
          		   else
          		   {
          			 nombreLigneOk=false;
          		   }
          		   
          		   
          	   }else
          	   {
          		 nombreLigneOk=false;  
          		   
          	   }
          	   
          	   
        System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     
            
        	
        
        
        
        	
         
            if (!nombreLigneOk) {
            	
            	if (bilanActifReport == null) {
              		bilanActifReport = new BilanActifReport();
                        report.setErrorExist(true);
                    }
              	  
              	bilanActifReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
           		
            	
                
            }else {
            	
            	
            	
            	
            	for (int index=8 ;index<=54;index++) 
                {
              	  
            		
            		
              	 // Debut cellule C
            		
            		if ((index!=53) && (index!=54) ) {
              	  
              	  cellReference = new CellReference("C"+index); 
              	  
              	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                    cellCase = rowCase.getCell(cellReference.getCol());
                    cellValue = evaluator.evaluate(cellCase);
                    
                     
                    if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                    {
                  	  
                  	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
                  	  
                  	  if (bilanActifReport == null) {
                  		bilanActifReport = new BilanActifReport();
                            report.setErrorExist(true);
                        }
                  	  
                  	  String nomCellule="[" +"C"+index+ "]";
                  	  
                  	  cellReference = new CellReference("A"+index); 
                  	  
                  	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                        cellCase = rowCase.getCell(cellReference.getCol());
                        cellValue = evaluator.evaluate(cellCase);
                        
                        
                        if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                        {
                      	  nomCellule=cellValue.getStringValue();
                      	 
                      	  
                        }
                  	  

                  	  
                        bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                        bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
                  	  
                  	  
                    }
                    
            		}
                 // Fin cellule C
                    
                    
                    
                  // Debut cellule D
              	  
              	  cellReference = new CellReference("D"+index); 
              	  
              	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                    cellCase = rowCase.getCell(cellReference.getCol());
                    cellValue = evaluator.evaluate(cellCase);
                    
                     
                    if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                    {
                  	  
                  	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                  	  
                  	  if (bilanActifReport == null) {
                  		bilanActifReport = new BilanActifReport();
                            report.setErrorExist(true);
                        }
                  	  
                  	  
                      String nomCellule="[" +"D"+index+ "]";
                  	  
                  	  cellReference = new CellReference("A"+index); 
                  	  
                  	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                        cellCase = rowCase.getCell(cellReference.getCol());
                        cellValue = evaluator.evaluate(cellCase);
                        
                        
                        if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                        {
                      	  nomCellule=cellValue.getStringValue();
                      	 
                      	  
                        }
                  	  
                  	  
                  	  
                  	  
                        bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                        bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
                  	  
                  	  
                    }
                    
                   // Fin cellule D
                    
                    
                    
                    
                 // Debut cellule E
                	  
                	  cellReference = new CellReference("E"+index); 
                	  
                	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                      cellCase = rowCase.getCell(cellReference.getCol());
                      cellValue = evaluator.evaluate(cellCase);
                      
                       
                      if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                      {
                    	  
                    	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                    	  
                    	  if (bilanActifReport == null) {
                    		bilanActifReport = new BilanActifReport();
                              report.setErrorExist(true);
                          }
                    	  
                    	  
                        String nomCellule="[" +"E"+index+ "]";
                    	  
                    	  cellReference = new CellReference("A"+index); 
                    	  
                    	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                          cellCase = rowCase.getCell(cellReference.getCol());
                          cellValue = evaluator.evaluate(cellCase);
                          
                          
                          if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                          {
                        	  nomCellule=cellValue.getStringValue();
                        	 
                        	  
                          }
                    	  
                    	  
                    	  
                    	  
                          bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                          bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"E"+index+ "]");
                    	  
                    	  
                      }
                      else 
                      {
                      	
                      	if(index==50)
                      	{
                      		
                      		if ((cellValue!=null) &&(cellValue.getCellType() == CellType.NUMERIC))
                              {
                            	  
                      			resultatNet =cellValue.getNumberValue()+"";	
                              }
                      		
                      		
                      	}
                      	
                      	
                      	
                      	if(index==51)
                      	{
                      		
                      		if ((cellValue!=null) &&(cellValue.getCellType() == CellType.NUMERIC))
                              {
                      			chiffreAffaire=cellValue.getNumberValue()+"";	
                              }
                      		
                      		
                      	}
                      	
                      }

                      
                     // Fin cellule E
                    
                    
                    
                    
                    
                    
                    
                }
                
                
                
            	
            	
            }
        	
        	
        	
        	
        }  //Fin de tester nombre de ligne bilan actif
             

    	if (bilanActifReport != null) {
            report.setBilanActifReport(bilanActifReport);
        }
        //*** Fin bilan
    	  
             
             
       //Fin Verification Bilan actif
    	
    	
    	
    	//debut verification bilan passif
    	
    	
    	
    	//Debut bilan
        datatypeSheet = workbook.getSheetAt(3);
        System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
        System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
        
        
        
         nombreColonneOk=true;
        
        cellReference = new CellReference("D2");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);
        
             if(cellValue==null) {
             	 nombreColonneOk=false;
             	
             } else
           if (cellValue.getCellType() == CellType.BLANK) 
           {
         	  nombreColonneOk=false;
         }
           else
     	   if (cellValue.getCellType() == CellType.STRING) 
     	   {
     		   
     		   if(cellValue.getStringValue().equalsIgnoreCase("Exercice :")) 
     		   {
     			   nombreColonneOk=true;
     			   
     		   }
     		   else
     		   {
     			   nombreColonneOk=false;
     		   }
     		   
     		   
     	   }else
     	   {
     		   nombreColonneOk=false;  
     		   
     	   }
     	   
     	   
   System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
       
       
   if(!nombreColonneOk) 
   {
   	
 	  if (bilanPassifReport == null) {
 		 bilanPassifReport = new BilanPassifReport();
           report.setErrorExist(true);
       }
 	  
 	bilanPassifReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
		
   	
   } else {
   	
   	
// Fin Gestion du nombre de ligne
       
       
   	
boolean    nombreLigneOk=true;
        
        cellReference = new CellReference("A61");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);
        
             if(cellValue==null) {
           	  nombreLigneOk=false;
             	
             } else
           if (cellValue.getCellType() == CellType.BLANK) 
           {
           	nombreLigneOk=false;
         }
           else
     	   if (cellValue.getCellType() == CellType.STRING) 
     	   {
     		   
     		   if(cellValue.getStringValue().equalsIgnoreCase("09. Engagements de restitution des autres valeurs détenues appartenant à des tiers")) 
     		   {
     			 nombreLigneOk=true;
     			   
     		   }
     		   else
     		   {
     			 nombreLigneOk=false;
     		   }
     		   
     		   
     	   }else
     	   {
     		 nombreLigneOk=false;  
     		   
     	   }
     	   
     	   
   System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     
       
   	
   
   
   
   	
    
       if (!nombreLigneOk) {
       	
       	if (bilanPassifReport == null) {
       		bilanPassifReport = new BilanPassifReport();
                   report.setErrorExist(true);
               }
         	  
       	bilanPassifReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
      		
       	
           
       }else {
       	
       	
       	
       	
       	for (int index=6 ;index<=61;index++) 
           {
         	  
         	 // Debut cellule D
       		
       if((index!=58) &&(index!=59) &&(index!=60)&&(index!=61)) {
         	  
         	  cellReference = new CellReference("D"+index); 
         	  
         	  rowCase = datatypeSheet.getRow(cellReference.getRow());
               cellCase = rowCase.getCell(cellReference.getCol());
               cellValue = evaluator.evaluate(cellCase);
               
                
               if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
               {
             	  
             	  System.out.println("erreur de format[" +"D"+index+ "]  "+ cellValue  +"--");
             	  
             	  if (bilanPassifReport == null) {
             		 bilanPassifReport = new BilanPassifReport();
                       report.setErrorExist(true);
                   }
             	  
             	  String nomCellule="[" +"D"+index+ "]";
             	  
             	  cellReference = new CellReference("A"+index); 
             	  
             	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                   cellCase = rowCase.getCell(cellReference.getCol());
                   cellValue = evaluator.evaluate(cellCase);
                   
                   
                   if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                   {
                 	  nomCellule=cellValue.getStringValue();
                 	 
                 	  
                   }
             	  

             	  
                   bilanPassifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                   bilanPassifReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
             	  
             	  
               }
               
       		}
               
            // Fin cellule D
               
               
               
             // Debut cellule E
         	  
         	  cellReference = new CellReference("E"+index); 
         	  
         	  rowCase = datatypeSheet.getRow(cellReference.getRow());
               cellCase = rowCase.getCell(cellReference.getCol());
               cellValue = evaluator.evaluate(cellCase);
               
                
               if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
               {
             	  
             	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
             	  
             	  if (bilanPassifReport == null) {
             		 bilanPassifReport = new BilanPassifReport();
                       report.setErrorExist(true);
                   }
             	  
             	  
                 String nomCellule="[" +"E"+index+ "]";
             	  
             	  cellReference = new CellReference("A"+index); 
             	  
             	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                   cellCase = rowCase.getCell(cellReference.getCol());
                   cellValue = evaluator.evaluate(cellCase);
                   
                   
                   if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                   {
                 	  nomCellule=cellValue.getStringValue();
                 	 
                 	  
                   }
             	  
             	  
             	  
             	  
                   bilanPassifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                   bilanPassifReport.errorCelluleMap.put(nomCellule, "[" +"E"+index+ "]");
             	  
             	  
               }
               
              // Fin cellule E
               
               
               
           }
           
           
           
           
       	
       	
       }
   	
   	
   	
   	
   }  //Fin de tester nombre de ligne bilan actif
        

	if (bilanPassifReport!= null) {
       report.setBilanPassifReport(bilanPassifReport);
   }
   //*** Fin bilan
	  
    	
    	
    	
    	
    	//Fin verification bilan passif
	
	
	
	//Bebut de verification hors bilan
	
	
	
	
    	
 


             
             }  //fin nombre de page
             
             }
             
             if (report.errorExist) {
                 HeaderReport headerReport = new HeaderReport();

                 headerReport.setDesignationValue(designationValue);
                 headerReport.setAdresseValue(adresseValue);
                 headerReport.setNumIdentificationValue(numIdentificationValue);
                 headerReport.setSigleValue(sigleValue);
                 headerReport.setExerciceValue(exerciceValue);

                 report.setHeaderReport(headerReport);
             } else {
                 ExcelData excelData = new ExcelData();

                 excelData.setEntreprise(designationValue);
                 excelData.setNinea(numIdentificationValue);
                 excelData.setTotalBilan(totalBilan);
                 excelData.setCapitalPropre(capitalPropre);
                 excelData.setResultatNet(resultatNet);
                 excelData.setChiffreAffaire(chiffreAffaire);
                 
                 
                 System.out.println("chiffreAffaire------------------------>"+chiffreAffaire);
                 System.out.println("resultatNet------------------------>"+resultatNet);
                 

                 report.setExcelData(excelData);
             }

             //String reportFileName = "Rapport de conformité_test.xlsx";
             excelFile.close();
             createReport(report, filePath, rapportFileName);
         } catch (Exception e) {
             report = null;
             System.out.println("xxxxxxx");
             e.printStackTrace();
             System.out.println("yyyyyyy");


         } finally {

             try {
                 // He was careful to close streams in finally block, but it’s not complete
                 // Can you spot error?

                 if (excelFile != null)
                     excelFile.close();

             } catch (IOException e) {
                 System.out.println("Failed to close streams");
             }

         }

         System.out.println("======> Fin verification excel");
         //2222222222222222222222222222222222222222222222222222222222222222222222

         return report;
 		 
 		 
 	    }
 	        
             	
 	
 	//Fin de la gestion du depot Assurance
 	 
 	 
 	 
 	 //Gestion du systeme SMT
 	 
 	 
 public static Report verifyExcelSMT(String filePath, String fileName, String rapportFileName,String formJuridique) {
 		
 		 
 		 Report report = null;
         String designationValue = "";
         String adresseValue = "";
         String numIdentificationValue = "";
         String sigleValue = "";
         String exerciceValue = "";

         String totalBilan = "";//Bilan paysage : F31
         String capitalPropre = "";//Bilan paysage : 
         String resultatNet = "";//Compte resultat : C31  new 
         String chiffreAffaire = "";//Compte resultat : C14  new
         
         int nombrePageExcel=0;
         double total=0;
         
        List<String> nomDesOnglet = new ArrayList<>();
        nomDesOnglet.add("IDENTIFICATION");
        nomDesOnglet.add("FICHE DE DEPOT");
        nomDesOnglet.add("CONDITIONS DE RECEVABILITE");
        nomDesOnglet.add("TABLE DES CODES");
        nomDesOnglet.add("CODE DES ACTIVITES");
        nomDesOnglet.add("FICHE DE RENSEIGNEMENT R1");
        nomDesOnglet.add("ACTIVITES DE L'ENTREPRISE R2");
        nomDesOnglet.add("FICHE DIRIGEANTS");
        nomDesOnglet.add("INFORMATIONS OBLIGATOIRES");
        nomDesOnglet.add("BILAN SMT");
        nomDesOnglet.add("CPTE DE RESULTAT SMT");
        nomDesOnglet.add("SUIVI MAT MOB ET CAUT");
        nomDesOnglet.add("ETAT DES STOCKS");
        nomDesOnglet.add("ETAT DES DETTES ET DES CREANCES");
        nomDesOnglet.add("JOURNAL DE TRESORERIE");
        nomDesOnglet.add("JOURNAL DES CREANCES IMP");
        nomDesOnglet.add("JOURNAL DES DETTES A PAYER");
        
        
        
       
        
        Map<String,Integer> ReferencePosteHorsBilanMap= new HashMap<String, Integer>();
       
        ReferencePosteHorsBilanMap.put("20", 1);
        ReferencePosteHorsBilanMap.put("22", 2);
        ReferencePosteHorsBilanMap.put("24", 3);
        ReferencePosteHorsBilanMap.put("29", 4);
        ReferencePosteHorsBilanMap.put("31", 5);
        ReferencePosteHorsBilanMap.put("33", 6);
       
       
        
        
        
        //Note 13
        
        
      
         //1111111111111111111111111111111111111111111111111111111111111111111111
         System.out.println("======> Debut verification excel  systeme minimal ");
         String fileLocation = filePath + fileName;
         FileInputStream excelFile = null;

         try {
             excelFile = new FileInputStream(new File(fileLocation));

             Workbook workbook = new XSSFWorkbook(excelFile);
             FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

             //Workbook workbook = com.monitorjbl.xlsx.StreamingReader.StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(excelFile));

             System.out.println("--> Nombre de page du document = [" + workbook.getNumberOfSheets() + "]");

             CellReference cellReference;
             Row rowCase;
             Cell cellCase;
             CellValue cellValue;
             
             CellReference cellReference2;
             Row rowCase2;
             Cell cellCase2;
             CellValue cellValue2;


             report = new Report();
             
             nombrePageExcel=workbook.getNumberOfSheets();

             //11111111
             PageGardeReport pageGardeReport = null;
             FicheRenseignementReport ficheRenseignementReport = null;
             ActiviteEntrepriseReport activiteEntrepriseReport = null;
             DirigeantsReport dirigeantsReport = null;
             BalanceReport balanceReport = null;
             BilanActifReport bilanActifReport = null;
             BilanPassifReport bilanPassifReport = null;
             HorsBilanReport horsBilanReport = null;
             CompteResultatReport compteResultatReport = null;
             FluxTresorerieReport fluxTresorerieReport = null;
             Note13 note13 = null;
             //22222222
             report.errorFormatExist=false;
             
             
             if(nombrePageExcel < 17) {
             	
             	report.observationFormat.add("Des feuilles/rubriques ont été supprimées");
             	report.errorFormatExist=true;
             	report.errorExist=true;
             	
               /* for(int i=nombrePageExcel;i<55;i++) {
          
             	report.listfeuillesManquantes.add(nomDesOnglet.get(i));
             	
             }*/
             	
             	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été supprimées");
               
             }
             
             else
             	
                 if(nombrePageExcel > 17)   //le nombre de ligne du fichier Excel
                 {
                 	report.observationFormat.add("Des feuilles/rubriques ont été ajoutées");
                 	report.errorFormatExist=true;
                 	report.errorExist=true;
                 	
                 	
                 	/*for(int i=(nombrePageExcel-1);i>=55;i--) {
                         
                 		Sheet datatypeSheet01 = workbook.getSheetAt(i);
                     	report.listfeuillesManquantes.add(datatypeSheet01.getSheetName());
                     	
                     }*/
                 	
                 	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été ajoutées");
                 	
                 	
                 	report.errorExist=true;
                 }
             
             else
             	
                   //le nombre de ligne du fichier Excel   if(nombrePageExcel==55)   
             {
             	
             
            	 /*for(int i=0;i<17;i++) {
            		 Sheet datatypeSheet = workbook.getSheetAt(i);   
            	  System.out.println("--> Onglet = [" + datatypeSheet.getSheetName() + "]");
            	 
            	 }
             	*/
             	//controle des nms des onglets
             	
             	
             	 for(int i=0;i<17;i++) {
             		 
             		 Sheet datatypeSheet02 = workbook.getSheetAt(i);   
             		 
             		 if(!datatypeSheet02.getSheetName().equals(nomDesOnglet.get(i))) {
             		 
             			 
          
                  	report.listongletsnomsModifies.add(datatypeSheet02.getSheetName());
                  	
                  	
                  	
                  	report.errorMaplistongletsnomsModifies.put(datatypeSheet02.getSheetName(), "Le mon de la feuille a éte modifié. L'appellation conforme est :"+nomDesOnglet.get(i));
                  	
             		 }
                  	
                  }
             	
        
             	 if(report.listongletsnomsModifies.size()>0) 
             	 {
             		
             		 
                  report.errorFormatExist=true;
             		 
             	report.observationFormat.add("Les noms de certaines rubriques ont été changés");
             	   
             	report.errorExist=true;
             		 
             		 
             	 }else {
             	
             		 

             	//Fin controle des noms onglets
             		 
             
             	
             //*** Debut verification page de garde
             	
             	
             	
             Sheet datatypeSheet = workbook.getSheetAt(1);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

              	
             
             //Centre de dépôt
             cellReference = new CellReference("B15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);

             //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellValue ==null || (cellValue.getCellType() != CellType.STRING)) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setCentreDepotObservation("Information non renseignée");
                 pageGardeReport.setCentreDepotIsCorrect(false);
                 pageGardeReport.setCentreDepotCellule("B15");
             } else {
                 try {
                     if ((cellCase.getStringCellValue().split(":")[1] != null) && (!cellCase.getStringCellValue().split(":")[1].trim().equalsIgnoreCase(""))) {
                     } else {
                         if (pageGardeReport == null) {
                             pageGardeReport = new PageGardeReport();
                             report.setErrorExist(true);
                         }
                         pageGardeReport.setCentreDepotObservation("Information non renseignée");
                         pageGardeReport.setCentreDepotIsCorrect(false);
                         pageGardeReport.setCentreDepotCellule("B15");
                     }
                 } catch (Exception ie) {
                     if (pageGardeReport == null) {
                         pageGardeReport = new PageGardeReport();
                         report.setErrorExist(true);
                     }
                     pageGardeReport.setCentreDepotObservation("Information non renseignée");
                     pageGardeReport.setCentreDepotIsCorrect(false);
                     pageGardeReport.setCentreDepotCellule("B15");
                 }
             }

             //Exercice clos
             cellReference = new CellReference("M25");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
             //System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");

             if(cellValue==null) {
             
             	 if (pageGardeReport == null) {
                      pageGardeReport = new PageGardeReport();
                      report.setErrorExist(true);
                  }
                  pageGardeReport.setExerciceClosObservation("Information non renseignée");
                  pageGardeReport.setExerciceClosIsCorrect(false);
                  pageGardeReport.setExerciceClosCellule("M25");
             	
             	
             }
             else
                 if (cellValue.getCellType() == CellType.STRING || cellValue.getCellType() == CellType.NUMERIC) {

                 	 try {
                          SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                          DataFormatter dataFormatter = new DataFormatter();
                          
                          Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                         
                          date.getTime();
                          
                          exerciceValue = dataFormatter.formatCellValue(cellCase);
                      } catch (Exception e) {
                          e.printStackTrace();
                         
                          if (pageGardeReport == null) {
                              pageGardeReport = new PageGardeReport();
                              report.setErrorExist(true);
                          }
                          pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                         
                          pageGardeReport.setExerciceClosCellule("M25");
                          pageGardeReport.setExerciceClosIsCorrect(false);
                          
                      }
                 	
                 }
             /*else
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {

                 //gestion avancee de la date
                 try {
                     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                     DataFormatter dataFormatter = new DataFormatter();
                     Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                     date.getTime();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                 pageGardeReport.setExerciceClosIsCorrect(false);
                 pageGardeReport.setExerciceClosCellule("M25");
                 
             } */
             
             else {
                 DataFormatter df = new DataFormatter();
                 exerciceValue = df.formatCellValue(cellCase);
             }
             
             

             //Denomination sociale
             cellReference = new CellReference("L33");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             //System.out.println("[ligne L33 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             
             
             
             
             if (cellCase.getCellType() != CellType.STRING) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setDenominationSocialeObservation("Information non renseignée");
                 pageGardeReport.setDenominationSocialeIsCorrect(false);
                 pageGardeReport.setDenominationSocialeCellule("L33");
                 
             } else {
                 designationValue = cellCase.getStringCellValue();
             }

             //Adresse
             cellReference = new CellReference("J44");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setAdresseObservation("Information non renseignée");
                 pageGardeReport.setAdresseIsCorrect(false);
                 pageGardeReport.setAdresseCellule("J44");
             } else {
                 adresseValue = cellCase.getStringCellValue();
             }

             //Identification fiscal
             cellReference = new CellReference("N49");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne N49 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());

             if (cellCase.getCellType() != CellType.STRING) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setIdFiscaleObservation("Information non renseignée");
                 pageGardeReport.setIdFiscaleIsCorrect(false);
                 pageGardeReport.setIdFiscaleCellule("N49");
             } else {
                 numIdentificationValue = cellCase.getStringCellValue();
             }

             //Recuperation sigleValue header
             cellReference = new CellReference("H39");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne H39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.STRING) {
                 sigleValue = cellCase.getStringCellValue();
             }

////             //Recuperation exerciceValue header
////             cellReference = new CellReference("B25");
////             rowCase = datatypeSheet.getRow(cellReference.getRow());
////             cellCase = rowCase.getCell(cellReference.getCol());
////             System.out.println("[ligne B25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
////             if (cellCase.getCellType() == CellType.STRING) {
////                 exerciceValue = cellCase.getStringCellValue();
////             }

             if (pageGardeReport != null) {
                 report.setPageGardeReport(pageGardeReport);
             }
             
             
             //*** Fin verification page de garde

             //*** Debut verification fiche renseignement
             datatypeSheet = workbook.getSheetAt(5);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

             /* ??
             //Centre de dépôt
             cellReference = new CellReference("B15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setCentreDepotObservation("Information non renseignée");
                 ficheRenseignementReport.setCentreDepotIsCorrect(false);
             }
             */

             //Exercice clos
             try {
                 cellReference = new CellReference("V9");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne V9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getCachedFormulaResultType());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println(cellValue.getCellType());
                
                 
                 if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                     if (ficheRenseignementReport == null) {
                         ficheRenseignementReport = new FicheRenseignementReport();
                         report.setErrorExist(true);
                     }
                     ficheRenseignementReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                     ficheRenseignementReport.setExerciceClosIsCorrect(false);
                     ficheRenseignementReport.setExerciceClosCellule("V9");
                 }
             } catch (Exception ie) {// driver not found
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceClosObservation("Information non renseignée");
                 ficheRenseignementReport.setExerciceClosIsCorrect(false);
                 ficheRenseignementReport.setExerciceClosCellule("V9");
             }

             /*??
             //Denomination sociale
             cellReference = new CellReference("B15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDenominationSocialeObservation("Information non renseignée");
                 ficheRenseignementReport.setDenominationSocialeIsCorrect(false);
             }
             */

             //Adress
             cellReference = new CellReference("J6");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne J6 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            // System.out.println(cellCase.getStringCellValue());
            try {
             cellValue = evaluator.evaluate(cellCase);
             
            } catch(Exception e)
            {
            	cellValue=null;	
            	
            	
            }
            // System.out.println(cellValue.getCellType());
             
             if ((cellValue==null) ||(cellValue.getCellType() != CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setAdresseObservation("Information non renseignée");
                 ficheRenseignementReport.setAdresseIsCorrect(false);
                 ficheRenseignementReport.setAdresseCellule("J6");
             }

             //Id fiscal
             try {
                 cellReference = new CellReference("J9");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne J9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
                 if (cellCase.getCellType() == CellType.BLANK) {
                     if (ficheRenseignementReport == null) {
                         ficheRenseignementReport = new FicheRenseignementReport();
                         report.setErrorExist(true);
                     }
                     ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée");
                     ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                     ficheRenseignementReport.setIdFiscaleCellule("J6");
                 }
             } catch (Exception ie) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setIdFiscaleObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                 ficheRenseignementReport.setIdFiscaleCellule("J6");
             }

             //Exerice comptable debut
             cellReference = new CellReference("Y12");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne Y12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             cellValue = evaluator.evaluate(cellCase);
             
             if(cellValue==null) 
             {
            	 
            	 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("Y12");
            	 
             } else
             
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("Y12");
             }
             

             //Exerice comptable fin
             cellReference = new CellReference("AH12");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
            // System.out.println(cellValue.getCellType());
             
             if(cellValue==null) 
             {
            	
            	 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("AH12");
            	 
             } else
             
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceComptableObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setExerciceComptableIsCorrect(false);
                 ficheRenseignementReport.setExerciceComptableCellule("AH12");
             }

             //Date arret compte
             try {
                 cellReference = new CellReference("U15");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne U15 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getCachedFormulaResultType());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println(cellValue.getCellType());
                 if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                     if (ficheRenseignementReport == null) {
                         ficheRenseignementReport = new FicheRenseignementReport();
                         report.setErrorExist(true);
                     }
                     ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée /Format incorrect de l'information renseignée");
                     ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                     ficheRenseignementReport.setDateArreteComptesCellule("U15");
                 }
             } catch (Exception ie) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée");
                 ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                 ficheRenseignementReport.setDateArreteComptesCellule("U15");
             }

             //Greffe
             cellReference = new CellReference("F23");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne F23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
//             if (cellCase.getCellType() != CellType.STRING) {
//                 if (ficheRenseignementReport == null) {
//                     ficheRenseignementReport = new FicheRenseignementReport();
//                     report.setErrorExist(true);
//                 }
//                 ficheRenseignementReport.setGreffeObservation("Information non renseignée");
//                 ficheRenseignementReport.setGreffeIsCorrect(false);
//             }

             //Num registre commerce
             cellReference = new CellReference("I23");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne I23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setNumRegistreCommerceObservation("Information non renseignée");
                 ficheRenseignementReport.setNumRegistreCommerceIsCorrect(false);
                 ficheRenseignementReport.setNumRegistreCommerceCellule("I23");
             }

             //Num Securite Sociale
             cellReference = new CellReference("G27");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//             if (cellCase.getCellType() == CellType.BLANK) {
//                 if (ficheRenseignementReport == null) {
//                     ficheRenseignementReport = new FicheRenseignementReport();
//                     report.setErrorExist(true);
//                 }
//                 ficheRenseignementReport.setNumSecuriteSocialeObservation("Information non renseignée");
//                 ficheRenseignementReport.setNumSecuriteSocialeIsCorrect(false);
//             }

             //Designation Entreprise
             //1
             cellReference = new CellReference("J3");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne J3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
                 ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
                 ficheRenseignementReport.setDesignationEntrepriseCellule("J3");
                 
             }
             //2
             cellReference = new CellReference("D31");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
                 ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
                 ficheRenseignementReport.setDesignationEntrepriseCellule("D31");
             }

             //Telephone
             cellReference = new CellReference("G35");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if ((cellCase.getCellType() != CellType.STRING) && (cellCase.getCellType() != CellType.NUMERIC)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setNumTelephoneObservation("Information non renseignée");
                 ficheRenseignementReport.setNumTelephoneIsCorrect(false);
                 ficheRenseignementReport.setNumTelephoneCellule("G35");
             }

             //Ville
             cellReference = new CellReference("AE35");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne AE35 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setVilleObservation("Information non renseignée");
                 ficheRenseignementReport.setVilleIsCorrect(false);
                 ficheRenseignementReport.setVilleCellule("AE35");
             }

             //Adresse Geographique
             cellReference = new CellReference("D39");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setAdresseGeographiqueObservation("Information non renseignée");
                 ficheRenseignementReport.setAdresseGeographiqueIsCorrect(false);
                 ficheRenseignementReport.setAdresseGeographiqueCellule("D39");
             }

             //Designation Activite Exercee
             cellReference = new CellReference("D43");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D43 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDesignationActiviteExerceeObservation("Information non renseignée");
                 ficheRenseignementReport.setDesignationActiviteExerceeIsCorrect(false);
                 ficheRenseignementReport.setDesignationActiviteExerceeCellule("D43");
             }

             //Personne A Contacter
             cellReference = new CellReference("D47");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D47 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setPersonneAContacterObservation("Information non renseignée");
                 ficheRenseignementReport.setPersonneAContacterIsCorrect(false);
                 ficheRenseignementReport.setPersonneAContacterCellule("D47");
             }

             //Professionnel Ou Cabinet Comptable AuteurEF
             cellReference = new CellReference("D51");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFObservation("Information non renseignée");
                 ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFIsCorrect(false);
                 ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFCellule("D51");
             }

             //Commissaire Au Compte
             cellReference = new CellReference("D55");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
//             if (cellCase.getCellType() != CellType.STRING) {
//                 if (ficheRenseignementReport == null) {
//                     ficheRenseignementReport = new FicheRenseignementReport();
//                     report.setErrorExist(true);
//                 }
//                 ficheRenseignementReport.setCommissaireAuCompteObservation("Information non renseignée");
//                 ficheRenseignementReport.setCommissaireAuCompteIsCorrect(false);
//             }

             //Qualite du Signataire
             cellReference = new CellReference("D71");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.STRING) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setQualiteDuSignataireObservation("Information non renseignée");
                 ficheRenseignementReport.setQualiteDuSignataireIsCorrect(false);
                 ficheRenseignementReport.setQualiteDuSignataireCellule("D71");
                 
             }

             //Date Signature
             cellReference = new CellReference("D74");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne D74 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());
             if (cellCase.getCellType() != CellType.NUMERIC) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDateSignatureObservation("Information non renseignée");
                 ficheRenseignementReport.setDateSignatureIsCorrect(false);
                 ficheRenseignementReport.setDateSignatureCellule("D74");
             }

             //Banque
             String [] cellulesBanques = {"T70", "T71", "T72"}  ; // tableau de cellules à verifier
             Boolean isEmptyName = true;
             for(int i=0; i<cellulesBanques.length; i++) {
                 cellReference = new CellReference(cellulesBanques[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if (cellCase.getCellType() == CellType.STRING) {
                 	isEmptyName = false ;
                     break;
                 }
                }
             if(isEmptyName) {
             	
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                 /*ficheRenseignementReport.setBanqueObservation("Nom banque non renseignée");
                 ficheRenseignementReport.setBanqueIsCorrect(false);*/
                 
                 ficheRenseignementReport.errorMap.put("Banque(s)", "Nom banque non renseignée");
                 ficheRenseignementReport.errorCelluleMap.put("Banque(s)", "Cellule[T70-T71-T72]");
            		
                 
                 
                 
             }
             //Numero
             String [] cellulesNumero = {"AD70", "AD71", "AD72"}  ; // tableau de cellules à verifier
             Boolean isEmptyNumero  = true ;
             for(int i=0; i<cellulesNumero.length; i++) {
                 cellReference = new CellReference(cellulesNumero[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getStringCellValue());

                 if (cellCase.getCellType() == CellType.STRING) {
                 	isEmptyNumero = false ;
                     break;
                 }

             }
             if (isEmptyNumero) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 
                 /*ficheRenseignementReport.setNumeroObservation("compte bancaire non renseignée");
                 ficheRenseignementReport.setNumeroIsCorrect(false);*/
                 
                 ficheRenseignementReport.errorMap.put("Numéro(s)", "Compte bancaire non renseignée");
                 ficheRenseignementReport.errorCelluleMap.put("Numéro(s)", "Cellule[AD70-AD71-AD72]");
                 
             }
             
             //FIn  bank
             if (ficheRenseignementReport != null) {
                 report.setFicheRenseignementReport(ficheRenseignementReport);
             }
             //*** Fin verification fiche renseignement

             
             
    	   //Debut verification Activite de l' entreprise
             
             
           //*** Debut activite entreprise
             datatypeSheet = workbook.getSheetAt(6);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

             //Exercice Clos
             try {
                 cellReference = new CellReference("L5");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);
                 if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                     if (activiteEntrepriseReport == null) {
                         activiteEntrepriseReport = new ActiviteEntrepriseReport();
                         report.setErrorExist(true);
                     }
                     activiteEntrepriseReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                     activiteEntrepriseReport.setExerciceClosIsCorrect(false);
                     activiteEntrepriseReport.setExerciceClosCellule("L5");
                 }
             } catch (Exception ie) {
                 if (activiteEntrepriseReport == null) {
                     activiteEntrepriseReport = new ActiviteEntrepriseReport();
                     report.setErrorExist(true);
                 }
                 activiteEntrepriseReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                 activiteEntrepriseReport.setExerciceClosIsCorrect(false);
                 activiteEntrepriseReport.setExerciceClosCellule("L5");
             }

             //Adresse
             try {
                 cellReference = new CellReference("B3");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println("[ligne B3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 //System.out.println(cellCase.getStringCellValue());
                 if (!evaluateStringCell(cellCase, evaluator)) {
                     if (activiteEntrepriseReport == null) {
                         activiteEntrepriseReport = new ActiviteEntrepriseReport();
                         report.setErrorExist(true);
                     }
                     activiteEntrepriseReport.setAdresseObservation("Information non renseignée");
                     activiteEntrepriseReport.setAdresseIsCorrect(false);
                     activiteEntrepriseReport.setAdresseCellule("B3");
                 }
             } catch (Exception ie) {
                 if (activiteEntrepriseReport == null) {
                     activiteEntrepriseReport = new ActiviteEntrepriseReport();
                     report.setErrorExist(true);
                 }
                 activiteEntrepriseReport.setAdresseObservation("Information non renseignée");
                 activiteEntrepriseReport.setAdresseIsCorrect(false);
                 activiteEntrepriseReport.setAdresseCellule("B3");
             }

             //Id fiscal
             try {
                 cellReference = new CellReference("B5");
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 System.out.println("[ligne B5 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if (cellCase.getCellType() == CellType.BLANK) {
                     if (activiteEntrepriseReport == null) {
                         activiteEntrepriseReport = new ActiviteEntrepriseReport();
                         report.setErrorExist(true);
                     }
                     activiteEntrepriseReport.setIdFiscaleObservation("Information non renseignée ");
                     activiteEntrepriseReport.setIdFiscaleIsCorrect(false);
                     activiteEntrepriseReport.setIdFiscaleCellule("B5");
                 }
             } catch (Exception ie) {
                 if (activiteEntrepriseReport == null) {
                     activiteEntrepriseReport = new ActiviteEntrepriseReport();
                     report.setErrorExist(true);
                 }
                 activiteEntrepriseReport.setIdFiscaleObservation("Format incorrect de l'information renseignée");
                 activiteEntrepriseReport.setIdFiscaleIsCorrect(false);
                 activiteEntrepriseReport.setIdFiscaleCellule("B5");
             }

             //Designation Activite
//             String [] cellulesNumero = {"B28", "B28", "B28"}  ; // tableau de cellules à verifier
//             isEmpty  = true ;
//             for(int i=0; i<cellulesBanques.length; i++) {
             cellReference = new CellReference("B28");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             
             System.out.println("[--------------------------->ligne : B28 " +cellCase.getStringCellValue() );
            // System.out.println("[--------------------------->ligne : B28 " +cellCase.getStringCellValue() + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            try {
             if (cellCase.getCellType() == CellType.BLANK) {
             	 if (activiteEntrepriseReport == null) {
                      activiteEntrepriseReport = new ActiviteEntrepriseReport();
                      report.setErrorExist(true);
                  }
                  activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
                  activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
                  activiteEntrepriseReport.setDesignationActiviteCellule("B28");
             }
         } catch (Exception ie) {
         	 if (activiteEntrepriseReport == null) {
                  activiteEntrepriseReport = new ActiviteEntrepriseReport();
                  report.setErrorExist(true);
              }
              activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
              activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
              activiteEntrepriseReport.setDesignationActiviteCellule("B28");
         }
             
             
           /* if(cellCase==null) 
            {
         	   
         	   if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
                activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
                activiteEntrepriseReport.setDesignationActiviteCellule("B28");
         	   
            }
           */
            
            /*else
             
             if (cellCase.getCellType() != CellType.STRING) {
             	
                 if (activiteEntrepriseReport == null) {
                     activiteEntrepriseReport = new ActiviteEntrepriseReport();
                     report.setErrorExist(true);
                 }
                 activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
                 activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
                 activiteEntrepriseReport.setDesignationActiviteCellule("B28");
             }*/

             if (activiteEntrepriseReport != null) {
                 report.setActiviteEntrepriseReport(activiteEntrepriseReport);
             }
             //*** Fin activite entreprise

             //*** Debut dirigeant
             datatypeSheet = workbook.getSheetAt(7);
             System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
             System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

  

             //Nom
             String [] cellulesNoms = {"A15", "A16", "A17"}  ; // tableau de cellules à verifier
            boolean isEmptyNom  = true ;
             for(int i=0; i<cellulesNoms.length; i++) {
                 cellReference = new CellReference(cellulesNoms[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if ( cellCase.getCellType() == CellType.STRING) {
                 	isEmptyNom = false ;
                     break;
                 }
             }
             if (isEmptyNom) {
                if (dirigeantsReport == null) {
                     dirigeantsReport = new DirigeantsReport();
                     report.setErrorExist(true);
                 }
                /* dirigeantsReport.setNomObservation("Information non renseignée");
                 dirigeantsReport.setNomIsCorrect(false);*/
                
                dirigeantsReport.errorMap.put("Nom dirigeant", "Information non renseignée");
                dirigeantsReport.errorCelluleMap.put("Nom dirigeant", "[A15]");
                
             }
             //Prenom
             String [] cellulesPrenoms = {"C15", "C16", "C17"}  ; // tableau de cellules à verifier
             boolean  isEmptyPrenom  = true ;
             for(int i=0; i<cellulesPrenoms.length; i++) {
                 cellReference = new CellReference(cellulesPrenoms[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);
                 System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if (cellCase.getCellType() == CellType.STRING) {
                 	isEmptyPrenom = false ;
                     break;
                 }
             }
             if (isEmptyPrenom) {
                 if (dirigeantsReport == null) {
                     dirigeantsReport = new DirigeantsReport();
                     report.setErrorExist(true);
                 }
                 /*dirigeantsReport.setPrenomObservation("Information non renseignée");
                 dirigeantsReport.setPrenomIsCorrect(false);*/
                 
             dirigeantsReport.errorMap.put("Prénom dirigeant", "Information non renseignée");
             dirigeantsReport.errorCelluleMap.put("Prénom dirigeant", "[C15]");
                
             }

             //Qualite
             String [] cellulesQualite = {"E15", "E16", "E17"}  ; // tableau de cellules à verifier
             boolean isEmptyQualite  = true ;
             for(int i=0; i<cellulesQualite.length; i++) {
                 cellReference = new CellReference(cellulesQualite[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);

                 System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if (cellCase.getCellType() == CellType.STRING) {
                 	isEmptyQualite = false ;
                     break;
                 }
             }
             if(isEmptyQualite)  {
                 if (dirigeantsReport == null) {
                     dirigeantsReport = new DirigeantsReport();
                     report.setErrorExist(true);
                 }
               /*  dirigeantsReport.setQualiteObservation("Information non renseignée");
                 dirigeantsReport.setQualiteIsCorrect(false);*/
                 
                 dirigeantsReport.errorMap.put("Qualite dirigeant", "Information non renseignée");
                 dirigeantsReport.errorCelluleMap.put("Qualite dirigeant", "[E15]");
             }
             
           //NumeroIF
             String [] cellulesNumeroIF = {"G15", "G16", "G17"}  ; // tableau de cellules à verifier
             boolean isEmptyNumeroIF  = true ;
             for(int i=0; i<cellulesQualite.length; i++) {
                 cellReference = new CellReference(cellulesNumeroIF[i]);
                 rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);

                 System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                 if ((cellCase.getCellType() == CellType.NUMERIC) ||(cellCase.getCellType() == CellType.STRING) ) {
                 	isEmptyNumeroIF = false ;
                     break;
                 }
             }
             if(isEmptyNumeroIF)  {
                 if (dirigeantsReport == null) {
                     dirigeantsReport = new DirigeantsReport();
                     report.setErrorExist(true);
                 }
               /*  dirigeantsReport.setQualiteObservation("Information non renseignée");
                 dirigeantsReport.setQualiteIsCorrect(false);*/
                 
                 dirigeantsReport.errorMap.put("N° d'identification", "Information non renseignée");
                 dirigeantsReport.errorCelluleMap.put("N° d'identification", "[G15]");
             }
             
             
             
             //Adresse
               String [] cellulesAdresse = {"H15", "H16", "H17"}  ; // tableau de cellules à verifier
               boolean isEmptyAdresse  = true ;
               for(int i=0; i<cellulesQualite.length; i++) {
                   cellReference = new CellReference(cellulesAdresse[i]);
                   rowCase = datatypeSheet.getRow(cellReference.getRow());
                   cellCase = rowCase.getCell(cellReference.getCol());
                   cellValue = evaluator.evaluate(cellCase);

                   System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
                   if (cellCase.getCellType() == CellType.STRING) {
                 	  isEmptyAdresse = false ;
                       break;
                   }
               }
               if(isEmptyAdresse)  {
                   if (dirigeantsReport == null) {
                       dirigeantsReport = new DirigeantsReport();
                       report.setErrorExist(true);
                   }
                 /*  dirigeantsReport.setQualiteObservation("Information non renseignée");
                   dirigeantsReport.setQualiteIsCorrect(false);*/
                   
                   dirigeantsReport.errorMap.put("Adresse dirigeant", "Information non renseignée");
                   dirigeantsReport.errorCelluleMap.put("Adresse dirigeant", "[H15]");
               }
               
             
             
             //Adresse
             /*
             cellReference = new CellReference("B8");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             cellValue = evaluator.evaluate(cellCase);
             System.out.println("[ligne B8 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellValue.getCellType() == CellType.BLANK) {
                 if (dirigeantsReport == null) {
                     dirigeantsReport = new DirigeantsReport();
                     report.setErrorExist(true);
                 }
                 dirigeantsReport.setAdresseObservation("Information non renseignée");
                 dirigeantsReport.setAdresseIsCorrect(false);
             }
*/
             if (dirigeantsReport != null) {
                 report.setDirigeantsReport(dirigeantsReport);
             }
             //*** Fin dirigeant
             
            
             
             
         //Fin versification activité de l' entreprise
    	
    	
    	//Fin verification bilan passif
             
             //debut verification bilan SMT
             
             
             //Debut bilan SMT
              datatypeSheet = workbook.getSheetAt(9);
              System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
              System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
              
              
              
              boolean    nombreColonneOk=true;
              
              cellReference = new CellReference("K9");
              rowCase = datatypeSheet.getRow(cellReference.getRow());
              cellCase = rowCase.getCell(cellReference.getCol());
              cellValue = evaluator.evaluate(cellCase);
              
                   if(cellValue==null) {
                   	 nombreColonneOk=false;
                   	
                   } else
                 if (cellValue.getCellType() == CellType.BLANK) 
                 {
               	  nombreColonneOk=false;
               }
                 else
           	   if (cellValue.getCellType() == CellType.STRING) 
           	   {
           		   
           		 String cellVal1= cellValue.getStringValue();
      		   String cellVal2= exerciceValue;
           		   
      		
        		   boolean testok=false;
        		   
        		   if(cellVal2.length()>0 && cellVal1.length()>0){
        		   
        		   try {
        			    String val1=cellVal1.substring(cellVal1.length()-2, cellVal1.length());
        			    int val2= Integer.parseInt(cellVal2.substring(cellVal2.length()-2, cellVal2.length()))-1;
        			   System.out.print("val1"+val1);
        			   System.out.print("val2"+val2);
        			   
        		  testok=val1.equals(String.valueOf(val2));
        		 
        		   }
        		   catch(Exception e) 
        		   {
        			   
        		   }
        		   
        		   }
           		   
           		   
           		   if(cellValue.getStringValue().equalsIgnoreCase("Exercice au 31/12/N-1") || testok) 
           		   {
           			   nombreColonneOk=true;
           			   
           		   }
           		   else
           		   {
           			   nombreColonneOk=false;
           		   }
           		   
           		   
           	   }else
           	   {
           		   nombreColonneOk=false;  
           		   
           	   }
           	   
           	   
         System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
             
             
         if(!nombreColonneOk) 
         {
         	
       	  if (bilanActifReport == null) {
       		bilanActifReport = new BilanActifReport();
       		bilanActifReport.setTitle("Bilan SMT");
                 report.setErrorExist(true);
             }
       	  
       	bilanActifReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
       	bilanActifReport.errorCelluleMap.put("Nombre de colonne"," il ya une incohérence entre l'exercicle clos au nivdeau de la page et la date renseignée au niveau de la cellule K9");
        
         	
         } else {
         	
         	
  // Fin Gestion du nombre de ligne
             
             
         	
      boolean    nombreLigneOk=true;
              
              cellReference = new CellReference("A22");
              rowCase = datatypeSheet.getRow(cellReference.getRow());
              cellCase = rowCase.getCell(cellReference.getCol());
              cellValue = evaluator.evaluate(cellCase);
              
                   if(cellValue==null) {
                 	  nombreLigneOk=false;
                   	
                   } else
                 if (cellValue.getCellType() == CellType.BLANK) 
                 {
                 	nombreLigneOk=false;
               }
                 else
           	   if (cellValue.getCellType() == CellType.STRING) 
           	   {
           		   
           		   if(cellValue.getStringValue().equalsIgnoreCase("TOTAL ACTIF")) 
           		   {
           			 nombreLigneOk=true;
           			   
           		   }
           		   else
           		   {
           			 nombreLigneOk=false;
           		   }
           		   
           		   
           	   }else
           	   {
           		 nombreLigneOk=false;  
           		   
           	   }
           	   
           	   
         System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     
             
         	
             if (!nombreLigneOk) {
             	
             	if (bilanActifReport == null) {
               		bilanActifReport = new BilanActifReport();
               		bilanActifReport.setTitle("Bilan SMT");
                         report.setErrorExist(true);
                     }
               	  
               	bilanActifReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
            		
             	
                 
             }else {
             	
             	
             	
             	
             	for (int index=11 ;index<=22;index++) 
                 {
               	  
               	 // Debut cellule C
               	  
               	  cellReference = new CellReference("C"+index); 
               	  
               	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                     cellCase = rowCase.getCell(cellReference.getCol());
                     cellValue = evaluator.evaluate(cellCase);
                     
                      
                     if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                     {
                   	  
                   	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
                   	  
                   	  if (bilanActifReport == null) {
                   		bilanActifReport = new BilanActifReport();
                   		bilanActifReport.setTitle("Bilan SMT");
                             report.setErrorExist(true);
                         }
                   	  
                   	  String nomCellule="[" +"C"+index+ "]";
                   	  
                   	  cellReference = new CellReference("A"+index); 
                   	  
                   	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                         cellCase = rowCase.getCell(cellReference.getCol());
                         cellValue = evaluator.evaluate(cellCase);
                         
                         
                         if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                         {
                       	  nomCellule=cellValue.getStringValue();
                       	 
                       	  
                         }
                   	  

                   	  
                         bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                         bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
                   	  
                   	  
                     }
                     
                  // Fin cellule C
                     
                     
                     
                   // Debut cellule D
               	  
               	  cellReference = new CellReference("D"+index); 
               	  
               	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                     cellCase = rowCase.getCell(cellReference.getCol());
                     cellValue = evaluator.evaluate(cellCase);
                     
                      
                     if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                     {
                   	  
                   	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                   	  
                   	  if (bilanActifReport == null) {
                   		bilanActifReport = new BilanActifReport();
                   		bilanActifReport.setTitle("Bilan SMT");
                             report.setErrorExist(true);
                         }
                   	  
                   	  
                       String nomCellule="[" +"D"+index+ "]";
                   	  
                   	  cellReference = new CellReference("A"+index); 
                   	  
                   	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                         cellCase = rowCase.getCell(cellReference.getCol());
                         cellValue = evaluator.evaluate(cellCase);
                         
                         
                         if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                         {
                       	  nomCellule=cellValue.getStringValue();
                       	 
                       	  
                         }
                   	  
                   	  
                         bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                         bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
                   	  
                   	  
                     }
                     
                    // Fin cellule D
                     
                   
                     // Debut cellule E
                  	  
                  	  cellReference = new CellReference("E"+index); 
                  	  
                  	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                        cellCase = rowCase.getCell(cellReference.getCol());
                        cellValue = evaluator.evaluate(cellCase);
                        
                         
                        if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                        {
                      	  
                      	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                      	  
                      	  if (bilanActifReport == null) {
                      		bilanActifReport = new BilanActifReport();
                      		bilanActifReport.setTitle("Bilan SMT");
                                report.setErrorExist(true);
                            }
                      	  
                      	  
                          String nomCellule="[" +"E"+index+ "]";
                      	  
                      	  cellReference = new CellReference("A"+index); 
                      	  
                      	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                            cellCase = rowCase.getCell(cellReference.getCol());
                            cellValue = evaluator.evaluate(cellCase);
                            
                            
                            if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                            {
                          	  nomCellule=cellValue.getStringValue();
                          	 
                          	  
                            }
                      	  
                      	  
                            bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                            bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"E"+index+ "]");
                      	  
                      	  
                        }
                        
                       // Fin cellule E
                        
                     
                     // Debut cellule F
                    	  
                    	  cellReference = new CellReference("F"+index); 
                    	  
                    	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                          cellCase = rowCase.getCell(cellReference.getCol());
                          cellValue = evaluator.evaluate(cellCase);
                          
                           
                          if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                          {
                        	  
                        	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                        	  
                        	  if (bilanActifReport == null) {
                        		bilanActifReport = new BilanActifReport();
                        		bilanActifReport.setTitle("Bilan SMT");
                                  report.setErrorExist(true);
                              }
                        	  
                        	  
                            String nomCellule="[" +"F"+index+ "]";
                        	  
                        	  cellReference = new CellReference("A"+index); 
                        	  
                        	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                              cellCase = rowCase.getCell(cellReference.getCol());
                              cellValue = evaluator.evaluate(cellCase);
                              
                              
                              if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                              {
                            	  nomCellule=cellValue.getStringValue();
                            	 
                            	  
                              }
                        	  
                        	  
                              bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                              bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"F"+index+ "]");
                        	  
                        	  
                          }
                          
                         // Fin cellule F
                     
                   
                     // Debut cellule J
                    	  
                    	  cellReference = new CellReference("J"+index); 
                    	  
                    	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                          cellCase = rowCase.getCell(cellReference.getCol());
                          cellValue = evaluator.evaluate(cellCase);
                          
                           
                          if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                          {
                        	  
                        	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                        	  
                        	  if (bilanActifReport == null) {
                        		bilanActifReport = new BilanActifReport();
                        		bilanActifReport.setTitle("Bilan SMT");
                                  report.setErrorExist(true);
                              }
                        	  
                        	  
                            String nomCellule="[" +"J"+index+ "]";
                        	  
                        	  cellReference = new CellReference("H"+index); 
                        	  
                        	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                              cellCase = rowCase.getCell(cellReference.getCol());
                              cellValue = evaluator.evaluate(cellCase);
                              
                              
                              if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                              {
                            	  nomCellule=cellValue.getStringValue();
                            	 
                            	  
                              }
                        	  
                        	  
                              bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                              bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"J"+index+ "]");
                        	  
                        	  
                          }
                          
                         // Fin cellule J
                          
                          
                         // Debut cellule K
                    	  
                    	  cellReference = new CellReference("K"+index); 
                    	  
                    	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                          cellCase = rowCase.getCell(cellReference.getCol());
                          cellValue = evaluator.evaluate(cellCase);
                          
                           
                          if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                          {
                        	  
                        	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
                        	  
                        	  if (bilanActifReport == null) {
                        		bilanActifReport = new BilanActifReport();
                        		bilanActifReport.setTitle("Bilan SMT");
                                  report.setErrorExist(true);
                              }
                        	  
                        	  
                            String nomCellule="[" +"K"+index+ "]";
                        	  
                        	  cellReference = new CellReference("H"+index); 
                        	  
                        	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                              cellCase = rowCase.getCell(cellReference.getCol());
                              cellValue = evaluator.evaluate(cellCase);
                              
                              
                              if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                              {
                            	  nomCellule=cellValue.getStringValue();
                            	 
                            	  
                              }
                        	  
                        	  
                              bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                              bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"K"+index+ "]");
                        	  
                        	  
                          }
                          
                         // Fin cellule K
                          
                     
                 }
                 
                 
             	
             }
         	
         	
         	
         	
         }  //Fin de tester nombre de ligne bilan actif
              

     	if (bilanActifReport != null) {
             report.setBilanActifReport(bilanActifReport);
         }
         //*** Fin bilan
             
             
             
             
             
             
             //Fin verification  bilan SMT 
	
           
     	
     	//debut verification  CPTE de resultat SMT
     	
     	
     	
     	//Debut bilan SMT
        datatypeSheet = workbook.getSheetAt(10);
        System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
        System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
        
        
        
           nombreColonneOk=true;
        
        cellReference = new CellReference("D11");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);
        
             if(cellValue==null) {
             	 nombreColonneOk=false;
             	
             } else
           if (cellValue.getCellType() == CellType.BLANK) 
           {
         	  nombreColonneOk=false;
         }
           else
     	   if (cellValue.getCellType() == CellType.STRING) 
     	   {
     		   
     		   if(cellValue.getStringValue().equalsIgnoreCase("Exercice au 31/12/N-1")) 
     		   {
     			   nombreColonneOk=true;
     			   
     		   }
     		   else
     		   {
     			   nombreColonneOk=false;
     		   }
     		   
     		   
     	   }else
     	   {
     		   nombreColonneOk=false;  
     		   
     	   }
     	   
     	   
   System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
       
       
   if(!nombreColonneOk) 
   {
   	
 	  if (compteResultatReport == null) {
 		 compteResultatReport = new CompteResultatReport();
 		compteResultatReport.setTitle("CPTE de Résultat SMT");
           report.setErrorExist(true);
       }
 	  
 	 compteResultatReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
		
   	
   } else {
   	
   	
// Fin Gestion du nombre de ligne
       
       
   	
boolean    nombreLigneOk=true;
        
        cellReference = new CellReference("A31");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);
        
             if(cellValue==null) {
           	  nombreLigneOk=false;
             	
             } else
           if (cellValue.getCellType() == CellType.BLANK) 
           {
           	nombreLigneOk=false;
         }
           else
     	   if (cellValue.getCellType() == CellType.STRING) 
     	   {
     		   
     		   if(cellValue.getStringValue().equalsIgnoreCase("RESULTAT DE L'EXERCICE")) 
     		   {
     			 nombreLigneOk=true;
     			   
     		   }
     		   else
     		   {
     			 nombreLigneOk=false;
     		   }
     		   
     		   
     	   }else
     	   {
     		 nombreLigneOk=false;  
     		   
     	   }
     	   
     	   
   System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     
       
   	
       if (!nombreLigneOk) {
       	
       	if (compteResultatReport == null) {
       		compteResultatReport = new CompteResultatReport();
         		compteResultatReport.setTitle("CPTE de Résultat SMT");
                   report.setErrorExist(true);
               }
         	  
       	compteResultatReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
      		
       	
           
       }else {
       	
       	
       	
       	
       	for (int index=12 ;index<=31;index++) 
           {
         	  
         	 // Debut cellule C
         	  
         	  cellReference = new CellReference("C"+index); 
         	  
         	  rowCase = datatypeSheet.getRow(cellReference.getRow());
               cellCase = rowCase.getCell(cellReference.getCol());
               cellValue = evaluator.evaluate(cellCase);
               
                
               if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
               {
             	  
             	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
             	  
             	  if (compteResultatReport == null) {
             		 compteResultatReport = new CompteResultatReport();
                     compteResultatReport.setTitle("CPTE de Résultat SMT");
                       report.setErrorExist(true);
                   }
             	  
             	  String nomCellule="[" +"C"+index+ "]";
             	  
             	  cellReference = new CellReference("A"+index); 
             	  
             	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                   cellCase = rowCase.getCell(cellReference.getCol());
                   cellValue = evaluator.evaluate(cellCase);
                   
                   
                   if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                   {
                 	  nomCellule=cellValue.getStringValue();
                 	 
                 	  
                   }
             	  

             	  
                   compteResultatReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                   compteResultatReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
             	  
             	  
               }
               else 
               {
               	
               	if(index==14)
               	{
               		
               		if ((cellValue!=null) && (cellValue.getCellType() == CellType.NUMERIC))
                       {
                     	  
                      chiffreAffaire=cellValue.getNumberValue()+"";	
                       }
               		
               		
                 	}
               	
               	
               	
               	if(index==31)
               	{
               		
               		if ( (cellValue!=null) &&(cellValue.getCellType() == CellType.NUMERIC))
                       {
                     	resultatNet=cellValue.getNumberValue()+"";	
                       }
               		
               		
               	}
               	
               }

               
            // Fin cellule C
               
               
               
             // Debut cellule D
         	  
         	  cellReference = new CellReference("D"+index); 
         	  
         	  rowCase = datatypeSheet.getRow(cellReference.getRow());
               cellCase = rowCase.getCell(cellReference.getCol());
               cellValue = evaluator.evaluate(cellCase);
               
                
               if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
               {
             	  
             	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
             	  
             	  if (compteResultatReport == null) {
             		 compteResultatReport = new CompteResultatReport();
             		compteResultatReport.setTitle("CPTE de Résultat SMT");
                       report.setErrorExist(true);
                   }
             	  
             	  
                 String nomCellule="[" +"D"+index+ "]";
             	  
             	  cellReference = new CellReference("A"+index); 
             	  
             	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                   cellCase = rowCase.getCell(cellReference.getCol());
                   cellValue = evaluator.evaluate(cellCase);
                   
                   
                   if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                   {
                 	  nomCellule=cellValue.getStringValue();
                 	 
                 	  
                   }
             	  
             	  
                   compteResultatReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                   compteResultatReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
             	  
             	  
               }
               
              // Fin cellule D
               
           }
           
           
       	
       }
   	
   	
   	
   	
   }  //Fin de tester nombre de ligne bilan actif
        

	if (compteResultatReport != null) {
       report.setCompteResultatReport(compteResultatReport);
   }
   //*** Fin bilan
       
       
     	//FIn vderification CPTE resultat SMT
             
             
             }  //fin nombre de page
             
             }
             
             if (report.errorExist) {
                 HeaderReport headerReport = new HeaderReport();

                 headerReport.setDesignationValue(designationValue);
                 headerReport.setAdresseValue(adresseValue);
                 headerReport.setNumIdentificationValue(numIdentificationValue);
                 headerReport.setSigleValue(sigleValue);
                 headerReport.setExerciceValue(exerciceValue);

                 report.setHeaderReport(headerReport);
             } else {
                 ExcelData excelData = new ExcelData();

                 excelData.setEntreprise(designationValue);
                 excelData.setNinea(numIdentificationValue);
                 excelData.setTotalBilan(totalBilan);
                 excelData.setCapitalPropre(capitalPropre);
                 excelData.setResultatNet(resultatNet);
                 excelData.setChiffreAffaire(chiffreAffaire);
                 
                 System.out.println("chiffreAffaire------------------------>"+chiffreAffaire);
                 System.out.println("resultatNet------------------------>"+resultatNet);

                 report.setExcelData(excelData);
             }

             //String reportFileName = "Rapport de conformité_test.xlsx";
             excelFile.close();
             createReport(report, filePath, rapportFileName);
         } catch (Exception e) {
             report = null;
             System.out.println("xxxxxxx");
             e.printStackTrace();
             System.out.println("yyyyyyy");


         } finally {

             try {
                 // He was careful to close streams in finally block, but it’s not complete
                 // Can you spot error?

                 if (excelFile != null)
                     excelFile.close();

             } catch (IOException e) {
                 System.out.println("Failed to close streams");
             }

         }

         System.out.println("======> Fin verification excel");
         //2222222222222222222222222222222222222222222222222222222222222222222222

         return report;
 		 
 		 
 	    }
 	
 	 
 	 //Fin de la gestion SMT
 
 
 
 //Debut verification gestion Assurance
 
 
//Gestion pour le depot Banque
	
	
	 public static Report verifyExcelBanque(String filePath, String fileName, String rapportFileName,String formJuridique) {
		
		 
		 Report report = null;
     String designationValue = "";
     String adresseValue = "";
     String numIdentificationValue = "";
     String sigleValue = "";
     String exerciceValue = "";

     String totalBilan = "";//Bilan paysage : F31
     String capitalPropre = "";//Bilan paysage : D35
     String resultatNet = "";//Compte resultat : D56  new
     String chiffreAffaire = "";//Compte resultat : D36  new
     
     int nombrePageExcel=0;
     double total=0;
     
    List<String> nomDesOnglet = new ArrayList<>();
    nomDesOnglet.add("Page de garde");
    nomDesOnglet.add("Fiche de renseignement R1");
    nomDesOnglet.add("Bilan ACTIF");
    nomDesOnglet.add("Bilan PASSIF");
    nomDesOnglet.add("Hors Bilan");
    nomDesOnglet.add("Compte de Résultat");
    nomDesOnglet.add("Annexe 4.1");
    nomDesOnglet.add("Annexe 4.2");
    nomDesOnglet.add("Annexe 4.3");
    nomDesOnglet.add("Annexe 4.4");
    nomDesOnglet.add("Annexe 4.5");
    nomDesOnglet.add("Annexe 4.6");
    nomDesOnglet.add("Annexes 4.7");
    nomDesOnglet.add("Annexe 4.8");
    nomDesOnglet.add("Annexe 4.9");
    nomDesOnglet.add("Annexe 4.10");
    nomDesOnglet.add("Annexe 4.11");
    nomDesOnglet.add("Annexe 4.12");
    nomDesOnglet.add("Annexe 4.13");
    nomDesOnglet.add("Annexes 4.14");
    nomDesOnglet.add("Annexe 4.15");
    nomDesOnglet.add("Annexe 4.16");
    nomDesOnglet.add("Annexe 4.17");
    nomDesOnglet.add("Annexe 4.18");
    nomDesOnglet.add("Annexe 4.19");
    nomDesOnglet.add("Annexe 4.20");
    nomDesOnglet.add("Annexes 4.21");
    nomDesOnglet.add("Annexe 4.22");
    nomDesOnglet.add("Annexe 4.23"); 
    nomDesOnglet.add("Annexe 4.24");
    nomDesOnglet.add("Annexe 4.25");
    nomDesOnglet.add("Annexe 4.26");
    nomDesOnglet.add("Annexe 4.27");
    
    
    List<String> referrenceBilan1 = new ArrayList<>();
   
    referrenceBilan1.add("REF");
    referrenceBilan1.add("REF");
    referrenceBilan1.add("AD");
    referrenceBilan1.add("AE");
    referrenceBilan1.add("AF");
    referrenceBilan1.add("AG");
    referrenceBilan1.add("AH");
    referrenceBilan1.add("AI");
    referrenceBilan1.add("AJ");
    referrenceBilan1.add("AK");
    referrenceBilan1.add("AL");
    referrenceBilan1.add("AM");
    referrenceBilan1.add("AN");
    referrenceBilan1.add("AP");
    referrenceBilan1.add("AQ");
    referrenceBilan1.add("AR");
    referrenceBilan1.add("AS");
    referrenceBilan1.add("AZ");
    referrenceBilan1.add("BA");
    referrenceBilan1.add("BB");
    referrenceBilan1.add("BG");
    referrenceBilan1.add("BH");
    referrenceBilan1.add("BI");
    referrenceBilan1.add("BJ");
    referrenceBilan1.add("BK");
    referrenceBilan1.add("BQ");
    referrenceBilan1.add("BR");
    referrenceBilan1.add("BS");
    referrenceBilan1.add("BT");
    referrenceBilan1.add("BU");
    referrenceBilan1.add("BZ");
    
    List<String> referrenceBilan2 = new ArrayList<>();
    referrenceBilan2.add("REF");
    referrenceBilan2.add("REF");
    referrenceBilan2.add("CA");
    referrenceBilan2.add("CB");
    referrenceBilan2.add("CD");
    referrenceBilan2.add("CE");
    referrenceBilan2.add("CF");
    referrenceBilan2.add("CG");
    referrenceBilan2.add("CH");
    referrenceBilan2.add("CJ");
    referrenceBilan2.add("CL");
    referrenceBilan2.add("CM");
    referrenceBilan2.add("CP");
    referrenceBilan2.add("DA");
    referrenceBilan2.add("DB");
    referrenceBilan2.add("DC");
    referrenceBilan2.add("DD");
    referrenceBilan2.add("DF");
    referrenceBilan2.add("DH");
    referrenceBilan2.add("DI");
    referrenceBilan2.add("DJ");
    referrenceBilan2.add("DK");
    referrenceBilan2.add("DM");
    referrenceBilan2.add("DN");
    referrenceBilan2.add("DP");
    referrenceBilan2.add("");
    referrenceBilan2.add("DQ");
    referrenceBilan2.add("DR");
    referrenceBilan2.add("DT");
    referrenceBilan2.add("DV");
    referrenceBilan2.add("DZ");
   
    
    List<String> referrenceComptat1 = new ArrayList<>();
    referrenceComptat1.add("REF");
    referrenceComptat1.add("TA");
    referrenceComptat1.add("RA");
    referrenceComptat1.add("RB");
    referrenceComptat1.add("XA");
    referrenceComptat1.add("TB");
    referrenceComptat1.add("TC");
    referrenceComptat1.add("TD");
    referrenceComptat1.add("XB");
    referrenceComptat1.add("TE");
    referrenceComptat1.add("TF");
    referrenceComptat1.add("TG");
    referrenceComptat1.add("TH");
    referrenceComptat1.add("TI");
    referrenceComptat1.add("RC");
    referrenceComptat1.add("RD");
    referrenceComptat1.add("RE");
    referrenceComptat1.add("RF");
    referrenceComptat1.add("RG");
    referrenceComptat1.add("RH");
    referrenceComptat1.add("RI");
    referrenceComptat1.add("RJ");
    referrenceComptat1.add("XC");
    referrenceComptat1.add("RK");
    referrenceComptat1.add("XD");
    referrenceComptat1.add("TJ");
    referrenceComptat1.add("RL");
    referrenceComptat1.add("XE");
    referrenceComptat1.add("TK");
    referrenceComptat1.add("TL");
    referrenceComptat1.add("TM");
    referrenceComptat1.add("RM");
    referrenceComptat1.add("RN");
    referrenceComptat1.add("XF");
    referrenceComptat1.add("XG");
    referrenceComptat1.add("TN");
    referrenceComptat1.add("TO");
    referrenceComptat1.add("RO");
    referrenceComptat1.add("RP");
    referrenceComptat1.add("XH");
    referrenceComptat1.add("RQ");
    referrenceComptat1.add("RS");
    referrenceComptat1.add("XI");
    
    List<String> referrenceTresorerie1 = new ArrayList<>();
    referrenceTresorerie1.add("REF");
    referrenceTresorerie1.add("ZA");
    referrenceTresorerie1.add("");
    referrenceTresorerie1.add("FA");
    referrenceTresorerie1.add("FB");
    referrenceTresorerie1.add("FC");
    referrenceTresorerie1.add("FD");
    referrenceTresorerie1.add("FE");
    referrenceTresorerie1.add("");
    referrenceTresorerie1.add("ZB");
    referrenceTresorerie1.add("");
    referrenceTresorerie1.add("FF");
    referrenceTresorerie1.add("FG");
    referrenceTresorerie1.add("FH");
    referrenceTresorerie1.add("FI");
    referrenceTresorerie1.add("FJ");
    referrenceTresorerie1.add("ZC");
    referrenceTresorerie1.add("");
    referrenceTresorerie1.add("FK");
    referrenceTresorerie1.add("FL");
    referrenceTresorerie1.add("FM");
    referrenceTresorerie1.add("FN");
    referrenceTresorerie1.add("ZD");
    referrenceTresorerie1.add("");
    referrenceTresorerie1.add("FO");
    referrenceTresorerie1.add("FP");
    referrenceTresorerie1.add("FQ");
    referrenceTresorerie1.add("ZE");
    referrenceTresorerie1.add("ZF");
    referrenceTresorerie1.add("ZG");
    referrenceTresorerie1.add("XI");
   
    
    Map<String,Integer> ReferencePosteMap= new HashMap<String, Integer>();
    ReferencePosteMap.put("18", 1);
    ReferencePosteMap.put("20", 2);
    ReferencePosteMap.put("22", 3);
    ReferencePosteMap.put("24", 4);
    ReferencePosteMap.put("26", 5);
    ReferencePosteMap.put("28", 6);
    ReferencePosteMap.put("30", 7);
    ReferencePosteMap.put("32", 8);
    ReferencePosteMap.put("34", 9);
    ReferencePosteMap.put("36", 10);
    ReferencePosteMap.put("38", 11);
    ReferencePosteMap.put("40", 12);
    ReferencePosteMap.put("42", 13);
    ReferencePosteMap.put("44", 14);
    ReferencePosteMap.put("46", 15);
    ReferencePosteMap.put("48", 16);
    ReferencePosteMap.put("50", 17);
    ReferencePosteMap.put("52", 18);
    ReferencePosteMap.put("54", 19);
    ReferencePosteMap.put("56", 20);
    
    
    
    Map<String,Integer> ReferencePosteHorsBilanMap= new HashMap<String, Integer>();
   
    ReferencePosteHorsBilanMap.put("20", 1);
    ReferencePosteHorsBilanMap.put("22", 2);
    ReferencePosteHorsBilanMap.put("24", 3);
    ReferencePosteHorsBilanMap.put("29", 4);
    ReferencePosteHorsBilanMap.put("31", 5);
    ReferencePosteHorsBilanMap.put("33", 6);
   
   
    
    
    
    //Note 13
    
    
  
     //1111111111111111111111111111111111111111111111111111111111111111111111
     System.out.println("======> Debut verification excel  systeme banque");
     String fileLocation = filePath + fileName;
     FileInputStream excelFile = null;

     try {
         excelFile = new FileInputStream(new File(fileLocation));

         Workbook workbook = new XSSFWorkbook(excelFile);
         FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

         //Workbook workbook = com.monitorjbl.xlsx.StreamingReader.StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(excelFile));

         System.out.println("--> Nombre de page du document = [" + workbook.getNumberOfSheets() + "]");

         CellReference cellReference;
         Row rowCase;
         Cell cellCase;
         CellValue cellValue;
         
         CellReference cellReference2;
         Row rowCase2;
         Cell cellCase2;
         CellValue cellValue2;


         report = new Report();
         
         nombrePageExcel=workbook.getNumberOfSheets();

         //11111111
         PageGardeReport pageGardeReport = null;
         FicheRenseignementReport ficheRenseignementReport = null;
         ActiviteEntrepriseReport activiteEntrepriseReport = null;
         DirigeantsReport dirigeantsReport = null;
         BalanceReport balanceReport = null;
         BilanActifReport bilanActifReport = null;
         BilanPassifReport bilanPassifReport = null;
         HorsBilanReport horsBilanReport = null;
         CompteResultatReport compteResultatReport = null;
         FluxTresorerieReport fluxTresorerieReport = null;
         Note13 note13 = null;
         //22222222
         report.errorFormatExist=false;
         
         
         if(nombrePageExcel < 33) {
         	
         	report.observationFormat.add("Des feuilles/rubriques ont été supprimées");
         	report.errorFormatExist=true;
         	report.errorExist=true;
         	
           /* for(int i=nombrePageExcel;i<55;i++) {
      
         	report.listfeuillesManquantes.add(nomDesOnglet.get(i));
         	
         }*/
         	
         	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été supprimées");
           
         }
         
         else
         	
             if(nombrePageExcel > 33)   //le nombre de ligne du fichier Excel
             {
             	report.observationFormat.add("Des feuilles/rubriques ont été ajoutées");
             	report.errorFormatExist=true;
             	report.errorExist=true;
             	
             	
             	/*for(int i=(nombrePageExcel-1);i>=55;i--) {
                     
             		Sheet datatypeSheet01 = workbook.getSheetAt(i);
                 	report.listfeuillesManquantes.add(datatypeSheet01.getSheetName());
                 	
                 }*/
             	
             	report.listfeuillesManquantes.add("Des feuilles/rubriques ont été ajoutées");
             	
             	
             	report.errorExist=true;
             }
         
         else
         	
               //le nombre de ligne du fichier Excel   if(nombrePageExcel==55)   
         {
         	
         	
        	/* for(int i=0;i<33;i++) {
        		 Sheet datatypeSheet = workbook.getSheetAt(i);   
        	  System.out.println("--> Onglet = [" + datatypeSheet.getSheetName() + "]");
        	 
        	 }*/
         	
         	//controle des nms des onglets
         	
         	
         	 for(int i=0;i<33;i++) {
         		 
         		 Sheet datatypeSheet02 = workbook.getSheetAt(i);   
         		 
         		 if(!datatypeSheet02.getSheetName().equals(nomDesOnglet.get(i))) {
         		 
         			 
      
              	report.listongletsnomsModifies.add(datatypeSheet02.getSheetName());
              	
              	
              	
              	report.errorMaplistongletsnomsModifies.put(datatypeSheet02.getSheetName(), "Le mon de la feuille a éte modifié. L'appellation conforme est :"+nomDesOnglet.get(i));
              	
         		 }
              	
              }
         	
    
         	 if(report.listongletsnomsModifies.size()>0) 
         	 {
         		
         		 
              report.errorFormatExist=true;
         		 
         	report.observationFormat.add("Les noms de certaines rubriques ont été changés");
         	   
         	report.errorExist=true;
         		 
         		 
         	 }else {
         	
         		 

         	//Fin controle des noms onglets
         		 
         
         	
         //*** Debut verification page de garde
         	
         	
         	
         Sheet datatypeSheet = workbook.getSheetAt(0);
         System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
         System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

          	
         
         //Centre de dépôt
         cellReference = new CellReference("B15");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         cellValue = evaluator.evaluate(cellCase);

         //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if ( cellValue ==null || cellValue.getCellType() != CellType.STRING) {
             if (pageGardeReport == null) {
                 pageGardeReport = new PageGardeReport();
                 report.setErrorExist(true);
             }
             pageGardeReport.setCentreDepotObservation("Information non renseignée");
             pageGardeReport.setCentreDepotIsCorrect(false);
             pageGardeReport.setCentreDepotCellule("B15");
         } else {
             try {
                 if ((cellCase.getStringCellValue().split(":")[1] != null) && (!cellCase.getStringCellValue().split(":")[1].trim().equalsIgnoreCase(""))) {
                 } else {
                     if (pageGardeReport == null) {
                         pageGardeReport = new PageGardeReport();
                         report.setErrorExist(true);
                     }
                     pageGardeReport.setCentreDepotObservation("Information non renseignée");
                     pageGardeReport.setCentreDepotIsCorrect(false);
                     pageGardeReport.setCentreDepotCellule("B15");
                 }
             } catch (Exception ie) {
                 if (pageGardeReport == null) {
                     pageGardeReport = new PageGardeReport();
                     report.setErrorExist(true);
                 }
                 pageGardeReport.setCentreDepotObservation("Information non renseignée");
                 pageGardeReport.setCentreDepotIsCorrect(false);
                 pageGardeReport.setCentreDepotCellule("B15");
             }
         }

         //Exercice clos
         
         System.out.println(" debut Exercice clos ");
         
         cellReference = new CellReference("M25");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         cellValue = evaluator.evaluate(cellCase);
       // System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");

         if(cellValue==null) {
         
         	 if (pageGardeReport == null) {
                  pageGardeReport = new PageGardeReport();
                  report.setErrorExist(true);
              }
              pageGardeReport.setExerciceClosObservation("Information non renseignée");
              pageGardeReport.setExerciceClosIsCorrect(false);
              pageGardeReport.setExerciceClosCellule("M25");
         	
         	
         }
         else
             if (cellValue.getCellType() == CellType.STRING || cellValue.getCellType() == CellType.NUMERIC) {

             	 try {
                      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                      DataFormatter dataFormatter = new DataFormatter();
                      
                      Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                     
                      date.getTime();
                      exerciceValue = dataFormatter.formatCellValue(cellCase);
                      
                  } catch (Exception e) {
                      e.printStackTrace();
                     
                      if (pageGardeReport == null) {
                          pageGardeReport = new PageGardeReport();
                          report.setErrorExist(true);
                      }
                      pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                     
                      pageGardeReport.setExerciceClosCellule("M25");
                      pageGardeReport.setExerciceClosIsCorrect(false);
                      
                  }
             	
             }
         
         
         /*else
         if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {

        	  System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");

             //gestion avancee de la date
             try {
                 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                 DataFormatter dataFormatter = new DataFormatter();
                 Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                 date.getTime();
             } catch (Exception e) {
            	 
                 e.printStackTrace();
                 
             }
             
             if (pageGardeReport == null) {
                 pageGardeReport = new PageGardeReport();
                 report.setErrorExist(true);
             }
             pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
             pageGardeReport.setExerciceClosIsCorrect(false);
             pageGardeReport.setExerciceClosCellule("M25");
             
         } */else {
        	 
        	 

             DataFormatter df = new DataFormatter();
             exerciceValue = df.formatCellValue(cellCase);
             
            if(exerciceValue.length()>10)
            {
            	
            	if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                pageGardeReport.setExerciceClosIsCorrect(false);
                pageGardeReport.setExerciceClosCellule("M25");
            	
            }
             
             
             
         }
         
         System.out.println(" Exercice clos fin ");
          

         //Denomination sociale
         cellReference = new CellReference("L33");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         //System.out.println("[ligne L33 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         
         
         
         
         if (cellCase.getCellType() != CellType.STRING) {
             if (pageGardeReport == null) {
                 pageGardeReport = new PageGardeReport();
                 report.setErrorExist(true);
             }
             pageGardeReport.setDenominationSocialeObservation("Information non renseignée");
             pageGardeReport.setDenominationSocialeIsCorrect(false);
             pageGardeReport.setDenominationSocialeCellule("L33");
             
         } else {
             designationValue = cellCase.getStringCellValue();
         }

         //Adresse
         cellReference = new CellReference("J44");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (pageGardeReport == null) {
                 pageGardeReport = new PageGardeReport();
                 report.setErrorExist(true);
             }
             pageGardeReport.setAdresseObservation("Information non renseignée");
             pageGardeReport.setAdresseIsCorrect(false);
             pageGardeReport.setAdresseCellule("J44");
         } else {
             adresseValue = cellCase.getStringCellValue();
         }

         //Identification fiscal
         cellReference = new CellReference("N49");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne N49 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());

         if (cellCase.getCellType() != CellType.STRING) {
             if (pageGardeReport == null) {
                 pageGardeReport = new PageGardeReport();
                 report.setErrorExist(true);
             }
             pageGardeReport.setIdFiscaleObservation("Information non renseignée");
             pageGardeReport.setIdFiscaleIsCorrect(false);
             pageGardeReport.setIdFiscaleCellule("N49");
         } else {
             numIdentificationValue = cellCase.getStringCellValue();
         }

         //Recuperation sigleValue header
         cellReference = new CellReference("H39");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne H39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         if (cellCase.getCellType() == CellType.STRING) {
             sigleValue = cellCase.getStringCellValue();
         }

////         //Recuperation exerciceValue header
////         cellReference = new CellReference("B25");
////         rowCase = datatypeSheet.getRow(cellReference.getRow());
////         cellCase = rowCase.getCell(cellReference.getCol());
////         System.out.println("[ligne B25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
////         if (cellCase.getCellType() == CellType.STRING) {
////             exerciceValue = cellCase.getStringCellValue();
////         }

         if (pageGardeReport != null) {
             report.setPageGardeReport(pageGardeReport);
         }
         
         
         //*** Fin verification page de garde

         //*** Debut verification fiche renseignement
         datatypeSheet = workbook.getSheetAt(1);
         System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
         System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

         /* ??
         //Centre de dépôt
         cellReference = new CellReference("B15");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setCentreDepotObservation("Information non renseignée");
             ficheRenseignementReport.setCentreDepotIsCorrect(false);
         }
         */

         //Exercice clos
         try {
             cellReference = new CellReference("V9");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne V9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getCachedFormulaResultType());
             cellValue = evaluator.evaluate(cellCase);
             System.out.println(cellValue.getCellType());
            
             
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setExerciceClosObservation("Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setExerciceClosIsCorrect(false);
                 ficheRenseignementReport.setExerciceClosCellule("V9");
             }
         } catch (Exception ie) {// driver not found
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setExerciceClosObservation("Information non renseignée");
             ficheRenseignementReport.setExerciceClosIsCorrect(false);
             ficheRenseignementReport.setExerciceClosCellule("V9");
         }

         /*??
         //Denomination sociale
         cellReference = new CellReference("B15");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setDenominationSocialeObservation("Information non renseignée");
             ficheRenseignementReport.setDenominationSocialeIsCorrect(false);
         }
         */

         //Adress
         cellReference = new CellReference("J6");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne J6 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
        // System.out.println(cellCase.getStringCellValue());
         cellValue = evaluator.evaluate(cellCase);
         System.out.println(cellValue.getCellType());
         
         if (cellValue.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setAdresseObservation("Information non renseignée");
             ficheRenseignementReport.setAdresseIsCorrect(false);
             ficheRenseignementReport.setAdresseCellule("J6");
         }

         //Id fiscal
         try {
             cellReference = new CellReference("J9");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne J9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
             if (cellCase.getCellType() == CellType.BLANK) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée");
                 ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                 ficheRenseignementReport.setIdFiscaleCellule("J6");
             }
         } catch (Exception ie) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setIdFiscaleObservation("Format incorrect de l'information renseignée");
             ficheRenseignementReport.setIdFiscaleIsCorrect(false);
             ficheRenseignementReport.setIdFiscaleCellule("J6");
         }

         //Exerice comptable debut
         cellReference = new CellReference("Y12");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne Y12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         cellValue = evaluator.evaluate(cellCase);
         
         if(cellValue==null) 
         {
        	 
        	 if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée");
             ficheRenseignementReport.setExerciceComptableIsCorrect(false);
             ficheRenseignementReport.setExerciceComptableCellule("Y12");
        	 
         } else
         
         if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setExerciceComptableObservation("Format incorrect de l'information renseignée");
             ficheRenseignementReport.setExerciceComptableIsCorrect(false);
             ficheRenseignementReport.setExerciceComptableCellule("Y12");
         }
         

         //Exerice comptable fin
         cellReference = new CellReference("AH12");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         cellValue = evaluator.evaluate(cellCase);
        // System.out.println(cellValue.getCellType());
         
         if(cellValue==null) 
         {
        	
        	 if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée");
             ficheRenseignementReport.setExerciceComptableIsCorrect(false);
             ficheRenseignementReport.setExerciceComptableCellule("AH12");
        	 
         } else
         
         if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setExerciceComptableObservation("Format incorrect de l'information renseignée");
             ficheRenseignementReport.setExerciceComptableIsCorrect(false);
             ficheRenseignementReport.setExerciceComptableCellule("AH12");
         }

         //Date arret compte
         try {
             cellReference = new CellReference("U15");
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne U15 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getCachedFormulaResultType());
             cellValue = evaluator.evaluate(cellCase);
             System.out.println(cellValue.getCellType());
             if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                 if (ficheRenseignementReport == null) {
                     ficheRenseignementReport = new FicheRenseignementReport();
                     report.setErrorExist(true);
                 }
                 ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée /Format incorrect de l'information renseignée");
                 ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                 ficheRenseignementReport.setDateArreteComptesCellule("U15");
             }
         } catch (Exception ie) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée");
             ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
             ficheRenseignementReport.setDateArreteComptesCellule("U15");
         }

         //Greffe
         cellReference = new CellReference("F23");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne F23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
//         if (cellCase.getCellType() != CellType.STRING) {
//             if (ficheRenseignementReport == null) {
//                 ficheRenseignementReport = new FicheRenseignementReport();
//                 report.setErrorExist(true);
//             }
//             ficheRenseignementReport.setGreffeObservation("Information non renseignée");
//             ficheRenseignementReport.setGreffeIsCorrect(false);
//         }

         //Num registre commerce
         cellReference = new CellReference("I23");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne I23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setNumRegistreCommerceObservation("Information non renseignée");
             ficheRenseignementReport.setNumRegistreCommerceIsCorrect(false);
             ficheRenseignementReport.setNumRegistreCommerceCellule("I23");
         }

         //Num Securite Sociale
         cellReference = new CellReference("G27");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//         if (cellCase.getCellType() == CellType.BLANK) {
//             if (ficheRenseignementReport == null) {
//                 ficheRenseignementReport = new FicheRenseignementReport();
//                 report.setErrorExist(true);
//             }
//             ficheRenseignementReport.setNumSecuriteSocialeObservation("Information non renseignée");
//             ficheRenseignementReport.setNumSecuriteSocialeIsCorrect(false);
//         }

         //Designation Entreprise
         //1
         cellReference = new CellReference("J3");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne J3 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         if (cellCase.getCellType() == CellType.BLANK) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
             ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
             ficheRenseignementReport.setDesignationEntrepriseCellule("J3");
             
         }
         //2
         cellReference = new CellReference("D31");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne D31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         if (cellCase.getCellType() == CellType.BLANK) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setDesignationEntrepriseObservation("Information non renseignée");
             ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
             ficheRenseignementReport.setDesignationEntrepriseCellule("D31");
         }

         //Telephone
         cellReference = new CellReference("G35");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if ((cellCase.getCellType() != CellType.STRING) && (cellCase.getCellType() != CellType.NUMERIC)) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setNumTelephoneObservation("Information non renseignée");
             ficheRenseignementReport.setNumTelephoneIsCorrect(false);
             ficheRenseignementReport.setNumTelephoneCellule("G35");
         }

         //Ville
         cellReference = new CellReference("AE35");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne AE35 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setVilleObservation("Information non renseignée");
             ficheRenseignementReport.setVilleIsCorrect(false);
             ficheRenseignementReport.setVilleCellule("AE35");
         }

         //Adresse Geographique
         cellReference = new CellReference("D39");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne D39 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() == CellType.BLANK) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setAdresseGeographiqueObservation("Information non renseignée");
             ficheRenseignementReport.setAdresseGeographiqueIsCorrect(false);
             ficheRenseignementReport.setAdresseGeographiqueCellule("D39");
         }

         //Designation Activite Exercee
         cellReference = new CellReference("D43");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne D43 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setDesignationActiviteExerceeObservation("Information non renseignée");
             ficheRenseignementReport.setDesignationActiviteExerceeIsCorrect(false);
             ficheRenseignementReport.setDesignationActiviteExerceeCellule("D43");
         }

         //Personne A Contacter
         cellReference = new CellReference("D47");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne D47 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setPersonneAContacterObservation("Information non renseignée");
             ficheRenseignementReport.setPersonneAContacterIsCorrect(false);
             ficheRenseignementReport.setPersonneAContacterCellule("D47");
         }

         //Professionnel Ou Cabinet Comptable AuteurEF
         cellReference = new CellReference("D51");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFObservation("Information non renseignée");
             ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFIsCorrect(false);
             ficheRenseignementReport.setProfessionnelOuCabinetComptableAuteurEFCellule("D51");
         }

         //Commissaire Au Compte
         cellReference = new CellReference("D55");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
//         if (cellCase.getCellType() != CellType.STRING) {
//             if (ficheRenseignementReport == null) {
//                 ficheRenseignementReport = new FicheRenseignementReport();
//                 report.setErrorExist(true);
//             }
//             ficheRenseignementReport.setCommissaireAuCompteObservation("Information non renseignée");
//             ficheRenseignementReport.setCommissaireAuCompteIsCorrect(false);
//         }

         //Qualite du Signataire
         cellReference = new CellReference("D71");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.STRING) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setQualiteDuSignataireObservation("Information non renseignée");
             ficheRenseignementReport.setQualiteDuSignataireIsCorrect(false);
             ficheRenseignementReport.setQualiteDuSignataireCellule("D71");
             
         }

         //Date Signature
         cellReference = new CellReference("D74");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         System.out.println("[ligne D74 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
         //System.out.println(cellCase.getStringCellValue());
         if (cellCase.getCellType() != CellType.NUMERIC) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             ficheRenseignementReport.setDateSignatureObservation("Information non renseignée");
             ficheRenseignementReport.setDateSignatureIsCorrect(false);
             ficheRenseignementReport.setDateSignatureCellule("D74");
         }

         //Banque
         String [] cellulesBanques = {"T70", "T71", "T72"}  ; // tableau de cellules à verifier
         Boolean isEmptyName = true;
         for(int i=0; i<cellulesBanques.length; i++) {
             cellReference = new CellReference(cellulesBanques[i]);
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             if (cellCase.getCellType() == CellType.STRING) {
             	isEmptyName = false ;
                 break;
             }
            }
         if(isEmptyName) {
         	
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                report.setErrorExist(true);
            }
             /*ficheRenseignementReport.setBanqueObservation("Nom banque non renseignée");
             ficheRenseignementReport.setBanqueIsCorrect(false);*/
             
             ficheRenseignementReport.errorMap.put("Banque(s)", "Nom banque non renseignée");
             ficheRenseignementReport.errorCelluleMap.put("Banque(s)", "Cellule[T70-T71-T72]");
        		
             
             
             
         }
         //Numero
         String [] cellulesNumero = {"AD70", "AD71", "AD72"}  ; // tableau de cellules à verifier
         Boolean isEmptyNumero  = true ;
         for(int i=0; i<cellulesNumero.length; i++) {
             cellReference = new CellReference(cellulesNumero[i]);
             rowCase = datatypeSheet.getRow(cellReference.getRow());
             cellCase = rowCase.getCell(cellReference.getCol());
             System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
             //System.out.println(cellCase.getStringCellValue());

             if (cellCase.getCellType() == CellType.STRING) {
             	isEmptyNumero = false ;
                 break;
             }

         }
         if (isEmptyNumero) {
             if (ficheRenseignementReport == null) {
                 ficheRenseignementReport = new FicheRenseignementReport();
                 report.setErrorExist(true);
             }
             
             /*ficheRenseignementReport.setNumeroObservation("compte bancaire non renseignée");
             ficheRenseignementReport.setNumeroIsCorrect(false);*/
             
             ficheRenseignementReport.errorMap.put("Numéro(s)", "Compte bancaire non renseignée");
             ficheRenseignementReport.errorCelluleMap.put("Numéro(s)", "Cellule[AD70-AD71-AD72]");
             
         }
         
         //FIn  bank
         if (ficheRenseignementReport != null) {
             report.setFicheRenseignementReport(ficheRenseignementReport);
         }
         //*** Fin verification fiche renseignement

         
         //debut de verification bilan actif
         
         
        //Debut bilan
         datatypeSheet = workbook.getSheetAt(2);
         System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
         System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
         
         
         
         boolean    nombreColonneOk=true;
         
         cellReference = new CellReference("D13");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         cellValue = evaluator.evaluate(cellCase);
         
              if(cellValue==null) {
              	 nombreColonneOk=false;
              	
              } else
            if (cellValue.getCellType() == CellType.BLANK) 
            {
          	  nombreColonneOk=false;
          }
            else
      	   if (cellValue.getCellType() == CellType.STRING) 
      	   {
      		   
      		   if(cellValue.getStringValue().equalsIgnoreCase("( en  millions  de  F  CFA )")) 
      		   {
      			   nombreColonneOk=true;
      			   
      		   }
      		   else
      		   {
      			   nombreColonneOk=false;
      		   }
      		   
      		   
      	   }else
      	   {
      		   nombreColonneOk=false;  
      		   
      	   }
      	   
      	   
    System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
        
        
    if(!nombreColonneOk) 
    {
    	
  	  if (bilanActifReport == null) {
  		bilanActifReport = new BilanActifReport();
            report.setErrorExist(true);
        }
  	  
  	bilanActifReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
		
    	
    } else {
    	
    	
// Fin Gestion du nombre de ligne
        
        
    	
 boolean    nombreLigneOk=true;
         
         cellReference = new CellReference("B47");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         cellValue = evaluator.evaluate(cellCase);
         
              if(cellValue==null) {
            	  nombreLigneOk=false;
              	
              } else
            if (cellValue.getCellType() == CellType.BLANK) 
            {
            	nombreLigneOk=false;
          }
            else
      	   if (cellValue.getCellType() == CellType.STRING) 
      	   {
      		   
      		   if(cellValue.getStringValue().equalsIgnoreCase("TOTAL DE L'ACTIF")) 
      		   {
      			 nombreLigneOk=true;
      			   
      		   }
      		   else
      		   {
      			 nombreLigneOk=false;
      		   }
      		   
      		   
      	   }else
      	   {
      		 nombreLigneOk=false;  
      		   
      	   }
      	   
      	   
    System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     
        
    	
    
    
    
    	
     
        if (!nombreLigneOk) {
        	
        	if (bilanActifReport == null) {
          		bilanActifReport = new BilanActifReport();
                    report.setErrorExist(true);
                }
          	  
          	bilanActifReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
       		
        	
            
        }else {
        	
        	
        	
        	
        	for (int index=17 ;index<=52;index++) 
            {
          	  
          	 // Debut cellule C
          	  
          	  cellReference = new CellReference("C"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
          	  
          	  if( rowCase==null) {
          		  
          	  }
          	  
          	  else {
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                
                 
                if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
                {
              	  
              	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
              	  
              	  if (bilanActifReport == null) {
              		bilanActifReport = new BilanActifReport();
                        report.setErrorExist(true);
                    }
              	  
              	  String nomCellule="[" +"C"+index+ "]";
              	  
              	  cellReference = new CellReference("B"+index); 
              	  
              	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                    cellCase = rowCase.getCell(cellReference.getCol());
                    cellValue = evaluator.evaluate(cellCase);
                    
                    
                    if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                    {
                  	  nomCellule=cellValue.getStringValue();
                  	 
                  	  
                    }
              	  

              	  
                    bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                    bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
              	  
              	  
                }
                
             // Fin cellule C
                
                
                
              // Debut cellule D
          	  
          	  cellReference = new CellReference("D"+index); 
          	  
          	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                cellCase = rowCase.getCell(cellReference.getCol());
                cellValue = evaluator.evaluate(cellCase);
                
                 
                if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
                {
              	  
              	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
              	  
              	  if (bilanActifReport == null) {
              		bilanActifReport = new BilanActifReport();
                        report.setErrorExist(true);
                    }
              	  
              	  
                  String nomCellule="[" +"D"+index+ "]";
              	  
              	  cellReference = new CellReference("B"+index); 
              	  
              	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                    cellCase = rowCase.getCell(cellReference.getCol());
                    cellValue = evaluator.evaluate(cellCase);
                    
                    
                    if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
                    {
                  	  nomCellule=cellValue.getStringValue();
                  	 
                  	  
                    }
              	  
              	  
              	  
              	  
                    bilanActifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
                    bilanActifReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
              	  
              	  
                }
                
               // Fin cellule D
                
          	  } 
                
            }
            
            
            
            //Gestion des references Poste
        	
        	
        	 
            for (int index=18 ;index<=44 ;index=index+2) 
            {
            	
            
            //  referrenceBilan1
                cellReference = new CellReference("A"+index); 
           	  
           	  rowCase = datatypeSheet.getRow(cellReference.getRow());
                 cellCase = rowCase.getCell(cellReference.getCol());
                 cellValue = evaluator.evaluate(cellCase);
            	
            	
               
                 //  referrenceBilan1
                 if (!(cellValue == null ) && (cellValue.getCellType()==CellType.NUMERIC) )
                 {
               	  
               	  if (cellValue.getNumberValue()!=ReferencePosteMap.get(index+""))
               	  {
               		
               		  if (bilanActifReport == null) {
               			bilanActifReport = new BilanActifReport();
                             report.setErrorExist(true);
                         }
               		
               		bilanActifReport.errorMap.put(ReferencePosteMap.get(index+"")+"", "Libellé Poste modifié");
               		bilanActifReport.errorCelluleMap.put(ReferencePosteMap.get(index+"")+"", "[" +"A"+index+ "]");
                        
               		  
               	  }
               	  
               	  
               	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
                   	  
                 } else 
                 {
               	
               	  if (bilanActifReport == null) {
               		bilanActifReport = new BilanActifReport();
                         report.setErrorExist(true);
                     }
           		
               	bilanActifReport.errorMap.put(ReferencePosteMap.get(index+"")+"", "Poste inexistant");
               	bilanActifReport.errorCelluleMap.put(ReferencePosteMap.get(index+"")+"", "[" +"A"+index+ "]");
                    
               	  
                 }
                 
             //  referrenceBilan1
                 
            	
            	
            	
            }
        	
        	//Fin gestion des reference Poste
        	
        	
        	
        	
        	
        	
        	
        }
    	
    	
    	
    	
    }  //Fin de tester nombre de ligne bilan actif
         

	if (bilanActifReport != null) {
        report.setBilanActifReport(bilanActifReport);
    }
    //*** Fin bilan
	  
         
         
   //Fin Verification Bilan actif
	
	
	
	//debut verification bilan passif
	
	
	
	//Debut bilan
    datatypeSheet = workbook.getSheetAt(3);
    System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
    System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
    
    
    
     nombreColonneOk=true;
    
    cellReference = new CellReference("D13");
    rowCase = datatypeSheet.getRow(cellReference.getRow());
    cellCase = rowCase.getCell(cellReference.getCol());
    cellValue = evaluator.evaluate(cellCase);
    
         if(cellValue==null) {
         	 nombreColonneOk=false;
         	
         } else
       if (cellValue.getCellType() == CellType.BLANK) 
       {
     	  nombreColonneOk=false;
     }
       else
 	   if (cellValue.getCellType() == CellType.STRING) 
 	   {
 		   
 		   if(cellValue.getStringValue().equalsIgnoreCase("( en  millions  de  F  CFA )")) 
 		   {
 			   nombreColonneOk=true;
 			   
 		   }
 		   else
 		   {
 			   nombreColonneOk=false;
 		   }
 		   
 		   
 	   }else
 	   {
 		   nombreColonneOk=false;  
 		   
 	   }
 	   
 	   
System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     
   
   
if(!nombreColonneOk) 
{
	
	  if (bilanPassifReport == null) {
		 bilanPassifReport = new BilanPassifReport();
       report.setErrorExist(true);
   }
	  
	bilanPassifReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");
	
	
} else {
	
	
//Fin Gestion du nombre de ligne
   
   
	
boolean    nombreLigneOk=true;
    
    cellReference = new CellReference("B51");
    rowCase = datatypeSheet.getRow(cellReference.getRow());
    cellCase = rowCase.getCell(cellReference.getCol());
    cellValue = evaluator.evaluate(cellCase);
    
         if(cellValue==null) {
       	  nombreLigneOk=false;
         	
         } else
       if (cellValue.getCellType() == CellType.BLANK) 
       {
       	nombreLigneOk=false;
     }
       else
 	   if (cellValue.getCellType() == CellType.STRING) 
 	   {
 		   
 		   if(cellValue.getStringValue().equalsIgnoreCase("TOTAL DU PASSIF")) 
 		   {
 			 nombreLigneOk=true;
 			   
 		   }
 		   else
 		   {
 			 nombreLigneOk=false;
 		   }
 		   
 		   
 	   }else
 	   {
 		 nombreLigneOk=false;  
 		   
 	   }
 	   
 	   
System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     
   
	



	

   if (!nombreLigneOk) {
   	
   	if (bilanPassifReport == null) {
   		bilanPassifReport = new BilanPassifReport();
               report.setErrorExist(true);
           }
     	  
   	bilanPassifReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
  		
   	
       
   }else {
   	
   	
   	
   	
   	for (int index=17 ;index<=52;index++) 
       {
     	  
     	 // Debut cellule C
     	  
     	  cellReference = new CellReference("C"+index); 
     	  
     	  rowCase = datatypeSheet.getRow(cellReference.getRow());
           cellCase = rowCase.getCell(cellReference.getCol());
           cellValue = evaluator.evaluate(cellCase);
           
            
           if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
           {
         	  
         	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
         	  
         	  if (bilanPassifReport == null) {
         		 bilanPassifReport = new BilanPassifReport();
                   report.setErrorExist(true);
               }
         	  
         	  String nomCellule="[" +"C"+index+ "]";
         	  
         	  cellReference = new CellReference("B"+index); 
         	  
         	  rowCase = datatypeSheet.getRow(cellReference.getRow());
               cellCase = rowCase.getCell(cellReference.getCol());
               cellValue = evaluator.evaluate(cellCase);
               
               
               if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
               {
             	  nomCellule=cellValue.getStringValue();
             	 
             	  
               }
         	  

         	  
               bilanPassifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
               bilanPassifReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
         	  
         	  
           }
           
        // Fin cellule C
           
           
           
         // Debut cellule D
     	  
     	  cellReference = new CellReference("D"+index); 
     	  
     	  rowCase = datatypeSheet.getRow(cellReference.getRow());
           cellCase = rowCase.getCell(cellReference.getCol());
           cellValue = evaluator.evaluate(cellCase);
           
            
           if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
           {
         	  
         	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
         	  
         	  if (bilanPassifReport == null) {
         		 bilanPassifReport = new BilanPassifReport();
                   report.setErrorExist(true);
               }
         	  
         	  
             String nomCellule="[" +"D"+index+ "]";
         	  
         	  cellReference = new CellReference("B"+index); 
         	  
         	  rowCase = datatypeSheet.getRow(cellReference.getRow());
               cellCase = rowCase.getCell(cellReference.getCol());
               cellValue = evaluator.evaluate(cellCase);
               
               
               if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
               {
             	  nomCellule=cellValue.getStringValue();
             	 
             	  
               }
         	  
         	  
         	  
         	  
               bilanPassifReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
               bilanPassifReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
         	  
         	  
           }
           
          // Fin cellule D
           
           
           
       }
       
       
       
       //Gestion des references Poste
   	
   	
   	 
       for (int index=18 ;index<=48 ;index=index+2) 
       {
       	
       
       //  referrenceBilan1
           cellReference = new CellReference("A"+index); 
      	  
      	  rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
       	
       	
          
            //  referrenceBilan1
            if (!(cellValue == null ) && (cellValue.getCellType()==CellType.NUMERIC) )
            {
          	  
          	  if (cellValue.getNumberValue()!=ReferencePosteMap.get(index+""))
          	  {
          		
          		  if (bilanPassifReport == null) {
          			bilanPassifReport = new BilanPassifReport();
                        report.setErrorExist(true);
                    }
          		
          		bilanPassifReport.errorMap.put(ReferencePosteMap.get(index+"")+"", "Libellé Poste modifié");
          		bilanPassifReport.errorCelluleMap.put(ReferencePosteMap.get(index+"")+"", "[" +"A"+index+ "]");
                   
          		  
          	  }
          	  
          	  
          	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
              	  
            } else 
            {
          	
          	  if (bilanPassifReport == null) {
          		bilanPassifReport = new BilanPassifReport();
                    report.setErrorExist(true);
                }
      		
          	bilanPassifReport.errorMap.put(ReferencePosteMap.get(index+"")+"", "Poste inexistant");
          	bilanPassifReport.errorCelluleMap.put(ReferencePosteMap.get(index+"")+"", "[" +"A"+index+ "]");
               
          	  
            }
            
        //  referrenceBilan1
            
       	
       	
       	
       }
   	
   	//Fin gestion des reference Poste
   	
   	
   }
	
	
	
	
}  //Fin de tester nombre de ligne bilan actif
    

if (bilanPassifReport!= null) {
   report.setBilanPassifReport(bilanPassifReport);
}
//*** Fin bilan
  
	
	
	
	
	//Fin verification bilan passif



//Bebut de verification hors bilan



//Debut  hors bilan
datatypeSheet = workbook.getSheetAt(4);
System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");


 nombreColonneOk=true;

cellReference = new CellReference("D13");
rowCase = datatypeSheet.getRow(cellReference.getRow());
cellCase = rowCase.getCell(cellReference.getCol());
cellValue = evaluator.evaluate(cellCase);

     if(cellValue==null) {
     	 nombreColonneOk=false;
     	
     } else
   if (cellValue.getCellType() == CellType.BLANK) 
   {
 	  nombreColonneOk=false;
 }
   else
	   if (cellValue.getCellType() == CellType.STRING) 
	   {
		   
		   if(cellValue.getStringValue().equalsIgnoreCase("( en  millions  de  F  CFA )")) 
		   {
			   nombreColonneOk=true;
			   
		   }
		   else
		   {
			   nombreColonneOk=false;
		   }
		   
		   
	   }else
	   {
		   nombreColonneOk=false;  
		   
	   }
	   
	   
System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     


if(!nombreColonneOk) 
{

  if (horsBilanReport == null) {
	  horsBilanReport = new HorsBilanReport();
   report.setErrorExist(true);
}
  
  horsBilanReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");


} else {


//Fin Gestion du nombre de ligne



boolean    nombreLigneOk=true;

cellReference = new CellReference("B33");
rowCase = datatypeSheet.getRow(cellReference.getRow());
cellCase = rowCase.getCell(cellReference.getCol());
cellValue = evaluator.evaluate(cellCase);

     if(cellValue==null) {
   	  nombreLigneOk=false;
     	
     } else
   if (cellValue.getCellType() == CellType.BLANK) 
   {
   	nombreLigneOk=false;
 }
   else
	   if (cellValue.getCellType() == CellType.STRING) 
	   {
		   
		   if(cellValue.getStringValue().equalsIgnoreCase("ENGAGEMENTS SUR TITRES")) 
		   {
			 nombreLigneOk=true;
			   
		   }
		   else
		   {
			 nombreLigneOk=false;
		   }
		   
		   
	   }else
	   {
		 nombreLigneOk=false;  
		   
	   }
	   
	   
System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     







if (!nombreLigneOk) {
	
	if (horsBilanReport == null) {
		horsBilanReport = new HorsBilanReport();
           report.setErrorExist(true);
       }
 	  
	horsBilanReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
		
	
   
}else {
	
	
	
	
	for (int index=19 ;index<=35;index++) 
   {
 	  
 	 // Debut cellule C
 	  
 	  cellReference = new CellReference("C"+index); 
 	  
 	  rowCase = datatypeSheet.getRow(cellReference.getRow());
       cellCase = rowCase.getCell(cellReference.getCol());
       cellValue = evaluator.evaluate(cellCase);
       
        
       if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
       {
     	  
     	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
     	  
     	  if (horsBilanReport == null) {
     		 horsBilanReport = new HorsBilanReport();
               report.setErrorExist(true);
           }
     	  
     	  String nomCellule="[" +"C"+index+ "]";
     	  
     	  cellReference = new CellReference("B"+index); 
     	  
     	  rowCase = datatypeSheet.getRow(cellReference.getRow());
           cellCase = rowCase.getCell(cellReference.getCol());
           cellValue = evaluator.evaluate(cellCase);
           
           
           if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
           {
         	  nomCellule=cellValue.getStringValue();
         	 
         	  
           }
     	  

     	  
           horsBilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
           horsBilanReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
     	  
     	  
       }
       
    // Fin cellule C
       
       
       
     // Debut cellule D
 	  
 	  cellReference = new CellReference("D"+index); 
 	  
 	  rowCase = datatypeSheet.getRow(cellReference.getRow());
       cellCase = rowCase.getCell(cellReference.getCol());
       cellValue = evaluator.evaluate(cellCase);
       
        
       if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
       {
     	  
     	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
     	  
     	  if (horsBilanReport == null) {
     		 horsBilanReport = new HorsBilanReport();
               report.setErrorExist(true);
           }
     	  
     	  
         String nomCellule="[" +"D"+index+ "]";
     	  
     	  cellReference = new CellReference("B"+index); 
     	  
     	  rowCase = datatypeSheet.getRow(cellReference.getRow());
           cellCase = rowCase.getCell(cellReference.getCol());
           cellValue = evaluator.evaluate(cellCase);
           
           
           if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
           {
         	  nomCellule=cellValue.getStringValue();
         	 
         	  
           }
     	  
     	  
     	  
     	  
           horsBilanReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
           horsBilanReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
     	  
     	  
       }
       
      // Fin cellule D
       
       
       
   }
   
   
   
   //Gestion des references Poste
	
	
	 
   for (int index=20 ;index<=33 ;index++) 
   {
   	
   
   //  referrenceBilan1
	   
	   if(index==20 ||index==22 || index==24 ||index==29 ||index==31 ||index==33)
	   
	   {
       cellReference = new CellReference("A"+index); 
  	  
  	  rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);
   	
   	
      
        //  referrenceBilan1
        if (!(cellValue == null ) && (cellValue.getCellType()==CellType.NUMERIC) )
        {
      	  
      	  if (cellValue.getNumberValue()!=ReferencePosteHorsBilanMap.get(index+""))
      	  {
      		
      		  if (horsBilanReport == null) {
      			horsBilanReport = new HorsBilanReport();
                    report.setErrorExist(true);
                }
      		
      		horsBilanReport.errorMap.put(ReferencePosteHorsBilanMap.get(index+"")+"", "Libellé Poste modifié");
      		horsBilanReport.errorCelluleMap.put(ReferencePosteHorsBilanMap.get(index+"")+"", "[" +"A"+index+ "]");
               
      		  
      	  }
      	  
      	  
      	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
          	  
        } else 
        {
      	
      	  if (horsBilanReport == null) {
      		horsBilanReport = new HorsBilanReport();
                report.setErrorExist(true);
            }
  		
      	horsBilanReport.errorMap.put(ReferencePosteHorsBilanMap.get(index+"")+"", "Poste inexistant");
      	horsBilanReport.errorCelluleMap.put(ReferencePosteHorsBilanMap.get(index+"")+"", "[" +"A"+index+ "]");
           
      	  
        }
        
    //  referrenceBilan1
        
   	
   	
   	
   }
	
	//Fin gestion des reference Poste
	
   } // Fin condition
}




}  //Fin de tester nombre de ligne bilan actif


if (horsBilanReport!= null) {
report.setHorsBilanReport(horsBilanReport);
}
//*** Fin bilan




//Fin de verification hors bilan
	
       
//Debut de verification compte de resultat


//Debut  compteResultat
datatypeSheet = workbook.getSheetAt(5);
System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");


nombreColonneOk=true;

cellReference = new CellReference("D12");
rowCase = datatypeSheet.getRow(cellReference.getRow());
cellCase = rowCase.getCell(cellReference.getCol());
cellValue = evaluator.evaluate(cellCase);

 if(cellValue==null) {
 	 nombreColonneOk=false;
 	
 } else
if (cellValue.getCellType() == CellType.BLANK) 
{
	  nombreColonneOk=false;
}
else
   if (cellValue.getCellType() == CellType.STRING) 
   {
	   
	   if(cellValue.getStringValue().equalsIgnoreCase("( en  millions  de  F  CFA )")) 
	   {
		   nombreColonneOk=true;
		   
	   }
	   else
	   {
		   nombreColonneOk=false;
	   }
	   
	   
   }else
   {
	   nombreColonneOk=false;  
	   
   }
   
   
System.out.println("----------------------------boolean   nombreColonneOk [" + nombreColonneOk + "]");     


if(!nombreColonneOk) 
{

if (compteResultatReport == null) {
  compteResultatReport = new CompteResultatReport();
report.setErrorExist(true);
}

compteResultatReport.errorMap.put("Nombre de colonne", "Nombre de colonne du tableau différent de celui du modèle");


} else {


//Fin Gestion du nombre de ligne



boolean    nombreLigneOk=true;

cellReference = new CellReference("B56");
rowCase = datatypeSheet.getRow(cellReference.getRow());
cellCase = rowCase.getCell(cellReference.getCol());
cellValue = evaluator.evaluate(cellCase);

 if(cellValue==null) {
	  nombreLigneOk=false;
 	
 } else
if (cellValue.getCellType() == CellType.BLANK) 
{
	nombreLigneOk=false;
}
else
   if (cellValue.getCellType() == CellType.STRING) 
   {
	   
	   if(cellValue.getStringValue().equalsIgnoreCase("RESULTAT NET")) 
	   {
		 nombreLigneOk=true;
		   
	   }
	   else
	   {
		 nombreLigneOk=false;
	   }
	   
	   
   }else
   {
	 nombreLigneOk=false;  
	   
   }
   
   
System.out.println("----------------------------boolean   nombreLigneOk [" + nombreLigneOk + "]");     







if (!nombreLigneOk) {

if (compteResultatReport == null) {
	compteResultatReport = new CompteResultatReport();
       report.setErrorExist(true);
   }
	  
compteResultatReport.errorMap.put("Nombre de ligne", "Nombre de ligne du tableau différent de celui du modèle");
	


}else {




for (int index=16 ;index<=56;index++) 
{
	  
	 // Debut cellule C
	  
	  cellReference = new CellReference("C"+index); 
	  
	  rowCase = datatypeSheet.getRow(cellReference.getRow());
   cellCase = rowCase.getCell(cellReference.getCol());
   cellValue = evaluator.evaluate(cellCase);
   
    
   if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) && ((cellValue.getCellType()==CellType.STRING ) && (!cellValue.getStringValue().equals("-"))) )
   {
 	  
 	  System.out.println("erreur de format[" +"C"+index+ "]  "+ cellValue  +"--");
 	  
 	  if (compteResultatReport == null) {
 		 compteResultatReport = new CompteResultatReport();
           report.setErrorExist(true);
       }
 	  
 	  String nomCellule="[" +"C"+index+ "]";
 	  
 	  cellReference = new CellReference("B"+index); 
 	  
 	  rowCase = datatypeSheet.getRow(cellReference.getRow());
       cellCase = rowCase.getCell(cellReference.getCol());
       cellValue = evaluator.evaluate(cellCase);
       
       
       if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
       {
     	  nomCellule=cellValue.getStringValue();
     	 
     	  
       }
 	  

 	  
       compteResultatReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
       compteResultatReport.errorCelluleMap.put(nomCellule, "[" +"C"+index+ "]");
 	  
 	  
   }
   
// Fin cellule C
   
   
   
 // Debut cellule D
	  
	  cellReference = new CellReference("D"+index); 
	  
	  rowCase = datatypeSheet.getRow(cellReference.getRow());
   cellCase = rowCase.getCell(cellReference.getCol());
   cellValue = evaluator.evaluate(cellCase);
   
    
   if (!(cellValue == null ) && (cellValue.getCellType() != CellType.NUMERIC) )
   {
 	  
 	//  System.out.println("erreur de format[" +"E"+index+ "]  "+ cellValue  +"--");
 	  
 	  if (compteResultatReport == null) {
 		 compteResultatReport = new CompteResultatReport();
           report.setErrorExist(true);
       }
 	  
 	  
     String nomCellule="[" +"D"+index+ "]";
 	  
 	  cellReference = new CellReference("B"+index); 
 	  
 	  rowCase = datatypeSheet.getRow(cellReference.getRow());
       cellCase = rowCase.getCell(cellReference.getCol());
       cellValue = evaluator.evaluate(cellCase);
       
       
       if (!(cellValue == null ) && (cellValue.getCellType() == CellType.STRING))
       {
     	  nomCellule=cellValue.getStringValue();
     	 
     	  
       }
 	  
 	  
 	  
 	  
       compteResultatReport.errorMap.put(nomCellule, "Format incorrect de l'information renseignée");
       compteResultatReport.errorCelluleMap.put(nomCellule, "[" +"D"+index+ "]");
 	  
 	  
   }else 
   {
   	
   	if(index==36)
   	{
   		
   		if ((cellValue!=null) &&(cellValue.getCellType() == CellType.NUMERIC))
           {
         	  
          chiffreAffaire=cellValue.getNumberValue()+"";	
           }
   		
   		
   	}
   	
   	
   	
   	if(index==56)
   	{
   		
   		if ((cellValue!=null) &&(cellValue.getCellType() == CellType.NUMERIC))
           {
         	resultatNet=cellValue.getNumberValue()+"";	
           }
   		
   		
   	}
   	
   }
   
  // Fin cellule D
   
   
   
}



//Gestion des references Poste


//Gestion des references Poste
	
	
	 
for (int index=18 ;index<=56 ;index=index+2) 
{
	

//  referrenceBilan1
    cellReference = new CellReference("A"+index); 
	  
	  rowCase = datatypeSheet.getRow(cellReference.getRow());
     cellCase = rowCase.getCell(cellReference.getCol());
     cellValue = evaluator.evaluate(cellCase);
	
	
   
     //  referrenceBilan1
     if (!(cellValue == null ) && (cellValue.getCellType()==CellType.NUMERIC) )
     {
   	  
   	  if (cellValue.getNumberValue()!=ReferencePosteMap.get(index+""))
   	  {
   		
   		  if (compteResultatReport == null) {
   			compteResultatReport = new CompteResultatReport();
                 report.setErrorExist(true);
             }
   		
   		compteResultatReport.errorMap.put(ReferencePosteMap.get(index+"")+"", "Libellé Poste modifié");
   		compteResultatReport.errorCelluleMap.put(ReferencePosteMap.get(index+"")+"", "[" +"A"+index+ "]");
            
   		  
   	  }
   	  
   	  
   	  System.out.println("refernce A"+index+ "]  "+ cellValue.getStringValue()  +"--");
       	  
     } else 
     {
   	
   	  if (compteResultatReport == null) {
   		compteResultatReport = new CompteResultatReport();
             report.setErrorExist(true);
         }
		
   	compteResultatReport.errorMap.put(ReferencePosteMap.get(index+"")+"", "Poste inexistant");
   	compteResultatReport.errorCelluleMap.put(ReferencePosteMap.get(index+"")+"", "[" +"A"+index+ "]");
        
   	  
     }
     
 //  referrenceBilan1
     
	
	
	
}

//Fin gestion des reference Poste
 


}




}  //Fin de tester nombre de ligne bilan actif


if (compteResultatReport!= null) {
report.setCompteResultatReport(compteResultatReport);
}
//*** Fin bilan







//Fin de verification fin compte resultat


         
         }  //fin nombre de page
         
         }
         
         if (report.errorExist) {
             HeaderReport headerReport = new HeaderReport();

             headerReport.setDesignationValue(designationValue);
             headerReport.setAdresseValue(adresseValue);
             headerReport.setNumIdentificationValue(numIdentificationValue);
             headerReport.setSigleValue(sigleValue);
             headerReport.setExerciceValue(exerciceValue);

             report.setHeaderReport(headerReport);
         } else {
             ExcelData excelData = new ExcelData();

             excelData.setEntreprise(designationValue);
             excelData.setNinea(numIdentificationValue);
             excelData.setTotalBilan(totalBilan); // pour banque
             excelData.setCapitalPropre(capitalPropre);
             excelData.setResultatNet(resultatNet);
             excelData.setChiffreAffaire(chiffreAffaire);
             
          
             System.out.println("chiffreAffaire------------------------>"+chiffreAffaire);
             System.out.println("resultatNet------------------------>"+resultatNet);
             

             report.setExcelData(excelData);
         }

         //String reportFileName = "Rapport de conformité_test.xlsx";
         excelFile.close();
         createReport(report, filePath, rapportFileName);
     } catch (Exception e) {
         report = null;
         System.out.println("xxxxxxx");
         e.printStackTrace();
         System.out.println("yyyyyyy");


     } finally {

         try {
             // He was careful to close streams in finally block, but it’s not complete
             // Can you spot error?

             if (excelFile != null)
                 excelFile.close();

         } catch (IOException e) {
             System.out.println("Failed to close streams");
         }

     }

     System.out.println("======> Fin verification excel");
     //2222222222222222222222222222222222222222222222222222222222222222222222

     return report;
		 
		 
	    }
	        
         	
	
	//Fin de la gestion du depot Banque
 
 
 
 
 
 
 //Fin de la gestion des gestion Assurance
 
 
 
	 
	 //Gestion du ficher des  clients 
	 
	 
	 
 public static FileVerificatorDto verifyExcelListeClient(String filePath) {
		
		 String messageErreur="";
		
         int nombrePageExcel=0;
         
         FileVerificatorDto resultat= new FileVerificatorDto(true,messageErreur);
         
         boolean verifyError = false;
         boolean verifiLineResult = false;
       
       
    
     
     //1111111111111111111111111111111111111111111111111111111111111111111111
     System.out.println("======> Debut verification excel  lise des client");
     String fileLocation = filePath;
     FileInputStream excelFile = null;

     try {
         try {
			excelFile = new FileInputStream(new File(fileLocation));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			messageErreur="Fichier non trouvé";
			resultat.setStatut(false);
			resultat.setMessage(messageErreur);
			return resultat;
		}

         Workbook workbook = null;
         messageErreur = " La liste des clients  ne respecte pas le canenvas attendu. Pour rappel, le canevas de liste des client est téléchargeable au niveau de la page de connexion";
		try {
			workbook = new XSSFWorkbook(excelFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        
         System.out.println("--> Nombre de page du document = [" + workbook.getNumberOfSheets() + "]");

         CellReference cellReference;
         Row rowCase;
         Cell cellCase;
         CellValue cellValue;
         
         CellReference cellReference2;
         Row rowCase2;
         Cell cellCase2;
         CellValue cellValue2;


         	
         Sheet datatypeSheet = workbook.getSheetAt(0);
         System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
         System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

          	
         //debut du traitement  A4
         
         cellReference = new CellReference("A4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="A4 est vide" ;
        	 verifyError = true;
        	
        	 
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Ninea")))
              
             // messageErreur="A4  a été modifié" ;
            	  verifyError = true;
             
             
         }
         
         //Fin du traitement  A4
         
         
        //debut du traitement  B4
         
         cellReference = new CellReference("B4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="B4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
             System.out.println("B4"+Col01);
             
           if(!(Col01.trim().equals("Nom et Prénom du bénéficiaire")))
              
              //messageErreur="B4  a été modifié" ;
        	   verifyError = true;
             
         }
         
         //Fin du traitement  B4
         
       //debut du traitement  C4
         
         cellReference = new CellReference("C4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="C4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Adresse du bénéficiaire")))
              
              //messageErreur="C4  a été modifié" ;
                verifyError = true;
             
         }
         
         //Fin du traitement  C4
         
         
       //debut du traitement  D4
         
         cellReference = new CellReference("D4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="D4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.equals("Chiffre d'affaire")))
              
              //messageErreur="D4  a été modifié" ;
            	verifyError = true;
             
         }
         
         //Fin du traitement  D4
      
      
//debut du traitement  E4
         
         cellReference = new CellReference("E4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="E4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Adresse du siege N°")))
              
              //messageErreur="E4  a été modifié" ;
            	verifyError = true;
             
         }
         
         //Fin du traitement  E4
         
         
       //debut du traitement  F4
         
         cellReference = new CellReference("F4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="F4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Type de voie")))
              
              //messageErreur="F4  a été modifié" ;
              verifyError = true;
             
         }
         
         //Fin du traitement  F4
         
         
      //debut du traitement  G4
         
         cellReference = new CellReference("G4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="G4 est vide" ;
        	 verifyError = true;
        	              
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Nom de la voie")))
              
              //messageErreur="G4  a été modifié" ;
            	  verifyError = true;
             
         }
         
         //Fin du traitement  G4
         
    //debut du traitement  H4
         
         cellReference = new CellReference("H4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
        
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="H4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Immeuble")))
              
              //messageErreur="H4  a été modifié" ;
            	verifyError = true;
             
         }
         
         //Fin du traitement  H4

        //debut du traitement  H4
         
         cellReference = new CellReference("I4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="I4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Quartier")))
              
              //messageErreur="I4  a été modifié" ;
            	verifyError = true;
             
         }
         
         //Fin du traitement  I4
         
         
     //debut du traitement  J4
         
         cellReference = new CellReference("J4");
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
         
         if (cellCase==null || (cellCase.getCellType() != CellType.STRING)) {
        	 
        	 //messageErreur="J4 est vide" ;
        	 verifyError = true;
             
         } else {
        	 
             String Col01 = cellCase.getStringCellValue();
             
              if(!(Col01.trim().equals("Commune")))
              
              //messageErreur="J4  a été modifié" ;
                verifyError = true;
             
         }
         
         //Fin du traitement  J4
         
         if(verifyError) {
        	 resultat.setStatut(false);
			 resultat.setMessage(messageErreur);
			 return resultat;
         }else{

         //Banque
         String [] cellulesClients = {"A5", "B5", "C5","D5", "E5", "F5","G5", "H5", "I5","J5"}  ; // tableau de cellules à verifier
         
         messageErreur="Merci de renseigner toutes les colonnes  de la liste des clients avec les informations attendues";
         
         verifiLineResult = verifyFirstLine(cellulesClients,cellReference, rowCase, cellCase,datatypeSheet);
         
         
         }
         
         
         
         } finally {

             try {
                 // He was careful to close streams in finally block, but it’s not complete
                 // Can you spot error?

                 if (excelFile != null)
                     excelFile.close();

             } catch (IOException e) {
                 System.out.println("Failed to close streams");
             }

         }

         System.out.println("======> Fin verification excel");
       
         System.out.println("======> Result "+verifiLineResult);
         if(verifiLineResult) {
        	 System.out.println("======> if");
        	 resultat.setStatut(false);
			 resultat.setMessage(messageErreur);
         }else {
        	 System.out.println("======> else");
        	 resultat.setStatut(true);
			 resultat.setMessage("La liste des clients est chargée avec succès.");
         }

      return resultat;
	
}
 
 static boolean verifyFirstLine(String[] cellulesClients,CellReference cellReference, Row rowCase, Cell cellCase, Sheet datatypeSheet) {
	 
	 //Boolean isEmptyName = false;
	 Boolean verifyError = false;
	 
	 for(int i=0; i<cellulesClients.length; i++) {
         cellReference = new CellReference(cellulesClients[i]);
         rowCase = datatypeSheet.getRow(cellReference.getRow());
         cellCase = rowCase.getCell(cellReference.getCol());
        
      //   System.out.println("[ligne A5 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
      /*    
         cellCase =null;
         try {
         cellCase = rowCase.getCell(cellReference.getCol());
         
         }catch (Exception e)
         {}
         
         if ( cellCase ==null || (cellCase.getCellType() != CellType.STRING) || (cellCase.getCellType() != CellType.NUMERIC)) {
         	isEmptyName = true ;
         	 messageErreur="information client  non renseignée"+cellulesClients[i] ;
             break;
         }
       */
         System.out.println("================> Boucle bi "+cellCase);
         if (cellCase==null || cellCase.toString() == "") {
        	 //isEmptyName = true ;
        	 //messageErreur="information client  non renseignée Cellule ["+cellulesClients[i] +"]";
        	 verifyError = true;
        	 return verifyError;
         }
         
         
     
     }
	 return verifyError;
 }
 
 
}

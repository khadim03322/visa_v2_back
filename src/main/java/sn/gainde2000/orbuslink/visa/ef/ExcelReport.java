package sn.gainde2000.orbuslink.visa.ef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Bassirou THIAM
 */
public class ExcelReport {

//    public static void main(String[] args) {
////////        System.out.println("11111111111111111111111");
////////
////////        //111111111111111111111111111111111111111111111111111111111111111111111
////////////        Report report = new Report();
////////////        report.setErrorExist(true);
////////////        PageGardeReport pageGardeReport = new PageGardeReport();
////////////        report.setPageGardeReport(pageGardeReport);
////////////        FicheRenseignementReport ficheRenseignementReport = new FicheRenseignementReport();
////////////        report.setFicheRenseignementReport(ficheRenseignementReport);
////////////        ActiviteEntrepriseReport activiteEntrepriseReport = new ActiviteEntrepriseReport();
////////////        report.setActiviteEntrepriseReport(activiteEntrepriseReport);
////////////        DirigeantsReport dirigeantsReport = new DirigeantsReport();
////////////        report.setDirigeantsReport(dirigeantsReport);
////////////        BalanceReport balanceReport = new BalanceReport();
////////////        report.setBalanceReport(balanceReport);
////////////        BilanReport bilanReport = new BilanReport();
////////////        report.setBilanReport(bilanReport);
////////////        CompteResultatReport compteResultatReport = new CompteResultatReport();
////////////        report.setCompteResultatReport(compteResultatReport);
////////////        FluxTresorerieReport fluxTresorerieReport = new FluxTresorerieReport();
////////////        report.setFluxTresorerieReport(fluxTresorerieReport);
////////////
////////////        createReport(report);
////////        //222222222222222222222222222222222222222222222222222222222222222222222
////////
////////        //111111111111111111111111111111111111111111111111111111111111111111111
////////        //createReport();
////////////        verifyExcel();
////////        verifyExcel("","","");
////////        //222222222222222222222222222222222222222222222222222222222222222222222
////////        System.out.println("22222222222222222222222");
//        verifyExcel("C:\\Users\\Lsarr\\Downloads\\testExcel\\", "test10.xlsx", "rapport8.xlsx");
//////
//    }

    private static void createReport() {
        System.out.println("======> Debut creation rapport");
        String fileLocation = "E:\\Bassirou\\Gainde2000\\Projets\\ProjetVisaDGID\\docs\\Bassirou\\TraitementExcel\\Rapport de conformité_Bass.xlsx";
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
            sheet.addMergedRegion(CellRangeAddress.valueOf("B8:E8"));

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
            styleTitleTab.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            styleTitleTab.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle styleDefault = workbook.createCellStyle();
            styleDefault.setWrapText(true);

            //Debut creation header
            HeaderReport headerReport = new HeaderReport();

            int rowNum;
            int colNum;

            //Data row 1 (ligne 2)
            rowNum = 1;
            Row row1 = sheet.createRow(rowNum);
            //B2
            colNum = 1;
            Cell cellB2 = row1.createCell(colNum);
            cellB2.setCellValue(headerReport.getDesignationName());
            cellB2.setCellStyle(styleHeaderDoc);
            //C2
            colNum = 2;
            Cell cellC2 = row1.createCell(colNum);
            cellC2.setCellValue(headerReport.getDesignationValue());
            cellC2.setCellStyle(styleDefault);
            //Fin creation header

            //Data row 3 (ligne 4)
            rowNum = 3;
            Row row3 = sheet.createRow(rowNum);
            //B4
            colNum = 1;
            Cell cellB4 = row3.createCell(colNum);
            cellB4.setCellValue(headerReport.getAdresseName());
            cellB4.setCellStyle(styleHeaderDoc);
            //C4
            colNum = 2;
            Cell cellC4 = row3.createCell(colNum);
            cellC4.setCellValue(headerReport.getAdresseValue());
            cellC4.setCellStyle(styleDefault);
            //E4
            colNum = 4;
            Cell cellE4 = row3.createCell(colNum);
            cellE4.setCellValue(headerReport.getSigleName());
            cellE4.setCellStyle(styleHeaderDoc);
            //F4
            colNum = 5;
            Cell cellF4 = row3.createCell(colNum);
            cellF4.setCellValue(headerReport.getSigleValue());
            cellF4.setCellStyle(styleDefault);

            //Data row 5 (ligne 6)
            rowNum = 5;
            Row row5 = sheet.createRow(rowNum);
            //B6
            colNum = 1;
            Cell cellB6 = row5.createCell(colNum);
            cellB6.setCellValue(headerReport.getNumIdentificationName());
            cellB6.setCellStyle(styleHeaderDoc);
            //C6
            colNum = 2;
            Cell cellC6 = row5.createCell(colNum);
            cellC6.setCellValue(headerReport.getNumIdentificationValue());
            cellC6.setCellStyle(styleDefault);
            //E6
            colNum = 4;
            Cell cellE6 = row5.createCell(colNum);
            cellE6.setCellValue(headerReport.getExerciceName());
            cellE6.setCellStyle(styleHeaderDoc);
            //F6
            colNum = 5;
            Cell cellF6 = row5.createCell(colNum);
            cellF6.setCellValue(headerReport.getExerciceValue());
            cellF6.setCellStyle(styleDefault);

            //Data row 7 (ligne 8)
            rowNum = 7;
            Row row7 = sheet.createRow(rowNum);
            //B8
            colNum = 1;
            Cell cellB8 = row7.createCell(colNum);
            cellB8.setCellValue(headerReport.getTitleResults());
            cellB8.setCellStyle(styleTitle);

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
        System.out.println("======> Fin creation rapport");
    }

    private static void verifyExcel() {
        System.out.println("======> Debut verification excel");
        String fileLocation = "E:\\Bassirou\\Gainde2000\\Projets\\ProjetVisaDGID\\docs\\Moustapha\\new\\Backlog\\modéle_états_financiers DGID_Bass.xlsx";

        try {
            FileInputStream excelFile = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(excelFile);

            System.out.println("--> Nombre de page du document = [" + workbook.getNumberOfSheets() + "]");

            CellReference cellReference;
            Row rowCase;
            Cell cellCase;

            Report report = new Report();

            //11111111
            PageGardeReport pageGardeReport = null;
            FicheRenseignementReport ficheRenseignementReport = null;
            ActiviteEntrepriseReport activiteEntrepriseReport = null;
            DirigeantsReport dirigeantsReport = null;
            BalanceReport balanceReport = null;
            BilanReport bilanReport = null;
            CompteResultatReport compteResultatReport = null;
            FluxTresorerieReport fluxTresorerieReport = null;
            //22222222

            //*** Debut verification page de garde
            Sheet datatypeSheet = workbook.getSheetAt(0);
            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");

            //Centre de dépôt
            cellReference = new CellReference("B15");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            //System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase.getCellType() != CellType.STRING) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setCentreDepotObservation("Information non renseignée");
                pageGardeReport.setCentreDepotIsCorrect(false);
            }

            //Exercice clos
            cellReference = new CellReference("M25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            //System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() != CellType.NUMERIC) {
                /*
                //gestion avancee de la date
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yy");
                    DataFormatter dataFormatter = new DataFormatter();
                    Date date = formatter.parse(dataFormatter.formatCellValue(cellCase));
                } catch (ParseException e) {
                }
                */
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                pageGardeReport.setExerciceClosIsCorrect(false);
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
            }

            //Identification fiscal
            System.out.println("[----------------->");
            cellReference = new CellReference("N49");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[----------------->ligne N49 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase.getCellType() != CellType.STRING) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setIdFiscaleObservation("Information non renseignée");
                pageGardeReport.setIdFiscaleIsCorrect(false);
            }

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
            cellReference = new CellReference("V9");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            //System.out.println("[ligne V9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getCachedFormulaResultType());
            if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
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

            /*??
            //Adress
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
                ficheRenseignementReport.setAdresseObservation("Information non renseignée");
                ficheRenseignementReport.setAdresseIsCorrect(false);
            }
            */

            /*(number or string)?
            //Id fiscal
            cellReference = new CellReference("J9");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne J9 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            System.out.println(cellCase.getCachedFormulaResultType());
            if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée");
                ficheRenseignementReport.setIdFiscaleIsCorrect(false);
            }
            */

            //Exerice comptable debut
            cellReference = new CellReference("Y12");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne Y12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() != CellType.NUMERIC) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée / Format incorrect");
                ficheRenseignementReport.setExerciceComptableIsCorrect(false);
            }
            //Exerice comptable fin
            cellReference = new CellReference("AH12");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne AH12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() != CellType.NUMERIC) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée / Format incorrect");
                ficheRenseignementReport.setExerciceComptableIsCorrect(false);
            }

            //Date arret compte
            cellReference = new CellReference("U15");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne U15 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            System.out.println(cellCase.getCachedFormulaResultType());
            if (cellCase.getCachedFormulaResultType() != CellType.NUMERIC) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée / Format incorrect");
                ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
            }

            //Greffe
            cellReference = new CellReference("F23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne F23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            System.out.println(cellCase.getStringCellValue());
//            if (cellCase.getCellType() != CellType.STRING) {
//                if (ficheRenseignementReport == null) {
//                    ficheRenseignementReport = new FicheRenseignementReport();
//                    report.setErrorExist(true);
//                }
//                ficheRenseignementReport.setGreffeObservation("Information non renseignée");
//                ficheRenseignementReport.setGreffeIsCorrect(false);
//            }

            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */
            /*
            //Title
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
                ficheRenseignementReport.setXxxObservation("Information non renseignée");
                ficheRenseignementReport.setXxxIsCorrect(false);
            }
            */

            if (ficheRenseignementReport != null) {
                report.setFicheRenseignementReport(ficheRenseignementReport);
            }
            //*** Fin verification fiche renseignement


            createReport(report);
        } catch (Exception e) {
            System.out.println("xxxxxxx");
            e.printStackTrace();
            System.out.println("yyyyyyy");
        }

        System.out.println("======> Fin verification excel");
    }

    public static Report verifyExcel(String filePath, String fileName, String rapportFileName) {
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

        //1111111111111111111111111111111111111111111111111111111111111111111111
        System.out.println("======> Debut verification excel");
////        String fileLocation = "E:\\Bassirou\\ProjetOrbusLinkComptable\\docs\\Bassirou\\Tests\\modele_etats_financiers_DGID_Test.xlsx";
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


            report = new Report();

            //11111111
            PageGardeReport pageGardeReport = null;
            FicheRenseignementReport ficheRenseignementReport = null;
            ActiviteEntrepriseReport activiteEntrepriseReport = null;
            DirigeantsReport dirigeantsReport = null;
            BalanceReport balanceReport = null;
            BilanReport bilanReport = null;
            CompteResultatReport compteResultatReport = null;
            FluxTresorerieReport fluxTresorerieReport = null;
            //22222222

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
            if (cellValue.getCellType() != CellType.STRING) {
                if (pageGardeReport == null) {
                    pageGardeReport = new PageGardeReport();
                    report.setErrorExist(true);
                }
                pageGardeReport.setCentreDepotObservation("Information non renseignée");
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
                        pageGardeReport.setCentreDepotIsCorrect(false);
                    }
                } catch (Exception ie) {
                    if (pageGardeReport == null) {
                        pageGardeReport = new PageGardeReport();
                        report.setErrorExist(true);
                    }
                    pageGardeReport.setCentreDepotObservation("Information non renseignée");
                    pageGardeReport.setCentreDepotIsCorrect(false);
                }
            }

            //Exercice clos
            cellReference = new CellReference("M25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            //System.out.println("[ligne M25 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");

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
                pageGardeReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                pageGardeReport.setExerciceClosIsCorrect(false);
            } else {
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
                    ficheRenseignementReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                    ficheRenseignementReport.setExerciceClosIsCorrect(false);
                }
            } catch (Exception ie) {// driver not found
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
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
            System.out.println(cellCase.getStringCellValue());
            cellValue = evaluator.evaluate(cellCase);
            System.out.println(cellValue.getCellType());
            if (cellValue.getCellType() != CellType.STRING) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setAdresseObservation("Information non renseignée");
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
                    ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée / Format incorrect");
                    ficheRenseignementReport.setIdFiscaleIsCorrect(false);
                }
            } catch (Exception ie) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setIdFiscaleObservation("Information non renseignée / Format incorrect");
                ficheRenseignementReport.setIdFiscaleIsCorrect(false);
            }

            //Exerice comptable debut
            cellReference = new CellReference("Y12");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne Y12 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            cellValue = evaluator.evaluate(cellCase);
            if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée / Format incorrect");
                ficheRenseignementReport.setExerciceComptableIsCorrect(false);
            }

            //Exerice comptable fin
            cellReference = new CellReference("AH12");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            System.out.println(cellValue.getCellType());
            if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setExerciceComptableObservation("Information non renseignée / Format incorrect");
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
                if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                    if (ficheRenseignementReport == null) {
                        ficheRenseignementReport = new FicheRenseignementReport();
                        report.setErrorExist(true);
                    }
                    ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée / Format incorrect");
                    ficheRenseignementReport.setDateArreteComptesIsCorrect(false);
                }
            } catch (Exception ie) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setDateArreteComptesObservation("Information non renseignée / Format incorrect");
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
            if (cellCase.getCellType() != CellType.STRING) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setNumRegistreCommerceObservation("Information non renseignée");
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
                ficheRenseignementReport.setDesignationEntrepriseIsCorrect(false);
            }

            //Telephone
            cellReference = new CellReference("G35");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            //System.out.println(cellCase.getStringCellValue());
            if (cellCase.getCellType() != CellType.STRING) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setNumTelephoneObservation("Information non renseignée");
                ficheRenseignementReport.setNumTelephoneIsCorrect(false);
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
            if (cellCase.getCellType() != CellType.STRING) {
                if (ficheRenseignementReport == null) {
                    ficheRenseignementReport = new FicheRenseignementReport();
                    report.setErrorExist(true);
                }
                ficheRenseignementReport.setQualiteDuSignataireObservation("Information non renseignée");
                ficheRenseignementReport.setQualiteDuSignataireIsCorrect(false);
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
            }

            //Banque
//            String [] cellulesBanques = {"T70", "T71", "T72"}  ; // tableau de cellules à verifier
            Boolean isEmpty = true;
//            for(int i=0; i<cellulesBanques.length; i++) {
//                cellReference = new CellReference(cellulesBanques[i]);
//                rowCase = datatypeSheet.getRow(cellReference.getRow());
//                cellCase = rowCase.getCell(cellReference.getCol());
//                System.out.println("[ligne T71 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//                if (cellCase.getCellType() == CellType.STRING) {
//                    isEmpty = false ;
//                    break;
//                }
//            }
//            if(isEmpty) {
//                if (ficheRenseignementReport == null) {
//                    ficheRenseignementReport = new FicheRenseignementReport();
//                    report.setErrorExist(true);
//                }
//                ficheRenseignementReport.setBanqueObservation("Information non renseignée");
//                ficheRenseignementReport.setBanqueIsCorrect(false);
//            }
            //Numero
//            String [] cellulesNumero = {"AD70", "AD71", "AD72"}  ; // tableau de cellules à verifier
//            isEmpty  = true ;
//            for(int i=0; i<cellulesNumero.length; i++) {
//                cellReference = new CellReference(cellulesNumero[i]);
//                rowCase = datatypeSheet.getRow(cellReference.getRow());
//                cellCase = rowCase.getCell(cellReference.getCol());
//                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//                //System.out.println(cellCase.getStringCellValue());
//
//                if (cellCase.getCellType() != CellType.STRING) {
//                    isEmpty = false ;
//                    break;
//                }
//
//            }
//            if (isEmpty) {
//                if (ficheRenseignementReport == null) {
//                    ficheRenseignementReport = new FicheRenseignementReport();
//                    report.setErrorExist(true);
//                }
//                ficheRenseignementReport.setNumeroObservation("Information non renseignée");
//                ficheRenseignementReport.setNumeroIsCorrect(false);
//            }
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
                if (!(cellValue.getCellType() == CellType.NUMERIC || cellValue.getCellType() == CellType.STRING)) {
                    if (activiteEntrepriseReport == null) {
                        activiteEntrepriseReport = new ActiviteEntrepriseReport();
                        report.setErrorExist(true);
                    }
                    activiteEntrepriseReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
                    activiteEntrepriseReport.setExerciceClosIsCorrect(false);
                }
            } catch (Exception ie) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setExerciceClosObservation("Information non renseignée / Format incorrect");
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
                    activiteEntrepriseReport.setAdresseIsCorrect(false);
                }
            } catch (Exception ie) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setAdresseObservation("Information non renseignée");
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
                    activiteEntrepriseReport.setIdFiscaleObservation("Information non renseignée / Format incorrect");
                    activiteEntrepriseReport.setIdFiscaleIsCorrect(false);
                }
            } catch (Exception ie) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setIdFiscaleObservation("Information non renseignée / Format incorrect");
                activiteEntrepriseReport.setIdFiscaleIsCorrect(false);
            }

            //Designation Activite
//            String [] cellulesNumero = {"B28", "B28", "B28"}  ; // tableau de cellules à verifier
//            isEmpty  = true ;
//            for(int i=0; i<cellulesBanques.length; i++) {
            cellReference = new CellReference("B28");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellCase.getCellType() != CellType.STRING) {
                if (activiteEntrepriseReport == null) {
                    activiteEntrepriseReport = new ActiviteEntrepriseReport();
                    report.setErrorExist(true);
                }
                activiteEntrepriseReport.setDesignationActiviteObservation("Information non renseignée");
                activiteEntrepriseReport.setDesignationActiviteIsCorrect(false);
            }

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
//            String [] cellulesNoms = {"A8", "A9", "A10"}  ; // tableau de cellules à verifier
//            isEmpty  = true ;
//            for(int i=0; i<cellulesNoms.length; i++) {
//                cellReference = new CellReference(cellulesNoms[i]);
//                rowCase = datatypeSheet.getRow(cellReference.getRow());
//                cellCase = rowCase.getCell(cellReference.getCol());
//                cellValue = evaluator.evaluate(cellCase);
//                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//                if ( cellCase.getCellType() == CellType.STRING) {
//                    isEmpty = false ;
//                    break;
//                }
//            }
//            if (isEmpty) {
//                if (dirigeantsReport == null) {
//                    dirigeantsReport = new DirigeantsReport();
//                    report.setErrorExist(true);
//                }
//                dirigeantsReport.setNomObservation("Information non renseignée");
//                dirigeantsReport.setNomIsCorrect(false);
//            }
            //Prenom
//            String [] cellulesPrenoms = {"B8", "B9", "B10"}  ; // tableau de cellules à verifier
//            isEmpty  = true ;
//            for(int i=0; i<cellulesPrenoms.length; i++) {
//                cellReference = new CellReference(cellulesPrenoms[i]);
//                rowCase = datatypeSheet.getRow(cellReference.getRow());
//                cellCase = rowCase.getCell(cellReference.getCol());
//                cellValue = evaluator.evaluate(cellCase);
//                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//                if (cellCase.getCellType() == CellType.STRING) {
//                    isEmpty = false ;
//                    break;
//                }
//            }
//            if (isEmpty) {
//                if (dirigeantsReport == null) {
//                    dirigeantsReport = new DirigeantsReport();
//                    report.setErrorExist(true);
//                }
//                dirigeantsReport.setPrenomObservation("Information non renseignée");
//                dirigeantsReport.setPrenomIsCorrect(false);
//            }

            //Qualite
//            String [] cellulesQualite = {"C8", "C9", "C10"}  ; // tableau de cellules à verifier
//            isEmpty  = true ;
//            for(int i=0; i<cellulesQualite.length; i++) {
//                cellReference = new CellReference(cellulesQualite[i]);
//                rowCase = datatypeSheet.getRow(cellReference.getRow());
//                cellCase = rowCase.getCell(cellReference.getCol());
//                cellValue = evaluator.evaluate(cellCase);
//
//                System.out.println("[ligne : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
//                if (cellCase.getCellType() == CellType.STRING) {
//                    isEmpty = false ;
//                    break;
//                }
//            }
//            if(isEmpty)  {
//                if (dirigeantsReport == null) {
//                    dirigeantsReport = new DirigeantsReport();
//                    report.setErrorExist(true);
//                }
//                dirigeantsReport.setQualiteObservation("Information non renseignée");
//                dirigeantsReport.setQualiteIsCorrect(false);
//            }
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
            int i = getLastRowWithData(datatypeSheet);

            if (i != 30) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setNombreDeLigneIsCorrect(false);
            }
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
            cellReference = new CellReference("D18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
            }
            //2
            cellReference = new CellReference("E18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
            }
            //3
            cellReference = new CellReference("F18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());

            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
            }
            //1
            cellReference = new CellReference("G18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            System.out.println("[ligne G18 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getCellType() + "]");
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifImmobiliseObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifImmobiliseIsCorrect(false);
            }

            //Total Ressource stable
            //1
            cellReference = new CellReference("K18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalRessourceObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalRessourceIsCorrect(false);
            }
            //2
            cellReference = new CellReference("L18");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalRessourceObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalRessourceIsCorrect(false);
            }

            //TotalActifCirculant
            //1
            cellReference = new CellReference("D25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifCirculantIsCorrect(false);
            }
            //2
            cellReference = new CellReference("E25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifCirculantIsCorrect(false);
            }
            //3
            cellReference = new CellReference("F25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifCirculantIsCorrect(false);
            }
            //4
            cellReference = new CellReference("G25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalActifCirculantObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalActifCirculantIsCorrect(false);
            }

            //TotalPassif
            //1
            cellReference = new CellReference("K25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalPassifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalPassifIsCorrect(false);
            }
            //2
            cellReference = new CellReference("L25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalPassifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalPassifIsCorrect(false);
            }
            //TotalTresorerieActif
            //1
            cellReference = new CellReference("D29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
            }
            //3
            cellReference = new CellReference("F29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
            }
            //4
            cellReference = new CellReference("G29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresorerieActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalTresorerieActifIsCorrect(false);
            }

            //TotalTresoreriePassif
            //1
            cellReference = new CellReference("K29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresoreriePassifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalTresoreriePassifIsCorrect(false);
            }
            //2
            cellReference = new CellReference("L29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalTresoreriePassifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalTresoreriePassifIsCorrect(false);
            }

            //TotalGeneralActif
            //1
            cellReference = new CellReference("D31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalGeneralActifIsCorrect(false);
            }
            //2
            cellReference = new CellReference("E31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalGeneralActifIsCorrect(false);
            }
            //3
            cellReference = new CellReference("F31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalGeneralActifIsCorrect(false);
            } else {
                totalBilan = String.valueOf((long) cellCase.getNumericCellValue());
            }
            //4
            cellReference = new CellReference("G31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralActifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalGeneralActifIsCorrect(false);
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
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralPassifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalGeneralPassifIsCorrect(false);
            }
            //2
            cellReference = new CellReference("L31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (bilanReport == null) {
                    bilanReport = new BilanReport();
                    report.setErrorExist(true);
                }
                bilanReport.setTotalGeneralPassifObservation("Information non renseignée / Format incorrect");
                bilanReport.setTotalGeneralPassifIsCorrect(false);
            }

            //Gestion colonne
            //Gestion nom reference
            //Gestion ligne

            if (bilanReport != null) {
                report.setBilanReport(bilanReport);
            }
            //*** Fin bilan

            //*** Debut compte resultat
            datatypeSheet = workbook.getSheetAt(6);


            System.out.println("--> Nom premire page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
            int n = getLastRowWithData(datatypeSheet);
            if (n != 42) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setNombreDeLigneIsCorrect(false);
            }

            //ChiffreAffaire
            //1
            cellReference = new CellReference("E9");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setChiffreAffaireObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setChiffreAffaireIsCorrect(false);
            } else {
                chiffreAffaire = String.valueOf((long) cellValue.getNumberValue());
            }
            //2
            cellReference = new CellReference("F9");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setChiffreAffaireObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setChiffreAffaireIsCorrect(false);
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
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setValeurAjouteeObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setValeurAjouteeIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setValeurAjouteeObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setValeurAjouteeIsCorrect(false);
            }

            //Exedent
            //1
            cellReference = new CellReference("E25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setExedentObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setExedentIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F25");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setExedentObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setExedentIsCorrect(false);
            }

            //Resultat exploitation
            //1
            cellReference = new CellReference("E28");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setResultatIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F28");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setResultatIsCorrect(false);
            }

            //ResultatNet
            //1
            cellReference = new CellReference("E43");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatNetObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setResultatNetIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F43");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (compteResultatReport == null) {
                    compteResultatReport = new CompteResultatReport();
                    report.setErrorExist(true);
                }
                compteResultatReport.setResultatNetObservation("Information non renseignée / Format incorrect");
                compteResultatReport.setResultatNetIsCorrect(false);
            }

            //Gestion colonne
            //Gestion nom reference
            //Gestion ligne

            if (compteResultatReport != null) {
                report.setCompteResultatReport(compteResultatReport);
            }
            //*** Fin compte resultat

            //*** Debut flux tresorerie
            datatypeSheet = workbook.getSheetAt(7);
            System.out.println("--> Nom premiere page = [" + datatypeSheet.getSheetName() + "]");
            System.out.println("--> Nombre de ligne de la premiere page = [" + datatypeSheet.getLastRowNum() + "]");
            int b = getLastRowWithData(datatypeSheet);
            if (b != 31) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setNombreDeLigneIsCorrect(false);
            }
            //Tresorerie
            //1
            cellReference = new CellReference("E2");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setTresorerieIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F2");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setTresorerieIsCorrect(false);
            }

            //fluxActiviteOperationnelle
            //1
            cellReference = new CellReference("E10");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteOperationnelleObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxActiviteOperationnelleIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F10");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteOperationnelleObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxActiviteOperationnelleIsCorrect(false);
            }

            //fluxActiviteInvestissement
            //1
            cellReference = new CellReference("E23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteInvestissementObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxActiviteInvestissementIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F23");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxActiviteInvestissementObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxActiviteInvestissementIsCorrect(false);
            }

            //fluxCapitauxEtranger
            //1
            cellReference = new CellReference("E29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxCapitauxEtrangerObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxCapitauxEtrangerIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F29");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setFluxCapitauxEtrangerObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setFluxCapitauxEtrangerIsCorrect(false);
            }

            //tresorerieNette
            //1
            cellReference = new CellReference("E31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieNetteObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setTresorerieNetteIsCorrect(false);
            }
            //2
            cellReference = new CellReference("F31");
            rowCase = datatypeSheet.getRow(cellReference.getRow());
            cellCase = rowCase.getCell(cellReference.getCol());
            cellValue = evaluator.evaluate(cellCase);
            if (cellValue == null || cellValue.getCellType() != CellType.NUMERIC) {
                if (fluxTresorerieReport == null) {
                    fluxTresorerieReport = new FluxTresorerieReport();
                    report.setErrorExist(true);
                }
                fluxTresorerieReport.setTresorerieNetteObservation("Information non renseignée / Format incorrect");
                fluxTresorerieReport.setTresorerieNetteIsCorrect(false);
            }

            if (fluxTresorerieReport != null) {
                report.setFluxTresorerieReport(fluxTresorerieReport);
            }
            //*** Fin flux tresorerie

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
                sheet.addMergedRegion(CellRangeAddress.valueOf("B8:E8"));

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
                styleTitleTab.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                styleTitleTab.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                CellStyle styleDefault = workbook.createCellStyle();
                styleDefault.setWrapText(true);

                //Debut creation header
                HeaderReport headerReport = report.getHeaderReport();

                int rowNum;
                int colNum;

                //Data row 1 (ligne 2)
                rowNum = 1;
                Row row1 = sheet.createRow(rowNum);
                //B2
                colNum = 1;
                Cell cellB2 = row1.createCell(colNum);
                cellB2.setCellValue(headerReport.getDesignationName());
                cellB2.setCellStyle(styleHeaderDoc);
                //C2
                colNum = 2;
                Cell cellC2 = row1.createCell(colNum);
                cellC2.setCellValue(headerReport.getDesignationValue());
                cellC2.setCellStyle(styleDefault);
                //Fin creation header

                //Data row 3 (ligne 4)
                rowNum = 3;
                Row row3 = sheet.createRow(rowNum);
                //B4
                colNum = 1;
                Cell cellB4 = row3.createCell(colNum);
                cellB4.setCellValue(headerReport.getAdresseName());
                cellB4.setCellStyle(styleHeaderDoc);
                //C4
                colNum = 2;
                Cell cellC4 = row3.createCell(colNum);
                cellC4.setCellValue(headerReport.getAdresseValue());
                cellC4.setCellStyle(styleDefault);
                //E4
                colNum = 4;
                Cell cellE4 = row3.createCell(colNum);
                cellE4.setCellValue(headerReport.getSigleName());
                cellE4.setCellStyle(styleHeaderDoc);
                //F4
                colNum = 5;
                Cell cellF4 = row3.createCell(colNum);
                cellF4.setCellValue(headerReport.getSigleValue());
                cellF4.setCellStyle(styleDefault);

                //Data row 5 (ligne 6)
                rowNum = 5;
                Row row5 = sheet.createRow(rowNum);
                //B6
                colNum = 1;
                Cell cellB6 = row5.createCell(colNum);
                cellB6.setCellValue(headerReport.getNumIdentificationName());
                cellB6.setCellStyle(styleHeaderDoc);
                //C6
                colNum = 2;
                Cell cellC6 = row5.createCell(colNum);
                cellC6.setCellValue(headerReport.getNumIdentificationValue());
                cellC6.setCellStyle(styleDefault);
                //E6
                colNum = 4;
                Cell cellE6 = row5.createCell(colNum);
                cellE6.setCellValue(headerReport.getExerciceName());
                cellE6.setCellStyle(styleHeaderDoc);
                //F6
                colNum = 5;
                Cell cellF6 = row5.createCell(colNum);
                cellF6.setCellValue(headerReport.getExerciceValue());
                cellF6.setCellStyle(styleDefault);

                //Data row 7 (ligne 8)
                rowNum = 7;
                Row row7 = sheet.createRow(rowNum);
                //B8
                colNum = 1;
                Cell cellB8 = row7.createCell(colNum);
                cellB8.setCellValue(headerReport.getTitleResults());
                cellB8.setCellStyle(styleTitle);

                int numeroLigne = 9;

                Row myRow;
                Cell myCell;
                //Gestion page de garde
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
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans page de garde");
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans flux tresorerie");
                }

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

    private static void createReport(Report report) {
        System.out.println("======> Debut creation rapport");
        if (report.errorExist) {
            System.out.println("--> Avec creation rapport");
            String fileLocation = "E:\\Bassirou\\Gainde2000\\Projets\\ProjetVisaDGID\\docs\\Moustapha\\new\\Backlog\\Rapport de conformité_Bass.xlsx";
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
                sheet.addMergedRegion(CellRangeAddress.valueOf("B8:E8"));

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
                styleTitleTab.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                styleTitleTab.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                CellStyle styleDefault = workbook.createCellStyle();
                styleDefault.setWrapText(true);

                //Debut creation header
                HeaderReport headerReport = new HeaderReport();

                int rowNum;
                int colNum;

                //Data row 1 (ligne 2)
                rowNum = 1;
                Row row1 = sheet.createRow(rowNum);
                //B2
                colNum = 1;
                Cell cellB2 = row1.createCell(colNum);
                cellB2.setCellValue(headerReport.getDesignationName());
                cellB2.setCellStyle(styleHeaderDoc);
                //C2
                colNum = 2;
                Cell cellC2 = row1.createCell(colNum);
                cellC2.setCellValue(headerReport.getDesignationValue());
                cellC2.setCellStyle(styleDefault);
                //Fin creation header

                //Data row 3 (ligne 4)
                rowNum = 3;
                Row row3 = sheet.createRow(rowNum);
                //B4
                colNum = 1;
                Cell cellB4 = row3.createCell(colNum);
                cellB4.setCellValue(headerReport.getAdresseName());
                cellB4.setCellStyle(styleHeaderDoc);
                //C4
                colNum = 2;
                Cell cellC4 = row3.createCell(colNum);
                cellC4.setCellValue(headerReport.getAdresseValue());
                cellC4.setCellStyle(styleDefault);
                //E4
                colNum = 4;
                Cell cellE4 = row3.createCell(colNum);
                cellE4.setCellValue(headerReport.getSigleName());
                cellE4.setCellStyle(styleHeaderDoc);
                //F4
                colNum = 5;
                Cell cellF4 = row3.createCell(colNum);
                cellF4.setCellValue(headerReport.getSigleValue());
                cellF4.setCellStyle(styleDefault);

                //Data row 5 (ligne 6)
                rowNum = 5;
                Row row5 = sheet.createRow(rowNum);
                //B6
                colNum = 1;
                Cell cellB6 = row5.createCell(colNum);
                cellB6.setCellValue(headerReport.getNumIdentificationName());
                cellB6.setCellStyle(styleHeaderDoc);
                //C6
                colNum = 2;
                Cell cellC6 = row5.createCell(colNum);
                cellC6.setCellValue(headerReport.getNumIdentificationValue());
                cellC6.setCellStyle(styleDefault);
                //E6
                colNum = 4;
                Cell cellE6 = row5.createCell(colNum);
                cellE6.setCellValue(headerReport.getExerciceName());
                cellE6.setCellStyle(styleHeaderDoc);
                //F6
                colNum = 5;
                Cell cellF6 = row5.createCell(colNum);
                cellF6.setCellValue(headerReport.getExerciceValue());
                cellF6.setCellStyle(styleDefault);

                //Data row 7 (ligne 8)
                rowNum = 7;
                Row row7 = sheet.createRow(rowNum);
                //B8
                colNum = 1;
                Cell cellB8 = row7.createCell(colNum);
                cellB8.setCellValue(headerReport.getTitleResults());
                cellB8.setCellStyle(styleTitle);

                int numeroLigne = 9;

                Row myRow;
                Cell myCell;
                //Gestion page de garde
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
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans page de garde");
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                    myCell.setCellStyle(styleHeaderTab);
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
                        numeroLigne++;
                    }
                } else {
                    System.out.println("Rapport sans flux tresorerie");
                }

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
}

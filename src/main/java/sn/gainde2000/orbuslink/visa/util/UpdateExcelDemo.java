package sn.gainde2000.orbuslink.visa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sn.gainde2000.orbuslink.visa.ef.PageGardeReport;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;







public class UpdateExcelDemo {

	
	public void fonction() {
		
		/*
	       File file = new File("F://TesteAccuse//employee.xlsx");
	       // Read XSL file
	       FileInputStream inputStream = new FileInputStream(file);
	 
	       // Get the workbook instance for XLS file
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	 
	       // Get first sheet from the workbook
	       HSSFSheet sheet = workbook.getSheetAt(0);
	 
	       HSSFCell cell = sheet.getRow(1).getCell(2);
	       cell.setCellValue(cell.getNumericCellValue() * 2);
	      
	       cell = sheet.getRow(2).getCell(2);
	       cell.setCellValue(cell.getNumericCellValue() * 2);
	      
	       cell = sheet.getRow(3).getCell(2);
	       cell.setCellValue(cell.getNumericCellValue() * 2);
	 
	       inputStream.close();
	 
	       // Write File
	       FileOutputStream out = new FileOutputStream(file);
	       workbook.write(out);
	       out.close();
	       
	       */
		
		
		try {
	        OPCPackage fs = null;
			try {
				fs = OPCPackage.open(new File("F://TesteAccuse//employee.xlsx"));
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        XSSFWorkbook wb = new XSSFWorkbook(fs);
	        /*
	        XSSFSheet sheet = wb.getSheet("Feuil1");
	        XSSFRow row;
	        CellReference cr = new CellReference("A1");
	        row = sheet.getRow(cr.getCol());
	        */
	        String time = Long.toString(new Date().getTime());
	       // XSSFSheet sheet1 = wb.createSheet("new sheet");
	         
	        
	     //  Debut Write the output to a file
	        
	        XSSFSheet sheet = wb.getSheetAt(0);
	        
	        XSSFRow row = sheet.getRow(2);


	        Cell cell = row.getCell(3);


	        if (cell == null)

	            cell = row.createCell(3);


	        cell.setCellType(CellType.STRING);


	        cell.setCellValue("a test");
	        
	        
	        // Write the output to a file
	        
	         //Debut Suppression
	        
	        //wb.removeSheetAt(0);
	        
	         //FIn suppression
	        
	        
	        
	        try (OutputStream fileOut = new FileOutputStream("F://TesteAccuse//workbook_"+time+".xlsx")) {


	            wb.write(fileOut);
	        }
	       
	    } catch (FileNotFoundException e) {
	       /* if (logger.isDebugEnabled()) {
	            logger.debug("How can this error be possible? we should have already thrown an exception in the construction");
	        }*/
	    } catch (IOException e) {
	        /*logger.error(String.format("Exception in reading the file: %s",
	                e.getMessage()));*/
	    }
		
		String fname = "F://TesteAccuse//test02.xlsx";
		
	}
	
	
	public void fonction02() {
		
		try {
            File excel = new File("F://TesteAccuse//test03.xlsx");
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            Iterator<Row> itr = sheet.iterator();

            // Iterating over Excel file in Java
           /* while (itr.hasNext()) {
                Row row = itr.next();

                // Iterating over each column of Excel file
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:

                    }
                }
                System.out.println("");
            }*/

            // writing data into XLSX file
            Map<String, Object[]> newData = new HashMap<String, Object[]>();
            newData.put("7", new Object[] { 7d, "Sonya", "75K", "SALES",
                    "Rupert" });
            newData.put("8", new Object[] { 8d, "Kris", "85K", "SALES",
                    "Rupert" });
            newData.put("9", new Object[] { 9d, "Dave", "90K", "SALES",
                    "Rupert" });

            Set<String> newRows = newData.keySet();
            int rownum = sheet.getLastRowNum();

            for (String key : newRows) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = newData.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                       // cell.setAsActiveCell();
                    } else if (obj instanceof Boolean) {
                        //cell.setCellValue((Boolean) obj);
                        cell.setAsActiveCell();
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                        //cell.setAsActiveCell();
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                        //cell.setAsActiveCell();
                    }
                }
            }

            // open an OutputStream to save written data into Excel file
            FileOutputStream os = new FileOutputStream(excel);
            book.write(os);
            System.out.println("Writing on Excel file Finished ...");

            // Close workbook, OutputStream and Excel file to prevent leak
            os.close();
            book.close();
            fis.close();

        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    

	}
	
	public void fonctionLOCKED() {
		
		/*String file = "F://TesteAccuse//test04.xlsx";
		FileOutputStream outputStream = new FileOutputStream(file);
		Workbook wb = new XSSFWorkbook();

		CellStyle unlockedCellStyle = wb.createCellStyle();
		unlockedCellStyle.setLocked(true);

		XSSFSheet sheet = (XSSFSheet) wb.createSheet();
		sheet.protectSheet("password");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("TEST");
		cell.setCellStyle(unlockedCellStyle);

		wb.write(outputStream);
		outputStream.close();*/
	}
	
	
	public void fonctionSuppressionPage1() 
	{
		/*
		System.out.println("Debut");
		
		//input source excel file which contains sheets to be copied
		
		XSSFWorkbook workbookinput = new XSSFWorkbook(new  FileInputStream("F://TesteAccuse//ETATLINKv03.xlsm"));

		//output new excel file to which we need to copy the above sheets
		//this would copy entire workbook from source
		XSSFWorkbook workbookoutput=workbookinput;

		//delete one or two unnecessary sheets, you can delete them by specifying the sheetnames
		workbookoutput.removeSheetAt(workbookoutput.getSheetIndex(workbookoutput.getSheet("EtaLink")));

		//if you want to delete more sheets you can use a for to delete the sheets
		
		//To write your changes to new workbook
		FileOutputStream out = new FileOutputStream("F://TesteAccuse//test02_FinalOutput.xlsm");
		workbookoutput.write(out);
		out.close();
		
				
				*/
		
	}
	
	
	public void  fonctionLogerSolution01() 
	{
	/*	
		CellReference cellReference;
        Row rowCase;
        Cell cellCase;
        CellValue cellValue;
      
		//input source excel file which contains sheets to be copied
		
		XSSFWorkbook workbookinput = new XSSFWorkbook(new  FileInputStream("F://TesteAccuse//ETATLINKv03.xlsm"));

		//output new excel file to which we need to copy the above sheets
		//this would copy entire workbook from source
		XSSFWorkbook workbookoutput=workbookinput;

		
		
		//debut
		int nombrePageExcel=workbookinput.getNumberOfSheets();
		 System.out.println("--> Nombre de page du document = [" + workbookoutput.getNumberOfSheets() + "]");

		XSSFSheet datatypeSheet = workbookoutput.getSheetAt(workbookoutput.getSheetIndex(workbookoutput.getSheet("PageGarde")));

		FormulaEvaluator evaluator = workbookoutput.getCreationHelper().createFormulaEvaluator();

		  CellStyle unlockedCellStyle = workbookoutput.createCellStyle();
			unlockedCellStyle.setLocked(true);
			datatypeSheet.protectSheet("password");
			
		
		
        
		cellReference = new CellReference("E31");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);

        
        if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
            
        } else {
            
       System.out.println("[ligne E31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getStringCellValue() + "]");
            
       cellCase.setCellValue("8888344222");
       cellCase.setCellStyle(unlockedCellStyle);
       
		
        	
        }
        
      
        cellReference = new CellReference("C21");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);

        
        if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
            
        } else {
            
       System.out.println("[ligne C21 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getStringCellValue() + "]");
            
       cellCase.setCellValue("Gainde 2000");
       cellCase.setCellStyle(unlockedCellStyle);
          
      
		
		
        }
       
		
		FileOutputStream out = new FileOutputStream("F://TesteAccuse//ETATLINK_FinalOutput.xlsm");
		workbookoutput.write(out);
		out.close();
		*/
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		 
		System.out.println("Debut");
	
		CellReference cellReference;
        Row rowCase;
        Cell cellCase;
        CellValue cellValue;
        Font font ;
		//input source excel file which contains sheets to be copied
        
        //
		XSSFWorkbook workbookinput = new XSSFWorkbook(new  FileInputStream("F://TesteAccuse//ETATLINKv03.xlsm"));

		//output new excel file to which we need to copy the above sheets
		//this would copy entire workbook from source
		XSSFWorkbook workbookoutput=workbookinput;

		
		
		//debut
		int nombrePageExcel=workbookinput.getNumberOfSheets();
		 System.out.println("--> Nombre de page du document = [" + workbookoutput.getNumberOfSheets() + "]");

		XSSFSheet datatypeSheet = workbookoutput.getSheetAt(workbookoutput.getSheetIndex(workbookoutput.getSheet("Fiche d'identification")));

		FormulaEvaluator evaluator = workbookoutput.getCreationHelper().createFormulaEvaluator();

		font = workbookoutput.createFont();
		font.setFontHeightInPoints((short)12);
		
		//CellStyle headerStyle = workbookoutput.createCellStyle();
	
		font.setBold(true);
		
		  CellStyle unlockedCellStyle = workbookoutput.createCellStyle();
			
			unlockedCellStyle.setFont(font);
		
			unlockedCellStyle.setAlignment(HorizontalAlignment.CENTER);
			datatypeSheet.protectSheet("passwordOrbusLinkMasar2021");
			unlockedCellStyle.setLocked(true);
			
			
		cellReference = new CellReference("D31");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);

        
        if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
            
        } else {
            
       System.out.println("[ligne D31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getStringCellValue() + "]");
            
       cellCase.setCellValue("Gainde 2000");
       cellCase.setCellStyle(unlockedCellStyle);
       	
        }
        
      
        cellReference = new CellReference("D47");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);

        
        if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
            
        } else {
            
       System.out.println("[ligne D47 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getStringCellValue() + "]");
            
       cellCase.setCellValue("8888344222");
       cellCase.setCellStyle(unlockedCellStyle);
          
        }
        
        
        //information sur la page de garde
        
      
		
		 datatypeSheet = workbookoutput.getSheetAt(workbookoutput.getSheetIndex(workbookoutput.getSheet("PageGarde")));

		 evaluator = workbookoutput.getCreationHelper().createFormulaEvaluator();

		font = workbookoutput.createFont();
		font.setFontHeightInPoints((short)16);
		
		//CellStyle headerStyle = workbookoutput.createCellStyle();
	
		font.setBold(true);
		
		    unlockedCellStyle = workbookoutput.createCellStyle();
			
			unlockedCellStyle.setFont(font);
		
			unlockedCellStyle.setAlignment(HorizontalAlignment.LEFT);
			datatypeSheet.protectSheet("passwordOrbusLinkMasar2021");
			unlockedCellStyle.setLocked(true);
			
			
		cellReference = new CellReference("E23");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);

        
        if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
            
        } else {
            
       System.out.println("[ligne E23 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getStringCellValue() + "]");
            
       cellCase.setCellValue("Gainde 2000");
       cellCase.setCellStyle(unlockedCellStyle);
       	
        }
        
      
        cellReference = new CellReference("E31");
        rowCase = datatypeSheet.getRow(cellReference.getRow());
        cellCase = rowCase.getCell(cellReference.getCol());
        cellValue = evaluator.evaluate(cellCase);

        
        if (cellValue ==null || cellValue.getCellType() != CellType.STRING) {
            
        } else {
            
       System.out.println("[ligne E31 : " + cellReference.getRow() + ", colonne : " + cellReference.getCol() + "] = [" + cellCase.getStringCellValue() + "]");
            
       cellCase.setCellValue("8888344222");
       cellCase.setCellStyle(unlockedCellStyle);
          
        }
        
        
        //FIn Information sur la page de garde
       
		
		FileOutputStream out = new FileOutputStream("F://TesteAccuse//ETATLINK_FinalOutput.xlsm");
		workbookoutput.write(out);
		out.close();
		
		
		
		
	       System.out.println("Fin");
	 
	   }
	
	
}

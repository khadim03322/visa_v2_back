package sn.gainde2000.orbuslink.visa.ef;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.PieceJoint;


public class MoteurMcc {
	   //ROYAL_BLUE
	
	 static Report report ;
	
	 static String urlRep="C://Users//MTHIAM//PROJECTS//GAINDE//VISA//OrbusLinkVisaBackend//upload/" ;
	 
	 static String urlFolder="http://localhost:9090/upload/";
	 
	  
	public static ExcelVerification verifyExcel(PieceJoint pieceJointe) {

        String nameRapport = pieceJointe.getLibelle() + "_rapport_verification_excel.xlsx" ;
        
        if(pieceJointe.getSystemeComptable().equals("1"))  //systeme Normal
        {
        	
         report = MccExcelReport.verifyExcelSystemeNormal(urlRep, pieceJointe.getName(), nameRapport,pieceJointe.getStatut()) ;
             	
        }else
        	if(pieceJointe.getSystemeComptable().equals("3")) //systeme banque
            {
            	
             report = MccExcelReport.verifyExcelBanque(urlRep, pieceJointe.getName(), nameRapport,pieceJointe.getStatut()) ;
                 	
            }
        
        	else
            	if(pieceJointe.getSystemeComptable().equals("4"))  //Systeme  assurance
                {
                	
                 report = MccExcelReport.verifyExcelAssurance(urlRep, pieceJointe.getName(), nameRapport,pieceJointe.getStatut()) ;
                     	
                }
        
            	else
                	if(pieceJointe.getSystemeComptable().equals("2")) // SMT
                    {
                    	
                     report = MccExcelReport.verifyExcelSMT(urlRep, pieceJointe.getName(), nameRapport,pieceJointe.getStatut()) ;
                         	
                    }
        	
        	
         
        
        ExcelVerification excelVerification = new ExcelVerification() ;
        List<String> positives = new ArrayList<>() ;
        List<String> negatives = new ArrayList<>() ;
        excelVerification.setPositives(positives);
        excelVerification.setNegatives(negatives);

        if(report!=null&& report.errorFormatExist) {
        	
         //negatives.add("Le fichier excel des ETAFI soumis est différent du modèle de la DGID ");
        	
        	if(report.listfeuillesManquantes.size()>0)
        		negatives= report.listfeuillesManquantes;
        	else
        		negatives=  report.listongletsnomsModifies;
        	
        	//System.out.println(" negatives"+ negatives.toString());
        	 System.out.println(" negatives"+ negatives.toString() + "fichier :"+urlFolder+nameRapport);
        	
        }else {
        
        if(report!=null&& report.isErrorExist())
        {
            negatives.add("Le fichier en cours de chargement n'est pas rempli en bonne et due forme. Merci de cliquer ici pour télécharger le rapport de contrôle de conformité");
            excelVerification.setPathReport(urlFolder+nameRapport);
            
            System.out.println(" negatives"+ negatives.toString() + "fichier :"+urlFolder+nameRapport);
        }
        else if(report == null) {
            negatives.add("Les nom de certaines rubriques ont été changés");
            System.out.println(" negatives"+ negatives.toString());
        }
        else {
            positives.add("Les Etats Financiers ont été chargés avec succès");
            
            System.out.println(" positives"+ positives.toString());
        }
        
        }
        
        
        
        return excelVerification ;
    }
  
	
	
	
	
	
	  
	  
	  
	  
	  
	  

}

package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

public class Note13 {

	  String title;
	  
	  String donnee;
	  
	  
	  String observation;
	  
	  String cellule;
		
	    public String getCellule() {
		return cellule;
	}
	    
	    
	public void setCellule(String cellule) {
		this.cellule = cellule;
	}
	
		public Note13() {
	  
	    	  this.errorMap = new HashMap<String, String>();
	    	  this.errorCelluleMap = new HashMap<String, String>();
	    	 this.title = "Non-conformités sur la Rubrique : Note13";
	         this.donnee = "Donnée concernée";
	         this.observation = "Observations";
	         this.cellule = "Cellule";


	}

		public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

		public String getDonnee() {
		return donnee;
	}

	public void setDonnee(String donnee) {
		this.donnee = donnee;
	}

		
	
	 public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	Map<String,String> errorMap;
	
	Map<String,String> errorCelluleMap;
	 
	 
	 
	 public Map<String, String> getErrorCelluleMap() {
		return errorCelluleMap;
	}

	public void setErrorCelluleMap(Map<String, String> errorCelluleMap) {
		this.errorCelluleMap = errorCelluleMap;
	}

	public Map<String, String> getErrorMap() {
	        return errorMap;
	    }

	    public void setErrorMap(Map<String, String> errorMap) {
	        this.errorMap = errorMap;
	    }
	
	
}

package sn.gainde2000.orbuslink.visa.ef;


import java.util.HashMap;
import java.util.Map;

public class BilanPassifReport {
    
    String title;
    String donnee;
    String observation;
    
    String totalActifImmobilise;
    String totalActifImmobiliseDonnee;
    String totalActifImmobiliseObservation;
    boolean totalActifImmobiliseIsCorrect;
    String totalActifImmobiliseCellule;
    
    String totalRessource;
    String totalRessourceDonnee;
    String totalRessourceObservation;
    boolean totalRessourceIsCorrect;
    String totalRessourceCellule;
    
    String totalActifCirculant;
    String totalActifCirculantDonnee;
    String totalActifCirculantObservation;
    boolean totalActifCirculantIsCorrect;
    String totalActifCirculantCellule;
    
    
    String totalPassif;
    String totalPassifDonnee;
    String totalPassifObservation;
    boolean totalPassifIsCorrect;
    String totalPassifCellule;
    
    
    
    String totalTresorerieActif;
    String totalTresorerieActifDonnee;
    String totalTresorerieActifObservation;
    boolean totalTresorerieActifIsCorrect;
    String totalTresorerieActifCellule;
    
    
    String totalTresoreriePassif;
    String totalTresoreriePassifDonnee;
    String totalTresoreriePassifObservation;
    boolean totalTresoreriePassifIsCorrect;
    String totalTresoreriePassifCellule;
    
    
    String totalGeneralActif;
    String totalGeneralActifDonnee;
    String totalGeneralActifObservation;
    boolean totalGeneralActifIsCorrect;
    String totalGeneralActifCellule;
    
    
    String totalGeneralPassif;
    String totalGeneralPassifDonnee;
    String totalGeneralPassifObservation;
    boolean totalGeneralPassifIsCorrect;
    String totalGeneralPassifCellule;

    int nombreDeLigne ;
    String nombreDeLigneDonnee = "Nombre de ligne" ;
    String nombreDeLigneObservation ="Nombre de ligne du tableau différent de celui du modèle" ;
    Boolean nombreDeLigneIsCorrect ;
    String nombreDeLigneCellule;

    

    public String getTotalActifImmobiliseCellule() {
		return totalActifImmobiliseCellule;
	}


	public void setTotalActifImmobiliseCellule(String totalActifImmobiliseCellule) {
		this.totalActifImmobiliseCellule = totalActifImmobiliseCellule;
	}


	public String getTotalRessourceCellule() {
		return totalRessourceCellule;
	}


	public void setTotalRessourceCellule(String totalRessourceCellule) {
		this.totalRessourceCellule = totalRessourceCellule;
	}


	public String getTotalActifCirculantCellule() {
		return totalActifCirculantCellule;
	}


	public void setTotalActifCirculantCellule(String totalActifCirculantCellule) {
		this.totalActifCirculantCellule = totalActifCirculantCellule;
	}


	public String getTotalPassifCellule() {
		return totalPassifCellule;
	}


	public void setTotalPassifCellule(String totalPassifCellule) {
		this.totalPassifCellule = totalPassifCellule;
	}


	public String getTotalTresorerieActifCellule() {
		return totalTresorerieActifCellule;
	}


	public void setTotalTresorerieActifCellule(String totalTresorerieActifCellule) {
		this.totalTresorerieActifCellule = totalTresorerieActifCellule;
	}


	public String getTotalTresoreriePassifCellule() {
		return totalTresoreriePassifCellule;
	}


	public void setTotalTresoreriePassifCellule(String totalTresoreriePassifCellule) {
		this.totalTresoreriePassifCellule = totalTresoreriePassifCellule;
	}


	public String getTotalGeneralActifCellule() {
		return totalGeneralActifCellule;
	}


	public void setTotalGeneralActifCellule(String totalGeneralActifCellule) {
		this.totalGeneralActifCellule = totalGeneralActifCellule;
	}


	public String getTotalGeneralPassifCellule() {
		return totalGeneralPassifCellule;
	}


	public void setTotalGeneralPassifCellule(String totalGeneralPassifCellule) {
		this.totalGeneralPassifCellule = totalGeneralPassifCellule;
	}


	public String getNombreDeLigneCellule() {
		return nombreDeLigneCellule;
	}


	public void setNombreDeLigneCellule(String nombreDeLigneCellule) {
		this.nombreDeLigneCellule = nombreDeLigneCellule;
	}


	String cellule;
   	Map<String,String> errorCelluleMap;
    
   	
   	    public String getCellule() {
   		return cellule;
   	}
   	    
   	    
   	public void setCellule(String cellule) {
   		this.cellule = cellule;
   	}

    
   	 public Map<String, String> getErrorCelluleMap() {
   		return errorCelluleMap;
   	}

   	public void setErrorCelluleMap(Map<String, String> errorCelluleMap) {
   		this.errorCelluleMap = errorCelluleMap;
   	}


    
    
    
    public int getNombreDeLigne() {
        return nombreDeLigne;
    }

    public void setNombreDeLigne(int nombreDeLigne) {
        this.nombreDeLigne = nombreDeLigne;
    }

    public String getNombreDeLigneDonnee() {
        return nombreDeLigneDonnee;
    }

    public void setNombreDeLigneDonnee(String nombreDeLigneDonnee) {
        this.nombreDeLigneDonnee = nombreDeLigneDonnee;
    }

    public String getNombreDeLigneObservation() {
        return nombreDeLigneObservation;
    }

    public void setNombreDeLigneObservation(String nombreDeLigneObservation) {
        this.nombreDeLigneObservation = nombreDeLigneObservation;
    }

    public Boolean getNombreDeLigneIsCorrect() {
        return nombreDeLigneIsCorrect;
    }

    public void setNombreDeLigneIsCorrect(Boolean nombreDeLigneIsCorrect) {
        this.nombreDeLigneIsCorrect = nombreDeLigneIsCorrect;
        if (nombreDeLigneIsCorrect) {
            this.errorMap.remove(this.nombreDeLigneDonnee);
        } else {
            this.errorMap.put(this.nombreDeLigneDonnee, this.nombreDeLigneObservation);
        }
    }


    Map<String,String> errorMap;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDonnee() {
        return donnee;
    }

    public void setDonnee(String donnee) {
        this.donnee = donnee;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getTotalActifImmobilise() {
        return totalActifImmobilise;
    }

    public void setTotalActifImmobilise(String totalActifImmobilise) {
        this.totalActifImmobilise = totalActifImmobilise;
    }

    public String getTotalActifImmobiliseDonnee() {
        return totalActifImmobiliseDonnee;
    }

    public void setTotalActifImmobiliseDonnee(String totalActifImmobiliseDonnee) {
        this.totalActifImmobiliseDonnee = totalActifImmobiliseDonnee;
    }

    public String getTotalActifImmobiliseObservation() {
        return totalActifImmobiliseObservation;
    }

    public void setTotalActifImmobiliseObservation(String totalActifImmobiliseObservation) {
        this.totalActifImmobiliseObservation = totalActifImmobiliseObservation;
    }

    public boolean isTotalActifImmobiliseIsCorrect() {
        return totalActifImmobiliseIsCorrect;
    }

    public void setTotalActifImmobiliseIsCorrect(boolean totalActifImmobiliseIsCorrect) {
        this.totalActifImmobiliseIsCorrect = totalActifImmobiliseIsCorrect;
        if (totalActifImmobiliseIsCorrect) {
            this.errorMap.remove(this.totalActifImmobiliseDonnee);
        } else {
            this.errorMap.put(this.totalActifImmobiliseDonnee, this.totalActifImmobiliseObservation);
        }
    }

    public String getTotalRessource() {
        return totalRessource;
    }

    public void setTotalRessource(String totalRessource) {
        this.totalRessource = totalRessource;
    }

    public String getTotalRessourceDonnee() {
        return totalRessourceDonnee;
    }

    public void setTotalRessourceDonnee(String totalRessourceDonnee) {
        this.totalRessourceDonnee = totalRessourceDonnee;
    }

    public String getTotalRessourceObservation() {
        return totalRessourceObservation;
    }

    public void setTotalRessourceObservation(String totalRessourceObservation) {
        this.totalRessourceObservation = totalRessourceObservation;
    }

    public boolean isTotalRessourceIsCorrect() {
        return totalRessourceIsCorrect;
    }

    public void setTotalRessourceIsCorrect(boolean totalRessourceIsCorrect) {
        this.totalRessourceIsCorrect = totalRessourceIsCorrect;
        if (totalRessourceIsCorrect) {
            this.errorMap.remove(this.totalRessourceDonnee);
        } else {
            this.errorMap.put(this.totalRessourceDonnee, this.totalRessourceObservation);
        }
    }

    public String getTotalActifCirculant() {
        return totalActifCirculant;
    }

    public void setTotalActifCirculant(String totalActifCirculant) {
        this.totalActifCirculant = totalActifCirculant;
    }

    public String getTotalActifCirculantDonnee() {
        return totalActifCirculantDonnee;
    }

    public void setTotalActifCirculantDonnee(String totalActifCirculantDonnee) {
        this.totalActifCirculantDonnee = totalActifCirculantDonnee;
    }

    public String getTotalActifCirculantObservation() {
        return totalActifCirculantObservation;
    }

    public void setTotalActifCirculantObservation(String totalActifCirculantObservation) {
        this.totalActifCirculantObservation = totalActifCirculantObservation;
    }

    public boolean isTotalActifCirculantIsCorrect() {
        return totalActifCirculantIsCorrect;
    }

    public void setTotalActifCirculantIsCorrect(boolean totalActifCirculantIsCorrect) {
        this.totalActifCirculantIsCorrect = totalActifCirculantIsCorrect;
        if (totalActifCirculantIsCorrect) {
            this.errorMap.remove(this.totalActifCirculantDonnee);
        } else {
            this.errorMap.put(this.totalActifCirculantDonnee, this.totalActifCirculantObservation);
        }
    }

    public String getTotalPassif() {
        return totalPassif;
    }

    public void setTotalPassif(String totalPassif) {
        this.totalPassif = totalPassif;
    }

    public String getTotalPassifDonnee() {
        return totalPassifDonnee;
    }

    public void setTotalPassifDonnee(String totalPassifDonnee) {
        this.totalPassifDonnee = totalPassifDonnee;
    }

    public String getTotalPassifObservation() {
        return totalPassifObservation;
    }

    public void setTotalPassifObservation(String totalPassifObservation) {
        this.totalPassifObservation = totalPassifObservation;
    }

    public boolean isTotalPassifIsCorrect() {
        return totalPassifIsCorrect;
    }

    public void setTotalPassifIsCorrect(boolean totalPassifIsCorrect) {
        this.totalPassifIsCorrect = totalPassifIsCorrect;
        if (totalPassifIsCorrect) {
            this.errorMap.remove(this.totalPassifDonnee);
        } else {
            this.errorMap.put(this.totalPassifDonnee, this.totalPassifObservation);
        }
    }

    public String getTotalTresorerieActif() {
        return totalTresorerieActif;
    }

    public void setTotalTresorerieActif(String totalTresorerieActif) {
        this.totalTresorerieActif = totalTresorerieActif;
    }

    public String getTotalTresorerieActifDonnee() {
        return totalTresorerieActifDonnee;
    }

    public void setTotalTresorerieActifDonnee(String totalTresorerieActifDonnee) {
        this.totalTresorerieActifDonnee = totalTresorerieActifDonnee;
    }

    public String getTotalTresorerieActifObservation() {
        return totalTresorerieActifObservation;
    }

    public void setTotalTresorerieActifObservation(String totalTresorerieActifObservation) {
        this.totalTresorerieActifObservation = totalTresorerieActifObservation;
    }

    public boolean isTotalTresorerieActifIsCorrect() {
        return totalTresorerieActifIsCorrect;
    }

    public void setTotalTresorerieActifIsCorrect(boolean totalTresorerieActifIsCorrect) {
        this.totalTresorerieActifIsCorrect = totalTresorerieActifIsCorrect;
        if (totalTresorerieActifIsCorrect) {
            this.errorMap.remove(this.totalTresorerieActifDonnee);
        } else {
            this.errorMap.put(this.totalTresorerieActifDonnee, this.totalTresorerieActifObservation);
        }
    }

    public String getTotalTresoreriePassif() {
        return totalTresoreriePassif;
    }

    public void setTotalTresoreriePassif(String totalTresoreriePassif) {
        this.totalTresoreriePassif = totalTresoreriePassif;
    }

    public String getTotalTresoreriePassifDonnee() {
        return totalTresoreriePassifDonnee;
    }

    public void setTotalTresoreriePassifDonnee(String totalTresoreriePassifDonnee) {
        this.totalTresoreriePassifDonnee = totalTresoreriePassifDonnee;
    }

    public String getTotalTresoreriePassifObservation() {
        return totalTresoreriePassifObservation;
    }

    public void setTotalTresoreriePassifObservation(String totalTresoreriePassifObservation) {
        this.totalTresoreriePassifObservation = totalTresoreriePassifObservation;
    }

    public boolean isTotalTresoreriePassifIsCorrect() {
        return totalTresoreriePassifIsCorrect;
    }

    public void setTotalTresoreriePassifIsCorrect(boolean totalTresoreriePassifIsCorrect) {
        this.totalTresoreriePassifIsCorrect = totalTresoreriePassifIsCorrect;
        if (totalTresoreriePassifIsCorrect) {
            this.errorMap.remove(this.totalTresoreriePassifDonnee);
        } else {
            this.errorMap.put(this.totalTresoreriePassifDonnee, this.totalTresoreriePassifObservation);
        }
    }

    public String getTotalGeneralActif() {
        return totalGeneralActif;
    }

    public void setTotalGeneralActif(String totalGeneralActif) {
        this.totalGeneralActif = totalGeneralActif;
    }

    public String getTotalGeneralActifDonnee() {
        return totalGeneralActifDonnee;
    }

    public void setTotalGeneralActifDonnee(String totalGeneralActifDonnee) {
        this.totalGeneralActifDonnee = totalGeneralActifDonnee;
    }

    public String getTotalGeneralActifObservation() {
        return totalGeneralActifObservation;
    }

    public void setTotalGeneralActifObservation(String totalGeneralActifObservation) {
        this.totalGeneralActifObservation = totalGeneralActifObservation;
    }

    public boolean isTotalGeneralActifIsCorrect() {
        return totalGeneralActifIsCorrect;
    }

    public void setTotalGeneralActifIsCorrect(boolean totalGeneralActifIsCorrect) {
        this.totalGeneralActifIsCorrect = totalGeneralActifIsCorrect;
        if (totalGeneralActifIsCorrect) {
            this.errorMap.remove(this.totalGeneralActifDonnee);
        } else {
            this.errorMap.put(this.totalGeneralActifDonnee, this.totalGeneralActifObservation);
        }
    }

    public String getTotalGeneralPassif() {
        return totalGeneralPassif;
    }

    public void setTotalGeneralPassif(String totalGeneralPassif) {
        this.totalGeneralPassif = totalGeneralPassif;
    }

    public String getTotalGeneralPassifDonnee() {
        return totalGeneralPassifDonnee;
    }

    public void setTotalGeneralPassifDonnee(String totalGeneralPassifDonnee) {
        this.totalGeneralPassifDonnee = totalGeneralPassifDonnee;
    }

    public String getTotalGeneralPassifObservation() {
        return totalGeneralPassifObservation;
    }

    public void setTotalGeneralPassifObservation(String totalGeneralPassifObservation) {
        this.totalGeneralPassifObservation = totalGeneralPassifObservation;
    }

    public boolean isTotalGeneralPassifIsCorrect() {
        return totalGeneralPassifIsCorrect;
    }

    public void setTotalGeneralPassifIsCorrect(boolean totalGeneralPassifIsCorrect) {
        this.totalGeneralPassifIsCorrect = totalGeneralPassifIsCorrect;
        if (totalGeneralPassifIsCorrect) {
            this.errorMap.remove(this.totalGeneralPassifDonnee);
        } else {
            this.errorMap.put(this.totalGeneralPassifDonnee, this.totalGeneralPassifObservation);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public BilanPassifReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Bilan Passif";
        this.donnee = "Donnée concernée";
        this.observation = "Observations";
        
        this.errorCelluleMap = new HashMap<String, String>();
        this.cellule = "Cellule";
        
        this.totalActifImmobilise = "totalActifImmobilise";
        this.totalActifImmobiliseDonnee = "TOTAL ACTIF IMMOBILISE";
////        this.totalActifImmobiliseObservation = "totalActifImmobiliseObservation";
////        this.totalActifImmobiliseIsCorrect = false;
////        errorMap.put(this.totalActifImmobiliseDonnee, this.totalActifImmobiliseObservation);
        
        this.totalRessource = "totalRessource";
        this.totalRessourceDonnee = "TOTAL RESSOURCES STABLES";
////        this.totalRessourceObservation = "totalRessourceObservation";
////        this.totalRessourceIsCorrect = false;
////        errorMap.put(this.totalRessourceDonnee, this.totalRessourceObservation);
        
        this.totalActifCirculant = "totalActifCirculant";
        this.totalActifCirculantDonnee = "TOTAL ACTIF CIRCULANT";
////        this.totalActifCirculantObservation = "totalActifCirculantObservation";
////        this.totalActifCirculantIsCorrect = false;
////        errorMap.put(this.totalActifCirculantDonnee, this.totalActifCirculantObservation);
        
        this.totalPassif = "totalPassif";
        this.totalPassifDonnee = "TOTAL PASSIF CIRCULANT";
////        this.totalPassifObservation = "totalPassifObservation";
////        this.totalPassifIsCorrect = false;
////        errorMap.put(this.totalPassifDonnee, this.totalPassifObservation);
        
        this.totalTresorerieActif = "totalTresorerieActif";
        this.totalTresorerieActifDonnee = "TOTAL TRESORERIE - ACTIF";
////        this.totalTresorerieActifObservation = "totalTresorerieActifObservation";
////        this.totalTresorerieActifIsCorrect = false;
////        errorMap.put(this.totalTresorerieActifDonnee, this.totalTresorerieActifObservation);
        
        this.totalTresoreriePassif = "totalTresoreriePassif";
        this.totalTresoreriePassifDonnee = "TOTAL TRESORERIE - PASSIF";
////        this.totalTresoreriePassifObservation = "totalTresoreriePassifObservation";
////        this.totalTresoreriePassifIsCorrect = false;
////        errorMap.put(this.totalTresoreriePassifDonnee, this.totalTresoreriePassifObservation);
        
        this.totalGeneralActif = "totalGeneralActif";
        this.totalGeneralActifDonnee = "TOTAL GENERAL - ACTIF";
////        this.totalGeneralActifObservation = "totalGeneralActifObservation";
////        this.totalGeneralActifIsCorrect = false;
////        errorMap.put(this.totalGeneralActifDonnee, this.totalGeneralActifObservation);
        
        this.totalGeneralPassif = "totalGeneralPassif";
        this.totalGeneralPassifDonnee = "TOTAL GENERAL - PASSIF";
////        this.totalGeneralPassifObservation = "totalGeneralPassifObservation";
////        this.totalGeneralPassifIsCorrect = false;
////        errorMap.put(this.totalGeneralPassifDonnee, this.totalGeneralPassifObservation);
    }
}

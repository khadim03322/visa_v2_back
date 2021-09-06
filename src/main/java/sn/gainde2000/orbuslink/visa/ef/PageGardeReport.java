package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class PageGardeReport {
    String title;
    String donnee;
    String observation;
    
    String centreDepot;
    String centreDepotDonnee;
    String centreDepotObservation;
    boolean centreDepotIsCorrect;
    String centreDepotCellule;
    String celluleCentreDepot;
    
    String exerciceClos;
    String exerciceClosDonnee;
    String exerciceClosObservation;
    boolean exerciceClosIsCorrect;
    String exerciceClosCellule;
     String celluleexerciceClos;
    
    String denominationSociale;
    String denominationSocialeDonnee;
    String denominationSocialeObservation;
    boolean denominationSocialeIsCorrect;
    String denominationSocialeCellule;
    String celluledenominationSociale;
    
    String adresse;
    String adresseDonnee;
    String adresseObservation;
    boolean adresseIsCorrect;
    String adresseCellule;
    String celluleadresse;
    
    String idFiscale;
    String idFiscaleDonnee;
    String idFiscaleObservation;
    boolean idFiscaleIsCorrect;
    String idFiscaleCellule;
    String celluleFiscale;
    
    
    
    
    public String getCentreDepotCellule() {
		return centreDepotCellule;
	}


	public void setCentreDepotCellule(String centreDepotCellule) {
		this.centreDepotCellule = centreDepotCellule;
	}


	public String getExerciceClosCellule() {
		return exerciceClosCellule;
	}


	public void setExerciceClosCellule(String exerciceClosCellule) {
		this.exerciceClosCellule = exerciceClosCellule;
	}


	public String getDenominationSocialeCellule() {
		return denominationSocialeCellule;
	}


	public void setDenominationSocialeCellule(String denominationSocialeCellule) {
		this.denominationSocialeCellule = denominationSocialeCellule;
	}


	public String getAdresseCellule() {
		return adresseCellule;
	}


	public void setAdresseCellule(String adresseCellule) {
		this.adresseCellule = adresseCellule;
	}


	public String getIdFiscaleCellule() {
		return idFiscaleCellule;
	}


	public void setIdFiscaleCellule(String idFiscaleCellule) {
		this.idFiscaleCellule = idFiscaleCellule;
	}

	Map<String,String> errorMap;
    
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

    public String getCentreDepot() {
        return centreDepot;
    }

    public void setCentreDepot(String centreDepot) {
        this.centreDepot = centreDepot;
    }

    public String getCentreDepotDonnee() {
        return centreDepotDonnee;
    }

    public void setCentreDepotDonnee(String centreDepotDonnee) {
        this.centreDepotDonnee = centreDepotDonnee;
    }

    public String getCentreDepotObservation() {
        return centreDepotObservation;
    }

    public void setCentreDepotObservation(String centreDepotObservation) {
        this.centreDepotObservation = centreDepotObservation;
    }

    public boolean isCentreDepotIsCorrect() {
        return centreDepotIsCorrect;
    }

    public void setCentreDepotIsCorrect(boolean centreDepotIsCorrect) {
        this.centreDepotIsCorrect = centreDepotIsCorrect;
        if (centreDepotIsCorrect) {
            this.errorMap.remove(this.centreDepotDonnee);
        } else {
            this.errorMap.put(this.centreDepotDonnee, this.centreDepotObservation);
            this.errorCelluleMap.put(this.centreDepotDonnee, this.centreDepotCellule);
        }
    }

    public String getExerciceClos() {
        return exerciceClos;
    }

    public void setExerciceClos(String exerciceClos) {
        this.exerciceClos = exerciceClos;
    }

    public String getExerciceClosDonnee() {
        return exerciceClosDonnee;
    }

    public void setExerciceClosDonnee(String exerciceClosDonnee) {
        this.exerciceClosDonnee = exerciceClosDonnee;
    }

    public String getExerciceClosObservation() {
        return exerciceClosObservation;
    }

    public void setExerciceClosObservation(String exerciceClosObservation) {
        this.exerciceClosObservation = exerciceClosObservation;
    }

    public boolean isExerciceClosIsCorrect() {
        return exerciceClosIsCorrect;
    }

    public void setExerciceClosIsCorrect(boolean exerciceClosIsCorrect) {
        this.exerciceClosIsCorrect = exerciceClosIsCorrect;
        if (exerciceClosIsCorrect) {
            this.errorMap.remove(this.exerciceClosDonnee);
        } else {
            this.errorMap.put(this.exerciceClosDonnee, this.exerciceClosObservation);
            this.errorCelluleMap.put(this.exerciceClosDonnee, this.exerciceClosCellule);
        }
    }

    public String getDenominationSociale() {
        return denominationSociale;
    }

    public void setDenominationSociale(String denominationSociale) {
        this.denominationSociale = denominationSociale;
    }

    public String getDenominationSocialeDonnee() {
        return denominationSocialeDonnee;
    }

    public void setDenominationSocialeDonnee(String denominationSocialeDonnee) {
        this.denominationSocialeDonnee = denominationSocialeDonnee;
    }

    public String getDenominationSocialeObservation() {
        return denominationSocialeObservation;
    }

    public void setDenominationSocialeObservation(String denominationSocialeObservation) {
        this.denominationSocialeObservation = denominationSocialeObservation;
    }

    public boolean isDenominationSocialeIsCorrect() {
        return denominationSocialeIsCorrect;
    }

    public void setDenominationSocialeIsCorrect(boolean denominationSocialeIsCorrect) {
        this.denominationSocialeIsCorrect = denominationSocialeIsCorrect;
        if (denominationSocialeIsCorrect) {
            this.errorMap.remove(this.denominationSocialeDonnee);
        } else {
            this.errorMap.put(this.denominationSocialeDonnee, this.denominationSocialeObservation);
            this.errorCelluleMap.put(this.denominationSocialeDonnee, this.denominationSocialeCellule);
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresseDonnee() {
        return adresseDonnee;
    }

    public void setAdresseDonnee(String adresseDonnee) {
        this.adresseDonnee = adresseDonnee;
    }

    public String getAdresseObservation() {
        return adresseObservation;
    }

    public void setAdresseObservation(String adresseObservation) {
        this.adresseObservation = adresseObservation;
    }

    public boolean isAdresseIsCorrect() {
        return adresseIsCorrect;
    }

    public void setAdresseIsCorrect(boolean adresseIsCorrect) {
        this.adresseIsCorrect = adresseIsCorrect;
        if (adresseIsCorrect) {
            this.errorMap.remove(this.adresseDonnee);
        } else {
            this.errorMap.put(this.adresseDonnee, this.adresseObservation);
            this.errorCelluleMap.put(this.adresseDonnee, this.adresseCellule);
        }
    }

    public String getIdFiscale() {
        return idFiscale;
    }

    public void setIdFiscale(String idFiscale) {
        this.idFiscale = idFiscale;
    }

    public String getIdFiscaleDonnee() {
        return idFiscaleDonnee;
    }

    public void setIdFiscaleDonnee(String idFiscaleDonnee) {
        this.idFiscaleDonnee = idFiscaleDonnee;
    }

    public String getIdFiscaleObservation() {
        return idFiscaleObservation;
    }

    public void setIdFiscaleObservation(String idFiscaleObservation) {
        this.idFiscaleObservation = idFiscaleObservation;
    }

    public boolean isIdFiscaleIsCorrect() {
        return idFiscaleIsCorrect;
    }
    
    

    public String getCelluleCentreDepot() {
		return celluleCentreDepot;
	}


	public void setCelluleCentreDepot(String celluleCentreDepot) {
		this.celluleCentreDepot = celluleCentreDepot;
	}


	public String getCelluleexerciceClos() {
		return celluleexerciceClos;
	}


	public void setCelluleexerciceClos(String celluleexerciceClos) {
		this.celluleexerciceClos = celluleexerciceClos;
	}


	public String getCelluledenominationSociale() {
		return celluledenominationSociale;
	}


	public void setCelluledenominationSociale(String celluledenominationSociale) {
		this.celluledenominationSociale = celluledenominationSociale;
	}


	public String getCelluleadresse() {
		return celluleadresse;
	}


	public void setCelluleadresse(String celluleadresse) {
		this.celluleadresse = celluleadresse;
	}


	public String getCelluleFiscale() {
		return celluleFiscale;
	}


	public void setCelluleFiscale(String celluleFiscale) {
		this.celluleFiscale = celluleFiscale;
	}


	public void setIdFiscaleIsCorrect(boolean idFiscaleIsCorrect) {
        this.idFiscaleIsCorrect = idFiscaleIsCorrect;
        if (idFiscaleIsCorrect) {
            this.errorMap.remove(this.idFiscaleDonnee);
        } else {
            this.errorMap.put(this.idFiscaleDonnee, this.idFiscaleObservation);
            System.out.print("Debut --------------------------->"+this.idFiscaleObservation +"---Cellule-----"+this.idFiscaleCellule);
            this.errorCelluleMap.put(this.idFiscaleDonnee, this.idFiscaleCellule);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public PageGardeReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Page de garde";
        this.donnee = "Donnée concernée";
        this.observation = "Observations";
        this.errorCelluleMap = new HashMap<String, String>();
        this.cellule = "Cellule";

        
        this.centreDepot = "centreDepot";
        this.centreDepotDonnee = "CENTRE DE DEPÔT DE";
////        this.centreDepotObservation = "centreDepotObservation";
////        this.centreDepotIsCorrect = false;
////        errorMap.put(this.centreDepotDonnee, this.centreDepotObservation);
        
        this.exerciceClos = "exerciceClos";
        this.exerciceClosDonnee = "EXERCICE CLOS LE";
////        this.exerciceClosObservation = "exerciceClosObservation";
////        this.exerciceClosIsCorrect = false;
////        errorMap.put(this.exerciceClosDonnee, this.exerciceClosObservation);
        
        this.denominationSociale = "denominationSociale";
        this.denominationSocialeDonnee = "DENOMINATION SOCIALE :";
////        this.denominationSocialeObservation = "denominationSocialeObservation";
////        this.denominationSocialeIsCorrect = false;
////        errorMap.put(this.denominationSocialeDonnee, this.denominationSocialeObservation);
        
        this.adresse = "adresse";
        this.adresseDonnee = "ADRESSE COMPLETE :";
////        this.adresseObservation = "adresseObservation";
////        this.adresseIsCorrect = false;
////        errorMap.put(this.adresseDonnee, this.adresseObservation);
        
        this.idFiscale = "idFiscale";
        this.idFiscaleDonnee = "N° D'IDENTIFICATION FISCALE :";
////        this.idFiscaleObservation = "idFiscaleObservation";
////        this.idFiscaleIsCorrect = false;
////        errorMap.put(this.idFiscaleDonnee, this.idFiscaleObservation);
    }
    
    
}

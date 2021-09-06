package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class ActiviteEntrepriseReport {
    
    String title;
    String donnee;
    String observation;
    
    String centreDepot;
    String centreDepotDonnee;
    String centreDepotObservation;
    boolean centreDepotIsCorrect;
    String centreDepotCellule;
    
    String exerciceClos;
    String exerciceClosDonnee;
    String exerciceClosObservation;
    boolean exerciceClosIsCorrect;
    String exerciceClosCellule;
    
    String denominationSociale;
    String denominationSocialeDonnee;
    String denominationSocialeObservation;
    boolean denominationSocialeIsCorrect;
    String denominationSocialeCellule;
    
    String adresse;
    String adresseDonnee;
    String adresseObservation;
    boolean adresseIsCorrect;
    String adresseCellule;
    
    String idFiscale;
    String idFiscaleDonnee;
    String idFiscaleObservation;
    boolean idFiscaleIsCorrect;
    String idFiscaleCellule;
    
    String exerciceComptable;
    String exerciceComptableDonnee;
    String exerciceComptableObservation;
    boolean exerciceComptableIsCorrect;
    String exerciceComptableCellule;
    
    String dateArreteComptes;
    String dateArreteComptesDonnee;
    String dateArreteComptesObservation;
    boolean dateArreteComptesIsCorrect;
    String dateArreteComptesCellule;
    
    String designationActivite;
    String designationActiviteDonnee;
    String designationActiviteObservation;
    boolean designationActiviteIsCorrect;
    String designationActiviteCellule;
    
    
    
    
    
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

	public String getExerciceComptableCellule() {
		return exerciceComptableCellule;
	}

	public void setExerciceComptableCellule(String exerciceComptableCellule) {
		this.exerciceComptableCellule = exerciceComptableCellule;
	}

	public String getDateArreteComptesCellule() {
		return dateArreteComptesCellule;
	}

	public void setDateArreteComptesCellule(String dateArreteComptesCellule) {
		this.dateArreteComptesCellule = dateArreteComptesCellule;
	}

	public String getDesignationActiviteCellule() {
		return designationActiviteCellule;
	}

	public void setDesignationActiviteCellule(String designationActiviteCellule) {
		this.designationActiviteCellule = designationActiviteCellule;
	}

	Map<String,String> errorMap;
    
    String cellule;
	
    public String getCellule() {
	return cellule;
}
    
    Map<String,String> errorCelluleMap;
	 
	 
	 
	 public Map<String, String> getErrorCelluleMap() {
		return errorCelluleMap;
	}

	public void setErrorCelluleMap(Map<String, String> errorCelluleMap) {
		this.errorCelluleMap = errorCelluleMap;
	}

    
   
public void setCellule(String cellule) {
	this.cellule = cellule;
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
            this.errorCelluleMap.remove(this.centreDepotDonnee);
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

    public void setIdFiscaleIsCorrect(boolean idFiscaleIsCorrect) {
        this.idFiscaleIsCorrect = idFiscaleIsCorrect;
        if (idFiscaleIsCorrect) {
            this.errorMap.remove(this.idFiscaleDonnee);
        } else {
            this.errorMap.put(this.idFiscaleDonnee, this.idFiscaleObservation);
            this.errorCelluleMap.put(this.idFiscaleDonnee, this.idFiscaleCellule);
        }
    }

    public String getExerciceComptable() {
        return exerciceComptable;
    }

    public void setExerciceComptable(String exerciceComptable) {
        this.exerciceComptable = exerciceComptable;
    }

    public String getExerciceComptableDonnee() {
        return exerciceComptableDonnee;
    }

    public void setExerciceComptableDonnee(String exerciceComptableDonnee) {
        this.exerciceComptableDonnee = exerciceComptableDonnee;
    }

    public String getExerciceComptableObservation() {
        return exerciceComptableObservation;
    }

    public void setExerciceComptableObservation(String exerciceComptableObservation) {
        this.exerciceComptableObservation = exerciceComptableObservation;
    }

    public boolean isExerciceComptableIsCorrect() {
        return exerciceComptableIsCorrect;
    }

    public void setExerciceComptableIsCorrect(boolean exerciceComptableIsCorrect) {
        this.exerciceComptableIsCorrect = exerciceComptableIsCorrect;
        if (exerciceComptableIsCorrect) {
            this.errorMap.remove(this.exerciceComptableDonnee);
        } else {
            this.errorMap.put(this.exerciceComptableDonnee, this.exerciceComptableObservation);
            this.errorCelluleMap.put(this.exerciceComptableDonnee, this.exerciceComptableCellule);
        }
    }

    public String getDateArreteComptes() {
        return dateArreteComptes;
    }

    public void setDateArreteComptes(String dateArreteComptes) {
        this.dateArreteComptes = dateArreteComptes;
    }

    public String getDateArreteComptesDonnee() {
        return dateArreteComptesDonnee;
    }

    public void setDateArreteComptesDonnee(String dateArreteComptesDonnee) {
        this.dateArreteComptesDonnee = dateArreteComptesDonnee;
    }

    public String getDateArreteComptesObservation() {
        return dateArreteComptesObservation;
    }

    public void setDateArreteComptesObservation(String dateArreteComptesObservation) {
        this.dateArreteComptesObservation = dateArreteComptesObservation;
    }

    public boolean isDateArreteComptesIsCorrect() {
        return dateArreteComptesIsCorrect;
    }

    public void setDateArreteComptesIsCorrect(boolean dateArreteComptesIsCorrect) {
        this.dateArreteComptesIsCorrect = dateArreteComptesIsCorrect;
        if (dateArreteComptesIsCorrect) {
            this.errorMap.remove(this.dateArreteComptesDonnee);
        } else {
            this.errorMap.put(this.dateArreteComptesDonnee, this.dateArreteComptesObservation);
            this.errorCelluleMap.put(this.dateArreteComptesDonnee, this.dateArreteComptesCellule);
        }
    }

    public String getDesignationActivite() {
        return designationActivite;
    }

    public void setDesignationActivite(String designationActivite) {
        this.designationActivite = designationActivite;
    }

    public String getDesignationActiviteDonnee() {
        return designationActiviteDonnee;
    }

    public void setDesignationActiviteDonnee(String designationActiviteDonnee) {
        this.designationActiviteDonnee = designationActiviteDonnee;
    }

    public String getDesignationActiviteObservation() {
        return designationActiviteObservation;
    }

    public void setDesignationActiviteObservation(String designationActiviteObservation) {
        this.designationActiviteObservation = designationActiviteObservation;
    }

    public boolean isDesignationActiviteIsCorrect() {
        return designationActiviteIsCorrect;
    }

    public void setDesignationActiviteIsCorrect(boolean designationActiviteIsCorrect) {
        this.designationActiviteIsCorrect = designationActiviteIsCorrect;
        if (designationActiviteIsCorrect) {
            this.errorMap.remove(this.designationActiviteDonnee);
        } else {
            this.errorMap.put(this.designationActiviteDonnee, this.designationActiviteObservation);
            this.errorCelluleMap.put(this.designationActiviteDonnee, this.designationActiviteCellule);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public ActiviteEntrepriseReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.errorCelluleMap = new HashMap<String, String>();
        this.cellule = "Cellule";
        this.title = "Non-conformités sur la Rubrique : Activités de l'entreprise";
        this.donnee = "Donnée concernée";
        this.observation = "Observations";
        this.cellule = "Cellule";

        this.centreDepot = "centreDepot";
        this.centreDepotDonnee = "CENTRE DE DEPÔT DE";
////        this.centreDepotObservation = "centreDepotObservation";
////        setCentreDepotIsCorrect(false);
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

        this.exerciceComptable = "exerciceComptable";
        this.exerciceComptableDonnee = "EXERCICE COMPTABLE";
////        this.exerciceComptableObservation = "exerciceComptableObservation";
////        this.exerciceComptableIsCorrect = false;
////        errorMap.put(this.exerciceComptableDonnee, this.exerciceComptableObservation);
        
        this.dateArreteComptes = "dateArreteComptes";
        this.dateArreteComptesDonnee = "DATE D'ARRETE EFFECTIF DES COMPTES";
////        this.dateArreteComptesObservation = "dateArreteComptesObservation";
////        this.dateArreteComptesIsCorrect = false;
////        errorMap.put(this.dateArreteComptesDonnee, this.dateArreteComptesObservation);
        
        this.designationActivite = "designationActivite";
        this.designationActiviteDonnee = "DESIGNATION DE L'ACTIVITE";
////        this.designationActiviteObservation = "designationActiviteObservation";
////        this.designationActiviteIsCorrect = false;
////        errorMap.put(this.designationActiviteDonnee, this.designationActiviteObservation);
    }
}

package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class CompteResultatReport {
    
    String title;
    String donnee;
    String observation;
    
    String chiffreAffaire;
    String chiffreAffaireDonnee;
    String chiffreAffaireObservation;
    boolean chiffreAffaireIsCorrect;
    String chiffreAffaireCellule;
    
    String valeurAjoutee;
    String valeurAjouteeDonnee;
    String valeurAjouteeObservation;
    boolean valeurAjouteeIsCorrect;
    String valeurAjouteeCellule;
    
    String exedent;
    String exedentDonnee;
    String exedentObservation;
    boolean exedentIsCorrect;
    String exedentCellule;
    
    String resultat;
    String resultatDonnee;
    String resultatObservation;
    boolean resultatIsCorrect;
    String resultatCellule;
    
    String resultatNet;
    String resultatNetDonnee;
    String resultatNetObservation;
    boolean resultatNetIsCorrect;
    String resultatNetCellule;
    
    
    public String getChiffreAffaireCellule() {
		return chiffreAffaireCellule;
	}


	public void setChiffreAffaireCellule(String chiffreAffaireCellule) {
		this.chiffreAffaireCellule = chiffreAffaireCellule;
	}


	public String getValeurAjouteeCellule() {
		return valeurAjouteeCellule;
	}


	public void setValeurAjouteeCellule(String valeurAjouteeCellule) {
		this.valeurAjouteeCellule = valeurAjouteeCellule;
	}


	public String getExedentCellule() {
		return exedentCellule;
	}


	public void setExedentCellule(String exedentCellule) {
		this.exedentCellule = exedentCellule;
	}


	public String getResultatCellule() {
		return resultatCellule;
	}


	public void setResultatCellule(String resultatCellule) {
		this.resultatCellule = resultatCellule;
	}


	public String getResultatNetCellule() {
		return resultatNetCellule;
	}


	public void setResultatNetCellule(String resultatNetCellule) {
		this.resultatNetCellule = resultatNetCellule;
	}

	Map<String,String> errorMap;

    int nombreDeLigne ;
    String nombreDeLigneDonnee = "Nombre de ligne" ;
    String nombreDeLigneObservation ="Nombre de ligne du tableau différent de celui du modèle" ;
    Boolean nombreDeLigneIsCorrect ;

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

    public String getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(String chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public String getChiffreAffaireDonnee() {
        return chiffreAffaireDonnee;
    }

    public void setChiffreAffaireDonnee(String chiffreAffaireDonnee) {
        this.chiffreAffaireDonnee = chiffreAffaireDonnee;
    }

    public String getChiffreAffaireObservation() {
        return chiffreAffaireObservation;
    }

    public void setChiffreAffaireObservation(String chiffreAffaireObservation) {
        this.chiffreAffaireObservation = chiffreAffaireObservation;
    }

    public boolean isChiffreAffaireIsCorrect() {
        return chiffreAffaireIsCorrect;
    }

    public void setChiffreAffaireIsCorrect(boolean chiffreAffaireIsCorrect) {
        this.chiffreAffaireIsCorrect = chiffreAffaireIsCorrect;
        if (chiffreAffaireIsCorrect) {
            this.errorMap.remove(this.chiffreAffaireDonnee);
        } else {
            this.errorMap.put(this.chiffreAffaireDonnee, this.chiffreAffaireObservation);
        }
    }

    public String getValeurAjoutee() {
        return valeurAjoutee;
    }

    public void setValeurAjoutee(String valeurAjoutee) {
        this.valeurAjoutee = valeurAjoutee;
    }

    public String getValeurAjouteeDonnee() {
        return valeurAjouteeDonnee;
    }

    public void setValeurAjouteeDonnee(String valeurAjouteeDonnee) {
        this.valeurAjouteeDonnee = valeurAjouteeDonnee;
    }

    public String getValeurAjouteeObservation() {
        return valeurAjouteeObservation;
    }

    public void setValeurAjouteeObservation(String valeurAjouteeObservation) {
        this.valeurAjouteeObservation = valeurAjouteeObservation;
    }

    public boolean isValeurAjouteeIsCorrect() {
        return valeurAjouteeIsCorrect;
    }

    public void setValeurAjouteeIsCorrect(boolean valeurAjouteeIsCorrect) {
        this.valeurAjouteeIsCorrect = valeurAjouteeIsCorrect;
        if (valeurAjouteeIsCorrect) {
            this.errorMap.remove(this.valeurAjouteeDonnee);
        } else {
            this.errorMap.put(this.valeurAjouteeDonnee, this.valeurAjouteeObservation);
        }
    }

    public String getExedent() {
        return exedent;
    }

    public void setExedent(String exedent) {
        this.exedent = exedent;
    }

    public String getExedentDonnee() {
        return exedentDonnee;
    }

    public void setExedentDonnee(String exedentDonnee) {
        this.exedentDonnee = exedentDonnee;
    }

    public String getExedentObservation() {
        return exedentObservation;
    }

    public void setExedentObservation(String exedentObservation) {
        this.exedentObservation = exedentObservation;
    }

    public boolean isExedentIsCorrect() {
        return exedentIsCorrect;
    }

    public void setExedentIsCorrect(boolean exedentIsCorrect) {
        this.exedentIsCorrect = exedentIsCorrect;
        if (exedentIsCorrect) {
            this.errorMap.remove(this.exedentDonnee);
        } else {
            this.errorMap.put(this.exedentDonnee, this.exedentObservation);
        }
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getResultatDonnee() {
        return resultatDonnee;
    }

    public void setResultatDonnee(String resultatDonnee) {
        this.resultatDonnee = resultatDonnee;
    }

    public String getResultatObservation() {
        return resultatObservation;
    }

    public void setResultatObservation(String resultatObservation) {
        this.resultatObservation = resultatObservation;
    }

    public boolean isResultatIsCorrect() {
        return resultatIsCorrect;
    }

    public void setResultatIsCorrect(boolean resultatIsCorrect) {
        this.resultatIsCorrect = resultatIsCorrect;
        if (resultatIsCorrect) {
            this.errorMap.remove(this.resultatDonnee);
        } else {
            this.errorMap.put(this.resultatDonnee, this.resultatObservation);
        }
    }

    public String getResultatNet() {
        return resultatNet;
    }

    public void setResultatNet(String resultatNet) {
        this.resultatNet = resultatNet;
    }

    public String getResultatNetDonnee() {
        return resultatNetDonnee;
    }

    public void setResultatNetDonnee(String resultatNetDonnee) {
        this.resultatNetDonnee = resultatNetDonnee;
    }

    public String getResultatNetObservation() {
        return resultatNetObservation;
    }

    public void setResultatNetObservation(String resultatNetObservation) {
        this.resultatNetObservation = resultatNetObservation;
    }

    public boolean isResultatNetIsCorrect() {
        return resultatNetIsCorrect;
    }

    public void setResultatNetIsCorrect(boolean resultatNetIsCorrect) {
        this.resultatNetIsCorrect = resultatNetIsCorrect;
        if (resultatNetIsCorrect) {
            this.errorMap.remove(this.resultatNetDonnee);
        } else {
            this.errorMap.put(this.resultatNetDonnee, this.resultatNetObservation);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public CompteResultatReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Compte de Résultat";
        this.donnee = "Donnée concernée";
        this.observation = "Observations";
        
        this.errorCelluleMap = new HashMap<String, String>();
        this.cellule = "Cellule";
        
        this.chiffreAffaire = "chiffreAffaire";
        this.chiffreAffaireDonnee = "CHIFFRE D'AFFAIRES (A + B + C + D)";
////        this.chiffreAffaireObservation = "chiffreAffaireObservation";
////        this.chiffreAffaireIsCorrect = false;
////        errorMap.put(this.chiffreAffaireDonnee, this.chiffreAffaireObservation);
        
        this.valeurAjoutee = "valeurAjoutee";
        this.valeurAjouteeDonnee = "VALEUR AJOUTEE (XB + RA + RB) + (somme TE à RJ)";
////        this.valeurAjouteeObservation = "valeurAjouteeObservation";
////        this.valeurAjouteeIsCorrect = false;
////        errorMap.put(this.valeurAjouteeDonnee, this.valeurAjouteeObservation);
        
        this.exedent = "exedent";
        this.exedentDonnee = "EXCEDENT BRUT D'EXPLOITATION (XC + RK)";
////        this.exedentObservation = "exedentObservation";
////        this.exedentIsCorrect = false;
////        errorMap.put(this.exedentDonnee, this.exedentObservation);
        
        this.resultat = "resultat";
        this.resultatDonnee = "RESULTAT D'EXPLOITATION (XD + TJ + RL)";
////        this.resultatObservation = "resultatObservation";
////        this.resultatIsCorrect = false;
////        errorMap.put(this.resultatDonnee, this.resultatObservation);
        
        this.resultatNet = "resultatNet";
        this.resultatNetDonnee = "RESULTAT NET (XG + XH + RQ + RS)";
////        this.resultatNetObservation = "resultatNetObservation";
////        this.resultatNetIsCorrect = false;
////        errorMap.put(this.resultatNetDonnee, this.resultatNetObservation);
    }
}

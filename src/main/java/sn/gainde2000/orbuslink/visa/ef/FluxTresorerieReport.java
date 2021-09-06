package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class FluxTresorerieReport {
    String title;
    String donnee;
    String observation;
    
    String tresorerie;
    String tresorerieDonnee;
    String tresorerieObservation;
    boolean tresorerieIsCorrect;
    String tresorerieCellule;
    
    
    String fluxActiviteOperationnelle;
    String fluxActiviteOperationnelleDonnee;
    String fluxActiviteOperationnelleObservation;
    boolean fluxActiviteOperationnelleIsCorrect;
    String fluxActiviteOperationnelleCellule;
    
    String fluxActiviteInvestissement;
    String fluxActiviteInvestissementDonnee;
    String fluxActiviteInvestissementObservation;
    boolean fluxActiviteInvestissementIsCorrect;
    String fluxActiviteInvestissementCellule;
    
    String fluxCapitauxEtranger;
    String fluxCapitauxEtrangerDonnee;
    String fluxCapitauxEtrangerObservation;
    boolean fluxCapitauxEtrangerIsCorrect;
    String fluxCapitauxEtrangerCellule;
    
    String tresorerieNette;
    String tresorerieNetteDonnee;
    String tresorerieNetteObservation;
    boolean tresorerieNetteIsCorrect;
    String tresorerieNetteCellule;

    int nombreDeLigne ;
    String nombreDeLigneDonnee = "Nombre de ligne" ;
    String nombreDeLigneObservation ="Nombre de ligne du tableau différent de celui du modèle" ;
    Boolean nombreDeLigneIsCorrect ;
    String nombreDeLigneCellule;

    public String getTresorerieCellule() {
		return tresorerieCellule;
	}


	public void setTresorerieCellule(String tresorerieCellule) {
		this.tresorerieCellule = tresorerieCellule;
	}


	public String getFluxActiviteOperationnelleCellule() {
		return fluxActiviteOperationnelleCellule;
	}


	public void setFluxActiviteOperationnelleCellule(String fluxActiviteOperationnelleCellule) {
		this.fluxActiviteOperationnelleCellule = fluxActiviteOperationnelleCellule;
	}


	public String getFluxActiviteInvestissementCellule() {
		return fluxActiviteInvestissementCellule;
	}


	public void setFluxActiviteInvestissementCellule(String fluxActiviteInvestissementCellule) {
		this.fluxActiviteInvestissementCellule = fluxActiviteInvestissementCellule;
	}


	public String getFluxCapitauxEtrangerCellule() {
		return fluxCapitauxEtrangerCellule;
	}


	public void setFluxCapitauxEtrangerCellule(String fluxCapitauxEtrangerCellule) {
		this.fluxCapitauxEtrangerCellule = fluxCapitauxEtrangerCellule;
	}


	public String getTresorerieNetteCellule() {
		return tresorerieNetteCellule;
	}


	public void setTresorerieNetteCellule(String tresorerieNetteCellule) {
		this.tresorerieNetteCellule = tresorerieNetteCellule;
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

    public String getTresorerie() {
        return tresorerie;
    }

    public void setTresorerie(String tresorerie) {
        this.tresorerie = tresorerie;
    }

    public String getTresorerieDonnee() {
        return tresorerieDonnee;
    }

    public void setTresorerieDonnee(String tresorerieDonnee) {
        this.tresorerieDonnee = tresorerieDonnee;
    }

    public String getTresorerieObservation() {
        return tresorerieObservation;
    }

    public void setTresorerieObservation(String tresorerieObservation) {
        this.tresorerieObservation = tresorerieObservation;
    }

    public boolean isTresorerieIsCorrect() {
        return tresorerieIsCorrect;
    }

    public void setTresorerieIsCorrect(boolean tresorerieIsCorrect) {
        this.tresorerieIsCorrect = tresorerieIsCorrect;
        if (tresorerieIsCorrect) {
            this.errorMap.remove(this.tresorerieDonnee);
        } else {
            this.errorMap.put(this.tresorerieDonnee, this.tresorerieObservation);
        }
    }

    public String getFluxActiviteOperationnelle() {
        return fluxActiviteOperationnelle;
    }

    public void setFluxActiviteOperationnelle(String fluxActiviteOperationnelle) {
        this.fluxActiviteOperationnelle = fluxActiviteOperationnelle;
    }

    public String getFluxActiviteOperationnelleDonnee() {
        return fluxActiviteOperationnelleDonnee;
    }

    public void setFluxActiviteOperationnelleDonnee(String fluxActiviteOperationnelleDonnee) {
        this.fluxActiviteOperationnelleDonnee = fluxActiviteOperationnelleDonnee;
    }

    public String getFluxActiviteOperationnelleObservation() {
        return fluxActiviteOperationnelleObservation;
    }

    public void setFluxActiviteOperationnelleObservation(String fluxActiviteOperationnelleObservation) {
        this.fluxActiviteOperationnelleObservation = fluxActiviteOperationnelleObservation;
    }

    public boolean isFluxActiviteOperationnelleIsCorrect() {
        return fluxActiviteOperationnelleIsCorrect;
    }

    public void setFluxActiviteOperationnelleIsCorrect(boolean fluxActiviteOperationnelleIsCorrect) {
        this.fluxActiviteOperationnelleIsCorrect = fluxActiviteOperationnelleIsCorrect;
        if (fluxActiviteOperationnelleIsCorrect) {
            this.errorMap.remove(this.fluxActiviteOperationnelleDonnee);
        } else {
            this.errorMap.put(this.fluxActiviteOperationnelleDonnee, this.fluxActiviteOperationnelleObservation);
        }
    }

    public String getFluxActiviteInvestissement() {
        return fluxActiviteInvestissement;
    }

    public void setFluxActiviteInvestissement(String fluxActiviteInvestissement) {
        this.fluxActiviteInvestissement = fluxActiviteInvestissement;
    }

    public String getFluxActiviteInvestissementDonnee() {
        return fluxActiviteInvestissementDonnee;
    }

    public void setFluxActiviteInvestissementDonnee(String fluxActiviteInvestissementDonnee) {
        this.fluxActiviteInvestissementDonnee = fluxActiviteInvestissementDonnee;
    }

    public String getFluxActiviteInvestissementObservation() {
        return fluxActiviteInvestissementObservation;
    }

    public void setFluxActiviteInvestissementObservation(String fluxActiviteInvestissementObservation) {
        this.fluxActiviteInvestissementObservation = fluxActiviteInvestissementObservation;
    }

    public boolean isFluxActiviteInvestissementIsCorrect() {
        return fluxActiviteInvestissementIsCorrect;
    }

    public void setFluxActiviteInvestissementIsCorrect(boolean fluxActiviteInvestissementIsCorrect) {
        this.fluxActiviteInvestissementIsCorrect = fluxActiviteInvestissementIsCorrect;
        if (fluxActiviteInvestissementIsCorrect) {
            this.errorMap.remove(this.fluxActiviteInvestissementDonnee);
        } else {
            this.errorMap.put(this.fluxActiviteInvestissementDonnee, this.fluxActiviteInvestissementObservation);
        }
    }

    public String getFluxCapitauxEtranger() {
        return fluxCapitauxEtranger;
    }

    public void setFluxCapitauxEtranger(String fluxCapitauxEtranger) {
        this.fluxCapitauxEtranger = fluxCapitauxEtranger;
    }

    public String getFluxCapitauxEtrangerDonnee() {
        return fluxCapitauxEtrangerDonnee;
    }

    public void setFluxCapitauxEtrangerDonnee(String fluxCapitauxEtrangerDonnee) {
        this.fluxCapitauxEtrangerDonnee = fluxCapitauxEtrangerDonnee;
    }

    public String getFluxCapitauxEtrangerObservation() {
        return fluxCapitauxEtrangerObservation;
    }

    public void setFluxCapitauxEtrangerObservation(String fluxCapitauxEtrangerObservation) {
        this.fluxCapitauxEtrangerObservation = fluxCapitauxEtrangerObservation;
    }

    public boolean isFluxCapitauxEtrangerIsCorrect() {
        return fluxCapitauxEtrangerIsCorrect;
    }

    public void setFluxCapitauxEtrangerIsCorrect(boolean fluxCapitauxEtrangerIsCorrect) {
        this.fluxCapitauxEtrangerIsCorrect = fluxCapitauxEtrangerIsCorrect;
        if (fluxCapitauxEtrangerIsCorrect) {
            this.errorMap.remove(this.fluxCapitauxEtrangerDonnee);
        } else {
            this.errorMap.put(this.fluxCapitauxEtrangerDonnee, this.fluxCapitauxEtrangerObservation);
        }
    }

    public String getTresorerieNette() {
        return tresorerieNette;
    }

    public void setTresorerieNette(String tresorerieNette) {
        this.tresorerieNette = tresorerieNette;
    }

    public String getTresorerieNetteDonnee() {
        return tresorerieNetteDonnee;
    }

    public void setTresorerieNetteDonnee(String tresorerieNetteDonnee) {
        this.tresorerieNetteDonnee = tresorerieNetteDonnee;
    }

    public String getTresorerieNetteObservation() {
        return tresorerieNetteObservation;
    }

    public void setTresorerieNetteObservation(String tresorerieNetteObservation) {
        this.tresorerieNetteObservation = tresorerieNetteObservation;
    }

    public boolean isTresorerieNetteIsCorrect() {
        return tresorerieNetteIsCorrect;
    }

    public void setTresorerieNetteIsCorrect(boolean tresorerieNetteIsCorrect) {
        this.tresorerieNetteIsCorrect = tresorerieNetteIsCorrect;
        if (tresorerieNetteIsCorrect) {
            this.errorMap.remove(this.tresorerieNetteDonnee);
        } else {
            this.errorMap.put(this.tresorerieNetteDonnee, this.tresorerieNetteObservation);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public FluxTresorerieReport() {

        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Flux de trésorerie";
        this.donnee = "Donnée concernée";
        this.observation = "Observations";
        this.errorCelluleMap = new HashMap<String, String>();
        this.cellule = "Cellule";
        
        this.tresorerie = "tresorerie";
        this.tresorerieDonnee = "Trésorerie nette au 1er janvier (Trésorerie actif N-1 - Trésorerie passif N-1)";
////        this.tresorerieObservation = "tresorerieObservation";
////        this.tresorerieIsCorrect = false;
////        errorMap.put(this.tresorerieDonnee, this.tresorerieObservation);
        
        this.fluxActiviteOperationnelle = "fluxActiviteOperationnelle";
        this.fluxActiviteOperationnelleDonnee = "Flux de trésorerie provenant des activités opérationnelles (somme FA à FE)";
////        this.fluxActiviteOperationnelleObservation = "fluxActiviteOperationnelleObservation";
////        this.fluxActiviteOperationnelleIsCorrect = false;
////        errorMap.put(this.fluxActiviteOperationnelleDonnee, this.fluxActiviteOperationnelleObservation);
        
        this.fluxActiviteInvestissement = "fluxActiviteInvestissement";
        this.fluxActiviteInvestissementDonnee = "Flux  de trésorerie provenant du financement par les capitaux propres (somme FK à FN)";
////        this.fluxActiviteInvestissementObservation = "fluxActiviteInvestissementObservation";
////        this.fluxActiviteInvestissementIsCorrect = false;
////        errorMap.put(this.fluxActiviteInvestissementDonnee, this.fluxActiviteInvestissementObservation);
        
        this.fluxCapitauxEtranger = "fluxCapitauxEtranger";
        this.fluxCapitauxEtrangerDonnee = "Flux de trésorerie provenant des capitaux étrangers (D + E)";
////        this.fluxCapitauxEtrangerObservation = "fluxCapitauxEtrangerObservation";
////        this.fluxCapitauxEtrangerIsCorrect = false;
////        errorMap.put(this.fluxCapitauxEtrangerDonnee, this.fluxCapitauxEtrangerObservation);
        
        this.tresorerieNette = "tresorerieNette";
        this.tresorerieNetteDonnee = "Trésorerie nette au 31 décembre (G + A)";
////        this.tresorerieNetteObservation = "tresorerieNetteObservation";
////        this.tresorerieNetteIsCorrect = false;
////        errorMap.put(this.tresorerieNetteDonnee, this.tresorerieNetteObservation);
    }
}

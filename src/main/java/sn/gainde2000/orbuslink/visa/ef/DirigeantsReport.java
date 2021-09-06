package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class DirigeantsReport {
    
    String title;
    String donnee;
    String observation;
    
    String centreDepot;
    String centreDepotDonnee;
    String centreDepotObservation;
    boolean centreDepotIsCorrect;
    
    String exerciceClos;
    String exerciceClosDonnee;
    String exerciceClosObservation;
    boolean exerciceClosIsCorrect;
    
    String denominationSociale;
    String denominationSocialeDonnee;
    String denominationSocialeObservation;
    boolean denominationSocialeIsCorrect;
    
    String adresse;
    String adresseDonnee;
    String adresseObservation;
    boolean adresseIsCorrect;
    
    String idFiscale;
    String idFiscaleDonnee;
    String idFiscaleObservation;
    boolean idFiscaleIsCorrect;
    
    String nom;
    String nomDonnee;
    String nomObservation;
    boolean nomIsCorrect;
    
    String prenom;
    String prenomDonnee;
    String prenomObservation;
    boolean prenomIsCorrect;
    
    String qualite;
    String qualiteDonnee;
    String qualiteObservation;
    boolean qualiteIsCorrect;
    
    String adresseComplete;
    String adresseCompleteDonnee;
    String adresseCompleteObservation;
    boolean adresseCompleteIsCorrect;
    
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
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDonnee() {
        return nomDonnee;
    }

    public void setNomDonnee(String nomDonnee) {
        this.nomDonnee = nomDonnee;
    }

    public String getNomObservation() {
        return nomObservation;
    }

    public void setNomObservation(String nomObservation) {
        this.nomObservation = nomObservation;
    }

    public boolean isNomIsCorrect() {
        return nomIsCorrect;
    }

    public void setNomIsCorrect(boolean nomIsCorrect) {
        this.nomIsCorrect = nomIsCorrect;
        if (nomIsCorrect) {
            this.errorMap.remove(this.nomDonnee);
        } else {
            this.errorMap.put(this.nomDonnee, this.nomObservation);
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenomDonnee() {
        return prenomDonnee;
    }

    public void setPrenomDonnee(String prenomDonnee) {
        this.prenomDonnee = prenomDonnee;
    }

    public String getPrenomObservation() {
        return prenomObservation;
    }

    public void setPrenomObservation(String prenomObservation) {
        this.prenomObservation = prenomObservation;
    }

    public boolean isPrenomIsCorrect() {
        return prenomIsCorrect;
    }

    public void setPrenomIsCorrect(boolean prenomIsCorrect) {
        this.prenomIsCorrect = prenomIsCorrect;
        if (prenomIsCorrect) {
            this.errorMap.remove(this.prenomDonnee);
        } else {
            this.errorMap.put(this.prenomDonnee, this.prenomObservation);
        }
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getQualiteDonnee() {
        return qualiteDonnee;
    }

    public void setQualiteDonnee(String qualiteDonnee) {
        this.qualiteDonnee = qualiteDonnee;
    }

    public String getQualiteObservation() {
        return qualiteObservation;
    }

    public void setQualiteObservation(String qualiteObservation) {
        this.qualiteObservation = qualiteObservation;
    }

    public boolean isQualiteIsCorrect() {
        return qualiteIsCorrect;
    }

    public void setQualiteIsCorrect(boolean qualiteIsCorrect) {
        this.qualiteIsCorrect = qualiteIsCorrect;
        if (qualiteIsCorrect) {
            this.errorMap.remove(this.qualiteDonnee);
        } else {
            this.errorMap.put(this.qualiteDonnee, this.qualiteObservation);
        }
    }

    public String getAdresseComplete() {
        return adresseComplete;
    }

    public void setAdresseComplete(String adresseComplete) {
        this.adresseComplete = adresseComplete;
    }

    public String getAdresseCompleteDonnee() {
        return adresseCompleteDonnee;
    }

    public void setAdresseCompleteDonnee(String adresseCompleteDonnee) {
        this.adresseCompleteDonnee = adresseCompleteDonnee;
    }

    public String getAdresseCompleteObservation() {
        return adresseCompleteObservation;
    }

    public void setAdresseCompleteObservation(String adresseCompleteObservation) {
        this.adresseCompleteObservation = adresseCompleteObservation;
    }

    public boolean isAdresseCompleteIsCorrect() {
        return adresseCompleteIsCorrect;
    }

    public void setAdresseCompleteIsCorrect(boolean adresseCompleteIsCorrect) {
        this.adresseCompleteIsCorrect = adresseCompleteIsCorrect;
        if (adresseCompleteIsCorrect) {
            this.errorMap.remove(this.adresseCompleteDonnee);
        } else {
            this.errorMap.put(this.adresseCompleteDonnee, this.adresseCompleteObservation);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public DirigeantsReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Dirigeants";
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

        //        
        this.nom = "nom";
        this.nomDonnee = "Nom (s)";
////        this.nomObservation = "nomObservation";
////        this.nomIsCorrect = false;
////        errorMap.put(this.nomDonnee, this.nomObservation);
        
        this.prenom = "prenom";
        this.prenomDonnee = "Prénom (s)";
////        this.prenomObservation = "prenomObservation";
////        this.prenomIsCorrect = false;
////        errorMap.put(this.prenomDonnee, this.prenomObservation);
        
        this.qualite = "qualite";
        this.qualiteDonnee = "Qualité (s)";
////        this.qualiteObservation = "qualiteObservation";
////        this.qualiteIsCorrect = false;
////        errorMap.put(this.qualiteDonnee, this.qualiteObservation);
        
        this.adresseComplete = "adresseComplete";
        this.adresseCompleteDonnee = "ADRESSE COMPLETE  (s) :";
////        this.adresseCompleteObservation = "adresseCompleteObservation";
////        this.adresseCompleteIsCorrect = false;
////        errorMap.put(this.adresseCompleteDonnee, this.adresseCompleteObservation);
    }
}

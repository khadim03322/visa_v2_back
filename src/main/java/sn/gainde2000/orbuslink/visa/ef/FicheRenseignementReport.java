package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class FicheRenseignementReport {
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

    String greffe;
    String greffeDonnee;
    String greffeObservation;
    boolean greffeIsCorrect;
    String greffeCellule;

    String numRegistreCommerce;
    String numRegistreCommerceDonnee;
    String numRegistreCommerceObservation;
    boolean numRegistreCommerceIsCorrect;
    String numRegistreCommerceCellule;

    String numSecuriteSociale;
    String numSecuriteSocialeDonnee;
    String numSecuriteSocialeObservation;
    boolean numSecuriteSocialeIsCorrect;
    String numSecuriteSocialeCellule;
    
    
    String designationEntreprise;
    String designationEntrepriseDonnee;
    String designationEntrepriseObservation;
    boolean designationEntrepriseIsCorrect;
    String designationEntrepriseCellule;
    
    
    String numTelephone;
    String numTelephoneDonnee;
    String numTelephoneObservation;
    boolean numTelephoneIsCorrect;
    String numTelephoneCellule;

    String ville;
    String villeDonnee;
    String villeObservation;
    boolean villeIsCorrect;
    String villeCellule;

    String adresseGeographique;
    String adresseGeographiqueDonnee;
    String adresseGeographiqueObservation;
    boolean adresseGeographiqueIsCorrect;
    String adresseGeographiqueCellule;

    String designationActiviteExercee;
    String designationActiviteExerceeDonnee;
    String designationActiviteExerceeObservation;
    boolean designationActiviteExerceeIsCorrect;
    String designationActiviteExerceeCellule;
    
    String personneAContacter;
    String personneAContacterDonnee;
    String personneAContacterObservation;
    boolean personneAContacterIsCorrect;
    String personneAContacterCellule;
    
    
    String professionnelOuCabinetComptableAuteurEF;
    String professionnelOuCabinetComptableAuteurEFDonnee;
    String professionnelOuCabinetComptableAuteurEFObservation;
    boolean professionnelOuCabinetComptableAuteurEFIsCorrect;
    String professionnelOuCabinetComptableAuteurEFCellule;
    
    
    
    String commissaireAuCompte;
    String commissaireAuCompteDonnee;
    String commissaireAuCompteObservation;
    boolean commissaireAuCompteIsCorrect;
    String commissaireAuCompteCellule;

    String qualiteDuSignataire;
    String qualiteDuSignataireDonnee;
    String qualiteDuSignataireObservation;
    boolean qualiteDuSignataireIsCorrect;
    String qualiteDuSignataireCellule;
    
    
    String dateSignature;
    String dateSignatureDonnee;
    String dateSignatureObservation;
    boolean dateSignatureIsCorrect;
    String dateSignatureCellule;

    String banque;
    String banqueDonnee;
    String banqueObservation;
    boolean banqueIsCorrect;
    String banqueCellule;

    String numero;
    String numeroDonnee;
    String numeroObservation;
    boolean numeroIsCorrect;
    String numeroCellule;
    
    
    public String getDesignationActiviteExerceeCellule() {
		return designationActiviteExerceeCellule;
	}


	public void setDesignationActiviteExerceeCellule(String designationActiviteExerceeCellule) {
		this.designationActiviteExerceeCellule = designationActiviteExerceeCellule;
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

    public String getGreffe() {
        return greffe;
    }

    public void setGreffe(String greffe) {
        this.greffe = greffe;
    }

    public String getGreffeDonnee() {
        return greffeDonnee;
    }

    public void setGreffeDonnee(String greffeDonnee) {
        this.greffeDonnee = greffeDonnee;
    }

    public String getGreffeObservation() {
        return greffeObservation;
    }

    public void setGreffeObservation(String greffeObservation) {
        this.greffeObservation = greffeObservation;
    }

    public boolean isGreffeIsCorrect() {
        return greffeIsCorrect;
    }

    public void setGreffeIsCorrect(boolean greffeIsCorrect) {
        this.greffeIsCorrect = greffeIsCorrect;
        if (greffeIsCorrect) {
            this.errorMap.remove(this.greffeDonnee);
        } else {
            this.errorMap.put(this.greffeDonnee, this.greffeObservation);
        }
    }

    public String getNumRegistreCommerce() {
        return numRegistreCommerce;
    }

    public void setNumRegistreCommerce(String numRegistreCommerce) {
        this.numRegistreCommerce = numRegistreCommerce;
    }

    public String getNumRegistreCommerceDonnee() {
        return numRegistreCommerceDonnee;
    }

    public void setNumRegistreCommerceDonnee(String numRegistreCommerceDonnee) {
        this.numRegistreCommerceDonnee = numRegistreCommerceDonnee;
    }

    public String getNumRegistreCommerceObservation() {
        return numRegistreCommerceObservation;
    }

    public void setNumRegistreCommerceObservation(String numRegistreCommerceObservation) {
        this.numRegistreCommerceObservation = numRegistreCommerceObservation;
    }

    public boolean isNumRegistreCommerceIsCorrect() {
        return numRegistreCommerceIsCorrect;
    }

    public void setNumRegistreCommerceIsCorrect(boolean numRegistreCommerceIsCorrect) {
        this.numRegistreCommerceIsCorrect = numRegistreCommerceIsCorrect;
        if (numRegistreCommerceIsCorrect) {
            this.errorMap.remove(this.numRegistreCommerceDonnee);
        } else {
            this.errorMap.put(this.numRegistreCommerceDonnee, this.numRegistreCommerceObservation);
            this.errorCelluleMap.put(this.numRegistreCommerceDonnee, this.numRegistreCommerceCellule);
        }
    }

    public String getNumSecuriteSociale() {
        return numSecuriteSociale;
    }

    public void setNumSecuriteSociale(String numSecuriteSociale) {
        this.numSecuriteSociale = numSecuriteSociale;
    }

    public String getNumSecuriteSocialeDonnee() {
        return numSecuriteSocialeDonnee;
    }

    public void setNumSecuriteSocialeDonnee(String numSecuriteSocialeDonnee) {
        this.numSecuriteSocialeDonnee = numSecuriteSocialeDonnee;
    }

    public String getNumSecuriteSocialeObservation() {
        return numSecuriteSocialeObservation;
    }

    public void setNumSecuriteSocialeObservation(String numSecuriteSocialeObservation) {
        this.numSecuriteSocialeObservation = numSecuriteSocialeObservation;
    }

    public boolean isNumSecuriteSocialeIsCorrect() {
        return numSecuriteSocialeIsCorrect;
    }

    public void setNumSecuriteSocialeIsCorrect(boolean numSecuriteSocialeIsCorrect) {
        this.numSecuriteSocialeIsCorrect = numSecuriteSocialeIsCorrect;
        if (numSecuriteSocialeIsCorrect) {
            this.errorMap.remove(this.numSecuriteSocialeDonnee);
        } else {
            this.errorMap.put(this.numSecuriteSocialeDonnee, this.numSecuriteSocialeObservation);
            this.errorCelluleMap.put(this.numSecuriteSocialeDonnee, this.numSecuriteSocialeCellule);
        }
    }

    public String getDesignationEntreprise() {
        return designationEntreprise;
    }

    public void setDesignationEntreprise(String designationEntreprise) {
        this.designationEntreprise = designationEntreprise;
    }

    public String getDesignationEntrepriseDonnee() {
        return designationEntrepriseDonnee;
    }

    public void setDesignationEntrepriseDonnee(String designationEntrepriseDonnee) {
        this.designationEntrepriseDonnee = designationEntrepriseDonnee;
    }

    public String getDesignationEntrepriseObservation() {
        return designationEntrepriseObservation;
    }

    public void setDesignationEntrepriseObservation(String designationEntrepriseObservation) {
        this.designationEntrepriseObservation = designationEntrepriseObservation;
    }

    public boolean isDesignationEntrepriseIsCorrect() {
        return designationEntrepriseIsCorrect;
    }

    public void setDesignationEntrepriseIsCorrect(boolean designationEntrepriseIsCorrect) {
        this.designationEntrepriseIsCorrect = designationEntrepriseIsCorrect;
        if (designationEntrepriseIsCorrect) {
            this.errorMap.remove(this.designationEntrepriseDonnee);
        } else {
            this.errorMap.put(this.designationEntrepriseDonnee, this.designationEntrepriseObservation);
            this.errorCelluleMap.put(this.designationEntrepriseDonnee, this.designationEntrepriseCellule);
        }
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getNumTelephoneDonnee() {
        return numTelephoneDonnee;
    }

    public void setNumTelephoneDonnee(String numTelephoneDonnee) {
        this.numTelephoneDonnee = numTelephoneDonnee;
    }

    public String getNumTelephoneObservation() {
        return numTelephoneObservation;
    }

    public void setNumTelephoneObservation(String numTelephoneObservation) {
        this.numTelephoneObservation = numTelephoneObservation;
    }

    public boolean isNumTelephoneIsCorrect() {
        return numTelephoneIsCorrect;
    }

    public void setNumTelephoneIsCorrect(boolean numTelephoneIsCorrect) {
        this.numTelephoneIsCorrect = numTelephoneIsCorrect;
        if (numTelephoneIsCorrect) {
            this.errorMap.remove(this.numTelephoneDonnee);
        } else {
            this.errorMap.put(this.numTelephoneDonnee, this.numTelephoneObservation);
            this.errorCelluleMap.put(this.numTelephoneDonnee, this.numTelephoneCellule);
        }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVilleDonnee() {
        return villeDonnee;
    }

    public void setVilleDonnee(String villeDonnee) {
        this.villeDonnee = villeDonnee;
    }

    public String getVilleObservation() {
        return villeObservation;
    }

    public void setVilleObservation(String villeObservation) {
        this.villeObservation = villeObservation;
    }

    public boolean isVilleIsCorrect() {
        return villeIsCorrect;
    }

    public void setVilleIsCorrect(boolean villeIsCorrect) {
        this.villeIsCorrect = villeIsCorrect;
        if (villeIsCorrect) {
            this.errorMap.remove(this.villeDonnee);
        } else {
            this.errorMap.put(this.villeDonnee, this.villeObservation);
            this.errorCelluleMap.put(this.villeDonnee, this.villeCellule);
        }
    }

    public String getAdresseGeographique() {
        return adresseGeographique;
    }

    public void setAdresseGeographique(String adresseGeographique) {
        this.adresseGeographique = adresseGeographique;
    }

    public String getAdresseGeographiqueDonnee() {
        return adresseGeographiqueDonnee;
    }

    public void setAdresseGeographiqueDonnee(String adresseGeographiqueDonnee) {
        this.adresseGeographiqueDonnee = adresseGeographiqueDonnee;
    }

    public String getAdresseGeographiqueObservation() {
        return adresseGeographiqueObservation;
    }

    public void setAdresseGeographiqueObservation(String adresseGeographiqueObservation) {
        this.adresseGeographiqueObservation = adresseGeographiqueObservation;
    }

    public boolean isAdresseGeographiqueIsCorrect() {
        return adresseGeographiqueIsCorrect;
    }

    public void setAdresseGeographiqueIsCorrect(boolean adresseGeographiqueIsCorrect) {
        this.adresseGeographiqueIsCorrect = adresseGeographiqueIsCorrect;
        if (adresseGeographiqueIsCorrect) {
            this.errorMap.remove(this.adresseGeographiqueDonnee);
        } else {
            this.errorMap.put(this.adresseGeographiqueDonnee, this.adresseGeographiqueObservation);
            this.errorCelluleMap.put(this.adresseGeographiqueDonnee, this.adresseGeographiqueCellule);
        }
    }

    public String getDesignationActiviteExercee() {
        return designationActiviteExercee;
    }

    public void setDesignationActiviteExercee(String designationActiviteExercee) {
        this.designationActiviteExercee = designationActiviteExercee;
    }

    public String getDesignationActiviteExerceeDonnee() {
        return designationActiviteExerceeDonnee;
    }

    public void setDesignationActiviteExerceeDonnee(String designationActiviteExerceeDonnee) {
        this.designationActiviteExerceeDonnee = designationActiviteExerceeDonnee;
    }

    public String getDesignationActiviteExerceeObservation() {
        return designationActiviteExerceeObservation;
    }

    public void setDesignationActiviteExerceeObservation(String designationActiviteExerceeObservation) {
        this.designationActiviteExerceeObservation = designationActiviteExerceeObservation;
    }

    public boolean isDesignationActiviteExerceeIsCorrect() {
        return designationActiviteExerceeIsCorrect;
    }

    public void setDesignationActiviteExerceeIsCorrect(boolean designationActiviteExerceeIsCorrect) {
        this.designationActiviteExerceeIsCorrect = designationActiviteExerceeIsCorrect;
        if (designationActiviteExerceeIsCorrect) {
            this.errorMap.remove(this.designationActiviteExerceeDonnee);
        } else {
            this.errorMap.put(this.designationActiviteExerceeDonnee, this.designationActiviteExerceeObservation);
            this.errorCelluleMap.put(this.designationActiviteExerceeDonnee, this.designationActiviteExerceeCellule);
        }
    }

    public String getPersonneAContacter() {
        return personneAContacter;
    }

    public void setPersonneAContacter(String personneAContacter) {
        this.personneAContacter = personneAContacter;
    }

    public String getPersonneAContacterDonnee() {
        return personneAContacterDonnee;
    }

    public void setPersonneAContacterDonnee(String personneAContacterDonnee) {
        this.personneAContacterDonnee = personneAContacterDonnee;
    }

    public String getPersonneAContacterObservation() {
        return personneAContacterObservation;
    }

    public void setPersonneAContacterObservation(String personneAContacterObservation) {
        this.personneAContacterObservation = personneAContacterObservation;
    }

    public boolean isPersonneAContacterIsCorrect() {
        return personneAContacterIsCorrect;
    }

    public void setPersonneAContacterIsCorrect(boolean personneAContacterIsCorrect) {
        this.personneAContacterIsCorrect = personneAContacterIsCorrect;
        if (personneAContacterIsCorrect) {
            this.errorMap.remove(this.personneAContacterDonnee);
        } else {
            this.errorMap.put(this.personneAContacterDonnee, this.personneAContacterObservation);
            this.errorCelluleMap.put(this.personneAContacterDonnee, this.personneAContacterCellule);
        }
    }

    public String getProfessionnelOuCabinetComptableAuteurEF() {
        return professionnelOuCabinetComptableAuteurEF;
    }

    public void setProfessionnelOuCabinetComptableAuteurEF(String professionnelOuCabinetComptableAuteurEF) {
        this.professionnelOuCabinetComptableAuteurEF = professionnelOuCabinetComptableAuteurEF;
    }

    public String getProfessionnelOuCabinetComptableAuteurEFDonnee() {
        return professionnelOuCabinetComptableAuteurEFDonnee;
    }

    public void setProfessionnelOuCabinetComptableAuteurEFDonnee(String professionnelOuCabinetComptableAuteurEFDonnee) {
        this.professionnelOuCabinetComptableAuteurEFDonnee = professionnelOuCabinetComptableAuteurEFDonnee;
    }

    public String getProfessionnelOuCabinetComptableAuteurEFObservation() {
        return professionnelOuCabinetComptableAuteurEFObservation;
    }

    public void setProfessionnelOuCabinetComptableAuteurEFObservation(String professionnelOuCabinetComptableAuteurEFObservation) {
        this.professionnelOuCabinetComptableAuteurEFObservation = professionnelOuCabinetComptableAuteurEFObservation;
    }

    public boolean isProfessionnelOuCabinetComptableAuteurEFIsCorrect() {
        return professionnelOuCabinetComptableAuteurEFIsCorrect;
    }

    public void setProfessionnelOuCabinetComptableAuteurEFIsCorrect(boolean professionnelOuCabinetComptableAuteurEFIsCorrect) {
        this.professionnelOuCabinetComptableAuteurEFIsCorrect = professionnelOuCabinetComptableAuteurEFIsCorrect;
        if (professionnelOuCabinetComptableAuteurEFIsCorrect) {
            this.errorMap.remove(this.professionnelOuCabinetComptableAuteurEFDonnee);
        } else {
            this.errorMap.put(this.professionnelOuCabinetComptableAuteurEFDonnee, this.professionnelOuCabinetComptableAuteurEFObservation);
            this.errorCelluleMap.put(this.professionnelOuCabinetComptableAuteurEFDonnee, this.professionnelOuCabinetComptableAuteurEFCellule);
        }
    }

    public String getCommissaireAuCompte() {
        return commissaireAuCompte;
    }

    public void setCommissaireAuCompte(String commissaireAuCompte) {
        this.commissaireAuCompte = commissaireAuCompte;
    }

    public String getCommissaireAuCompteDonnee() {
        return commissaireAuCompteDonnee;
    }

    public void setCommissaireAuCompteDonnee(String commissaireAuCompteDonnee) {
        this.commissaireAuCompteDonnee = commissaireAuCompteDonnee;
    }

    public String getCommissaireAuCompteObservation() {
        return commissaireAuCompteObservation;
    }

    public void setCommissaireAuCompteObservation(String commissaireAuCompteObservation) {
        this.commissaireAuCompteObservation = commissaireAuCompteObservation;
    }

    public boolean isCommissaireAuCompteIsCorrect() {
        return commissaireAuCompteIsCorrect;
    }

    public void setCommissaireAuCompteIsCorrect(boolean commissaireAuCompteIsCorrect) {
        this.commissaireAuCompteIsCorrect = commissaireAuCompteIsCorrect;
        if (commissaireAuCompteIsCorrect) {
            this.errorMap.remove(this.commissaireAuCompteDonnee);
        } else {
            this.errorMap.put(this.commissaireAuCompteDonnee, this.commissaireAuCompteObservation);
            this.errorCelluleMap.put(this.commissaireAuCompteDonnee, this.commissaireAuCompteCellule);

        }
    }

    public String getQualiteDuSignataire() {
        return qualiteDuSignataire;
    }

    public void setQualiteDuSignataire(String qualiteDuSignataire) {
        this.qualiteDuSignataire = qualiteDuSignataire;
    }

    public String getQualiteDuSignataireDonnee() {
        return qualiteDuSignataireDonnee;
    }

    public void setQualiteDuSignataireDonnee(String qualiteDuSignataireDonnee) {
        this.qualiteDuSignataireDonnee = qualiteDuSignataireDonnee;
    }

    public String getQualiteDuSignataireObservation() {
        return qualiteDuSignataireObservation;
    }

    public void setQualiteDuSignataireObservation(String qualiteDuSignataireObservation) {
        this.qualiteDuSignataireObservation = qualiteDuSignataireObservation;
    }

    public boolean isQualiteDuSignataireIsCorrect() {
        return qualiteDuSignataireIsCorrect;
    }

    public void setQualiteDuSignataireIsCorrect(boolean qualiteDuSignataireIsCorrect) {
        this.qualiteDuSignataireIsCorrect = qualiteDuSignataireIsCorrect;
        if (qualiteDuSignataireIsCorrect) {
            this.errorMap.remove(this.qualiteDuSignataireDonnee);
        } else {
            this.errorMap.put(this.qualiteDuSignataireDonnee, this.qualiteDuSignataireObservation);
            this.errorCelluleMap.put(this.qualiteDuSignataireDonnee, this.qualiteDuSignataireCellule);
        }
    }

    public String getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(String dateSignature) {
        this.dateSignature = dateSignature;
    }

    public String getDateSignatureDonnee() {
        return dateSignatureDonnee;
    }

    public void setDateSignatureDonnee(String dateSignatureDonnee) {
        this.dateSignatureDonnee = dateSignatureDonnee;
    }

    public String getDateSignatureObservation() {
        return dateSignatureObservation;
    }

    public void setDateSignatureObservation(String dateSignatureObservation) {
        this.dateSignatureObservation = dateSignatureObservation;
    }

    public boolean isDateSignatureIsCorrect() {
        return dateSignatureIsCorrect;
    }

    public void setDateSignatureIsCorrect(boolean dateSignatureIsCorrect) {
        this.dateSignatureIsCorrect = dateSignatureIsCorrect;
        if (dateSignatureIsCorrect) {
            this.errorMap.remove(this.dateSignatureDonnee);
        } else {
            this.errorMap.put(this.dateSignatureDonnee, this.dateSignatureObservation);
            this.errorCelluleMap.put(this.dateSignatureDonnee, this.dateSignatureCellule);
        }
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getBanqueDonnee() {
        return banqueDonnee;
    }

    public void setBanqueDonnee(String banqueDonnee) {
        this.banqueDonnee = banqueDonnee;
    }

    public String getBanqueObservation() {
        return banqueObservation;
    }

    public void setBanqueObservation(String banqueObservation) {
        this.banqueObservation = banqueObservation;
    }

    public boolean isBanqueIsCorrect() {
        return banqueIsCorrect;
    }

    public void setBanqueIsCorrect(boolean banqueIsCorrect) {
        this.banqueIsCorrect = banqueIsCorrect;
        if (banqueIsCorrect) {
            this.errorMap.remove(this.banqueDonnee);
        } else {
            this.errorMap.put(this.banqueDonnee, this.banqueObservation);
            this.errorCelluleMap.put(this.banqueDonnee, this.banqueCellule);
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroDonnee() {
        return numeroDonnee;
    }

    public void setNumeroDonnee(String numeroDonnee) {
        this.numeroDonnee = numeroDonnee;
    }

    public String getNumeroObservation() {
        return numeroObservation;
    }

    public void setNumeroObservation(String numeroObservation) {
        this.numeroObservation = numeroObservation;
    }

    public boolean isNumeroIsCorrect() {
        return numeroIsCorrect;
    }

    public void setNumeroIsCorrect(boolean numeroIsCorrect) {
        this.numeroIsCorrect = numeroIsCorrect;
        if (numeroIsCorrect) {
            this.errorMap.remove(this.numeroDonnee);
        } else {
            this.errorMap.put(this.numeroDonnee, this.numeroObservation);
            this.errorCelluleMap.put(this.numeroDonnee, this.numeroCellule);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public FicheRenseignementReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Fiche de renseignement";
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
        
        this.greffe = "greffe";
        this.greffeDonnee = "Greffe";
////        this.greffeObservation = "greffeObservation";
////        this.greffeIsCorrect = false;
////        errorMap.put(this.greffeDonnee, this.greffeObservation);
        
        this.numRegistreCommerce = "numRegistreCommerce";
        this.numRegistreCommerceDonnee = "N° registre du Commerce";
////        this.numRegistreCommerceObservation = "numRegistreCommerceObservation";
////        this.numRegistreCommerceIsCorrect = false;
////        errorMap.put(this.numRegistreCommerceDonnee, this.numRegistreCommerceObservation);
        
        this.numSecuriteSociale = "numSecuriteSociale";
        this.numSecuriteSocialeDonnee = "N° de sécurité sociale";
////        this.numSecuriteSocialeObservation = "numSecuriteSocialeObservation";
////        this.numSecuriteSocialeIsCorrect = false;
////        errorMap.put(this.numSecuriteSocialeDonnee, this.numSecuriteSocialeObservation);
        
        this.designationEntreprise = "designationEntreprise";
        this.designationEntrepriseDonnee = "Désignation de l'entreprise";
////        this.designationEntrepriseObservation = "designationEntrepriseObservation";
////        this.designationEntrepriseIsCorrect = false;
////        errorMap.put(this.designationEntrepriseDonnee, this.designationEntrepriseObservation);
        
        this.numTelephone = "numTelephone";
        this.numTelephoneDonnee = "N° de téléphone";
////        this.numTelephoneObservation = "numTelephoneObservation";
////        this.numTelephoneIsCorrect = false;
////        errorMap.put(this.numTelephoneDonnee, this.numTelephoneObservation);
        
        this.ville = "ville";
        this.villeDonnee = "Ville";
////        this.villeObservation = "villeObservation";
////        this.villeIsCorrect = false;
////        errorMap.put(this.villeDonnee, this.villeObservation);
        
        this.adresseGeographique = "adresseGeographique";
        this.adresseGeographiqueDonnee = "Adresse géographique complète (Immeuble, rue, quartier, ville, pays)";
////        this.adresseGeographiqueObservation = "adresseGeographiqueObservation";
////        this.adresseGeographiqueIsCorrect = false;
////        errorMap.put(this.adresseGeographiqueDonnee, this.adresseGeographiqueObservation);
        
        this.designationActiviteExercee = "designationActiviteExercee";
        this.designationActiviteExerceeDonnee = "Désignation précise de l'activité principale exercée par l'entreprise";
////        this.designationActiviteExerceeObservation = "designationActiviteExerceeObservation";
////        this.designationActiviteExerceeIsCorrect = false;
////        errorMap.put(this.designationActiviteExerceeDonnee, this.designationActiviteExerceeObservation);
        
        this.personneAContacter = "personneAContacter";
        this.personneAContacterDonnee = "Nom, adresse et qualité de personne à contacter en cas de demande d'informations complémentaires";
////        this.personneAContacterObservation = "personneAContacterObservation";
////        this.personneAContacterIsCorrect = false;
////        errorMap.put(this.personneAContacterDonnee, this.personneAContacterObservation);
        
        this.professionnelOuCabinetComptableAuteurEF = "professionnelOuCabinetComptableAuteurEF";
        this.professionnelOuCabinetComptableAuteurEFDonnee = "Nom du professionnel salarié de l'entreprise ou Nom, adresse et téléphone du cabinet comptable ou du professionnel INSCRIT A L'ORDRE NATIONAL DES EXPERTS COMPTABLES ET DES COMPTABLES AGREES ayant établi les états financiers.";
////        this.professionnelOuCabinetComptableAuteurEFObservation = "professionnelOuCabinetComptableAuteurEFObservation";
////        this.professionnelOuCabinetComptableAuteurEFIsCorrect = false;
////        errorMap.put(this.professionnelOuCabinetComptableAuteurEFDonnee, this.professionnelOuCabinetComptableAuteurEFObservation);
        
        this.commissaireAuCompte = "commissaireAuCompte";
        this.commissaireAuCompteDonnee = "Noms et adresses du ou des commissaires au comptes";
////        this.commissaireAuCompteObservation = "commissaireAuCompteObservation";
////        this.commissaireAuCompteIsCorrect = false;
////        errorMap.put(this.commissaireAuCompteDonnee, this.commissaireAuCompteObservation);
        
        this.qualiteDuSignataire = "qualiteDuSignataire";
        this.qualiteDuSignataireDonnee = "Qualité du signataire des états financiers";
////        this.qualiteDuSignataireObservation = "qualiteDuSignataireObservation";
////        this.qualiteDuSignataireIsCorrect = false;
////        errorMap.put(this.qualiteDuSignataireDonnee, this.qualiteDuSignataireObservation);
        
        this.dateSignature = "dateSignature";
        this.dateSignatureDonnee = "Date de signature";
////        this.dateSignatureObservation = "dateSignatureObservation";
////        this.dateSignatureIsCorrect = false;
////        errorMap.put(this.dateSignatureDonnee, this.dateSignatureObservation);
        
        this.banque = "banque";
        this.banqueDonnee = "Banque (s)";
////        this.banqueObservation = "banqueObservation";
////        this.banqueIsCorrect = false;
////        errorMap.put(this.banqueDonnee, this.banqueObservation);
        
        this.numero = "numero";
        this.numeroDonnee = "Numéro (s) de compte";
////        this.numeroObservation = "numeroObservation";
////        this.numeroIsCorrect = false;
////        errorMap.put(this.numeroDonnee, this.numeroObservation);
    }


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


	public String getGreffeCellule() {
		return greffeCellule;
	}


	public void setGreffeCellule(String greffeCellule) {
		this.greffeCellule = greffeCellule;
	}


	public String getNumRegistreCommerceCellule() {
		return numRegistreCommerceCellule;
	}


	public void setNumRegistreCommerceCellule(String numRegistreCommerceCellule) {
		this.numRegistreCommerceCellule = numRegistreCommerceCellule;
	}


	public String getNumSecuriteSocialeCellule() {
		return numSecuriteSocialeCellule;
	}


	public void setNumSecuriteSocialeCellule(String numSecuriteSocialeCellule) {
		this.numSecuriteSocialeCellule = numSecuriteSocialeCellule;
	}


	public String getDesignationEntrepriseCellule() {
		return designationEntrepriseCellule;
	}


	public void setDesignationEntrepriseCellule(String designationEntrepriseCellule) {
		this.designationEntrepriseCellule = designationEntrepriseCellule;
	}


	public String getNumTelephoneCellule() {
		return numTelephoneCellule;
	}


	public void setNumTelephoneCellule(String numTelephoneCellule) {
		this.numTelephoneCellule = numTelephoneCellule;
	}


	public String getVilleCellule() {
		return villeCellule;
	}


	public void setVilleCellule(String villeCellule) {
		this.villeCellule = villeCellule;
	}


	public String getAdresseGeographiqueCellule() {
		return adresseGeographiqueCellule;
	}


	public void setAdresseGeographiqueCellule(String adresseGeographiqueCellule) {
		this.adresseGeographiqueCellule = adresseGeographiqueCellule;
	}


	


	public String getPersonneAContacterCellule() {
		return personneAContacterCellule;
	}


	public void setPersonneAContacterCellule(String personneAContacterCellule) {
		this.personneAContacterCellule = personneAContacterCellule;
	}


	public String getProfessionnelOuCabinetComptableAuteurEFCellule() {
		return professionnelOuCabinetComptableAuteurEFCellule;
	}


	public void setProfessionnelOuCabinetComptableAuteurEFCellule(String professionnelOuCabinetComptableAuteurEFCellule) {
		this.professionnelOuCabinetComptableAuteurEFCellule = professionnelOuCabinetComptableAuteurEFCellule;
	}


	public String getCommissaireAuCompteCellule() {
		return commissaireAuCompteCellule;
	}


	public void setCommissaireAuCompteCellule(String commissaireAuCompteCellule) {
		this.commissaireAuCompteCellule = commissaireAuCompteCellule;
	}


	public String getQualiteDuSignataireCellule() {
		return qualiteDuSignataireCellule;
	}


	public void setQualiteDuSignataireCellule(String qualiteDuSignataireCellule) {
		this.qualiteDuSignataireCellule = qualiteDuSignataireCellule;
	}


	public String getDateSignatureCellule() {
		return dateSignatureCellule;
	}


	public void setDateSignatureCellule(String dateSignatureCellule) {
		this.dateSignatureCellule = dateSignatureCellule;
	}


	public String getBanqueCellule() {
		return banqueCellule;
	}


	public void setBanqueCellule(String banqueCellule) {
		this.banqueCellule = banqueCellule;
	}


	public String getNumeroCellule() {
		return numeroCellule;
	}


	public void setNumeroCellule(String numeroCellule) {
		this.numeroCellule = numeroCellule;
	}
}

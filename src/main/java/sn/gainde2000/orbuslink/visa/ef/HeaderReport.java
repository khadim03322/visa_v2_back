package sn.gainde2000.orbuslink.visa.ef;

/**
 *
 * @author Bassirou THIAM
 */
public class HeaderReport {
    String designationName;
    String designationValue;
    String adresseName;
    String adresseValue;
    String numIdentificationName;
    String numIdentificationValue;
    String sigleName;
    String sigleValue;
    String exerciceName;
    String exerciceValue;
    String titleResults;

    
    
    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDesignationValue() {
        return designationValue;
    }

    public void setDesignationValue(String designationValue) {
        this.designationValue = designationValue;
    }

    public String getAdresseName() {
        return adresseName;
    }

    public void setAdresseName(String adresseName) {
        this.adresseName = adresseName;
    }

    public String getAdresseValue() {
        return adresseValue;
    }

    public void setAdresseValue(String adresseValue) {
        this.adresseValue = adresseValue;
    }

    public String getNumIdentificationName() {
        return numIdentificationName;
    }

    public void setNumIdentificationName(String numIdentificationName) {
        this.numIdentificationName = numIdentificationName;
    }

    public String getNumIdentificationValue() {
        return numIdentificationValue;
    }

    public void setNumIdentificationValue(String numIdentificationValue) {
        this.numIdentificationValue = numIdentificationValue;
    }

    public String getSigleName() {
        return sigleName;
    }

    public void setSigleName(String sigleName) {
        this.sigleName = sigleName;
    }

    public String getSigleValue() {
        return sigleValue;
    }

    public void setSigleValue(String sigleValue) {
        this.sigleValue = sigleValue;
    }

    public String getExerciceName() {
        return exerciceName;
    }

    public void setExerciceName(String exerciceName) {
        this.exerciceName = exerciceName;
    }

    public String getExerciceValue() {
        return exerciceValue;
    }

    public void setExerciceValue(String exerciceValue) {
        this.exerciceValue = exerciceValue;
    }

    public String getTitleResults() {
        return titleResults;
    }

    public void setTitleResults(String titleResults) {
        this.titleResults = titleResults;
    }

    public HeaderReport() {
        this.designationName = "Désignation de l'entreprise :";
        this.adresseName = "Adresse de l'entreprise :";
        this.numIdentificationName = "N° d'identification";
        this.sigleName = "Sigle usuel :";
        this.exerciceName = "Exercice clos le :";
        this.titleResults = "Résultats du contrôle sur le chargement des Etats Financiers par rubrique ";

        //this.designationValue = "Désignation entreprise";
        //this.adresseValue = "Adresse entreprise";
        this.numIdentificationValue = "id entreprise";
        this.sigleValue = "Sigle";
        //this.exerciceValue = "10/12/2020";
    }
}

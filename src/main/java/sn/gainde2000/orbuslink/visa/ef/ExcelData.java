package sn.gainde2000.orbuslink.visa.ef;

import java.util.regex.Pattern;

/**
 *
 * @author Bassirou THIAM
 */

public class ExcelData {
    String entreprise;
    String ninea;
    String totalBilan;//Bilan paysage : F31
    String capitalPropre;//Bilan paysage : K13
    String resultatNet;//Compte resultat : E43
    String chiffreAffaire;//Compte resultat : E9

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = extractionNinea(ninea);
    }

    public String getTotalBilan() {
        return totalBilan;
    }

    public void setTotalBilan(String totalBilan) {
        this.totalBilan = totalBilan;
    }

    public String getCapitalPropre() {
        return capitalPropre;
    }

    public void setCapitalPropre(String capitalPropre) {
        this.capitalPropre = capitalPropre;
    }

    public String getResultatNet() {
        return resultatNet;
    }

    public void setResultatNet(String resultatNet) {
        this.resultatNet = resultatNet;
    }

    public String getChiffreAffaire() {
        return chiffreAffaire.replace(" ", "");
    }

    public void setChiffreAffaire(String chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }
    public static String extractionNinea(String brute) {
//        if(brute==null)
//            return brute ;
//        int length = brute.length();
//        boolean matche = Pattern.matches("^00.*", brute);
////        boolean matche2 = Pattern.matches(".*[a-zA-Z].*", brute); // find an alphabetic caracterer
//
//        if(!matche)
//            brute = "00"+brute;
//        if(length>=9)
//            brute =brute.substring(0,8);
        return brute ;
    }
}

package sn.gainde2000.orbuslink.visa.ef;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class BalanceReport {
    
    String title;
    String donnee;
    String observation;
    
    String balance;
    String balanceDonnee;
    String balanceObservation;
    boolean balanceIsCorrect;
    
    Map<String,String> errorMap;
    
    
    String cellule;
	
    public String getCellule() {
	return cellule;
}
    
    
public void setCellule(String cellule) {
	this.cellule = cellule;
}



Map<String,String> errorCelluleMap;
 
 
 
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalanceDonnee() {
        return balanceDonnee;
    }

    public void setBalanceDonnee(String balanceDonnee) {
        this.balanceDonnee = balanceDonnee;
    }

    public String getBalanceObservation() {
        return balanceObservation;
    }

    public void setBalanceObservation(String balanceObservation) {
        this.balanceObservation = balanceObservation;
    }

    public boolean isBalanceIsCorrect() {
        return balanceIsCorrect;
    }

    public void setBalanceIsCorrect(boolean balanceIsCorrect) {
        this.balanceIsCorrect = balanceIsCorrect;
        if (balanceIsCorrect) {
            this.errorMap.remove(this.balanceDonnee);
        } else {
            this.errorMap.put(this.balanceDonnee, this.balanceObservation);
        }
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public BalanceReport() {
        this.errorMap = new HashMap<String, String>();
        
        this.title = "Non-conformités sur la Rubrique : Balance";
        this.donnee = "Donnée concernée";
        this.observation = "Observations";
        
        this.balance = "balance";
        this.balanceDonnee = "Balance";
        this.balanceObservation = "balance";
        this.balanceIsCorrect = false;
        errorMap.put(this.balanceDonnee, this.balanceObservation);
        
        this.errorCelluleMap = new HashMap<String, String>();
        this.cellule = "Cellule";
    }
}

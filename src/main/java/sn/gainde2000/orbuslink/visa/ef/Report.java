    package sn.gainde2000.orbuslink.visa.ef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bassirou THIAM
 */
public class Report {
    boolean errorExist;
    boolean errorPageGardeExist;
    
    HeaderReport headerReport;
    ExcelData excelData;
    
    PageGardeReport pageGardeReport;
    FicheRenseignementReport ficheRenseignementReport;
    ActiviteEntrepriseReport activiteEntrepriseReport;
    DirigeantsReport dirigeantsReport;
    BalanceReport balanceReport;
    BilanReport bilanReport;
    CompteResultatReport compteResultatReport;
    FluxTresorerieReport fluxTresorerieReport;
    Note13 note13;
    BilanActifReport bilanActifReport;
    BilanPassifReport bilanPassifReport;
    HorsBilanReport horsBilanReport;
    
    
    
    
	public BilanActifReport getBilanActifReport() {
		return bilanActifReport;
	}

	public void setBilanActifReport(BilanActifReport bilanActifReport) {
		this.bilanActifReport = bilanActifReport;
	}

	public BilanPassifReport getBilanPassifReport() {
		return bilanPassifReport;
	}

	public void setBilanPassifReport(BilanPassifReport bilanPassifReport) {
		this.bilanPassifReport = bilanPassifReport;
	}

	public HorsBilanReport getHorsBilanReport() {
		return horsBilanReport;
	}

	public void setHorsBilanReport(HorsBilanReport horsBilanReport) {
		this.horsBilanReport = horsBilanReport;
	}

	public Note13 getNote13() {
		return note13;
	}

	public void setNote13(Note13 note13) {
		this.note13 = note13;
	}

	public boolean errorFormatExist;
	public List<String> observationFormat = new ArrayList<>();
	
	public List<String> listfeuillesManquantes  = new ArrayList<>();
	
	public List<String> listongletsnomsModifies  = new ArrayList<>();
	
	public  Map<String,String> errorMaplistongletsnomsModifies=  new HashMap<String, String>(); 
	 

    public boolean isErrorExist() {
        return errorExist;
    }

    public void setErrorExist(boolean errorExist) {
        this.errorExist = errorExist;
    }

    public boolean isErrorPageGardeExist() {
        return errorPageGardeExist;
    }

    public void setErrorPageGardeExist(boolean errorPageGardeExist) {
        this.errorPageGardeExist = errorPageGardeExist;
    }

    public HeaderReport getHeaderReport() {
        return headerReport;
    }

    public void setHeaderReport(HeaderReport headerReport) {
        this.headerReport = headerReport;
    }

    public ExcelData getExcelData() {
        return excelData;
    }

    public void setExcelData(ExcelData excelData) {
        this.excelData = excelData;
    }

    public PageGardeReport getPageGardeReport() {
        return pageGardeReport;
    }

    public void setPageGardeReport(PageGardeReport pageGardeReport) {
        this.pageGardeReport = pageGardeReport;
    }

    public FicheRenseignementReport getFicheRenseignementReport() {
        return ficheRenseignementReport;
    }

    public void setFicheRenseignementReport(FicheRenseignementReport ficheRenseignementReport) {
        this.ficheRenseignementReport = ficheRenseignementReport;
    }

    public ActiviteEntrepriseReport getActiviteEntrepriseReport() {
        return activiteEntrepriseReport;
    }

    public void setActiviteEntrepriseReport(ActiviteEntrepriseReport activiteEntrepriseReport) {
        this.activiteEntrepriseReport = activiteEntrepriseReport;
    }

    public DirigeantsReport getDirigeantsReport() {
        return dirigeantsReport;
    }

    public void setDirigeantsReport(DirigeantsReport dirigeantsReport) {
        this.dirigeantsReport = dirigeantsReport;
    }

    public BalanceReport getBalanceReport() {
        return balanceReport;
    }

    public void setBalanceReport(BalanceReport balanceReport) {
        this.balanceReport = balanceReport;
    }

    public BilanReport getBilanReport() {
        return bilanReport;
    }

    public void setBilanReport(BilanReport bilanReport) {
        this.bilanReport = bilanReport;
    }

    public CompteResultatReport getCompteResultatReport() {
        return compteResultatReport;
    }

    public void setCompteResultatReport(CompteResultatReport compteResultatReport) {
        this.compteResultatReport = compteResultatReport;
    }

    public FluxTresorerieReport getFluxTresorerieReport() {
        return fluxTresorerieReport;
    }

    public void setFluxTresorerieReport(FluxTresorerieReport fluxTresorerieReport) {
        this.fluxTresorerieReport = fluxTresorerieReport;
    }

}

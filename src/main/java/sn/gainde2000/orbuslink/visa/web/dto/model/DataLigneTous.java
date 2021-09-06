package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.util.List;

import lombok.Data;

@Data
public class DataLigneTous {

	
	
	private List<String> mois;
    private List<Long> data ;
    private String annee;
    
	public DataLigneTous(List<String> mois, List<Long> data,String annee) {
		super();
		this.mois = mois;
		this.data = data;
		this.annee=annee;
	}
    

	
	
}

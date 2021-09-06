package sn.gainde2000.orbuslink.visa.web.dto.model;

import lombok.Data;
import sn.gainde2000.orbuslink.visa.model.CentreServiceFiscal;
import sn.gainde2000.orbuslink.visa.model.Localite;
import sn.gainde2000.orbuslink.visa.model.Profil;

@Data
public class SearchIntervenantDto {
	 private String prenom;
	    private String nom;
	    private String matricule;
	    private String profil;
	    private String centreServiceFiscal;
		private String localite;
		 private String email;
}

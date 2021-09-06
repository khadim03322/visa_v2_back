package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import sn.gainde2000.orbuslink.visa.model.ActivitePrincipale;
import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;

public interface ActivitePrincipaleService {
	ActivitePrincipale saveActivitePrincipale(ActivitePrincipale activitePrincipale);
	public Page<ActivitePrincipale> getAllActivitePrincipales(int page, int size) ;
	List<ActivitePrincipale> getAllActivitePrincipales();
	boolean isActiviteExists(String libelle);

}

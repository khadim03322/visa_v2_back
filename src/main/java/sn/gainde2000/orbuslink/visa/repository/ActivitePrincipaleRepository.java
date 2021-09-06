package sn.gainde2000.orbuslink.visa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.ActivitePrincipale;
import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;

@Repository
public interface ActivitePrincipaleRepository extends JpaRepository<ActivitePrincipale, Long>{
	ActivitePrincipale findActivitePrincipaleBylibelle(String libelle);

}

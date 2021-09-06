package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;
import sn.gainde2000.orbuslink.visa.model.InfoRejet;

@Repository
public interface InfoRejetRepository extends JpaRepository<InfoRejet, Long>{

	List<InfoRejet> findAllByDepot_EtatOrderByIdDesc(EEtatDepot eEtatDepot);

	List<InfoRejet> findAllByDepot_EtatAndUtilisateur_Structure_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<InfoRejet> findAllByDepot_EtatAndDepot_Contribuable_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<InfoRejet> findAllByDepot_Utilisateur_Structure_Id(Long id);

	
	@Query(value="SELECT  A.depot.utilisateur.structure.nomOuRaisonSocial , COUNT(*) as nombre ,YEAR(A.createDateTime) as annee "
	  		+ " FROM InfoRejet A  "
	  		+ " GROUP BY  A.depot.utilisateur.structure.nomOuRaisonSocial ORDER BY A.depot.utilisateur.structure.nomOuRaisonSocial  ")
	List<Object[]> getNombreREJETGroupeByCabinet();

}

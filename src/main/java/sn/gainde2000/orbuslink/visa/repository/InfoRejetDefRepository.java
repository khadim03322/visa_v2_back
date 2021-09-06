package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;
import sn.gainde2000.orbuslink.visa.model.RejetDef;


public interface InfoRejetDefRepository extends JpaRepository<RejetDef, Long> {

	List<RejetDef> findAllByDepot_EtatOrderByIdDesc(EEtatDepot eEtatDepot);

	List<RejetDef> findAllByDepot_EtatAndUtilisateur_Structure_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<RejetDef> findAllByDepot_EtatAndDepot_Contribuable_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<RejetDef> findAllRejetDefByDepot_EtatOrderByIdDesc(EEtatDepot eEtatDepot);

	List<RejetDef> findAllRejetDefByDepot_EtatAndUtilisateur_Structure_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<RejetDef> findAllRejetDefByDepot_EtatAndDepot_Contribuable_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	@Query(value="SELECT  A.depot.utilisateur.structure.nomOuRaisonSocial , COUNT(*) as nombre ,YEAR(A.createDateTime) as annee "
	  		+ " FROM RejetDef A  "
	  		+ " GROUP BY  A.depot.utilisateur.structure.nomOuRaisonSocial,YEAR(A.createDateTime) ORDER BY A.depot.utilisateur.structure.nomOuRaisonSocial  ")
	List<Object[]> getNombreREJETGroupeByCabinet();

	

	

}

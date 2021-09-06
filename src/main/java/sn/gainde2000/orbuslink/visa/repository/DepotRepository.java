package sn.gainde2000.orbuslink.visa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;

import java.util.List;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Long>{
	
	Depot findByAnneeExcerciceAndContribuable_IdAndEtat(String annee, Long id, Depot.EEtatDepot etatDepot);
	Page<Depot> findAllByContribuable_IdAndEtatNotAndEtatNotOrderByIdDesc(Long Id,Depot.EEtatDepot etat1, Depot.EEtatDepot etat2,Pageable pageable);
	Page<Depot> findAllByEtatNotAndEtatNotAndStructure_IdOrderByIdDesc(Depot.EEtatDepot etat,Depot.EEtatDepot etat2,Long Id,Pageable pageable);
	Page<Depot> findAllByEtatAndStructure_IdOrderByIdDesc(Depot.EEtatDepot etat,Long Id,Pageable pageable);
	List<Depot> findAllByEtatAndStructure_IdOrderByIdDesc(Depot.EEtatDepot etat,Long Id);
	Depot findTopByOrderByIdDesc();
	List<Depot> findAllByStructure_Id(Long id);
	List<Depot> findAllByContribuable_IdAndEtatNotAndEtatNotOrderByIdDesc(Long Id,Depot.EEtatDepot etat1,Depot.EEtatDepot etat2);
	List<Depot> findAllByEtat(EEtatDepot eEtatDepot);
	List<Depot> findAllByEtatOrderByIdDesc(EEtatDepot eEtatDepot);
	List<Depot> findAllByEtatAndContribuable_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);
	Page<Depot> findAllByEtatNotAndEtatNotAndEtatNotOrderByIdDesc(Depot.EEtatDepot etat1, Depot.EEtatDepot etat2,Depot.EEtatDepot etat3,Pageable pageable);
	List<Depot> findAllByEtatNotAndEtatNotAndEtatNotOrderByIdDesc(Depot.EEtatDepot etat1, Depot.EEtatDepot etat2,Depot.EEtatDepot etat3);
	List<Depot> findAllByEtatAndUtilisateurReceive_Structure_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);
	List<Depot> findAllByEtatAndUtilisateurTraitant_Structure_Id(EEtatDepot eEtatDepot, Long id);
	List<Depot> findAllByEtatAndStructure_Id(EEtatDepot eEtatDepot, Long id);
	List<Depot> findAllDepotByEtatOrderByIdDesc(EEtatDepot eEtatDepot);
	List<Depot> findAllDepotByEtatAndStructure_Id(EEtatDepot eEtatDepot, Long id);
	List<Depot> findAllDepotByEtatAndContribuable_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);
	
	
	
	
}

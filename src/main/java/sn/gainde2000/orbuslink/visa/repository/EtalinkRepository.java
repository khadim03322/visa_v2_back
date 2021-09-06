package sn.gainde2000.orbuslink.visa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.gainde2000.orbuslink.visa.model.Etalink;
import sn.gainde2000.orbuslink.visa.model.Etalink.EEtatDemande;

@Repository
public interface EtalinkRepository extends JpaRepository<Etalink,Long> {
	Page<Etalink> findAllByContribuable_IdAndEtatNotOrderByIdDesc(Long id,EEtatDemande etat, Pageable pageable);
	Page<Etalink> findAllByStructure_IdAndEtatNotOrderByIdDesc(Long id,EEtatDemande etat, Pageable pageable);
	Page<Etalink> findAllByEtatNotOrderByIdDesc(EEtatDemande etat,Pageable pageable);
}

package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;

@Repository
public interface ContribuableRepository extends JpaRepository<Contribuable, Long>{
	
	Contribuable findContribuableById(Long id);
	Contribuable findContribuableByNinea(String ninea);
	Contribuable findContribuableByNineaAndIdNot(String ninea, Long id);
	Page<Contribuable> findAllByOrderByIdAsc(Pageable requestedPage);
	Page<Contribuable> findAllByOrderByIdDesc(Pageable requestedPage);
	List<Contribuable> findContribuableByNineaOrderByIdDesc(String ninea);
	Page<Contribuable> findAllContribuableBycabinet_IdOrderByIdDesc(Long id, Pageable requestedPage);
	List<Contribuable> findAllByOrderByIdDesc();
	List<Contribuable> findAllContribuableByAbonnement(boolean b);
	List<Contribuable> findAllContribuableBycabinet_IdOrderByIdDesc(Long id);

}

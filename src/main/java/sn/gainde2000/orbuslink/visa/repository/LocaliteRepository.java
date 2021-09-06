package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Localite;

@Repository
public interface LocaliteRepository extends JpaRepository<Localite, Long>{
	List<Localite> findAllByOrderByLibelleAsc();
	
	
	

}

package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long>{
	//Optional<Profil> findById(Long id);
	List<Profil> findAllByCodeIn(Iterable<String> listProfilStructure);

}

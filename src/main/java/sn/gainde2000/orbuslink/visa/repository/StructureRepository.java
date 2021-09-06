package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Structure;
@Repository
public interface StructureRepository extends JpaRepository<Structure, Long>{
	Page<Structure> findAllByOrderByIdDesc(Pageable pageable);
	Structure findStructureByNinea(String ninea);

	Structure findStructureByRccm(String rccm);
	Structure findStructureById(Long id);
	Structure findStructureByNineaAndIdNot(String ninea, Long id);
	Structure findStructureByRccmAndIdNot(String rccm, Long id);
	List<Structure> findAllByOrderByIdDesc();
	List<Structure> findAllStructureByAbonnement(boolean b);

}

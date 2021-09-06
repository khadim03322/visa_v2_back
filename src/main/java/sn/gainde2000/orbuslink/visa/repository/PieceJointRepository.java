package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.NatureFichier;
import sn.gainde2000.orbuslink.visa.model.PieceJoint;

@Repository
public interface PieceJointRepository extends JpaRepository<PieceJoint, Long>{
	PieceJoint findByDepot_IdAndNatureFichier(Long id, NatureFichier natureFichier) ;
	PieceJoint findByEtalink_IdAndNatureFichier(Long id, NatureFichier natureFichier) ;
    List<PieceJoint> findAllByDepot_Id(Long id);
    PieceJoint findByDepot_IdAndNatureFichier_Id(Long idDepot,Long idNature);
}

package sn.gainde2000.orbuslink.visa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.SystemeComptable;

@Repository
public interface SystemeComptableRepository extends JpaRepository<SystemeComptable, Long>{

}

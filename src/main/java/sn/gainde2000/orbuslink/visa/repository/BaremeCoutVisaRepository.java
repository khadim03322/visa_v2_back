package sn.gainde2000.orbuslink.visa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;
import sn.gainde2000.orbuslink.visa.model.Structure;

@Repository
public interface BaremeCoutVisaRepository extends JpaRepository<BaremeCoutVisa, Long>{
	
	@Query("SELECT b from BaremeCoutVisa  b where :val <= b.barMax AND :val >= b.barMin")
    BaremeCoutVisa getCoutVisa(@Param(value = "val") Long ca);
	
}

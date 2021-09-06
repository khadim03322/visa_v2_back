package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.gainde2000.orbuslink.visa.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	 List<Menu> findMenuByProfilOrderByPriorite(Long id);
}

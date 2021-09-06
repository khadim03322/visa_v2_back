package sn.gainde2000.orbuslink.visa.service;

import java.util.List;
import java.util.Optional;

import sn.gainde2000.orbuslink.visa.model.Localite;


public interface LocaliteService {

	List<Localite> getAllLocalites();

	Optional<Localite> getLocaliteById(Long id);


	

}

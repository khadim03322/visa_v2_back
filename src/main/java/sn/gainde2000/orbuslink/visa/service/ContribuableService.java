package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchInscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchIntervenantDto;


public interface ContribuableService {
	Contribuable getContribuableByid(Long id);
	ContribuableDto getContribuableDtoByid(Long id);
	Page<Contribuable> getAllContribuables(int page,int size);
	List<Contribuable> findAll();
	Contribuable saveContribuable(Contribuable contribuable);
	boolean isNineaExists(String ninea);
	List<Contribuable> findAllContribuableByNiniaContent(String ninea);
	boolean isNineaExistsDiffId(String ninea, Long id);
	Page<Contribuable> getAllContribuablesByClient(Long id,int page, int size);
	List<Contribuable> getAllContribuablesByClient(Long id);
	List<Contribuable> searchContribuablesInscription(SearchInscriptionDto searchInscriptionDto);
	List<Utilisateur> searchIntervenantContribuable(SearchIntervenantDto searchIntervenantDto);
	Page<Utilisateur> findAllUtilisateursByContribuable(int page, int size);
	List<Contribuable> getNombreContribuablesAbonne();
}

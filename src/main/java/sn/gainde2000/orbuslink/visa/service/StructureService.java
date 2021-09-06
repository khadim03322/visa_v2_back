package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import org.springframework.data.domain.Page;

import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchInscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchIntervenantDto;

public interface StructureService {
	
	Page<Structure> getAllStructures(int page, int size);
	
	boolean isNineaExists(String ninea);
	Structure getStructureById(Long id);

	boolean isRccmExists(String rccm);

	boolean saveStructure(Structure structureToUpdate);
	
	boolean isNineaExistsAndIdNot(String ninea,Long id);
	boolean isRccmExistsAndIdNot(String rccm,Long id);

	List<Structure> searchStructures(SearchInscriptionDto searchInscriptionDto);

	List<Utilisateur> searchIntervenantStructure(SearchIntervenantDto searchIntervenantDto);

	List<Structure> getNombreStructuresAbonne();

}

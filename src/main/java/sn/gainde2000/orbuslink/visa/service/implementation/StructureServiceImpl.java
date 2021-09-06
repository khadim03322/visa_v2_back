package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.StructureRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.StructureService;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchInscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchIntervenantDto;

@Service
public class StructureServiceImpl implements StructureService {
	private StructureRepository structureRepository;
	private UtilisateurRepository  utilisateurRepository;
	
	@Autowired
	public void setRepository(
			StructureRepository structureRepository,
			UtilisateurRepository  utilisateurRepository
			)
	{
		this.structureRepository = structureRepository;
		this.utilisateurRepository = utilisateurRepository;
	}
	@Override
	public Page<Structure> getAllStructures(int page, int size){
		Pageable requestedPage = PageRequest.of(page, size);
		return structureRepository.findAllByOrderByIdDesc(requestedPage);
	}
	@Override
	public boolean isNineaExists(String ninea) {
		Structure structure = structureRepository.findStructureByNinea(ninea);
		if (structure!=null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isRccmExists(String rccm) {
		Structure structure = structureRepository.findStructureByRccm(rccm);
		if (structure!=null) {
			return true;
		}
		return false;
	}
	@Override
	public Structure getStructureById(Long id) {
		return  structureRepository.findById(id).get();
	}
	@Override
	public boolean saveStructure(Structure structureToUpdate) {
		Structure str= structureRepository.saveAndFlush(structureToUpdate);
		System.out.println(str+"STATUT");
		if (str!=null) {
			return true;
		}else
			return false;
		
	}
	
	@Override
	public boolean isNineaExistsAndIdNot(String ninea,Long id) {
		
		Structure structure = structureRepository.findStructureByNineaAndIdNot(ninea,id);
		
		if (structure!=null) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean isRccmExistsAndIdNot(String rccm,Long id) {
		
		System.out.println("rccm "+rccm+"id"+id );
		
		Structure structure = structureRepository.findStructureByRccmAndIdNot(rccm,id);
		if (structure!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Structure> searchStructures(SearchInscriptionDto searchInscriptionDto) {
		// TODO Auto-generated method stub

		List<Structure> list =  structureRepository.findAllByOrderByIdDesc();

		if(searchInscriptionDto.getNinea() != null && !searchInscriptionDto.getNinea().equals("")){
			list = list.stream().filter(s -> s.getNinea().equals(searchInscriptionDto.getNinea())).collect(Collectors.toList());
		}

		if(searchInscriptionDto.getNomOuRaisonSocial() != null && !searchInscriptionDto.getNomOuRaisonSocial().equals("")){
			list = list.stream().filter(s -> s.getNomOuRaisonSocial().contains(searchInscriptionDto.getNomOuRaisonSocial())).collect(Collectors.toList());
		}

		if(searchInscriptionDto.getCategorie() != null && !searchInscriptionDto.getCategorie().equals("")){
			list = list.stream().filter(s ->  s.getCategorie()!= null && s.getCategorie().getId().toString().equals(searchInscriptionDto.getCategorie())).collect(Collectors.toList());
		}

		
		return list;
	}
	@Override
	public List<Utilisateur> searchIntervenantStructure(SearchIntervenantDto searchIntervenantDto) {
		// TODO Auto-generated method stub
		
		List<Utilisateur> list =  utilisateurRepository.findAllUtilisateurByStructure_IdNotNullOrderByIdDesc();
		
		
		if(searchIntervenantDto.getNom() != null && !searchIntervenantDto.getNom().equals("")){
			list = list.stream().filter(s -> s.getNom().contains(searchIntervenantDto.getNom())).collect(Collectors.toList());
		}
		
		
		if(searchIntervenantDto.getPrenom() != null && !searchIntervenantDto.getPrenom().equals("")){
			list = list.stream().filter(s -> s.getPrenom().contains(searchIntervenantDto.getPrenom())).collect(Collectors.toList());
		}
		

		if(searchIntervenantDto.getMatricule() != null && !searchIntervenantDto.getMatricule().equals("")){
			list = list.stream().filter(s -> s.getMatricule()!= null && s.getMatricule().equals(searchIntervenantDto.getMatricule())).collect(Collectors.toList());
		}
		
		
		if(searchIntervenantDto.getProfil() != null && !searchIntervenantDto.getProfil().equals("")){
			list = list.stream().filter(s ->  s.getProfil()!= null && s.getProfil().getId().toString().equals(searchIntervenantDto.getProfil())).collect(Collectors.toList());
		}
		
		
		
		return list;
	}
	
	@Override
	public List<Structure> getNombreStructuresAbonne() {
		
		List<Structure> list =  structureRepository.findAllStructureByAbonnement(true);
		
		return list;
	}

	

}

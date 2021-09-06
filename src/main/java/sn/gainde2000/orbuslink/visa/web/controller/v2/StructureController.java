package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.service.AssocieService;
import sn.gainde2000.orbuslink.visa.service.CategorieService;
import sn.gainde2000.orbuslink.visa.service.ContribuableService;
import sn.gainde2000.orbuslink.visa.service.ProfilService;
import sn.gainde2000.orbuslink.visa.service.QualiteSignatureService;
import sn.gainde2000.orbuslink.visa.service.StructureService;
import sn.gainde2000.orbuslink.visa.service.UtilisateurService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.ContribuableMapper;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.StructureMapper;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.UtilisateurMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.DetailsContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.DetailsStructureDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.InscriptionCabinetDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.InscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchInscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchIntervenantDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.StructureDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/structures")
public class StructureController {
	
	private final UtilisateurService utilisateurService;
	private final StructureService structureService;
	private final QualiteSignatureService qualiteSignatureService; 
	private final CategorieService categorieService;
	private final ProfilService profilService;
	public final AssocieService associeService;
	
	@PostMapping("/save")
	public Response<?> saveCabinet(@RequestBody InscriptionCabinetDto inscriptionCabinetDto) {
		StructureDto structureDto = inscriptionCabinetDto.getStructureDto();
		
		UtilisateurDto utilisateurDto = inscriptionCabinetDto.getUtilisateurDto();
		
		Utilisateur u = new UtilisateurMapper().toUser(utilisateurDto);
		u.setStatut(true);
		Structure s = new StructureMapper().structuresDtoToStructures(structureDto);
		u.setStructure(s);
		if (structureService.isNineaExists(s.getNinea())) {
			return Response.duplicateNinea().setErrors(new String("Ce ninea existe déjà."));
		}
		if (structureService.isRccmExists(s.getRccm())) {
			return Response.duplicateRccm().setErrors(new String("Ce rccm existe déjà."));
		}
		if (utilisateurService.isUserEmailExist(u.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		if (utilisateurService.isUserMatriculeExist(u.getMatricule())) {
			return Response.duplicateMatricule().setErrors(new String("Ce matricule existe déjà."));
		}
		
		
		if (utilisateurService.saveUser(u))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(u)).setMessage(new String("Inscription cabinet réussi."));
		else
			return Response.badRequest().setErrors(new String("Echec inscription cabinet."));
		//return Response.ok().setPayload(inscriptionCabinetDto);
	}
	@GetMapping("/list")
	public Response<?> getAllStructures( @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Structure> pages = structureService.getAllStructures(page, size);
		int newSize = pages.getSize(); 
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
				//new StructureMapper()
		//.structuresTostructuresDTOs(pages.getContent())).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	@GetMapping("/listIntervenantsStructure/{idStructure}")
	public Response<?> getAllIntervenantsContribuables(@PathVariable("idStructure") Long idStructure, @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Utilisateur> pagesUsers = utilisateurService.findAllContribuablesByStructureId(idStructure,page, size);
		int newSize = pagesUsers.getSize();
		Long totalElements = pagesUsers.getTotalElements();
		int totalPages = pagesUsers.getTotalPages();
		int number = pagesUsers.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(new UtilisateurMapper()
		.usersToUserDTOs(pagesUsers.getContent())).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	@GetMapping("/listIntervenantsCabinet")
	public Response<?> listIntervenantsCabinet(@RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Utilisateur> pagesUsers = utilisateurService.findAllIntervenantsCabinet(page, size);
		int newSize = pagesUsers.getSize();
		Long totalElements = pagesUsers.getTotalElements();
		int totalPages = pagesUsers.getTotalPages();
		int number = pagesUsers.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(pagesUsers.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
				//new UtilisateurMapper()
		//.usersToUserDTOs(pagesUsers.getContent())).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	@GetMapping("/detailsStructure/{idStructure}")
	public Response<?> getDetailsContribuables(@PathVariable("idStructure") Long idStructure, @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		DetailsStructureDto detailsStructureDto = new DetailsStructureDto();
		Structure structure = structureService.getStructureById(idStructure);
		Page<Utilisateur> pagesUsers = utilisateurService.findAllContribuablesByStructureId(idStructure,page, size);
		int newSize = pagesUsers.getSize();
		Long totalElements = pagesUsers.getTotalElements();
		int totalPages = pagesUsers.getTotalPages();
		int number = pagesUsers.getNumber();
		detailsStructureDto.setUtilisateurDtos(new UtilisateurMapper()
				.usersToUserDTOs(pagesUsers.getContent()));
		detailsStructureDto.setStructureDto(new StructureMapper().structureToStructuretDto(structure)) ;
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(detailsStructureDto).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	@GetMapping(value = "/getAllQualiteSignature")
	public Response<?> getAllQualiteSignature() {
		
		return Response.ok().setPayload(qualiteSignatureService.getAllQualiteSignature());
	}
	@GetMapping(value = "/getAllCategorie")
	public Response<?> getAllCategorie() {
		
		return Response.ok().setPayload(categorieService.getAllCategorie());
	}
	@GetMapping(value = "/getAllProfilStructure")
	public Response<?> getAllProfilStructure() {
		
		return Response.ok().setPayload(profilService.getAllProfilStructure());
	}
	
	
	@GetMapping(value = "/getAllAssocies")
	public Response<?> getAllAssocies() {
		
		return Response.ok().setPayload(associeService.getAllAssocies());
	}
	
	@GetMapping(value = "/findAllIntervenantsCabinetByCategorie/{id}")
	public Response<?> findAllIntervenantsCabinetByCategorie(@PathVariable("id") Long id) {
		
		return Response.ok().setPayload(utilisateurService.findAllIntervenantsCabinetByCategorie(id));
	}
	@GetMapping("/getStructureById/{idStructure}")
	public Response<?> getStructureById(@PathVariable("idStructure") Long idStructure) {
		Structure structure = structureService.getStructureById(idStructure);
		
		return Response.ok().setPayload(structure);
	}
	@PostMapping("/updateStructure/{id}")
	public Response<?> updateStructure(@RequestBody StructureDto structure, @PathVariable("id") Long id) {
		
		Structure structureToUpdate =  structureService.getStructureById(id); 
		structureToUpdate.setAdresse(structure.getAdresse());
		structureToUpdate.setCategorie(structure.getCategorie()); 
		structureToUpdate.setNinea(structure.getNinea());
		structureToUpdate.setNomOuRaisonSocial(structure.getNomOuRaisonSocial());
		structureToUpdate.setRccm(structure.getRccm());
		structureToUpdate.setQualiteSignature(structure.getQualiteSignature());
		structureToUpdate.setAssocie(structure.getAssocie());
		
		if (structureService.isNineaExistsAndIdNot(structureToUpdate.getNinea(),id)) {
			return Response.duplicateNinea().setErrors(new String("Ce ninea existe déjà."));
		}
		if (structureService.isRccmExistsAndIdNot(structureToUpdate.getRccm(),id)) {
			return Response.duplicateRccm().setErrors(new String("Ce rccm existe déjà."));
		}
		if (structureService.saveStructure(structureToUpdate))
			return Response.ok().setMessage(new String("Modification effectué avec succes"));
		else
			return Response.badRequest().setErrors(new String("Echec de la modification"));
	}
	
	@PostMapping("/saveIntervenantCabinet/{idStructure}")
	public Response<?> saveCabinet(@RequestBody UtilisateurDto utilisateurDto, @PathVariable("idStructure") Long idStructure) {
		Structure structure =  structureService.getStructureById(idStructure);
		Utilisateur u = new UtilisateurMapper().toUser(utilisateurDto);
		u.setStructure(structure);
		
		if (utilisateurService.isUserEmailExist(u.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		
		if (utilisateurService.isUserMatriculeExist(u.getMatricule())) {
			return Response.duplicateMatricule().setErrors(new String("Ce matricule existe déjà."));
		}
		
		if (utilisateurService.saveUser(u))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(u)).setMessage(new String("Ajout interventant cabinet réussi."));
		else
			return Response.badRequest().setErrors(new String("Echec ajout interventant cabinet."));
	}
	@PostMapping("/updateIntervenantCabinet/{idStructure}")
	public Response<?> updateCabinet(@RequestBody UtilisateurDto utilisateurDto, @PathVariable("idStructure") Long idStructure) {
		Structure structure =  structureService.getStructureById(idStructure);
		//Utilisateur user = new UtilisateurMapper().toUser(utilisateurService.getUtilisateurbyEmail(utilisateurDto.getEmail()));
		System.out.print("----------------->debut update");
		Utilisateur user = utilisateurService.findUtilisateurByEmail(utilisateurDto.getEmail());
		Utilisateur newUser = new UtilisateurMapper().toUser(utilisateurDto);
		//user.setStructure(structure);
		user.setNom(newUser.getNom());
		user.setPrenom(newUser.getPrenom());
		user.setTelephone(newUser.getTelephone());
		user.setMatricule(newUser.getMatricule());
		user.setDelagation(newUser.getDelagation());
		user.setSignatureKeyId(newUser.getSignatureKeyId());
		user.setDelagationProf(newUser.getDelagationProf());
		user.setSignatureKeyIdProf(newUser.getSignatureKeyIdProf());
		user.setProfil(newUser.getProfil());
		System.out.print("----------------->Fin update");
		
		if (utilisateurService.isUserMatriculeExistById(newUser.getMatricule(),user.getId())) {
			return Response.duplicateMatricule().setErrors(new String("Ce matricule existe déjà."));
		}
		
		if (utilisateurService.updateUser(user))
		//if (utilisateurService.saveUser(user))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(user)).setMessage(new String("Modification interventant cabinet réussi."));
		else
			return Response.badRequest().setErrors(new String("Echec modification interventant cabinet."));
	}
	
	
	@PostMapping("search/structure")
	public Response<?> searchStrucutres(@RequestBody SearchInscriptionDto searchInscriptionDto) throws IOException {
		
		List<Structure> list = structureService.searchStructures(searchInscriptionDto);
		
		return Response.ok().setPayload(list);
	}
	
	
	
	@PostMapping("/updateAbonnementStructure/{id}")
	public Response<?> updateAbonnementStructure(@PathVariable("id") Long id) {
		
		Structure structureToUpdate =  structureService.getStructureById(id); 
		
		structureToUpdate.setAbonnement(!structureToUpdate.isAbonnement());
		
		
		if (structureService.saveStructure(structureToUpdate))
			return Response.ok().setMessage(new String("Opération effectué avec succes"));
		else
			return Response.badRequest().setErrors(new String("Echec de l' opération"));
	}
	
	@PostMapping("search/intervenantStructure")
	public Response<?> searchIntervenantStructure(@RequestBody SearchIntervenantDto searchIntervenantDto) throws IOException {
		
		List<Utilisateur> list = structureService.searchIntervenantStructure(searchIntervenantDto);
		
		return Response.ok().setPayload(list);
	}
	
	@GetMapping("/getNombreStructuresAbonne")
	public Response<?> getNombreStructuresAbonne() {
		List<Structure> liste = structureService.getNombreStructuresAbonne();
		
		
		return Response.ok().setPayload(liste.size());
	}
	
}

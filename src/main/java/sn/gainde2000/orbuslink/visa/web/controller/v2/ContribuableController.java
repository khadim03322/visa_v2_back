package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.RegimeImposition;
import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.service.ActivitePrincipaleService;
import sn.gainde2000.orbuslink.visa.service.AssocieService;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.CentreServiceFiscalService;
import sn.gainde2000.orbuslink.visa.service.ContribuableService;
import sn.gainde2000.orbuslink.visa.service.FonctionService;
import sn.gainde2000.orbuslink.visa.service.FormeJuridiqueService;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.LocaliteService;
import sn.gainde2000.orbuslink.visa.service.ProfilService;
import sn.gainde2000.orbuslink.visa.service.RegimeImpositionService;
import sn.gainde2000.orbuslink.visa.service.StructureService;
import sn.gainde2000.orbuslink.visa.service.SystemeComptableService;
import sn.gainde2000.orbuslink.visa.service.TypeEntiteService;
import sn.gainde2000.orbuslink.visa.service.TypeStructureService;
import sn.gainde2000.orbuslink.visa.service.UtilisateurService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.ContribuableMapper;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.UtilisateurMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.DetailsContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.InscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchInscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchIntervenantDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/contribuables")
public class ContribuableController {
	private final ContribuableService contribuableService;
	private final UtilisateurService utilisateurService;
	private final RegimeImpositionService regimeImpositionService;
	public final FonctionService fonctionService;
	public final FormeJuridiqueService formeJuridiqueService;
	public final SystemeComptableService systemeComptableService;
	public final TypeEntiteService typeEntiteService;
	public final TypeStructureService typeStructureService;
	public final LocaliteService localiteService;
	public final CentreServiceFiscalService centreServiceFiscalService;
	public final ActivitePrincipaleService activitePrincipaleService;
	public final AssocieService associeService;
	public final StructureService structureService;
	private final ProfilService profilService;

	
	@GetMapping("/list")
	public Response<?> getAllContribuables( @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Contribuable> pages = contribuableService.getAllContribuables(page, size);
		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
				
		//		new ContribuableMapper()
		//.contribuablesTocontribuablesDTOs(pages.getContent())).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	@PostMapping("/save")
	public Response<?> saveContribuable(@RequestBody InscriptionDto inscriptionDto) {
		//Contribuable cont = contribuableService.saveContribuable(new ContribuableMapper().contDtoToCont(contribuableDto));
		ContribuableDto contribuableDto = inscriptionDto.getContribuableDto();
		
		UtilisateurDto utilisateurDto = inscriptionDto.getUtilisateurDto();
		
		Utilisateur u = new UtilisateurMapper().toUser(utilisateurDto);
		Contribuable c = new ContribuableMapper().contDtoToCont(contribuableDto);
		u.setContribuable(c);
		if (contribuableService.isNineaExists(c.getNinea())) {
			return Response.duplicateNinea().setErrors(new String("Ce ninea existe déjà."));
		}
		if (utilisateurService.isUserEmailExist(u.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		if (utilisateurService.saveUser(u))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(u)).setMessage(new String("Votre inscription a été validée avec succès.<br>\r\n" + 
					" Vous avez reçu un email dans votre courriel. Vous pourrez accèder à  votre espace <br>."));
		else
			return Response.badRequest().setErrors("Echec inscription ");
		//return Response.ok().setPayload(u);
	}
	
	
	@GetMapping("/listIntervenantsContribuable/{idContribuable}")
	public Response<?> getAllIntervenantsContribuables(@PathVariable("idContribuable") Long idContribuable, @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Utilisateur> pagesUsers = utilisateurService.findAllUtilisateursByContribuableId(idContribuable,page, size);
		int newSize = pagesUsers.getSize();
		Long totalElements = pagesUsers.getTotalElements();
		int totalPages = pagesUsers.getTotalPages();
		int number = pagesUsers.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(pagesUsers.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	@GetMapping("/detailsContribuable/{idContribuable}")
	public Response<?> getDetailsContribuables(@PathVariable("idContribuable") Long idContribuable, @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		 System.out.println(idContribuable+" ID CONTRIB");
		
		DetailsContribuableDto detailsContribuableDto = new DetailsContribuableDto();
		Contribuable contribuable = contribuableService.getContribuableByid(idContribuable);
		Page<Utilisateur> pagesUsers = utilisateurService.findAllUtilisateursByContribuableId(idContribuable,page, size);
		int newSize = pagesUsers.getSize();
		Long totalElements = pagesUsers.getTotalElements();
		int totalPages = pagesUsers.getTotalPages();
		int number = pagesUsers.getNumber();
		detailsContribuableDto.setUtilisateurDtos(new UtilisateurMapper()
				.usersToUserDTOs(pagesUsers.getContent()));
		detailsContribuableDto.setContribuableDto(new ContribuableMapper().contToContDto(contribuable));
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(detailsContribuableDto).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	@GetMapping(value = "/getAllRegimeImposition")
	public Response<?> getAllRegimeImposition() {
		
		return Response.ok().setPayload(regimeImpositionService.getAllRegimeImposition());
	}
	@GetMapping(value = "/getAllFonctions")
	public Response<?> getAllFonctions() {
		
		return Response.ok().setPayload(fonctionService.getAllFonctions());
	}
	@GetMapping(value = "/getAllFormeJuridiques")
	public Response<?> getAllFormeJuridiques() {
		
		return Response.ok().setPayload(formeJuridiqueService.getAllFormeJuridiques());
	}
	@GetMapping(value = "/getAllSystemeComptables")
	public Response<?> getAllSystemeComptables() {
		
		return Response.ok().setPayload(systemeComptableService.getAllSystemeComptables());
	}
	@GetMapping(value = "/getAllTypeEntites")
	public Response<?> getAllTypeEntites() {
		
		return Response.ok().setPayload(typeEntiteService.getAllTypeEntite());
	}
	@GetMapping(value = "/getAllTypeStructures")
	public Response<?> getAllTypeStructures() {
		
		return Response.ok().setPayload(typeStructureService.getAllTypeStructures());
	}
	
	@GetMapping(value = "/getAllLocalites")
	public Response<?> getAllLocalites() {
		
		return Response.ok().setPayload(localiteService.getAllLocalites());
	}
	@GetMapping(value = "/getAllCentreServiceFiscals")
	public Response<?> getAllCentreServiceFiscal() {
		
		return Response.ok().setPayload(centreServiceFiscalService.getAllCentreServiceFiscal());
	}
	@GetMapping(value = "/getAllActivitePrincipales")
	public Response<?> getAllActivitePrincipales() {
		
		return Response.ok().setPayload(activitePrincipaleService.getAllActivitePrincipales());
	}
	@GetMapping(value = "/getAllAssocies")
	public Response<?> getAllAssocies() {
		
		return Response.ok().setPayload(associeService.getAllAssocies());
	}
	@GetMapping(value = "/getContribuableById/{id}")
	public Response<?> getContribuableById(@PathVariable("id") Long id) {
		
		Contribuable contribuable = contribuableService.getContribuableByid(id);
		
		if (contribuable !=null)
			return Response.ok().setPayload(contribuable);
		else
			return Response.badRequest();
	}
	@GetMapping(value = "/findAllContribuableByNiniaContent/{ninea}")
	public Response<?> getContribuableById(@PathVariable("ninea") String ninea) {
		
		List<Contribuable>  contribuables = contribuableService.findAllContribuableByNiniaContent(ninea);
		
		if (contribuables.size()>0)
			return Response.ok().setPayload(contribuables);
		else
			return Response.ok().setErrors("Aucun contribuable trouvé!");
	}
	@PostMapping("/updateContribuable/{idUser}/{idCont}")
	public Response<?> updateContribuable(@RequestBody Contribuable contribuable, @PathVariable("idUser") Long idUser,  @PathVariable("idCont") Long idCont) {
		Utilisateur user = utilisateurService.findUtilisateurById(idUser);
		Contribuable contToUpdate = contribuableService.getContribuableByid(idCont);
		contToUpdate.setActivitePrincipale(contribuable.getActivitePrincipale());
		contToUpdate.setAdresseComplete(contribuable.getAdresseComplete());
		contToUpdate.setCentreServiceFiscal(contribuable.getCentreServiceFiscal());
		contToUpdate.setCofi(contribuable.getCofi());
		contToUpdate.setFonction(contribuable.getFonction());
		contToUpdate.setFormeJuridique(contribuable.getFormeJuridique());
		contToUpdate.setLocalite(contribuable.getLocalite());
		contToUpdate.setNinea(contribuable.getNinea());
		contToUpdate.setNomOuRaisonSocial(contribuable.getNomOuRaisonSocial());
		contToUpdate.setRegimeImposition(contribuable.getRegimeImposition());
		contToUpdate.setResponsableMorale(contribuable.getResponsableMorale());
		contToUpdate.setSigle(contribuable.getSigle());
		contToUpdate.setTypeEntite(contribuable.getTypeEntite());
		contToUpdate.setSystemeComptable(contribuable.getSystemeComptable());
		contToUpdate.setTypeStructure(contribuable.getTypeStructure());
		
		user.setContribuable(contToUpdate);
		if (contribuableService.isNineaExistsDiffId(contribuable.getNinea(), idCont)) {
			return Response.duplicateNinea().setErrors(new String("Ce ninea existe déjà."));
		}
		
		if (utilisateurService.saveUser(user))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(user)).setMessage(new String("Modification inscription réussie."));
		else
			return Response.badRequest().setErrors("Echec modification inscription. ");
		//return Response.ok().setPayload(u);
	}
	
	@PostMapping("/saveclient/{id}")
	public Response<?> saveContribuableCLient(@RequestBody InscriptionDto inscriptionDto, @PathVariable("id") Long id) {
		
		
		ContribuableDto contribuableDto = inscriptionDto.getContribuableDto();
		
		UtilisateurDto utilisateurDto = inscriptionDto.getUtilisateurDto();
		
		
		Utilisateur u = new UtilisateurMapper().toUser(utilisateurDto);
		Contribuable c = new ContribuableMapper().contDtoToCont(contribuableDto);
		
		System.out.println("---------------------------->"+id);
		Structure cabinet= structureService.getStructureById(id);
		
		 /*Structure cabinet= new Structure();
		  cabinet.setId(id);*/
		c.setCabinet(cabinet);
		
		u.setContribuable(c);
		
	
		if (contribuableService.isNineaExists(c.getNinea())) {
			return Response.duplicateNinea().setErrors(new String("Ce ninea existe déjà."));
		}
		if (utilisateurService.isUserEmailExist(u.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		if (utilisateurService.saveUserCLient(u))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(u)).setMessage(new String("Inscription client a été validée avec succès.<br>\r\n" + 
					"  <br>."));
		else
			return Response.badRequest().setErrors("Echec inscription client ");
		
		
		//return Response.ok().setPayload(new Utilisateur()).setMessage("ok");
	}
	
	
	@GetMapping("/listclient/{id}")
	public Response<?> getAllContribuablesByCabinet(@PathVariable("id") Long id, @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Contribuable> pages = contribuableService.getAllContribuablesByClient(id,page, size);
		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
				
		//		new ContribuableMapper()
		//.contribuablesTocontribuablesDTOs(pages.getContent())).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	
	@GetMapping(value = "/getAllProfilContribuable")
	public Response<?> getAllProfilContribuable() {
		
		return Response.ok().setPayload(profilService.getAllProfilContribuable());
	}
	
	
	@PostMapping("/saveIntervenantInscription/{idContribuable}")
	public Response<?> saveIntervenantContribuable(@RequestBody UtilisateurDto utilisateurDto, @PathVariable("idContribuable") Long idContribuable) {
		Contribuable contribuable =  contribuableService.getContribuableByid(idContribuable);
		Utilisateur u = new UtilisateurMapper().toUser(utilisateurDto);
		u.setContribuable(contribuable);
		
		if (utilisateurService.isUserEmailExist(u.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		
		if (utilisateurService.saveUser(u))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(u)).setMessage(new String("Ajout interventant du contribuable réussi."));
		else
			return Response.badRequest().setErrors(new String("Echec ajout interventant cabinet."));
	}
	
	
	@PostMapping("search/contribuableInscription")
	public Response<?> searchContribuableInscription(@RequestBody SearchInscriptionDto searchInscriptionDto) throws IOException {
		
		List<Contribuable> list = contribuableService.searchContribuablesInscription(searchInscriptionDto);
		
		return Response.ok().setPayload(list);
	}
	
	@GetMapping(value = "/getLocaliteById/{id}")
	public Response<?> getLocaliteById(@PathVariable("id") Long id) {
		
		return Response.ok().setPayload(localiteService.getLocaliteById(id));
	}
	
	
	
	@PostMapping("/updateContribuableById/{idCont}")
	public Response<?> updateContribuableById(@RequestBody Contribuable contribuable, @PathVariable("idCont") Long idCont) {
		
		Contribuable contToUpdate = contribuableService.getContribuableByid(idCont);
		contToUpdate.setActivitePrincipale(contribuable.getActivitePrincipale());
		contToUpdate.setAdresseComplete(contribuable.getAdresseComplete());
		contToUpdate.setCentreServiceFiscal(contribuable.getCentreServiceFiscal());
		contToUpdate.setCofi(contribuable.getCofi());
		contToUpdate.setFonction(contribuable.getFonction());
		contToUpdate.setFormeJuridique(contribuable.getFormeJuridique());
		contToUpdate.setLocalite(contribuable.getLocalite());
		contToUpdate.setNinea(contribuable.getNinea());
		contToUpdate.setNomOuRaisonSocial(contribuable.getNomOuRaisonSocial());
		contToUpdate.setRegimeImposition(contribuable.getRegimeImposition());
		contToUpdate.setResponsableMorale(contribuable.getResponsableMorale());
		contToUpdate.setSigle(contribuable.getSigle());
		contToUpdate.setTypeEntite(contribuable.getTypeEntite());
		contToUpdate.setSystemeComptable(contribuable.getSystemeComptable());
		contToUpdate.setTypeStructure(contribuable.getTypeStructure());
		
		if (contribuableService.isNineaExistsDiffId(contribuable.getNinea(), idCont)) {
			return Response.duplicateNinea().setErrors(new String("Ce ninea existe déjà."));
		}
		
		Contribuable cont= contribuableService.saveContribuable(contToUpdate);
		
		if (cont!=null)
			return Response.ok().setPayload(cont).setMessage(new String("Modification inscription réussie."));
		else
			return Response.badRequest().setErrors("Echec modification inscription. ");
		//return Response.ok().setPayload(u);
	}
	
	
	
	@PostMapping("/updateAbonnementContribuable/{id}")
	public Response<?> updateAbonnementContribuable( @PathVariable("id") Long id) {
		
		Contribuable contToUpdate = contribuableService.getContribuableByid(id);
		contToUpdate.setAbonnement(!contToUpdate.isAbonnement());
		
		Contribuable cont= contribuableService.saveContribuable(contToUpdate);
		
		if (cont!=null)
			return Response.ok().setPayload(cont).setMessage(new String("Modification Abbonnement réussie."));
		else
			return Response.badRequest().setErrors("Echec modification inscription. ");
		//return Response.ok().setPayload(u);
	}
	
	
	
	@GetMapping("/getAlllistIntervenantsContribuable")
	public Response<?> getAlllistIntervenantsContribuable(@RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		//findAllUtilisateursByContribuable_IdNotNullOrderByIdDesc
		//Page<Utilisateur> pagesUsers = utilisateurService.findAllUtilisateursByContribuable(page, size);
		Page<Utilisateur> pagesUsers = contribuableService.findAllUtilisateursByContribuable(page, size);
		int newSize = pagesUsers.getSize();
		Long totalElements = pagesUsers.getTotalElements();
		int totalPages = pagesUsers.getTotalPages();
		int number = pagesUsers.getNumber();
		//return Response.ok().setPayload(pages);
		return Response.ok().setPayload(pagesUsers.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	
	
	@PostMapping("search/intervenantContribuable")
	public Response<?> searchintervenantContribuable(@RequestBody SearchIntervenantDto searchIntervenantDto) throws IOException {
		
		List<Utilisateur> list = contribuableService.searchIntervenantContribuable(searchIntervenantDto);
		
		return Response.ok().setPayload(list);
	}
	
	
	@GetMapping("/getNombreContribuablesAbonne")
	public Response<?> getNombreContribuablesAbonne() {
		List<Contribuable> liste = contribuableService.getNombreContribuablesAbonne();
		
		
		return Response.ok().setPayload(liste.size());
	}
	
	
	
}

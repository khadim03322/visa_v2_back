package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.io.IOException;
import java.time.LocalDate;
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
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.DepotService;
import sn.gainde2000.orbuslink.visa.exception.SignatureException;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.service.InfoVisaService;
import sn.gainde2000.orbuslink.visa.web.dto.model.CabinetDepotDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDepot;
import sn.gainde2000.orbuslink.visa.web.dto.model.InfoViserDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchDepotDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/depot")
public class DepotController {

	private final DepotService depotService;
	private final AuthService authService;
	private final InfoVisaService infoVisaService;

	@GetMapping(value = "/getDepotById/{id}")
	public Response<?> getUtilisateurById(@PathVariable("id") Long id) {

		Depot depot = depotService.findDepotById(id);

		if (depot !=null)
			return Response.ok().setPayload(depot);
		else
			return Response.badRequest();
	}

	@GetMapping("getCoutVisa/{ca}")
	public Response<?> getCoutVisa(@PathVariable Long ca) throws IOException {
		return Response.ok().setPayload(depotService.getAllBaremeCoutVisa().stream().filter(b -> b.getBarMax() >= ca && b.getBarMin() <= ca).findFirst().isPresent() ? depotService.getAllBaremeCoutVisa().stream().filter(b -> b.getBarMax() >= ca && b.getBarMin() <= ca).findFirst().get() : 0);
	}

	@PostMapping("save/contribuableDepot")
	public Response<?> saveContribuableDepot(@RequestBody ContribuableDepot contribuableDepot) throws IOException {
		return Response.ok().setPayload(depotService.saveDepot(contribuableDepot, Depot.EEtatDepot.BR)).setMessage("Votre demande visa a été bien enregistrée en brouillon!");
	}

	@PostMapping("valid/contribuableDepot")
	public Response<?> validContribuableDepot(@RequestBody ContribuableDepot contribuableDepot) throws IOException {
		return Response.ok().setPayload(depotService.saveDepot(contribuableDepot, Depot.EEtatDepot.DE)).setMessage("Votre demande visa a été bien déposée!");
	}

	//	Cabinet

	@PostMapping("save/cabinetDepot")
	public Response<?> saveCabinetDepot(@RequestBody CabinetDepotDto cabinetDepotDto) throws IOException {
		return Response.ok().setPayload(depotService.saveDepotCabinet(cabinetDepotDto, Depot.EEtatDepot.BR)).setMessage("Votre demande visa a été bien enregistrée en brouillon!");
	}

	@PostMapping("valid/cabinetDepot")
	public Response<?> validCabinetDepot(@RequestBody CabinetDepotDto cabinetDepotDto) throws IOException {
		return Response.ok().setPayload(depotService.saveDepotCabinet(cabinetDepotDto, Depot.EEtatDepot.DE)).setMessage("Votre demande visa a été bien déposée!");
	}

	//	end Cabinet

	@GetMapping("getListByContrib/{id}")
	public Response<?> contribuableListDepot(@PathVariable("id") Long id,@RequestParam(value = "page",defaultValue = "0") int page,
											 @RequestParam(value = "size",defaultValue = "10") int size) throws IOException {
		Page<Depot> pages = depotService.getAllDepotByAuthUser(id, page, size);

		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}

	@GetMapping("mes-demandes-recus/{id}")
	public Response<?> mesdemandesRecu(@PathVariable("id") Long id,@RequestParam(value = "page",defaultValue = "0") int page,
									   @RequestParam(value = "size",defaultValue = "10") int size) throws IOException {
		Page<Depot> pages = depotService.getAllDepotByStructureId(id, page, size);

		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}

	@GetMapping("mes-demandes-brouillons/{id}")
	public Response<?> mesdemandesBrouillons(@PathVariable("id") Long id,@RequestParam(value = "page",defaultValue = "0") int page,
											 @RequestParam(value = "size",defaultValue = "10") int size) throws IOException {
		Page<Depot> pages = depotService.getAllDepotBrouillonsByStructureId(id, page, size);

		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}

	@PostMapping("search/contribuableDepot")
	public Response<?> searchContribuableDepot(@RequestBody SearchDepotDto searchDepotDto) throws IOException {
		List<Depot> list = depotService.searchContribuabledepots(authService.getConnectedUser().getContribuable().getId(), searchDepotDto);
		return Response.ok().setPayload(list);
	}

	@PostMapping("search/structure")
	public Response<?> searchStructureDepots(@RequestBody SearchDepotDto searchDepotDto) throws IOException {
		List<Depot> result = depotService.searchStructureDepots(authService.getConnectedUser().getStructure().getId(), searchDepotDto);
		return Response.ok().setPayload(result);
	}

	@PostMapping("search/admin")
	public Response<?> searchAdminDepots(@RequestBody SearchDepotDto searchDepotDto) throws IOException {
		List<Depot> result = depotService.searchAdminDepots(searchDepotDto);
		return Response.ok().setPayload(result);
	}

	@PostMapping("search/brouillon/structure")
	public Response<?> searchStructureBrouillons(@RequestBody SearchDepotDto searchDepotDto) throws IOException {
		List<Depot> result = depotService.searchStructureBrouillon(authService.getConnectedUser().getStructure().getId(), searchDepotDto);

		return Response.ok().setPayload(result);
	}

	@GetMapping("rejet/{id}")
	public Response<?> rejetDepot(@PathVariable Long id) throws IOException {
		boolean statut = depotService.rejetDepot(id);
		if(statut) {
			return Response.ok().setMessage("Le dépot a été bien réjeté!");
		}
		return Response.exception().setErrors("Une erreur est survenue!");
	}

	@GetMapping("rejetdef/{id}")
	public Response<?> rejetDefDepot(@PathVariable Long id) throws IOException {
		boolean statut = depotService.rejetDefinitifDepot(id);
		if(statut) {
			return Response.ok().setMessage("Le dépot a été bien réjeté!");
		}
		return Response.exception().setErrors("Une erreur est survenue!");
	}

	@GetMapping("details/{id}")
	public Response<?> GetDetailsDepot(@PathVariable Long id) throws IOException {
		return Response.ok().setPayload(depotService.findDepotById(id));
	}

	@GetMapping("info/{id}")
	public Response<?> GetInfoDepot(@PathVariable Long id) throws IOException {
		return Response.ok().setPayload(infoVisaService.getInfoByIdDepot(id));
	}

	@PostMapping("viser/{id}")
	public Response<?> viserDepot(@RequestBody InfoViserDto info,@PathVariable("id") Long idDepot) throws IOException {

		String result = null;

		try {
			result = depotService.signerDocumentAttestation(idDepot, 36, info.getPinCode(), info.getMission(), info.getSignature());
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(result.equals("success")) {
			return Response.ok().setMessage("Demande visée");
		}
		return Response.exception().setErrors(result);
	}


	@GetMapping(value = "/getDepotsAdmin")
	public Response<?> getDepotsAdmin(@RequestParam(value = "page",defaultValue = "0") int page,
									  @RequestParam(value = "size",defaultValue = "10") int size) {

		Page<Depot> pages = depotService.getAllDepotAdmin(page, size);

		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}

}

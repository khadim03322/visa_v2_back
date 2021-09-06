package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Etalink;
import sn.gainde2000.orbuslink.visa.model.PieceJoint;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.ContribuableService;
import sn.gainde2000.orbuslink.visa.service.IEtatLinkService;
import sn.gainde2000.orbuslink.visa.service.PieceJointService;
import sn.gainde2000.orbuslink.visa.web.dto.model.DownloadDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/mazars")
public class MazarsController {
	
	private final ContribuableService contribuableService;
	private final PieceJointService pieceJointService;
	private final IEtatLinkService iEtatLinkService;

	
	
	@GetMapping("/listclientBycabinet/{id}")
	public Response<?> getAllContribuablesByCabinet(@PathVariable("id") Long id) {
		return Response.ok().setPayload(contribuableService.getAllContribuablesByClient(id));

	}
	
	@PostMapping("/download")
	public Response<?> getAllContribuablesByCabinet(@RequestBody DownloadDto downloadDto) {
		
		try {
			PieceJoint rep = pieceJointService.copy(downloadDto);
			return Response.ok().setPayload(rep).setMessage("Vous venez de télécharger le fichier étalink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.exception().setPayload(downloadDto).setErrors("une erreur est survenue");
		

	}
	
	@GetMapping("etalinkListByProfil")
	public Response<?> getListEtalink(@RequestParam(value = "page",defaultValue = "0") int page,
											 @RequestParam(value = "size",defaultValue = "10") int size) throws IOException {
		Page<Etalink> pages = iEtatLinkService.getListEtalinkByProfil(page, size);
		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	@GetMapping("delete/{id}")
	public Response<?> deleteEtalink(@PathVariable Long id) throws IOException {
		boolean response = iEtatLinkService.deleteEtalink(id);
		return response ? Response.ok().setMessage("Votre demande a été bien supprimé") : Response.exception().setErrors("Une erreur est survenue!");
	}
	
	@GetMapping("generateEtafi/{id}")
	public Response<?> generateEtafi(@PathVariable Long id) throws Exception {
		PieceJoint response = pieceJointService.genererEtafi(id);
		return response != null ? Response.ok().setPayload(response) : Response.exception().setErrors("Une erreur est survenue!");
	}

}

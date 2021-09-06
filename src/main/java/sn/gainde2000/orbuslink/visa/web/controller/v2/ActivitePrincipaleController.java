package sn.gainde2000.orbuslink.visa.web.controller.v2;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.ActivitePrincipale;
import sn.gainde2000.orbuslink.visa.service.ActivitePrincipaleService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.ActivitePrincipaleMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.ActivitePrincipaleDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/activitePrincipale")
public class ActivitePrincipaleController {
	private final ActivitePrincipaleService activitePrincipaleService;
	
	@GetMapping("/list")
	public Response<?> getAllActivitePrincipale( @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<ActivitePrincipale> pages = activitePrincipaleService.getAllActivitePrincipales(page, size);
		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	@PostMapping("/save")
	public Response<?> saveActivitePrincipale(@RequestBody ActivitePrincipaleDto activitePrincipaleDto) {
		System.out.println("activité principale--------->"+activitePrincipaleDto.getLibelle());
		
		if (activitePrincipaleService.isActiviteExists(activitePrincipaleDto.getLibelle())) {
			return Response.duplicateActivite().setErrors(new String("Cette activité existe déjà."));
		}
		else {
			
		ActivitePrincipale acPrincipale = new ActivitePrincipaleMapper().activitePrincipalesDtoToActivitePrincipales(activitePrincipaleDto) ;
		ActivitePrincipale ac = activitePrincipaleService.saveActivitePrincipale(acPrincipale);
		if (ac!=null)
			return Response.ok().setPayload(new ActivitePrincipaleMapper().activitePrincipaleToActivitePrincipaletDto(ac)).setMessage(new String("Enregistrement activié réussi."));
		else
			return Response.badRequest().setErrors(new String("Echec Enregistrement activité."));
	}
}
	}

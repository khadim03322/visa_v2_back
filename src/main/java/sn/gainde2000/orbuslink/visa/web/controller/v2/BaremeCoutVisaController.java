package sn.gainde2000.orbuslink.visa.web.controller.v2;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.service.BaremeCoutVisaService;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.UtilisateurService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.BaremeCoutVisaMapper;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.UtilisateurMapper;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/BaremeCoutVisa")
public class BaremeCoutVisaController {
	
	private final BaremeCoutVisaService baremeCoutVisaService;
	
	@GetMapping("/list")
	public Response<?> getAllBaremeCoutVisas( @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<BaremeCoutVisa> pages = baremeCoutVisaService.getAllBaremeCoutVisas(page, size);
		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
}

package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.service.ActivitePrincipaleService;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.StatistiqueService;
import sn.gainde2000.orbuslink.visa.web.dto.model.DataLigneTous;
import sn.gainde2000.orbuslink.visa.web.dto.model.RapportCabinet;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchRapportDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/statistique")
public class StatistiqueController {
	
	private final StatistiqueService statistiqueService;
	private final AuthService authService;
	
	@GetMapping("/dashboard")
	Map<String, Long> getNumbers()
    {
       //System.out.println("authService.getConnectedUser() "+authService.getConnectedUser().getEmail());
       
		return statistiqueService.dashbord();
	
    }
	
	@GetMapping("/dashboard2/{id}")
	Map<String, Long> getNumbers2(@PathVariable("id") Long id)
    {
        
		return statistiqueService.dashbord(id);
	
    }
	
	
	@GetMapping("/nombrebymois/{id}")
	 public List<DataLigneTous> getNombreDepotGroupeByMois(@PathVariable("id") Long id) {
		 
	    	List<DataLigneTous> liste= statistiqueService.getNombreDepotGroupeByMois(id);
	    	
	    	
	    	return liste ;
	    }
	
	
	 @GetMapping("/nombrebySystemeComptable/{id}")
	 public List<Object[]> getNombreDepotGroupeBySystemComptable(@PathVariable("id") Long id) {
	    	List<Object[]> liste= statistiqueService.getNombreDepotGroupeBySystemComptable(id);
	    	
	    	
	    	return liste ;
	    }
	
	 
	 @PostMapping("/nombreVisabyCabinet")
	 public Response<?> getNombreVisabyCabinet(@RequestBody SearchRapportDto searchRapportDto) {
		 
	    	List<RapportCabinet> liste= statistiqueService.getNombreVisabyCabinet(searchRapportDto);
	    	
	    	
	    	return Response.ok().setPayload(liste); 	
	    	
	    	//return liste ;
	    }
	
	 
	 @PostMapping("/nombreRejetByCabinet")
	 public Response<?> getNombreRejetByCabinet(@RequestBody SearchRapportDto searchRapportDto) {
		 
	    	List<RapportCabinet> liste= statistiqueService.getNombreRejetByCabinet(searchRapportDto);
	    	
	    	
	    	return Response.ok().setPayload(liste); 	
	    	
	    	//return liste ;
	    }

}

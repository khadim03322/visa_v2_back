package sn.gainde2000.orbuslink.visa.service;

import java.util.List;
import java.util.Map;

import sn.gainde2000.orbuslink.visa.web.dto.model.DataLigneTous;
import sn.gainde2000.orbuslink.visa.web.dto.model.RapportCabinet;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchRapportDto;

public interface StatistiqueService {

	Map<String, Long> dashbord();

	Map<String, Long> dashbord(Long id);

	List<DataLigneTous> getNombreDepotGroupeByMois(Long id);

	
	List<Object[]> getNombreDepotGroupeBySystemComptable(Long id);

	List<RapportCabinet> getNombreVisabyCabinet(SearchRapportDto searchRapportDto);

	List<RapportCabinet> getNombreRejetByCabinet(SearchRapportDto searchRapportDto);

	
}

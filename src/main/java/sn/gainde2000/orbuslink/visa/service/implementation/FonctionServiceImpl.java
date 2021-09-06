package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.RegimeImposition;
import sn.gainde2000.orbuslink.visa.repository.FonctionRepository;
import sn.gainde2000.orbuslink.visa.service.FonctionService;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@Service
public class FonctionServiceImpl implements FonctionService {
	
	private FonctionRepository fonctionRepository;
	
	
	@Autowired
	public void setRepository(FonctionRepository fonctionRepository
			
		)
	{
		this.fonctionRepository = fonctionRepository;
	}
	@Override
	public List<Fonction> getAllFonctions(){
		return fonctionRepository.findAll();
	}

}

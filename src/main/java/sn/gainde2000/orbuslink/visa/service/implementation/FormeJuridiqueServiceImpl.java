package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.FormeJuridique;
import sn.gainde2000.orbuslink.visa.repository.FonctionRepository;
import sn.gainde2000.orbuslink.visa.repository.FormeJuridiqueRepository;
import sn.gainde2000.orbuslink.visa.service.FormeJuridiqueService;

@Service
public class FormeJuridiqueServiceImpl implements FormeJuridiqueService {
	private FormeJuridiqueRepository formeJuridiqueRepository;
	
	
	@Autowired
	public void setRepository(FormeJuridiqueRepository formeJuridiqueRepository
			
		)
	{
		this.formeJuridiqueRepository = formeJuridiqueRepository;
	}
	@Override
	public List<FormeJuridique> getAllFormeJuridiques(){
		return formeJuridiqueRepository.findAll();
	}

}

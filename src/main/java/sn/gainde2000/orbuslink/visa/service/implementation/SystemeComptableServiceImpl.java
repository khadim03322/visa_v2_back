package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.SystemeComptable;
import sn.gainde2000.orbuslink.visa.repository.FonctionRepository;
import sn.gainde2000.orbuslink.visa.repository.SystemeComptableRepository;
import sn.gainde2000.orbuslink.visa.service.SystemeComptableService;

@Service
public class SystemeComptableServiceImpl implements SystemeComptableService {
	private SystemeComptableRepository systemeComptableRepository;
	
	
	@Autowired
	public void setRepository(SystemeComptableRepository systemeComptableRepository
			
		)
	{
		this.systemeComptableRepository = systemeComptableRepository;
	}
	@Override
	public List<SystemeComptable> getAllSystemeComptables(){
		return systemeComptableRepository.findAll();
	}

}

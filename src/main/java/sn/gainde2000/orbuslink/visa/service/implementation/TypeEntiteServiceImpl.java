package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.SystemeComptable;
import sn.gainde2000.orbuslink.visa.model.TypeEntite;
import sn.gainde2000.orbuslink.visa.repository.SystemeComptableRepository;
import sn.gainde2000.orbuslink.visa.repository.TypeEntiteRepository;
import sn.gainde2000.orbuslink.visa.service.TypeEntiteService;

@Service
public class TypeEntiteServiceImpl implements TypeEntiteService {
	
	private TypeEntiteRepository typeEntiteRepository;
	
	
	@Autowired
	public void setRepository(TypeEntiteRepository typeEntiteRepository
			
		)
	{
		this.typeEntiteRepository = typeEntiteRepository;
	}
	@Override
	public List<TypeEntite> getAllTypeEntite(){
		return typeEntiteRepository.findAll();
	}

}

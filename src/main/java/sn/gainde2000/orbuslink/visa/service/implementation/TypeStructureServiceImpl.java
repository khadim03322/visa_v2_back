package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.TypeStructure;
import sn.gainde2000.orbuslink.visa.repository.FonctionRepository;
import sn.gainde2000.orbuslink.visa.repository.TypeStructureRepository;
import sn.gainde2000.orbuslink.visa.service.TypeStructureService;

@Service
public class TypeStructureServiceImpl implements TypeStructureService {
	
	private TypeStructureRepository typeStructureRepository;
	
	
	@Autowired
	public void setRepository(TypeStructureRepository typeStructureRepository
			
		)
	{
		this.typeStructureRepository = typeStructureRepository;
	}
	@Override
	public List<TypeStructure> getAllTypeStructures(){
		return typeStructureRepository.findAll();
	}

}

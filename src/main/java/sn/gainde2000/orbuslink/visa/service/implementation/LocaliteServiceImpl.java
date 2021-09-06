package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Localite;
import sn.gainde2000.orbuslink.visa.model.TypeStructure;
import sn.gainde2000.orbuslink.visa.repository.LocaliteRepository;
import sn.gainde2000.orbuslink.visa.repository.TypeStructureRepository;
import sn.gainde2000.orbuslink.visa.service.LocaliteService;

@Service
public class LocaliteServiceImpl implements LocaliteService {
	
	private LocaliteRepository localiteRepository;
	
	
	@Autowired
	public void setRepository(LocaliteRepository localiteRepository
			
		)
	{
		this.localiteRepository = localiteRepository;
	}
	@Override
	public List<Localite> getAllLocalites(){
		return localiteRepository.findAllByOrderByLibelleAsc();
	}
	
	@Override
	public Optional<Localite> getLocaliteById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(localiteRepository.findById(id).get());
	}
	
	
	

}

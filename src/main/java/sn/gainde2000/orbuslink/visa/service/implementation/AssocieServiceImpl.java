package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Associe;
import sn.gainde2000.orbuslink.visa.repository.AssocieRepostitory;
import sn.gainde2000.orbuslink.visa.repository.FonctionRepository;
import sn.gainde2000.orbuslink.visa.service.AssocieService;

@Service
public class AssocieServiceImpl implements AssocieService{
	
	private AssocieRepostitory  associeRepostitory;
	
	
	@Autowired
	public void setRepository(AssocieRepostitory  associeRepostitory
			
		)
	{
		this.associeRepostitory = associeRepostitory;
	}
	@Override
	public List<Associe> getAllAssocies() {
		
		return associeRepostitory.findAll();
	}

}

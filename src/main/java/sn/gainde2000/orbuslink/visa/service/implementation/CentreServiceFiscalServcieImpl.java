package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.CentreServiceFiscal;
import sn.gainde2000.orbuslink.visa.repository.CentreServiceFiscalRepository;
import sn.gainde2000.orbuslink.visa.service.CentreServiceFiscalService;

@Service
public class CentreServiceFiscalServcieImpl implements CentreServiceFiscalService {
	
	private CentreServiceFiscalRepository centreServiceFiscalRepository;
	@Autowired
	public void setRepository(CentreServiceFiscalRepository centreServiceFiscalRepository
			
		)
	{
		this.centreServiceFiscalRepository = centreServiceFiscalRepository;
	}
	
	@Override
	public List<CentreServiceFiscal> getAllCentreServiceFiscal(){
		return centreServiceFiscalRepository.findAll();
	}
}

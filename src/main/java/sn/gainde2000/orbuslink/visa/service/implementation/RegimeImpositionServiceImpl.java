package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.model.Profil;
import sn.gainde2000.orbuslink.visa.model.RegimeImposition;
import sn.gainde2000.orbuslink.visa.repository.ProfilRepository;
import sn.gainde2000.orbuslink.visa.repository.RegimeImpositionRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.RegimeImpositionService;
import sn.gainde2000.orbuslink.visa.service.SimpleEmailService;

@Service
public class RegimeImpositionServiceImpl implements RegimeImpositionService {
	private RegimeImpositionRepository regimeImpositionRepository;
	@Autowired
	public void setRepository(RegimeImpositionRepository regimeImpositionRepository
			
		)
	{
		this.regimeImpositionRepository = regimeImpositionRepository;
	}
	
	@Override
	public List<RegimeImposition> getAllRegimeImposition(){
		return regimeImpositionRepository.findAll();
	}
}

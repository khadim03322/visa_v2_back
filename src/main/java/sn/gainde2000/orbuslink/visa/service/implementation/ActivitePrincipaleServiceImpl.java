package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.ActivitePrincipale;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.ActivitePrincipaleRepository;
import sn.gainde2000.orbuslink.visa.service.ActivitePrincipaleService;

@Service
public class ActivitePrincipaleServiceImpl implements ActivitePrincipaleService {
	private ActivitePrincipaleRepository activitePrincipaleRepository;
	
	@Autowired
	public void setRepository(ActivitePrincipaleRepository activitePrincipaleRepository
			)
	{
		this.activitePrincipaleRepository = activitePrincipaleRepository;
	}
	@Override
	public Page<ActivitePrincipale> getAllActivitePrincipales(int page, int size) {
		
		Pageable requestedPage = PageRequest.of(page, size);
		return activitePrincipaleRepository.findAll(requestedPage);
	}
	@Override
	public ActivitePrincipale saveActivitePrincipale(ActivitePrincipale activitePrincipale) {
		return this.activitePrincipaleRepository.save(activitePrincipale);
	}
	@Override
	public List<ActivitePrincipale> getAllActivitePrincipales() {
		return this.activitePrincipaleRepository.findAll();
	}
	@Override
	public boolean isActiviteExists(String libelle) {
		ActivitePrincipale activitePrincipale = activitePrincipaleRepository.findActivitePrincipaleBylibelle(libelle);
		if (activitePrincipale!=null) {
			return true;
		}
		return false;
	}
	
	
}

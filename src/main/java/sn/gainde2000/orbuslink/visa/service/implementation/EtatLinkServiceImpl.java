package sn.gainde2000.orbuslink.visa.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.Etalink;
import sn.gainde2000.orbuslink.visa.model.Etalink.EEtatDemande;
import sn.gainde2000.orbuslink.visa.repository.EtalinkRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.IEtatLinkService;
import sn.gainde2000.orbuslink.visa.web.dto.model.DownloadDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.ProfilDto;

@Service
@RequiredArgsConstructor
public class EtatLinkServiceImpl implements IEtatLinkService{
	
	private final EtalinkRepository etalinkrepository;
	private final AuthService authService;

	@Override
	public boolean savedownloadInfo(DownloadDto downloadDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Etalink> getListEtalinkByProfil(int page, int size) {
		// TODO Auto-generated method stub
		ProfilDto profil = authService.getConnectedUser().getProfil();
		Pageable requestedPage = PageRequest.of(page, size);
		
		switch (profil.getCode()) {
		case "AD":
			return etalinkrepository.findAllByEtatNotOrderByIdDesc(EEtatDemande.DE,requestedPage);
			
		case "CA":
			return etalinkrepository.findAllByStructure_IdAndEtatNotOrderByIdDesc(authService.getConnectedUser().getStructure().getId(),EEtatDemande.DE, requestedPage);
		case "EX":
			return etalinkrepository.findAllByStructure_IdAndEtatNotOrderByIdDesc(authService.getConnectedUser().getStructure().getId(),EEtatDemande.DE, requestedPage);
		case "DE":
			return etalinkrepository.findAllByContribuable_IdAndEtatNotOrderByIdDesc(authService.getConnectedUser().getContribuable().getId(),EEtatDemande.DE, requestedPage);
		case "SEL":
			
			break;

		default:
			break;
		}
		
		return null;
	}

	@Override
	public boolean deleteEtalink(long id) {
		// TODO Auto-generated method stub
		try {
			Etalink etalink = etalinkrepository.findById(id).orElse(null);
			if(etalink == null) {
				return false;
			}
			etalink.setEtat(EEtatDemande.DE);
			etalinkrepository.save(etalink);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	

}

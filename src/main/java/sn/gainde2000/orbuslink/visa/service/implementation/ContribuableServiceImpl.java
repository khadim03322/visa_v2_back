package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;
import sn.gainde2000.orbuslink.visa.repository.ContribuableRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.ContribuableService;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.SimpleEmailService;
import sn.gainde2000.orbuslink.visa.util.EmailSender;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.ContribuableMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchDepotDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchInscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchIntervenantDto;

@Service
public class ContribuableServiceImpl implements ContribuableService {
	
	private ContribuableRepository contribuableRepository;
	private JwtTokenUtil jwtTokenUtil;
	private JwtUserDetailsService userDetailsService;
	private SimpleEmailService simpleEmailService;
	
	private UtilisateurRepository  utilisateurRepository;
	
	@Value("${urlApp}")
    String url ;
	
	@Autowired
	public void setRepository(
			ContribuableRepository contribuableRepository,
			JwtTokenUtil jwtTokenUtil,
			JwtUserDetailsService userDetailsService,
			SimpleEmailService simpleEmailService,
			UtilisateurRepository utilisateurRepository
			)
	{
		this.contribuableRepository = contribuableRepository;
		this.jwtTokenUtil= jwtTokenUtil;
		this.userDetailsService = userDetailsService;
		this.simpleEmailService = simpleEmailService;
		this.utilisateurRepository=utilisateurRepository;
	}
	@Override
	public Contribuable getContribuableByid(Long id) {
		return contribuableRepository.findContribuableById(id);
	}

	@Override
	public ContribuableDto getContribuableDtoByid(Long id) {
		return new ContribuableMapper().contToContDto(contribuableRepository.findContribuableById(id));
	}

	@Override
	public Page<Contribuable> getAllContribuables(int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return contribuableRepository.findAllByOrderByIdDesc(requestedPage);
	}
	@Override
	public List<Contribuable> findAll() {
		return contribuableRepository.findAll();
	}
	@Override
	public Contribuable saveContribuable(Contribuable contribuable) {
		Contribuable cont = contribuableRepository.saveAndFlush(contribuable);
		return cont;
	}
	@Override
	public boolean isNineaExists(String ninea) {
		Contribuable contribuable = contribuableRepository.findContribuableByNinea(ninea);
		if (contribuable!=null) {
			return true;
		}
		return false;
	}
	@Override
	public List<Contribuable> findAllContribuableByNiniaContent(String ninea) {
		return contribuableRepository.findContribuableByNineaOrderByIdDesc(ninea);
	}
	@Override
	public boolean isNineaExistsDiffId(String ninea, Long id) {
		Contribuable contribuable = contribuableRepository.findContribuableByNineaAndIdNot(ninea,id);
		if (contribuable!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public Page<Contribuable> getAllContribuablesByClient(Long id,int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return contribuableRepository.findAllContribuableBycabinet_IdOrderByIdDesc(id,requestedPage);
	}
	
	
	
	@Override
	public List<Contribuable> searchContribuablesInscription(SearchInscriptionDto searchInscriptionDto) {
		// TODO Auto-generated method stub

		List<Contribuable> list =  contribuableRepository.findAllByOrderByIdDesc();

		if(searchInscriptionDto.getNinea() != null && !searchInscriptionDto.getNinea().equals("")){
			list = list.stream().filter(i -> i.getNinea().equals(searchInscriptionDto.getNinea())).collect(Collectors.toList());
		}

		if(searchInscriptionDto.getNomOuRaisonSocial() != null && !searchInscriptionDto.getNomOuRaisonSocial().equals("")){
			list = list.stream().filter(i -> i.getNomOuRaisonSocial().contains(searchInscriptionDto.getNomOuRaisonSocial())).collect(Collectors.toList());
		}

		if(searchInscriptionDto.getCentre() != null && !searchInscriptionDto.getCentre().equals("")){
			list = list.stream().filter(i -> i.getCentreServiceFiscal()!=null && i.getCentreServiceFiscal().getId().toString().equals(searchInscriptionDto.getCentre())).collect(Collectors.toList());
		}

		
		return list;
	}
	
	@Override
	public List<Utilisateur> searchIntervenantContribuable(SearchIntervenantDto searchIntervenantDto) {
		// TODO Auto-generated method stub
     
		
		
		List<Utilisateur> list =  utilisateurRepository.findAllUtilisateurByContribuable_IdNotNullOrderByIdDesc();
		
		
		//System.out.println("debut--------------->"+list.size());
		
		if(searchIntervenantDto.getNom() != null && !searchIntervenantDto.getNom().equals("")){
			list = list.stream().filter(s -> s.getNom().contains(searchIntervenantDto.getNom())).collect(Collectors.toList());
		}
		
		
		if(searchIntervenantDto.getPrenom() != null && !searchIntervenantDto.getPrenom().equals("")){
			list = list.stream().filter(s -> s.getPrenom().contains(searchIntervenantDto.getPrenom())).collect(Collectors.toList());
		}
		

		if(searchIntervenantDto.getEmail() != null && !searchIntervenantDto.getEmail().equals("")){
			list = list.stream().filter(s -> s.getEmail()!= null && s.getEmail().equals(searchIntervenantDto.getEmail())).collect(Collectors.toList());
		}
		
		
		
		
		
		return list;
	}
	@Override
	public Page<Utilisateur> findAllUtilisateursByContribuable(int page, int size) {
		// TODO Auto-generated method stub
				
		Pageable requestedPage = PageRequest.of(page, size);
		return utilisateurRepository.findAllUtilisateurByContribuable_IdNotNullOrderByIdDesc(requestedPage);
	}
	
	@Override
	public List<Contribuable> getNombreContribuablesAbonne() {
		
	List<Contribuable> list =  contribuableRepository.findAllContribuableByAbonnement(true);
		
		return list;
	}
	@Override
	public List<Contribuable> getAllContribuablesByClient(Long id) {
		// TODO Auto-generated method stub
		return contribuableRepository.findAllContribuableBycabinet_IdOrderByIdDesc(id);
	}


}

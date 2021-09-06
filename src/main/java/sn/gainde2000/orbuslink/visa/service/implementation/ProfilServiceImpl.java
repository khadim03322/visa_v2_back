package sn.gainde2000.orbuslink.visa.service.implementation;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.gainde2000.orbuslink.visa.model.Profil;
import sn.gainde2000.orbuslink.visa.repository.ProfilRepository;
import sn.gainde2000.orbuslink.visa.service.ProfilService;

@Service
public class ProfilServiceImpl implements ProfilService {
	private ProfilRepository profilRepository;
	@Autowired
	public void setRepository(
			ProfilRepository profilRepository
		)
	{
		
		this.profilRepository = profilRepository;
	}
	
	@Override
	public List<Profil> getAllProfils(){
		return profilRepository.findAll();
	}

	@Override
	public List<Profil> getAllProfilStructure() {
		Iterable<String> listProfilStructure =Arrays.asList("CA", "EX", "SUP");
		return profilRepository.findAllByCodeIn(listProfilStructure);
	}
	@Override
	public List<Profil> getAllProfilUtilisateur() {
		Iterable<String> listProfilStructure =Arrays.asList("AD", "AF", "SEL");
		return profilRepository.findAllByCodeIn(listProfilStructure);
	}
	
	@Override
	public List<Profil> getAllProfilContribuable() {
		Iterable<String> listProfilStructure =Arrays.asList("DE", "ASR");
		return profilRepository.findAllByCodeIn(listProfilStructure);
	}
}

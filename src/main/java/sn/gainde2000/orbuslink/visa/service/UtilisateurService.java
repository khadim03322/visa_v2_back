package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.web.dto.model.PasswordChangeDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;

public interface UtilisateurService {
	UtilisateurDto getUtilisateurbyEmail(String email);
	
	Page<Utilisateur> getAllUsers(int page,int size);
	
	boolean saveUser(Utilisateur utilisateur);
	
	boolean updateUser(Utilisateur utilisateur);
	
	UtilisateurDto findUtilisateurDtoById(Long id);
	
	Utilisateur findUtilisateurById(Long id);
	
	boolean isUserEmailExist(String email);
	
	Page<Utilisateur> findAllUtilisateursByContribuableId(Long id,int page, int size);
	
	Page<Utilisateur> findAllContribuablesByStructureId(Long id,int page, int size);
	
	boolean activerDesactiverUser(Long id);

	Page<Utilisateur> findAllIntervenantsCabinet(int page, int size);

	List<Utilisateur> findAllIntervenantsCabinetByCategorie(Long idcategorie);


	Boolean checkPassword(String password, Long id);

	Boolean changePassword(PasswordChangeDto passwordChangeDto, Long id);

	Utilisateur findUtilisateurByEmail(String email);

	boolean forgetPassword(Utilisateur utilisateur);

	boolean saveUserCLient(Utilisateur utilisateur);

	Utilisateur updateUtilisateur(Utilisateur utilisateur);

	List<Utilisateur> findAllUtilisateursByContribuableId(Long id);
	boolean isUserMatriculeExist(String email);

	boolean isUserMatriculeExistById(String matricule, Long id);

	

	
	
	
	
}

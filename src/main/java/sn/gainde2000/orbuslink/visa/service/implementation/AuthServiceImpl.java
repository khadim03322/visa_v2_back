package sn.gainde2000.orbuslink.visa.service.implementation;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.UtilisateurMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;
/**
 * 
 * @author MTHIAM
 *
 */
@Service
public class AuthServiceImpl implements AuthService,AuthenticationProvider {
	
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public void setRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	@Override
	public UtilisateurDto getConnectedUser() {
		// TODO Auto-generated method stub
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        String email =  authentication.getName();
	        Utilisateur user = utilisateurRepository.findUtilisateurByEmail(email);
	        return new UtilisateurMapper().toUserDto(user);
		} catch (NoResultException e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}

}

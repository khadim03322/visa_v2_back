package sn.gainde2000.orbuslink.visa.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import org.springframework.security.core.GrantedAuthority;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	private UtilisateurRepository repository;

    @Autowired
    public void setRepository(UtilisateurRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> userSearch = Optional.ofNullable(repository.findUtilisateurByEmail(username));
		return userSearch.map(utilisateur -> {
            List<GrantedAuthority> profils = new ArrayList<>();
            profils.add(new SimpleGrantedAuthority(utilisateur.getProfil().getNom()));
            return new User(username, utilisateur.getPassword(), profils);
        }).orElseThrow(() -> new UsernameNotFoundException("L'utilisateur avec l'email" + username + " n'existe pas !"));
	}

}

package sn.gainde2000.orbuslink.visa.web.controller.v2;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.expr.NewArray;
import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.MenuService;
import sn.gainde2000.orbuslink.visa.service.ProfilService;
import sn.gainde2000.orbuslink.visa.service.UtilisateurService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.ContribuableMapper;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.UtilisateurMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.InscriptionDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.LoginRequest;
import sn.gainde2000.orbuslink.visa.web.dto.model.MenuDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/users")
public class UserController {
	
	private final  UtilisateurService utilisateurService;
	private final JwtUserDetailsService userDetailsService;
	private final JwtTokenUtil jwtTokenUtil;
	private final PasswordEncoder passwordEncoder;
	private final ProfilService profilService;
	private final AuthenticationManager authenticationManager;
	private final MenuService menuService;
	private final AuthService authService;
	
	@GetMapping("/list")
	public Response<?> getAllUsers( @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size) {
		Page<Utilisateur> pages = utilisateurService.getAllUsers(page, size);
		int newSize = pages.getSize();
		Long totalElements = pages.getTotalElements();
		int totalPages = pages.getTotalPages();
		int number = pages.getNumber();
		return Response.ok().setPayload(pages.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
	}
	
	
	@PostMapping
	public Response<?> saveUser(@RequestBody Utilisateur utilisateur) {
		if (utilisateurService.isUserEmailExist(utilisateur.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		if (utilisateurService.saveUser(utilisateur))
			return Response.ok().setMessage(new String("Ajout effectué avec succes."));
		else
			return Response.badRequest().setErrors(new String("Echec ajout."));
	}
	@GetMapping(value = "/getUtilisateursById/{id}")
	public Response<?> getUtilisateurById(@PathVariable("id") Long id) {
		
		UtilisateurDto user = utilisateurService.findUtilisateurDtoById(id);
		
		if (user !=null)
			return Response.ok().setPayload(user);
		else
			return Response.badRequest();
	}
	
	@PostMapping(value = "/updateUser/{id}")
	public Response<?> updateUser(@RequestBody Utilisateur utilisateur,@PathVariable("id") Long id) {
		
		Utilisateur user = utilisateurService.findUtilisateurById(id);
		user.setPrenom(utilisateur.getPrenom());
		user.setNom(utilisateur.getNom());
		user.setTelephone(utilisateur.getTelephone()); 
		user.setMatricule(utilisateur.getMatricule());
		user.setDelagation(utilisateur.getDelagation());
		user.setSignatureKeyId(utilisateur.getSignatureKeyId());
		if (utilisateurService.saveUser(user))
			return Response.ok().setMessage(new String("Modification effectué avec succes"));
		else
			return Response.badRequest().setErrors(new String("Echec de la modification"));
	}
	@PostMapping(value = "/changePassword/{id}")
	public Response<?> changePassword(@RequestBody LoginRequest loginRequest,@PathVariable("id") Long id) {
		if (loginRequest.getNewPassword().equals(loginRequest.getOldPassword())) 
			return Response.badRequest().setErrors(new String("Votre nouveau mot de passe doit être différent de l'ancien."));
		Utilisateur user = utilisateurService.findUtilisateurById(id);
		
		if (passwordEncoder.matches(loginRequest.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(loginRequest.getNewPassword())); 
			if (utilisateurService.saveUser(user))
				return Response.ok().setMessage(new String("Modification mot de passe effectuée avec succes"));
			else
				return Response.badRequest().setErrors(new String("Echec de la modification du mot de passe"));
		}else {
			return Response.badRequest().setErrors(new String("Votre ancien mot de passe saisi est incorrect."));
		}
		
	}
	
	@PostMapping(value = "/activerDesactiverUser/{id}")
	public Response<?> activerDesactiverUser(@PathVariable("id") Long id) {
		
		if (utilisateurService.activerDesactiverUser(id))
			return Response.ok();
		else
			return Response.badRequest();
	}
	@GetMapping(value = "/getAllProfil")
	public Response<?> getAllProfil() {
		
		return Response.ok().setPayload(profilService.getAllProfils());
	}
	
	
	/*@PostMapping("/resetPassword")
	public Response<?> resetPassword(@RequestBody Utilisateur utilisateur) {
		Utilisateur user = utilisateurService.findUtilisateurById(utilisateur.getId());
		user.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		user.setFirstConnection(false);
		
		
		if (utilisateurService.updateUser(user))
			return Response.ok().setPayload(user).setMessage("Mot de passe modifié avec succès.");
		else
			return Response.badRequest().setErrors(new String("Echec réinitialisation mot de passe."));
	} */
	
	
	
	@PostMapping("/resetPassword")
	public Response<?> resetPassword(@RequestBody Utilisateur utilisateur) {
		Utilisateur user = utilisateurService.findUtilisateurById(utilisateur.getId());
		user.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		user.setFirstConnection(false);
		
		/*UserDetails userDetails = userDetailsService
				.loadUserByUsername(utilisateur.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);*/
		user= utilisateurService.updateUtilisateur(user);
		if (user!=null) {
			
			
			try {
				authenticate(user.getUsername(), utilisateur.getPassword());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(user.getUsername());

			
			List<MenuDto> menus = menuService.getMenuListByProfilID(authService.getConnectedUser().getProfil().getId()) ;
			Map<String, Object> claims = new HashMap<>();
			claims.put("menu", menus);
			claims.put("currentUser", authService.getConnectedUser());
			
			final String token = jwtTokenUtil.generateCustomToken(userDetails,claims);
            return Response.ok().setPayload(token);
			
			//return Response.ok().setPayload(user).setMessage("Mot de passe modifié avec succès.");
		
		}else
			return Response.badRequest().setErrors(new String("Echec réinitialisation mot de passe."));
	} 
	
	@PostMapping("/saveUtilisateur")
	public Response<?> saveContribuable(@RequestBody UtilisateurDto utilisateurDto) {
		Utilisateur u = new UtilisateurMapper().toUser(utilisateurDto);
		
		if (utilisateurService.isUserEmailExist(u.getEmail())) {
			return Response.duplicateEmail().setErrors(new String("Cet email existe déjà."));
		}
		if (utilisateurService.saveUser(u))
			return Response.ok().setPayload(new UtilisateurMapper().toUserDto(u)).setMessage(new String("Inscription réussie."));
		else
			return Response.badRequest();
		//return Response.ok().setPayload(u);
	}
	@GetMapping(value = "/getAllProfilUtilisateur")
	public Response<?> getAllProfilUtilisateur() {
		
		return Response.ok().setPayload(profilService.getAllProfilUtilisateur());
	}
	@PostMapping("/forgetPassword/{email}")
	public Response<?> forgetPassword(@PathVariable("email") String email) {
		if (utilisateurService.isUserEmailExist(email)) {
			Utilisateur user = utilisateurService.findUtilisateurByEmail(email);	
			if (utilisateurService.forgetPassword(user)) 
				return Response.ok().setPayload(user).setMessage("Initialisation mot de passe réussi avec succès. Veillez consultez votre compte mail.");
			
			return Response.badRequest().setErrors(new String("Echec réinitialisation mot de passe."));
			
		}
		return Response.duplicateEmail().setErrors(new String("Email incorrect."));
	} 
	
	/* @RequestMapping( value = "/utilisateurs/resetPassword" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?> resetPassword(@RequestBody Map<Object, String> input) {
	    	System.out.println(input+ "input");
	        Utilisateur u = utilisateurService.getUtilisateurObject(Long.parseLong(input.get("identifiant")));
	        Map<String, Object> model = new HashMap<>();
	        u.setPassword(passwordEncoder.encode(input.get("newPassword")));
	        u.setFirstConnection(false);
	        utilisateurService.createUtilisateur(u);
	        System.out.println("bbbbbbbbbbbbbbbbbbbb");
	        List<MenuDto> menus = menuService.getProfilById(u.getProfil().getId()) ;
	        model.put("first_connection", false);
	        model.put("user", u);
	        model.put("menu", menus);
	        model.put("notifications", "null");

	        model.put("status", "true");
	        String token = tokenProvider.createToken(u.getUsername(), this.utilisateurService.findByLogin(u.getUsername()).getRoles());
	        model.put("token", token);
	        return ResponseEntity.ok(model);
	    }*/
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
}

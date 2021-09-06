 package sn.gainde2000.orbuslink.visa.service.implementation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.model.Profil;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.ProfilRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.SimpleEmailService;
import sn.gainde2000.orbuslink.visa.service.UtilisateurService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.UtilisateurMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.PasswordChangeDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.parametersDto;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{
	
	private UtilisateurRepository utilisateurRepository;
	private ProfilRepository profilRepository;
	private JwtTokenUtil jwtTokenUtil;
	private JwtUserDetailsService userDetailsService;
	private SimpleEmailService simpleEmailService;
	private PasswordEncoder passwordEncoder;
	private AuthService authService;
	@Value("${urlApp}")
    String url ;
	
	@Autowired
	public void setRepository(UtilisateurRepository utilisateurRepository, 
			JwtTokenUtil jwtTokenUtil,
			JwtUserDetailsService userDetailsService,
			SimpleEmailService simpleEmailService,
			ProfilRepository profilRepository,
			PasswordEncoder passwordEncoder,
			AuthService authService
		)
	{
		this.utilisateurRepository = utilisateurRepository;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userDetailsService =userDetailsService;
		this.simpleEmailService = simpleEmailService;
		this.profilRepository = profilRepository;
		this.passwordEncoder = passwordEncoder;
		this.authService = authService;
	}

	@Override
	public UtilisateurDto getUtilisateurbyEmail(String email) {
		// TODO Auto-generated method stub
		// 
		return new  UtilisateurMapper().toUserDto(utilisateurRepository.findUtilisateurByEmail(email));
	}

	@Override
	public Page<Utilisateur> getAllUsers(int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		
		//return utilisateurRepository.findAllByOrderByIdDesc(requestedPage);
		Iterable<String> listProfil =Arrays.asList("AD", "AF", "SEL");
		return utilisateurRepository.findAllUtilisateurByprofil_codeInOrderByIdDesc(listProfil,requestedPage); 
		
	}

	@Override
	public boolean saveUser(Utilisateur utilisateur) {
		/*// TODO Auto-generated method stub
		Utilisateur user = utilisateurRepository.save(utilisateur);
		return user != null ? true : false;*/
		//utilisateur.setFirstConnection(true);
        //utilisateur.setPassword("$2a$10$rt9NYYq4XveHWteKHOOUOetICo5yKrXbJELK/1tM/H6diYxksRmwC");
        //utilisateur.setStatut(true);
		Profil profil = profilRepository.findById(utilisateur.getProfil().getId()).get();
		System.out.println(utilisateur.getProfil().getId()+"profil");
		/*if (profil!=null) {
			utilisateur.setProfil(profil);
		}*/
		utilisateur.setProfil(profil);
        utilisateur=utilisateurRepository.saveAndFlush(utilisateur) ;

       
        final UserDetails userDetails = userDetailsService
				.loadUserByUsername(utilisateur.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        String lien = url +"/resetpassword/"+utilisateur.getId()+"/" + token + "/" + utilisateur.getUsername();
        String lien2 = "<a href=" + lien + ">ici</a>" ;

        String objet = "Portail visa" ;


        String text = "  Bonjour, <br>\n" +
               "Votre compte d'accès à la plateforme visa a été activé avec succès.<br>\n" +
                "\n" +
                "A très bientôt sur le portail visa. "+
                "Vous pouvez cliquer " + lien2 +
                " pour vous connecter à votre compte.\n";
        
        String codeProfil=utilisateur.getProfil().getCode();
        if(codeProfil.equals("DE")) 
        {
        	
         text = "  Bonjour, <br>\n" +
                    "Votre inscription a été enregistrée avec succès.<br>\n" +
                     "Veuillez cliquer sur le lien suivant " + lien2 + ", pour personnaliser le mot de passe de votre compte.<br>"+
                     "Vous pouvez considérer votre adresse mail comme identifiant de connexion.<br> " +
                     " Vous pouvez contacter le service assistance en cas de besoin.<br> " +
                    
                    " A très bientôt sur le portail pour envoyer vos demandes de visa des états financiers de synthèse."+

                      "Merci" +"";
        }
        

        simpleEmailService.sendEmail(utilisateur.getEmail(), "Personnalisation mot de passe", text);


        return true;
	}
	/*@Override
	public boolean updateUser(Utilisateur utilisateur) {
        utilisateur=utilisateurRepository.saveAndFlush(utilisateur) ;
        if (utilisateur!=null) {
        	return true;
		}
        return false;
	}*/@Override
	public boolean forgetPassword(Utilisateur utilisateur) {

        final UserDetails userDetails = userDetailsService
				.loadUserByUsername(utilisateur.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        String lien = url +"/resetpassword/"+utilisateur.getId()+"/" + token + "/" + utilisateur.getUsername();
        String lien2 = "<a href=" + lien + ">ici</a>" ;

        String objet = "Portail visa" ;


        String text = "  Bonjour,<br>\n" +
               "Votre compte a été réinitialisé avec succès.<br>\n" +
                "\n" +
               "Veuillez cliquer "+lien2 +" ,  pour personnaliser le mot de passe et accèder à votre compte.<br>\n"+
                "A très bientôt sur le portail visa. ";

        simpleEmailService.sendEmail(utilisateur.getEmail(), "Réinitialisation mot de passe", text);


        return true;
	}

	@Override
	public boolean updateUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Utilisateur user = utilisateurRepository.saveAndFlush(utilisateur);
		return user != null ? true : false;
	}
	
	
	
	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Utilisateur user = utilisateurRepository.saveAndFlush(utilisateur);
		return user;
	}

	@Override
	public List<Utilisateur> findAllUtilisateursByContribuableId(Long id) {
		return utilisateurRepository.findAllUtilisateurByContribuable_IdOrderByIdDesc(id);
	}

	@Override
	public boolean activerDesactiverUser(Long id) {
		Utilisateur user = utilisateurRepository.findById(id).get();
		boolean oldStatut = user.isStatut();
		user.setStatut(!user.isStatut());
		Utilisateur userSave = utilisateurRepository.save(user);
		if (!oldStatut) {
	        String text = "  Bonjour,<br>\n" +
	               "Votre compte d'accès à la plateforme visa a été activé avec succès.\n" ;

	        simpleEmailService.sendEmail(userSave.getEmail(), "Activation compte", text);
		}
		else {
			String text = "  Bonjour,<br>\n" +
		               "Votre compte d'accès à la plateforme visa a été desactivé avec succès.\n" ;

		    simpleEmailService.sendEmail(userSave.getEmail(), "Desactivation compte", text);
		}
		return true;
	}



	@Override
	public UtilisateurDto findUtilisateurDtoById(Long id) {
		// TODO Auto-generated method stub
		
		Utilisateur user = utilisateurRepository.findUtilisateurById(id).orElse(null);
		
		return user != null ? new UtilisateurMapper().toUserDto(user) : null;
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findUtilisateurById(id).orElse(null);
	}
	@Override
	public Utilisateur findUtilisateurByEmail(String email) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findUtilisateurByEmail(email);
	}

	@Override
	public boolean isUserEmailExist(String email) {
		Utilisateur user = utilisateurRepository.findUtilisateurByEmail(email);
		if (user!=null) 
			return true;
		else 
			return false;
		}

	@Override
	public Page<Utilisateur> findAllUtilisateursByContribuableId(Long id,int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return utilisateurRepository.findAllUtilisateurByContribuable_IdOrderByIdDesc(id,requestedPage);
	}
	@Override
	public Page<Utilisateur> findAllContribuablesByStructureId(Long id,int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return utilisateurRepository.findAllUtilisateurByStructure_Id(id,requestedPage);
	}
	@Override
	public Page<Utilisateur> findAllIntervenantsCabinet(int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return utilisateurRepository.findAllUtilisateurByStructure_IdNotNullOrderByIdDesc(requestedPage);
	}
	@Override
	public List<Utilisateur> findAllIntervenantsCabinetByCategorie(Long idcategorie) {
		return utilisateurRepository.findAllUtilisateurByStructure_IdNotNullAndStructure_Categorie_IdOrderByNomAsc(idcategorie);
	}
	@Override
    public Boolean changePassword(PasswordChangeDto passwordChangeDto, Long id) {
       // Utilisateur utilisateur = authService.getCurrrentUser() ;
		 Utilisateur utilisateur = utilisateurRepository.findById(id).get();
        String encode = passwordEncoder.encode(passwordChangeDto.getNewPassword()) ;
        if(passwordEncoder.matches(encode, utilisateur.getPassword()) )
            return false ;
        utilisateur.setPassword(encode);
        utilisateurRepository.save(utilisateur) ;
        return true ;
    }


    @Override
    public Boolean checkPassword(String password, Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).get();
               // .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not found for this id :: "));
        System.out.println(password);
        System.out.println(utilisateur.getPassword());
        if(passwordEncoder.matches(password, utilisateur.getPassword()) )
            return true ;
        return  false;
    }
    
    
   
	/*@Override
	public Page<Utilisateur> getAllUsersByRecherche(int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		
		  //utilisateurRepository.search(keyword);
		// utilisateurRepository.findAll(where(hasAuthor(parametersDto.bookName)).and(hasTitle(parametersDto.title)));
		
	}*/
    
    
  
	@Override
	public boolean saveUserCLient(Utilisateur utilisateur) {
		
		Profil profil = profilRepository.findById(utilisateur.getProfil().getId()).get();
		System.out.println(utilisateur.getProfil().getId()+"profil");
		/*if (profil!=null) {
			utilisateur.setProfil(profil);
		}*/
		
		
		utilisateur.setProfil(profil);
        utilisateur=utilisateurRepository.saveAndFlush(utilisateur) ;

       
        final UserDetails userDetails = userDetailsService
				.loadUserByUsername(utilisateur.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        String lien = url +"/resetpassword/"+utilisateur.getId()+"/" + token + "/" + utilisateur.getUsername();
        String lien2 = "<a href=" + lien + ">ici</a>" ;

        String objet = "Portail visa" ;


        String text = "  Bonjour,<br>\n" +
               "Votre compte d'accès à la plateforme visa a été activé avec succès.<br>\n" +
                "\n" +
                "A très bientôt sur le portail visa. "+
                "Vous pouvez cliquer " + lien2 +
                " pour vous connecter à votre compte.\n";

        simpleEmailService.sendEmail(utilisateur.getEmail(), "Personnalisation mot de passe", text);

 
        return true;
	}

	@Override
	public boolean isUserMatriculeExist(String matricule) {
		
		List<Utilisateur> listuser = utilisateurRepository.findAllByMatricule(matricule);
		if (listuser.size()>0) 
			return true;
		else 
			return false;
	}

	@Override
	public boolean isUserMatriculeExistById(String matricule, Long id) {
		
		List<Utilisateur> listuser = utilisateurRepository.findAllByMatriculeAndIdNot(matricule,id);
		if (listuser.size()>0) 
			return true;
		else 
			return false;
	}

	
    
}

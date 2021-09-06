package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Utilisateur findUtilisateurByEmail(String email);

	//Paginer les utilisateurs
    Page<Utilisateur> findAll(Pageable pageable);
    
    Page<Utilisateur> findAllByOrderByIdDesc(Pageable pageable);
    
    Optional<Utilisateur> findUtilisateurById(Long id);
    
    
    Page<Utilisateur> findAllUtilisateurByContribuable_Id(Long idContribuable,Pageable pageable);
    
    Page<Utilisateur> findAllUtilisateurByStructure_Id(Long idStructure,Pageable pageable);
    
    Page<Utilisateur> findAllUtilisateurByStructure_IdNotNullOrderByIdDesc(Pageable pageable);
    
    List<Utilisateur> findAllUtilisateurByStructure_IdNotNullAndStructure_Categorie_IdOrderByNomAsc(Long idCategorie);
    
    
    Page<Utilisateur> findAllUtilisateurByprofil_codeInOrderByIdDesc(Iterable<String> listProfil,Pageable pageable);

	Page<Utilisateur> findAllUtilisateurByContribuable_IdOrderByIdDesc(Long id, Pageable requestedPage);
    List<Utilisateur> findAllUtilisateurByContribuable_IdOrderByIdDesc(Long id);

	List<Utilisateur> findAllByMatricule(String matricule);

	List<Utilisateur> findAllByMatriculeAndIdNot(String matricule, Long id);

	List<Utilisateur> findAllUtilisateurByStructure_IdNotNullOrderByIdDesc();

	//Page<Utilisateur> findAllUtilisateursByContribuable_IdNotNullOrderByIdDesc(Pageable requestedPage);

	List<Utilisateur> findAllUtilisateurByContribuable_IdNotNullOrderByIdDesc();

	Page<Utilisateur> findAllUtilisateurByContribuable_IdNotNullOrderByIdDesc(Pageable requestedPage);

	

}

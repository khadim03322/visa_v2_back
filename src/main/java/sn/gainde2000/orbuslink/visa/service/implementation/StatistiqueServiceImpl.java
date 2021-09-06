package sn.gainde2000.orbuslink.visa.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;
import sn.gainde2000.orbuslink.visa.model.InfoRejet;
import sn.gainde2000.orbuslink.visa.model.InfoVisa;
import sn.gainde2000.orbuslink.visa.model.RejetDef;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.BaremeCoutVisaRepository;
import sn.gainde2000.orbuslink.visa.repository.ContribuableCopieRepository;
import sn.gainde2000.orbuslink.visa.repository.ContribuableRepository;
import sn.gainde2000.orbuslink.visa.repository.DepotRepository;
import sn.gainde2000.orbuslink.visa.repository.InfoRejetDefRepository;
import sn.gainde2000.orbuslink.visa.repository.InfoRejetRepository;
import sn.gainde2000.orbuslink.visa.repository.InfoVisaRepository;
import sn.gainde2000.orbuslink.visa.repository.NatureFichierRepository;
import sn.gainde2000.orbuslink.visa.repository.PieceJointRepository;
import sn.gainde2000.orbuslink.visa.repository.RejetDefRepository;
import sn.gainde2000.orbuslink.visa.repository.StructureRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.StatistiqueService;
import sn.gainde2000.orbuslink.visa.web.dto.model.DataLigneTous;
import sn.gainde2000.orbuslink.visa.web.dto.model.ProfilDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.RapportCabinet;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchDepotDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchRapportDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;

@Service
@RequiredArgsConstructor
public class StatistiqueServiceImpl   implements  StatistiqueService {
	
	
	
	
	private final DepotRepository depotRepository;
	private final AuthService authService;
	
    private  final UtilisateurRepository utilisateurRepository;
    
    private  final InfoVisaRepository infoVisaRepository;
    
    private  final InfoRejetRepository infoRejetRepository;
    
    private  final InfoRejetDefRepository infoRejetDefRepository;
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Long> dashbord() {
		String annee = String.valueOf(LocalDate.now().getYear() - 1);
		Map<String, Long> results = new HashMap<String, Long>();
		/*results.put("depot", new Long(listerDepot(Depot.EEtatDepot.VS).stream().filter(d->d.getAnneeExcercice().equals(annee)).collect(Collectors.toList()).size()));
		results.put("transfert", new Long(listerDepot(Depot.EEtatDepot.EC).stream().filter(d->d.getAnneeExcercice().equals(annee)).collect(Collectors.toList()).size()));
	     results.put("rejet", new Long(listerDepot(Depot.EEtatDepot.REJ).stream().filter(d->d.getAnneeExcercice().equals(annee)).collect(Collectors.toList()).size()));
		results.put("rejetDef", new Long(listerDepot(Depot.EEtatDepot.REJDEF).stream().filter(d->d.getAnneeExcercice().equals(annee)).collect(Collectors.toList()).size()));
		*/
		return results;
	}
	
	

	@Override
	public Map<String, Long> dashbord(Long id) {
		
		String annee = String.valueOf(LocalDate.now().getYear() - 1);
		Map<String, Long> results = new HashMap<String, Long>();
		results.put("depot", new Long(listerDepotViser(id,Depot.EEtatDepot.VS).stream().filter(d->d.getCreateDateTime().getYear()==LocalDate.now().getYear()).collect(Collectors.toList()).size()));
		results.put("transfert", new Long(listerDepotEnCours(id,Depot.EEtatDepot.DE).stream().filter(d->d.getCreateDateTime().getYear()==LocalDate.now().getYear()).collect(Collectors.toList()).size()));
	     results.put("rejet", new Long(listerDepotRejet(id,Depot.EEtatDepot.REJ).stream().filter(d->d.getCreateDateTime().getYear()==LocalDate.now().getYear()).collect(Collectors.toList()).size()));
		results.put("rejetDef", new Long(listerDepotRejetDef(id,Depot.EEtatDepot.REJDEF).stream().filter(d->d.getCreateDateTime().getYear()==LocalDate.now().getYear()).collect(Collectors.toList()).size()));
		
		return results;
		
	}
	
	
	
private List<RejetDef> listerDepotRejetDef(Long id,Depot.EEtatDepot eEtatDepot) {
		
		
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
				
			List<RejetDef> list = new ArrayList<RejetDef>(); 
			
			System.out.print("user--Profil------------>"+user.getProfil().getCode());
			 
			if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
				
				System.out.print("user--AD--AF------------->"+user.getEmail());
				
				list =  infoRejetDefRepository.findAllRejetDefByDepot_EtatOrderByIdDesc(eEtatDepot);	
			}else
				if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
				  
					System.out.print("user--CA--ASS------------->"+user.getEmail());
					if(user.getStructure()!=null)
					list =  infoRejetDefRepository.findAllRejetDefByDepot_EtatAndUtilisateur_Structure_IdOrderByIdDesc(eEtatDepot,user.getStructure().getId());	
					
				}
				else
					if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
					  
						System.out.print("user--DE--ASR------------->"+user.getEmail());
						
						list =  infoRejetDefRepository.findAllRejetDefByDepot_EtatAndDepot_Contribuable_IdOrderByIdDesc(eEtatDepot,user.getContribuable().getId());	
						
					}
			
			    

			return list;
		}
	
	
	
	private List<InfoRejet> listerDepotRejet(Long id,Depot.EEtatDepot eEtatDepot) {
		
		
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
				
			List<InfoRejet> list = new ArrayList<InfoRejet>(); 
			
			System.out.print("user--Profil------------>"+user.getProfil().getCode());
			 
			if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
				
				System.out.print("user--AD--AF------------->"+user.getEmail());
				
				list =  infoRejetRepository.findAllByDepot_EtatOrderByIdDesc(eEtatDepot);	
			}else
				if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
				  
					System.out.print("user--CA--ASS------------->"+user.getEmail());
					if(user.getStructure()!=null)
					list =  infoRejetRepository.findAllByDepot_Utilisateur_Structure_Id(user.getStructure().getId());	
					
				}
				else
					if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
					  
						System.out.print("user--DE--ASR------------->"+user.getEmail());
						
						list =  infoRejetRepository.findAllByDepot_EtatAndDepot_Contribuable_IdOrderByIdDesc(eEtatDepot,user.getContribuable().getId());	
						
					}
			
			    

			return list;
		}
	
	
	
	private List<InfoVisa> listerDepotViser(Long id,Depot.EEtatDepot eEtatDepot) {
		
			
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
				
			List<InfoVisa> list = new ArrayList<InfoVisa>(); 
			
			System.out.print("user--Profil------------>"+user.getProfil().getCode());
			 
			if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
				
				System.out.print("user--AD--AF------------->"+user.getEmail());
				
				list =  infoVisaRepository.findAllInfoVisaByOrderByIdDesc();	
			}else
				if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
				  

					if(user.getStructure()!=null)
					//list =  infoVisaRepository.findAllByDepot_EtatAndUtilisateur_Structure_IdOrderByIdDesc(eEtatDepot,user.getStructure().getId());
					 // list =  infoVisaRepository.findAllByUtilisateur_Structure_IdOrderByIdDesc(user.getStructure().getId());	
					 list =  infoVisaRepository.findAllInfoVisaByDepot_Utilisateur_Structure_Id(user.getStructure().getId());	
					
				}
				else
					if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
					  
						System.out.print("user--DE--ASR------------->"+user.getEmail());
						
						list =  infoVisaRepository.findAllInfoVisaByDepot_Contribuable_IdOrderByIdDesc(user.getContribuable().getId());	
						
					}
			
			    

			return list;
		}
	
	
	private List<Depot> listerDepotEnCours(Long id,Depot.EEtatDepot eEtatDepot) {
		
			
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
				
			List<Depot> list = new ArrayList<Depot>(); 
			

			 
			if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
				

				
				list =  depotRepository.findAllDepotByEtatOrderByIdDesc(eEtatDepot);	
			}else
				if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
				  
					if(user.getStructure()!=null)
					 // list =  depotRepository.findAllByEtatAndStructure_IdOrderByIdDesc(eEtatDepot,user.getStructure().getId());	
					list =  depotRepository.findAllDepotByEtatAndStructure_Id(eEtatDepot,user.getStructure().getId());		
				}
				else
					if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
					  
						
						list =  depotRepository.findAllDepotByEtatAndContribuable_IdOrderByIdDesc(eEtatDepot,user.getContribuable().getId());	
						
					}
			
			    

			return list;
		}
	
	
	private List<Depot> listerDepot(Long id,Depot.EEtatDepot eEtatDepot) {
		
		 //UtilisateurDto currentUser = authService.getConnectedUser();
			
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
		//if(user!=null)
			
				
			List<Depot> list = new ArrayList<Depot>(); 
			
			System.out.print("user--Profil------------>"+user.getProfil().getCode());
			 
			if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
				
				System.out.print("user--AD--AF------------->"+user.getEmail());
				
				list =  depotRepository.findAllByEtatOrderByIdDesc(eEtatDepot);	
			}else
				if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
				  
					System.out.print("user--CA--ASS------------->"+user.getEmail());
					if(user.getStructure()!=null)
					list =  depotRepository.findAllByEtatAndStructure_IdOrderByIdDesc(eEtatDepot,user.getStructure().getId());	
					
				}
				else
					if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
					  
						System.out.print("user--DE--ASR------------->"+user.getEmail());
						
						list =  depotRepository.findAllByEtatAndContribuable_IdOrderByIdDesc(eEtatDepot,user.getContribuable().getId());	
						
					}
			
			    

			return list;
		}



	@Override
	public List<DataLigneTous> getNombreDepotGroupeByMois(Long id) {
		
		
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
		List<Object[]> liste=new ArrayList<>();
        
		if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
        	
			liste= infoVisaRepository.getNombreDepotGroupeByMois();
        	
        }
		else
			if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
			  
			
				if(user.getStructure()!=null)
					liste =  infoVisaRepository.getNombreDepotGroupeByMoisAndStructure(user.getStructure().getId());	
				
			}
		
			else
				if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
				  
					
					liste =  infoVisaRepository.getNombreDepotGroupeByMoisAndCnntribuable(user.getContribuable().getId());	
					
				}
		
		
		
       
        
    	List<DataLigneTous> listeDataTous= new ArrayList<>();
    	
    	List<String> mois= new ArrayList<>();
        List<Long> data= new ArrayList<>(); 
    	String annee="";
    
        if(liste != null && !liste.isEmpty()){
     
           for (Object[] object : liste) {
        	   
        	   mois.add(((String)object[2]));
             
        	   data.add(((Long)object[0]));
        	   
        	   annee= (object[3].toString());
        	   
           }
        }
           	
        listeDataTous.add(new DataLigneTous(mois,data,annee));
	       
    	
    	
    	return listeDataTous ;
	}



	@Override
	public List<Object[]> getNombreDepotGroupeBySystemComptable(Long id) {
		
		
		Utilisateur  user =  utilisateurRepository.findById(id).get();
		
		List<Object[]> liste=new ArrayList<>();
		 
		
       if(user.getProfil().getCode().equals("AD") ||  user.getProfil().getCode().equals("AF")  ||user.getProfil().getCode().equals("SEL")){
        	
			liste= infoVisaRepository.getNombreDepotGroupeBySystemComptable();
        	
        }
       else
			if(user.getProfil().getCode().equals("CA") ||  user.getProfil().getCode().equals("EX") ||  user.getProfil().getCode().equals("ASS") || user.getProfil().getCode().equals("SUP")){
			  
			
				if(user.getStructure()!=null)
					liste =  infoVisaRepository.getNombreDepotGroupeBySystemComptableAndStructure(user.getStructure().getId());	
				
			}
			else
				if(user.getProfil().getCode().equals("DE") ||  user.getProfil().getCode().equals("ASR")){
				  
					
					liste =  infoVisaRepository.getNombreDepotGroupeBySystemComptableAndCnntribuable(user.getContribuable().getId());	
					
				}
		
		
       
    	
    	return liste ;
	}



	@Override
	public List<RapportCabinet> getNombreVisabyCabinet(SearchRapportDto searchRapportDto) {
		// TODO Auto-generated method stub
		
		System.out.println(searchRapportDto.getAnneeExcercice());
		
		List<Object[]> liste=new ArrayList<>();
		
		liste= infoVisaRepository.getNombreVISAGroupeByCabinet();
		
		
		List<RapportCabinet> listeCabinet= new ArrayList<>();
		
		RapportCabinet rc;
        
        if(liste != null && !liste.isEmpty()){
     
           for (Object[] object : liste) {
        	   rc=new  RapportCabinet();
        	   rc.setNomOuRaisonSocial(object[0].toString());
        	   rc.setNombre((Long)object[1]);
        	   rc.setAnnee(object[2].toString());
        	   
        	   listeCabinet.add(rc);
        	   
        	   
        	   
           }
        }
        
        
        if(searchRapportDto.getAnneeExcercice() != null && !searchRapportDto.getAnneeExcercice().equals("")){
        	listeCabinet = listeCabinet.stream().filter(s -> s.getAnnee().equals(searchRapportDto.getAnneeExcercice())).collect(Collectors.toList());
		}
		
		
		if(searchRapportDto.getNomOuRaisonSocial() != null && !searchRapportDto.getNomOuRaisonSocial().equals("")){
			listeCabinet = listeCabinet.stream().filter(s -> s.getNomOuRaisonSocial().contains(searchRapportDto.getNomOuRaisonSocial().trim())).collect(Collectors.toList());
		}
		
		
		
		return listeCabinet;
	}



	@Override
	public List<RapportCabinet> getNombreRejetByCabinet(SearchRapportDto searchRapportDto) {
		

		
		List<Object[]> liste=new ArrayList<>();
		
		liste= infoRejetDefRepository.getNombreREJETGroupeByCabinet();
		
		
		List<RapportCabinet> listeCabinet= new ArrayList<>();
		
		RapportCabinet rc;
        
        if(liste != null && !liste.isEmpty()){
     
           for (Object[] object : liste) {
        	   rc=new  RapportCabinet();
        	   rc.setNomOuRaisonSocial(object[0].toString());
        	   rc.setNombre((Long)object[1]);
        	   rc.setAnnee(object[2].toString());
        	   
        	   listeCabinet.add(rc);
        	   
        	   
        	   
           }
        }
        
        
        if(searchRapportDto.getAnneeExcercice() != null && !searchRapportDto.getAnneeExcercice().equals("")){
        	listeCabinet = listeCabinet.stream().filter(s -> s.getAnnee().equals(searchRapportDto.getAnneeExcercice())).collect(Collectors.toList());
		}
		
		
		if(searchRapportDto.getNomOuRaisonSocial() != null && !searchRapportDto.getNomOuRaisonSocial().equals("")){
			listeCabinet = listeCabinet.stream().filter(s -> s.getNomOuRaisonSocial().contains(searchRapportDto.getNomOuRaisonSocial().trim())).collect(Collectors.toList());
		}
		
		
		
		return listeCabinet;
	}
	

}

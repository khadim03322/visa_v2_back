package sn.gainde2000.orbuslink.visa.service.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.config.NumeroGenerator;
import sn.gainde2000.orbuslink.visa.ef.ExcelVerification;
import sn.gainde2000.orbuslink.visa.ef.MccExcelReport;
import sn.gainde2000.orbuslink.visa.ef.MoteurMcc;
import sn.gainde2000.orbuslink.visa.ef.Report;
import sn.gainde2000.orbuslink.visa.ef.VerificationUploads;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Etalink;
import sn.gainde2000.orbuslink.visa.model.Etalink.EEtatDemande;
import sn.gainde2000.orbuslink.visa.model.NatureFichier;
import sn.gainde2000.orbuslink.visa.model.PieceJoint;
import sn.gainde2000.orbuslink.visa.repository.ContribuableRepository;
import sn.gainde2000.orbuslink.visa.repository.DepotRepository;
import sn.gainde2000.orbuslink.visa.repository.EtalinkRepository;
import sn.gainde2000.orbuslink.visa.repository.NatureFichierRepository;
import sn.gainde2000.orbuslink.visa.repository.PieceJointRepository;
import sn.gainde2000.orbuslink.visa.repository.StructureRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.PieceJointService;
import sn.gainde2000.orbuslink.visa.web.dto.model.DownloadDto;

@Service
@RequiredArgsConstructor
@Transactional
public class PieceJointServiceImpl implements PieceJointService {
	
	
	@Value("${pathFile}")
    String UPLOADED_FOLDER;
	@Value("${urlFolder}")
    String urlFolder;
	private final PieceJointRepository pieceJointRepository;
	private final ContribuableRepository contribuableRepository;
	private final DepotRepository depotRepository;
	private final NatureFichierRepository natureFichierRepository;
	private Report report ;
	private final EtalinkRepository etalinkRepository;
	private final AuthService authService;
	private final StructureRepository structureRepository;
	private final UtilisateurRepository utilisateurRepository;
	

	@Override
	public void storeExcel(MultipartFile multipartFile, Long id, String annee)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
    	String libelle = "_EtafiEnExcel_";
        store(multipartFile, id, annee, "EFExcel", libelle);
	}
	
	private void store(MultipartFile multipartFile, Long id, String annee, String nature, String libelle) throws IOException, InterruptedException {
        Contribuable contribuable = contribuableRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("contribuable not found"));

      
        libelle = contribuable.getNinea()+"_"+contribuable.getCofi() + libelle + annee;                                                                                                                                                                                                                                                                                    
        

        Depot depot = depotRepository.findByAnneeExcerciceAndContribuable_IdAndEtat(annee, id, Depot.EEtatDepot.EC);

        PieceJoint pieceJointe = null;
        String time = Long.toString(new Date().getTime());
        String name = time +"_" + contribuable.getNinea();
        String path = UPLOADED_FOLDER + name;
        String url = urlFolder + name;
        
        NatureFichier natureFichier = natureFichierRepository.findByLibelle(nature);

        if (depot == null) {

            depot = new Depot();
            depot.setAnneeExcercice(annee);
            depot.setContribuable(contribuable);
            depot = depotRepository.save(depot);
        } else {

            pieceJointe = pieceJointRepository.findByDepot_IdAndNatureFichier(depot.getId(), natureFichier);
        }
        if (pieceJointe != null) {

            try {
                Files.delete(Paths.get(UPLOADED_FOLDER + pieceJointe.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            pieceJointe = new PieceJoint();
        }
        
        pieceJointe.setPath(url); 
        pieceJointe.setNatureFichier(natureFichier);
        pieceJointe.setDepot(depot);
        pieceJointe.setLibelle(libelle);
        pieceJointe.setName(name);
        //pieceJointe.setStatut(contribuable.getStatut().getId().toString());
        pieceJointe.setSystemeComptable(contribuable.getSystemeComptable().getId().toString());
        //A modifier en cas de changement de statut
        pieceJointe.setStatut("31");
        byte[] bytes = multipartFile.getBytes();
        Path path2 = Paths.get(path);
        Files.write(path2, bytes);
        pieceJointRepository.save(pieceJointe);
        // genererPdfQRCodeSigner(pieceJointe.getName(),  "test") ;




    }

	@Override
	public void deleteExcel(Long id, String annee) throws IOException {
		// TODO Auto-generated method stub
		 delete(id, annee, "EFExcel");
	}
	
	private void delete(Long id, String annee, String nature) throws IOException {
        Depot depot = depotRepository.findByAnneeExcerciceAndContribuable_IdAndEtat(annee, id, Depot.EEtatDepot.EC);
        NatureFichier natureFichier = natureFichierRepository.findByLibelle(nature);
        if (depot == null) {
            throw new ResourceNotFoundException("depot not found");
        }
        PieceJoint pieceJointe = pieceJointRepository.findByDepot_IdAndNatureFichier(depot.getId(), natureFichier);
        if (pieceJointe != null) {
            Files.delete(Paths.get(UPLOADED_FOLDER + pieceJointe.getName()));
            pieceJointRepository.delete(pieceJointe);
        }
    }

	@Override
	public void storeOther(MultipartFile multipartFile, Long id, String annee)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String libelle = "_AutresFichier_";
        store(multipartFile, id, annee, "Autres", libelle);
		
	}

	@Override
	public void deleteOther(Long id, String annee) throws IOException {
		// TODO Auto-generated method stub
		delete(id, annee, "Autres");
		
	}

	@Override
	public ExcelVerification verifyExcelEtafi(Long id, String annee) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 Depot depot = depotRepository.findByAnneeExcerciceAndContribuable_IdAndEtat(annee, id, Depot.EEtatDepot.EC);
		NatureFichier natureExcel = natureFichierRepository.findByLibelle("EFExcel");

	
		if (depot == null) {
			throw new ResourceNotFoundException("not found");
		}

		
		PieceJoint pieceJointe = pieceJointRepository.findByDepot_IdAndNatureFichier(depot.getId(), natureExcel);


		
		String nameRapport = pieceJointe.getLibelle() + "_rapport_verification_excel.xlsx";
        //report = ExcelReport.verifyExcel(urlRep, pieceJointe.getName(), nameRapport);
        // ;

 

        if (pieceJointe.getSystemeComptable().equals("1")) // systeme Normal
        {

 

            report = MccExcelReport.verifyExcelSystemeNormal(UPLOADED_FOLDER, pieceJointe.getName(), nameRapport,
                    pieceJointe.getStatut());

 

        } else if (pieceJointe.getSystemeComptable().equals("3")) // systeme banque
        {

 

            report = MccExcelReport.verifyExcelBanque(UPLOADED_FOLDER, pieceJointe.getName(), nameRapport,
                    pieceJointe.getStatut());

 

        }

 

        else if (pieceJointe.getSystemeComptable().equals("4")) // Systeme assurance
        {

 

            report = MccExcelReport.verifyExcelAssurance(UPLOADED_FOLDER, pieceJointe.getName(), nameRapport,
                    pieceJointe.getStatut());

 

        }

 

        else if (pieceJointe.getSystemeComptable().equals("2")) // SMT
        {

 

            report = MccExcelReport.verifyExcelSMT(UPLOADED_FOLDER, pieceJointe.getName(), nameRapport, pieceJointe.getStatut());

 

        }

 

        ExcelVerification excelVerification = new ExcelVerification();
        List<String> positives = new ArrayList<>();
        List<String> negatives = new ArrayList<>();
        excelVerification.setPositives(positives);
        excelVerification.setNegatives(negatives);

 

//        if(report!=null&& report.isErrorExist())
//        {
//            negatives.add("Le fichier Excel des ETAFI soumis comporte des erreurs. Cf rapport");
//            excelVerification.setPathReport(urlFolder+nameRapport);
//        }
//        else if(report == null) {
//            negatives.add("Le fichier excel des ETAFI soumis est différent du modèle de la DGID ");
//
//        }
//        else {
//            positives.add("Le fichier excel est conforme");
//        }
        if (report != null && report.errorFormatExist) {

 

            // negatives.add("Le fichier excel des ETAFI soumis est différent du modèle de
            // la DGID ");

 

            if (report.listfeuillesManquantes.size() > 0) {
                
                negatives.add(
                        "Le fichier en cours de chargement n'est pas rempli en bonne et due forme. Merci de télécharger le rapport de contrôle de conformité ");
                negatives = report.listfeuillesManquantes;
                
                 excelVerification.setPathReport(urlFolder+nameRapport);
            }else {
                negatives = report.listongletsnomsModifies;
                negatives.add(
                        "Le fichier en cours de chargement n'est pas rempli en bonne et due forme. Merci de télécharger le rapport de contrôle de conformité ");
                 excelVerification.setPathReport(urlFolder+nameRapport);
            }
                
            

 

            // System.out.println(" negatives"+ negatives.toString());
            System.out.println(" negatives" + negatives.toString() + "fichier :" + urlFolder + nameRapport);

 

        } else {

 

            if (report != null && report.isErrorExist()) {
                negatives.add(
                        "Le fichier en cours de chargement n'est pas rempli en bonne et due forme. Merci de télécharger le rapport de contrôle de conformité ");
                excelVerification.setPathReport(urlFolder + nameRapport);

 

                System.out.println(" negatives" + negatives.toString() + "fichier :" + urlFolder + nameRapport);
            } else if (report == null) {
                negatives.add("Les nom de certaines rubriques ont été changés");
    
                System.out.println(" negatives" + negatives.toString());
            } else {
                positives.add("Les Etats Financiers ont été chargés avec succès");

 

                System.out.println(" positives" + positives.toString());
            }

 

        }
        return excelVerification;
	}

	@Override
	public Map<String, Object> getFile(Long id) throws IOException {
        PieceJoint pieceJointe = pieceJointRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("file not found"));
        byte[] bytes = Files.readAllBytes(Paths.get(UPLOADED_FOLDER, pieceJointe.getName()));
        Map<String, Object> result = new HashMap<>();
        String nameWithExtension = pieceJointe.getLibelle() + "." + pieceJointe.getNatureFichier().getExtension();
        result.put("name", nameWithExtension);
        result.put("file", bytes);
        return result;
    }


	public PieceJoint copy(DownloadDto downloadDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			Contribuable contribuable = contribuableRepository.findById(downloadDto.getContribuableId()).
	                orElseThrow(() -> new ResourceNotFoundException("contribuable not found"));
			 
			 
			 Etalink etalink = new Etalink();
			 etalink.setAnneeCloture("20"+downloadDto.getAnneeCloture());
			 etalink.setAnneeN1(Integer.parseInt("20"+downloadDto.getAnneeN1()));
			 etalink.setClotureDate(downloadDto.getClotureDate());
			 etalink.setClotureDerniereDate(downloadDto.getClotureDerniereDate());
			 etalink.setContribuable(contribuable);
			 etalink.setDureeN(downloadDto.getDureeN());
			 etalink.setDureeN1(downloadDto.getDureeN1());
			 
			 etalink.setNbMois(downloadDto.getNbMois());
			 etalink.setOuvertureDate(downloadDto.getOuvertureDate());
			 etalink.setOuvertureDerniereDate(downloadDto.getOuvertureDerniereDate());
			 etalink.setContribuable(contribuableRepository.findById(downloadDto.getContribuableId()).get());
			 if(!authService.getConnectedUser().getProfil().getCode().toLowerCase().equals("de")) {
				 etalink.setStructure(structureRepository.findById(authService.getConnectedUser().getStructure().getId()).orElse(null));
			 }
			 etalink.setUtilisateur(utilisateurRepository.findUtilisateurByEmail(authService.getConnectedUser().getEmail()));
			 etalinkRepository.saveAndFlush(etalink);
			 
			
			PieceJoint pieceJointe = new PieceJoint();
	        String time = Long.toString(new Date().getTime());
	        String name = time +"_Etalink_" + contribuable.getNinea()+"_annee_"+etalink.getAnneeCloture()+".xlsm";
	        
	        String libelle = contribuable.getNinea()+"_"+contribuable.getCofi() + "ETALINK_" + downloadDto.getAnneeCloture();   
	        
	        String path = UPLOADED_FOLDER + name;
	        String url = urlFolder + name;

	        
		    NatureFichier natureFichier = natureFichierRepository.findByLibelle("EtaLink");
		    
		    pieceJointe.setPath(url); 
	        pieceJointe.setNatureFichier(natureFichier);

	        pieceJointe.setLibelle(libelle);
	        pieceJointe.setName(name);
	        //pieceJointe.setStatut(contribuable.getStatut().getId().toString());
	        pieceJointe.setSystemeComptable(contribuable.getSystemeComptable().getId().toString());
	        //A modifier en cas de changement de statut
	        pieceJointe.setStatut("31");
	        pieceJointe.setEtalink(etalink);
	        
	        
	        Path path2 = Paths.get(path);
	        Files.write(path2,  Files.readAllBytes(new File(UPLOADED_FOLDER +"senetafi.xlsm").toPath()));
	        
	        pieceJointRepository.saveAndFlush(pieceJointe);
	        System.out.println(pieceJointe.getName());
		    return pieceJointe;
		} catch (Exception e) {
			// TODO: handle exception
			throw new java.lang.UnsupportedOperationException();

		}
		    
	}


	@Override
	public void storeEtafix(MultipartFile multipartFile, Long id) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Etalink etalink = etalinkRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Etalink not found"));
		
		Contribuable contribuable = contribuableRepository.findById(etalink.getContribuable().getId()).
                orElseThrow(() -> new ResourceNotFoundException("contribuable not found"));

      
		String libelle = contribuable.getNinea()+"_"+contribuable.getCofi() + "ETALINK_" + etalink.getAnneeCloture();                                                                                                                                                                                                                                                                                    
        

   

        PieceJoint pieceJointe = null;
        String time = Long.toString(new Date().getTime());
        String name = "F"+time +"_" + contribuable.getNinea()+"_annee_"+etalink.getAnneeCloture()+".xlsm";
        String path = UPLOADED_FOLDER + name;
        String url = urlFolder + name;
        
        NatureFichier natureFichier = natureFichierRepository.findByLibelle("FEtalink");

        if (etalink != null) {

        	pieceJointe = pieceJointRepository.findByEtalink_IdAndNatureFichier(etalink.getId(), natureFichier);
        } 
        
        if (pieceJointe != null) {

            try {
                Files.delete(Paths.get(UPLOADED_FOLDER + pieceJointe.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            pieceJointe = new PieceJoint();
        }
        
        pieceJointe.setPath(url); 
        pieceJointe.setNatureFichier(natureFichier);
        pieceJointe.setEtalink(etalink);
        pieceJointe.setLibelle(libelle);
        pieceJointe.setName(name);

        pieceJointe.setSystemeComptable(contribuable.getSystemeComptable().getId().toString());
        pieceJointe.setStatut("31");
        byte[] bytes = multipartFile.getBytes();
        Path path2 = Paths.get(path);
        Files.write(path2, bytes);
        pieceJointRepository.save(pieceJointe);
		
	}


	@Override
	public void removeEtafix(Long id) throws IOException {
		// TODO Auto-generated method stub
		Etalink etalink = etalinkRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Etalink not found"));
	        NatureFichier natureFichier = natureFichierRepository.findByLibelle("FEtalink");
	        if (etalink == null) {
	            throw new ResourceNotFoundException("etalink not found");
	        }
	        PieceJoint pieceJointe = pieceJointRepository.findByEtalink_IdAndNatureFichier(etalink.getId(), natureFichier);
	        if (pieceJointe != null) {
	            Files.delete(Paths.get(UPLOADED_FOLDER + pieceJointe.getName()));
	            pieceJointRepository.delete(pieceJointe);
	        }
	}

	@Override
	public PieceJoint genererEtafi(Long id) throws Exception {
		// TODO Auto-generated method stub
		Etalink etalink = etalinkRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Etalink not found"));
	    NatureFichier natureFichier = natureFichierRepository.findByLibelle("GEtalink");
	    NatureFichier fNatureFichier = natureFichierRepository.findByLibelle("FEtalink");
	    Contribuable contribuable = contribuableRepository.findById(etalink.getContribuable().getId()).
                orElseThrow(() -> new ResourceNotFoundException("contribuable not found"));
	        
		
	    PieceJoint fPieceJointe = pieceJointRepository.findByEtalink_IdAndNatureFichier(etalink.getId(), fNatureFichier);
	    
	    PieceJoint pieceJointe = new PieceJoint();
        String time = Long.toString(new Date().getTime());
        String name = time +"_Etalink_" + contribuable.getNinea()+"_annee_"+etalink.getAnneeCloture()+".xlsm";
        
        String libelle = NumeroGenerator.generateSequenceFile(etalink)+"_"+contribuable.getNinea()+ "SEN_ETAFI_" + etalink.getAnneeCloture();   
        
        String path = UPLOADED_FOLDER + name;
        String url = urlFolder + name;

        

	    
	    pieceJointe.setPath(url); 
        pieceJointe.setNatureFichier(natureFichier);

        pieceJointe.setLibelle(libelle);
        pieceJointe.setName(name);
        //pieceJointe.setStatut(contribuable.getStatut().getId().toString());
        pieceJointe.setSystemeComptable(contribuable.getSystemeComptable().getId().toString());
        //A modifier en cas de changement de statut
        pieceJointe.setStatut("31");
        pieceJointe.setEtalink(etalink);
        etalink.setEtat(EEtatDemande.GE);
        
        Path path2 = Paths.get(path);
        Files.write(path2,  Files.readAllBytes(new File(UPLOADED_FOLDER + "senetafifinal.xlsx").toPath()));
        
        pieceJointRepository.saveAndFlush(pieceJointe);
        etalinkRepository.save(etalink);
        System.out.println(pieceJointe.getName());
	    return pieceJointe;
	}
	
	
	
	
	





}

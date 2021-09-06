package sn.gainde2000.orbuslink.visa.service.implementation;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.gainde2000.orbuslink.visa.config.NumeroGenerator;
import sn.gainde2000.orbuslink.visa.exception.SignatureException;
import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.ContribuableCopie;
import sn.gainde2000.orbuslink.visa.repository.BaremeCoutVisaRepository;
import sn.gainde2000.orbuslink.visa.repository.ContribuableCopieRepository;
import sn.gainde2000.orbuslink.visa.repository.ContribuableRepository;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.NatureFichier;
import sn.gainde2000.orbuslink.visa.model.PieceJoint;
import sn.gainde2000.orbuslink.visa.model.RejetDef;
import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;
import sn.gainde2000.orbuslink.visa.model.InfoRejet;
import sn.gainde2000.orbuslink.visa.model.InfoVisa;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.DepotRepository;
import sn.gainde2000.orbuslink.visa.repository.InfoRejetRepository;
import sn.gainde2000.orbuslink.visa.repository.InfoVisaRepository;
import sn.gainde2000.orbuslink.visa.repository.NatureFichierRepository;
import sn.gainde2000.orbuslink.visa.repository.PieceJointRepository;
import sn.gainde2000.orbuslink.visa.repository.RejetDefRepository;
import sn.gainde2000.orbuslink.visa.repository.StructureRepository;
import sn.gainde2000.orbuslink.visa.repository.UtilisateurRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.DepotService;
import sn.gainde2000.orbuslink.visa.util.OrbusEmail;
import sn.gainde2000.orbuslink.visa.util.SignatureWebServiceRequester;
import sn.gainde2000.orbuslink.visa.web.dto.model.CabinetDepotDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDepot;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchDepotDto;

@Service
public class DepotServiceImpl implements DepotService {

	@Value("${URL_SIGNATURE}")
	String URL_SIGNATURE;

	@Value("${pathFile}")
	String UPLOADED_FOLDER;

	@Value("${urlFolder}")
	String urlFolder;

	@Value("${lienQrcode}")
	String lienQrCode;

	String NEWNAME = "attestation.pdf";

	private BaremeCoutVisaRepository  baremeCoutVisaRepository;
	private DepotRepository depotRepository;
	private AuthService authService;
	private ContribuableRepository contribuableRepository;
	private StructureRepository structureRepository;
	private UtilisateurRepository utilisateurRepository;
	private ContribuableCopieRepository contribuableCopieRepository;
	private NatureFichierRepository natureFichierRepository;
	private PieceJointRepository pieceJointRepository;
	private InfoVisaRepository infoVisaRepository;
	private InfoRejetRepository infoRejetRepository;
	private RejetDefRepository rejetDefRepository;


	@Autowired
	public void setRepository(BaremeCoutVisaRepository  baremeCoutVisaRepository,DepotRepository depotRepository,AuthService authService,
							  ContribuableRepository contribuableRepository,StructureRepository structureRepository,UtilisateurRepository utilisateurRepository,
							  ContribuableCopieRepository contribuableCopieRepository,NatureFichierRepository natureFichierRepository,
							  PieceJointRepository pieceJointRepository,InfoVisaRepository infoVisaRepository,
							  InfoRejetRepository infoRejetRepository,RejetDefRepository rejetDefRepository)
	{
		this.baremeCoutVisaRepository= baremeCoutVisaRepository;
		this.depotRepository = depotRepository;
		this.authService = authService;
		this.structureRepository = structureRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.contribuableRepository = contribuableRepository;
		this.contribuableCopieRepository = contribuableCopieRepository;
		this.natureFichierRepository = natureFichierRepository;
		this.pieceJointRepository= pieceJointRepository;
		this.infoVisaRepository = infoVisaRepository;
		this.infoRejetRepository = infoRejetRepository;
		this.rejetDefRepository = rejetDefRepository;
	}


	@Override
	public BaremeCoutVisa getBaremeCoutVisaByCA(Long ca) {
		// TODO Auto-generated method stub
		return baremeCoutVisaRepository.findAll().stream().filter(b -> b.getBarMax() <= ca && b.getBarMin() >= ca).findFirst().orElse(null);
	}
	@Override
	public List<BaremeCoutVisa> getAllBaremeCoutVisa() {
		// TODO Auto-generated method stub
		return baremeCoutVisaRepository.findAll();
	}

	@Override
	public Depot findDepotById(Long id) {
		return depotRepository.findById(id).get();
	}


	@Override
	public Depot saveDepot(ContribuableDepot contribuableDepot, EEtatDepot etat) {
		// TODO Auto-generated method stub
		//Utilisateur currentUser = authService.getConnectedUser();
		Contribuable contribuable = contribuableRepository.findContribuableById(contribuableDepot.getContribuable_id());
		ContribuableCopie contribuableCopie = new ModelMapper().map(contribuable, ContribuableCopie.class);
		contribuableCopie.setCon_id(null);

		Depot depot = depotRepository.findByAnneeExcerciceAndContribuable_IdAndEtat(contribuableDepot.getAnneeExcercice(),
				contribuable.getId(), Depot.EEtatDepot.EC);

		Utilisateur user = null;

		if (depot != null) {
			depot.setContribuable(contribuable);
			contribuableCopieRepository.saveAndFlush(contribuableCopie);
			depot.setContribuableCopie(contribuableCopie);
			depot.setAnneeExcercice(contribuableDepot.getAnneeExcercice());
			depot.setChiffreAffaire(contribuableDepot.getChiffreAffaire());
			depot.setEtat(etat);
			//depot.setStructure(structureRepository.findStructureById(1L));
			depot.setCapitauxPropre(contribuableDepot.getCapitauxPropre());
			depot.setResultatNet(contribuableDepot.getResultatNet());
			depot.setTotalBilan(contribuableDepot.getTotalBilan());
			depot.setTotalProduit(contribuableDepot.getTotalProduit());
			depot.setTotalTtc(contribuableDepot.getTotalTtc());
			depot.setNbPages(contribuableDepot.getNbPages());
			depot.setUtilisateur(utilisateurRepository.findById(contribuableDepot.getTraitant_id()).get());
			Depot lastDep = depotRepository.findTopByOrderByIdDesc();
			depot.setNumero(NumeroGenerator.generateCodeArticle(lastDep));
			user = utilisateurRepository.findById(contribuableDepot.getTraitant_id()).get();
			depot.setStructure(structureRepository.findStructureById(user.getStructure().getId()));
			depot.setUtilisateurReceive(user);

			if(depotRepository.save(depot) != null){
				// debut envoie des email de notification

				String text = "Bonjour," + "<br/>"
						+
						"Une demande de délivrance du visa des états financiers annuels de synthèse vous a été confiée par l'entité "
						+ contribuable.getNomOuRaisonSocial()+ ".<br/>"
						+ "Vous pouvez vous connecter avec votre compte pour consulter en détail et procéder au traitement . <br/>"
						+ "Vous pouvez contacter le service assistance en cas de besoin. Merci nous avoir fait confiance.<br/>";

				user.getStructure().getUtilisateurs().forEach(u -> OrbusEmail.sendHtmlMessage("Confirmation demande",text,u.getEmail()));

				return depot;
			}


		}


		return null;

	}


	@Override
	public Page<Depot> getAllDepotByAuthUser(Long Id, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		return depotRepository.findAllByContribuable_IdAndEtatNotAndEtatNotOrderByIdDesc(Id, Depot.EEtatDepot.EC,Depot.EEtatDepot.BR,requestedPage);

	}


	@Override
	public List<Depot> searchContribuabledepots(Long Id, SearchDepotDto searchDepotDto) {
		// TODO Auto-generated method stub

		List<Depot> list =  depotRepository.findAllByContribuable_IdAndEtatNotAndEtatNotOrderByIdDesc(Id,EEtatDepot.BR,EEtatDepot.EC);

		if(searchDepotDto.getAnneeExcercice() != null && !searchDepotDto.getAnneeExcercice().equals("")){
			list = list.stream().filter(d -> d.getAnneeExcercice().equals(searchDepotDto.getAnneeExcercice())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNomOuRaisonSocial() != null && !searchDepotDto.getNomOuRaisonSocial().equals("")){
			list = list.stream().filter(d -> d.getContribuableCopie().getNomOuRaisonSocial().contains(searchDepotDto.getNomOuRaisonSocial())).collect(Collectors.toList());
		}

		if(searchDepotDto.getEtat() != null && !searchDepotDto.getEtat().equals("")){
			list = list.stream().filter(d -> d.getEtat().toString().equals(searchDepotDto.getEtat())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNumero() != null && !searchDepotDto.getNumero().equals("")){
			list = list.stream().filter(d -> d.getNumero().contains(searchDepotDto.getNumero())).collect(Collectors.toList());
		}

		return list;
	}


	@Override
	public Page<Depot> getAllDepotByStructureId(Long Id, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		return depotRepository.findAllByEtatNotAndEtatNotAndStructure_IdOrderByIdDesc(Depot.EEtatDepot.EC,Depot.EEtatDepot.BR, Id, requestedPage);
	}


	@Override
	public Depot saveDepotCabinet(CabinetDepotDto cabnetDepot, EEtatDepot etat) {
		// TODO Auto-generated method stub

		Contribuable contribuable = contribuableRepository.findContribuableById(cabnetDepot.getContribuable_id());
		ContribuableCopie contribuableCopie = new ModelMapper().map(contribuable, ContribuableCopie.class);
		contribuableCopie.setCon_id(null);

		Depot depot = depotRepository.findByAnneeExcerciceAndContribuable_IdAndEtat(cabnetDepot.getAnneeExcercice(),
				contribuable.getId(), Depot.EEtatDepot.EC);

		if (depot != null) {
			depot.setContribuable(contribuable);
			contribuableCopieRepository.saveAndFlush(contribuableCopie);
			depot.setContribuableCopie(contribuableCopie);
			depot.setAnneeExcercice(cabnetDepot.getAnneeExcercice());
			depot.setChiffreAffaire(cabnetDepot.getChiffreAffaire());
			depot.setEtat(etat);
			depot.setStructure(structureRepository.findStructureById(cabnetDepot.getStructure()));
			depot.setCapitauxPropre(cabnetDepot.getCapitauxPropre());
			depot.setResultatNet(cabnetDepot.getResultatNet());
			depot.setTotalBilan(cabnetDepot.getTotalBilan());
			depot.setTotalProduit(cabnetDepot.getTotalProduit());
			depot.setTotalTtc(cabnetDepot.getTotalTtc());
			depot.setNbPages(cabnetDepot.getNbPages());
			depot.setUtilisateurReceive(utilisateurRepository.findById(cabnetDepot.getTraitant_id()).get());
			depot.setUtilisateur(utilisateurRepository.findById(cabnetDepot.getTraitant_id()).get());
			Depot lastDep = depotRepository.findTopByOrderByIdDesc();
			depot.setNumero(NumeroGenerator.generateCodeArticle(lastDep));

			if(depotRepository.save(depot) != null){
				// debut envoie des email de notification

				String text = "Bonjour," + "<br/>"
						+
						"Une demande de délivrance du visa des états financiers annuels de synthèse vous a été confiée par l'entité "
						+ contribuable.getNomOuRaisonSocial()+ ".<br/>"
						+ "Vous pouvez vous connecter avec votre compte pour consulter en détail et procéder au traitement . <br/>"
						+ "Vous pouvez contacter le service assistance en cas de besoin.<br/>Merci de nous avoir fait confiance.<br/>";

				String text2 = "Bonjour," + "<br/>"
						+
						"La demande de visa des états financiers annuels de synthèse de l'entité "
						+ contribuable.getNomOuRaisonSocial()+ " a été confiée au cabinet "+depot.getUtilisateurReceive().getStructure().getNomOuRaisonSocial()+".<br/>"
						+ "Vous pouvez vous connecter avec votre compte pour  suivre l'état d'avancement du traitement. <br/>"
						+ "Vous pouvez contacter le service assistance en cas de besoin.<br/>Merci de nous avoir fait confiance.<br/>";

				depot.getUtilisateur().getStructure().getUtilisateurs().forEach(u -> OrbusEmail.sendHtmlMessage("Nouvelle demande demande",text,u.getEmail()));
				utilisateurRepository.findAllUtilisateurByContribuable_IdOrderByIdDesc(depot.getContribuable().getId())
						.forEach(u -> OrbusEmail.sendHtmlMessage("Nouvelle demande demande",text2,u.getEmail()));
				return depot;
			}

		}


		return null;
	}


	@Override
	public Page<Depot> getAllDepotBrouillonsByStructureId(Long Id, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		return depotRepository.findAllByEtatAndStructure_IdOrderByIdDesc(Depot.EEtatDepot.BR, Id, requestedPage);
	}


	@Override
	public boolean changeStatutDepot(Long Id, EEtatDepot etat) {
		// TODO Auto-generated method stub
		Depot depot = depotRepository.findById(Id).get();
		depot.setEtat(etat);

		try {
			depotRepository.save(depot);

			if(etat == EEtatDepot.REJ){
				String text = "Bonjour," + "<br/>"
						+
						"Une demande de délivrance du visa des états financiers annuels de synthèse vous a été confiée par l'entité "
						+ depot.getContribuableCopie().getNomOuRaisonSocial()+ " pour l'exercice "+depot.getAnneeExcercice()+" a été rejetée par le professionnel membre de l'ONECCA "+ depot.getUtilisateurTraitant().getEmail()+".<br/>"
						+ "Vous pouvez vous envoyer une nouvelle demande. <br/>"
						+ "Vous pouvez contacter le service assistance en cas de besoin.<br/>"
						+ "Merci de nous avoir fait confiance.<br/>";

				utilisateurRepository.findAllUtilisateurByContribuable_IdOrderByIdDesc(depot.getContribuable().getId())
						.forEach(u -> OrbusEmail.sendHtmlMessage("Rejet demande VISA",text,u.getEmail()));
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}



	@Override
	public String signerDocumentAttestation(Long idDepot, int nbrPage, String codePin, String typeMission, int choixSignature) throws SignatureException {
		// TODO Auto-generated method stub

		String result2 = null;
		String result = null;
		try {
			//Viser le depot
			//Generer l'attestation visé et l'insérer dans la base de données
			Depot demande = depotRepository.findById(idDepot).get();
			System.out.println(utilisateurRepository.findAllUtilisateurByContribuable_IdOrderByIdDesc(demande.getContribuable().getId()).size()+"------------------");
			String time = Long.toString(new Date().getTime());
			String nomFichierSigne ="attestation_Signee_"+demande.getContribuableCopie().getNinea()+"_"+time+".pdf";

			String name = time +"_" + demande.getContribuableCopie().getNinea();
			String url = urlFolder + name;

			result = SignatureWebServiceRequester.signerDocumentAttestation(demande, nomFichierSigne, UPLOADED_FOLDER, demande.getNbPages(), demande.getUtilisateur(), codePin, typeMission, choixSignature, URL_SIGNATURE,NEWNAME);

			if(!result.equals("success")) {
				return result;
			}


			Utilisateur traitant = utilisateurRepository.findById(authService.getConnectedUser().getId()).get();
			demande.setUtilisateurTraitant(traitant);
			demande.setEtat(EEtatDepot.VS);
			InfoVisa info = new InfoVisa();
			info.setLibelle("Demande: "+demande.getNumero()+ "visé par "+traitant.getPrenom()+" "+traitant.getNom()+"("+demande.getStructure().getNomOuRaisonSocial()+")");
			info.setUtilisateur(traitant);
			info.setDepot(demande);
			infoVisaRepository.save(info);
			depotRepository.saveAndFlush(demande);





			//Convertir l'ETAFI en PDF et l'insérer dans la base de données
			NatureFichier natureFichier = natureFichierRepository.findByLibelle("VISA");
			PieceJoint pieceJointe = new PieceJoint();


			pieceJointe.setPath(url);
			pieceJointe.setNatureFichier(natureFichier);
			pieceJointe.setDepot(demande);
			pieceJointe.setLibelle(nomFichierSigne);
			pieceJointe.setName(nomFichierSigne);
			//pieceJointe.setStatut(contribuable.getStatut().getId().toString());
			pieceJointe.setSystemeComptable(demande.getContribuableCopie().getSystemeComptable().getId().toString());
			//A modifier en cas de changement de statut
			pieceJointe.setStatut("31");

			pieceJointRepository.save(pieceJointe);

			result2 = signerDocumentPdfQRCodeFromExcel(idDepot,demande.getUtilisateur(),lienQrCode,codePin);


			if(!result2.equals("success")) {
				return result2;
			}

			String text = "Bonjour," + "<br/>"
					+
					"Une demande de délivrance du visa des états financiers annuels de synthèse vous a été confiée par l'entité "
					+ demande.getContribuableCopie().getNomOuRaisonSocial()+ " pour l'exercice "+demande.getAnneeExcercice()+" a été visée par le professionnel membre de l'ONECCA "+ demande.getUtilisateurTraitant().getEmail()+".<br/>"
					+ "Vous pouvez vous connecter au portail pour consulter et télécharger l'attestation de visa. <br/>"
					+ "Vous pouvez contacter le service assistance en cas de besoin.<br/>"
					+ "Merci de nous avoir fait confiance.<br/>";

			utilisateurRepository.findAllUtilisateurByContribuable_IdOrderByIdDesc(demande.getContribuable().getId())
					.forEach(u -> OrbusEmail.sendHtmlMessage("Attestation VISA",text,u.getEmail()));
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}


	@Override
	public String signerDocumentPdfQRCodeFromExcel(Long idDepot, Utilisateur utilisateur, String lienQrCode,
												   String codePin) throws SignatureException {
		// TODO Auto-generated method stub
		String result = null;
		try {
			Depot demande = depotRepository.findById(idDepot).get();
			String time = Long.toString(new Date().getTime());
			String nomFichierSigne ="EFPDF_Signee_"+demande.getContribuableCopie().getNinea()+"_"+time+".pdf";

			String nameFile = demande.getPiecesJointes().stream().filter(p -> p.getNatureFichier().getLibelle().equals("EFExcel")).findFirst().get().getName();

			NatureFichier natureFichier = natureFichierRepository.findByLibelle("EFPDF");
			PieceJoint pieceJointe = new PieceJoint();


			pieceJointe.setPath(urlFolder + nomFichierSigne);
			pieceJointe.setNatureFichier(natureFichier);
			pieceJointe.setDepot(demande);
			pieceJointe.setLibelle(nomFichierSigne);
			pieceJointe.setName(nomFichierSigne);
			//pieceJointe.setStatut(contribuable.getStatut().getId().toString());
			pieceJointe.setSystemeComptable(demande.getContribuableCopie().getSystemeComptable().getId().toString());
			//A modifier en cas de changement de statut
			pieceJointe.setStatut("31");
			pieceJointRepository.save(pieceJointe);


			result = SignatureWebServiceRequester.signerDocumentPdfQRCodeFromExcel(nameFile,demande, demande.getUtilisateur(),UPLOADED_FOLDER,lienQrCode, codePin,nomFichierSigne, URL_SIGNATURE,NEWNAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Depot> searchStructureDepots(Long Id, SearchDepotDto searchDepotDto) {
		List<Depot> list = depotRepository.findAllByStructure_Id(Id);

		if(searchDepotDto.getAnneeExcercice() != null && !searchDepotDto.getAnneeExcercice().equals("")){
			list = list.stream().filter(d -> d.getAnneeExcercice().equals(searchDepotDto.getAnneeExcercice())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNomOuRaisonSocial() != null && !searchDepotDto.getNomOuRaisonSocial().equals("")){
			list = list.stream().filter(d -> d.getContribuableCopie().getNomOuRaisonSocial().contains(searchDepotDto.getNomOuRaisonSocial())).collect(Collectors.toList());
		}

		if(searchDepotDto.getEtat() != null && !searchDepotDto.getEtat().toString().equals("") && !searchDepotDto.getEtat().toString().equals("NONE")){
			list = list.stream().filter(d -> d.getEtat().toString().equals(searchDepotDto.getEtat())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNumero() != null && !searchDepotDto.getNumero().equals("")){
			list = list.stream().filter(d -> d.getNumero().contains(searchDepotDto.getNumero())).collect(Collectors.toList());
		}



		return list;

	}

	@Override
	public List<Depot> searchStructureBrouillon(Long Id, SearchDepotDto searchDepotDto) {
		List<Depot> list = depotRepository.findAllByEtatAndStructure_IdOrderByIdDesc(Depot.EEtatDepot.BR, Id);

		if(searchDepotDto.getAnneeExcercice() != null && !searchDepotDto.getAnneeExcercice().equals("")){
			list = list.stream().filter(d -> d.getAnneeExcercice().equals(searchDepotDto.getAnneeExcercice())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNomOuRaisonSocial() != null && !searchDepotDto.getNomOuRaisonSocial().equals("")){
			list = list.stream().filter(d -> d.getContribuableCopie().getNomOuRaisonSocial().contains(searchDepotDto.getNomOuRaisonSocial())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNumero() != null && !searchDepotDto.getNumero().equals("")){
			list = list.stream().filter(d -> d.getNumero().contains(searchDepotDto.getNumero())).collect(Collectors.toList());
		}

		return list;
	}

	@Override
	public List<Depot> searchAdminDepots(SearchDepotDto searchDepotDto) {
		List<Depot> list = depotRepository.findAllByEtatNotAndEtatNotAndEtatNotOrderByIdDesc(Depot.EEtatDepot.EC,Depot.EEtatDepot.BR, EEtatDepot.DE);

		if(searchDepotDto.getAnneeExcercice() != null && !searchDepotDto.getAnneeExcercice().equals("")){
			list = list.stream().filter(d -> d.getAnneeExcercice().equals(searchDepotDto.getAnneeExcercice())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNomOuRaisonSocial() != null && !searchDepotDto.getNomOuRaisonSocial().equals("")){
			list = list.stream().filter(d -> d.getContribuableCopie().getNomOuRaisonSocial().contains(searchDepotDto.getNomOuRaisonSocial())).collect(Collectors.toList());
		}

		if(searchDepotDto.getEtat() != null && !searchDepotDto.getEtat().toString().equals("") && !searchDepotDto.getEtat().toString().equals("NONE")){
			System.out.println(searchDepotDto.getEtat()+"------------------- ETAT");
			list = list.stream().filter(d -> d.getEtat().toString().equals(searchDepotDto.getEtat())).collect(Collectors.toList());
		}

		if(searchDepotDto.getNumero() != null && !searchDepotDto.getNumero().equals("")){
			list = list.stream().filter(d -> d.getNumero().contains(searchDepotDto.getNumero())).collect(Collectors.toList());
		}



		return list;
	}

	@Override
	public Page<Depot> getAllDepotAdmin(int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return depotRepository.findAllByEtatNotAndEtatNotAndEtatNotOrderByIdDesc(Depot.EEtatDepot.EC,Depot.EEtatDepot.BR, EEtatDepot.DE,requestedPage);
	}


	@Transactional
	@Override
	public boolean rejetDepot(Long Id) {
		// TODO Auto-generated method stub
		try {
			Depot depot = depotRepository.findById(Id).get();
			depot.setEtat(EEtatDepot.REJ);
			depotRepository.save(depot);
			Utilisateur traitant = utilisateurRepository.findById(authService.getConnectedUser().getId()).get();
			InfoRejet info = new InfoRejet();
			info.setDepot(depot);
			info.setLibelle("Rejet du dépôt: "+depot.getNumero()+" par "+authService.getConnectedUser().getFullName()+"("+traitant.getStructure().getNomOuRaisonSocial()+")");
			info.setUtilisateur(traitant);
			infoRejetRepository.save(info);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}


	@Override
	public boolean rejetDefinitifDepot(Long Id) {
		// TODO Auto-generated method stub
		try {
			Depot depot = depotRepository.findById(Id).get();
			depot.setEtat(EEtatDepot.REJDEF);
			depotRepository.save(depot);
			Utilisateur traitant = utilisateurRepository.findById(authService.getConnectedUser().getId()).get();
			RejetDef info= new RejetDef();
			info.setDepot(depot);
			info.setLibelle("Rejet définitif du dépôt: "+depot.getNumero()+" par "+authService.getConnectedUser().getFullName()+"("+traitant.getStructure().getNomOuRaisonSocial()+")");
			info.setUtilisateur(traitant);
			rejetDefRepository.save(info);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}




}

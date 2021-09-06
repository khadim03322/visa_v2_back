package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import sn.gainde2000.orbuslink.visa.exception.SignatureException;
import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;
import sn.gainde2000.orbuslink.visa.model.Depot;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.web.dto.model.CabinetDepotDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDepot;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchDepotDto;

public interface DepotService {

	BaremeCoutVisa getBaremeCoutVisaByCA(Long ca);

	List<BaremeCoutVisa> getAllBaremeCoutVisa();

	Depot findDepotById(Long id);

	//Sauvegarder dépot ou valider dépot contribuable, c'est le même processus
	//c'est seulement le statut qui change
	Depot saveDepot(ContribuableDepot contribuableDepot,Depot.EEtatDepot etat);

	//Sauvegarder dépot ou valider dépot contribuable, c'est le même processus
	//c'est seulement le statut qui change
	Depot saveDepotCabinet(CabinetDepotDto cabnetDepot,Depot.EEtatDepot etat);

	Page<Depot> getAllDepotByAuthUser(Long Id,int page,int size);
	List<Depot> searchContribuabledepots(Long Id,SearchDepotDto searchDepotDto);
	Page<Depot> getAllDepotByStructureId(Long Id,int page,int size);
	Page<Depot> getAllDepotBrouillonsByStructureId(Long Id,int page,int size);

	boolean changeStatutDepot(Long Id, Depot.EEtatDepot etat);
	boolean rejetDepot(Long Id);
	boolean rejetDefinitifDepot(Long Id);

	String signerDocumentAttestation(Long idDepot, int nbrPage, String codePin, String typeMission, int choixSignature) throws SignatureException;
	String signerDocumentPdfQRCodeFromExcel(Long idDepot, Utilisateur utilisateur,String lienQrCode, String codePin) throws SignatureException;
	List<Depot> searchStructureDepots(Long Id,SearchDepotDto searchDepotDto);
	List<Depot> searchStructureBrouillon(Long Id,SearchDepotDto searchDepotDto);
	List<Depot> searchAdminDepots(SearchDepotDto searchDepotDto);
	Page<Depot> getAllDepotAdmin(int page,int size);
}

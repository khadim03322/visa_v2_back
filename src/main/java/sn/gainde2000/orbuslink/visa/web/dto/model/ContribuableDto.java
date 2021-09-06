package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import sn.gainde2000.orbuslink.visa.model.ActivitePrincipale;
import sn.gainde2000.orbuslink.visa.model.Associe;
import sn.gainde2000.orbuslink.visa.model.CentreServiceFiscal;
import sn.gainde2000.orbuslink.visa.model.Fonction;
import sn.gainde2000.orbuslink.visa.model.FormeJuridique;
import sn.gainde2000.orbuslink.visa.model.Localite;
import sn.gainde2000.orbuslink.visa.model.RegimeImposition;
import sn.gainde2000.orbuslink.visa.model.SystemeComptable;
import sn.gainde2000.orbuslink.visa.model.TypeEntite;
import sn.gainde2000.orbuslink.visa.model.TypeStructure;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
//exclure les propriétés ayant des valeurs nulles / vides ou par défaut.
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContribuableDto {
	
	private Long id;
	private String nomOuRaisonSocial;
	private String cofi;
	private String ninea;
	private String sigle;
	private String telephone;
	private String adresseComplete;
	private String responsableMorale;
	private ActivitePrincipale activitePrincipale;
	private RegimeImposition regimeImposition;
	private TypeEntite typeEntite;
	private SystemeComptable systemeComptable;
	private TypeStructure typeStructure;
	private Fonction fonction;
	private CentreServiceFiscal centreServiceFiscal;
	private Localite localite;
	private FormeJuridique formeJuridique;
	private Associe associe;
	private boolean abonnement;
	//private UtilisateurDto utilisateur;
	//private List<Utilisateur> utilisateurs;
	
	

}

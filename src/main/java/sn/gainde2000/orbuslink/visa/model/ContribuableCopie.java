package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "td_contribuable_copie")
public class ContribuableCopie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="con_id")
	private Long con_id;
	@Column(name="con_nom_ou_raison_social")
	private String nomOuRaisonSocial;
	@Column(name="con_cofi")
	private String cofi;
	@Column(name="con_ninea")
	private String ninea;
	@Column(name="con_sigle")
	private String sigle;
	@Column(name="con_telephone")
	private String telephone;
	@Column(name="con_adresse_complete")
	private String adresseComplete;
	@Column(name="con_responsable_morale")
	private String responsableMorale;
	@CreationTimestamp
    private LocalDateTime createDateTime;
	 @ManyToOne
	 @JoinColumn(name="con_acP_id")
	 private ActivitePrincipale activitePrincipale;
	 @ManyToOne
	 @JoinColumn(name="con_reI_id")
	 private RegimeImposition regimeImposition;
	 @ManyToOne
	 @JoinColumn(name="con_tyE_id")
	 private TypeEntite typeEntite;
	 @ManyToOne
	 @JoinColumn(name="con_syC_id")
	 private SystemeComptable systemeComptable;
	 @ManyToOne
	 @JoinColumn(name="con_tyS_id")
	 private TypeStructure typeStructure;
	 @ManyToOne
	 @JoinColumn(name="con_fon_id")
	 private Fonction fonction;
	 @ManyToOne
	 @JoinColumn(name="con_ass_id")
	 private Associe associe;
	 @ManyToOne
	 @JoinColumn(name="con_csf_id")
	 private CentreServiceFiscal centreServiceFiscal;
	 @ManyToOne
	 @JoinColumn(name="con_loc_id")
	 private Localite localite;
	 @ManyToOne
	 @JoinColumn(name="con_str_id",nullable = true)
	 private Structure cabinet;
	 
	 
	
}

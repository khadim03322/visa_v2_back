package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "td_depot")
public class Depot implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dep_id")
	private Long id;
	@Column(name="dep_capitauxPropre")
	private Double capitauxPropre;
	@Column(name="dep_resultatNet")
	private Double resultatNet;
	@Column(name="dep_ca")
	private Double chiffreAffaire;
	@Column(name="dep_totalProduit")
	private Double totalProduit;
	@Column(name="dep_totalBilan")
	private Double totalBilan;
	@Column(name="dep_totalTtc")
	private Double totalTtc;
	@Column(name="dep_numero")
	private String numero;
	@Column(name="dep_anneeExcercice")
	private String anneeExcercice;
	@Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "varchar(6) default 'EC'")
    private EEtatDepot etat = EEtatDepot.EC;
	@Transient
    private String etatLibelle;
	@ManyToOne(optional = true)
	@JoinColumn(name="dep_str_id")
	private Structure structure;
	@ManyToOne
	@JoinColumn(name="dep_con_id")
	private Contribuable contribuable;
	@ManyToOne
	@JoinColumn(name="dep_cco_id")
	private ContribuableCopie contribuableCopie;
	@CreationTimestamp
	private LocalDateTime dep_DateSoumission;
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@ManyToOne(optional = true)
	@JoinColumn(name="dep_uti_id")
	private Utilisateur utilisateur ;
	@ManyToOne
	@JoinColumn(name="dep_uti_receive_id")
	private Utilisateur utilisateurReceive;
	@ManyToOne
	@JoinColumn(name="dep_uti_traitant_id")
	private Utilisateur utilisateurTraitant;
	@OneToMany(mappedBy = "depot")
	private List<PieceJoint> piecesJointes;

    @javax.persistence.Transient
    private String dateString;

	@Column(name="dep_nb_pages",columnDefinition = "integer default '0'")
	private int nbPages;




	
	
	@PostLoad
    private void postLoad() {
        this.dateString = createDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        switch (this.etat) {
		case BR:
			this.etatLibelle = "Brouillon";
			break;
		case DE:
			this.etatLibelle = "En attente de visa";
			break;
		case REJ:
			this.etatLibelle = "Rejetée ";
			break;
		case REJDEF:
			this.etatLibelle = "Rejetée";
			break;
		case VS:
			this.etatLibelle = "Visée";
			break;
		case EC:
			this.etatLibelle = "En cours";
			break;
		default:
			break;
		}
    }
	

	
	public enum EEtatDepot {
        EC, // en cour de dépot
        DE, //Déposé
        REJDEF, // rejet definitif
        VS, //viser,
        RE,// retirer
        REJ,//rejter
        BR,//Brouillon
		NONE
    }

}

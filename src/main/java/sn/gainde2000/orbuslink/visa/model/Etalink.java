package sn.gainde2000.orbuslink.visa.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "td_etalink")
public class Etalink implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="eta_id")
    private Long id;
    @Column(name="eta_date_ouverture")
    private Date ouvertureDate;
    @Column(name="eta_date_cloture")
    private Date clotureDate;
    @Column(name="eta_derniere_date_ouverture")
    private Date ouvertureDerniereDate;
    @Column(name="eta_derniere_date_cloture")
    private Date clotureDerniereDate;
    @Column(name="eta_duree_n")
    private int dureeN;
    @Column(name="eta_dureen1")
    private int dureeN1;
    @Column(name="eta_annee_cloture_exercice")
    private String anneeCloture;
    @Column(name="eta_annee_n1")
    private int anneeN1;
    @Column(name="eta_nb_mois")
    private int nbMois;

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "varchar(6) default 'EC'")
    private EEtatDemande etat= EEtatDemande.EC;

    @Transient
    private String etatLibelle;
    
    @Transient
    private String denominationSociale;
    
    @Transient
    private String ninea;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="eta_str_id",nullable = true)
    private Structure structure;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="eta_uti_id",nullable = true)
    private Utilisateur utilisateur;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="eta_con_id",nullable = true)
    private Contribuable contribuable;

    @CreationTimestamp
    private LocalDateTime createDateTime;
    
    @OneToMany(mappedBy = "etalink")
	private List<PieceJoint> piecesJointes;


    public enum EEtatDemande {
        EC, // en cour
        GE, //Généré
        AN, // Annulé
        DE, // Supprimer
    }

    @PostLoad
    private void postLoad() {
    	this.denominationSociale = this.contribuable.getNomOuRaisonSocial();
    	this.ninea = this.contribuable.getNinea();
        switch (this.etat) {
            case EC:
                this.etatLibelle = "En cours";
                break;
            case GE:
                this.etatLibelle = "Etafi généré";
                break;
            case AN:
                this.etatLibelle = "Demande annulé";
                break;
            default:
                break;
        }
    }
}

package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "td_structure")
public class Structure implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="str_id")
	private Long id;
	@Column(name="str_nom_ou_raison_social")
	private String nomOuRaisonSocial;
	@Column(name="str_adresse")
	private String adresse;
	@Column(name="str_numero_rccm",unique = true)
	private String rccm;
	@Column(name="str_ninea", unique = true)
	private String ninea;
	@Column(name="str_fax")
	private String fax;
	@Column(name="str_telephone")
	private String telephone;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "structure")
	@JsonIgnore
	@ToString.Exclude
	private List<Utilisateur> utilisateurs;
	@ManyToOne
	@JoinColumn(name="str_cat_id")
	private Categorie categorie;
	@ManyToOne
	@JoinColumn(name="str_qsi_id")
	private QualiteSignature qualiteSignature;
	 @ManyToOne
	 @JoinColumn(name="str_ass_id")
	 private Associe associe;
	 @Column(name="str_abonnement",nullable = false, columnDefinition = "bit default 0")
	 private boolean abonnement;

}

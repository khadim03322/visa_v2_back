package sn.gainde2000.orbuslink.visa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import sn.gainde2000.orbuslink.visa.util.CustomCheminSerializer;

@Data
@Entity
@Table(name = "td_piece_joint")
public class PieceJoint {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="pij_id")
	    private Long id;
	    @Column(name="pij_libelle")
	    private String libelle;
	    @Column(name="pij_libelleLastUpdate")
	    private String libelleLastUpdate;
	    @Column(name="pij_path")
	    private String path ;
	    @Column(name="pij_pathLastUpdate")
	    private String pathLastUpdate;
	    @Column(name="pij_typeFichier")
	    private String typeFichier;
	    @Column(name="pij_syc_id")
	    private String systemeComptable ;
	    @Column(name="pij_statut")
	    private String statut;
	    @JsonSerialize(using = CustomCheminSerializer.class)
	    @Column(name="pij_name")
	    private String name;
	    @JsonSerialize(using = CustomCheminSerializer.class)
	    @Column(name="pij_nameLastUpdate")
	    private String nameLastUpdate;
	    
	    
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name="pij_depot")
	    private Depot depot ;
	    

	    
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name="pij_etalink")
	    private Etalink etalink ;

	    public String getPath() {
	        return name;
	    }

	    @ManyToOne
	    @JoinColumn(name="pij_nature_fichier")
	    private NatureFichier natureFichier ;
	    
	    
	    public String getNineaPath() {
	        return path;
	    }
	}

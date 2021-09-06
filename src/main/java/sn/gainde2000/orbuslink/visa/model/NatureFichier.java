package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "tp_nature_fichier")
public class NatureFichier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="naf_id")
    private Long id;
	@Column(name="naf_libelle")
    private String libelle ;
	@Column(name="naf_icone")
    private String icone ;
	@Column(name="naf_extension")
    private String extension;
}
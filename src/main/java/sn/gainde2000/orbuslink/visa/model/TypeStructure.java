package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tp_type_structure")
public class TypeStructure implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tys_id")
    private Long id;
	@Column(name="tys_libelle")
	private String libelle;
	@Lob
	@Column(name="tys_description")
	private String description;
	@Column(name="tys_seuil")
	private float seuil;

}

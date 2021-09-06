package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tp_type_entite")

public class TypeEntite implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tye_id")
    private Long id; 
	@Column(name="tye_libelle")
    private String libelle;
	@Column(name="tye_limite")
    private float limite;
}

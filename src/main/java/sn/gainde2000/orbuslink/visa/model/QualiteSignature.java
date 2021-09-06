package sn.gainde2000.orbuslink.visa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "tp_qualite_signature")
public class QualiteSignature {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="qsi_id")
    private Long id;
	@Column(name="qsi_libelle")
	private String libelle;
}

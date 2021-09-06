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
@Table(name = "td_numero_sequence_depot")
public class NumeroSequenceDepot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nsd_id")
    private Long id;
	@Column(name="nsd_annee")
	private Long annee;
	@Column(name="nsd_numero")
    private Long numero;

}

package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
@Entity
@Table(name = "tp_bareme_cout_visa")
public class BaremeCoutVisa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bar_id")
	private Long id;
	@Column(name="bar_min")
	private Double barMin;
	@Column(name="bar_max")
	private Double barMax;
	@Column(name="bar_montant")
	private Double barMontant;
	@Column(name = "bar_date_debut_validite", columnDefinition = "DATE")
	private LocalDate barDateDebutValidite;
	@Column(name = "bar_date_fin_validite", columnDefinition = "DATE")
	private LocalDate barDateFinValidite;
	@ManyToOne(optional = true)
	@JoinColumn(name="bar_str_id", nullable = true)
	@JsonIgnore
	private Structure structure;
    

}

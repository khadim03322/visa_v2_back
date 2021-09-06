package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name = "td_info_visa")
public class InfoVisa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="inv_id")
    private Long id;
	@Column(name="inv_libelle")
    private String libelle;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @ManyToOne
    @JoinColumn(name="inv_uti_id")
    private Utilisateur utilisateur ;

    @OneToOne
    //@JsonIgnore
    private Depot depot ;
    @Transient
    private String dateString;

    @PostLoad
    private void postLoad() {
        this.dateString = createDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}


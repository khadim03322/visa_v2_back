package sn.gainde2000.orbuslink.visa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
@Table(name = "td_rejet_def")
public class RejetDef implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="red_id")
    private Long id;
	@Column(name="red_libelle")
    private String libelle;
    @ManyToOne
    @JoinColumn(name="red_uti_id")
    private Utilisateur utilisateur ;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="red_dep_id")
    private Depot depot ;
    @CreationTimestamp
    private LocalDateTime createDateTime;

}

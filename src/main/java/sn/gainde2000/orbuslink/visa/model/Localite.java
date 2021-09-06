package sn.gainde2000.orbuslink.visa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tp_localite")
@Data
public class Localite implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loc_id")
    private Long id; 
	@Column(name="loc_libelle")
    private String libelle;
	//@ManyToMany(mappedBy = "localite")
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "tr_centreServiceFiscal_localite",
        joinColumns = @JoinColumn(name = "id_localite", referencedColumnName = "loc_id"),
        inverseJoinColumns = @JoinColumn(name = "id_centre_service_fiscal", referencedColumnName = "csf_id"))
	@JsonIgnoreProperties({"localite"})
	private List <CentreServiceFiscal> centreServiceFiscal;
    
    
    
    

}

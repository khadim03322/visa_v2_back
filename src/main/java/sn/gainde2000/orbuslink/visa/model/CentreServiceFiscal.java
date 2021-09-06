package sn.gainde2000.orbuslink.visa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="tp_centre_service_fiscal")


public class CentreServiceFiscal implements Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="csf_id")
    private Long id;
	@Column(name="csf_libelle")
    private String libelle;
   
    
    //@JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "tr_centreServiceFiscal_localite",
        joinColumns = @JoinColumn(name = "id_centre_service_fiscal", referencedColumnName = "csf_id"),
        inverseJoinColumns = @JoinColumn(name = "id_localite", referencedColumnName = "loc_id"))
    @JsonIgnoreProperties({"centreServiceFiscal"})
    private List <Localite> localite;
    


}

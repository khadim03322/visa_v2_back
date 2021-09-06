package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import sn.gainde2000.orbuslink.visa.model.Associe;
import sn.gainde2000.orbuslink.visa.model.Categorie;
import sn.gainde2000.orbuslink.visa.model.QualiteSignature;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
//exclure les propriétés ayant des valeurs nulles / vides ou par défaut.
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StructureDto {
	private Long id;
	private String nomOuRaisonSocial;
	private String adresse;
	private String ninea;
	private String fax;
	private String rccm;
	private QualiteSignature qualiteSignature;
	private String telephone;
	private Categorie categorie;
    private Associe associe;
    private boolean abonnement;
}

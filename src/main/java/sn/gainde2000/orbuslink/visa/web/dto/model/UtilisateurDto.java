package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Profil;
import sn.gainde2000.orbuslink.visa.model.Structure;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
//exclure les propriétés ayant des valeurs nulles / vides ou par défaut.
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UtilisateurDto {
    private Long id;
    private String prenom;
    private String nom;
    private String telephone;
    private String email;
    private boolean statut;
    private boolean abonnement;
    private LocalDateTime dateAbonnement;
    private boolean firstConnection;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private ProfilDto profil;
    private ContribuableDto contribuable;
    private StructureDto structure;
    private String matricule;
    private String signatureKeyId;
    private String delagation;
    private String signatureKeyIdProf;
    private String delagationProf;
    public String getFullName() {
        return prenom != null ? prenom.concat(" ").concat(nom) : "";
    }
}

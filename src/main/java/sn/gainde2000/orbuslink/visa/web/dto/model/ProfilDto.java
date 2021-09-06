package sn.gainde2000.orbuslink.visa.web.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 
 * @author MTHIAM
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
//'exclure les propriétés ayant des valeurs nulles / vides ou par défaut.
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfilDto {
	private Long id;
    private String nom;
    private String code;
    private String domaine;

}

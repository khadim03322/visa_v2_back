package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import sn.gainde2000.orbuslink.visa.model.Categorie;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString
//exclure les propriétés ayant des valeurs nulles / vides ou par défaut.
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailsStructureDto {
	private StructureDto structureDto;
	private List<UtilisateurDto> utilisateurDtos;

}

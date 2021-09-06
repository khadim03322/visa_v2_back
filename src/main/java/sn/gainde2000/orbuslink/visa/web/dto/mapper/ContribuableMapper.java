package sn.gainde2000.orbuslink.visa.web.dto.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import sn.gainde2000.orbuslink.visa.model.Contribuable;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.web.dto.model.ContribuableDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;

@Component
public class ContribuableMapper {
	
	public ContribuableDto contToContDto(Contribuable contribuable) {
		return new ModelMapper().map(contribuable, ContribuableDto.class);
	}
	public Contribuable contDtoToCont(ContribuableDto contribuableDto) {
		return new ModelMapper().map(contribuableDto, Contribuable.class);
	}
	public  List<ContribuableDto> contribuablesTocontribuablesDTOs(List<Contribuable> contribuables) {
        return contribuables.stream()
            .filter(Objects::nonNull)
            .map(this::contToContDto)
            .collect(Collectors.toList());
    }
	
	public  List<Contribuable> contribuablesDtoTocontribuables(List<ContribuableDto> contribuablesDtos) {
        return contribuablesDtos.stream()
            .filter(Objects::nonNull)
            .map(this::contDtoToCont)
            .collect(Collectors.toList());
    }
}

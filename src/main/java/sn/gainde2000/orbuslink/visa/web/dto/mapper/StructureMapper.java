package sn.gainde2000.orbuslink.visa.web.dto.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import sn.gainde2000.orbuslink.visa.model.Structure;
import sn.gainde2000.orbuslink.visa.web.dto.model.StructureDto;

@Component
public class StructureMapper {
	
	public StructureDto structureToStructuretDto(Structure structure) {
		return new ModelMapper().map(structure, StructureDto.class);
	}
	public Structure structuresDtoToStructures(StructureDto StructureDto) {
		return new ModelMapper().map(StructureDto, Structure.class);
	}
	public  List<StructureDto> structuresTostructuresDTOs(List<Structure> structures) {
        return structures.stream()
            .filter(Objects::nonNull)
            .map(this::structureToStructuretDto)
            .collect(Collectors.toList());
    }
	
	public  List<Structure> structuresDtoTostructures(List<StructureDto> structuresDtos) {
        return structuresDtos.stream()
            .filter(Objects::nonNull)
            .map(this::structuresDtoToStructures)
            .collect(Collectors.toList());
    }

}

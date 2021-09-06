package sn.gainde2000.orbuslink.visa.web.dto.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;
import sn.gainde2000.orbuslink.visa.web.dto.model.BaremeCoutVisaDto;

@Component
public class BaremeCoutVisaMapper {
	
	public BaremeCoutVisaDto BaremeCoutVisaToBaremeCoutVisatDto(BaremeCoutVisa BaremeCoutVisa) {
		return new ModelMapper().map(BaremeCoutVisa, BaremeCoutVisaDto.class);
	}
	public BaremeCoutVisa BaremeCoutVisasDtoToBaremeCoutVisas(BaremeCoutVisaDto BaremeCoutVisaDto) {
		return new ModelMapper().map(BaremeCoutVisaDto, BaremeCoutVisa.class);
	}
	public  List<BaremeCoutVisaDto> BaremeCoutVisasToBaremeCoutVisasDTOs(List<BaremeCoutVisa> BaremeCoutVisas) {
        return BaremeCoutVisas.stream()
            .filter(Objects::nonNull)
            .map(this::BaremeCoutVisaToBaremeCoutVisatDto)
            .collect(Collectors.toList());
    }
	
	public  List<BaremeCoutVisa> BaremeCoutVisasDtoToBaremeCoutVisas(List<BaremeCoutVisaDto> BaremeCoutVisasDtos) {
        return BaremeCoutVisasDtos.stream()
            .filter(Objects::nonNull)
            .map(this::BaremeCoutVisasDtoToBaremeCoutVisas)
            .collect(Collectors.toList());
    }

}

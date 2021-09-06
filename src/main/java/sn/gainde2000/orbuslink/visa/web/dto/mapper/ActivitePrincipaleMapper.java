package sn.gainde2000.orbuslink.visa.web.dto.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import sn.gainde2000.orbuslink.visa.model.ActivitePrincipale;
import sn.gainde2000.orbuslink.visa.web.dto.model.ActivitePrincipaleDto;

@Component
public class ActivitePrincipaleMapper {
	
	public ActivitePrincipaleDto activitePrincipaleToActivitePrincipaletDto(ActivitePrincipale ActivitePrincipale) {
		return new ModelMapper().map(ActivitePrincipale, ActivitePrincipaleDto.class);
	}
	public ActivitePrincipale activitePrincipalesDtoToActivitePrincipales(ActivitePrincipaleDto ActivitePrincipaleDto) {
		return new ModelMapper().map(ActivitePrincipaleDto, ActivitePrincipale.class);
	}
	public  List<ActivitePrincipaleDto> activitePrincipalesToActivitePrincipalesDTOs(List<ActivitePrincipale> ActivitePrincipales) {
        return ActivitePrincipales.stream()
            .filter(Objects::nonNull)
            .map(this::activitePrincipaleToActivitePrincipaletDto)
            .collect(Collectors.toList());
    }
	
	public  List<ActivitePrincipale> activitePrincipalesDtoToActivitePrincipales(List<ActivitePrincipaleDto> ActivitePrincipalesDtos) {
        return ActivitePrincipalesDtos.stream()
            .filter(Objects::nonNull)
            .map(this::activitePrincipalesDtoToActivitePrincipales)
            .collect(Collectors.toList());
    }

}

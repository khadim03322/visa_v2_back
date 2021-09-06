package sn.gainde2000.orbuslink.visa.web.dto.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.web.dto.model.ProfilDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;

/**
 * 
 * @author MTHIAM
 *
 */
@Component
public class UtilisateurMapper {
	public  UtilisateurDto toUserDto(Utilisateur user) {
        
		return new ModelMapper().map(user, UtilisateurDto.class);
                
    }
	public  Utilisateur toUser(UtilisateurDto user) {
        return new ModelMapper().map(user, Utilisateur.class);
               
    }
	
	
	public  List<UtilisateurDto> usersToUserDTOs(List<Utilisateur> users) {
        return users.stream()
            .filter(Objects::nonNull)
            .map(this::toUserDto)
            .collect(Collectors.toList());
    }
	
	public  List<Utilisateur> usersDtoToUsers(List<UtilisateurDto> usersDtos) {
        return usersDtos.stream()
            .filter(Objects::nonNull)
            .map(this::toUser)
            .collect(Collectors.toList());
    }
	
}

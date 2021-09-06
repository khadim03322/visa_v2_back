package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.model.Menu;
import sn.gainde2000.orbuslink.visa.model.Utilisateur;
import sn.gainde2000.orbuslink.visa.repository.MenuRepository;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.MenuService;
import sn.gainde2000.orbuslink.visa.web.dto.mapper.MenuMapper;
import sn.gainde2000.orbuslink.visa.web.dto.model.MenuDto;
import sn.gainde2000.orbuslink.visa.web.dto.model.UtilisateurDto;

import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author MTHIAM
 *
 */

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
	
	private final MenuRepository menuRepository;
	private final AuthService authService;


	@Override
	public List<MenuDto> getMenuListByProfilID(Long idprofil) throws NoResultException {
		// TODO Auto-generated method stub
		List<Menu> menus = menuRepository.findMenuByProfilOrderByPriorite(idprofil) ;
	       // find Parent
	        Predicate<Menu> profile0 = menu -> menu.getParent_id() == 0;
	        List<Menu>  parents = menus.stream().filter(profile0)
	                .collect(Collectors.toList());
	        
	        
	        List<MenuDto> parentsDtos = new ArrayList<>() ;
	        parents.forEach(menu -> {
	           //
	            MenuDto tmp1 = MenuMapper.toMenuDto(menu);
	            UtilisateurDto uti = authService.getConnectedUser();
	            
	            if(tmp1.getId() == 69L) {
                	if(uti.getProfil().getCode().toLowerCase().equals("de")) {

                    	if(uti.getContribuable().isAbonnement())
                        {
                    		 parentsDtos.add(tmp1) ;
                        }
                    }
                }else if(tmp1.getId() == 70L) {
                	if(uti.getStructure() != null && uti.getProfil().getCode().toLowerCase().equals("ca")) {
                		
                    	if(uti.getStructure().isAbonnement())
                        {
                    		 parentsDtos.add(tmp1) ;
                        }
                    }
                }else if(tmp1.getId() == 71L) {
                	if(uti.getStructure() != null && uti.getProfil().getCode().toLowerCase().equals("ex")) {
                		
                    	if(uti.getStructure().isAbonnement())
                        {
                    		 parentsDtos.add(tmp1) ;
                        }
                    }
                }else {
                	 parentsDtos.add(tmp1) ;
                }	            
	           
	        });
	        
	        parentsDtos.forEach(menuDto -> {
	            menus.forEach(menu -> {
	                if(menu.getParent_id() == menuDto.getId()) {
	                    MenuDto dto = MenuMapper.toMenuDto(menu) ;
	                    menuDto.getEnfants().add(dto) ;
	                }
	            });
	        });
	        return parentsDtos ;

	}

}

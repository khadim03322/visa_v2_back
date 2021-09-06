package sn.gainde2000.orbuslink.visa.web.dto.mapper;

import org.springframework.stereotype.Component;
import sn.gainde2000.orbuslink.visa.model.Menu;
import sn.gainde2000.orbuslink.visa.web.dto.model.MenuDto;


/**
 * 
 * @author MTHIAM
 *
 */

@Component
public class MenuMapper {
	
	public static MenuDto toMenuDto(Menu menu) {
        return new MenuDto()
        		.setId(menu.getId())
        		.setLibelle(menu.getLibelle())
        		.setCode(menu.getCode())
        		.setIcon(menu.getIcon())
        		.setRoute(menu.getRoute())
        		.setParent_id(menu.getParent_id())
        		.setPriorite(menu.getPriorite());
                
    }

}

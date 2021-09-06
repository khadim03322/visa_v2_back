package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * 
 * @author MTHIAM
 *
 */
@Data
@AllArgsConstructor
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private List<MenuDto> menu;
}

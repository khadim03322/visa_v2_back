package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sn.gainde2000.orbuslink.visa.config.JwtTokenUtil;
import sn.gainde2000.orbuslink.visa.service.AuthService;
import sn.gainde2000.orbuslink.visa.service.JwtUserDetailsService;
import sn.gainde2000.orbuslink.visa.service.MenuService;
import sn.gainde2000.orbuslink.visa.web.dto.model.JwtResponse;
import sn.gainde2000.orbuslink.visa.web.dto.model.LoginRequest;
import sn.gainde2000.orbuslink.visa.web.dto.model.MenuDto;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;
/**
 * 
 * @author MTHIAM
 *
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/v2/auth")
public class AuthenticationController {
	
	private AuthenticationManager authenticationManager;
	private JwtTokenUtil jwtTokenUtil;
	private JwtUserDetailsService userDetailsService;
	private MenuService menuService;
	private AuthService authService;
	
	@Autowired
	public AuthenticationController(
			AuthenticationManager authenticationManager,
			JwtTokenUtil jwtTokenUtil,
			JwtUserDetailsService userDetailsService,
			MenuService menuService,
			AuthService authService
			) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil =jwtTokenUtil;
		this.userDetailsService = userDetailsService;
		this.menuService = menuService;
		this.authService = authService;
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Response<?> authenticate(@RequestBody LoginRequest authenticationRequest, HttpServletResponse response) throws Exception {

		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());

			List<MenuDto> menus = menuService.getMenuListByProfilID(authService.getConnectedUser().getProfil().getId());
			
			Map<String, Object> claims = new HashMap<>();
			claims.put("menu", menus);
			claims.put("currentUser", authService.getConnectedUser());
			
			final String token = jwtTokenUtil.generateCustomToken(userDetails,claims);
            return Response.ok().setPayload(token);
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            return Response.unauthorized().setErrors(Collections.singletonMap("AuthenticationException", e.getLocalizedMessage()));
        }
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	


}

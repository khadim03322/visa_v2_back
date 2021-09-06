package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import javax.persistence.NoResultException;

import sn.gainde2000.orbuslink.visa.web.dto.model.MenuDto;

public interface MenuService {
	List<MenuDto> getMenuListByProfilID(Long idprofil)throws NoResultException;
}

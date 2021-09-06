package sn.gainde2000.orbuslink.visa.service;

import java.util.List;

import sn.gainde2000.orbuslink.visa.model.Profil;

public interface ProfilService {
	public List<Profil> getAllProfils();
	public List<Profil>  getAllProfilStructure();
	List<Profil> getAllProfilUtilisateur();
	List<Profil> getAllProfilContribuable();

}

package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.Categorie;
import sn.gainde2000.orbuslink.visa.repository.CategorieRepository;
import sn.gainde2000.orbuslink.visa.repository.TypeEntiteRepository;
import sn.gainde2000.orbuslink.visa.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
	
   private CategorieRepository categorieRepository;
	
	
	@Autowired
	public void setRepository(CategorieRepository categorieRepository
			
		)
	{
		this.categorieRepository = categorieRepository;
	}
	@Override
	public List<Categorie> getAllCategorie() {
		
		return categorieRepository.findAll();
	}

}

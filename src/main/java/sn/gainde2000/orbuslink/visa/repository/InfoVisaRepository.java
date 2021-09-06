package sn.gainde2000.orbuslink.visa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.gainde2000.orbuslink.visa.model.Depot.EEtatDepot;
import sn.gainde2000.orbuslink.visa.model.InfoVisa;
import sn.gainde2000.orbuslink.visa.web.dto.model.SearchRapportDto;

@Repository
public interface InfoVisaRepository extends JpaRepository<InfoVisa, Long> {
    InfoVisa findByDepot_Id(Long id);

	List<InfoVisa> findAllByDepot_EtatOrderByIdDesc(EEtatDepot eEtatDepot);

	List<InfoVisa> findAllByDepot_EtatAndUtilisateur_Structure_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<InfoVisa> findAllByDepot_EtatAndDepot_Contribuable_IdOrderByIdDesc(EEtatDepot eEtatDepot, Long id);

	List<InfoVisa> findAllByUtilisateur_Structure_IdOrderByIdDesc(Long id);

	List<InfoVisa> findAllByOrderByIdDesc();

	List<InfoVisa> findAllByDepot_Contribuable_IdOrderByIdDesc(Long id);

	List<InfoVisa> findAllByUtilisateur_Structure_Id(Long id);

	List<InfoVisa> findAllByDepot_Utilisateur_Structure_Id(Long id);

	
	
	
	@Query(value="SELECT COUNT(*), MONTH(createDateTime), "
			/*+ " 'février' as libelle "*/
			+ "CASE MONTH(createDateTime)"
	  		+ "         WHEN 1 THEN 'janvier'"
	  		+ "         WHEN 2 THEN 'février'"
	  		+ "         WHEN 3 THEN 'mars'"
	  		+ "         WHEN 4 THEN 'avril'"
	  		+ "         WHEN 5 THEN 'mai'"
	  		+ "         WHEN 6 THEN 'juin'"
	  		+ "         WHEN 7 THEN 'juillet'"
	  		+ "         WHEN 8 THEN 'août'"
	  		+ "         WHEN 9 THEN 'septembre'"
	  		+ "         WHEN 10 THEN 'octobre'"
	  		+ "         WHEN 11 THEN 'novembre'"
	  		+ "         ELSE 'décembre' "
	  		+ " END as libelle "
	  		+ ",YEAR(createDateTime) FROM InfoVisa   "
	  		+ " WHERE   YEAR(createDateTime)=YEAR(NOW())"
	  		+ " "
	  		+ " GROUP BY   MONTH(createDateTime) , "
	  		+ " CASE MONTH(createDateTime) WHEN 1 THEN 'janvier' WHEN 2 THEN 'février'  WHEN 3 THEN 'mars' WHEN 4 THEN 'avril' WHEN 5 THEN 'mai'  WHEN 6 THEN 'juin'"
	  		+ " WHEN 7 THEN 'juillet' WHEN 8 THEN 'août' WHEN 9 THEN 'septembre' WHEN 10 THEN 'octobre'WHEN 11 THEN 'novembre' ELSE 'décembre' END ,"
	  		+ " YEAR(createDateTime) ORDER BY MONTH(createDateTime) ")
	 	List<Object[]> getNombreDepotGroupeByMois();

	 	
	 
	 	@Query(value="SELECT COUNT(*), MONTH(createDateTime), CASE MONTH(createDateTime)"
		  		+ "         WHEN 1 THEN 'janvier'"
		  		+ "         WHEN 2 THEN 'février'"
		  		+ "         WHEN 3 THEN 'mars'"
		  		+ "         WHEN 4 THEN 'avril'"
		  		+ "         WHEN 5 THEN 'mai'"
		  		+ "         WHEN 6 THEN 'juin'"
		  		+ "         WHEN 7 THEN 'juillet'"
		  		+ "         WHEN 8 THEN 'août'"
		  		+ "         WHEN 9 THEN 'septembre'"
		  		+ "         WHEN 10 THEN 'octobre'"
		  		+ "         WHEN 11 THEN 'novembre'"
		  		+ "         ELSE 'décembre' "
		  		+ " END AS libelle ,YEAR(createDateTime) FROM InfoVisa  "
		  		+ " WHERE  YEAR(createDateTime)=YEAR(NOW()) AND depot.utilisateur.structure.id =:idStructure "
		  		+ " "
		  		+ " GROUP BY  MONTH(createDateTime) ,"
		  		+ " CASE MONTH(createDateTime) WHEN 1 THEN 'janvier' WHEN 2 THEN 'février'  WHEN 3 THEN 'mars' WHEN 4 THEN 'avril' WHEN 5 THEN 'mai'  WHEN 6 THEN 'juin'"
		  		+ " WHEN 7 THEN 'juillet' WHEN 8 THEN 'août' WHEN 9 THEN 'septembre' WHEN 10 THEN 'octobre'WHEN 11 THEN 'novembre' ELSE 'décembre' END ,"
		  	
		  		+ " YEAR(createDateTime) ORDER BY MONTH(createDateTime)  ")
	   List<Object[]> getNombreDepotGroupeByMoisAndStructure(@Param("idStructure") Long idStructure);

	   
	   
	   @Query(value="SELECT COUNT(*), MONTH(createDateTime), CASE MONTH(createDateTime)"
		  		+ "         WHEN 1 THEN 'janvier'"
		  		+ "         WHEN 2 THEN 'février'"
		  		+ "         WHEN 3 THEN 'mars'"
		  		+ "         WHEN 4 THEN 'avril'"
		  		+ "         WHEN 5 THEN 'mai'"
		  		+ "         WHEN 6 THEN 'juin'"
		  		+ "         WHEN 7 THEN 'juillet'"
		  		+ "         WHEN 8 THEN 'août'"
		  		+ "         WHEN 9 THEN 'septembre'"
		  		+ "         WHEN 10 THEN 'octobre'"
		  		+ "         WHEN 11 THEN 'novembre'"
		  		+ "         ELSE 'décembre' "
		  		+ " END AS libelle  ,YEAR(createDateTime) FROM InfoVisa  "
		  		+ " WHERE  YEAR(createDateTime)=YEAR(NOW()) AND depot.contribuable.id =:idContribuable "
		  		+ " "
		  		+ " GROUP BY  MONTH(createDateTime) ,"
		  		+ " CASE MONTH(createDateTime) WHEN 1 THEN 'janvier' WHEN 2 THEN 'février'  WHEN 3 THEN 'mars' WHEN 4 THEN 'avril' WHEN 5 THEN 'mai'  WHEN 6 THEN 'juin'"
		  		+ " WHEN 7 THEN 'juillet' WHEN 8 THEN 'août' WHEN 9 THEN 'septembre' WHEN 10 THEN 'octobre'WHEN 11 THEN 'novembre' ELSE 'décembre' END ,"
		  	
		  		+ " YEAR(createDateTime) ORDER BY MONTH(createDateTime)  ")
		List<Object[]> getNombreDepotGroupeByMoisAndCnntribuable(@Param("idContribuable") Long idContribuable);

		
		

		@Query(value="SELECT concat( A.depot.contribuable.systemeComptable.libelle,' [',COUNT(*),'] '),COUNT(*)  "
		  		+ " FROM InfoVisa A  "
		  
		  		+ " WHERE YEAR(A.createDateTime)=YEAR(NOW())"
		  		+ " "
		  		+ " GROUP BY  A.depot.contribuable.systemeComptable.libelle ORDER BY A.depot.contribuable.systemeComptable.libelle  ")
	List<Object[]> getNombreDepotGroupeBySystemComptable();

	
	
	
	@Query(value="SELECT concat( A.depot.contribuable.systemeComptable.libelle,' [',COUNT(*),'] '),COUNT(*)  "
	  		+ " FROM InfoVisa A  "
	  		+ " "
	  		+ " WHERE YEAR(A.createDateTime)=YEAR(NOW())  AND A.depot.utilisateur.structure.id =:idStructure   "
	  		+ " "
	  		+ " GROUP BY  A.depot.contribuable.systemeComptable.libelle ORDER BY A.depot.contribuable.systemeComptable.libelle  ")
		List<Object[]> getNombreDepotGroupeBySystemComptableAndStructure(@Param("idStructure") Long idStructure);

		
		
		@Query(value="SELECT concat( A.depot.contribuable.systemeComptable.libelle,' [',COUNT(*),'] '),COUNT(*)  "
		  		+ " FROM InfoVisa A  "
		  		+ "  "
		  		+ " WHERE YEAR(A.createDateTime)=YEAR(NOW())  AND A.depot.contribuable.id =:idContribuable    "
		  		+ " "
		  		+ " GROUP BY  A.depot.contribuable.systemeComptable.libelle ORDER BY A.depot.contribuable.systemeComptable.libelle  ")
	List<Object[]> getNombreDepotGroupeBySystemComptableAndCnntribuable(@Param("idContribuable") Long idContribuable);

	
	@Query(value="SELECT  A.depot.utilisateur.structure.nomOuRaisonSocial , COUNT(*) as nombre ,YEAR(A.createDateTime) as annee "
	  		+ " FROM InfoVisa A  "
	  		+ " GROUP BY  A.depot.utilisateur.structure.nomOuRaisonSocial,YEAR(A.createDateTime) ORDER BY A.depot.utilisateur.structure.nomOuRaisonSocial  ")
	
	List<Object[]> getNombreVISAGroupeByCabinet();

	List<InfoVisa> findAllInfoVisaByOrderByIdDesc();

	List<InfoVisa> findAllInfoVisaByDepot_Utilisateur_Structure_Id(Long id);

	List<InfoVisa> findAllInfoVisaByDepot_Contribuable_IdOrderByIdDesc(Long id);

		

	
}

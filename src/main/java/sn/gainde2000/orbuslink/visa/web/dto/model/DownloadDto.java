package sn.gainde2000.orbuslink.visa.web.dto.model;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class DownloadDto {
	
	@Column(name="eta_date_ouverture")
    private Date ouvertureDate;
    @Column(name="eta_date_cloture")
    private Date clotureDate;
    @Column(name="eta_derniere_date_ouverture")
    private Date ouvertureDerniereDate;
    @Column(name="eta_derniere_date_cloture")
    private Date clotureDerniereDate;
    @Column(name="eta_duree_n")
    private int dureeN;
    @Column(name="eta_dureen1")
    private int dureeN1;
    @Column(name="eta_annee_cloture_exercice")
    private String anneeCloture;
    @Column(name="eta_annee_n1")
    private int anneeN1;
    @Column(name="eta_nb_mois")
    private int nbMois;
    private Long contribuableId;
}

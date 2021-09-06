package sn.gainde2000.orbuslink.visa.web.dto.model;

import lombok.Data;

@Data
public class CabinetDepotDto {
	private Double capitauxPropre;
	private Double resultatNet;
	private Double chiffreAffaire;
	private Double totalProduit;
	private Double totalBilan;
	private Double totalTtc;
	private String anneeExcercice;
	private Long traitant_id;
	private Long contribuable_id;
	private Long structure;
	private int nbPages;
}

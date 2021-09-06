package sn.gainde2000.orbuslink.visa.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
/**
 * 
 * @author MTHIAM
 *
 */
@Data
@Entity
@Table(name = "tp_menu_item")
public class Menu implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 410357248812085729L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    private String libelle;
    @Size(max = 10)
    private String code;
    @Size(max = 100)
    private String icon;
    @Size(max = 150)
    private String route;
    private long parent_id;
    private long priorite;
    private Long profil;

}


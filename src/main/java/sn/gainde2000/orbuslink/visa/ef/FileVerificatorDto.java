package sn.gainde2000.orbuslink.visa.ef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class FileVerificatorDto {
	
	private boolean statut;
	private String message;

}

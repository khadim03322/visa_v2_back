package sn.gainde2000.orbuslink.visa.service;

import org.springframework.data.domain.Page;

import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;

public interface BaremeCoutVisaService {
	Page<BaremeCoutVisa> getAllBaremeCoutVisas(int page, int size);

}

package sn.gainde2000.orbuslink.visa.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.BaremeCoutVisa;
import sn.gainde2000.orbuslink.visa.repository.BaremeCoutVisaRepository;
import sn.gainde2000.orbuslink.visa.service.BaremeCoutVisaService;

@Service
public class BaremeCoutVisaServiceImpl implements BaremeCoutVisaService {
	private BaremeCoutVisaRepository baremeCoutVisaRepository;
	
	@Autowired
	public void setRepository(BaremeCoutVisaRepository baremeCoutVisaRepository
			)
	{
		this.baremeCoutVisaRepository = baremeCoutVisaRepository;
	}
	@Override
	public Page<BaremeCoutVisa> getAllBaremeCoutVisas(int page, int size) {
		Pageable requestedPage = PageRequest.of(page, size);
		return baremeCoutVisaRepository.findAll(requestedPage);
	}

}

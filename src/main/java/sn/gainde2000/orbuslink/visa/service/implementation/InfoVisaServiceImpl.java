package sn.gainde2000.orbuslink.visa.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.InfoVisa;
import sn.gainde2000.orbuslink.visa.repository.InfoVisaRepository;
import sn.gainde2000.orbuslink.visa.service.InfoVisaService;

@Service
@RequiredArgsConstructor
public class InfoVisaServiceImpl implements InfoVisaService {

    public final InfoVisaRepository infoVisaRepository;

    @Override
    public InfoVisa getInfoByIdDepot(Long id) {
        return infoVisaRepository.findByDepot_Id(id);
    }
}

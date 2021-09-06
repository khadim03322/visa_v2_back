package sn.gainde2000.orbuslink.visa.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.gainde2000.orbuslink.visa.model.QualiteSignature;
import sn.gainde2000.orbuslink.visa.repository.QualiteSignatureRepository;
import sn.gainde2000.orbuslink.visa.repository.StructureRepository;
import sn.gainde2000.orbuslink.visa.service.QualiteSignatureService;

@Service
public class QualiteSignatureServiceImpl implements QualiteSignatureService {
	
	private QualiteSignatureRepository qualiteSignatureRepository;
	@Autowired
	public void setRepository(
			QualiteSignatureRepository qualiteSignatureRepository
			)
	{
		this.qualiteSignatureRepository = qualiteSignatureRepository;
	}
	
	@Override
	public List<QualiteSignature> getAllQualiteSignature() {
		return qualiteSignatureRepository.findAll();
	}
}

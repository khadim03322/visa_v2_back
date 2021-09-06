package sn.gainde2000.orbuslink.visa.service;

import org.springframework.data.domain.Page;

import sn.gainde2000.orbuslink.visa.model.Etalink;
import sn.gainde2000.orbuslink.visa.web.dto.model.DownloadDto;

public interface IEtatLinkService {
	boolean savedownloadInfo(DownloadDto downloadDto);
	boolean deleteEtalink(long id);
	Page<Etalink> getListEtalinkByProfil(int page,int size);
}

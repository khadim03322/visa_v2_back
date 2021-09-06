package sn.gainde2000.orbuslink.visa.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import sn.gainde2000.orbuslink.visa.ef.ExcelVerification;
import sn.gainde2000.orbuslink.visa.model.PieceJoint;
import sn.gainde2000.orbuslink.visa.web.dto.model.DownloadDto;


public interface PieceJointService {
	
	void storeExcel(MultipartFile multipartFile, Long id, String annee) throws IOException, InterruptedException;
	void deleteExcel(Long id, String annee) throws IOException;
	
	void storeOther(MultipartFile multipartFile, Long id, String annee) throws IOException, InterruptedException;
	void deleteOther(Long id, String annee) throws IOException;
	ExcelVerification verifyExcelEtafi(Long id , String annee) throws IOException, InterruptedException;
	Map<String, Object> getFile(Long id ) throws IOException;
	
	
	//Mazars
	void storeEtafix(MultipartFile multipartFile, Long id) throws IOException, InterruptedException;
	void removeEtafix(Long id) throws IOException;
	PieceJoint copy(DownloadDto downloadDto) throws Exception;
	PieceJoint genererEtafi(Long id) throws Exception;


}

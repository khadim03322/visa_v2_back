package sn.gainde2000.orbuslink.visa.web.controller.v2;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import sn.gainde2000.orbuslink.visa.service.PieceJointService;
import sn.gainde2000.orbuslink.visa.web.dto.response.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v2/files")
public class FilesController {
	
	private final PieceJointService pieceJointeService;
	
	@PostMapping(value = "excel/{id}/{annee}")
    public void storeExcel(@RequestParam("file") MultipartFile file, @PathVariable String annee,
                           @PathVariable Long id) throws IOException, InterruptedException {

		pieceJointeService.storeExcel(file, id, annee);
    }
	

    @PostMapping("deleteEtafiExcel/{id}/{annee}")
    public void deleteExcel( @PathVariable String annee,
                                          @PathVariable Long id ) throws IOException {
    	pieceJointeService.deleteExcel(id, annee);

    }
    
    
    @PostMapping(value = "other/{id}/{annee}")
    public void storeOtherl(@RequestParam("file") MultipartFile file, @PathVariable String annee,
                           @PathVariable Long id) throws IOException, InterruptedException {

		pieceJointeService.storeOther(file, id, annee);
    }
	

    @PostMapping("deleteOtherExcel/{id}/{annee}")
    public void deleteOther( @PathVariable String annee,
                                          @PathVariable Long id ) throws IOException {
    	pieceJointeService.deleteExcel(id, annee);

    }
    
    @GetMapping(value = "verifyEtafi/{id}/{annee}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> verify(@PathVariable Long id, @PathVariable String annee) throws IOException, InterruptedException {
       return Response.ok().setPayload(pieceJointeService.verifyExcelEtafi( id, annee));
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity getFile(@PathVariable Long id) throws IOException {
        Map results = pieceJointeService.getFile(id);
        return ResponseEntity.ok()
                .body((byte[]) results.get("file"));
    }
    
    
    //Mazars
    @PostMapping(value = "storeEtafix/{id}")
    public void storeEtafix(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException, InterruptedException {
    	pieceJointeService.storeEtafix(file, id);
    }
	

    @PostMapping("removeEtafix/{id}")
    public void removeEtafix(@PathVariable Long id ) throws IOException {

    }

}

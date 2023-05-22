package academics_mgmt.academics_details.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import academics_mgmt.academics_details.model.dto.LMSAcademicsDetailsDTO;
import academics_mgmt.academics_details.services.I_LMSAcademicsDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/academicsDetailsManagement")
public class LMSAcademicsDetailsController {

//	private static final Logger logger = LoggerFactory.getLogger(LMSAcademicsDetails_Controller.class);

	@Autowired
	private I_LMSAcademicsDetailsService lmsAcademicsDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSAcademicsDetailsDTO> newAcademicsDetails(@RequestBody LMSAcademicsDetailsDTO academicsDetailsDTO) {
		LMSAcademicsDetailsDTO academicsDetailsDTO2 = lmsAcademicsDetailsServ.newLMSAcademicsDetails(academicsDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(academicsDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllAcademicsDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsDetailsDTO>> getAllLMSAcademicsDetails() {
		ArrayList<LMSAcademicsDetailsDTO> academicsDetailsDTOs = lmsAcademicsDetailsServ.getAllSessions();
		return new ResponseEntity<>(academicsDetailsDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectAcademicsDetails", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsDetailsDTO>> getSelectAcademicsDetails(@RequestBody ArrayList<Long> sessionSeqNos) {
		ArrayList<LMSAcademicsDetailsDTO> academicsDetailsDTOs = lmsAcademicsDetailsServ.getSelectSessions(sessionSeqNos);		
		return new ResponseEntity<>(academicsDetailsDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updAcademicsDetails")
	public void updateacademicsDetails(@RequestBody LMSAcademicsDetailsDTO academicsDetailsDTO) 
	{
			lmsAcademicsDetailsServ.updLMSAcademicsDetails(academicsDetailsDTO);	
		return;
	}

	@DeleteMapping("/delSelectAcademicsDetails")
	public void deleteSelectacademicsDetails(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsAcademicsDetailsServ.delSelectSessions(sSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllacademicsDetails")
	public void deleteAllAcademicsDetails() {
		lmsAcademicsDetailsServ.delAllLMSAcademicsDetails();
		return;
	}
	
}
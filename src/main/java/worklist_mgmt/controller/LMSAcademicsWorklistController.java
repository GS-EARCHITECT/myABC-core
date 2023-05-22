package worklist_mgmt.controller;

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
import worklist_mgmt.model.dto.LMSAcademicsWorklistsDTO;
import worklist_mgmt.services.I_LMSAcademicsWorklistsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/academicsWorklistManagement")
public class LMSAcademicsWorklistController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSAcademicsWorklist_Controller.class);

	@Autowired
	private I_LMSAcademicsWorklistsService lmsAcademicsWorklistsServ;

	@PostMapping("/new")
	public ResponseEntity<LMSAcademicsWorklistsDTO> newAcademicsWorklist(
			@RequestBody LMSAcademicsWorklistsDTO academicsWorklistDTO) {
		LMSAcademicsWorklistsDTO academicsWorklistDTO2 = lmsAcademicsWorklistsServ
				.newLMSAcademicsWorklist(academicsWorklistDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(academicsWorklistDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAcademicsWorklists", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsWorklistsDTO>> getAllLMSAcademicsWorklists() {
		ArrayList<LMSAcademicsWorklistsDTO> academicsWorklistDTOs = lmsAcademicsWorklistsServ.getAllWorklists();
		return new ResponseEntity<>(academicsWorklistDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAcademicsWorklistsForSessions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsWorklistsDTO>> getSelectAcademicsWorklistsForSessions(
			@RequestBody ArrayList<Long> sesssionSeqNos) {
		ArrayList<LMSAcademicsWorklistsDTO> academicsWorklistDTOs = lmsAcademicsWorklistsServ
				.getSelectWorklistsForSessions(sesssionSeqNos);
		return new ResponseEntity<>(academicsWorklistDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAcademicsWorklistsForFaculties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsWorklistsDTO>> getSelectAcademicsWorklistsForFaculties(
			@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSAcademicsWorklistsDTO> academicsWorklistDTOs = lmsAcademicsWorklistsServ
				.getSelectWorklistsForFaculties(iSeqNos);
		return new ResponseEntity<>(academicsWorklistDTOs, HttpStatus.OK);
	}

	@PutMapping("/updAcademicsWorklist")
	public void updateacademicsWorklist(@RequestBody LMSAcademicsWorklistsDTO academicsWorklistDTO) {
		lmsAcademicsWorklistsServ.updLMSAcademicsWorklist(academicsWorklistDTO);
		return;
	}

	@DeleteMapping("/delSelectAcademicsWorklistsBySessions")
	public void delSelectAcademicsWorklistsBySessions(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsAcademicsWorklistsServ.delSelectWorklistsForFaculties(sSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectAcademicsWorklistsByFaculties")
	public void delSelectAcademicsWorklistsByFaculties(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsAcademicsWorklistsServ.delSelectWorklistsForFaculties(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllacademicsWorklist")
	public void deleteAllAcademicsWorklists() {
		lmsAcademicsWorklistsServ.delAllLMSAcademicsWorklists();
		;
		return;
	}

}
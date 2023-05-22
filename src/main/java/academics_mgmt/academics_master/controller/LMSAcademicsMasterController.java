package academics_mgmt.academics_master.controller;

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
import academics_mgmt.academics_master.model.dto.LMSAcademicsMasterDTO;
import academics_mgmt.academics_master.services.I_LMSAcademicsMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/academicsManagement")
public class LMSAcademicsMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSAcademicsMaster_Controller.class);

	@Autowired
	private I_LMSAcademicsMasterService lmsAcademicsMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSAcademicsMasterDTO> newacademicsTemplate(
			@RequestBody LMSAcademicsMasterDTO academicsTemplateDTO) {
		LMSAcademicsMasterDTO academicsTemplateDTO2 = lmsAcademicsMasterServ
				.newAcademics(academicsTemplateDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(academicsTemplateDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAcademicss", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsMasterDTO>> getAllLMSAcademicsMasters() {
		ArrayList<LMSAcademicsMasterDTO> academicsTemplateDTOs = lmsAcademicsMasterServ
				.getAllAcademicss();
		return new ResponseEntity<>(academicsTemplateDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAcademicss", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsMasterDTO>> getSelectLMSMediaBySubjects(
			@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSAcademicsMasterDTO> academicsTemplateDTOs = lmsAcademicsMasterServ
				.getSelectAcademicss(subjectDetailsSeqNos);
		return new ResponseEntity<>(academicsTemplateDTOs, HttpStatus.OK);
	}

	@PutMapping("/updAcademicTemplate")
	public void updateacademicTemplate(@RequestBody LMSAcademicsMasterDTO academicsTemplateDTO) {
		lmsAcademicsMasterServ.updAcademics(academicsTemplateDTO);
		return;
	}

	@DeleteMapping("/delSelectAcademicss")
	public void deleteSelectAcademics(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsAcademicsMasterServ.delSelectAcademicss(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllacademicsTemplates")
	public void deleteAllAcademicss() {
		lmsAcademicsMasterServ.delAllAcademicss();
		return;
	}

	@DeleteMapping("/delAcademics")
	public void delAcademicTemplate(@RequestBody LMSAcademicsMasterDTO academicsTemplateDTO) {
		lmsAcademicsMasterServ.delAcademicTemplate(academicsTemplateDTO);
		return;
	}

}
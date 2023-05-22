package attendance_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import attendance_mgmt.model.dto.LMSAcademicsAttendanceDTO;
import attendance_mgmt.services.I_LMSAcademicsAttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/academicsAttendanceManagement")
public class LMSAcademicsAttendanceController {

//	private static final Logger logger = LoggerFactory.getLogger(LMSAcademicsAttendance_Controller.class);

	@Autowired
	private I_LMSAcademicsAttendanceService lmsAcademicsAttendanceServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSAcademicsAttendanceDTO> newacademicsAttendance(@RequestBody LMSAcademicsAttendanceDTO academicsAttendanceDTO) {
		LMSAcademicsAttendanceDTO academicsAttendanceDTO2 = lmsAcademicsAttendanceServ.newLMSAcademicsAttendance(academicsAttendanceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(academicsAttendanceDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllAcademicsAttendances", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsAttendanceDTO>> getAllLMSAcademicsAttendances() {
		ArrayList<LMSAcademicsAttendanceDTO> academicsAttendanceDTOs = lmsAcademicsAttendanceServ.getAllAcademicsAttendances();
		return new ResponseEntity<>(academicsAttendanceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectAcademicsAttendances", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsAttendanceDTO>> getSelectLMSMediaBySubjects(@RequestBody ArrayList<Long> attendanceDetailsSeqNos) {
		ArrayList<LMSAcademicsAttendanceDTO> academicsAttendanceDTOs = lmsAcademicsAttendanceServ.getSelectAcademicsAttendances(attendanceDetailsSeqNos);		
		return new ResponseEntity<>(academicsAttendanceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectAcademicsAttendancesbyStudents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSAcademicsAttendanceDTO>> getSelectAcademicsAttendancesByStudents(@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSAcademicsAttendanceDTO> academicsAttendanceDTOs = lmsAcademicsAttendanceServ.getSelectAcademicsAttendancesByStudents(iSeqNos);		
		return new ResponseEntity<>(academicsAttendanceDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updAcademicsAttendance")
	public void updateacademicsAttendance(@RequestBody LMSAcademicsAttendanceDTO academicsAttendanceDTO) 
	{
			lmsAcademicsAttendanceServ.updLMSAcademicsAttendance(academicsAttendanceDTO);	
		return;
	}

	@DeleteMapping("/delSelectacademicsAttendance")
	public void deleteSelectacademicsAttendance(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsAcademicsAttendanceServ.delSelectAcademicsAttendances(sSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllacademicsAttendance")
	public void deleteAllAcademicsAttendances() {
		lmsAcademicsAttendanceServ.delAllLMSAcademicsAttendances();;
		return;
	}
	
	@DeleteMapping("/delSelectacademicsAttendancebyStudents")
	public void delSelectAcademicsAttendancesBySubjects(@RequestBody ArrayList<Long> ids)
	{
		lmsAcademicsAttendanceServ.delSelectAcademicsAttendancesByStudents(ids);
		return;
	}
	
	
	
		
}
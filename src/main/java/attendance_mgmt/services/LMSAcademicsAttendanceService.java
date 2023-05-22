package attendance_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import attendance_mgmt.model.dto.LMSAcademicsAttendanceDTO;
import attendance_mgmt.model.master.LMSAcademicsAttendance;
import attendance_mgmt.model.master.LMSAcademicsAttendancePK;
import attendance_mgmt.model.repo.LMSAcademicsAttendanceRepo;

@Service("lmsAcademicsAttendanceServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSAcademicsAttendanceService implements I_LMSAcademicsAttendanceService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSAcademicsAttendance_Controller.class);

	@Autowired
	private LMSAcademicsAttendanceRepo lmsAcademicsAttendanceRepo;

	@Override
	public ArrayList<LMSAcademicsAttendanceDTO> getAllAcademicsAttendances() {
		ArrayList<LMSAcademicsAttendanceDTO> academicsAttendanceDTOs = new ArrayList<LMSAcademicsAttendanceDTO>();
		ArrayList<LMSAcademicsAttendance> academicsAttendanceOpts = (ArrayList<LMSAcademicsAttendance>) lmsAcademicsAttendanceRepo
				.findAll();

		if (academicsAttendanceOpts != null) {
			academicsAttendanceDTOs = getAcademicsAttendanceDtos(academicsAttendanceOpts);
		} else {
			academicsAttendanceDTOs = null;
		}

		return academicsAttendanceDTOs;
	}

	@Override
	public ArrayList<LMSAcademicsAttendanceDTO> getSelectAcademicsAttendances(ArrayList<Long> ids) {
		ArrayList<LMSAcademicsAttendance> lMasters = lmsAcademicsAttendanceRepo
				.getSelectAcademicsAttendances(ids);
		ArrayList<LMSAcademicsAttendanceDTO> LMSAcademicsAttendanceDTOs = new ArrayList<LMSAcademicsAttendanceDTO>();
		LMSAcademicsAttendanceDTO LMSAcademicsAttendanceDTO = null;

		if (lMasters != null) {
			LMSAcademicsAttendanceDTOs = getAcademicsAttendanceDtos(lMasters);
		}

		return LMSAcademicsAttendanceDTOs;
	}

	@Override
	public ArrayList<LMSAcademicsAttendanceDTO> getSelectAcademicsAttendancesByStudents(ArrayList<Long> ids) 
	{
		ArrayList<LMSAcademicsAttendance> lMasters = lmsAcademicsAttendanceRepo.getSelectAcademicsAttendancesByStudents(ids);
		ArrayList<LMSAcademicsAttendanceDTO> LMSAcademicsAttendanceDTOs = new ArrayList<LMSAcademicsAttendanceDTO>();
		LMSAcademicsAttendanceDTO LMSAcademicsAttendanceDTO = null;

		if (lMasters != null) {
			LMSAcademicsAttendanceDTOs = getAcademicsAttendanceDtos(lMasters);
		}

		return LMSAcademicsAttendanceDTOs;
	}

		public LMSAcademicsAttendanceDTO newLMSAcademicsAttendance(LMSAcademicsAttendanceDTO lms_AcademicsAttendanceDTO) 
	{
		LMSAcademicsAttendancePK lmsAcademicsTemplatePK = new LMSAcademicsAttendancePK();
		lmsAcademicsTemplatePK.setActionInstanceSeqNo(lms_AcademicsAttendanceDTO.getActionInstanceSeqNo());
		lmsAcademicsTemplatePK.setStudentSeqNo(lms_AcademicsAttendanceDTO.getStudentSeqNo());		
		LMSAcademicsAttendance lmsAcademicsTemplate = null;

		if (!lmsAcademicsAttendanceRepo.existsById(lmsAcademicsTemplatePK)) {
			lmsAcademicsTemplate = this.setAcademicsAttendance(lms_AcademicsAttendanceDTO);
			lmsAcademicsTemplate.setId(lmsAcademicsTemplatePK);
			lms_AcademicsAttendanceDTO = this.getAcademicsAttendanceDto(lmsAcademicsAttendanceRepo.save(lmsAcademicsTemplate));
		}
		return lms_AcademicsAttendanceDTO;
	}

	public void updLMSAcademicsAttendance(LMSAcademicsAttendanceDTO lMSAcademicsAttendanceDTO) 
	{
		LMSAcademicsAttendancePK lmsAcademicsTemplatePK = new LMSAcademicsAttendancePK();
		lmsAcademicsTemplatePK.setActionInstanceSeqNo(lMSAcademicsAttendanceDTO.getActionInstanceSeqNo());
		lmsAcademicsTemplatePK.setStudentSeqNo(lMSAcademicsAttendanceDTO.getStudentSeqNo());		
		LMSAcademicsAttendance lmsAcademicsTemplate = null;

		if (!lmsAcademicsAttendanceRepo.existsById(lmsAcademicsTemplatePK)) 
		{
		LMSAcademicsAttendance lms_AcademicsAttendance = setAcademicsAttendance(lMSAcademicsAttendanceDTO);
		lmsAcademicsAttendanceRepo.save(lms_AcademicsAttendance);
		}
	}

	public void delSelectAcademicsAttendances(ArrayList<Long> attendanceSeqNos) 
	{
		lmsAcademicsAttendanceRepo.delSelectAcademicsAttendances(attendanceSeqNos);
	}

	public void delSelectAcademicsAttendancesByStudents(ArrayList<Long> ids)
	{
		lmsAcademicsAttendanceRepo.delSelectAcademicsAttendancesByStudents(ids);
	}

	public void delAllLMSAcademicsAttendances() {
		lmsAcademicsAttendanceRepo.deleteAll();
	}

	private ArrayList<LMSAcademicsAttendanceDTO> getAcademicsAttendanceDtos(
			ArrayList<LMSAcademicsAttendance> lms_AcademicsAttendances) {
		LMSAcademicsAttendanceDTO academicsAttendanceDTO = null;
		ArrayList<LMSAcademicsAttendanceDTO> academicsAttendanceDTOs = new ArrayList<LMSAcademicsAttendanceDTO>();

		for (int i = 0; i < lms_AcademicsAttendances.size(); i++) {
			academicsAttendanceDTO = getAcademicsAttendanceDto(lms_AcademicsAttendances.get(i));
			academicsAttendanceDTOs.add(academicsAttendanceDTO);
		}
		return academicsAttendanceDTOs;
	}

	private LMSAcademicsAttendanceDTO getAcademicsAttendanceDto(LMSAcademicsAttendance attendanceMaster) {
		LMSAcademicsAttendanceDTO lDTO = new LMSAcademicsAttendanceDTO();
		lDTO.setActionInstanceSeqNo(attendanceMaster.getId().getActionInstanceSeqNo());
		lDTO.setStudentSeqNo(attendanceMaster.getId().getStudentSeqNo());
		return lDTO;
	}

	private LMSAcademicsAttendance setAcademicsAttendance(LMSAcademicsAttendanceDTO sMasterDTO) {
		LMSAcademicsAttendance lms_AcademicsAttendance = new LMSAcademicsAttendance();
		LMSAcademicsAttendancePK lmsAcademicsTemplatePK = new LMSAcademicsAttendancePK();
		lmsAcademicsTemplatePK.setActionInstanceSeqNo(sMasterDTO.getActionInstanceSeqNo());
		lmsAcademicsTemplatePK.setStudentSeqNo(sMasterDTO.getStudentSeqNo());
		lms_AcademicsAttendance.setId(lmsAcademicsTemplatePK);		
		return lms_AcademicsAttendance;
	}

}

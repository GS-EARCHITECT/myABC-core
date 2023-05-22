package academics_mgmt.academics_master.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import academics_mgmt.academics_master.model.dto.LMSAcademicsMasterDTO;
import academics_mgmt.academics_master.model.master.LMSAcademicsMaster;
import academics_mgmt.academics_master.model.master.LMSAcademicsMasterPK;
import academics_mgmt.academics_master.model.repo.LMSAcademicsMasterRepo;

@Service("lmsAcademicsMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSAcademicsMasterService implements I_LMSAcademicsMasterService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSAcademicsMaster_Controller.class);

	@Autowired
	private LMSAcademicsMasterRepo lmsAcademicsMasterRepo;

	public LMSAcademicsMasterDTO newAcademics(LMSAcademicsMasterDTO lms_AcademicsMasterDTO) 
	{
		LMSAcademicsMasterPK lmsAcademicsPK = new LMSAcademicsMasterPK();
		lmsAcademicsPK.setSessionSeqNo(lms_AcademicsMasterDTO.getSessionSeqNo());
		lmsAcademicsPK.setRuleSeqNo(lms_AcademicsMasterDTO.getRuleSeqNo());
		lmsAcademicsPK.setSubjectSeqNo(lms_AcademicsMasterDTO.getSubjectSeqNo());
		LMSAcademicsMaster lmsAcademics = null;

		if (!lmsAcademicsMasterRepo.existsById(lmsAcademicsPK)) 
		{
			lmsAcademics = this.setAcademicsMaster(lms_AcademicsMasterDTO);
			lmsAcademics.setId(lmsAcademicsPK);
			lms_AcademicsMasterDTO = this.getAcademicsMasterDto(lmsAcademicsMasterRepo.save(lmsAcademics));
		}
		return lms_AcademicsMasterDTO;
	}

	
	@Override
	public ArrayList<LMSAcademicsMasterDTO> getAllAcademicss() {
		ArrayList<LMSAcademicsMasterDTO> academicsTemplateMasterDTOs = new ArrayList<LMSAcademicsMasterDTO>();
		ArrayList<LMSAcademicsMaster> academicsTemplateMasterOpts = (ArrayList<LMSAcademicsMaster>) lmsAcademicsMasterRepo
				.findAll();

		if (academicsTemplateMasterOpts != null) {
			academicsTemplateMasterDTOs = getAcademicsMasterDtos(academicsTemplateMasterOpts);
		} else {
			academicsTemplateMasterDTOs = null;
		}

		return academicsTemplateMasterDTOs;
	}

	@Override
	public ArrayList<LMSAcademicsMasterDTO> getSelectAcademicss(ArrayList<Long> ids) {
		ArrayList<LMSAcademicsMaster> lMasters = lmsAcademicsMasterRepo
				.getSelectAcademicMasters(ids);
		ArrayList<LMSAcademicsMasterDTO> LMSAcademicsMasterDTOs = new ArrayList<LMSAcademicsMasterDTO>();
		
		if (lMasters != null) {
			LMSAcademicsMasterDTOs = getAcademicsMasterDtos(lMasters);
		}

		return LMSAcademicsMasterDTOs;
	}

	public void updDetailedStatus(Long sSeqNo, Long rSeqNo, Long subSeqNo) 
	{
		LMSAcademicsMasterPK lmsAcademicsPK = new LMSAcademicsMasterPK();
		lmsAcademicsPK.setSessionSeqNo(sSeqNo);
		lmsAcademicsPK.setRuleSeqNo(rSeqNo);
		lmsAcademicsPK.setSubjectSeqNo(subSeqNo);
		
		if (lmsAcademicsMasterRepo.existsById(lmsAcademicsPK)) 
		{
			lmsAcademicsMasterRepo.updDetailedStatus(sSeqNo, rSeqNo, subSeqNo);
		}
	}
	
	public void updAcademics(LMSAcademicsMasterDTO lMSAcademicsMasterDTO) 
	{
		LMSAcademicsMasterPK lmsAcademicsPK = new LMSAcademicsMasterPK();
		lmsAcademicsPK.setSessionSeqNo(lMSAcademicsMasterDTO.getSessionSeqNo());
		lmsAcademicsPK.setRuleSeqNo(lMSAcademicsMasterDTO.getRuleSeqNo());
		lmsAcademicsPK.setSubjectSeqNo(lMSAcademicsMasterDTO.getSubjectSeqNo());
		
		if (lmsAcademicsMasterRepo.existsById(lmsAcademicsPK)) 
		{
		LMSAcademicsMaster lms_AcademicsMaster = setAcademicsMaster(lMSAcademicsMasterDTO);
		lmsAcademicsMasterRepo.save(lms_AcademicsMaster);
		}
	}

	public void delForSessionAndSubject(Long sSeqNo, Long subSeqNo) 
	{
		lmsAcademicsMasterRepo.delForSessionAndSubject(sSeqNo, subSeqNo);
	}

	
	public void delSelectAcademicss(ArrayList<Long> sessionSeqNos) 
	{
		lmsAcademicsMasterRepo.delSelectAcademicMasters(sessionSeqNos);
	}

	public void delAcademicTemplate(LMSAcademicsMasterDTO lMSAcademicsMasterDTO)
	{
		LMSAcademicsMasterPK lmsAcademicsPK = new LMSAcademicsMasterPK();
		lmsAcademicsPK.setSessionSeqNo(lMSAcademicsMasterDTO.getSessionSeqNo());
		lmsAcademicsPK.setRuleSeqNo(lMSAcademicsMasterDTO.getRuleSeqNo());
		lmsAcademicsPK.setSubjectSeqNo(lMSAcademicsMasterDTO.getSubjectSeqNo());
		
		if (lmsAcademicsMasterRepo.existsById(lmsAcademicsPK)) 
		{
		lmsAcademicsMasterRepo.deleteById(lmsAcademicsPK);
		}
	
	}

	public void delAllAcademicss() {
		lmsAcademicsMasterRepo.deleteAll();
	}

	private ArrayList<LMSAcademicsMasterDTO> getAcademicsMasterDtos(
			ArrayList<LMSAcademicsMaster> lms_AcademicsMasters) {
		LMSAcademicsMasterDTO academicsTemplateMasterDTO = null;
		ArrayList<LMSAcademicsMasterDTO> academicsTemplateMasterDTOs = new ArrayList<LMSAcademicsMasterDTO>();

		for (int i = 0; i < lms_AcademicsMasters.size(); i++) {
			academicsTemplateMasterDTO = getAcademicsMasterDto(lms_AcademicsMasters.get(i));
			academicsTemplateMasterDTOs.add(academicsTemplateMasterDTO);
		}
		return academicsTemplateMasterDTOs;
	}

	private LMSAcademicsMasterDTO getAcademicsMasterDto(LMSAcademicsMaster sessionMaster) {
		LMSAcademicsMasterDTO lDTO = new LMSAcademicsMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");				
		lDTO.setFromDttm(formatter.format(sessionMaster.getFromDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(sessionMaster.getToDttm().toLocalDateTime()));		
		lDTO.setRuleLineSeqNo(sessionMaster.getId().getRuleSeqNo());
		lDTO.setSessionSeqNo(sessionMaster.getId().getSessionSeqNo());		
		lDTO.setSubjectSeqNo(sessionMaster.getId().getSubjectSeqNo());
		lDTO.setJobTypeSeqNo(sessionMaster.getJobTypeSeqNo());
		lDTO.setRuleLineSeqNo(sessionMaster.getRuleLineSeqNo());
		lDTO.setScheduleData(sessionMaster.getScheduleData());
		lDTO.setTimeFr(sessionMaster.getTimeFr());
		lDTO.setTimeTo(sessionMaster.getTimeTo());		
		lDTO.setStatusSeqNo(sessionMaster.getStatusSeqNo());
		return lDTO;
	}

	private LMSAcademicsMaster setAcademicsMaster(LMSAcademicsMasterDTO sMasterDTO)
	{
		LMSAcademicsMaster lms_AcademicsMaster = new LMSAcademicsMaster();
		LMSAcademicsMasterPK lmsAcademicsPK = new LMSAcademicsMasterPK();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(sMasterDTO.getFromDttm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(sMasterDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lmsAcademicsPK.setRuleSeqNo(sMasterDTO.getRuleSeqNo());
		lmsAcademicsPK.setSessionSeqNo(sMasterDTO.getSessionSeqNo());
		lmsAcademicsPK.setSubjectSeqNo(sMasterDTO.getSubjectSeqNo());
		lms_AcademicsMaster.setFromDttm(ts_Fr);
		lms_AcademicsMaster.setToDttm(ts_To);		
		lms_AcademicsMaster.setJobTypeSeqNo(sMasterDTO.getJobTypeSeqNo());		
		lms_AcademicsMaster.setScheduleData(sMasterDTO.getScheduleData());
		lms_AcademicsMaster.setTimeFr(sMasterDTO.getTimeFr());		
		lms_AcademicsMaster.setTimeTo(sMasterDTO.getTimeTo());		
		lms_AcademicsMaster.setStatusSeqNo(sMasterDTO.getStatusSeqNo());
		return lms_AcademicsMaster;
	}

}

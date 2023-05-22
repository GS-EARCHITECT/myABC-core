package academics_mgmt.academics_master.services;

import java.util.ArrayList;
import academics_mgmt.academics_master.model.dto.LMSAcademicsMasterDTO;

public interface I_LMSAcademicsMasterService 
{
	public LMSAcademicsMasterDTO newAcademics(LMSAcademicsMasterDTO academicTemplateMasterDTO);
	public ArrayList<LMSAcademicsMasterDTO> getAllAcademicss();
	public ArrayList<LMSAcademicsMasterDTO> getSelectAcademicss(ArrayList<Long> ids);	
	public void updAcademics(LMSAcademicsMasterDTO LMSAcademicsMasterDTO);
	public void delAcademicTemplate(LMSAcademicsMasterDTO LMSAcademicsMasterDTO);
	public void delAllAcademicss();	
	public void delSelectAcademicss( ArrayList<Long> ids);
	public void updDetailedStatus(Long sSeqNo, Long rSeqNo, Long subSeqNo);
	public void delForSessionAndSubject(Long sSeqNo, Long subSeqNo);
	}
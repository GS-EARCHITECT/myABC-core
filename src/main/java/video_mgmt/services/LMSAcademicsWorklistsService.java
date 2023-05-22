package video_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import worklist_mgmt.model.dto.LMSAcademicsWorklistsDTO;
import worklist_mgmt.model.master.LMSAcademicsWorklists;
import worklist_mgmt.model.repo.LMSAcademicsWorklistsRepo;

@Service("lmsAcademicsWorklistsServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSAcademicsWorklistsService implements I_LMSAcademicsWorklistsService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSAcademicsWorklists_Controller.class);
	
	@Autowired
    private LMSAcademicsWorklistsRepo lmsAcademicsWorklistsRepo;

	@Override
    public ArrayList<LMSAcademicsWorklistsDTO> getAllWorklists() 
    {
    	ArrayList<LMSAcademicsWorklistsDTO> courseMasterDTOs = new ArrayList<LMSAcademicsWorklistsDTO>();
    	ArrayList<LMSAcademicsWorklists> courseMasterOpts =  (ArrayList<LMSAcademicsWorklists>) lmsAcademicsWorklistsRepo.findAll();
    	    	
    	if(courseMasterOpts!=null)
    	{
    		courseMasterDTOs = getAcademicsWorklistsDtos(courseMasterOpts);
    	}
    	else
    	{
    		courseMasterDTOs= null;    	
    	}
            	
        return courseMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSAcademicsWorklistsDTO> getSelectWorklistsForSessions(ArrayList<Long> ids)
	{
		ArrayList<LMSAcademicsWorklists> lMasters = lmsAcademicsWorklistsRepo.getSelectWorklistsForSessions(ids);
		ArrayList<LMSAcademicsWorklistsDTO> LMSAcademicsWorklistsDTOs = new ArrayList<LMSAcademicsWorklistsDTO>();

		if (lMasters != null) 
		{
		LMSAcademicsWorklistsDTOs = getAcademicsWorklistsDtos(lMasters);				
		}
		
		return LMSAcademicsWorklistsDTOs;
	}

    @Override
    public ArrayList<LMSAcademicsWorklistsDTO> getSelectWorklistsForFaculties(ArrayList<Long> ids)
	{
		ArrayList<LMSAcademicsWorklists> lMasters = lmsAcademicsWorklistsRepo.getSelectWorklistsForFaculties(ids);
		ArrayList<LMSAcademicsWorklistsDTO> LMSAcademicsWorklistsDTOs = new ArrayList<LMSAcademicsWorklistsDTO>();

		if (lMasters != null) 
		{
		LMSAcademicsWorklistsDTOs = getAcademicsWorklistsDtos(lMasters);				
		}
		
		return LMSAcademicsWorklistsDTOs;
	}

    
    public LMSAcademicsWorklistsDTO newLMSAcademicsWorklist(LMSAcademicsWorklistsDTO lms_AcademicsWorklistsDTO) 
    {    	
    LMSAcademicsWorklists lms_AcademicsWorklists = lmsAcademicsWorklistsRepo.save(setAcademicsWorklists(lms_AcademicsWorklistsDTO));
    LMSAcademicsWorklistsDTO courseMasterDTO2 = getAcademicsWorklistsDto(lms_AcademicsWorklists);
	return courseMasterDTO2;
    }

    public void updLMSAcademicsWorklist(LMSAcademicsWorklistsDTO lMSAcademicsWorklistsDTO) 
    {
    LMSAcademicsWorklists lms_AcademicsWorklists = setAcademicsWorklists(lMSAcademicsWorklistsDTO);
    lmsAcademicsWorklistsRepo.save(lms_AcademicsWorklists);    
    }
    
    public void delSelectWorklistsForSesssions(ArrayList<Long> ids) 
    {
    lmsAcademicsWorklistsRepo.delSelectWorklistsForSessions(ids);
    }

    public void delSelectWorklistsForFaculties(ArrayList<Long> ids) 
    {
    lmsAcademicsWorklistsRepo.delSelectWorklistsForFaculties(ids);
    }
    
    public void delAllLMSAcademicsWorklists() 
    {
    lmsAcademicsWorklistsRepo.deleteAll();
    }
    
    private ArrayList<LMSAcademicsWorklistsDTO> getAcademicsWorklistsDtos(ArrayList<LMSAcademicsWorklists> lms_AcademicsWorklists) 
	{
		LMSAcademicsWorklistsDTO courseMasterDTO = null;
		ArrayList<LMSAcademicsWorklistsDTO> courseMasterDTOs = new ArrayList<LMSAcademicsWorklistsDTO>(); 
		
		for(int i=0; i<lms_AcademicsWorklists.size();i++)
		{		
		courseMasterDTO = getAcademicsWorklistsDto(lms_AcademicsWorklists.get(i));
		courseMasterDTOs.add(courseMasterDTO);
		}		
		return courseMasterDTOs;
	}
	
	private LMSAcademicsWorklistsDTO getAcademicsWorklistsDto(LMSAcademicsWorklists sMaster) 
	{
		LMSAcademicsWorklistsDTO lDTO = new LMSAcademicsWorklistsDTO();
		lDTO.setActionInstanceSeqNo(sMaster.getActionInstanceSeqNo());
		lDTO.setWorklistSeqNo(sMaster.getWorklistSeqNo());
		lDTO.setFacultySeqNo(sMaster.getFacultySeqNo());
		lDTO.setStudentSeqNo(sMaster.getStudentSeqNo());
		return lDTO;
		}
	
	private LMSAcademicsWorklists setAcademicsWorklists(LMSAcademicsWorklistsDTO sMasterDTO) 
	{
		LMSAcademicsWorklists lms_AcademicsWorklist	=	new	LMSAcademicsWorklists();		
		lms_AcademicsWorklist.setActionInstanceSeqNo(sMasterDTO.getActionInstanceSeqNo());
		lms_AcademicsWorklist.setFacultySeqNo(sMasterDTO.getFacultySeqNo());
		lms_AcademicsWorklist.setStudentSeqNo(sMasterDTO.getStudentSeqNo());
		return lms_AcademicsWorklist;
	}

}

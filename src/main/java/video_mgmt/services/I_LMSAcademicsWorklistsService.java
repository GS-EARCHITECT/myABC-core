package video_mgmt.services;

import java.util.ArrayList;
import worklist_mgmt.model.dto.LMSAcademicsWorklistsDTO;

public interface I_LMSAcademicsWorklistsService 
{
	abstract public LMSAcademicsWorklistsDTO newLMSAcademicsWorklist(LMSAcademicsWorklistsDTO resourceMediaWorklistsDTO);
	abstract public ArrayList<LMSAcademicsWorklistsDTO> getAllWorklists();
	abstract public ArrayList<LMSAcademicsWorklistsDTO> getSelectWorklistsForSessions(ArrayList<Long> ids);
	abstract public ArrayList<LMSAcademicsWorklistsDTO> getSelectWorklistsForFaculties(ArrayList<Long> ids);
	abstract public void updLMSAcademicsWorklist(LMSAcademicsWorklistsDTO LMSAcademicsWorklistsDTO);	
	abstract public void delAllLMSAcademicsWorklists();	
	abstract public void delSelectWorklistsForSesssions(ArrayList<Long> ids);
	abstract public void delSelectWorklistsForFaculties(ArrayList<Long> ids);
}
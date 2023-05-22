package academics_mgmt.academics_details.services;

import java.util.ArrayList;


import academics_mgmt.academics_details.model.dto.LMSAcademicsDetailsDTO;

public interface I_LMSAcademicsDetailsService 
{
	abstract public LMSAcademicsDetailsDTO newLMSAcademicsDetails(LMSAcademicsDetailsDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSAcademicsDetailsDTO> getAllSessions();
	abstract public ArrayList<LMSAcademicsDetailsDTO> getSelectSessions(ArrayList<Long> ids);	
	abstract public void updLMSAcademicsDetails(LMSAcademicsDetailsDTO LMSAcademicsDetailsDTO);	
	abstract public void delAllLMSAcademicsDetails();	
	abstract public void delSelectSessions( ArrayList<Long> ids);	
}
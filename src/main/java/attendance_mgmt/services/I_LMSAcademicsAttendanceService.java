package attendance_mgmt.services;

import java.util.ArrayList;
import attendance_mgmt.model.dto.LMSAcademicsAttendanceDTO;

public interface I_LMSAcademicsAttendanceService 
{
	abstract public LMSAcademicsAttendanceDTO newLMSAcademicsAttendance(LMSAcademicsAttendanceDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSAcademicsAttendanceDTO> getAllAcademicsAttendances();
	abstract public ArrayList<LMSAcademicsAttendanceDTO> getSelectAcademicsAttendances(ArrayList<Long> ids);	
	abstract public ArrayList<LMSAcademicsAttendanceDTO> getSelectAcademicsAttendancesByStudents(ArrayList<Long> ids);
	abstract public void updLMSAcademicsAttendance(LMSAcademicsAttendanceDTO LMSAcademicsAttendanceDTO);	
	abstract public void delAllLMSAcademicsAttendances();		
	abstract public void delSelectAcademicsAttendances(ArrayList<Long> ids);
	abstract public void delSelectAcademicsAttendancesByStudents(ArrayList<Long> ids);
}
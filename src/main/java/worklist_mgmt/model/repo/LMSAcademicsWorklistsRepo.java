package worklist_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import worklist_mgmt.model.master.LMSAcademicsWorklists;

@Repository("lmsAcademicsWorklistsRepo")
public interface LMSAcademicsWorklistsRepo extends CrudRepository<LMSAcademicsWorklists, Long> 
{ 
	@Query(value = "SELECT * FROM LMS_Academics_Worklists a WHERE a.ACTION_INSTANCE_SEQ_NO in :ids order by ACTION_INSTANCE_SEQ_NO", nativeQuery = true)
	ArrayList<LMSAcademicsWorklists> getSelectWorklistsForSessions(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_Academics_Worklists a WHERE a.faculty_SEQ_NO in :ids order by faculty_SEQ_NO", nativeQuery = true)
	ArrayList<LMSAcademicsWorklists> getSelectWorklistsForFaculties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_Academics_Worklists WHERE a.ACTION_INSTANCE_SEQ_NO in :ids", nativeQuery = true)
	void delSelectWorklistsForSessions(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_Academics_Worklists WHERE a.faculty_SEQ_NO in :ids", nativeQuery = true)
	void delSelectWorklistsForFaculties(@Param("ids") ArrayList<Long> ids);
} 


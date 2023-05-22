package academics_mgmt.academics_details.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import academics_mgmt.academics_details.model.master.LMSAcademicsDetails;

@Repository("lmsAcademicsDetailsRepo")
public interface LMSAcademicsDetailsRepo extends CrudRepository<LMSAcademicsDetails, Long> 
{ 
	@Query(value = "SELECT * FROM LMS_Academics_Details a WHERE a.session_SEQ_NO in :ids order by session_seq_no", nativeQuery = true)
	ArrayList<LMSAcademicsDetails> getSelectSessions(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "select coalesce(count(*),0) from LMS_ACADEMICS_DETAILS where (SESSION_SEQ_NO=:sSeqNo and SUBJECT_SEQ_NO=:subSeqNo)", nativeQuery = true)
	Long getCountForSessionAndSubject(@Param("sSeqNo") Long sSeqNo, @Param("subSeqNo") Long subSeqNo);
		
	@Query(value = "DELETE FROM LMS_Academics_Details WHERE a.session_seq_no in :ids", nativeQuery = true)
	void delSelectSessions(@Param("ids") ArrayList<Long> ids);
	
	@Modifying
	@Query(value = "delete from LMS_Academics_Details where (SESSION_SEQ_NO=:sSeqNo and SUBJECT_SEQ_NO=:subSeqNo)", nativeQuery = true)
	void delForSessionAndSubject(@Param("sSeqNo") Long sSeqNo, @Param("subSeqNo") Long subSeqNo);
	
} 


package academics_mgmt.academics_master.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import academics_mgmt.academics_master.model.master.LMSAcademicsMaster;
import academics_mgmt.academics_master.model.master.LMSAcademicsMasterPK;

@Repository("lmsAcademicsMasterRepo")
public interface LMSAcademicsMasterRepo extends CrudRepository<LMSAcademicsMaster, LMSAcademicsMasterPK> {
	@Query(value = "SELECT * FROM LMS_Academics_MASTER a WHERE a.session_SEQ_NO in :ids order by session_seq_no", nativeQuery = true)
	ArrayList<LMSAcademicsMaster> getSelectAcademicMasters(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_Academics_MASTER a WHERE a.status_seq_no < 0 order by session_seq_no", nativeQuery = true)
	ArrayList<LMSAcademicsMaster> getSelectAcademicMastersNotAllocated();

	@Query(value = "SELECT * FROM LMS_Academics_MASTER a WHERE (a.DETAIL_STATUS IS NULL or upper(trim(a.DETAIL_STATUS)) <> 'Y')", nativeQuery = true)
	ArrayList<LMSAcademicsMaster> getSelectAcademicMastersNotDetailed();

	@Modifying
	@Query(value = "update LMS_Academics_MASTER set detail_status='Y' WHERE (session_SEQ_NO = :sSeqNo and subject_SEQ_NO = :subSeqNo and rule_SEQ_NO = :rSeqNo)", nativeQuery = true)
	void updDetailedStatus(@Param("sSeqNo") Long sSeqNo, @Param("rSeqNo") Long rSeqNo,
			@Param("subSeqNo") Long subSeqNo);

	@Modifying
	@Query(value = "update LMS_Academics_MASTER set rule_line_seq_no=:rLineSeqNo WHERE (session_SEQ_NO = :sSeqNo and subject_SEQ_NO = :subSeqNo and rule_SEQ_NO = :rSeqNo)", nativeQuery = true)
	void updRuleLine(@Param("sSeqNo") Long sSeqNo, @Param("rSeqNo") Long rSeqNo, @Param("subSeqNo") Long subSeqNo,
			@Param("rLineSeqNo") Long rLineSeqNo);

	@Modifying
	@Query(value = "update LMS_Academics_MASTER set status_seq_no=0 WHERE (session_SEQ_NO = :sSeqNo and subject_SEQ_NO = :subSeqNo and rule_SEQ_NO = :rSeqNo)", nativeQuery = true)
	void updStatus(@Param("sSeqNo") Long sSeqNo, @Param("rSeqNo") Long rSeqNo, @Param("subSeqNo") Long subSeqNo);

	@Query(value = "DELETE FROM LMS_Academics_MASTER WHERE a.session_seq_no in :ids", nativeQuery = true)
	void delSelectAcademicMasters(@Param("ids") ArrayList<Long> ids);

	@Modifying
	@Query(value = "delete from LMS_ACADEMICS_MASTER where (SESSION_SEQ_NO=:sSeqNo and SUBJECT_SEQ_NO=:subSeqNo)", nativeQuery = true)
	void delForSessionAndSubject(@Param("sSeqNo") Long sSeqNo, @Param("subSeqNo") Long subSeqNo);

}

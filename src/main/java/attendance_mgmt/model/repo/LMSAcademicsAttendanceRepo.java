package attendance_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import attendance_mgmt.model.master.LMSAcademicsAttendance;
import attendance_mgmt.model.master.LMSAcademicsAttendancePK;

@Repository("lmsAcademicsAttendanceRepo")
public interface LMSAcademicsAttendanceRepo extends CrudRepository<LMSAcademicsAttendance, LMSAcademicsAttendancePK> 
{
	@Query(value = "SELECT * FROM LMS_Academics_Attendance a WHERE a.ACTION_INSTANCE_SEQ_NO in :ids order by ACTION_INSTANCE_SEQ_NO", nativeQuery = true)
	ArrayList<LMSAcademicsAttendance> getSelectAcademicsAttendances(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_Academics_Attendance a WHERE a.student_SEQ_NO in :ids order by student_seq_no", nativeQuery = true)
	ArrayList<LMSAcademicsAttendance> getSelectAcademicsAttendancesByStudents(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_Academics_Attendance_MASTER WHERE a.ACTION_INSTANCE_SEQ_NO in :ids", nativeQuery = true)
	void delSelectAcademicsAttendances(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_Academics_Attendance_MASTER WHERE a.student_SEQ_NO in :ids", nativeQuery = true)
	void delSelectAcademicsAttendancesByStudents(@Param("ids") ArrayList<Long> ids);
}

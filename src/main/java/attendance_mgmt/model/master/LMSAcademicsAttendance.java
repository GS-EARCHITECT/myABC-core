package attendance_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LMS_ACADEMICS_ATTENDANCE database table.
 * 
 */
@Entity
@Table(name="LMS_ACADEMICS_ATTENDANCE")
public class LMSAcademicsAttendance implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSAcademicsAttendancePK id;

	public LMSAcademicsAttendance() {
	}

	public LMSAcademicsAttendancePK getId() {
		return this.id;
	}

	public void setId(LMSAcademicsAttendancePK id) {
		this.id = id;
	}

	public LMSAcademicsAttendance(LMSAcademicsAttendancePK id) {
		super();
		this.id = id;
	}
	
	

}
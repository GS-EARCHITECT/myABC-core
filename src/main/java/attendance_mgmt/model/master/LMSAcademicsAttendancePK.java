package attendance_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_ACADEMICS_ATTENDANCE database table.
 * 
 */
@Embeddable
public class LMSAcademicsAttendancePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "STUDENT_SEQ_NO")
	private long studentSeqNo;

	@Column(name = "ACTION_INSTANCE_SEQ_NO")
	private long actionInstanceSeqNo;

	public LMSAcademicsAttendancePK() {
	}

	public long getStudentSeqNo() {
		return this.studentSeqNo;
	}

	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public long getActionInstanceSeqNo() {
		return this.actionInstanceSeqNo;
	}

	public void setActionInstanceSeqNo(long actionInstanceSeqNo) {
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSAcademicsAttendancePK)) {
			return false;
		}
		LMSAcademicsAttendancePK castOther = (LMSAcademicsAttendancePK) other;
		return (this.studentSeqNo == castOther.studentSeqNo)
				&& (this.actionInstanceSeqNo == castOther.actionInstanceSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.studentSeqNo ^ (this.studentSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.actionInstanceSeqNo ^ (this.actionInstanceSeqNo >>> 32)));

		return hash;
	}

	public LMSAcademicsAttendancePK(long studentSeqNo, long actionInstanceSeqNo) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

}
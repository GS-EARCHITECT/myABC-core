package worklist_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_ACADEMICS_WORKLISTS database table.
 * 
 */
@Entity
@Table(name = "LMS_ACADEMICS_WORKLISTS")
public class LMSAcademicsWorklists implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_ACADEMIC_WORKLIST_SEQUENCE")
	@SequenceGenerator(name = "LMS_ACADEMIC_WORKLIST_SEQUENCE", sequenceName = "LMS_ACADEMIC_WORKLIST_SEQUENCE", allocationSize = 1)
	@Column(name = "WORKLIST_SEQ_NO")
	private long worklistSeqNo;

	@Column(name = "ACTION_INSTANCE_SEQ_NO")
	private Long actionInstanceSeqNo;

	@Column(name = "FACULTY_SEQ_NO")
	private Long facultySeqNo;

	@Column(name = "STUDENT_SEQ_NO")
	private Long studentSeqNo;

	public LMSAcademicsWorklists() {
	}

	public long getWorklistSeqNo() {
		return this.worklistSeqNo;
	}

	public void setWorklistSeqNo(long worklistSeqNo) {
		this.worklistSeqNo = worklistSeqNo;
	}

	public Long getActionInstanceSeqNo() {
		return this.actionInstanceSeqNo;
	}

	public void setActionInstanceSeqNo(Long actionInstanceSeqNo) {
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public Long getFacultySeqNo() {
		return this.facultySeqNo;
	}

	public void setFacultySeqNo(Long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public Long getStudentSeqNo() {
		return this.studentSeqNo;
	}

	public void setStudentSeqNo(Long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionInstanceSeqNo == null) ? 0 : actionInstanceSeqNo.hashCode());
		result = prime * result + ((facultySeqNo == null) ? 0 : facultySeqNo.hashCode());
		result = prime * result + ((studentSeqNo == null) ? 0 : studentSeqNo.hashCode());
		result = prime * result + (int) (worklistSeqNo ^ (worklistSeqNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSAcademicsWorklists other = (LMSAcademicsWorklists) obj;
		if (actionInstanceSeqNo == null) {
			if (other.actionInstanceSeqNo != null)
				return false;
		} else if (!actionInstanceSeqNo.equals(other.actionInstanceSeqNo))
			return false;
		if (facultySeqNo == null) {
			if (other.facultySeqNo != null)
				return false;
		} else if (!facultySeqNo.equals(other.facultySeqNo))
			return false;
		if (studentSeqNo == null) {
			if (other.studentSeqNo != null)
				return false;
		} else if (!studentSeqNo.equals(other.studentSeqNo))
			return false;
		if (worklistSeqNo != other.worklistSeqNo)
			return false;
		return true;
	}

	public LMSAcademicsWorklists(long worklistSeqNo, Long actionInstanceSeqNo, Long facultySeqNo, Long studentSeqNo) {
		super();
		this.worklistSeqNo = worklistSeqNo;
		this.actionInstanceSeqNo = actionInstanceSeqNo;
		this.facultySeqNo = facultySeqNo;
		this.studentSeqNo = studentSeqNo;
	}

}
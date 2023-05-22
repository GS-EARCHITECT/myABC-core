package worklist_mgmt.model.dto;

import java.io.Serializable;

public class LMSAcademicsWorklistsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4581224326076976362L;
	private long worklistSeqNo;
	private Long actionInstanceSeqNo;
	private Long facultySeqNo;
	private Long studentSeqNo;

	public long getWorklistSeqNo() {
		return worklistSeqNo;
	}

	public void setWorklistSeqNo(long worklistSeqNo) {
		this.worklistSeqNo = worklistSeqNo;
	}

	public Long getActionInstanceSeqNo() {
		return actionInstanceSeqNo;
	}

	public void setActionInstanceSeqNo(Long actionInstanceSeqNo) {
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public Long getFacultySeqNo() {
		return facultySeqNo;
	}

	public void setFacultySeqNo(Long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public Long getStudentSeqNo() {
		return studentSeqNo;
	}

	public void setStudentSeqNo(Long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public LMSAcademicsWorklistsDTO(long worklistSeqNo, Long actionInstanceSeqNo, Long facultySeqNo, Long studentSeqNo) {
		super();
		this.worklistSeqNo = worklistSeqNo;
		this.actionInstanceSeqNo = actionInstanceSeqNo;
		this.facultySeqNo = facultySeqNo;
		this.studentSeqNo = studentSeqNo;
	}

	public LMSAcademicsWorklistsDTO() {
		super();
	}

}
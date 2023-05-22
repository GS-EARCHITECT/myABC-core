package attendance_mgmt.model.dto;

import java.io.Serializable;

public class LMSAcademicsAttendanceDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7976988381949924382L;
	private long studentSeqNo;
	private long actionInstanceSeqNo;

	public long getStudentSeqNo() {
		return studentSeqNo;
	}

	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public long getActionInstanceSeqNo() {
		return actionInstanceSeqNo;
	}

	public void setActionInstanceSeqNo(long actionInstanceSeqNo) {
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public LMSAcademicsAttendanceDTO(long studentSeqNo, long actionInstanceSeqNo) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public LMSAcademicsAttendanceDTO() {
		super();
	}

}
package academics_mgmt.academics_details.model.dto;

import java.io.Serializable;

public class LMSCourseMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8271908722379849357L;
	private Long course_seq_no;
	private String course;
	private String internal_refno;
	private Long instituteSeqNo;

	public Long getInstituteSeqNo() {
		return instituteSeqNo;
	}

	public void setInstituteSeqNo(Long instituteSeqNo) {
		this.instituteSeqNo = instituteSeqNo;
	}

	public Long getCourse_seq_no() {
		return course_seq_no;
	}

	public void setCourse_seq_no(Long course_seq_no) {
		this.course_seq_no = course_seq_no;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInternal_refno() {
		return internal_refno;
	}

	public void setInternal_refno(String internal_refno) {
		this.internal_refno = internal_refno;
	}

	public LMSCourseMasterDTO(Long course_seq_no, String course, String internal_refno, Long instituteSeqNo) {
		super();
		this.course_seq_no = course_seq_no;
		this.course = course;
		this.internal_refno = internal_refno;
		this.instituteSeqNo = instituteSeqNo;
	}

	public LMSCourseMasterDTO() {
		super();
	}

}

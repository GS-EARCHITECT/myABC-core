package academics_mgmt.academics_details.model.dto;

import java.io.Serializable;

public class LMSAcademicsDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7500010898907211749L;
	private long actionInstanceSeqNo;
	private Long sessionSeqNo;
	private Long subjectSeqNo;
	private String frDtTm;
	private String toDtTm;

	public long getActionInstanceSeqNo() {
		return actionInstanceSeqNo;
	}

	public void setActionInstanceSeqNo(long actionInstanceSeqNo) {
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public Long getSessionSeqNo() {
		return sessionSeqNo;
	}

	public void setSessionSeqNo(Long sessionSeqNo) {
		this.sessionSeqNo = sessionSeqNo;
	}

	public Long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public String getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(String frDtTm) {
		this.frDtTm = frDtTm;
	}

	public String getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(String toDtTm) {
		this.toDtTm = toDtTm;
	}

	public LMSAcademicsDetailsDTO() {
		super();
	}

	public LMSAcademicsDetailsDTO(long actionInstanceSeqNo, Long sessionSeqNo, Long subjectSeqNo, String frDtTm,
			String toDtTm) {
		super();
		this.actionInstanceSeqNo = actionInstanceSeqNo;
		this.sessionSeqNo = sessionSeqNo;
		this.subjectSeqNo = subjectSeqNo;
		this.frDtTm = frDtTm;
		this.toDtTm = toDtTm;
	}

}
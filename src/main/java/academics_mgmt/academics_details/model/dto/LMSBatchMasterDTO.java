package academics_mgmt.academics_details.model.dto;

import java.io.Serializable;

public class LMSBatchMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3317999040321901113L;
	private Long batchSeqNo;
	private String batchId;
	private String batchTitle;
	private String batchSummary;
	private Long courseSeqNo;
	private String frDttm;
	private String toDttm;

	public Long getBatchSeqNo() {
		return batchSeqNo;
	}

	public void setBatchSeqNo(Long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchSummary() {
		return batchSummary;
	}

	public void setBatchSummary(String batchSummary) {
		this.batchSummary = batchSummary;
	}

	public Long getCourseSeqNo() {
		return courseSeqNo;
	}

	public void setCourseSeqNo(Long courseSeqNo) {
		this.courseSeqNo = courseSeqNo;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public String getBatchTitle() {
		return batchTitle;
	}

	public void setBatchTitle(String batchTitle) {
		this.batchTitle = batchTitle;
	}

	public LMSBatchMasterDTO() {
		super();
	}

	public LMSBatchMasterDTO(Long batchSeqNo, String batchId, String batchTitle, String batchSummary, Long courseSeqNo,
			String frDttm, String toDttm) {
		super();
		this.batchSeqNo = batchSeqNo;
		this.batchId = batchId;
		this.batchTitle = batchTitle;
		this.batchSummary = batchSummary;
		this.courseSeqNo = courseSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

}
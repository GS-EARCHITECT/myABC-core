package academics_mgmt.academics_master.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSAcademicsMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8915131877133607292L;

	private long sessionSeqNo;
	private long subjectSeqNo;
	private long ruleSeqNo;
	private String fromDttm;
	private BigDecimal jobTypeSeqNo;
	private Long ruleLineSeqNo;
	private String scheduleData;
	private BigDecimal statusSeqNo;
	private String timeFr;
	private String timeTo;
	private String toDttm;

	public long getSessionSeqNo() {
		return sessionSeqNo;
	}

	public void setSessionSeqNo(long sessionSeqNo) {
		this.sessionSeqNo = sessionSeqNo;
	}

	public long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public long getRuleSeqNo() {
		return ruleSeqNo;
	}

	public void setRuleSeqNo(long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}

	public String getFromDttm() {
		return fromDttm;
	}

	public void setFromDttm(String fromDttm) {
		this.fromDttm = fromDttm;
	}

	public BigDecimal getJobTypeSeqNo() {
		return jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(BigDecimal jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public Long getRuleLineSeqNo() {
		return ruleLineSeqNo;
	}

	public void setRuleLineSeqNo(Long ruleLineSeqNo) {
		this.ruleLineSeqNo = ruleLineSeqNo;
	}

	public String getScheduleData() {
		return scheduleData;
	}

	public void setScheduleData(String scheduleData) {
		this.scheduleData = scheduleData;
	}

	public BigDecimal getStatusSeqNo() {
		return statusSeqNo;
	}

	public void setStatusSeqNo(BigDecimal statusSeqNo) {
		this.statusSeqNo = statusSeqNo;
	}

	public String getTimeFr() {
		return timeFr;
	}

	public void setTimeFr(String timeFr) {
		this.timeFr = timeFr;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public LMSAcademicsMasterDTO(long sessionSeqNo, long subjectSeqNo, long ruleSeqNo,
			java.lang.String fromDttm, BigDecimal jobTypeSeqNo, Long ruleLineSeqNo, java.lang.String scheduleData,
			BigDecimal statusSeqNo, java.lang.String timeFr, java.lang.String timeTo, java.lang.String toDttm) {
		super();
		this.sessionSeqNo = sessionSeqNo;
		this.subjectSeqNo = subjectSeqNo;
		this.ruleSeqNo = ruleSeqNo;
		this.fromDttm = fromDttm;
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.ruleLineSeqNo = ruleLineSeqNo;
		this.scheduleData = scheduleData;
		this.statusSeqNo = statusSeqNo;
		this.timeFr = timeFr;
		this.timeTo = timeTo;
		this.toDttm = toDttm;
	}

	public LMSAcademicsMasterDTO() {
		super();
	}

}
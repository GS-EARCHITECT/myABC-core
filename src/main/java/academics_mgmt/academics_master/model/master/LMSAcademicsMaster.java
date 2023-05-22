package academics_mgmt.academics_master.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the LMS_ACADEMICS_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_ACADEMICS_MASTER")
public class LMSAcademicsMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSAcademicsMasterPK id;

	@Column(name = "FROM_DTTM")
	private Timestamp fromDttm;

	@Column(name = "JOB_TYPE_SEQ_NO")
	private BigDecimal jobTypeSeqNo;

	@Column(name = "RULE_LINE_SEQ_NO")
	private Long ruleLineSeqNo;

	@Column(name = "SCHEDULE_DATA")
	private String scheduleData;

	@Column(name = "STATUS_SEQ_NO")
	private BigDecimal statusSeqNo;

	@Column(name = "TIME_FR")
	private String timeFr;

	@Column(name = "TIME_TO")
	private String timeTo;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public LMSAcademicsMaster() {
	}

	public LMSAcademicsMasterPK getId() {
		return this.id;
	}

	public void setId(LMSAcademicsMasterPK id) {
		this.id = id;
	}

	public Timestamp getFromDttm() {
		return this.fromDttm;
	}

	public void setFromDttm(Timestamp fromDttm) {
		this.fromDttm = fromDttm;
	}

	public BigDecimal getJobTypeSeqNo() {
		return this.jobTypeSeqNo;
	}

	public void setJobTypeSeqNo(BigDecimal jobTypeSeqNo) {
		this.jobTypeSeqNo = jobTypeSeqNo;
	}

	public Long getRuleLineSeqNo() {
		return this.ruleLineSeqNo;
	}

	public void setRuleLineSeqNo(Long ruleLineSeqNo) {
		this.ruleLineSeqNo = ruleLineSeqNo;
	}

	public String getScheduleData() {
		return this.scheduleData;
	}

	public void setScheduleData(String scheduleData) {
		this.scheduleData = scheduleData;
	}

	public BigDecimal getStatusSeqNo() {
		return this.statusSeqNo;
	}

	public void setStatusSeqNo(BigDecimal statusSeqNo) {
		this.statusSeqNo = statusSeqNo;
	}

	public String getTimeFr() {
		return this.timeFr;
	}

	public void setTimeFr(String timeFr) {
		this.timeFr = timeFr;
	}

	public String getTimeTo() {
		return this.timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public LMSAcademicsMaster(LMSAcademicsMasterPK id, Timestamp fromDttm, BigDecimal jobTypeSeqNo,
			Long ruleLineSeqNo, String scheduleData, BigDecimal statusSeqNo, String timeFr, String timeTo,
			Timestamp toDttm) {
		super();
		this.id = id;
		this.fromDttm = fromDttm;
		this.jobTypeSeqNo = jobTypeSeqNo;
		this.ruleLineSeqNo = ruleLineSeqNo;
		this.scheduleData = scheduleData;
		this.statusSeqNo = statusSeqNo;
		this.timeFr = timeFr;
		this.timeTo = timeTo;
		this.toDttm = toDttm;
	}

}
package academics_mgmt.academics_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_ACADEMICS_TEMPLATE_MASTER database table.
 * 
 */
@Embeddable
public class LMSAcademicsMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "SESSION_SEQ_NO")
	private long sessionSeqNo;

	@Column(name = "SUBJECT_SEQ_NO")
	private long subjectSeqNo;

	@Column(name = "RULE_SEQ_NO")
	private long ruleSeqNo;

	public LMSAcademicsMasterPK() {
	}

	public long getSessionSeqNo() {
		return this.sessionSeqNo;
	}

	public void setSessionSeqNo(long sessionSeqNo) {
		this.sessionSeqNo = sessionSeqNo;
	}

	public long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}

	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public long getRuleSeqNo() {
		return this.ruleSeqNo;
	}

	public void setRuleSeqNo(long ruleSeqNo) {
		this.ruleSeqNo = ruleSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSAcademicsMasterPK)) {
			return false;
		}
		LMSAcademicsMasterPK castOther = (LMSAcademicsMasterPK) other;
		return (this.sessionSeqNo == castOther.sessionSeqNo) && (this.subjectSeqNo == castOther.subjectSeqNo)
				&& (this.ruleSeqNo == castOther.ruleSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.sessionSeqNo ^ (this.sessionSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.subjectSeqNo ^ (this.subjectSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.ruleSeqNo ^ (this.ruleSeqNo >>> 32)));

		return hash;
	}

	public LMSAcademicsMasterPK(long sessionSeqNo, long subjectSeqNo, long ruleSeqNo) {
		super();
		this.sessionSeqNo = sessionSeqNo;
		this.subjectSeqNo = subjectSeqNo;
		this.ruleSeqNo = ruleSeqNo;
	}

}
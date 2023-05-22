package academics_mgmt.academics_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The persistent class for the LMS_ACADEMICS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_ACADEMICS_DETAILS")
public class LMSAcademicsDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_ACTION_INSTANCE_SEQUENCE")
	@SequenceGenerator(name = "LMS_ACTION_INSTANCE_SEQUENCE", sequenceName = "LMS_ACTION_INSTANCE_SEQUENCE", allocationSize = 1)
	@Column(name = "ACTION_INSTANCE_SEQ_NO")
	private long actionInstanceSeqNo;

	@Column(name = "SESSION_SEQ_NO")
	private Long sessionSeqNo;

	@Column(name = "SUBJECT_SEQ_NO")
	private Long subjectSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDtTm;

	@Column(name = "TO_DTTM")
	private Timestamp toDtTm;

	public LMSAcademicsDetails() {
	}

	public long getActionInstanceSeqNo() {
		return this.actionInstanceSeqNo;
	}

	public void setActionInstanceSeqNo(long actionInstanceSeqNo) {
		this.actionInstanceSeqNo = actionInstanceSeqNo;
	}

	public Long getSessionSeqNo() {
		return this.sessionSeqNo;
	}

	public void setSessionSeqNo(Long sessionSeqNo) {
		this.sessionSeqNo = sessionSeqNo;
	}

	public Long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}

	public void setSubjectSeqNo(Long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public Timestamp getFrDtTm() {
		return frDtTm;
	}

	public void setFrDtTm(Timestamp frDtTm) {
		this.frDtTm = frDtTm;
	}

	public Timestamp getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(Timestamp toDtTm) {
		this.toDtTm = toDtTm;
	}

	public LMSAcademicsDetails(long actionInstanceSeqNo, Long sessionSeqNo, Long subjectSeqNo, Timestamp frDtTm,
			Timestamp toDtTm) {
		super();
		this.actionInstanceSeqNo = actionInstanceSeqNo;
		this.sessionSeqNo = sessionSeqNo;
		this.subjectSeqNo = subjectSeqNo;
		this.frDtTm = frDtTm;
		this.toDtTm = toDtTm;
	}

}
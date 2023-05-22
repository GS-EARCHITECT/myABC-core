package academics_mgmt.academics_details.model.dto;

import java.io.Serializable;

public class LMSInstitutionMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1233607107698783711L;
	private Long institutionSeqNo;
	private Long locationSeqNo;
	private Long statusSeqNo;
	private String institution;

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Long getInstitutionSeqNo() {
		return institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Long getStatusSeqNo() {
		return statusSeqNo;
	}

	public void setStatusSeqNo(Long statusSeqNo) {
		this.statusSeqNo = statusSeqNo;
	}

	public LMSInstitutionMasterDTO() {
		super();
	}

	public LMSInstitutionMasterDTO(Long institutionSeqNo, Long locationSeqNo, Long statusSeqNo, String institution) {
		super();
		this.institutionSeqNo = institutionSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.statusSeqNo = statusSeqNo;
		this.institution = institution;
	}

}
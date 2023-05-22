package video_mgmt.model.dto;

import java.io.Serializable;

public class LMSVideoContentMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9021673486211161813L;
	private Long video_seq_no;
	private String name;
	private byte[] videoStream;

	public Long getVideo_seq_no() {
		return video_seq_no;
	}

	public void setVideo_seq_no(Long video_seq_no) {
		this.video_seq_no = video_seq_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getVideoStream() {
		return videoStream;
	}

	public void setVideoStream(byte[] videoStream) {
		this.videoStream = videoStream;
	}

	public LMSVideoContentMasterDTO(Long video_seq_no, String name, byte[] videoStream) {
		super();
		this.video_seq_no = video_seq_no;
		this.name = name;
		this.videoStream = videoStream;
	}

	public LMSVideoContentMasterDTO() {
		super();
	}

}
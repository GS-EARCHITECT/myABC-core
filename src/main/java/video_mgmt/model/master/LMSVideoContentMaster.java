package video_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_ACADEMICS_WORKLISTS database table.
 * 
 */
@Entity
@Table(name = "LMS_CONTENT_VIDEO_MASTER")
public class LMSVideoContentMaster implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1338648536003044346L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long video_seq_no;

	@Column(name = "NAME")
	private String name;

	@Lob
	@Column(name = "VIDEO_STREAM")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((video_seq_no == null) ? 0 : video_seq_no.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSVideoContentMaster other = (LMSVideoContentMaster) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (video_seq_no == null) {
			if (other.video_seq_no != null)
				return false;
		} else if (!video_seq_no.equals(other.video_seq_no))
			return false;
		return true;
	}

	public LMSVideoContentMaster(Long video_seq_no, String name, byte[] videoStream) {
		super();
		this.video_seq_no = video_seq_no;
		this.name = name;
		this.videoStream = videoStream;
	}

	public LMSVideoContentMaster() {
		super();
	}

}
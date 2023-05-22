package video_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import video_mgmt.model.master.LMSVideoContentMaster;

@Repository("lmsVideoContentRepo")
public interface LMSVideoContentRepo extends CrudRepository<LMSVideoContentMaster, Long> 
{
	@Query(nativeQuery = true, value="SELECT name FROM video")
    ArrayList<String> getAllEntryNames();
}

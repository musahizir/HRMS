package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.CvDetails;


public interface CvDetailsDao extends JpaRepository<CvDetails, Integer>{
	
	
	List<CvDetails> getAllByCv_CvId(int cvId);
	
	CvDetails findById(int id);

	

}

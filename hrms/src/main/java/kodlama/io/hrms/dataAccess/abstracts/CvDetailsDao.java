package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvDetails;


public interface CvDetailsDao extends JpaRepository<CvDetails, Integer>{
	
	List<CvDetails> getAllByCandidateId(int candidateId);

	

}

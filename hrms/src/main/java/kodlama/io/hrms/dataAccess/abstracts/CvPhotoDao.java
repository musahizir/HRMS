package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvPhoto;


public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer>{

	List<CvPhoto> getAllByCandidateId(int candidateId);
	
}

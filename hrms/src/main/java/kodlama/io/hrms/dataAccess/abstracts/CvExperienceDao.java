package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {

	List<CvExperience> getAllByCandidateIdOrderByCvExperienceLeaveDateDesc(int candidateId);
	
	List<CvExperience> getAllByCandidateId(int candidateId);
	
}

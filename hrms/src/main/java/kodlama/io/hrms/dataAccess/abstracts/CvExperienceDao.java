	package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {

	List<CvExperience> getAllByCv_CvIdOrderByCvExperienceLeaveDateDesc(int cvId);
	
	
	List<CvExperience> getAllByCv_CvId(int cvId);
	
	CvExperience findById(int id);
	
}

package kodlama.io.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer> {
	
	
	List<CvSchool> getAllByCandidateIdOrderByCvSchoolGraduateDate(int candidateId);
		
	List<CvSchool> getAllByCandidateId(int candidateId);
	

}

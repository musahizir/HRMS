package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto;

public interface JobAdDao extends JpaRepository<JobAd, Integer>{
	
	List<JobAd> findByjobAdIsActiveTrue();
	List<JobAd> findByOrderByJobAdPostedDate();
	
	@Query("From JobAd where jobAdIsActive = true and employer_id =:id")
	List<JobAd> getAllActiveJobAdByEmployer(int id);
	void save(JobAdRegisterDto jobAd);

}

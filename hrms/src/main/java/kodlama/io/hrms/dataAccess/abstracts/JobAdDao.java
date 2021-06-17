package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAd;

public interface JobAdDao extends JpaRepository<JobAd, Integer>{
	
	List<JobAd> findByjobAdIsActiveTrue();
	
	List<JobAd> findByOrderByJobAdPostedDate();
	
	@Query("From JobAd where jobAdIsActive = true and employer_id =:id")
	List<JobAd> getAllActiveJobAdByEmployer(int id);
	
	List<JobAd> getAllByJobAdIsConfirmedFalse();
	
	List<JobAd> findById(int id);
	
	/*
	 * @Query("From new kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto(jp.jobPositionId, ja.jobAdDescription, c.cityId, ja.jobAdMinWage, ja.jobAdMaxWage, ja.jobAdMaxOpenPosition, ja.jobAdApplicationEnd, e.employerId) From City c Inner Join c.jobAd ja + (From Employer e Inner Join e.jobAd ja) + (From JobPosition jp Inner Join jp.jobAd ja)"
	 * ) JobAdRegisterDto getJobAdWithJobPositionAndEmployerAndCity();
	 * 
	 * void save(JobAdRegisterDto jobAd);
	 */
	
}

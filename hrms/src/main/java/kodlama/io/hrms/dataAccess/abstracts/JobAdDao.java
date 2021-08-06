package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdFilterDto;

public interface JobAdDao extends JpaRepository<JobAd, Integer> {

	List<JobAd> findByjobAdIsActiveTrue();

	List<JobAd> findByOrderByJobAdPostedDate();

	@Query("From JobAd where jobAdIsActive = true and employer_id =:id")
	List<JobAd> getAllActiveJobAdByEmployer(int id);

	List<JobAd> getAllByJobAdIsConfirmedFalse();

	List<JobAd> findById(int id);

	@Query("From JobAd where jobAdIsConfirmed = false and jobAdConfirmRequest = true ")
	List<JobAd> getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue();

	@Query("Select j from kodlama.io.hrms.entities.concretes.JobAd j where ((:#{#filter.cityId}) IS NULL OR j.city.cityId IN (:#{#filter.cityId}))"
			+ " and ((:#{#filter.jobId}) IS NULL OR j.jobPosition.jobId IN (:#{#filter.jobId}))"
			+ " and ((:#{#filter.jobAdWorkingStyleId}) IS NULL OR j.jobAdWorkingStyle.jobAdWorkingStyleId IN (:#{#filter.jobAdWorkingStyleId}))"
			+ " and ((:#{#filter.jobAdShiftId}) IS NULL OR j.jobAdShift.jobAdShiftId IN (:#{#filter.jobAdShiftId}))"
			+ " and j.jobAdIsActive = true")
	public Page<JobAd> getByFilter(@Param("filter") JobAdFilterDto jobAdFilterDto, Pageable pageable);

}

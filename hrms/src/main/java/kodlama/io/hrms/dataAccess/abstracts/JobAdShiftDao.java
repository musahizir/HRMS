package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobAdShift;

public interface JobAdShiftDao extends JpaRepository<JobAdShift, Integer> {

	JobAdShift findByJobAdShiftId(int id);
}

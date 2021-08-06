package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobAdWorkingStyle;

public interface JobAdWorkingStyleDao extends JpaRepository<JobAdWorkingStyle, Integer> {

	JobAdWorkingStyle findById(int id);

}

package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer> {

	Cv findByCvId(int id);

	List<Cv> getAllBycvId(int id);

	List<Cv> getAllByCandidateId(int id);
}

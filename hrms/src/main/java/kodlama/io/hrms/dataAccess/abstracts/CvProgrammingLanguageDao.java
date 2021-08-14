package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;

public interface CvProgrammingLanguageDao extends JpaRepository<CvProgrammingLanguage, Integer> {

	List<CvProgrammingLanguage> getAllByCv_CvId(int cvId);

	CvProgrammingLanguage findByCvProgrammingLanguageId(int id);
}

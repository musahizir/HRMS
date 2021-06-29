package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvLanguage;


public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{
	
	List<CvLanguage> getAllByCv_CvId(int cvId);

	CvLanguage findById(int id);
}

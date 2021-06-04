package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLanguage;

public interface CvLanguageService {
	
	Result add(CvLanguage cvLanguage);

	Result update(CvLanguage cvLanguage);
	
	Result remove(int id);
	
	DataResult<List<CvLanguage>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvLanguage> cvLanguage);


}

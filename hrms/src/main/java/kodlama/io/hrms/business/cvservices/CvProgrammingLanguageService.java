package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;

public interface CvProgrammingLanguageService {
	
	Result add(CvProgrammingLanguage cvProgrammingLanguage);
	
	Result update(CvProgrammingLanguage cvProgrammingLanguage);
	
	Result remove(int id);
	
	DataResult<List<CvProgrammingLanguage>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvProgrammingLanguage> cvProgrammingLanguage);
	

}

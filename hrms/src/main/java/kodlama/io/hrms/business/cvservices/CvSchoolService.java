package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSchool;

public interface CvSchoolService {
	

	Result add(CvSchool cvSchool);
		
	Result update(CvSchool cvSchool);
	
	Result remove(int id);
	
	DataResult<List<CvSchool>> getAllByCandidateIdOrderByCvSchoolGraduateDate(int candidateId);
	
	DataResult<List<CvSchool>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvSchool> cvSchool);
	
}

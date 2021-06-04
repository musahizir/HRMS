package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvExperience;

public interface CvExperienceService {

	Result add(CvExperience cvExperience);

	Result update(CvExperience cvExperience);

	Result remove(int id);

	DataResult<List<CvExperience>> getAllByCandidateIdOrderByCvExperienceLeaveDateDesc(int candidateId);

	DataResult<List<CvExperience>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvExperience> cvExperience);
}

package kodlama.io.hrms.business.cvservices;


import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvDetails;

public interface CvDetailsService {

	
	Result add(CvDetails cvDetails);
	
	Result update(CvDetails cvDetails);
	
	Result remove(int id);

	DataResult<List<CvDetails>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvDetails> cvDetails);
}

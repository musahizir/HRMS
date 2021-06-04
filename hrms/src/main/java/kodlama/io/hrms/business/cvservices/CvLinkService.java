package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLink;

public interface CvLinkService {
	

	Result add(CvLink cvLink);
	
	Result update(CvLink cvLink);
	
	Result remove(int id);
	
	DataResult<List<CvLink>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvLink> cvLink);

}

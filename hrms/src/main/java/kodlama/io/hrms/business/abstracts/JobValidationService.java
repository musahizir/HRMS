package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Job;

public interface JobValidationService {
	
	Result validateJob(Job job);

}

package kodlama.io.hrms.business.auth;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionValidationService {

	Result validateJob(JobPosition job);

}

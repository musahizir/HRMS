package kodlama.io.hrms.business.auth;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerValidationService {

	Result validateEmployer(Employer employer);

}

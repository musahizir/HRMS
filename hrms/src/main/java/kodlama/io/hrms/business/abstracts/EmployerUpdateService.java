package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {

	DataResult<EmployerUpdate> employerSaveJson(EmployerUpdate employerUpdate);

}

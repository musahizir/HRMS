package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobAdWorkingStyle;

public interface JobAdWorkingStyleService {

	DataResult<List<JobAdWorkingStyle>> getAll();

	DataResult<JobAdWorkingStyle> getById(int id);
}

package kodlama.io.hrms.business.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionValidationManager implements JobPositionValidationService {

	private JobPositionDao jobDao;

	@Autowired
	public JobPositionValidationManager(JobPositionDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public Result validateJob(JobPosition job) {

		Result result = BusinessRules.Run(jobNameExist(job));

		if (result.isSuccess()) {

			return new SuccessResult();
		}
		return new ErrorResult();
	}

	private Result jobNameExist(JobPosition job) {

		if (jobDao.findByJobName(job.getJobName()) != null) {

			System.out.println("Bu iş bulunmaktadır");
			return new ErrorResult();
		}

		return new SuccessResult();

	}

}

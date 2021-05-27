package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobValidationService;
import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;

@Service
public class JobValidationManager implements JobValidationService {

	private JobDao jobDao;
	
	
	@Autowired
	public JobValidationManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public Result validateJob(Job job) {
		
		Result result = BusinessRules.Run(jobNameExist(job));
		
		if(result.isSuccess()) {
			
			return new SuccessResult();
		}
		return new ErrorResult();
	}
	
	private Result jobNameExist(Job job) {
		
		if(jobDao.findByJobName(job.getJobName()) != null ) {
			
			System.out.println("Bu iş bulunmaktadır");
			return new ErrorResult();
		}
		
		return new SuccessResult();
		
	}

}

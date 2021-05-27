package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.business.abstracts.JobValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobDao;
import kodlama.io.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	private JobValidationService jobValidationService;

	@Autowired
	public JobManager(JobDao jobDao, JobValidationService jobValidationService) {
		super();
		this.jobDao = jobDao;
		this.jobValidationService = jobValidationService;
	}

	@Override
	public DataResult<List<Job>> getAll() {

		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Job job) {

		if (jobValidationService.validateJob(job).isSuccess()) {

			this.jobDao.save(job);
			return new SuccessResult("İş pozisyonu eklendi");
			
			
		}
		return new ErrorResult("İş pozisyonu eklenemedi");

	}
}

package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.business.auth.JobPositionValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobDao;
	private JobPositionValidationService jobValidationService;

	@Autowired
	public JobPositionManager(JobPositionDao jobDao, JobPositionValidationService jobValidationService) {
		super();
		this.jobDao = jobDao;
		this.jobValidationService = jobValidationService;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.jobDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobPosition job) {

		if (jobValidationService.validateJob(job).isSuccess()) {

			this.jobDao.save(job);
			return new SuccessResult("İş pozisyonu eklendi");
			
			
		}
		return new ErrorResult("İş pozisyonu eklenemedi");

	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		JobPosition jobPosition = jobDao.findById(id);
		
		if(jobPosition == null) return new ErrorDataResult<JobPosition>();
		
		return new SuccessDataResult<JobPosition>(jobPosition);
	}
}

package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdWorkingStyleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdWorkingStyleDao;
import kodlama.io.hrms.entities.concretes.JobAdWorkingStyle;

@Service
public class JobAdWorkingStyleManager implements JobAdWorkingStyleService {

	private JobAdWorkingStyleDao jobAdWorkingStyleDao;

	@Autowired
	public JobAdWorkingStyleManager(JobAdWorkingStyleDao jobAdWorkingStyleDao) {
		super();
		this.jobAdWorkingStyleDao = jobAdWorkingStyleDao;
	}

	@Override
	public DataResult<List<JobAdWorkingStyle>> getAll() {

		return new SuccessDataResult<List<JobAdWorkingStyle>>(this.jobAdWorkingStyleDao.findAll());
	}

	@Override
	public DataResult<JobAdWorkingStyle> getById(int id) {
		JobAdWorkingStyle jobAdWorkingStyle = jobAdWorkingStyleDao.findById(id);
		if (jobAdWorkingStyle == null)
			return new ErrorDataResult<JobAdWorkingStyle>();
		return new SuccessDataResult<JobAdWorkingStyle>(jobAdWorkingStyle);
	}

}

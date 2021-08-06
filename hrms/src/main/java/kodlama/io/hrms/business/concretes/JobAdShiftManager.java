package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdShiftService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdShiftDao;
import kodlama.io.hrms.entities.concretes.JobAdShift;

@Service
public class JobAdShiftManager implements JobAdShiftService {

	private JobAdShiftDao jobAdShiftDao;

	@Autowired
	public JobAdShiftManager(JobAdShiftDao jobAdShiftDao) {
		super();
		this.jobAdShiftDao = jobAdShiftDao;
	}

	@Override
	public DataResult<List<JobAdShift>> getAll() {

		return new SuccessDataResult<List<JobAdShift>>(this.jobAdShiftDao.findAll());
	}

	@Override
	public DataResult<JobAdShift> getById(int id) {
		JobAdShift jobAdShift = jobAdShiftDao.findById(id);
		if (jobAdShift == null)
			return new ErrorDataResult<JobAdShift>();
		return new SuccessDataResult<JobAdShift>(jobAdShift);
	}

}

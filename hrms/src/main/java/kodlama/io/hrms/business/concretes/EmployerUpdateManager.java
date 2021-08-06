package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerUpdateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlama.io.hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

	private EmployerUpdateDao employerUpdateDao;

	@Autowired
	public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
		super();
		this.employerUpdateDao = employerUpdateDao;
	}

	@Override
	public DataResult<EmployerUpdate> employerSaveJson(EmployerUpdate employerUpdate) {

		return new SuccessDataResult<EmployerUpdate>(employerUpdateDao.save(employerUpdate));
	}

}

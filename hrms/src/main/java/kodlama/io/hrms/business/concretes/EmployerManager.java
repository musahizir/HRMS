package kodlama.io.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.auth.EmployerValidationManager;
import kodlama.io.hrms.core.concretes.BusinessRules;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidationManager employerValidationManager;

	@Autowired
	public EmployerManager(UserDao<Employer> userDao, EmployerValidationManager employerValidationManager) {
		super(userDao);
		this.employerDao = (EmployerDao) userDao;
		this.employerValidationManager = employerValidationManager;
	}

	

	@Override
	public Result add(Employer employer) {

		Result result = BusinessRules.Run(employerValidationManager.validateEmployer(employer),super.isEmailExist(employer.getEmail()));
		
		if (!result.isSuccess()) {

			if (!emailValidate(employer).isSuccess() || !hrmsConfirmation(employer).isSuccess() ) {

			}

			return result;
		}

	
		return new SuccessDataResult<Employer>(this.employerDao.save(employer), "İş veren eklendi");
	}

//sahte servisler
	private Result emailValidate(Employer employer) {

		return new SuccessResult();

	}

	private Result hrmsConfirmation(Employer employer) {

		return new SuccessResult();
	}

}

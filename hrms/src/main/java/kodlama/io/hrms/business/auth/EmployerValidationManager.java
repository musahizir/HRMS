package kodlama.io.hrms.business.auth;

import org.springframework.stereotype.Component;

import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;

@Component
public class EmployerValidationManager extends UserValidationManager implements EmployerValidationService{

	
	
	
	
	public Result validateEmployer(Employer employer) {
		
		Result result = BusinessRules.Run(employerNullCheck(employer));
		
		if (!result.isSuccess()) {

			return result;
		}
		return new SuccessResult();
	}
	
	
	public Result employerNullCheck(Employer employer) {

		if (!super.userNullCheck(employer).isSuccess()
				|| (employer.getCompanyName() == null || employer.getCompanyName().isBlank())
				|| (employer.getPhoneNumber() == null || employer.getPhoneNumber().isBlank())
				|| (employer.getWebsite() == null || employer.getWebsite().isBlank()) )
				{

			return new ErrorResult("Tüm alanları doldurunuz");

		}
		return new SuccessResult();
	}
	
}

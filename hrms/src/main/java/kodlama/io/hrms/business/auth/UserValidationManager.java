package kodlama.io.hrms.business.auth;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserValidationManager implements UserValidationService{

	
	public Result userNullCheck(User user) {
		
		if ((user.getEmail() == null || user.getEmail().isBlank()) || (user.getPassword() == null || user.getPassword().isBlank())) {
            return new ErrorResult("Bütün alanları doldurunuz");
        }
        return new SuccessResult();
    }
	
}



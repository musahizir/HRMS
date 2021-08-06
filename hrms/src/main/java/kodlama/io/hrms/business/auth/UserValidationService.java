package kodlama.io.hrms.business.auth;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;

public interface UserValidationService {

	Result userNullCheck(User user);

}

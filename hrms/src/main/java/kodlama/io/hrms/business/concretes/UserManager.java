package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserManager<T extends User> implements UserService<T> {

	
	private UserDao<T> userDao;
	
	@Autowired
	public UserManager(UserDao<T> userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() {
		
		return new SuccessDataResult<List<T>>(userDao.findAll(), "");
				
		
	}

	@Override
	public Result add(T t) {
	
		this.userDao.save(t);
		return new SuccessDataResult<T>("Kullanıcı eklendi");
	}
	
	public Result isEmailExist(String email) {
		
		if(userDao.findByEmail(email).isPresent()) {
			
			return new ErrorResult("Bu e-mail bulunmaktadır");
		}
		
		return new SuccessResult();
	}

}

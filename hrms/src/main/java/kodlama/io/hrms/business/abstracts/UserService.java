package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.User;

public interface UserService<T extends User> extends UserDetailsService{

	DataResult<List<T>> getAll();

	DataResult<T> getByEmail(String email);
	
	DataResult<T> getById(int id);
	
	Result add(T t);
	
	void addRoleToUser(String email, String roleName);

	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
	
	
	
	

}

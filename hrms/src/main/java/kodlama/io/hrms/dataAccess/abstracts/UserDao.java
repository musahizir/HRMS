package kodlama.io.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.User;

public interface UserDao<T extends User> extends JpaRepository<T, Integer>{
	
	Optional<T> findByEmail(String email);
	

}

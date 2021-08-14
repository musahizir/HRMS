package kodlama.io.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.User;

public interface UserDao<T extends User> extends JpaRepository<T, Integer> {

	T getById(int id);

	T getByEmail(String email);

}

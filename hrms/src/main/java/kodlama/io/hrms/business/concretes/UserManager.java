package kodlama.io.hrms.business.concretes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Role;
import kodlama.io.hrms.entities.concretes.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserManager<T extends User> implements UserService<T>, UserDetailsService {

	private final UserDao<T> userDao;
	private final RoleService roleService;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserManager(UserDao<T> userDao, RoleService roleService, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public DataResult<List<T>> getAll() {
		log.info("Bütün kullanıcılar getirildi ");
		return new SuccessDataResult<>(userDao.findAll());

	}

	@Override
	public Result add(T t) {

		log.info("Kullanıcı {} database'e eklendi", t.getId());
		t.setPassword(passwordEncoder.encode(t.getPassword()));
		this.userDao.save(t);
		return new SuccessDataResult<T>("Kullanıcı eklendi");
	}

	public Result isEmailExist(String email) {

		if (userDao.getByEmail(email) != null) {

			return new ErrorResult("Bu e-mail bulunmaktadır");
		}

		return new SuccessResult();
	}

	@Override
	public void addRoleToUser(String email, String roleName) {

		log.info("Kullanıcıya {} rol {} eklendi", email, roleName);

		Role role = roleService.getByRoleName(roleName);
		User user = userDao.getByEmail(email);
		user.getRoles().add(role);

	}

	@Override
	public DataResult<T> getByEmail(String email) {

		return new SuccessDataResult<>(this.userDao.getByEmail(email));
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userDao.getByEmail(email);

		if (email == null) {
			log.error("Kullanıcı bulunamadı");
			throw new UsernameNotFoundException("Kullanıcı bulunamadı");
		} else {
			log.info("Kullanıcı bulundu:{}", email);

		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public DataResult<T> getById(int id) {

		return new SuccessDataResult<>(this.userDao.getById(id));
	}

}

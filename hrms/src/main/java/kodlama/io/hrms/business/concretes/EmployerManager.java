package kodlama.io.hrms.business.concretes;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.Role;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EmployerManager extends UserManager<Employer> implements EmployerService {

	private final EmployerDao employerDao;
	private final RoleService roleService;
	private final PasswordEncoder passwordEncoder;



	@Autowired
	public EmployerManager(UserDao<Employer> userDao, RoleService roleService, PasswordEncoder passwordEncoder,
			EmployerDao employerDao) {
		super(userDao, roleService, passwordEncoder);
		this.employerDao = employerDao;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Result add(Employer employer) {

		Result result = BusinessRules.Run(super.isEmailExist(employer.getEmail()));

		if (!result.isSuccess()) {

			if (!emailValidate(employer).isSuccess() || !hrmsConfirmation(employer).isSuccess()) {

			}

			return result;
		}

		log.info("Kullanıcı {} database'e eklendi", employer.getId());
		employer.setPassword(passwordEncoder.encode(employer.getPassword()));
		return new SuccessDataResult<>(this.employerDao.save(employer), "İş veren eklendi");
	}

//sahte servisler
	private Result emailValidate(Employer employer) {

		return new SuccessResult();

	}

	private Result hrmsConfirmation(Employer employer) {

		return new SuccessResult();
	}

	@Override
	public DataResult<Employer> getById(int id) {
		Employer employer = employerDao.getById(id);
		if (employer == null)
			return new ErrorDataResult<>();

		return new SuccessDataResult<>(employer);
	}
	
	@Override
	public void addRoleToUser(String email, String roleName) {

		log.info("İş arayana {} rol {} eklendi", email, roleName);

		Role role = roleService.getByRoleName(roleName);
		Employer employer = employerDao.getByEmail(email);

		employer.getRoles().add(role);

	}

}

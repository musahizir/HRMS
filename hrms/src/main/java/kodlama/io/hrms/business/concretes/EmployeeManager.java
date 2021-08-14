package kodlama.io.hrms.business.concretes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employee;
import kodlama.io.hrms.entities.concretes.Role;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class EmployeeManager extends UserManager<Employee> implements EmployeeService {

	private final EmployeeDao employeeDao;
	private final RoleService roleService;
	private final PasswordEncoder passwordEncoder;


	@Autowired
	public EmployeeManager(UserDao<Employee> userDao, RoleService roleService, PasswordEncoder passwordEncoder,
			EmployeeDao employeeDao) {
		super(userDao, roleService, passwordEncoder);
		this.employeeDao = employeeDao;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<>(this.employeeDao.findAll(), "Liste getirildi");
	}

	@Override
	public Result add(Employee employee) {
		log.info("Kullanıcı {} database'e eklendi", employee.getId());
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan eklendi");
	}

	@Override
	public Result update(Employee employee, int id) {

		Employee employeeUpdate = employeeDao.getOne(id);
		employeeUpdate.setEmail(employee.getEmail());
		employeeUpdate.setFirstName(employee.getFirstName());
		employeeUpdate.setLastName(employee.getLastName());
		employeeUpdate.setPassword(employee.getPassword());

		employeeDao.save(employeeUpdate);
		return new SuccessResult();
	}

	@Override
	public Result delete(int employeeId) {

		this.employeeDao.deleteById(employeeId);
		return new SuccessResult();
	}

	@Override
	public DataResult<Employee> getById(int id) {
		Employee employee = employeeDao.getById(id);

		return new SuccessDataResult<>(employee);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {

		log.info("İş arayana {} rol {} eklendi", email, roleName);

		Role role = roleService.getByRoleName(roleName);
		Employee employee = employeeDao.getByEmail(email);

		employee.getRoles().add(role);

	}
}

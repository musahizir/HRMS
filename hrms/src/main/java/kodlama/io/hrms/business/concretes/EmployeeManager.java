package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeeDao;
import kodlama.io.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Liste getirildi");
	}

	@Override
	public Result add(Employee employee) {
		
		
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan eklendi");
	}

	@Override
	public Result update(Employee employee) {
		
		this.employeeDao.save(employee);
		return new SuccessResult();
	}

	@Override
	public Result delete(int employeeId) {
		
		this.employeeDao.deleteById(employeeId);
		return new SuccessResult();
	}

}

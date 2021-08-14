package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeService extends UserService<Employee> {

	Result update(Employee employee, int id);

	Result delete(int employeeId);

}

package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeControllers {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeControllers(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Employee>> getAll() {

		return this.employeeService.getAll();
	}

	@PostMapping("/add")
	Result add(@RequestBody Employee employee) {

		return this.employeeService.add(employee);
	}

	@PostMapping("/update")
	Result update(@RequestBody Employee employee, int id) {

		return this.employeeService.update(employee, id);
	}

	@PostMapping("/delete")
	Result delete(@RequestParam int employeeId) {

		return this.employeeService.delete(employeeId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		
		return this.employeeService.getById(id);
		
	}

}

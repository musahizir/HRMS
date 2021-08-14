package kodlama.io.hrms.api.controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.User;

@RequestMapping("/api/users")
@RestController
public class UsersController {

	private final UserService<User> userService;

	public UsersController(UserService<User> userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall")
	public <T> Result getAll() {

		userService.getAll();
		return new SuccessResult();
	}
	
	@GetMapping("/getById")
	public <T> Result getById(@RequestParam int id) {

		this.userService.getById(id);
		return new SuccessResult();
	}
	
	

}

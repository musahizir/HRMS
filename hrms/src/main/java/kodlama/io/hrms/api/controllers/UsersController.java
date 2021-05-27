package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.User;

@RequestMapping("/api/users")
@RestController
public class UsersController {
	
	private UserService<User> userService;
	public UsersController(UserService<User> userService) {
		super();
		this.userService = userService;
	}


	
	@GetMapping("/getall")
	public DataResult <List<User>> getAll(){
		
		return this.userService.getAll();
	}

}

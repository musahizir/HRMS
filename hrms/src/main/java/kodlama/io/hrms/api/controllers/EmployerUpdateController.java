package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.hrms.business.abstracts.EmployerUpdateService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.EmployerUpdate;

@CrossOrigin
@RestController
@RequestMapping("/api/employerUpdate")
public class EmployerUpdateController {

	private final EmployerUpdateService employerUpdateService;

	@Autowired
	public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
		super();
		this.employerUpdateService = employerUpdateService;
	}

	@PostMapping("/employerSaveJson")
	Result employerSaveJson(EmployerUpdate employerUpdate) {

		this.employerUpdateService.employerSaveJson(employerUpdate);
		return new SuccessResult();
	}

}

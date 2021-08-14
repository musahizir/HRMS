package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdWorkingStyleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobAdWorkingStyle;

@RestController
@RequestMapping("/api/jobAdWorkingStyle")
@CrossOrigin
public class JobAdWorkingStyleControllers {

	private final JobAdWorkingStyleService jobAdWorkingStyleService;

	@Autowired
	public JobAdWorkingStyleControllers(JobAdWorkingStyleService jobAdWorkingStyleService) {
		super();
		this.jobAdWorkingStyleService = jobAdWorkingStyleService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdWorkingStyle>> getAll() {

		return this.jobAdWorkingStyleService.getAll();

	}

	@GetMapping("/getById")
	public DataResult<JobAdWorkingStyle> getById(@RequestParam int id) {

		return this.jobAdWorkingStyleService.getById(id);
	}

}

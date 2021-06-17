package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdShiftService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobAdShift;

@RestController
@RequestMapping("/api/jobAdShift")
@CrossOrigin
public class JobAdShiftControllers {

	private JobAdShiftService jobAdShiftService;

	@Autowired
	public JobAdShiftControllers(JobAdShiftService jobAdShiftService) {
		super();
		this.jobAdShiftService = jobAdShiftService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<JobAdShift>> getAll(){
		
		return this.jobAdShiftService.getAll();
	}
}

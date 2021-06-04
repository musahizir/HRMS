package kodlama.io.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAd;

@RestController
@RequestMapping("/api/jobad")
public class JobAdController {
	
	
	private JobAdService jobAdService;

	@Autowired
	public JobAdController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAd jobAd) {
		
		return this.jobAdService.add(jobAd);
		
	}
	
	@PostMapping("/changeActiveToPassive")
	public Result changeActiveToPassive(int id) {
		return this.jobAdService.changeActiveToPassive(id);
		
	}
	
	@GetMapping("/findByjobAdIsActiveTrue")
	public DataResult<List<JobAd>> findByjobAdIsActiveTrue(){
		
		return this.jobAdService.findByjobAdIsActiveTrue();
		
	}
	
	@GetMapping("/findByOrderByJobAdPostedDate")
	DataResult<List<JobAd>> findByOrderByJobAdPostedDate(){
		return this.jobAdService.findByOrderByJobAdPostedDate();
	
	}
	
	@GetMapping("/getAllActiveJobAdByEmployer")
	DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id){
		return this.jobAdService.getAllActiveJobAdByEmployer(id);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

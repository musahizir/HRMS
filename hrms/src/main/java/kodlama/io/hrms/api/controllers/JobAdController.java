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

import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdFilterDto;
import kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto;

@RestController
@RequestMapping("/api/jobad")
@CrossOrigin
public class JobAdController {

	private final JobAdService jobAdService;

	@Autowired
	public JobAdController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdRegisterDto jobAdRegisterDto) {

		return this.jobAdService.add(jobAdRegisterDto);

	}

	@PostMapping("/remove")
	public Result remove(int id) {

		return this.jobAdService.remove(id);
	}

	@PostMapping("/changeActiveToPassive")
	public Result changeActiveToPassive(int id) {
		return this.jobAdService.changeActiveToPassive(id);

	}

	@PostMapping("/changePassiveToActive")
	public Result changePassiveToActive(int id) {
		return this.jobAdService.changePassiveToActive(id);

	}

	@PostMapping("/changeConfirmedFalseToTrue")

	public Result changeConfirmedFalseToTrue(int id) {

		return this.jobAdService.changeConfirmedFalseToTrue(id);
	}

	@PostMapping("/getAllPageNumberAndPageSizeAndFilter")
	public Result getAllPageNumberAndPageSizeAndFilter(@RequestParam int pageNo, int pageSize,
			@RequestBody JobAdFilterDto jobAdFilterDto) {

		return this.jobAdService.getAllPageNumberAndPageSizeAndFilter(pageNo, pageSize, jobAdFilterDto);
	}

	@PostMapping("/changeConfirmRequestTrueToFalse")

	public Result changeConfirmRequestTrueToFalse(int id) {

		return this.jobAdService.changeConfirmRequestTrueToFalse(id);
	}

	@GetMapping("/findByjobAdIsActiveTrue")
	public DataResult<List<JobAd>> findByjobAdIsActiveTrue() {

		return this.jobAdService.findByjobAdIsActiveTrue();

	}

	@GetMapping("/findByOrderByJobAdPostedDate")
	DataResult<List<JobAd>> findByOrderByJobAdPostedDate() {
		return this.jobAdService.findByOrderByJobAdPostedDate();

	}

	@GetMapping("/getAllActiveJobAdByEmployer")
	DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id) {
		return this.jobAdService.getAllActiveJobAdByEmployer(id);

	}

	@GetMapping("/getAllByJobAdIsConfirmedFalse")
	DataResult<List<JobAd>> getAllByJobAdIsConfirmedFalse() {

		return this.jobAdService.getAllByJobAdIsConfirmedFalse();
	}

	@PostMapping("/getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue")
	DataResult<List<JobAd>> getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue() {

		return this.jobAdService.getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue();
	}

}

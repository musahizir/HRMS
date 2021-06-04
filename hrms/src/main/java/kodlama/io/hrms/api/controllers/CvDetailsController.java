package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvDetails;


@RestController
@RequestMapping("/api/cvDetails")
public class CvDetailsController {

	private CvDetailsService cvDetailsService;

	@Autowired
	public CvDetailsController(CvDetailsService cvDetailsService) {
		super();
		this.cvDetailsService = cvDetailsService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvDetails cvDetails) {

		return this.cvDetailsService.add(cvDetails);

	}

	@PostMapping("/update")
	public Result update(@RequestBody CvDetails cvDetails) {

		return this.cvDetailsService.update(cvDetails);
	}

	@PostMapping("/remove")
	public Result remove(@RequestParam("id") int id) {

		return this.cvDetailsService.remove(id);

	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvDetails>> getAllByCandidateId(int candidateId) {

		return this.cvDetailsService.getAllByCandidateId(candidateId);
	}
}
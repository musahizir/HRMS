package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLink;

@RestController
@RequestMapping("/api/cvLink")
public class CvLinkController {

	private CvLinkService cvLinkService;
	
	@Autowired
	public CvLinkController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink) {
		
		return this.cvLinkService.add(cvLink);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLink cvLink ) {
		
		return this.update(cvLink);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvLinkService.remove(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvLink>> getAllByCandidateId(int candidateId) {

		return this.cvLinkService.getAllByCandidateId(candidateId);
	}
}

package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.cvservices.CvExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvExperience;

@RestController
@RequestMapping("/api/cvExperience")
public class CvExperienceController {
	
	
	private CvExperienceService cvExperienceService;
	
	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvExperience cvExperience) {
		
		return this.cvExperienceService.add(cvExperience);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvExperience cvExperience) {
		
		return this.cvExperienceService.update(cvExperience);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvExperienceService.remove(id);
	}
	
	@GetMapping("/getAllByCandidateIdOrderByCvExperienceLeaveDateDesc")
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByCvExperienceLeaveDateDesc(int candidateId)  {

		return this.cvExperienceService.getAllByCandidateIdOrderByCvExperienceLeaveDateDesc(candidateId);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvExperience>> getAllByCandidateId(int candidateId) {

		return this.cvExperienceService.getAllByCandidateId(candidateId);
	}

}

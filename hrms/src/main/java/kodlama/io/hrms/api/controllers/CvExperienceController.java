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

import kodlama.io.hrms.business.cvservices.CvExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvExperience;
import kodlama.io.hrms.entities.concretes.dto.CvExperienceDto;

@RestController
@RequestMapping("/api/cvExperience")
@CrossOrigin
public class CvExperienceController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvExperienceDto cvExperienceDto) {

		return this.cvExperienceService.add(cvExperienceDto);

	}

	@PostMapping("/update")
	public Result update(@RequestBody CvExperienceDto cvExperienceDto, int id) {

		return this.cvExperienceService.update(cvExperienceDto, id);
	}

	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {

		return this.cvExperienceService.remove(id);
	}

	@GetMapping("/getAllByCandidateIdOrderByCvExperienceLeaveDateDesc")
	public DataResult<List<CvExperience>> getAllByCv_CvIdOrderByCvExperienceLeaveDateDesc(int cvId) {

		return this.cvExperienceService.getAllByCv_CvIdOrderByCvExperienceLeaveDateDesc(cvId);
	}

	@GetMapping("/getAllByCv")
	public DataResult<List<CvExperience>> getAllByCv_CvId(int cvId) {

		return this.cvExperienceService.getAllByCv_CvId(cvId);
	}

	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {

		return this.cvExperienceService.getById(id);

	}

}

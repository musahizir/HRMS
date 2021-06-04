package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;


@RestController
@RequestMapping("/api/programmingLanguage")
public class CvProgrammingLanguageController {
	
	private CvProgrammingLanguageService cvProgrammingLanguageService;
	
	@Autowired
	public CvProgrammingLanguageController(CvProgrammingLanguageService cvProgrammingLanguageService) {
		super();
		this.cvProgrammingLanguageService = cvProgrammingLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvProgrammingLanguage cvProgrammingLanguage) {
		
		return this.cvProgrammingLanguageService.add(cvProgrammingLanguage);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvProgrammingLanguage cvProgrammingLanguage) {
		
		return this.cvProgrammingLanguageService.update(cvProgrammingLanguage);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvProgrammingLanguageService.remove(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvProgrammingLanguage>> getAllByCandidateId(int candidateId) {

		return this.cvProgrammingLanguageService.getAllByCandidateId(candidateId);
	}

}

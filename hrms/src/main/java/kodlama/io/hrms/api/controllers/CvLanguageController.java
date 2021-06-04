package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLanguage;


@RestController
@RequestMapping("/api/cvLanguage")
public class CvLanguageController {
	
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguageController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		
		return this.cvLanguageService.add(cvLanguage);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLanguage cvLanguage ) {
		
		return this.cvLanguageService.update(cvLanguage);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvLanguageService.remove(id);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvLanguage>> getAllByCandidateId(int candidateId)  {

		return this.cvLanguageService.getAllByCandidateId(candidateId);
	}
}

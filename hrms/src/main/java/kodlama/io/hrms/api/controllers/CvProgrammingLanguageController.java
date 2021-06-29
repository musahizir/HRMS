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

import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;
import kodlama.io.hrms.entities.concretes.dto.CvProgrammingLanguageDto;


@RestController
@RequestMapping("/api/programmingLanguage")
@CrossOrigin
public class CvProgrammingLanguageController {
	
	private CvProgrammingLanguageService cvProgrammingLanguageService;
	
	@Autowired
	public CvProgrammingLanguageController(CvProgrammingLanguageService cvProgrammingLanguageService) {
		super();
		this.cvProgrammingLanguageService = cvProgrammingLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvProgrammingLanguageDto cvProgrammingLanguageDto) {
		
		return this.cvProgrammingLanguageService.add(cvProgrammingLanguageDto);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvProgrammingLanguageDto cvProgrammingLanguageDto, int id) {
		
		return this.cvProgrammingLanguageService.update(cvProgrammingLanguageDto, id);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvProgrammingLanguageService.remove(id);
	}
	
	@GetMapping("/getAllByCv")
	public DataResult<List<CvProgrammingLanguage>> getAllByCv_CvId(int cvId) {

		return this.cvProgrammingLanguageService.getAllByCv_CvId(cvId);
	}

}

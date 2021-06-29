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

import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLanguage;
import kodlama.io.hrms.entities.concretes.dto.CvLanguageDto;


@RestController
@RequestMapping("/api/cvLanguage")
@CrossOrigin
public class CvLanguageController {
	
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguageController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}

	
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguageDto cvLanguageDto) {
		
		return this.cvLanguageService.add(cvLanguageDto);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLanguageDto cvLanguageDto, int id ) {
		
		return this.cvLanguageService.update(cvLanguageDto, id);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvLanguageService.remove(id);
	}
	
	@GetMapping("/getAllByCv")
	public DataResult<List<CvLanguage>> getAllByCv_CvId(int cvId)  {

		return this.cvLanguageService.getAllByCv_CvId(cvId);
	}
}

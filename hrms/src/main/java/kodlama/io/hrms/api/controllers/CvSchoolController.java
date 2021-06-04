package kodlama.io.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.cvservices.CvSchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSchool;


@RestController
@RequestMapping("/api/cvSchool")
public class CvSchoolController {
	
	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSchool cvSchool) {
		
		return this.cvSchoolService.add(cvSchool);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvSchool cvSchool) {
		
		return this.cvSchoolService.update(cvSchool);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvSchoolService.remove(id);
	}
	
	@GetMapping("/getAllByCandidateIdOrderByCvSchoolGraduateDate")
	public DataResult<List<CvSchool>> getAllByCandidateIdOrderByCvSchoolGraduateDate(int candidateId) {

		return this.cvSchoolService.getAllByCandidateIdOrderByCvSchoolGraduateDate(candidateId);
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvSchool>> getAllByCandidateId(int candidateId) {

		return this.cvSchoolService.getAllByCandidateId(candidateId);
	}
	
	
}

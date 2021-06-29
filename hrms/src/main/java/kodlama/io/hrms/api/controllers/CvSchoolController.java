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

import kodlama.io.hrms.business.cvservices.CvSchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSchool;
import kodlama.io.hrms.entities.concretes.dto.CvSchoolDto;


@RestController
@RequestMapping("/api/cvSchool")
@CrossOrigin
public class CvSchoolController {
	
	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSchoolDto cvSchoolDto) {
		
		return this.cvSchoolService.add(cvSchoolDto);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvSchoolDto cvSchoolDto, int id) {
		
		return this.cvSchoolService.update(cvSchoolDto, id);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvSchoolService.remove(id);
	}
	
	@GetMapping("/getAllByCandidateIdOrderByCvSchoolGraduateDate")
	public DataResult<List<CvSchool>> getAllByCv_CvIdOrderByCvSchoolGraduateDate(int cvId) {

		return this.cvSchoolService.getAllByCv_CvIdOrderByCvSchoolGraduateDate(cvId);
	}
	
	@GetMapping("/getAllByCv")
	public DataResult<List<CvSchool>> getAllByCv_CvId(int cvId) {

		return this.cvSchoolService.getAllByCv_CvId(cvId);
	}
	
	
}

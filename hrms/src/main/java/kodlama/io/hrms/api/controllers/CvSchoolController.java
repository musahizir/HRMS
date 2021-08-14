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

import kodlama.io.hrms.business.abstracts.cvservices.CvSchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSchool;
import kodlama.io.hrms.entities.concretes.dto.CvSchoolDto;

@RestController
@RequestMapping("/api/cvSchool")
@CrossOrigin
public class CvSchoolController {

	private final CvSchoolService cvSchoolService;

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
	public DataResult<List<CvSchool>> getAllByCvIdOrderByCvSchoolGraduateDate(int cvId) {

		return this.cvSchoolService.getAllByCvIdOrderByCvSchoolGraduateDate(cvId);
	}

	@GetMapping("/getAllByCv")
	public DataResult<List<CvSchool>> getAllByCvId(int cvId) {

		return this.cvSchoolService.getAllByCvId(cvId);
	}

	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {

		return this.cvSchoolService.getById(id);

	}

}

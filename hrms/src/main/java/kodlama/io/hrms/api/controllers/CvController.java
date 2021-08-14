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

import kodlama.io.hrms.business.abstracts.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.dto.CvAddDto;

@RestController
@RequestMapping("/api/cvController")
@CrossOrigin
public class CvController {

	private final CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@PostMapping("/add")
	Result add(@RequestBody CvAddDto cvAddDto) {

		return this.cvService.add(cvAddDto);
	}

	@GetMapping("/getAllByCandidateId")

	public DataResult<List<Cv>> getAllByCandidateId(@RequestParam int id) {

		return this.cvService.getAllByCandidateId(id);

	}

}

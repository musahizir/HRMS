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

import kodlama.io.hrms.business.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.dto.CvAddDto;
import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;
import kodlama.io.hrms.entities.concretes.dto.CvDto;


@RestController
@RequestMapping("/api/cvController")
@CrossOrigin
public class CvController {

	private CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}


	
	

	@PostMapping("/addx")
	Result addx(@RequestBody Cv cv) {

		return this.cvService.addx(cv);
	}
	@PostMapping("/add")
	Result add(@RequestBody CvAddDto cvAddDto){

		return this.cvService.add(cvAddDto);
	}

	
	@PostMapping("/cvDetailsAdd")
	Result cvDetailsAdd( @RequestBody CvDetailsDto cvDetailsDto) {
	
	
		return this.cvService.cvDetailsAdd( cvDetailsDto);
	}
	
	
    @GetMapping("/getAllByCandidateId")
	
	public DataResult<List<Cv>> getAllByCandidateId(@RequestParam int id){
		
		return this.cvService.getAllByCandidateId(id);
		
		
	}

}

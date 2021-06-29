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

import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvDetails;
import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;


@RestController
@RequestMapping("/api/cvDetails")
@CrossOrigin
public class CvDetailsController {

	private CvDetailsService cvDetailsService;

	@Autowired
	public CvDetailsController(CvDetailsService cvDetailsService) {
		super();
		this.cvDetailsService = cvDetailsService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvDetailsDto cvDetailsDto) {

		return this.cvDetailsService.add(cvDetailsDto);

	}

	@PostMapping("/update")
	public Result update(@RequestBody CvDetailsDto cvDetailsDto,int id) {

		return this.cvDetailsService.update(cvDetailsDto, id);
	}

	@PostMapping("/remove")
	public Result remove(@RequestParam("id") int id) {

		return this.cvDetailsService.remove(id);

	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		
		return this.cvDetailsService.getById(id);
		
	}
	
	

	@GetMapping("/getAllByCv")
	public DataResult<List<CvDetails>> getAllByCv_CvId(int cvId) {

		return this.cvDetailsService.getAllByCv_CvId(cvId);
	}
}
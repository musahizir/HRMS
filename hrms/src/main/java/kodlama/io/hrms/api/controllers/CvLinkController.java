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

import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLink;
import kodlama.io.hrms.entities.concretes.dto.CvLinkDto;

@RestController
@RequestMapping("/api/cvLink")
@CrossOrigin
public class CvLinkController {

	private CvLinkService cvLinkService;
	
	@Autowired
	public CvLinkController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvLinkDto cvLinkDto) {
		
		return this.cvLinkService.add(cvLinkDto);
	
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvLinkDto cvLinkDto, int id) {
		
		return this.cvLinkService.update(cvLinkDto, id);
	}
	
	@PostMapping("/delete")
	public Result remove(@RequestParam("id") int id) {
		
		return this.cvLinkService.remove(id);
	}
	
	@GetMapping("/getAllByCv")
	public DataResult<List<CvLink>> getAllBgetAllByCv_CvIdyCvId(int cvId) {

		return this.cvLinkService.getAllByCv_CvId(cvId);
	}
	
	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {
		
		return this.cvLinkService.getById(id);
		
	}
}

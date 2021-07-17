package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.FavoriteJobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.FavoriteJobAd;
import kodlama.io.hrms.entities.concretes.dto.FavoriteJobAdDto;

@RestController
@RequestMapping("/api/favoriteJobAd")
@CrossOrigin
public class FavoriteJobAdController {
	
	private FavoriteJobAdService favoriteJobAdService;

	@Autowired
	public FavoriteJobAdController(FavoriteJobAdService favoriteJobAdService) {
		super();
		this.favoriteJobAdService = favoriteJobAdService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody FavoriteJobAdDto favoriteJobAdDto) {
		
		return this.favoriteJobAdService.add(favoriteJobAdDto);
	
	}
	
@GetMapping("/getall")
	public DataResult<List<FavoriteJobAd>> getAll(){
		
		return this.favoriteJobAdService.getAll();
		
		
	}


@GetMapping("/getByCandidateId")
      public DataResult<List<FavoriteJobAd>> getByCandidateId(int id) {
	
	return this.favoriteJobAdService.getByCandidateId(id);
}
}

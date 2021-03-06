package kodlama.io.hrms.api.controllers;


import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;


@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

	private final CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();

	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {

		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/candidates/add").toUriString());
		
		return ResponseEntity.created(uri).body(this.candidateService.add(candidate));
	}

	@GetMapping("/getById")
	public Result getById(@RequestParam int id) {

		return this.candidateService.getById(id);

	}

	@PostMapping("/saveRoleToCandidate")
	public ResponseEntity<?> saveRoleToCandidate(@RequestBody String email, String roleName){
		
		candidateService.addRoleToUser(email, roleName);
		
		return ResponseEntity.ok().build();		
	}
	
	
}

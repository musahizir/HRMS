package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateService extends UserService<Candidate> {
	
	public DataResult <List<Candidate>> getAll();
	
	Result add(Candidate candidate);
	

}

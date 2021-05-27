package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidate;


public interface CandidateValidationService  {
	
	Result validateCandidate (Candidate candidate);
	
	Result candidateNullCheck(Candidate candidate);

}

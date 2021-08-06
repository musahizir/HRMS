package kodlama.io.hrms.core.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface MernisService {

	public boolean checkIfRealPerson(Candidate candidate);
}

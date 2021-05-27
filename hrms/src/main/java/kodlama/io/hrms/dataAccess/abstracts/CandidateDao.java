package kodlama.io.hrms.dataAccess.abstracts;

import java.util.Optional;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate> {

	Optional<Candidate> findByNationalityId(String nationalityId);

}

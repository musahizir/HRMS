package kodlama.io.hrms.business.auth;

import org.springframework.stereotype.Component;

import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

import kodlama.io.hrms.entities.concretes.Candidate;

@Component
public class CandidateValidationManager extends UserValidationManager implements CandidateValidationService {

	public Result validateCandidate(Candidate candidate) {

		Result result = BusinessRules.Run(candidateNullCheck(candidate));
		if (!result.isSuccess()) {

			return result;
		}
		return new SuccessResult();
	}

	public Result candidateNullCheck(Candidate candidate) {

		if (!super.userNullCheck(candidate).isSuccess()
				|| (candidate.getFirstName() == null || candidate.getFirstName().isBlank())
				|| (candidate.getLastName() == null || candidate.getLastName().isBlank())
				|| (candidate.getNationalityId() == null || candidate.getNationalityId().isBlank())
				|| (candidate.getBirthYear() == 0)) {

			return new ErrorResult("Tüm alanları doldurunuz");

		}
		return new SuccessResult();
	}

}

package kodlama.io.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.CandidateValidationService;
import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateValidationService candidateValidationService;

	@Autowired
	public CandidateManager(UserDao<Candidate> userDao, CandidateValidationService candidateValidationService) {
		super(userDao);
		this.candidateDao = (CandidateDao) userDao;
		this.candidateValidationService = candidateValidationService;
	}
	
	
	

	@Override
	public Result add(Candidate candidate) {

		Result result = BusinessRules.Run(this.candidateValidationService.validateCandidate(candidate),
				mernisValidate(candidate),nationalityIdExist(candidate.getNationalityId()),super.isEmailExist(candidate.getEmail()));

		if (!result.isSuccess()) {

			if (!emailValidate(candidate).isSuccess()) {

			}
			return result;
		}

		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate), "İş arayan eklendi");

	}
	
	
	private Result nationalityIdExist(String nationalityId) {

		if (candidateDao.findByNationalityId(nationalityId).isPresent()) {

			
			return new ErrorResult("Bu kimlik numarası kullanılıyor");
		}
		return new SuccessResult();
	}

//sahte servisler
	private Result mernisValidate(Candidate candidate) {

		if (candidate.getBirthYear().contains("4")) {

			return new SuccessResult();
		}
		return new ErrorResult("Mernis");
	}

	private Result emailValidate(Candidate candidate) {

		return new SuccessResult();
	}
	
	

}

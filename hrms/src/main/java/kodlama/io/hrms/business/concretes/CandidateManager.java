package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.auth.CandidateValidationService;
import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.business.cvservices.CvExperienceService;
import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.business.cvservices.CvSchoolService;
import kodlama.io.hrms.core.abstracts.MernisService;
import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CvDetails;
import kodlama.io.hrms.entities.concretes.dto.CvDto;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateValidationService candidateValidationService;
	private MernisService mernisService;
//	private CvDetailsService cvDetailsService;
//	private CvExperienceService cvExperienceService;
//	private CvLanguageService cvLanguageService;
//	private CvProgrammingLanguageService cvProgrammingLanguageService;
//	private CvSchoolService cvSchoolService;
//	private CvLinkService cvLinkService;

	@Autowired
	public CandidateManager(UserDao<Candidate> userDao, CandidateDao candidateDao,
			CandidateValidationService candidateValidationService, MernisService mernisService
			) {
		super(userDao);
		this.candidateDao = candidateDao;
		this.candidateValidationService = candidateValidationService;
		this.mernisService = mernisService;
//		this.cvDetailsService = cvDetailsService;
//		this.cvExperienceService = cvExperienceService;
//		this.cvLanguageService = cvLanguageService;
//		this.cvProgrammingLanguageService = cvProgrammingLanguageService;
//		this.cvSchoolService = cvSchoolService;
//		this.cvLinkService = cvLinkService;
	}

	

	@Override
	public Result add(Candidate candidate) {

		Result result = BusinessRules.Run(this.candidateValidationService.validateCandidate(candidate),
				nationalityIdExist(candidate.getNationalityId()), super.isEmailExist(candidate.getEmail()));

		
		
		if (!result.isSuccess()) {

			if (fakemernisValidate(candidate)) {

				if (!emailValidate(candidate).isSuccess()) {

				}

				return result;
			}
			return new ErrorResult("Mernis hatası");
		}
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate), "İş arayan eklendi");

	}

	private Result nationalityIdExist(String nationalityId) {

		if (candidateDao.findByNationalityId(nationalityId).isPresent()) {

			return new ErrorResult("Bu kimlik numarası kullanılıyor");
		}
		return new SuccessResult();
	}

//sahte servisle
	private boolean fakemernisValidate(Candidate candidate) {

		if (candidate.getNationalityId().length() < 11) {

			return true;
		}
		
		return false;
	}

	private Result emailValidate(Candidate candidate) {

		return new SuccessResult();
	}


	@Override
	public DataResult<Candidate> getById(int id) {
		Candidate candidate = candidateDao.findById(id);
		return new SuccessDataResult<Candidate>(candidate);
	}

	

	@Override
	public DataResult<CvDto> getCvByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

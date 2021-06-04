package kodlama.io.hrms.business.cvmanagers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.business.cvservices.CvExperienceService;
import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.business.cvservices.CvSchoolService;
import kodlama.io.hrms.business.cvservices.CvService;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.dto.CvDto;

@Service
public class CvManager implements CvService {

	private CandidateService candidateService;
	private CvDetailsService cvDetailsService;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvProgrammingLanguageService cvProgrammingLanguageService;
	private CvSchoolService cvSchoolService;
	private CvLinkService cvLinkService;
	
	@Autowired
	public CvManager(CandidateService candidateService, CvDetailsService cvDetailsService,
			CvExperienceService cvExperienceService, CvLanguageService cvLanguageService,
			CvProgrammingLanguageService cvProgrammingLanguageService, CvSchoolService cvSchoolService,
			CvLinkService cvLinkService) {
		super();
		this.candidateService = candidateService;
		this.cvDetailsService = cvDetailsService;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvProgrammingLanguageService = cvProgrammingLanguageService;
		this.cvSchoolService = cvSchoolService;
		this.cvLinkService = cvLinkService;
	}


	@Override
	public Result add(CvDto cvDto, int candidateId) {
		
		Candidate candidate = candidateService.getById(candidateId).getData();
		cvDto.setCandidate(candidate);
		
		cvDto.getCvDetails().forEach(cvDetails -> cvDetails.setCandidate(candidate));
		cvDetailsService.addAll(cvDto.getCvDetails());
		
		cvDto.getCvExperience().forEach(cvExperience -> cvExperience.setCandidate(candidate));
		cvExperienceService.addAll(cvDto.getCvExperience());
		
		cvDto.getCvLanguage().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
		cvLanguageService.addAll(cvDto.getCvLanguage());
		
		cvDto.getCvProgrammingLanguage().forEach(cvProgrammingLanguage -> cvProgrammingLanguage.setCandidate(candidate));
		cvProgrammingLanguageService.addAll(cvDto.getCvProgrammingLanguage());
		
		cvDto.getCvSchool().forEach(cvSchool -> cvSchool.setCandidate(candidate));
		cvSchoolService.addAll(cvDto.getCvSchool());
		
		cvDto.getCvLink().forEach(cvLink -> cvLink.setCandidate(candidate));
		cvLinkService.addAll(cvDto.getCvLink());
		
		
	
		return new SuccessResult();
	}


	

}

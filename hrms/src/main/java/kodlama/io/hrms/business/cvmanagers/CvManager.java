package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.business.cvservices.CvExperienceService;
import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.business.cvservices.CvPhotoService;
import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.business.cvservices.CvSchoolService;
import kodlama.io.hrms.business.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.CvDetails;


import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;
import kodlama.io.hrms.entities.concretes.dto.CvDto;


@Service
public class CvManager implements CvService {

//	private CandidateService candidateService;
//	private CvDetailsService cvDetailsService;
//	private CvExperienceService cvExperienceService;
//	private CvLanguageService cvLanguageService;
//	private CvProgrammingLanguageService cvProgrammingLanguageService;
//	private CvSchoolService cvSchoolService;
//	private CvLinkService cvLinkService;
//	private CvDao cvDao;
//	
//	@Autowired
//	public CvManager(CandidateService candidateService, CvDetailsService cvDetailsService,
//			CvExperienceService cvExperienceService, CvLanguageService cvLanguageService,
//			CvProgrammingLanguageService cvProgrammingLanguageService, CvSchoolService cvSchoolService,
//			CvLinkService cvLinkService, CvDao cvDao) {
//		super();
//		this.candidateService = candidateService;
//		this.cvDetailsService = cvDetailsService;
//		this.cvExperienceService = cvExperienceService;
//		this.cvLanguageService = cvLanguageService;
//		this.cvProgrammingLanguageService = cvProgrammingLanguageService;
//		this.cvSchoolService = cvSchoolService;
//		this.cvLinkService = cvLinkService;
//		this.cvDao = cvDao;
//	}

	
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		
		
		this.cvDao = cvDao;
		
	}

	@Override
	public Result add(CvDto cvDto, int candidateId) {
//		
//		Candidate candidate = candidateService.getById(candidateId).getData();
//		cvDto.setCandidate(candidate);
//		
//		cvDto.getCvDetails().forEach(cvDetails -> cvDetails.setCandidate(candidate));
//		cvDetailsService.addAll(cvDto.getCvDetails());
//		
//		cvDto.getCvExperience().forEach(cvExperience -> cvExperience.setCandidate(candidate));
//		cvExperienceService.addAll(cvDto.getCvExperience());
//		
//		cvDto.getCvLanguage().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
//		cvLanguageService.addAll(cvDto.getCvLanguage());
//		
//		cvDto.getCvProgrammingLanguage().forEach(cvProgrammingLanguage -> cvProgrammingLanguage.setCandidate(candidate));
//		cvProgrammingLanguageService.addAll(cvDto.getCvProgrammingLanguage());
//		
//		cvDto.getCvSchool().forEach(cvSchool -> cvSchool.setCandidate(candidate));
//		cvSchoolService.addAll(cvDto.getCvSchool());
//		
//		cvDto.getCvLink().forEach(cvLink -> cvLink.setCandidate(candidate));
//		cvLinkService.addAll(cvDto.getCvLink());
//		

		return new SuccessResult();
	}

//	@Override
//	public Result add(Cv cv) {
//
//		return new SuccessDataResult<Cv>(this.cvDao.save(cv));
//	}

	@Override
	public DataResult<Cv> getById(int id) {
		Cv cv = cvDao.findById(id);
		return new SuccessDataResult<Cv>(cv);
	}

//	@Override
//	public Result update(CvUpdateDto cvUpdateDto) {
//
//		Cv cvUpdate = new Cv();
//
//		if (getById(cvUpdateDto.getCvId()).isSuccess()) {
//
//			Cv cvUpdate = cvDao.getOne(cvUpdateDto.getCvId());
//
//			
//		
//			cvUpdate.setCvDetails(cvDetailsService.getById(cvUpdateDto.getCvDetailsId()).getData());
//			cvUpdate.setCvExperience(cvExperienceService.getById(cvUpdateDto.getCvExperienceId()).getData());
//			cvUpdate.setCvLanguage(cvLanguageService.getById(cvUpdateDto.getCvLanguageId()).getData());
//			cvUpdate.setCvLink(cvLinkService.getById(cvUpdateDto.getCvLinkId()).getData());
//			cvUpdate.setCvPhoto(cvPhotoService.getById(cvUpdateDto.getCvPhotoId()).getData());
//			cvUpdate.setCvProgrammingLanguage(cvProgrammingLanguageService.getById(cvUpdateDto.getCvProgrammingLanguageId()).getData());
//			cvUpdate.setCvSchool(cvSchoolService.getById(cvUpdateDto.getCvSchoolId()).getData());
//			cvUpdate.setCvId(cvUpdateDto.getCvId());
//
//			cvDao.save(cvUpdate);
//
//			return new SuccessResult();
//		}
//		return new ErrorResult();
//	}

	@Override
	public DataResult<List<Cv>> getAllBycvId(int id) {
		List<Cv> cv = cvDao.getAllBycvId(id);
		return new SuccessDataResult<List<Cv>>(cv);
	}
	
	

//	@Override
//	public Result cvDetailsAdd(CvUpdateDto cvUpdateDto, CvDetailsDto cvDetailsDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Result cvDetailsAdd(CvDetailsDto cvDetailsDto) {
		
		
//		CvDetails cvDetailsAdd = new CvDetails();
//		
//		cvDetailsAdd.setCvDetailsField(cvDetailsDto.getCvDetailsField());
//		cvDetailsAdd.setCvDetailsId(cvDetailsDto.getCvDetailsId());
//		cvDetailsService.add(cvDetailsDto);
//		
//		
//		Cv cvUpdate = cvDao.getOne(cvDetailsDto.getCvId());
//		
//		cvUpdate.setCvDetails(cvDetailsService.getById(cvDetailsDto.getCvDetailsId()).getData());
//		cvUpdate.setCvExperience(cvExperienceService.getById(cvUpdateDto.getCvExperienceId()).getData());
//		cvUpdate.setCvLanguage(cvLanguageService.getById(cvUpdateDto.getCvLanguageId()).getData());
//		cvUpdate.setCvLink(cvLinkService.getById(cvUpdateDto.getCvLinkId()).getData());
//		cvUpdate.setCvPhoto(cvPhotoService.getById(cvUpdateDto.getCvPhotoId()).getData());
//		cvUpdate.setCvProgrammingLanguage(cvProgrammingLanguageService.getById(cvUpdateDto.getCvProgrammingLanguageId()).getData());
//		cvUpdate.setCvSchool(cvSchoolService.getById(cvUpdateDto.getCvSchoolId()).getData());
//		cvUpdate.setCvId(cvUpdateDto.getCvId());
//		
//
//		
//		cvDao.save(cvUpdate);

		return new SuccessResult();
	}

	@Override
	public DataResult<List<Cv>> getAllByCandidateId(int id) {
		List<Cv> cv = cvDao.getAllByCandidateId(id);
		return new SuccessDataResult<List<Cv>>(cv);
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult();
	}

	

	
		
		
	
	
	

}

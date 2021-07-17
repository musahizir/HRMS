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
import kodlama.io.hrms.entities.concretes.dto.CvAddDto;
import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;
import kodlama.io.hrms.entities.concretes.dto.CvDto;


@Service
public class CvManager implements CvService {



	
	private CvDao cvDao;
	private CandidateService candidateService;
	
	@Autowired
	public CvManager(CvDao cvDao, CandidateService candidateService) {
		super();
		this.cvDao = cvDao;
		this.candidateService = candidateService;
	}

	

	@Override
	public Result add(CvDto cvDto, int candidateId) {


		return new SuccessResult();
	}



	@Override
	public DataResult<Cv> getById(int id) {
		Cv cv = cvDao.findById(id);
		return new SuccessDataResult<Cv>(cv);
	}



	@Override
	public DataResult<List<Cv>> getAllBycvId(int id) {
		List<Cv> cv = cvDao.getAllBycvId(id);
		return new SuccessDataResult<List<Cv>>(cv);
	}
	
	 



	@Override
	public Result cvDetailsAdd(CvDetailsDto cvDetailsDto) {
		
		


		return new SuccessResult();
	}

	@Override
	public DataResult<List<Cv>> getAllByCandidateId(int id) {
		List<Cv> cv = cvDao.getAllByCandidateId(id);
		return new SuccessDataResult<List<Cv>>(cv);
	}

	@Override
	public Result addx(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult();
	}

	@Override
	public Result add(CvAddDto cvAddDto) {
		Cv cvAdd = new Cv();
		cvAdd.setCvName(cvAddDto.getCvName());
		cvAdd.setCandidate(candidateService.getById(cvAddDto.getId()).getData());
		
		cvDao.save(cvAdd);
		return new SuccessResult();
	}

	

	
		
		
	
	
	

}

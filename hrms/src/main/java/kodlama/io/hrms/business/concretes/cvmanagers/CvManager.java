package kodlama.io.hrms.business.concretes.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.dto.CvAddDto;

@Service
public class CvManager implements CvService {

	private final CvDao cvDao;
	private final CandidateService candidateService;

	@Autowired
	public CvManager(CvDao cvDao, CandidateService candidateService) {
		super();
		this.cvDao = cvDao;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<Cv> getById(int id) {
		Cv cv = cvDao.findByCvId(id);
		return new SuccessDataResult<>(cv);
	}

	@Override
	public DataResult<List<Cv>> getAllByCandidateId(int id) {
		List<Cv> cv = cvDao.getAllByCandidateId(id);
		return new SuccessDataResult<>(cv);
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

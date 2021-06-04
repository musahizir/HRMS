package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlama.io.hrms.entities.concretes.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public Result add(CvExperience cvExperience) {

		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}

	@Override
	public Result update(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("İş tecrübesi güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("İş tecrübesi silindi");
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByCvExperienceLeaveDateDesc(int candidateId) {

		return new SuccessDataResult<List<CvExperience>>(
				this.cvExperienceDao.getAllByCandidateIdOrderByCvExperienceLeaveDateDesc(candidateId), "");
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateId(int candidateId) {

		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidateId(candidateId), "");
	}

	@Override
	public Result addAll(List<CvExperience> cvExperience) {
		this.cvExperienceDao.saveAll(cvExperience);
		return new SuccessResult();
	}

}

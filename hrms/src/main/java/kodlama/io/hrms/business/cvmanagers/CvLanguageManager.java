package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlama.io.hrms.entities.concretes.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;

	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Dil eklendi");
	}

	@Override
	public Result update(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Dil güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvLanguageDao.deleteById(id);
		return new SuccessResult("Dil silindi");
	}

	@Override
	public DataResult<List<CvLanguage>> getAllByCandidateId(int candidateId) {

		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCandidateId(candidateId), "");
	}

	@Override
	public Result addAll(List<CvLanguage> cvLanguage) {

		this.cvLanguageDao.saveAll(cvLanguage);

		return new SuccessResult();

	}

}

package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvProgrammingLanguageDao;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;

@Service
public class CvProgrammingLanguageManager implements CvProgrammingLanguageService{

	private CvProgrammingLanguageDao cvProgrammingLanguageDao;
	
	
	@Autowired
	public CvProgrammingLanguageManager(CvProgrammingLanguageDao cvProgrammingLanguageDao) {
		super();
		this.cvProgrammingLanguageDao = cvProgrammingLanguageDao;
	}

	@Override
	public Result add(CvProgrammingLanguage cvProgrammingLanguage) {
		this.cvProgrammingLanguageDao.save(cvProgrammingLanguage);
		return new SuccessResult("Programlama dilleri eklendi");
	}

	@Override
	public Result update(CvProgrammingLanguage cvProgrammingLanguage) {
		this.cvProgrammingLanguageDao.save(cvProgrammingLanguage);
		return new SuccessResult("Programlama dilleri güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvProgrammingLanguageDao.deleteById(id);
		return new SuccessResult("Programlama dilleri silindi");
	}

	@Override
	public DataResult<List<CvProgrammingLanguage>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvProgrammingLanguage>>(this.cvProgrammingLanguageDao.getAllByCandidateId(candidateId), "");
	}

	@Override
	public Result addAll(List<CvProgrammingLanguage> cvProgrammingLanguage) {
		this.cvProgrammingLanguageDao.saveAll(cvProgrammingLanguage);
		return new SuccessResult();
	}
	


}

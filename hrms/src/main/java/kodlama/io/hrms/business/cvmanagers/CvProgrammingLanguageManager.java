package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvProgrammingLanguageService;
import kodlama.io.hrms.business.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvProgrammingLanguageDao;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;
import kodlama.io.hrms.entities.concretes.dto.CvProgrammingLanguageDto;

@Service
public class CvProgrammingLanguageManager implements CvProgrammingLanguageService {

	private CvProgrammingLanguageDao cvProgrammingLanguageDao;
	private CvService cvService;

	@Autowired
	public CvProgrammingLanguageManager(CvProgrammingLanguageDao cvProgrammingLanguageDao, CvService cvService) {
		super();
		this.cvProgrammingLanguageDao = cvProgrammingLanguageDao;
		this.cvService = cvService;
	}

	@Override
	public Result add(CvProgrammingLanguageDto cvProgrammingLanguageDto) {

		CvProgrammingLanguage cvProgrammingLanguageAdd = new CvProgrammingLanguage();

		cvProgrammingLanguageAdd.setCvProgrammingLanguageName(cvProgrammingLanguageDto.getCvProgrammingLanguageName());
		cvProgrammingLanguageAdd
				.setCvProgrammingLanguageLevel(cvProgrammingLanguageDto.getCvProgrammingLanguageLevel());
		cvProgrammingLanguageAdd.setCv(cvService.getById(cvProgrammingLanguageDto.getCvId()).getData());

		cvProgrammingLanguageDao.save(cvProgrammingLanguageAdd);

		return new SuccessResult("Programlama dilleri eklendi");
	}

	@Override
	public Result update(CvProgrammingLanguageDto cvProgrammingLanguageDto, int id) {
		CvProgrammingLanguage cvProgrammingLanguageUpdate = cvProgrammingLanguageDao.getOne(id);
		cvProgrammingLanguageUpdate
				.setCvProgrammingLanguageLevel(cvProgrammingLanguageDto.getCvProgrammingLanguageLevel());
		cvProgrammingLanguageUpdate
				.setCvProgrammingLanguageName(cvProgrammingLanguageDto.getCvProgrammingLanguageName());

		cvProgrammingLanguageDao.save(cvProgrammingLanguageUpdate);
		return new SuccessResult("Programlama dilleri güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvProgrammingLanguageDao.deleteById(id);
		return new SuccessResult("Programlama dilleri silindi");
	}

	@Override
	public DataResult<List<CvProgrammingLanguage>> getAllByCv_CvId(int cvId) {

		return new SuccessDataResult<List<CvProgrammingLanguage>>(this.cvProgrammingLanguageDao.getAllByCv_CvId(cvId),
				"");

	}

	@Override
	public Result addAll(List<CvProgrammingLanguage> cvProgrammingLanguage) {
		this.cvProgrammingLanguageDao.saveAll(cvProgrammingLanguage);
		return new SuccessResult();
	}

	@Override
	public DataResult<CvProgrammingLanguage> getById(int id) {
		CvProgrammingLanguage cvProgrammingLanguage = cvProgrammingLanguageDao.findById(id);
		return new SuccessDataResult<CvProgrammingLanguage>(cvProgrammingLanguage);
	}

}

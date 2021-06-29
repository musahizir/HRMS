package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvLanguageService;
import kodlama.io.hrms.business.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlama.io.hrms.entities.concretes.CvLanguage;
import kodlama.io.hrms.entities.concretes.dto.CvLanguageDto;

@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;
	private CvService cvService;



	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao, CvService cvService) {
		super();
		this.cvLanguageDao = cvLanguageDao;
		this.cvService = cvService;
	}

	@Override
	public Result add(CvLanguageDto cvLanguageDto) {
		
		CvLanguage cvLanguageAdd = new CvLanguage();
		
		cvLanguageAdd.setCvLanguageLevel(cvLanguageDto.getCvLanguageLevel());
		cvLanguageAdd.setCvLanguageName(cvLanguageDto.getCvLanguageName());
		cvLanguageAdd.setCv(cvService.getById(cvLanguageDto.getCvId()).getData());
		
		cvLanguageDao.save(cvLanguageAdd);
		
		
		return new SuccessResult("Dil eklendi");
	}

	@Override
	public Result update(CvLanguageDto cvLanguageDto, int id) {
		
		CvLanguage cvLanguageUpdate = cvLanguageDao.getOne(id);
		
		cvLanguageUpdate.setCvLanguageLevel(cvLanguageDto.getCvLanguageLevel());
		cvLanguageUpdate.setCvLanguageName(cvLanguageDto.getCvLanguageName());
		
		cvLanguageDao.save(cvLanguageUpdate);
		return new SuccessResult("Dil güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvLanguageDao.deleteById(id);
		return new SuccessResult("Dil silindi");
	}

	@Override
	public DataResult<List<CvLanguage>> getAllByCv_CvId(int cvId) {

		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCv_CvId(cvId), "");
		
	}

	@Override
	public Result addAll(List<CvLanguage> cvLanguage) {

		this.cvLanguageDao.saveAll(cvLanguage);

		return new SuccessResult();

	}

	@Override
	public DataResult<CvLanguage> getById(int id) {
		CvLanguage cvLanguage =cvLanguageDao.findById(id);
		return new SuccessDataResult<CvLanguage>(cvLanguage);
	}

}

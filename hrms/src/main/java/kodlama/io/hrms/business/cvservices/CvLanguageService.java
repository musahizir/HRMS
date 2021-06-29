package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLanguage;
import kodlama.io.hrms.entities.concretes.dto.CvLanguageDto;

public interface CvLanguageService {
	
	Result add(CvLanguageDto cvLanguageDto);

	Result update(CvLanguageDto cvLanguageDto, int id);
	
	Result remove(int id);
	
	DataResult<List<CvLanguage>> getAllByCv_CvId(int cvId);
	
	Result addAll(List<CvLanguage> cvLanguage);

	DataResult <CvLanguage> getById(int id);

}

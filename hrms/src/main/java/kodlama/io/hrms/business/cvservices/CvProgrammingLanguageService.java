package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;
import kodlama.io.hrms.entities.concretes.dto.CvProgrammingLanguageDto;

public interface CvProgrammingLanguageService {

	Result add(CvProgrammingLanguageDto cvProgrammingLanguageDto);

	Result update(CvProgrammingLanguageDto cvProgrammingLanguageDto, int id);

	Result remove(int id);

	DataResult<List<CvProgrammingLanguage>> getAllByCv_CvId(int cvId);

	Result addAll(List<CvProgrammingLanguage> cvProgrammingLanguage);

	DataResult<CvProgrammingLanguage> getById(int id);

}

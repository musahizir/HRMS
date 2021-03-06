package kodlama.io.hrms.business.abstracts.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvExperience;
import kodlama.io.hrms.entities.concretes.dto.CvExperienceDto;

public interface CvExperienceService {

	Result add(CvExperienceDto cvExperienceDto);

	Result update(CvExperienceDto cvExperienceDto, int id);

	Result remove(int id);

	DataResult<List<CvExperience>> getAllByCv_CvIdOrderByCvExperienceLeaveDateDesc(int cvId);

	DataResult<List<CvExperience>> getAllByCvId(int cvId);

	DataResult<CvExperience> getById(int id);
}

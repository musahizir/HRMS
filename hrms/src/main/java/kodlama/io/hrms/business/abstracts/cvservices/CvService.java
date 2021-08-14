package kodlama.io.hrms.business.abstracts.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.dto.CvAddDto;


public interface CvService {


	DataResult<Cv> getById(int id);

	Result add(CvAddDto cvAddDto);

	DataResult<List<Cv>> getAllByCandidateId(int id);

}

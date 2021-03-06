package kodlama.io.hrms.business.abstracts.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvDetails;
import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;

public interface CvDetailsService {

	Result add(CvDetailsDto cvDetailsDto);

	Result update(CvDetailsDto cvDetailsDto, int id);

	Result remove(int id);

	DataResult<List<CvDetails>> getAllByCvId(int cvId);

	DataResult<CvDetails> getById(int id);

}

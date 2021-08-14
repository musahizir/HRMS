package kodlama.io.hrms.business.abstracts.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLink;
import kodlama.io.hrms.entities.concretes.dto.CvLinkDto;

public interface CvLinkService {

	Result add(CvLinkDto cvLinkDto);

	Result update(CvLinkDto cvLinkDto, int id);

	Result remove(int id);

	DataResult<List<CvLink>> getAllByCvId(int cvId);

	DataResult<CvLink> getById(int id);

}

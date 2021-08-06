package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.business.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDetailsDao;
import kodlama.io.hrms.entities.concretes.CvDetails;
import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;

@Service
public class CvDetailsManager implements CvDetailsService {

	private CvDetailsDao cvDetailsDao;
	private CvService cvService;

	@Autowired
	public CvDetailsManager(CvDetailsDao cvDetailsDao, CvService cvService) {
		super();
		this.cvDetailsDao = cvDetailsDao;
		this.cvService = cvService;
	}

	@Override
	public Result add(CvDetailsDto cvDetailsDto) {

		CvDetails cvDetailsAdd = new CvDetails();

		cvDetailsAdd.setCvDetailsField(cvDetailsDto.getCvDetailsField());
		cvDetailsAdd.setCv(cvService.getById(cvDetailsDto.getCvId()).getData());

		cvDetailsDao.save(cvDetailsAdd);

		return new SuccessResult("Cv detayları eklendi");
	}

	@Override
	public Result update(CvDetailsDto cvDetailsDto, int id) {

		CvDetails cvDetailsUpdate = cvDetailsDao.getOne(id);

		cvDetailsUpdate.setCvDetailsField(cvDetailsDto.getCvDetailsField());
		cvDetailsDao.save(cvDetailsUpdate);

		return new SuccessResult("Cv detayları güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvDetailsDao.deleteById(id);
		return new SuccessResult("Cv detayları silindi");
	}

	@Override
	public DataResult<List<CvDetails>> getAllByCv_CvId(int cvId) {

		return new SuccessDataResult<List<CvDetails>>(this.cvDetailsDao.getAllByCv_CvId(cvId), "");

	}

	@Override
	public Result addAll(List<CvDetails> cvDetails) {
		cvDetailsDao.saveAll(cvDetails);
		return new SuccessResult();
	}

	@Override
	public DataResult<CvDetails> getById(int id) {
		CvDetails cvDetails = cvDetailsDao.findById(id);
		return new SuccessDataResult<CvDetails>(cvDetails);
	}

}

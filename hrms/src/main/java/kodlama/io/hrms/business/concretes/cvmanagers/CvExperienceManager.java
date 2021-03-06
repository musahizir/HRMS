package kodlama.io.hrms.business.concretes.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.cvservices.CvExperienceService;
import kodlama.io.hrms.business.abstracts.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlama.io.hrms.entities.concretes.CvExperience;
import kodlama.io.hrms.entities.concretes.dto.CvExperienceDto;

@Service
public class CvExperienceManager implements CvExperienceService {

	private final CvExperienceDao cvExperienceDao;
	private final CvService cvService;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao, CvService cvService) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		this.cvService = cvService;
	}

	@Override
	public Result add(CvExperienceDto cvExperienceDto) {

		CvExperience cvExperienceAdd = new CvExperience();

		cvExperienceAdd.setCvExperienceCompanyName(cvExperienceDto.getCvExperienceCompanyName());
		cvExperienceAdd.setCvExperienceLeaveDate(cvExperienceDto.getCvExperienceLeaveDate());
		cvExperienceAdd.setCvExperiencePosition(cvExperienceDto.getCvExperiencePosition());
		cvExperienceAdd.setCvExperienceStartDate(cvExperienceDto.getCvExperienceStartDate());
		cvExperienceAdd.setCv(cvService.getById(cvExperienceDto.getCvId()).getData());

		cvExperienceDao.save(cvExperienceAdd);

		return new SuccessResult("İş tecrübesi eklendi");
	}

	@Override
	public Result update(CvExperienceDto cvExperienceDto, int id) {

		CvExperience cvExperienceUpdate = cvExperienceDao.getOne(id);
		cvExperienceUpdate.setCvExperienceCompanyName(cvExperienceDto.getCvExperienceCompanyName());
		cvExperienceUpdate.setCvExperienceLeaveDate(cvExperienceDto.getCvExperienceLeaveDate());
		cvExperienceUpdate.setCvExperiencePosition(cvExperienceDto.getCvExperiencePosition());
		cvExperienceUpdate.setCvExperienceStartDate(cvExperienceDto.getCvExperienceStartDate());

		cvExperienceDao.save(cvExperienceUpdate);
		return new SuccessResult("İş tecrübesi güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("İş tecrübesi silindi");
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCv_CvIdOrderByCvExperienceLeaveDateDesc(int cvId) {

		return new SuccessDataResult<>(
				this.cvExperienceDao.getAllByCv_CvIdOrderByCvExperienceLeaveDateDesc(cvId), "");

	}

	@Override
	public DataResult<List<CvExperience>> getAllByCvId(int cvId) {

		return new SuccessDataResult<>(this.cvExperienceDao.getAllByCv_CvId(cvId), "");

	}

	@Override
	public DataResult<CvExperience> getById(int id) {
		CvExperience cvExperience = cvExperienceDao.findByCvExperienceId(id);
		return new SuccessDataResult<>(cvExperience);
	}

}

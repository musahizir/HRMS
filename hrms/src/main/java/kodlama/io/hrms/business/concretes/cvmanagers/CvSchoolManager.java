package kodlama.io.hrms.business.concretes.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.cvservices.CvSchoolService;
import kodlama.io.hrms.business.abstracts.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvSchoolDao;
import kodlama.io.hrms.entities.concretes.CvSchool;
import kodlama.io.hrms.entities.concretes.dto.CvSchoolDto;

@Service
public class CvSchoolManager implements CvSchoolService {

	private final CvSchoolDao cvSchoolDao;
	private final CvService cvService;

	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao, CvService cvService) {
		super();
		this.cvSchoolDao = cvSchoolDao;
		this.cvService = cvService;
	}

	@Override
	public Result add(CvSchoolDto cvSchoolDto) {

		CvSchool cvSchoolAdd = new CvSchool();

		cvSchoolAdd.setCvSchoolBranch(cvSchoolDto.getCvSchoolBranch());
		cvSchoolAdd.setCvSchoolGraduateDate(cvSchoolDto.getCvSchoolGraduateDate());
		cvSchoolAdd.setCvSchoolName(cvSchoolDto.getCvSchoolName());
		cvSchoolAdd.setCvSchoolStartDate(cvSchoolDto.getCvSchoolStartDate());
		cvSchoolAdd.setCv(cvService.getById(cvSchoolDto.getCvId()).getData());

		cvSchoolDao.save(cvSchoolAdd);

		return new SuccessResult("Okul bilgileri eklendi");
	}

	@Override
	public Result update(CvSchoolDto cvSchoolDto, int id) {
		CvSchool cvSchoolUpdate = cvSchoolDao.getOne(id);
		cvSchoolUpdate.setCvSchoolBranch(cvSchoolDto.getCvSchoolBranch());
		cvSchoolUpdate.setCvSchoolGraduateDate(cvSchoolDto.getCvSchoolGraduateDate());
		cvSchoolUpdate.setCvSchoolName(cvSchoolDto.getCvSchoolName());
		cvSchoolUpdate.setCvSchoolStartDate(cvSchoolDto.getCvSchoolStartDate());

		cvSchoolDao.save(cvSchoolUpdate);
		return new SuccessResult("Okul bilgileri g??ncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvSchoolDao.deleteById(id);
		return new SuccessResult("Okul bilgileri silindi");
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCvIdOrderByCvSchoolGraduateDate(int cvId) {

		return new SuccessDataResult<>(this.cvSchoolDao.getAllByCv_CvIdOrderByCvSchoolGraduateDate(cvId),
				"");

	}

	@Override
	public DataResult<List<CvSchool>> getAllByCvId(int cvId) {

		return new SuccessDataResult<>(this.cvSchoolDao.getAllByCv_CvId(cvId), "");

	}

	@Override
	public DataResult<CvSchool> getById(int id) {
		CvSchool cvSchool = cvSchoolDao.findByCvSchoolId(id);
		return new SuccessDataResult<>(cvSchool);
	}

}

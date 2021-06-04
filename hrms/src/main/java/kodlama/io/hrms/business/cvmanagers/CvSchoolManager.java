package kodlama.io.hrms.business.cvmanagers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvSchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvSchoolDao;
import kodlama.io.hrms.entities.concretes.CvSchool;


@Service
public class CvSchoolManager implements CvSchoolService {
	
	
	CvSchoolDao cvSchoolDao;

	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		super();
		this.cvSchoolDao = cvSchoolDao;
	}

	@Override
	public Result add(CvSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Okul bilgileri eklendi");
	}

	@Override
	public Result update(CvSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Okul bilgileri güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvSchoolDao.deleteById(id);
		return new SuccessResult("Okul bilgileri silindi");
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCandidateIdOrderByCvSchoolGraduateDate(int candidateId) {
		
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByCandidateIdOrderByCvSchoolGraduateDate(candidateId), "");
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getAllByCandidateId(candidateId), "");
	}

	@Override
	public Result addAll(List<CvSchool> cvSchool) {
		this.cvSchoolDao.saveAll(cvSchool);
		return new SuccessResult();
	}



	

	

	
	
	

	
	
	
	

}

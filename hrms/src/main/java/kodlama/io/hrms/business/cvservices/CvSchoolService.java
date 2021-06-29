package kodlama.io.hrms.business.cvservices;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSchool;
import kodlama.io.hrms.entities.concretes.dto.CvSchoolDto;

public interface CvSchoolService {
	

	Result add(CvSchoolDto cvSchoolDto);
		
	Result update(CvSchoolDto cvSchoolDto, int id);
	
	Result remove(int id);
	
	DataResult<List<CvSchool>> getAllByCv_CvIdOrderByCvSchoolGraduateDate(int cvId);
	
	DataResult<List<CvSchool>> getAllByCv_CvId(int cvId);
	
	Result addAll(List<CvSchool> cvSchool);
	
	DataResult <CvSchool> getById(int id);
	
}

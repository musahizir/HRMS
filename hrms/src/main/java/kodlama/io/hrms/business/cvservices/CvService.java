package kodlama.io.hrms.business.cvservices;


import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.dto.CvDetailsDto;
import kodlama.io.hrms.entities.concretes.dto.CvDto;


public interface CvService {

	 Result add(CvDto cvDto,int candidateId);
	 
	 Result add(Cv cv);
	 
	 DataResult<Cv> getById(int id);
	 
	
	 
	

	DataResult <List<Cv>>getAllBycvId(int id);

	DataResult<List<Cv>>getAllByCandidateId(int id);

	
	
	Result cvDetailsAdd( CvDetailsDto cvDetailsDto);
	
}

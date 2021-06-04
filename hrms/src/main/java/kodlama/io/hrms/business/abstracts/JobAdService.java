package kodlama.io.hrms.business.abstracts;



import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto;


public interface JobAdService {
	
	Result add(JobAd jobAd);
	
	Result update(JobAd jobAd);
	
	Result remove(int id);
	
	Result changeActiveToPassive(int id);
	
	DataResult <JobAd> getById(int id);
	
	DataResult<List<JobAd>> findByjobAdIsActiveTrue();
	
	DataResult<List<JobAd>> findByOrderByJobAdPostedDate();
	
	DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id);

}

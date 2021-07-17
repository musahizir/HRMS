package kodlama.io.hrms.business.abstracts;



import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdFilterDto;
import kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto;


public interface JobAdService {
	
	Result add(JobAdRegisterDto jobAd);
	
	Result update(JobAd jobAd);
	
	Result remove(int id);
	
	Result changeActiveToPassive(int id);
	
	Result changePassiveToActive(int id);
	
	Result changeConfirmRequestTrueToFalse(int id);
	
	Result changeConfirmedFalseToTrue(int id);
	
	DataResult <JobAd> getById(int id);
	
	DataResult<List<JobAd>> findByjobAdIsActiveTrue();
	
	DataResult<List<JobAd>> findByOrderByJobAdPostedDate();
	
	DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id);
	
	DataResult <List<JobAd>> getAllByJobAdIsConfirmedFalse();
	
	DataResult <List<JobAd>> getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue();
	
	DataResult <List<JobAd>> getAllPageNumberAndPageSizeAndFilter(int pageNo, int pageSize, JobAdFilterDto jobAdFilterDto);
	
	

}

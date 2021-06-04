package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdDao;
import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto;

@Service
public class JobAdManager implements JobAdService {

	
	private JobAdDao jobAdDao;
	
	@Autowired
	public JobAdManager(JobAdDao jobAdDao) {
		super();
		this.jobAdDao = jobAdDao;
	}

	@Override
	public Result add(JobAd jobAd) {
		
		if(checkAllColumnsFilled(jobAd).isSuccess()) {
			
			this.jobAdDao.save(jobAd);
			return new SuccessResult("İş ilanı başarıyla eklendi");
		}
		
		return new ErrorResult("İş ilanı eklenemedi");
	}

	@Override
	public Result update(JobAd jobAd) {
		
		this.jobAdDao.save(jobAd);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public Result remove(int id) {
		
		this.jobAdDao.deleteById(id);
		return new SuccessResult("İlan güncellendi");
	}

	@Override
	public Result changeActiveToPassive(int id) {
		
		if(getById(id) == null) {
			
			return new ErrorResult("İlan bulunamadı");
		}
		
		if(getById(id).getData().isJobAdIsActive() == false) {
		
		return new ErrorResult("Bu ilan zaten kapalı");
		}
		
		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdIsActive(false);
		update(jobAd);
		
		return new SuccessResult("İlan pasif hale getirildi");

	}

	@Override
	public DataResult<JobAd> getById(int id) {
		
		return new SuccessDataResult<JobAd>(this.jobAdDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAd>> findByjobAdIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByjobAdIsActiveTrue(), "Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAd>> findByOrderByJobAdPostedDate() {
		
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByOrderByJobAdPostedDate(), "İş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id) {
		
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllActiveJobAdByEmployer(id), "İş verene ait tüm ilanlar listelendi");
	}
	
	private Result checkAllColumnsFilled(JobAd jobAd) {
		
		if((jobAd.getCity() == null )||( jobAd.getJobAdDescription() == null || jobAd.getJobAdDescription().isBlank()) || jobAd.getJobPosition() == null) {
		
		return new ErrorResult("");
	}

		return new SuccessResult();
	}

}

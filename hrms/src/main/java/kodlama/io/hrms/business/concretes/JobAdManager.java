package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.business.abstracts.JobAdShiftService;
import kodlama.io.hrms.business.abstracts.JobAdWorkingStyleService;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdDao;
import kodlama.io.hrms.entities.concretes.JobAd;
import kodlama.io.hrms.entities.concretes.dto.JobAdFilterDto;
import kodlama.io.hrms.entities.concretes.dto.JobAdRegisterDto;

@Service
public class JobAdManager implements JobAdService {

	private JobAdDao jobAdDao;
	private CityService cityService;
	private JobPositionService jobPositionService;
	private EmployerService employerService;
	private JobAdShiftService jobAdShiftService;
	private JobAdWorkingStyleService jobAdWorkingStyleService;

	@Autowired
	public JobAdManager(JobAdDao jobAdDao, CityService cityService, JobPositionService jobPositionService,
			EmployerService employerService, JobAdShiftService jobAdShiftService,
			JobAdWorkingStyleService jobAdWorkingStyleService) {
		super();
		this.jobAdDao = jobAdDao;
		this.cityService = cityService;
		this.jobPositionService = jobPositionService;
		this.employerService = employerService;
		this.jobAdShiftService = jobAdShiftService;
		this.jobAdWorkingStyleService = jobAdWorkingStyleService;
	}

	@Override
	public Result add(JobAdRegisterDto jobAdRegisterDto) {

		Result result = BusinessRules.Run(isJobPositionValid(jobAdRegisterDto.getJobId()),
				isCityValid(jobAdRegisterDto.getCityId()),
				isJobAdWorkingStyleValid(jobAdRegisterDto.getJobAdWorkingStyleId()),
				isJobAdShiftValid(jobAdRegisterDto.getJobAdShiftId()),
				isjobAdMaxOpenPositionValid(jobAdRegisterDto.getJobAdMaxOpenPosition()));

		if (!result.isSuccess()) {

			return result;
		}

		JobAd jobAdAdd = new JobAd();

		jobAdAdd.setJobAdDescription(jobAdRegisterDto.getJobAdDescription());
		jobAdAdd.setJobAdApplicationEnd(jobAdRegisterDto.getJobAdApplicationEnd());
		jobAdAdd.setJobAdIsActive(jobAdRegisterDto.isJobAdIsActive());
		jobAdAdd.setJobAdMaxOpenPosition(jobAdRegisterDto.getJobAdMaxOpenPosition());
		jobAdAdd.setJobAdMaxWage(jobAdRegisterDto.getJobAdMaxWage());
		jobAdAdd.setJobAdMinWage(jobAdRegisterDto.getJobAdMinWage());
		jobAdAdd.setJobAdIsConfirmed(jobAdRegisterDto.isJobAdIsConfirmed());
		jobAdAdd.setJobAdConfirmRequest(jobAdRegisterDto.isJobAdConfirmRequest());

		jobAdAdd.setCity(cityService.getById(jobAdRegisterDto.getCityId()).getData());
		jobAdAdd.setJobPosition(jobPositionService.getById(jobAdRegisterDto.getJobId()).getData());
		jobAdAdd.setEmployer(employerService.getById(jobAdRegisterDto.getEmployerId()).getData());
		jobAdAdd.setJobAdShift(jobAdShiftService.getById(jobAdRegisterDto.getJobAdShiftId()).getData());
		jobAdAdd.setJobAdWorkingStyle(
				jobAdWorkingStyleService.getById(jobAdRegisterDto.getJobAdWorkingStyleId()).getData());
		jobAdDao.save(jobAdAdd);
		return new SuccessResult("İş ilanı eklendi");

	}

	@Override
	public Result update(JobAd jobAd) {

		this.jobAdDao.save(jobAd);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public Result remove(int id) {

		this.jobAdDao.deleteById(id);
		return new SuccessResult("İlan silindi");
	}

	@Override
	public Result changeActiveToPassive(int id) {

		if (getById(id) == null) {

			return new ErrorResult("İlan bulunamadı");
		}

		if (getById(id).getData().isJobAdIsActive() == false) {

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

		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByOrderByJobAdPostedDate(),
				"İş ilanları tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id) {

		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllActiveJobAdByEmployer(id),
				"İş verene ait tüm ilanlar listelendi");
	}

	private Result isJobPositionValid(int id) {
		if (jobPositionService.getById(id).getData() == null)
			return new ErrorResult("Böyle bir iş pozisyonu yok");

		return new SuccessResult();
	}

	private Result isCityValid(int id) {

		if (cityService.getById(id).getData() == null)
			return new ErrorResult("Böyle bir şehir yok");
		return new SuccessResult();

	}

	private Result isJobAdWorkingStyleValid(int id) {

		if (jobAdWorkingStyleService.getById(id).getData() == null)
			return new ErrorResult("Böyle bir çalışma türü yok");

		return new SuccessResult();
	}

	private Result isJobAdShiftValid(int id) {
		if (jobAdShiftService.getById(id).getData() == null)
			return new ErrorResult("Böyle bir vardiya türü yok");

		return new SuccessResult();

	}

	private Result isjobAdMaxOpenPositionValid(int jobAdMaxOpenPosition) {
		if (jobAdMaxOpenPosition <= 0)
			return new ErrorResult("Minimum iş pozisyonu 0 ve 0'dan küçük olamaz");
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAd>> getAllByJobAdIsConfirmedFalse() {

		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByJobAdIsConfirmedFalse());
	}

	@Override
	public Result changeConfirmedFalseToTrue(int id) {

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdIsConfirmed(true);
		update(jobAd);

		return new SuccessResult("İlan onaylandı");
	}

	@Override
	public Result changePassiveToActive(int id) {

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdIsActive(true);
		update(jobAd);

		return new SuccessResult("İlan Aktive edildi");
	}

	@Override
	public DataResult<List<JobAd>> getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue() {

		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue());
	}

	@Override
	public Result changeConfirmRequestTrueToFalse(int id) {

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdConfirmRequest(false);
		update(jobAd);

		return new SuccessResult("İlan Onay Sürecinden Kaldırıldı");
	}

	@Override
	public DataResult<List<JobAd>> getAllPageNumberAndPageSizeAndFilter(int pageNo, int pageSize,
			JobAdFilterDto jobAdFilterDto) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

//		var data = this.jobAdDao.getByFilter(jobAdFilterDto, pageable);

		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.getByFilter(jobAdFilterDto, pageable).getContent(),
				this.jobAdDao.getByFilter(jobAdFilterDto, pageable).getTotalElements() + "");
	}

//	data.getContent(), String.valueOf(data.getTotalPages())

}

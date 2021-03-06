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

	private final JobAdDao jobAdDao;
	private final CityService cityService;
	private final JobPositionService jobPositionService;
	private final EmployerService employerService;
	private final JobAdShiftService jobAdShiftService;
	private final JobAdWorkingStyleService jobAdWorkingStyleService;

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
		return new SuccessResult("???? ilan?? eklendi");

	}

	@Override
	public Result update(JobAd jobAd) {

		this.jobAdDao.save(jobAd);
		return new SuccessResult("???? ilan?? g??ncellendi");
	}

	@Override
	public Result remove(int id) {

		this.jobAdDao.deleteById(id);
		return new SuccessResult("??lan silindi");
	}

	@Override
	public Result changeActiveToPassive(int id) {

		if (getById(id) == null) {

			return new ErrorResult("??lan bulunamad??");
		}

		if (!getById(id).getData().isJobAdIsActive()) {

			return new ErrorResult("Bu ilan zaten kapal??");
		}

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdIsActive(false);
		update(jobAd);

		return new SuccessResult("??lan pasif hale getirildi");

	}

	@Override
	public DataResult<JobAd> getById(int id) {

		return new SuccessDataResult<>(this.jobAdDao.findByJobAdId(id));
	}

	@Override
	public DataResult<List<JobAd>> findByjobAdIsActiveTrue() {

		return new SuccessDataResult<>(this.jobAdDao.findByjobAdIsActiveTrue(), "Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAd>> findByOrderByJobAdPostedDate() {

		return new SuccessDataResult<>(this.jobAdDao.findByOrderByJobAdPostedDate(),
				"???? ilanlar?? tarihe g??re listelendi");
	}

	@Override
	public DataResult<List<JobAd>> getAllActiveJobAdByEmployer(int id) {

		return new SuccessDataResult<>(this.jobAdDao.getAllActiveJobAdByEmployer(id),
				"???? verene ait t??m ilanlar listelendi");
	}

	private Result isJobPositionValid(int id) {
		if (jobPositionService.getById(id).getData() == null)
			return new ErrorResult("B??yle bir i?? pozisyonu yok");

		return new SuccessResult();
	}

	private Result isCityValid(int id) {

		if (cityService.getById(id).getData() == null)
			return new ErrorResult("B??yle bir ??ehir yok");
		return new SuccessResult();

	}

	private Result isJobAdWorkingStyleValid(int id) {

		if (jobAdWorkingStyleService.getById(id).getData() == null)
			return new ErrorResult("B??yle bir ??al????ma t??r?? yok");

		return new SuccessResult();
	}

	private Result isJobAdShiftValid(int id) {
		if (jobAdShiftService.getById(id).getData() == null)
			return new ErrorResult("B??yle bir vardiya t??r?? yok");

		return new SuccessResult();

	}

	private Result isjobAdMaxOpenPositionValid(int jobAdMaxOpenPosition) {
		if (jobAdMaxOpenPosition <= 0)
			return new ErrorResult("Minimum i?? pozisyonu 0 ve 0'dan k??????k olamaz");
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAd>> getAllByJobAdIsConfirmedFalse() {

		return new SuccessDataResult<>(this.jobAdDao.getAllByJobAdIsConfirmedFalse());
	}

	@Override
	public Result changeConfirmedFalseToTrue(int id) {

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdIsConfirmed(true);
		update(jobAd);

		return new SuccessResult("??lan onayland??");
	}

	@Override
	public Result changePassiveToActive(int id) {

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdIsActive(true);
		update(jobAd);

		return new SuccessResult("??lan Aktive edildi");
	}

	@Override
	public DataResult<List<JobAd>> getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue() {

		return new SuccessDataResult<>(this.jobAdDao.getAllByJobAdIsConfirmedFalseAndConfirmRequestTrue());
	}

	@Override
	public Result changeConfirmRequestTrueToFalse(int id) {

		JobAd jobAd = getById(id).getData();
		jobAd.setJobAdConfirmRequest(false);
		update(jobAd);

		return new SuccessResult("??lan Onay S??recinden Kald??r??ld??");
	}

	@Override
	public DataResult<List<JobAd>> getAllPageNumberAndPageSizeAndFilter(int pageNo, int pageSize,
			JobAdFilterDto jobAdFilterDto) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<>(this.jobAdDao.getByFilter(jobAdFilterDto, pageable).getContent(),
				this.jobAdDao.getByFilter(jobAdFilterDto, pageable).getTotalElements() + "");
	}



}

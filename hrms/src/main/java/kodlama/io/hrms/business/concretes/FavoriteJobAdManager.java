package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.FavoriteJobAdService;
import kodlama.io.hrms.business.abstracts.JobAdService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.FavoriteJobAdDao;
import kodlama.io.hrms.entities.concretes.FavoriteJobAd;
import kodlama.io.hrms.entities.concretes.dto.FavoriteJobAdDto;

@Service
public class FavoriteJobAdManager implements FavoriteJobAdService {

	private FavoriteJobAdDao favoriteJobAdDao;
	private CandidateService candidateService;
	private JobAdService jobAdService;

	@Autowired
	public FavoriteJobAdManager(FavoriteJobAdDao favoriteJobAdDao, CandidateService candidateService,
			JobAdService jobAdService) {
		super();
		this.favoriteJobAdDao = favoriteJobAdDao;
		this.candidateService = candidateService;
		this.jobAdService = jobAdService;
	}

	@Override
	public Result add(FavoriteJobAdDto favoriteJobAdDto) {

		FavoriteJobAd favAdd = new FavoriteJobAd();

		favAdd.setCandidate(candidateService.getById(favoriteJobAdDto.getId()).getData());
		favAdd.setJobAd(jobAdService.getById(favoriteJobAdDto.getJobAdId()).getData());

		this.favoriteJobAdDao.save(favAdd);

		return new SuccessResult();
	}

	@Override
	public DataResult<List<FavoriteJobAd>> getByCandidateId(int id) {

		return new SuccessDataResult<List<FavoriteJobAd>>(this.favoriteJobAdDao.getByCandidateId(id));
	}

	@Override
	public DataResult<List<FavoriteJobAd>> getAll() {

		return new SuccessDataResult<List<FavoriteJobAd>>(this.favoriteJobAdDao.findAll());
	}

}

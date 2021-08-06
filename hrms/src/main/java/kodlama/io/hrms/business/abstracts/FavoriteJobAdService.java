package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.FavoriteJobAd;
import kodlama.io.hrms.entities.concretes.dto.FavoriteJobAdDto;

public interface FavoriteJobAdService {

	Result add(FavoriteJobAdDto favoriteJobAdDto);

	DataResult<List<FavoriteJobAd>> getByCandidateId(int id);

	DataResult<List<FavoriteJobAd>> getAll();

}

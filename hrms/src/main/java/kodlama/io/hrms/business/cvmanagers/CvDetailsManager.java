package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvDetailsService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDetailsDao;
import kodlama.io.hrms.entities.concretes.CvDetails;


@Service
public class CvDetailsManager implements CvDetailsService {

	
	private CvDetailsDao cvDetailsDao;
	
	@Autowired
	public CvDetailsManager(CvDetailsDao cvDetailsDao) {
		super();
		this.cvDetailsDao = cvDetailsDao;
		
	}

	@Override
	public Result add(CvDetails cvDetails) {
		
		this.cvDetailsDao.save(cvDetails);
		return new SuccessResult("Cv detayları eklendi");
	}


	@Override
	public Result update(CvDetails cvDetails) {
		
		this.cvDetailsDao.save(cvDetails);
		return new SuccessResult("Cv detayları güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvDetailsDao.deleteById(id);
		return new SuccessResult("Cv detayları silindi");
	}

	@Override
	public DataResult<List<CvDetails>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvDetails>>(this.cvDetailsDao.getAllByCandidateId(candidateId), "");
	}

	@Override
	public Result addAll(List<CvDetails> cvDetails) {
		cvDetailsDao.saveAll(cvDetails);
		return new SuccessResult();
	}
	
	

}

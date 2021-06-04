package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvLinkDao;
import kodlama.io.hrms.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService{

	
	private CvLinkDao cvLinkDao;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link eklendi");
	}

	@Override
	public Result update(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("Link silindi");
	}

	@Override
	public DataResult<List<CvLink>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCandidateId(candidateId), "");
	}

	@Override
	public Result addAll(List<CvLink> cvLink) {

		this.cvLinkDao.saveAll(cvLink);

		
		return new SuccessResult();
	}

}

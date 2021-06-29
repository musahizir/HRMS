package kodlama.io.hrms.business.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.cvservices.CvLinkService;
import kodlama.io.hrms.business.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvLinkDao;
import kodlama.io.hrms.entities.concretes.CvLink;
import kodlama.io.hrms.entities.concretes.dto.CvLinkDto;

@Service
public class CvLinkManager implements CvLinkService{

	
	private CvLinkDao cvLinkDao;
	private CvService cvService;

	public CvLinkManager(CvLinkDao cvLinkDao, CvService cvService) {
		super();
		this.cvLinkDao = cvLinkDao;
		this.cvService = cvService;
	}

	@Override
	public Result add(CvLinkDto cvLinkDto) {
		
		CvLink cvLinkAdd = new CvLink();
		cvLinkAdd.setLinkName(cvLinkDto.getLinkName());
		cvLinkAdd.setCv(cvService.getById(cvLinkDto.getCvId()).getData());
		cvLinkDao.save(cvLinkAdd);
		
		return new SuccessResult("Link eklendi");
	}

	@Override
	public Result update(CvLinkDto cvLinkDto, int id) {
		CvLink cvLinkUpdate = cvLinkDao.getOne(id);
		cvLinkUpdate.setLinkName(cvLinkDto.getLinkName());
		
		cvLinkDao.save(cvLinkUpdate);
		return new SuccessResult("Link güncellendi");
	}

	@Override
	public Result remove(int id) {
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("Link silindi");
	}

	@Override
	public DataResult<List<CvLink>> getAllByCv_CvId(int cvId) {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCv_CvId(cvId), "");
		
	}

	@Override
	public Result addAll(List<CvLink> cvLink) {

		this.cvLinkDao.saveAll(cvLink);

		
		return new SuccessResult();
	}

	@Override
	public DataResult<CvLink> getById(int id) {
		CvLink cvLink = cvLinkDao.findById(id);
		return new SuccessDataResult<CvLink>(cvLink);
	}

}

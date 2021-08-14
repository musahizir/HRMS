package kodlama.io.hrms.business.concretes.cvmanagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.cvservices.CvLinkService;
import kodlama.io.hrms.business.abstracts.cvservices.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvLinkDao;
import kodlama.io.hrms.entities.concretes.CvLink;
import kodlama.io.hrms.entities.concretes.dto.CvLinkDto;

@Service
public class CvLinkManager implements CvLinkService {

	private final CvLinkDao cvLinkDao;
	private final CvService cvService;

	@Autowired
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
	public DataResult<List<CvLink>> getAllByCvId(int cvId) {

		return new SuccessDataResult<>(this.cvLinkDao.getAllByCv_CvId(cvId), "");

	}

	@Override
	public DataResult<CvLink> getById(int id) {
		CvLink cvLink = cvLinkDao.findByCvLinkId(id);
		return new SuccessDataResult<>(cvLink);
	}

}

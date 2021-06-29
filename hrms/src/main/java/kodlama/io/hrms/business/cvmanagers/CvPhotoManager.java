package kodlama.io.hrms.business.cvmanagers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.cvservices.CvPhotoService;
import kodlama.io.hrms.core.utilities.photo.PhotoService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvPhotoDao;
import kodlama.io.hrms.entities.concretes.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService {

//	private CvPhotoDao cvPhotoDao;
//	private PhotoService photoService;
//	
//	@Autowired
//	public CvPhotoManager(CvPhotoDao cvPhotoDao, PhotoService photoService) {
//		super();
//		this.cvPhotoDao = cvPhotoDao;
//		this.photoService = photoService;
//	}
//
//	@Override
//	public Result add(CvPhoto cvPhoto) {
//		
//		this.cvPhotoDao.save(cvPhoto);
//		return new SuccessResult();
//	}
//
//	@Override
//	public Result update(CvPhoto cvPhoto, MultipartFile file ) {
//		Map<String,String> uploadImage = this.photoService.uploadImageFile(file).getData();
//		this.cvPhotoDao.save(cvPhoto);
//		return new SuccessResult("Fotoğraf güncellendi");
//	}
//
//	@Override
//	public Result add(CvPhoto cvPhoto, MultipartFile file) {
//		Map<String,String> uploadImage = this.photoService.uploadImageFile(file).getData();
//		this.cvPhotoDao.save(cvPhoto);
//		return new SuccessResult("Fotoğraf eklendi");
//		
//	}
//	@Override
//	public Result remove(int id) {
//		this.cvPhotoDao.deleteById(id);
//		return new SuccessResult("Fotoğraf silindi");
//	}
//
//	@Override
//	public DataResult<List<CvPhoto>> getAllByCv_CvId(int cvId) {
//		
//		return new SuccessDataResult<List<CvPhoto>>(this.cvPhotoDao.getAllByCv_CvId(cvId), "Fotoğraflar getirildi");
//		
//	}
//
//	@Override
//	public Result addAll(List<CvPhoto> cvPhoto) {
//		cvPhotoDao.saveAll(cvPhoto);
//		return new SuccessResult();
//	}
//
//	@Override
//	public DataResult<CvPhoto> getById(int id) {
//		CvPhoto cvPhoto = cvPhotoDao.findById(id);
//		return new SuccessDataResult<CvPhoto>(cvPhoto);
//	}
//
//	

}

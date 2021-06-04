package kodlama.io.hrms.business.cvservices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvPhoto;


public interface CvPhotoService {


	Result add(CvPhoto cvPhoto);
	
	Result update(CvPhoto cvPhoto, MultipartFile file);
	
	Result remove(int id);
	
	Result add(CvPhoto cvPhoto, MultipartFile file);
	
	DataResult<List<CvPhoto>> getAllByCandidateId(int candidateId);
	
	Result addAll(List<CvPhoto> cvPhoto);
	
}

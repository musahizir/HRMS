package kodlama.io.hrms.core.utilities.photo;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;

public interface PhotoService {
	
	DataResult<Map> uploadImageFile(MultipartFile file);

}

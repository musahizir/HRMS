package kodlama.io.hrms.core.utilities.photo;

import java.io.IOException;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;

@Service
public class PhotoManager implements PhotoService {

	
	    private Cloudinary cloudinary;

	   
	    public PhotoManager() {
	        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
	        		
	        		"cloud_name", "dwr6y7ynz", 
	        		"api_key", "721434789621895", 
	        		"api_secret", "WFXDiK1Z8FNe9yRoA2q98fTY3hk"
	        		
	        		));
	    }

	    @Override
		public DataResult<Map> uploadImageFile(MultipartFile file) {
			try {
				@SuppressWarnings("unchecked")
				Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
				return new SuccessDataResult<Map>(resultMap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return new ErrorDataResult<Map>();
		}
}

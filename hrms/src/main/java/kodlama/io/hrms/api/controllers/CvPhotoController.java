package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.cvservices.CvPhotoService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.CvPhoto;

@RestController
@RequestMapping("/api/cvPhoto")
public class CvPhotoController {

	private CvPhotoService cvPhotoService;

	@Autowired
	public CvPhotoController(CvPhotoService cvPhotoService) {
		super();
		this.cvPhotoService = cvPhotoService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvPhoto cvPhoto, MultipartFile file) {

		this.cvPhotoService.add(cvPhoto, file);
		return new SuccessResult();
	}

}

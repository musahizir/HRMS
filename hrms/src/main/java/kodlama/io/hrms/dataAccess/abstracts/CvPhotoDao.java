package kodlama.io.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer> {

//	List<CvPhoto> getAllByCv_CvId(int cvId);
//	
//	CvPhoto findById(int id);
}

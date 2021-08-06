package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer> {

	List<CvSchool> getAllByCv_CvIdOrderByCvSchoolGraduateDate(int cvId);

	List<CvSchool> getAllByCv_CvId(int cvId);

	CvSchool findById(int id);

}

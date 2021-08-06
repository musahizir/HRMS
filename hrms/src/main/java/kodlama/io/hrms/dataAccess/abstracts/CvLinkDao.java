package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.CvLink;

public interface CvLinkDao extends JpaRepository<CvLink, Integer> {

	List<CvLink> getAllByCv_CvId(int cvId);

	CvLink findById(int id);
}

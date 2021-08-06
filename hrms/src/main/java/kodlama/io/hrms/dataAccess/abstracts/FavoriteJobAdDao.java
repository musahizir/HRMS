package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.FavoriteJobAd;

public interface FavoriteJobAdDao extends JpaRepository<FavoriteJobAd, Integer> {

	List<FavoriteJobAd> getByCandidateId(int id);

}

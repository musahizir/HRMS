package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="favorite_job_add")
@Entity
public class FavoriteJobAd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="favorite_job_add_id")
	private int favoriteJobAddId;
	
	@ManyToOne()
	@JoinColumn(name = "job_ad_id")
	private JobAd jobAd;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate; 

}

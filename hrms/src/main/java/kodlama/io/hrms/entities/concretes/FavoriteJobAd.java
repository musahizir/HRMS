package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorite_job_add")
@Entity
public class FavoriteJobAd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "favorite_job_add_id")
	private int favoriteJobAddId;

	@ManyToOne()
	@JoinColumn(name = "job_ad_id")
	private JobAd jobAd;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		FavoriteJobAd that = (FavoriteJobAd) o;

		return Objects.equals(favoriteJobAddId, that.favoriteJobAddId);
	}

	@Override
	public int hashCode() {
		return 641790795;
	}
}

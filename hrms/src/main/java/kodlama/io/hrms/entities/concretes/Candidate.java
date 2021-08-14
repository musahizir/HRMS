package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "candidate_id")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cv", "favoriteJobAd" })
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality_id")
	@Min(value = 11, message = "Kimlik numarası 11 haneli olmalıdır.")
	private String nationalityId;

	@Column(name = "birth_year")
	private int birthYear;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@ToString.Exclude
	private List<Cv> cv;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@ToString.Exclude
	private List<FavoriteJobAd> favoriteJobAd;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Candidate candidate = (Candidate) o;

		return Objects.equals(getId(), candidate.getId());
	}

	@Override
	public int hashCode() {
		return 703906644;
	}
}

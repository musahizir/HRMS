package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
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
	private List<Cv> cv;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<FavoriteJobAd> favoriteJobAd;

}

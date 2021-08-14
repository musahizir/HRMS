package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv")
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cvDetails", "cvExperience", "cvLanguage", "cvLink",
		"cvProgrammingLanguage", "cvSchool" })
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;

	@Column(name = "cv_name")
	private String cvName;

	@OneToMany(mappedBy = "cv")
	@ToString.Exclude
	private List<CvDetails> cvDetails;

	@OneToMany(mappedBy = "cv")
	@ToString.Exclude
	private List<CvExperience> cvExperience;

	@OneToMany(mappedBy = "cv")
	@ToString.Exclude
	private List<CvLanguage> cvLanguage;

	@OneToMany(mappedBy = "cv")
	@ToString.Exclude
	private List<CvLink> cvLink;

	@OneToMany(mappedBy = "cv")
	@ToString.Exclude
	private List<CvProgrammingLanguage> cvProgrammingLanguage;

	@OneToMany(mappedBy = "cv")
	@ToString.Exclude
	private List<CvSchool> cvSchool;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Cv cv = (Cv) o;

		return Objects.equals(cvId, cv.cvId);
	}

	@Override
	public int hashCode() {
		return 311730239;
	}
}

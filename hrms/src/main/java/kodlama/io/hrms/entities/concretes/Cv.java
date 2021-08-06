package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
	private List<CvDetails> cvDetails;

	@OneToMany(mappedBy = "cv")
	private List<CvExperience> cvExperience;

	@OneToMany(mappedBy = "cv")
	private List<CvLanguage> cvLanguage;

	@OneToMany(mappedBy = "cv")
	private List<CvLink> cvLink;

	@OneToMany(mappedBy = "cv")
	private List<CvProgrammingLanguage> cvProgrammingLanguage;

	@OneToMany(mappedBy = "cv")
	private List<CvSchool> cvSchool;

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}

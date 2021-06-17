package kodlama.io.hrms.entities.concretes;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="candidate_id")
public class Candidate extends User {
	
	public Candidate(int id, String email, String password, String firstName, String lastName, String nationalityId,
			int birthYear) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthYear = birthYear;
	}
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvDetails> cvDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvExperience> cvExperience;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvLanguage> cvLanguage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvLink> cvLink;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvProgrammingLanguage> cvProgrammingLanguage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvSchool> cvSchool;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvPhoto> cvPhoto;
	
	
	
	

	
	
	
	
	

	

}

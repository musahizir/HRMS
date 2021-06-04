package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_programming_language")
@Entity
public class CvProgrammingLanguage {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_programming_language_id")
	private int cvProgrammingLanguageId;
	
	@Column(name="cv_programming_language_name")
	private String cvProgrammingLanguageName;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name= "candidate_id")
	private Candidate candidate;

}

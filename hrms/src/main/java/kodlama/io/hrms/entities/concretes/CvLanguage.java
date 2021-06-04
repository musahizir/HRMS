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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_languages")
@Entity
public class CvLanguage {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cv_languages_id")
	private int cvLanguageId;
	
	@Column(name="cv_language_level")
	private short cvLanguageLevel;
	
	@Column(name="cv_language_name")
	private String cvLanguageName;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name= "candidate_id")
	private Candidate candidate;
	
}

	
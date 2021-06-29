package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name="cv_programming_language_level")
	private String cvProgrammingLanguageLevel;
	
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv; 


}

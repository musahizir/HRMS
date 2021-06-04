package kodlama.io.hrms.entities.concretes;



import java.time.LocalDate;

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
@Table(name="cv_schools")
@Entity
public class CvSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_schools_id")
	private int cvSchoolId;
	
	@Column(name = "cv_schools_start_date")
	private LocalDate cvSchoolStartDate;
	
	@Column(name = "cv_schools_graduate_date")
	private LocalDate cvSchoolGraduateDate;
	
	@Column (name = "cv_schools_branch")
	private String cvSchoolBranch;
	
	@Column (name = "cv_schools_name")
	private String cvSchoolName;
	
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name= "candidate_id")
	private Candidate candidate;
}

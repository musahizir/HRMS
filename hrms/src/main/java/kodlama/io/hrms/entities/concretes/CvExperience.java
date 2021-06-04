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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cv_experience")
@Entity
public class CvExperience {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cv_experience_id")
	private int cvExperienceId;
	
	@Column(name="cv_experience_company_name")
	private String cvExperienceCompanyName;
	
	@Column(name="cv_experience_start_date")
	private LocalDate cvExperienceStartDate;
	
	@Column(name="cv_experience_leave_date")
	private LocalDate cvExperienceLeaveDate;
	
	@Column(name="cv_experience_position")
	private String cvExperiencePosition;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name= "candidate_id")
	private Candidate candidate;
}

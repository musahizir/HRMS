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
@Table(name="cv_details")
@Entity
public class CvDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_details_id")
	private int cvDetailsId;
	
	@Column(name="cv_details_field")
	private String cvDetailsField;
	
	@Column(name="cv_last_update_date")
	private LocalDate cvLastUpdateDate;
	
	@Column(name="cv_create_date")
	private LocalDate cvCreateDate;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name= "candidate_id")
	private Candidate candidate;

}

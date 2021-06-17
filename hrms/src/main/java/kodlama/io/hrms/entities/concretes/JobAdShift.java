package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name="job_ad_shift")
public class JobAdShift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_ad_shift_id")
	private int jobAdShiftId;
	
	@Column(name="job_ad_shift_type")
	private String jobAdShiftType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobAdShift")
	private List<JobAd> jobAd;
}

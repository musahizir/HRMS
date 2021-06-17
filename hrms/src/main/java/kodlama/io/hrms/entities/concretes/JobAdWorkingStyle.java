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

@Table(name="job_ad_working_style")
public class JobAdWorkingStyle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_ad_working_style_id")
	private int jobAdWorkingStyleId;
	
	@Column(name="job_ad_working_style_type")
	private String jobAdWorkingStyleType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobAdWorkingStyle")
	private List<JobAd> jobAd;
}

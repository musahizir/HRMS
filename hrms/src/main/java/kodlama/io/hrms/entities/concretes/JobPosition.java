package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_titles")
@JsonIgnoreProperties ({"hibernateLazyInitializer","handler , jobAd"})
public class JobPosition {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_title_id")
	private int job_id;
	
	
	@Column(name="job_title")
	private String jobName;
	
	@OneToMany(mappedBy ="jobPosition", fetch = FetchType.LAZY)
	private List<JobAd> jobAd;

}

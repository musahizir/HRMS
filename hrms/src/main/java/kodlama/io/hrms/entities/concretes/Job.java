package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="job_tittles")
public class Job {
	

	@Id
	@GeneratedValue
	@Column(name="job_id")
	private int job_id;
	
	
	@Column(name="job_tittle")
	private String job_tittle;

}

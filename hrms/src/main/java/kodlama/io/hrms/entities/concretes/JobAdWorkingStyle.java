package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "job_ad_working_style")
public class JobAdWorkingStyle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_ad_working_style_id")
	private int jobAdWorkingStyleId;

	@Column(name = "job_ad_working_style_type")
	private String jobAdWorkingStyleType;

	@JsonIgnore
	@OneToMany(mappedBy = "jobAdWorkingStyle")
	@ToString.Exclude
	private List<JobAd> jobAd;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		JobAdWorkingStyle that = (JobAdWorkingStyle) o;

		return Objects.equals(jobAdWorkingStyleId, that.jobAdWorkingStyleId);
	}

	@Override
	public int hashCode() {
		return 1122721086;
	}
}

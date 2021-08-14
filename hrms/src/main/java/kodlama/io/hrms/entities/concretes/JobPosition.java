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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_titles")

public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_title_id")
	private int jobId;

	@Column(name = "job_title")
	private String jobName;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition", fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<JobAd> jobAd;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		JobPosition that = (JobPosition) o;

		return Objects.equals(jobId, that.jobId);
	}

	@Override
	public int hashCode() {
		return 255751276;
	}
}

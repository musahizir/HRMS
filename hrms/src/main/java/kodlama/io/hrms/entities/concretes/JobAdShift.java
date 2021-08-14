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

@Table(name = "job_ad_shift")
public class JobAdShift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_ad_shift_id")
	private int jobAdShiftId;

	@Column(name = "job_ad_shift_type")
	private String jobAdShiftType;

	@JsonIgnore
	@OneToMany(mappedBy = "jobAdShift")
	@ToString.Exclude
	private List<JobAd> jobAd;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		JobAdShift that = (JobAdShift) o;

		return Objects.equals(jobAdShiftId, that.jobAdShiftId);
	}

	@Override
	public int hashCode() {
		return 174244539;
	}
}

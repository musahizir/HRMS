package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_experience")
@Entity
public class CvExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_experience_id")
	private int cvExperienceId;

	@Column(name = "cv_experience_company_name")
	private String cvExperienceCompanyName;

	@Column(name = "cv_experience_start_date")
	private LocalDate cvExperienceStartDate;

	@Column(name = "cv_experience_leave_date")
	private LocalDate cvExperienceLeaveDate;

	@Column(name = "cv_experience_position")
	private String cvExperiencePosition;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvExperience that = (CvExperience) o;

		return Objects.equals(cvExperienceId, that.cvExperienceId);
	}

	@Override
	public int hashCode() {
		return 619704224;
	}
}

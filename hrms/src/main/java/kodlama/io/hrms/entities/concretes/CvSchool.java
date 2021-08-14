package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_schools")
@Entity
public class CvSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_schools_id")
	private int cvSchoolId;

	@Column(name = "cv_schools_start_date")
	private LocalDate cvSchoolStartDate;

	@Column(name = "cv_schools_graduate_date")
	private LocalDate cvSchoolGraduateDate;

	@Column(name = "cv_schools_branch")
	private String cvSchoolBranch;

	@Column(name = "cv_schools_name")
	private String cvSchoolName;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvSchool cvSchool = (CvSchool) o;

		return Objects.equals(cvSchoolId, cvSchool.cvSchoolId);
	}

	@Override
	public int hashCode() {
		return 509431338;
	}
}

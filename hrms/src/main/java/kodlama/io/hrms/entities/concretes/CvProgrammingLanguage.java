package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv_programming_language")
@Entity
public class CvProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_programming_language_id")
	private int cvProgrammingLanguageId;

	@Column(name = "cv_programming_language_name")
	private String cvProgrammingLanguageName;

	@Column(name = "cv_programming_language_level")
	private String cvProgrammingLanguageLevel;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvProgrammingLanguage that = (CvProgrammingLanguage) o;

		return Objects.equals(cvProgrammingLanguageId, that.cvProgrammingLanguageId);
	}

	@Override
	public int hashCode() {
		return 1650173991;
	}
}

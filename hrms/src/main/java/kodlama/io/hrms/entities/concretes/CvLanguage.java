package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_languages")
@Entity
public class CvLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_languages_id")
	private int cvLanguageId;

	@Column(name = "cv_language_level")
	private short cvLanguageLevel;

	@Column(name = "cv_language_name")
	private String cvLanguageName;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvLanguage that = (CvLanguage) o;

		return Objects.equals(cvLanguageId, that.cvLanguageId);
	}

	@Override
	public int hashCode() {
		return 1456367944;
	}
}

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
@Table(name = "employer_update")
@Entity
public class EmployerUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_update_id")
	private int employerUpdateId;

	@Column(name = "employer_update_json")
	private String employerUpdateJson;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		EmployerUpdate that = (EmployerUpdate) o;

		return Objects.equals(employerUpdateId, that.employerUpdateId);
	}

	@Override
	public int hashCode() {
		return 2043062086;
	}
}

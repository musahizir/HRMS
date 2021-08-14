package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends User {

	@Column(name = "employee_first_name")
	private String firstName;

	@Column(name = "employee_last_name")
	private String lastName;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Employee employee = (Employee) o;

		return Objects.equals(getId(), employee.getId());
	}

	@Override
	public int hashCode() {
		return 949447908;
	}
}

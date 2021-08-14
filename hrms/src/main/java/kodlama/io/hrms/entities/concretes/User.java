package kodlama.io.hrms.entities.concretes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@Email
	@NotBlank
	@NotNull
	private String email;

	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;

	 @ManyToMany(fetch = FetchType.EAGER)
	 private Collection<Role> roles = new ArrayList<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;

		return Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return 562048007;
	}
}

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
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employer_id")

public class Employer extends User {

	@Column(name = "employer_company_name")
	private String companyName;

	@Column(name = "employer_website")
	private String website;

	@Column(name = "employer_phone_number")
	private String phoneNumber;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	@ToString.Exclude
	private List<JobAd> jobAd;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Employer employer = (Employer) o;

		return Objects.equals(getId(), employer.getId());
	}

	@Override
	public int hashCode() {
		return 956758138;
	}
}

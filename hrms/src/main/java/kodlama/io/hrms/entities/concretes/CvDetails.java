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
@Table(name = "cv_details")
@Entity
public class CvDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_details_id")
	private int cvDetailsId;

	@Column(name = "cv_details_field")
	private String cvDetailsField;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvDetails cvDetails = (CvDetails) o;

		return Objects.equals(cvDetailsId, cvDetails.cvDetailsId);
	}

	@Override
	public int hashCode() {
		return 1405432436;
	}
}

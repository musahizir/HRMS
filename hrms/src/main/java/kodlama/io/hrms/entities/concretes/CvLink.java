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
@Table(name = "cv_links")
@Entity
public class CvLink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_link_id")
	private int cvLinkId;

	@Column(name = "cv_link_name")
	private String linkName;

	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvLink cvLink = (CvLink) o;

		return Objects.equals(cvLinkId, cvLink.cvLinkId);
	}

	@Override
	public int hashCode() {
		return 1712125959;
	}
}

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
@Table(name = "cv_photo")
@Entity

public class CvPhoto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_photo_id")
	private int cvPhotoId;

	@Column(name = "cv_photo_url")
	private String cvPhotoUrl;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CvPhoto cvPhoto = (CvPhoto) o;

		return Objects.equals(cvPhotoId, cvPhoto.cvPhotoId);
	}

	@Override
	public int hashCode() {
		return 1832193989;
	}
}

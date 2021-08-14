package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_ad")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "favoriteJobAd" })
public class JobAd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_ad_id")
	private int jobAdId;

	@Column(name = "job_ad_description")
	private String jobAdDescription;

	@Column(name = "job_ad_min_wage")
	private int jobAdMinWage;

	@Column(name = "job_ad_max_wage")
	private int jobAdMaxWage;

	@Column(name = "job_ad_application_end")
	private LocalDate jobAdApplicationEnd;

	@Column(name = "job_ad_max_open_position")
	private int jobAdMaxOpenPosition;

	@Column(name = "job_ad_is_active")
	private boolean jobAdIsActive;

	@Column(name = "job_ad_is_confirmed")
	private boolean jobAdIsConfirmed;

	@Column(name = "job_ad_posted_date")
	private LocalDate jobAdPostedDate;

	@Column(name = "job_ad_confirm_request")
	private boolean jobAdConfirmRequest;

	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_ad_shift_id")
	private JobAdShift jobAdShift;

	@ManyToOne()
	@JoinColumn(name = "job_ad_working_style_id")
	private JobAdWorkingStyle jobAdWorkingStyle;

	@OneToMany(mappedBy = "jobAd")
	@ToString.Exclude
	private List<FavoriteJobAd> favoriteJobAd;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		JobAd jobAd = (JobAd) o;

		return Objects.equals(jobAdId, jobAd.jobAdId);
	}

	@Override
	public int hashCode() {
		return 1916360370;
	}
}

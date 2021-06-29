package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_ad")
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
	
	@Column(name="job_ad_is_active")
	private boolean jobAdIsActive;
	
	@Column(name="job_ad_is_confirmed")
	private boolean jobAdIsConfirmed;
	
	@Column(name="job_ad_posted_date")
	private LocalDate jobAdPostedDate;
	
	@Column(name="job_ad_confirm_request")
	private boolean jobAdConfirmRequest;
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name= "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name= "job_ad_shift_id")
	private JobAdShift jobAdShift;
	
	@ManyToOne()
	@JoinColumn(name= "job_ad_working_style_id")
	private JobAdWorkingStyle jobAdWorkingStyle;

	
}

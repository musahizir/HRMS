package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="employer_id")

public class Employer extends User{
	
	@Column(name="employer_company_name")
	private String companyName;
	
	
	@Column(name="employer_website")
	private String website;
	
	@Column(name="employer_phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAd> jobAd;

}

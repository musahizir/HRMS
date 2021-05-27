package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	

}

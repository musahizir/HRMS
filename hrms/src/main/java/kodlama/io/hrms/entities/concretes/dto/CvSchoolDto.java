package kodlama.io.hrms.entities.concretes.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvSchoolDto {

	private int cvId;
	
	private LocalDate cvSchoolStartDate;
	
	private LocalDate cvSchoolGraduateDate;
	
	private String cvSchoolBranch;
	
	private String cvSchoolName;
		

}

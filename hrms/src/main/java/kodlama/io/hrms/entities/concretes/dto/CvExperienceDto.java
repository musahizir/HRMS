package kodlama.io.hrms.entities.concretes.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperienceDto {

	private int cvId;

	private String cvExperienceCompanyName;

	private LocalDate cvExperienceStartDate;

	private LocalDate cvExperienceLeaveDate;

	private String cvExperiencePosition;

}

package kodlama.io.hrms.entities.concretes.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvProgrammingLanguageDto {

	private int cvId;
	
	private String cvProgrammingLanguageName;
	
	private String cvProgrammingLanguageLevel;
}

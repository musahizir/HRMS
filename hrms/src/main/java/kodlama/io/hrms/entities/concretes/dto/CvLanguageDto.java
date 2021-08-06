package kodlama.io.hrms.entities.concretes.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvLanguageDto {

	private String cvLanguageName;

	private short cvLanguageLevel;

	private int cvId;
}

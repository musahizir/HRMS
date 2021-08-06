package kodlama.io.hrms.entities.concretes.dto;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CvDetails;
import kodlama.io.hrms.entities.concretes.CvExperience;
import kodlama.io.hrms.entities.concretes.CvLanguage;
import kodlama.io.hrms.entities.concretes.CvLink;
import kodlama.io.hrms.entities.concretes.CvProgrammingLanguage;
import kodlama.io.hrms.entities.concretes.CvSchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private Candidate candidate;

	private List<CvSchool> cvSchool;

	private List<CvLanguage> cvLanguage;

	private List<CvLink> cvLink;

	private List<CvProgrammingLanguage> cvProgrammingLanguage;

	private List<CvExperience> cvExperience;

	private List<CvDetails> cvDetails;

}

package kodlama.io.hrms.entities.concretes.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdFilterDto {
	
	private List<Integer> cityId;
	
	private List<Integer> jobId;
	
	private List<Integer> jobAdWorkingStyleId;
	
	private List<Integer> jobAdShiftId;

}

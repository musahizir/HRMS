package kodlama.io.hrms.entities.concretes.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdRegisterDto {
	
	private int jobPositionId;
	private String jobAdDescription;
	private int cityId;
	private int jobAdMinWage;
	private int jobAdMaxWage;
	private int jobAdMaxOpenPosition;
	private LocalDate jobAdApplicationEnd;
	private int employerId;
	

}

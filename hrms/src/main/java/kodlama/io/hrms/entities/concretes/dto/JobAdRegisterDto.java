package kodlama.io.hrms.entities.concretes.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdRegisterDto {

	private String jobAdDescription;

	private int jobAdMinWage;

	private int jobAdMaxWage;

	private int jobAdMaxOpenPosition;

	private LocalDate jobAdApplicationEnd;

	@JsonIgnore
	private boolean jobAdIsActive = false;

	@JsonIgnore
	private boolean jobAdConfirmRequest = true;

	@JsonIgnore
	private boolean jobAdIsConfirmed = false;

	private int employerId;

	private int jobAdWorkingStyleId;

	private int jobAdShiftId;

	private int jobId;

	private int cityId;
}

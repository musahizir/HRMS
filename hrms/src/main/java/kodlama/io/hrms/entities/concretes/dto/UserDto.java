package kodlama.io.hrms.entities.concretes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDto {

	private String email;
	private String password;
	private String confirmPassword;

}

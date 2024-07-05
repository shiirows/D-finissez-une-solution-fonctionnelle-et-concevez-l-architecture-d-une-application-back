package projetcar.mazoyer.alexandre.projetThree.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SigninRequest {
	
	@NotBlank
	@NotNull
	@Size(min = 6, max = 40)
	private String password;

	@NotBlank
	@NotNull
	@Size(max = 100)
	private String email;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

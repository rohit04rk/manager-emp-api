package com.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ManagerDto extends CommonFields {

	@NotBlank
	@Email(message = "Email id is invalid")
	private String email;

	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{5,20}$")
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}

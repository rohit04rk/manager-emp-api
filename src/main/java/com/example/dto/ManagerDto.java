package com.example.dto;

import javax.validation.constraints.NotBlank;

import com.example.validation.ValidEmail;
import com.example.validation.ValidPassword;

public class ManagerDto extends CommonFields {

	@NotBlank
	@ValidEmail
	private String email;

	@NotBlank
	@ValidPassword
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}

package com.example.model;

import javax.validation.constraints.NotBlank;

import com.example.validation.ValidEmail;
import com.example.validation.ValidPassword;

public class UserCredential {

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

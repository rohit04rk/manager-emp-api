package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.validation.ValidEmail;
import com.example.validation.ValidPassword;

public class ManagerDto extends CommonFields {

	@NotBlank
	@ValidEmail
	private String email;

	@NotBlank
	@ValidPassword
	private String password;

	@NotBlank
	@Size(max = 50, message = "Max 50 characters are allowed")
	private String company;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCompany() {
		return company;
	}

}

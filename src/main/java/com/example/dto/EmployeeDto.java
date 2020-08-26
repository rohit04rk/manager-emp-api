package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EmployeeDto extends CommonFields {

	@NotBlank
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "mobile number is invalid")
	private String mobile;

	@NotBlank
	@Size(max = 50, message = "Max 20 characters are allowed for city name")
	private String city;

	public String getMobile() {
		return mobile;
	}

	public String getCity() {
		return city;
	}

}

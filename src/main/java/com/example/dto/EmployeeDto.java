package com.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.validation.ValidMobile;
import com.example.validation.ValidName;

public class EmployeeDto extends CommonFields {

	@NotBlank
	@ValidMobile
	private String mobile;

	@NotBlank
	@ValidName
	@Size(max = 50, message = "Max 50 characters are allowed")
	private String city;

	public String getMobile() {
		return mobile;
	}

	public String getCity() {
		return city;
	}

}

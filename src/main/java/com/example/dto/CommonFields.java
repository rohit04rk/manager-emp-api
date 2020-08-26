package com.example.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommonFields {

	@NotBlank
	@Size(max = 30, message = "Max 30 characters are allowed for first name")
	private String firstName;

	@NotBlank
	@Size(max = 30, message = "Max 30 characters are allowed for last name")
	private String lastName;

	@NotNull
	private Date dateOfBirth;

	@NotBlank
	@Size(max = 50, message = "Max 50 characters are allowed for company name")
	private String company;

	@NotBlank
	@Size(max = 200, message = "Max 200 characters are allowed for company name")
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

}

package com.example.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.validation.ValidName;

public class CommonFields {

	@NotBlank
	@ValidName
	@Size(max = 30, message = "{name.size}")
	private String firstName;

	@NotBlank
	@ValidName
	@Size(max = 30, message = "{name.size}")
	private String lastName;

	@NotNull
	private Date dateOfBirth;

	@NotBlank
	@Size(max = 200, message = "Max 200 characters are allowed")
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

	public String getAddress() {
		return address;
	}

}

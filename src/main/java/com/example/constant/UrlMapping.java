package com.example.constant;

public class UrlMapping {

	private UrlMapping() {
		throw new IllegalStateException("Constants class.can't instatiate");
	}

	public static final String BASE_URL = "api/v1";

	public static final String LOGIN = "login";
	public static final String SIGNUP = "signup";

	public static final String EMPLOYEES = "employees";
	public static final String SINGLE_EMPLOYEE = "employees/{employeeUuid}";
}

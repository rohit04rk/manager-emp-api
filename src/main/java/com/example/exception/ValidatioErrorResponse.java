package com.example.exception;

public class ValidatioErrorResponse {

	private String fieldName;
	private String message;

	public ValidatioErrorResponse(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}

}

package com.example.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final ErrorCode errorCode;

	public CustomException(String message, Throwable e, ErrorCode errorCode) {
		super(message, e);
		this.errorCode = errorCode;
	}

	public CustomException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}

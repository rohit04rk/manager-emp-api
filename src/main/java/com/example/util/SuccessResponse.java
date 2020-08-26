package com.example.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class SuccessResponse<T> {

	private String message;
	private int code;
	private T data;

	public SuccessResponse(T data, int code) {
		super();
		this.data = data;
		this.code = code;
	}

	public SuccessResponse(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public SuccessResponse(String message, T data, int code) {
		super();
		this.message = message;
		this.data = data;
		this.code = code;
	}

	public SuccessResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public T getData() {
		return data;
	}

}

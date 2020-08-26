package com.example.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.exception.ValidatioErrorResponse;

@Component
public class ResponseMaker {

	public <T> ResponseEntity<SuccessResponse<T>> successResponse(T data, HttpStatus status) {
		SuccessResponse<T> response = new SuccessResponse<>(data, status.value());

		return new ResponseEntity<>(response, status);
	}

	public ResponseEntity<Object> validationErrorsResponse(String message,
			List<ValidatioErrorResponse> validationErros) {

		ErrorResponse response = new ErrorResponse(message, HttpStatus.BAD_REQUEST.value(), true);
		response.setValidationErros(validationErros);

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<ErrorResponse> errorResponse(String message, int errorCode) {
		ErrorResponse response = new ErrorResponse(message, errorCode, true);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

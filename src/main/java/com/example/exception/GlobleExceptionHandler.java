package com.example.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.util.ErrorResponse;
import com.example.util.ResponseMaker;

@RestControllerAdvice
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResponseMaker responseMaker;

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customExceptionHandler(CustomException e) {

		return responseMaker.errorResponse(e.getMessage(), e.getErrorCode().getCode());
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> nullPointerHandler(NullPointerException e) {
		String msg = "Something went wrong...Please try again later";
		return responseMaker.errorResponse(msg, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ValidatioErrorResponse> validationErros = ex.getBindingResult().getFieldErrors().stream()
				.map(f -> new ValidatioErrorResponse(f.getField(), f.getDefaultMessage())).collect(Collectors.toList());

		return responseMaker.validationErrorsResponse("Please enter valid data", validationErros);
	}

}
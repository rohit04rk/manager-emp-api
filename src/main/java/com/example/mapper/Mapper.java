package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.exception.CustomException;
import com.example.exception.ErrorCode;

@Component
public class Mapper {

	public <T> T convert(Object srcObj, Class<T> targetClass) {
		T response = null;

		try {
			response = new ModelMapper().map(srcObj, targetClass);
		} catch (Exception e) {
			throw new CustomException("Error while converting object", e, ErrorCode.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}

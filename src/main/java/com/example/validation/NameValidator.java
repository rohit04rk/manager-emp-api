package com.example.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NameValidator implements ConstraintValidator<ValidName, String> {

	private String regex = "^[a-zA-Z ]+$";

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(name))
			return true;

		Pattern pat = Pattern.compile(regex);
		return pat.matcher(name).matches();
	}

}

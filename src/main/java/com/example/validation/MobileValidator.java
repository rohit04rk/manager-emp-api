package com.example.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class MobileValidator implements ConstraintValidator<ValidMobile, String> {

	private String regex = "^[6-9]\\d{9}$";

	@Override
	public boolean isValid(String mobile, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(mobile))
			return true;

		Pattern pat = Pattern.compile(regex);
		return pat.matcher(mobile).matches();
	}

}

package com.example.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

	private String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{5,20}$";

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(password))
			return true;

		Pattern pat = Pattern.compile(regex);
		return pat.matcher(password).matches();
	}

}

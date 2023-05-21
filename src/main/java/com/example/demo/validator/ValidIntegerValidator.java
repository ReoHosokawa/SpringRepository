package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidIntegerValidator implements ConstraintValidator<ValidInteger, Integer> {

	private int[] values;
	
	@Override
	public void initialize(ValidInteger validValue) {
		this.values = validValue.values();
	}
	
	@Override
	public boolean isValid(final Integer targetValue, ConstraintValidatorContext context) {
		for (final int value : values) {
			if (targetValue == value) {
				return true;
			}
		}
		
		return false;
	}
}

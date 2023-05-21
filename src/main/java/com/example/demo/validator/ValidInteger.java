package com.example.demo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(value = {ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {com.example.demo.validator.ValidIntegerValidator.class})
public @interface ValidInteger {
	String message() default "{message}";
	int[] values();
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

package com.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CarValidator.class)
public @interface CarAnno {
	//double price();
	String message() default "error message for Car.";
    Class[] groups() default {};
    Class[] payload() default {};
}

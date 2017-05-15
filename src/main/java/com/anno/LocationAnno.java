package com.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=LocationValidator.class)
public @interface LocationAnno {
	//double price();
	String message() default "Cannot have that combination";
    Class[] groups() default {};
    Class[] payload() default {};
}

package com.kevinpham.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Helper class that contains business rules/logic
@Target( { ElementType.METHOD, ElementType.FIELD } ) // Can apply annotation to method or field
@Retention(RetentionPolicy.RUNTIME) // Retain annotation in the Java class file. Process it at runtime
public @interface CourseCode {

	
	// Define default course code
	public String[] value() default {"LUV"};
	
	// Define default error message
	public String message() default "Must start with LUV";
	
	// Define default groups
	public Class<?>[] groups() default {};
	
	// Define default payloads
	public Class<? extends Payload>[] payload() default {};
	
}

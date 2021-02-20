package com.kevinpham.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Helper class that contains business rules/logic
@Target( { ElementType.METHOD, ElementType.FIELD } ) // Can apply annotation to method or field
public @interface CourseCode {
	
}

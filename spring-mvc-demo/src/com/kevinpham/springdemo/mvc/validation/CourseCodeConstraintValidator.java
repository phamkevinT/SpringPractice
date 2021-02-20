package com.kevinpham.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result = false;

		if (theCode != null) {

			for(String temp : coursePrefix) {
				// Check if the user's entered string start with values in array coursePrefix
				result = theCode.startsWith(temp); 
				// If we find a match, break
				if(result) {
					break;
				}
			}
		} else {
			result = true;
		}
		return result;
	}

}

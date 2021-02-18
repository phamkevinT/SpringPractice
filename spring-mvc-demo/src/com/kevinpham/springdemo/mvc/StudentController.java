package com.kevinpham.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

	// ID from Spring Config
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// Create new student object
		Student theStudent = new Student();

		// Add student object to the model
		theModel.addAttribute("student", theStudent);
		
		// Add the country options to the model 
	    theModel.addAttribute("theCountryOptions", countryOptions); 

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		// Log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

		return "student-confirmation";
	}
}

package com.kevinpham.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// Need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// Need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// New controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// Read the request parameter from the HTML form
		// (studentName = form input name)
		String theName = request.getParameter("studentName");

		// Convert the data to all UpperCase
		theName = theName.toUpperCase();

		// Create the message
		String result = "Yo! " + theName;

		// Add the message to the model
		// (message = the ID to retrieve the result in helloworld.jsp)
		model.addAttribute("message", result);

		return "helloworld";
	}

	// New controller method to read form data and add data to the model using
	// '@RequestParam' in the parameter
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

		// Convert the data to all UpperCase
		theName = theName.toUpperCase();

		// Create the message
		String result = "Hello my friend, " + theName;

		// Add the message to the model
		// (message = the ID to retrieve the result in helloworld.jsp)
		model.addAttribute("message", result);

		return "helloworld";
	}
}

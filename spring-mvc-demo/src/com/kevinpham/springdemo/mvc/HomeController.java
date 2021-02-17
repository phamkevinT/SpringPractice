package com.kevinpham.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// Define Controller Method
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
				
	}
}

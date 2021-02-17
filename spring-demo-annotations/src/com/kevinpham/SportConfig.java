package com.kevinpham;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.kevinpham")
public class SportConfig {
	
	// Define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define bean for our swim coach AND inject dependency 
	@Bean 
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
}

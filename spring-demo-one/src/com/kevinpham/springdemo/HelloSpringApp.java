package com.kevinpham.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demo of the Constructor Dependency Injection
 * @author Kevin Pham
 *
 */
public class HelloSpringApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		// Parameter: the name of the XML configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from spring container
		// Parameter: "myCoach" = the bean ID in the XML configuration file
		// Parameter: "Coach.class" = the interface named Coach
		Coach theCoach = context.getBean("mySwimCoach", Coach.class);

		// Call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call method for fortunes
		System.out.println(theCoach.getDailyFortune());

		// Close the context
		context.close();

	}

}

package com.kevinpham.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		// Parameter: the name of the XML configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve bean from spring container
		// Parameter: "myCoach" = the bean ID in the XML config file
		// Parameter: "Coach.class" = the interface named Coach
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// Call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// Close the context
		context.close();

	}

}

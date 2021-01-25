package com.kevinpham.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

		// Retrieve bean from spring container
		Coach theCoach = context.getBean("mySwimCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		// Close the context
		context.close();

	}

}

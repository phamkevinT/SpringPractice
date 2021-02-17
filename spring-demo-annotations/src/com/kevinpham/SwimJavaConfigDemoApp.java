package com.kevinpham;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// Get the bean from spring container (ID = the bean 'name' in SportConfig file)
		Coach theCoach = context.getBean("swimCoach", Coach.class);

		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// Call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());

		// Close the context
		context.close();

	}

}

package com.kevinpham;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// Get the bean from spring container (ID = the bean 'name' in SportConfig file)
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// Call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Call our new swim coach methods ... property values injected from files
		System.out.println("Email: " + theCoach.getEmail());
		System.out.println("Team: " + theCoach.getTeam());

		// Close the context
		context.close();

	}

}

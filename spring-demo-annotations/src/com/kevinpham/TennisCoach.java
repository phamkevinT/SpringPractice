package com.kevinpham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	// Field Injection
	// Qualifier specifies which bean to use
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	// Set up default constructor
		public TennisCoach() {
			System.out.println(">> TennishCoach: Inside default constructor");
		}

//  Constructor Injection with Autowiring
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		// Spring will check what class implements the FortuneService and inject it in
//		// the constructor
//		fortuneService = theFortuneService;
//	}
	
	
//	// Setter Injection with Autowiring
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> TennishCoach: Inside setFortuneService() ");
//		fortuneService = theFortuneService;
//	}
	
	
//	// Method Injection with Autowiring
//	@Autowired
//	public void doSomething(FortuneService theFortuneService) {
//		System.out.println(">> TennishCoach: Inside doSomething() ");
//		fortuneService = theFortuneService;
//	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

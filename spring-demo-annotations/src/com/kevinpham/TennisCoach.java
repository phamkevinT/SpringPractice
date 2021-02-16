package com.kevinpham;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

//  Constructor Injection with Autowiring
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		// Spring will check what class implements the FortuneService and inject it in
//		// the constructor
//		fortuneService = theFortuneService;
//	}
	
	// Set up default constructor
	public TennisCoach() {
		System.out.println(">> TennishCoach: Inside default constructor");
	}
	
	// Setter Injection with Autowiring
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennishCoach: Inside setFortuneService() ");
		fortuneService = theFortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

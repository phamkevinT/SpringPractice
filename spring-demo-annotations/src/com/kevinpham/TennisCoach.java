package com.kevinpham;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// Scope: singleton (by default, share same instance). prototype -> new instance every time
public class TennisCoach implements Coach {

	// Field Injection
	// Qualifier specifies which bean to use
	@Autowired
	@Qualifier("randomFortuneService")
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
	

	// Define my init method
	// PostConstruct -> Runs this method after constructor
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: Inside of doMyStartUpStuff()");
	}
	

	// Define my destroy method
	// PreDestory -> Runs before destroying bean
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> TennisCoach: Inside of doMyCleanUpStuff()");
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

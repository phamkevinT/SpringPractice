package com.kevinpham.springdemo;

public class BaseballCoach implements Coach {

	// Define a private field for the dependency
	private FortuneService fortuneService;

	// Define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	// Define a no argument constructor
	public BaseballCoach() {

	}

	@Override
	public String getDailyWorkout() {

		return "Spend 30 minutes on batting practice.";
	}

	@Override
	public String getDailyFortune() {

		// Use for my fortuneService to get a fortune
		return fortuneService.getFortune();
	}

}

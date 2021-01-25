package com.kevinpham.springdemo;

public class SwimCoach implements Coach {

	// Define a private field for the dependency
	private FortuneService fortuneService;

	// Define a constructor for dependency injection
	public SwimCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Swim laps for 30 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

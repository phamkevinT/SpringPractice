package com.kevinpham.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	// Create a no-argument constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}

	// Create setter method for injection
	// This is called by Spring when it injects the dependency
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

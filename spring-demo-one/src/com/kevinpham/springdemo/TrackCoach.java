package com.kevinpham.springdemo;

public class TrackCoach implements Coach {

	// Define a private field for the dependency
	private FortuneService fortuneService;

	// Define a constructor for dependency injection
	public TrackCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}

	// Define a no argument constructor
	public TrackCoach() {

	}

	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k.";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it! " + fortuneService.getFortune();
	}
	
	// Add an initialization method
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: Inside method doMyStartUpStuff");
	}
	
	// Add a destroy method
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: Inside method doMyCleanUpStuff");
	}

}

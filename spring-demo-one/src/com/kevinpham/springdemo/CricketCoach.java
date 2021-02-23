package com.kevinpham.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	// Add new fields for emailAddress and team
	private String emailAddress;
	private String team;

	// Create a no-argument constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside no-arg constructor");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter method - setTeam");
		this.team = team;
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

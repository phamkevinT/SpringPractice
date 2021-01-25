package com.kevinpham.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	// Array of random fortune strings
	private String[] data = {
			"Beware fo the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	// Create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// Pick a random string from the array of fortunes
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}

package com.kevinpham;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Create an array of string
	private String[] data = { 
			"Beware of the worlf in sheep's clothing", 
			"Diligence is the mother of good luck",
			"The journey is the reward" };

	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}

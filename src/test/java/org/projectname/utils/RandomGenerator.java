package org.projectname.utils;

import java.util.Random;

public class RandomGenerator {
	
public static int generateRandomNumber()
{
	Random random = new Random();
	int randomNumber = random.nextInt();		
    return randomNumber;
}

public static int generateEightRandomNumbers() {
	
	Random rnd = new Random();
	int n = 1000000 + rnd.nextInt(9900000);
	return n;
	}
}

package com.test.example;

import java.util.Random;

public class MyRandom extends Random { // Random + 커스텀 (원하는 기능)
	
	// 2.
	public int getNumber() {
		
		Random rnd = new Random();
		return rnd.nextInt(10) + 1;
	}
	
	// 3.
	public static String getColor() {
		
		Random rnd = new Random();
		String[] colors = {"red", "yellow", "blue", "black", "white"};
		return colors[rnd.nextInt(colors.length)];
	}
	
	
	
}











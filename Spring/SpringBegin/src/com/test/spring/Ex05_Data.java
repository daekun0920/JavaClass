package com.test.spring;

import java.util.Random;

public class Ex05_Data {
	
	public int getData() {
		
		
		// Ex05 -> (의존) -> Ex05_Data
		Random rnd = new Random();
		
		return rnd.nextInt(100);
	}

}

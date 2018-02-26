package com.test.example;

import java.util.Random;

public class RandomTest {
		
	
		public static int nextInt() {
			
			Random rnd = new Random();
			return rnd.nextInt();
			
		}
		
		// 난수 생성기를 자주 사용하는 업무 -> 메소드 구현
		// 2. 1 ~ 10
		public static int getNumber() {
			
			Random rnd = new Random();
			
			return rnd.nextInt(10) + 1;
			
		}
		// 3. 색상 난수
		public static String getColor() {
			Random rnd = new Random();
			String[] colors = {"red", "yellow", "blue", "black", "white"};
			
			return colors[rnd.nextInt(colors.length)];
			
		}
		
}

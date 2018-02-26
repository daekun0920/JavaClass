package com.test.example;

import java.util.Random;

public class Ex42_Inheritance {
	public static void main(String[] args) {
		
		// Ex42_Inheritance.java
		
		// 부모 클래스 : 자식 클래스
		// 슈퍼 클래스 : 서브 클래스
		// 기본 클래스 : 확장(파생) 클래스 
		
		
		
		// 부모 클래스 -> Random 클래스
		// 상황) 내 업무 > 난수 발생 잦음 > Random 객체 사용 빈도 높음
		//		1. nextInt() : -21억 ~ 21억
		//      2. 1 ~ 10 사이의 난수
		//      3. 색상 난수 : red, yellow, blue, white, black 
		
		m1(); // 상속없이.. 예전대로
		m2(); // 상속 사용
		
		
	}

	private static void m2() {
			MyRandom rnd = new MyRandom();
			
			// 1.
			System.out.println(rnd.nextInt());
			System.out.println(rnd.nextInt());
			System.out.println(rnd.nextInt());
			
			// 2. 
			System.out.println(rnd.getNumber());
			System.out.println(rnd.getNumber());
			System.out.println(rnd.getNumber());
			
			// 3.
			System.out.println(rnd.getColor());
			System.out.println(rnd.getColor());
			System.out.println(rnd.getColor());
			
			System.out.println(rnd.nextBoolean());
	}

	private static void m1() {
		Random rnd = new Random();
		
		// 1. nextInt()
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt());
		
		System.out.println(RandomTest.nextInt());
		
		// 논리형 난수 발생
		
		
		// 2. 1 ~ 10 사이의 
		int n = rnd.nextInt(10) + 1;
		System.out.println(n);
		
		n = rnd.nextInt(10) + 1;
		System.out.println(n);
		
		n = rnd.nextInt(10) + 1;
		System.out.println(n);
		
		System.out.println(RandomTest.getNumber()); // 위와 동일한 업무를 다른 클래스의 정적 메소드로 뺌 // 자주 쓰는경우 
		
		// 3. 색상 난수 
		String[] colors = {"red", "yellow", "blue", "black", "white"};
		
		String color = colors[rnd.nextInt(colors.length)];
		System.out.println(color);
		
		color = colors[rnd.nextInt(colors.length)];
		System.out.println(color);
		
		color = colors[rnd.nextInt(colors.length)];
		System.out.println(color);
		
		System.out.println(RandomTest.getColor()); // 위와 동일한 업무를 다른 클래스의 정적 메소드로 뺌 // 자주 쓰는경우 
	
	}
}

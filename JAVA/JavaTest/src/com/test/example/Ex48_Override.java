package com.test.example;

import java.util.Calendar;

public class Ex48_Override {
	public static void main(String[] args) {
		
		// Ex48_Override.java
		
		OverrideTime t1 = new OverrideTime(2, 30, 50);
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2017, 11, 15, 2, 30, 50);
		
		int n = 10;
		System.out.println(n);
		
		// *** 
		System.out.println(c1); // 데이터 출력 
		System.out.println(c1.toString()); // toString 을 오버라이딩 했다 
		
		// com.test.example.OverrideTime@232204a1 => 마지막 @xxxxxx 는 "해시 코드(객체 ID,메모리 주소)" 이다. to.String 이 만듬 
		System.out.println(t1);
		System.out.println(t1.toString());
	
	
	
	}
}

class OverrideTime {
	
	private int hour;
	private int min;
	private int sec;
	
	// 서비스 차원에서 인자값 없는 생성자도 만드는것이 좋다.
	public OverrideTime() {
		this(0, 0, 0);
	}
	
	// 생성자 오버라이딩 
	public OverrideTime(int hour, int min, int sec) {
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	// toString 오버라이딩
	@Override // <- 어노테이션
	public String toString() {
		// 자신의 데이터를 문자열로 만들어서 돌려주기 -> 덤프(dump)
		return String.format("%d : %d : %d"
							, this.hour, this.min, this.sec);
	}
	
}










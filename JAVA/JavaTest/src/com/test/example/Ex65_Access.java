package com.test.example;

import com.test.access.Blue;

public class Ex65_Access extends Red {
	
	public static void main(String[] args) {
		
		// Ex65_Access.java
		
		// 접근 지정자
		// 1. private : 패키지 x, 다른 클래스x
		// 2. public : 다른 패키지 o, 다른 클래스o
		// 3. default : 패키지가 같으면 public, 클래스는 무관, 패키지 다르면 private
		// 4. protected : default 적용 + 자식 클래스이면 public
		
		// 1. 자기 자신(같은 패키지 + 같은 클래스)
		Red red = new Red();
		red.check(); 
		
		System.err.println(red.d); // public 
		
		// 2. 같은 패키지 + 다른 클래스
		System.out.println(red.b); // default
		System.out.println(red.c); // protected
		
		// 3. 다른 패키지 + 다른 클래스
		Blue blue = new Blue();
		blue.check();
	}
	
}

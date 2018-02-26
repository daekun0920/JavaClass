package com.test.example;

import java.util.Calendar;

public class Ex49_final {
	public static void main(String[] args) {
		
		// Ex49_final.java
		
		// final 키워드 
		//   - 한번 만들면 못 고친다.
		// 1. 변수에 적용
		// 2. 메소드에 적용 : 상속
		// 3. 클래스에 적용 : 상속
		
		// final 변수
		//   - 값을 수정할 수 없다.
		//   - 값을 초기화한 뒤 절대로 수정할 수 없는 공간 > 상수 (변하지 않는 값)
		int a = 10;
		final int b = 20;
		
		a = 30;
		// b = 40;
		
		System.out.println(a);
		System.out.println(b);
		
		// 수정하려는 시도를 원천봉쇄 
//		final double pi = 3.14;
//		pi = 6.24;
		
		System.out.println(a);
		System.out.println(b);
		
		// 상수명 명명법
		//   - 무조건 모두 대문자로
		//   - 변수 만들때 초기화 하기 
		final double PI = 3.14;
		
		// PI = 10;
		
		System.out.println(Calendar.YEAR);
		
		System.out.println(MyCalendar.YEAR);
		
		/*
		final String NAME;
		
		NAME = "홍길동"	 // 초기화
				
		System.out.println(NAME);
		
		NAME = "아무개"  // 치환
		*/
				
	}
}


class MyCalendar {
	public final static int YEAR = 1;
	
}

final class FinalParent { 		// final 으로 자식 클래스를 두지 않게됨
								// 클래스를 설계할 자신이없다 -> final로 클래스 만듬 
								// Terminal Node 들은 final로 만들어야한다.
	// 멤버 구현..
	public final void aaa() { // final 사용 
		System.out.println("Parent 기능");
	}
	
}

//class FinalChild extends FinalParent {
	
//	@Override
//	public void aaa() {
//		System.out.println("부모 기능 대신 자식이 구현");
//	}
	
//}













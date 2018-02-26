package com.test.example;

public class Ex58_enum {
	
	public static void main(String[] args) {
		
		// Ex58_enum.java
		
		// 열거형, Enumeration
		//   - 클래스의 일종(= 자료형)
		//   - 열거값을 가지는 자료형
		//   - 기호 상수(Symbolic Constant)가 필요할 때 사용
		//   - 가독성 상승 + 오타 줄임 > 안정성 상승 
		
		// 클래스
		// 1. 일반 클래스
		// 2. 추상 클래스
		// 3. 인터페이스
		// 4. 열거형
		
		
		
		// 요구사항) 쇼핑몰 + 옷 판매 : 색상 지정
		String color = "white"; // scan.nextLine(); 사용자 입력
		System.out.println(color);
		
		
		// enum
		Color c = Color.white;
		
		// 열거한 자료중에서만 사용가능(안정성)
		// color = "gray";
		// c = Color.gray;
		
		
		// 예)
		// 집 -> 직장
		
		// if문 사용
		int sel = 1;
		
		if (sel == 1) {
			System.out.println("지하철");
		} else if (sel == 2) {
			System.out.println("버스");
		} else if (sel == 3) {
			System.out.println("택시");
		} else if (sel == 4) {
			System.out.println("바이크");
		}
		
		// enum 사용
		Transfer sel2 = Transfer.TAXI; 
		
		// 데이터들이 의미를 갖게 됨 
		if (sel2 == Transfer.SUBWAY) {
			System.out.println("지하철");
		} else if (sel2 == Transfer.BUS) {
			System.out.println("버스");
		} else if (sel2 == Transfer.TAXI) {
			System.out.println("택시");
		} else if (sel2 == Transfer.BIKE) {
			System.out.println("바이크");
		}
	}
}

// enum 사용
enum Transfer {
	SUBWAY, // final 상수라서 모두 대문자로
	BUS,
	TAXI,
	BIKE
}

// 열거형 선언하기
enum Color {
	// 열거형 멤버
	
	// 아래 white는 내부적으로 public static final int white; 와 같다 
	white,
	black,
	yellow,
	red,
	blue
}

enum 직급 {
	부장,
	과장,
	대리,
	사원
}









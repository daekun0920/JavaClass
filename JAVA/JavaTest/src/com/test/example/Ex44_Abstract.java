package com.test.example;

public class Ex44_Abstract {
	
	public static void main(String[] args) {
		
		// Ex44_Abstract.java
		
		// 객체의 사용법을 통일시키기 위하여 사용된다.
		// 추상 클래스, Abstract Class
		//  - 클래스의 한 종류 > 상속 관계를 맺는게 가능 > 반드시 상속 관계를 맺고 사용
		//  - 상속 관계없이 추상 클래스를 단독으로 사용하지 않는다.
		//  - 상속받는 객체의 행동(사용법)을 표준화(강제로 제한)
		//  - 클래스를 사용해서 객체 생성 + 사용하는 개발자를 위한 기술
		
		// 추상 메소드, Abstract Method
		//  - 추상 클래스에 소속되어 객체 표준화하는데 사용됨
		
		// 홍길동  // LG100, Dell200 추상화 > 모니터
		LG100 lg = new LG100();
		
		lg.poweron();
		lg.poweroff();
		
		// lg.on();
		// lg.off();
		
		Dell200 dell = new Dell200();
		
		dell.poweron();
		dell.poweroff();
		
		// dell.up();
		// dell.down();
		
		
		
		
	} // main
	
} // Ex44 

// 추상 클래스 선언하기
abstract class Monitor {
	
	// 추상 클래스 멤버
	// 1. 일반 구현 멤버
	//  a. 멤버 변수 
	//  b. 멤버 메소드 
	// 2. 추상 멤버
	//  a. 추상 메소드
	
	
	public String model;
	public int price;
	
	public void info() {
		System.out.println(model + " : " + price);
	}
	
	// 추상 메소드 선언하기 -> 자식 클래스로 만드는 객체들의 사용법을 통일
	
	// 모든 모니터들의 전원 키는법
	public abstract void poweron(); // 추상 메소드 - 구현부가 없는 메소드
	public abstract void poweroff(); 
	
	
 }
	
class LG100 extends Monitor {
	
	// 추상 메소드 구현
	public void poweron() {
		System.out.println("전원 켜기");
	}
	
	// 전원 켜기
//	public void on() {
//		System.out.println("전원 켜기");
//	}
	
	// 전원 끄기
//	public void off() {
//		System.out.println("전원 끄기");
//	}

	@Override
	public void poweroff() {
		System.out.println("전원 끄기");
	}
}

class Dell200 extends Monitor { 
	
	// 전원 켜기
//	public void up() {
//		System.out.println("전원 켜기");
//	}
	
	// 전원 끄기
//	public void down() {
//		System.out.println("전원 끄기");
//	}

	@Override
	public void poweron() {
		System.out.println("전원 켜기");
	}

	@Override
	public void poweroff() {
		System.out.println("전원 끄기");
	}
}
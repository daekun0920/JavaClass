package com.test.example;

public class Ex55_interface {
	public static void main(String[] args) {
		
		// Ex55_interface.java
		
		A a = new A();
		a.test();
		
	}
	
}

class A {
	public void test() {
		System.out.println("A");
		
		// 이부분의 업무를 다른이에게 위임
		// 1. 업무가 너무 클 때 (가독성)
		// 2. 재사용이 있다고 생각될 떄(반드시)
		
		// 이 업무를 위임받기 위한 자격
		//   - 객체와 객체간의 서로 상호작용을 하기 위한 규칙으로 사용
		// 1. 추상 클래스 상속 -> 일반 멤버 비중이 높음
		//					   -> 코드의 결합이 강해지고 딱딱해짐
		
		// 2. 인터페이스 구현(상속) -> 사용 빈도가 더 높음,
		//							   잘 분간이 안갈땐 100%,
		//	 						   서로간의 결합(관계) 가 가벼워짐 
		
		B b = new B();
		
		String result = b.connect();
		System.out.println(result);
		
		C c = new C();
		
		result = c.connect();
		System.out.println(result);
		
		System.out.println("A");
		System.out.println("A");
	}
}

abstract class User { 
	// 추상 클래스를 선택 -> 일반 멤버(변수, 일반 메소드) 구현이 필수
	// 일반 멤버의 구현이 없으면 추상 클래스가 아니라 인터페이스로 만들어야 한다
	public String name;
	public void check() {
		
	}
	
	public abstract String connect();
}

class B extends User {

	@Override
	public String connect() {
		return "B";
	}
}

class C extends User {
	@Override
	public String connect() {
		return "C";
	}
}

class D extends User {

	@Override
	public String connect() {
		return null;
	}
	
}
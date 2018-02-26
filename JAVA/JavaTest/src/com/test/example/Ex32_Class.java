package com.test.example;

public class Ex32_Class {
	
	public static void main(String[] args) {
		
		// Ex32_Class.java
		
		// 접근 지정자(제어자), Access Modifier
		//   - public, private / protected, default
		
		
		// 1. public
		//   - 클래스 멤버를 외부에 공개해야 하는 경우 사용
		//   - 100%
		
		// 2. private
		//   - 클래스 멤버를 외부에 비공개해야 하는 경우 사용
		//   - 100% 비공개
		//   - 같은 클래스의 멤버끼리는 접근 가능(100% 가능)
		//   - 외부에서의 접근이 필요할 때 -> getter / setter 를 사용
		
		
		AccessTest t1 = new AccessTest();
		
		t1.a = 10; // public
		
		//t1.b = 20; // private 
		
		t1.aaa();
		
		//t1.bbb();
		
		t1.test();
		
		
		// e1
		//   - Employee 타입의 참조변수
		//   - e1 이라는 객체 -> 객체 변수
		//   - e1 이라는 인스턴스 -> 인스턴스 변수
		Employee e1 = new Employee();
		
		e1.aaa(40);
		System.out.println(e1.bbb());
		
		e1.setAge(20);
		System.out.println(e1.getAge());
		
		
//		e1.name = "홍길동";
//		e1.age = 40;
//		e1.department = "영업부";
		
//		System.out.println(e1.name);
//		System.out.println(e1.department);
		
		
		Employee e2 = new Employee();
		
		e2.setAge(2000000);
		System.out.println(e2.getAge());
		
//		e2.name = "아무개입니다";
//		e2.age = 23000;
//		e2.department = "안드로메다";
	}
}


// 사원 클래스 
class Employee {
	
	// 접근 지정자 사용 가이드
	// 1. 멤버 변수
	// 		1. 멤버 변수는 무조건 private으로 지정한다 ( public 할경우 틀린 값이들어가도 오류가 나지않음)
	// 		2. setter(전달자)/getter(외부로 빼오는자) 메소드를 구현한다. 
	// 2. 멤버 메소드 
	//      1. 멤버 메소드는 용도를 잘 모르겠으면 일단 private으로 한다.
	//		2. 멤버 메소드의 역할을 충분히 이해 -> 외부 접근 발생 -> 그때 public 수정한다.
	
	
	private String name;   		  // 이름
	private int age;       	  // 나이
	private String department;   // 부서
	 
	public void aaa(int a) { // private에게 대신 전달 
		age = a;
		
	}
	
	public int bbb() { // 내부값(private)을 외부로 빼와준다.
		return age;
	}
	
	public void setAge(int age) {   // private에게 대신 전달 (정석 버전)
		if (age >= 0 && age <= 130) {
			this.age = age; 		// 멤버 변수와 매개변수는 이름이 같아도 동시에 존재 가능 
									// this. 을 붙여 멤버 변수화
		} else {					// 같은이름을 사용한다
			System.out.println("올바른 나이가 아닙니다.");
		}
	 
							
	}
	public int getAge() {  // 내부값(private)을 외부로 빼와준다. (정석 버전)
		return this.age;
	}
	
}

class AccessTest {
	
	// 접근 지정자
	//   - 클래스 멤버에게
	public int a = 10;   // 외부 접근 가능
	private int b = 20;  // 외부 접근 불가
	
	public void aaa() {
		System.out.println("Aaa");
	}
	private void bbb() {
		System.out.println("bbb");
	}
	
	public void test() { // 같은 클래스내에 있는 멤버끼리는 private이라도 호출이나 출력가능 
		System.out.println(a);
		System.out.println(b);
		aaa();
		bbb();
	}
	
}













package com.test.example;

public class Ex30_Class {

		public static void main(String[] args) {
			
			//Ex30_Class.java
			
			/*
			 
			 클래스, Class
			 
			 1. 객체 지향 프로그래밍 Object     Oriented Programming     C++
			 	절차 지향 프로그래밍 Procedural Oriented Programming C
			 	
			 2. 객체(개체), Object
			 	- 데이터 + 행동 = 객체
			 	- 변수 + 메소드 = 객체
			 	
			 	- 독자성, Identity
			 	- 상태, State
			 	- 행동, Behavior
			 	- 캡슐화, Encapsulation
			 	- 정보 은닉화
			 	- 인터페이스 (내부와 외부를 연결시키는 중간다리 역할)
			 	
			 3. 클래스, Class
			 	- 객체를 생성하는 설계도
			 	- 개발자 -> 클래스 설계(선언) -> 나중에 객체가 생성될 때
			 	객체가 소유하게 될 데이터와 행동을 정의하는 것 -> 클래스를 사용해서 객체
			 	생성 -> 객체를 사용해서 목적에 맞는 업무를 구현
			 	
			 4. 클래스 vs 객체(Object) vs 인스턴스(Instance)
			 	- 클래스 : 틀, 추상적
			 	- 객체 : 클래스를 통해 생성 
			 	- 인스턴스 : (= 객체), 메모리상에 실체화된 객체
			 
			 
			 자바에서 클래스 만들기
			 
			 class 클래스명 {
			 	// 클래스 구성요소(= 클래스 멤버)
			 	1. 변수 선언
			 	2. 메소드 선언
			 	
			 }
			 
			 1. 실제 파일명과 클래스명은 동일해야 한다.
			 	- 컴파일 에러 발생
			 	- Ex30_Class.java -> class Ex30_Class {}
			 	
			 2. 클래스명은 대문자로 시작해야 한다.
			 	- 파스칼 표기법 사용 
			 	- 필수(x) -> 권장(o) -> 필수(o)
			 
			 3. 자바 파일(*.java) 1개당 클래스 1개 선언 
			 	- 필수(x) -> 권장(o)
			 	- 소스 파일 관리가 쉬워진다.
			 	- 1개의 .java 파일내에 여러개의 클래스를 선언하는 경우
			 		a. 모든 클래스 중에 public 키워드를 가지는 클래스는 유일
			 		b. public 클래스가 파일명이 된다.
			 
			 */
			// 3. 객체 생성하기
			// 자료형 변수명 = 객체 생성 연산자 생성자();
			Test t = new Test();
			
			Test t1;
			int n;
			byte b;
			boolean f;
			double d;
			
			// 지도 -> 좌표값 
			// 1. 우리집
			// 2. 마트
			
			// case 1.
			
			// 우리집
			int x1 = 100;
			int y1 = 200;
			
			// 마트
			int x2 = 250;
			int y2 = 330;
			
			// case2.
			// 서로 다른 데이터들을 한 배열에 집어넣으면 안된다
			int[] a1 = new int[2];
			a1[0] = 100;
			a1[1] = 200;
			
			int [] a2 = new int[2];
			a2[0] = 250;
			a2[1] = 330;
			
			// case3.
			Point p1 = new Point();
			
			p1.name = "우리집";
			p1.x = 100;
			p1.y = 200;
			
			Point p2 = new Point();
			
			p2.name = "마트";
			p2.x = 250;
			p2.y = 330;
			
			Size s1 = new Size();
			
			s1.width = 1000;
			s1.height = 500;
			
			Student2 hong = new Student2();
			
			hong.address = "서울시";
			hong.name = "홍길동";
			hong.gender = "남자";
			hong.height = 180;
			hong.weight = 80;
			hong.age = 20;
			
			// static 키워드 
			// MyMath m = new MyMath();
			MyMath.sum(10,  20);
			MyMath.divide(100, 3);
			
			
			Men m1 = new Men();
			
			m1.name = "홍길동";
			m1.age = 20;
			m1.job = "학생";
			m1.hello();
			
			Men m2 = new Men();
			m2.name = "아무개";
			m2.hello();
			
			
			
		} // main
} //class

// 클래스 목적
// 1. 데이터의 집합 = 변수
// 2. 행동의 집합 = 메소드 
// 3. 데이터와 행동의 집합 = 변수 + 메소드

// 1.
class Point {
    public String name;
	public int x;
	public int y;
}

class Size {
	public int width;
	public int height;
}

// 
/**/
/**
 * 
 * 학생 클래스입니다.
 *
 */
class Student2 {
	public String name;
	public int age;
	public String gender;
	/**
	 * 학생의 집주소입니다.
	 */
	public String address;
	public int height;
	public int weight;
}

// 2.
class MyMath {
	
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	public static void divide (int a, int b) {
		System.out.println(a / b);
	}
	
}

// 3.
class Men{
	
	// 멤버 변수
	public String name;
	public int age;
	public String job;
	
	// 멤버 메소드
	//   - 되도록 객체 자신이 주체가 되는 행동
	//   - 자신이 가진 데이터를 이용한 행동
	public void hello() {
		System.out.println("안녕하세요. 저는" + name + "입니다.");
	

	}

}



// 1. 클래스 선언하기(설계하기)
class Test {
	
	// 2. 클래스 멤버 구현하기
	public int a;
	public int b;
	
	public static void aaa() {
		System.out.println("aaa");
	}
	
	public static void bbb() {
		
	}
}

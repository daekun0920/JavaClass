package com.test.lambda;

public class Ex01 {

	public static void main(String[] args) {
		/*
		  
		  람다식, lambda
		  - 객체 지향 프로그래밍 코드 패턴 -> 함수 지향 프로그래밍 패턴 
		  - JDK 1.8부터 지원
		  - 익명 객체 사용	
		  - 람다식은 익명 함수를 만들기 위해 사용. 자바는 익명클래스를 사용해서 익명 메소드를 만든다.
		  람다식을 사용하면 익명 객체를 통해 익명 함수를 만들 수 있다. -> 인터페이스 
		  
		  람다식을 사용한 함수 만들기
		  - 함수적 스타일 문법 사용
		  
		  public void m1(매개변수) {
		  	구현부;
		  }
		  
		  (매개변수) -> { 구현부; }
		  
		  - 일반적인 람다식을 사용한 함수
		  (int a) -> { syso(a); }
		  
		  - 호출부(or 구현부)쪽에서 매개변수의 타입을 유추
		  (a) -> { syso(a); }
		  
		  - 매개 변수가 1개일때 소괄호 생략 가능
		  a -> { syso(a); }
		  
		  - 실행문 1줄일 때 중괄호 생략 가능
		  a -> syso(a);
		  
		  - 매개변수가 없거나 2개 이상일때는 소괄호 생략 불가능
		  () -> { syso("안녕"); }
		  (a, b) -> { syso(a + b); }
		  
		  - 실행문 2줄 이상 일때 중괄호 생략 불가능
		  (a, b) -> syso(a); syso(b); // X
		  (a, b) -> { syso(a); syso(b);} // O
		  (a, b) -> {
		  	syso(a); 
		  	syso(b); // O
		  }
		  
		  - 반환값
		  (a) -> { return a * a; }
		  a -> a * a;
		  a -> m1(a);
		  
		  public int m2(int a) {
		  	return m1(a);
		  }
		  
		  
		 */
		
		
		// () -> { System.out.println("람다식"); }
		
		// 익명 객체
		Test1 t1 = new Test1() {

			@Override
			public void m1() {
				System.out.println("안녕하세요.");
			}

//			@Override
//			public void m2() {
//				
//			}
			
		};
		
		t1.m1();
		
		
		// 람다식 -> 메소드 최대 1개만 구현 가능함 
		// - 자바에서는 람다식을 사용한 메소드를 정의를 (익명 객체를 사용해) 인터페이스에 저장한다.
		// - 람다식을 저장하는 인터페이스를 함수형(함수적) 인터페이스라고 부른다.
		Test1 t2 = () -> { System.out.println("반갑습니다."); }; // 보이진 않지만 위 예제 처럼 익명 객체(클래스)로 감싸져 있다.
		t2.m1(); // 만들때만 이름이 없고 호출할때는 인터페이스에 이미 결정된 이름으로 호출
		
		
		
		// 인자값O, 반환값X 메소드 구현
		Test3 t3 = (int a) -> { System.out.println(a * a); };
		t3.m1(10);
		
		Test3 t4 = (a) -> { System.out.println(a * a); };
		t4.m1(20);
		
		Test3 t5 = a -> System.out.println(a * a);
		t5.m1(30);
		
		// 인자값 2개 이상
		Test4 t6 = (count, name) -> {
			for (int i = 0; i < count; i++) {
				System.out.println(name);
			}
		};
		t6.m1(5, "하하하");
		
		// 리턴값 
		Test5 t7 = () -> { return "아무개"; };
		System.out.println(t7.m1());
		
		Test5 t8 = () -> "호호호";   // 메소드 블럭내에서 return문만이 유일한 문장일떄..
		System.out.println(t8.m1());
		
		Test6 t9 = (a, b) -> { return a + b; };
		System.out.println(t9.m1(5, 8));
		
		Test6 t10 = (a, b) -> a * b; // 메소드 블럭내에서 return문만이 유일한 문장일떄..
		System.out.println(t10.m1(20, 30));
		
		
	}
	
	public void m1() {
		System.out.println("람다식");
	}
	
}



// 1. 반환값 X, 인자값X
@FunctionalInterface // annotation 어노테이션(기능이 있는 주석) -> 람다식을 저장할 인터페이스에만 붙임 -> 아래에 있는 인터페이스가 추상메소드를 1개만 가지고 있는지 체크 
interface Test1 {
	void m1(); // 반환값x, 인자값x
	//void m2(); // 람다식에서 사용하는 인터페이스는 반드시 추상 메소드를 딱 1개 가질 수 있다. 
}


@FunctionalInterface
interface Test2 {
	void m1();
	//void m2();
}


// 2. 인자값O, 반환값X 함수형 인터페이스
@FunctionalInterface
interface Test3 {
	void m1(int a); // 람다식의 원형 
}


// 3. 인자값 2개 이상 
@FunctionalInterface
interface Test4 {
	void m1(int a, String b);
}


// 4. 인자값X, 반환값O
@FunctionalInterface
interface Test5 {
	String m1();
}


// 5. 인자값O, 반환값O
@FunctionalInterface
interface Test6 {
	int m1(int a, int b);	
}


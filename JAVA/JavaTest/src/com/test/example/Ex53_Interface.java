package com.test.example;

public class Ex53_Interface {

	public static void main(String[] args) {
		
		// Ex53_Interface.java
		
		// 인터페이스, Interface
		//   - 클래스의 일종(자료형 - 상속 구성원, 변수 생성 가능)
		//   - 추상 클래스와 유사 
		//   - 인터페이스는 멤버로 추상메소드를 가진다.
		//   - 구현 멤버를 가질 수 없다. > 변수 생성X, 구현된 메소드X > 추상 메소드만 만들 수 있다.
		//   - 추상 메소드의 집합
		
		// 추상 클래스 - 일반 멤버 = 인터페이스
		// 일반 클래스 + 인터페이스 = 추상 클래스 
		// 추상 클래스 - 인터페이스 = 일반 클래스
		
		// IMouse m1 = new IMouse();
		IMouse m1;
		
		M8500G m2 = new M8500G();
		m2.click();
		m2.drag();
		m2.drop();
		
	}
}

// 인터페이스 (우선은 추상클래스와 역할이 똑같다고 보는것이 좋다)
// 헝가리안 표기법 (Interface + Mouse = IMouse)
interface IMouse {
	
	// 인터페이스 멤버 (추상 메소드만 가능, 추상 메소드와 같은 목적) 
	//    - 반드시 public 이어야함, 그렇기 때문에 접근 지정자를 표시하지 않아도 됨 (abstract도 당연한거기 때문에 생략됨)
	void click(); 
	void drag();
	void drop();
	
	// 일반 멤버, 구현된 멤버 (불가능)
	// public int price;
	// public void info() {
		
	// }
}

			// extends 와 같은 역할
class M8500G implements IMouse {

				@Override
				public void click() {
					
				}

				@Override
				public void drag() {
					
				}

				@Override
				public void drop() {
					
				}
	
}
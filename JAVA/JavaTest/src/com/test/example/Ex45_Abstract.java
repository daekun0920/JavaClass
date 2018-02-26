package com.test.example;

public class Ex45_Abstract {
	public static void main(String[] args) {
		
		// Ex45_Abstract.java
		
		// Shape s1 = new Shape();
		//s1.info();
		//s1.draw();
	
		// 추상 클래스는 객체는 만들지 못하지만 변수는 만들수 있다
		// Shape s1;
		
		Circle c1 = new Circle();
		c1.draw();
		c1.erase(); // A
		c1.info();  // B
		
		Rectangle rect1 = new Rectangle();
		rect1.draw();
		rect1.erase(); // A
		rect1.info();  // B
		
		Triangle t1 = new Triangle();
		t1.draw();
		t1.erase(); // A
		t1.info();  // B
		
	}
}

// 그림판 > 도형 그리기
// 도형 클래스 
// 1. 일반 클래스 선언
// 	 a. 원 : 이름, 위치, 지름
//   b. 사각형 : 이름, 위치, 너비, 높이
//   c. 삼각형 : 이름, 위치, 너비, 높이


// 2. 공통 부분 > 부모 클래스 선언
//   a. 일반 클래스 
//   b. 추상 클래스


// 부모 클래스
abstract class Shape {
	
	// 일반 (구현) 멤버 : 자식에게 물려주려고..
	private String name;
	private int x;
	private int y;
	
	public void info() {
		System.out.printf("%s : (%d, %d)\n"
				          , this.name, this.x, this.y);
	}
	
	// 추상 멤버 : 자식에게 행동을 강요하려고..
	// 그리기 
	public abstract void draw();
	
	// 지우기
	public abstract void erase();
}

class Circle extends Shape {
	
	// 자신만의 멤버 
	//   - 원만이 가지는 멤버
	
	@Override
	public void draw() {
		// 단, 추상 메소드는 시그너쳐(사용법)에 대한 제약만 할 뿐이지 구현부에 대한 제약은 할 수 없다.
		System.out.println("원을 그립니다.");
	}
	
	@Override
	public void erase() {
		System.out.println("원을 지웁니다.");
	}
}

class Rectangle extends Shape {

	@Override
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}

	@Override
	public void erase() {
		System.out.println("사각형을 지웁니다.");
	}	
	
}

class Triangle extends Shape {

	@Override
	public void draw() {
		System.out.println("삼각형을 그립니다.");
	}

	@Override
	public void erase() {
		System.out.println("삼각형을 지웁니다.");
	}
	
}




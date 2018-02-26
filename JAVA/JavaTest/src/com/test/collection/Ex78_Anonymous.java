package com.test.collection;

public class Ex78_Anonymous {
	
	public static void main(String[] args) {
		
		// Ex78_Anonymous.java
		
		// Anonymous Class, 익명 클래스
		//	 - 익명(이름이 없다.)
		//   - 재사용이 불가능하다. -> 1회용 클래스(HashMap 같은 느낌?)
		//   - 인터페이스를 사용해서 만든다.
		
		// m1. Red가 필요해서 생성
		Red r1 = new Red();
		r1.print();
		r1.fill();
		r1.draw();
		
		// m2. Color 자격을 가지는 객체가 필요해서 참조변수 Color 로 (m1과 목적과 의미가 다르다)
		Color r2 = new Red();
		r2.print();
		r2.fill();
		// r2.draw(); 는 인터페이스에 없으니 사용 못함
		
		// m3.
		Color r3 = new Color() {
			
			// 업캐스팅으로 부모타입으로 변수를 만들고
			// 이름이 없는 클래스라 
			// 클래스선언부를 가질수없어서
			// 생성부에다가 구현을 했다 
			
			@Override
			public void print() {
				
			}

			@Override
			public void fill() {
				
			}
			
			
		};
		
		// ? r3 = new ?() {};
		
		r3.print();
		r3.fill();
	}

}

// class ? implements Color {
//    구현할수없음. 	
// }


interface Color {
	void print();
	void fill();
}

class Red implements Color {

	@Override
	public void print() {
		
	}

	@Override
	public void fill() {
		
	}
	
	public void draw() {
		
	}
	
}
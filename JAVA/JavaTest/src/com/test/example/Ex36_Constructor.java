package com.test.example;

public class Ex36_Constructor {
	
	public static void main(String[] args) {
		
		// Ex36_Constructor.java
		
		// 클래스 -> 객체 생성
		// 클래스명 객체명 = new 클래스명();
		
		// 생성자, Constructor
		//   - 클래스명과 동일한 메소드
		//   - 메소드의 한 종류(특별한 역할)
		//   - 객체 생성 직 후 멤버를 초기화 하는 역할
		//   - 반환 값을 가질 수 없다.
		//   - 인자값은 가질 수 있다.
		//   - 사용자 마음대로 호출이 불가능. 반드시 객체 생성 시에만 사용 
		
		Keyboard k1 = new Keyboard();
		k1.setModel("S001");
		k1.setPrice(20000);
		
		System.out.printf("%s, %,d원\n", k1.getModel(), k1.getPrice());
		
		
		Keyboard k2 = new Keyboard();
		
		System.out.printf("%s, %,d원\n", k2.getModel(), k2.getPrice());
		
		
		
		Keyboard k3 = new Keyboard();
		
		k3.setModel("s004");
		k3.setPrice(50000);
		
		System.out.printf("%s, %,d원\n", k3.getModel(), k3.getPrice());
		
		// 생성자 오버로딩  
		Keyboard k4 = new Keyboard("s004", 50000);
	
		System.out.printf("%s, %,d원\n", k4.getModel(), k4.getPrice());
	
		Cup c1 = new Cup();
		c1.check();
		
		Cup c2 = new Cup("검정색", "종이컵", 24);
		c2.check();
	
		Cup c3 = new Cup(14);
		c3.check();
		
		Cup c4 = new Cup("빨강색");
		c4.check();
	} // main
	
} // Ex36

class Cup {
	
	private String color;     // 색상 
	private String type;      // 타입
	private int size;		   // 사이즈
	
	// 값을 세팅 -> 생성자
	// 값을 확인 -> 한번에 getter -> 출력 메소드 
	
	// 기본 생성자(가장 중립적인 값으로 세팅) 
//	public Cup() {
//		this.color = "흰색";
//		this.type = "머그컵";
//		this.size = 16;
//	}
//	
//	// 생성자 오버로딩 - 편리한 기능 - 권장
//	public Cup(String color, String type, int size) {
//		this.color = color;
//		this.type = type;
//		this.size = size;
//	}
//	// 일부 수정 
//	public Cup(int size) {
//		this.color = "흰색";
//		this.type = "머그컵";
//		this.size = size;
//	}
//	
//	public Cup(String color) {  // String type은 같은 String 이라서 둘중 하나 만 가능 
//		this.color = color;
//		this.type = "머그컵";
//		this.size = 16;
//
//	}
//	
//	
//	public void check() {
//		System.out.printf("색상 : %s, 타입 : %s, 크기 : %doz\n", this.color, this.type, this.size);
//	}
	
	
	public Cup() {
		this("흰색", "머그컵", 16); // Cup 대신 this를 사용
	}
	
	// 생성자 오버로딩 - 편리한 기능 - 권장
	public Cup(String color, String type, int size) {
		this.color = color;
		this.type = type;
		this.size = size;
	}
	// 일부 수정 
	public Cup(int size) {
		this("흰색", "머그컵", size);
	}
	
	public Cup(String color) {  // String type은 같은 String 이라서 둘중 하나 만 가능 
		this(color, "머그컵", 16);

	}
	
	
	public void check() {
		System.out.printf("색상 : %s, 타입 : %s, 크기 : %doz\n", this.color, this.type, this.size);
	}
	
}
		
		
class Keyboard {
	// 클래스 안에는 일반적인 연산이나 제어문이 올수 없다. ( 메소드 안에는 가능) -> 그래서 클래스보다 메소드 안에 변수 초기화 함 
	private String model;// = "S003";  비추천      // 멤버 
	private int price; // = 40000;
	
	// 생성자 선언 (컴파일러가 자동 생성, 기본값으로 모든 멤버 변수 초기화) // 태어날때 자동으로 초기화 하는 setter 
	public Keyboard() {
		this.model = "S002";  // 추천 
		this.price = 30000;
	}
	
	// 생성자 오버로딩
	public Keyboard(String model, int price) { // setter x 2 
		this.model = model;
		this.price = price;
		
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}




















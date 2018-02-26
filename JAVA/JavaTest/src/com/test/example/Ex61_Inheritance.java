package com.test.example;

public class Ex61_Inheritance {

	public static void main(String[] args) {
		
		// Ex61_Inheritance.java
		
		// private, public, this, super + 상속
		
		TestParent p1 = new TestParent();
		
		System.out.println(p1.a);
		// System.out.println(p1.b);
		p1.print();
		
		TestChild c1 = new TestChild(); // c1의 멤버 5개 (상속 받은것 포함)
		System.out.println(c1.a);
		// System.out.println(c1.b);
		System.out.println(c1.c);
		// System.out.println(c1.d);
		
		// 오버라이딩된 자식의 print()가 아니고 부모의 print()를 호출?
		c1.print();
		
		
		
	}
	
}

class TestParent {
	public int a = 10;
	private int b = 20;
	
	public void print() {
		System.out.println(this.a);
		System.out.println(this.b);
	}
}

class TestChild extends TestParent {
	public int c = 30;
	private int d = 40;
	
	public void print() {
		System.out.println(this.a);  // public
		// System.out.println(this.b);  // private // 금고를 물려받았지만 키는 물려받지 못한것과 같다(상속이되도 부모의 private멤버로 남는다, 모든 부모 멤버들이 자식 멤버가 되는것이 아니라 부모 클래스 자체가 자식 클래스안에 감싸져 들어오는격)
		System.out.println(this.c);  // public													   	 (private 이기때문에 자식이라도 접근하지못함, 무조건 본인만 가능)
		System.out.println(this.d);  // private 
	}
	
	public void print2() {
		// 둘다 객체를 가리킴
		// 나 자신
		this.print();
		
		// 내 부모
		super.print();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString(); // (변화 없음)원래 부모걸 그대로 사용하겠다.
	}
	
	
}




















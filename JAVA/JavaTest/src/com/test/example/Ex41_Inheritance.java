package com.test.example;

public class Ex41_Inheritance {
	
	public static void main(String[] args) {
		
		// Ex41_Inheritance.java
		
		// 클래스 상속 // 면접에서 자주 물어봄
		//   - 클래스와 클래스간의 발생
		//   - 클래스 재산? - 변수 + 메소드
		//   - 왜?
		//   - 코드 재사용(***)
		
		Child c = new Child();
		c.a = 10;
		c.b = 20;
		System.out.println(c.a);
		
		c.c = 30;
		c.d = 40;
		
		DDD d = new DDD();
		d.a = 10;
		d.b = 20;
		d.c = 30;
		d.d = 40;
	}
}

class Parent {
	public int a;
	public int b;
}
         // 부모 코드 복붙 (모든 것)
class Child extends Parent {
	public int c;
	public int d;
}


// 증조할아버지
class AAA {
	public int a;
}

// 할아버지
class BBB extends AAA {
	public int b;
}


// 아버지
class CCC extends BBB {
	public int c;
}


// 삼촌
class EEE extends BBB {
	public int e;
}


// 나 
class DDD extends CCC {
	public int d;
}


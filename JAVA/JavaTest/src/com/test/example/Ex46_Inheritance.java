package com.test.example;

public class Ex46_Inheritance {
	public static void main(String[] args) {
		
		// Ex46_Inheritance.java
		
		// 클래스, 추상 클래스 - > 상속 패턴 
		
	}
}
// 상속
// [부모] 		[자식]
// 일반클래스	일반클래스   O  자주
// 추상클래스 	일반클래스   O  자주
// 일반클래스   추상클래스   X  비권장 
// 추상클래스   추상클래스   O  일반클래스 최소 1개 필요


// 일반 클래스
class AA {
	public int a; // 일반(구현) 멤버
	//public abstract void test();
}


class BB extends AA {
	public int b;
}


abstract class CC {
	public int c;
	public abstract void ccc();
}


class DD extends CC {
	public int d;
	public void ccc() {
		
	}
	
}	

abstract class EE extends AA {
	
}

abstract class FF {
	public int f;
	public abstract void fff();
}

abstract class GG extends FF { // 자식
	// 부모와 자식이 모두 추상 클래스일 때..
	// 1. 자식이 추상 메소드를 구현 안하고 손자에게 떠넘기는 경우..
	// 2. 자식이 구현하는 경우
	
	@Override
	public void fff() {
		// 구현
	}
	public abstract void ggg();
}

class HH extends GG { // 손자 
	@Override
	public void ggg() {
		
	}
}

// 프로젝트 

// 1. 많은 데이터
// 2. 최소 3세대 상속 

// 진짜 사람 -> 일반 클래스 / 개념 -> 추상 클래스 
// 말단 노드들은 무조건 일반 클래스 
// 객체를 만들일이 없다 & 단순히 공통점을 뽑아놓은것 같다. -> 추상 클래스 / 객체를 만들일이 있다 -> 일반 클래스

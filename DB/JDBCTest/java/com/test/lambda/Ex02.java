package com.test.lambda;

public class Ex02 {
	public static void main(String[] args) {
		
		System.out.println(ITest.a);
		
		
	} // main
}

interface ITest {
	
	// 인터페이스의 멤버
	// - 인터페이스는 구현된 멤버(일반 멤버 변수, 구현부를 가진 메소드)를 가질 수 없다.
	// 1. 추상 메소드
	// 2. final 정적 변수 
	// 3. 정적 메소드
	void test1();
	
	public static final int a = 100;
	
	public static void test2() {
		
	}
	
}


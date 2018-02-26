package com.test.example;

public class Ex62_Wrapper {
	
	public static void main(String[] args) {
		
		// Ex62_Wrapper.java
		
		// 값형에 대응하는 참조형 클래스가 제공된다.
		//   -> Wrapper Class, Utility Class
		
		// int -> Integer
		// double -> Double
		// boolean -> Boolean
		
		int n1 = 10;					// 값형
		Integer n2 = new Integer(20);	// 참조형
		
		System.out.println(n1 + 10);
		System.out.println(n2 + 10);	// 원래는 되면 안되지만 원형 상수가 리턴되도록 내부적으로 설계되어있다.
		
		// 추가 기능
		int n3 = Integer.parseInt("100");
		
		System.out.println(Integer.MAX_VALUE); // Static final 상수 - Integer의 최댓값 리턴
		System.out.println(Integer.MIN_VALUE);	//                               최솟값 리턴 
		
		
		// Integer.compare() ***
		// -1 : 앞에값이 더 큼
		//  0 : 두 값이 같음
		//  1 : 뒤엣값이 더 큼 
		System.out.println(Integer.compare(10, 20));
		System.out.println(Integer.compare(20, 10));
		System.out.println(Integer.compare(10, 10));
		
		System.out.println(Integer.SIZE); // int 자료형의 크기 반환(32비트)
		System.out.println(Long.SIZE);	   // long (64비트)
		
		System.out.println(Integer.max(10, 5)); // 둘 중 더 큰 값을 반환 
		System.out.println(Integer.min(10, 5)); // 둘 중 더 작은 값을 반환 
		
		System.out.println(Integer.toBinaryString(10)); // 10진수를 2진수(문자열 타입)로 변환 
		System.out.println(Integer.toHexString(20));    // 10진수를 16진수로 변환
		System.out.println(Integer.toOctalString(10));  // 10진수를 8진수로 변환 
	}
	
}

package com.test.example;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ex63_Exception {

	public static void main(String[] args) {
		
		// Ex63_Exception.java
		
		// 이전 수업
		// 1. 값형 자료형 ~ 배열
		// 2. 클래스 ~ 상속, 열거형, 제네릭 등..
		// 3. 기타 등등
		
		// 예외, Exception
		//   - 컴파일 발견X
		//   - 런타임 발견O
		//   - 프로그램 실행 중 발견되는 에러
		//   - 프로그래머가 미리 예측을 하더라도 발생 가능성이 있음.
		
		// 예외 처리, Exception Handling
		//   1. 전통적인 방식
		//		- 제어문(if)
		//   2. 특화된 방식 
		//		- try catch 문 
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		
		try { // 예외 미루기
			m7();
		} catch (Exception e) {
			
		}
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // main

	// 예외 미루기
	//   - 예외가 발생한 영역에서 예외를 처리하지 않고 호출한 쪽으로 예외 처리를 미루는 방식 
	//   - 예외를 중앙으로 집중 시키겠다
	private static void m7() throws Exception {
		
		int n = 0;
		System.out.println(100 / n);
		
		
	}


	private static void m6() {
		
		// 업무
		//   - 3의 배수를 입력
		//   - 3의 배수가 아니면 에러
		
		int num = 3;
		
		if (num % 3 == 0) {
			System.out.println("업무 진행");
		} else {
			System.out.println("예외 처리");
		}
		
		
		
		try {
			// 문법은 예외가 아닌데
			// 업무상 예외로 취급해서
			// 강제로 예외를 발생하려는 상황
			if (num % 3 != 0) {
				throw new Exception(); // 예외 던지기(강제 예외 발생)
			}
			
			System.out.println("업무 진행");
		} catch (Exception e) {
			System.out.println("예외 처리");
		}
		
		
	}

	private static void m5() {
		
		try {
			// 1. 여러개의 예외를 1개의 try로 관리 -> 가독성
			// 2. 개발자가 예측하지 못하는 예외도 처리 가능
			// 3. 속도에 영향을 미쳐서 최소한만 사용한다
			
			// 업무1.
			int n = 10; // 사용자 입력
			System.out.println(100 / n);
		
			// 업무2.
			int[] nums = {100, 200, 300}; // 오류시에 new ArithmeticException(); 객체를 ArithmeticException e 로 던진다 
			System.out.println(nums[0]);
		
			Random rnd = null;
			System.out.println(rnd.nextInt(100));
		} catch (ArithmeticException e) { // 던진 객체를 변수로 잡는다
			System.out.println("0 입력 불가");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("방번호 틀림");
		} catch (NullPointerException e) {
			System.out.println("객체 없음");
		} catch (Exception e) { // Exception 계의 만능(최상위) 클래스임(맨 마지막에 기타 등등을 잡기위해 존재, 모든 Exception 오류 잡기가능)
			System.out.println("예외 처리");
		}
		
	}

	private static void m4() {
		Printer[] list = new Printer[2];
		list[0] = new LG200();
		list[1] = new HP300();
		
		try {
			// java.lang.ClassCastException
			((HP300)list[0]).selfCheck();
		} catch (Exception e) {
			System.out.println("예외 처리");
		}
		
	}

	private static void m3() {
		
		Random rnd = null;
		boolean flag = false;
		
		if (flag) {
			rnd = new Random();
		}
		
		try {
			// java.lang.NullPointerException
			System.out.println(rnd.nextInt(100));
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("예외 처리");
		}
		
		System.out.println("종료");
		
	}

	private static void m2() {
		
		// 배열
		int[] nums = {10, 20, 30};
		
		try {
			// java.lang.ArrayIndexOutOfBoundsException
			nums[3] = 40; // 예외 발생 
			System.out.println(nums[3]);
		} catch (Exception e) { // Exception e -> 에러가 났을때의 상황을 저장하는 객체
			System.out.println(e.toString());
		}
		
		// 문자열
		// java.lang.StringIndexOutOfBoundsException
		try {
			String str = "홍길동";
			System.out.println(str.charAt(4));
		} catch (Exception e) {
			System.out.println("예외 처리");
		}
		
		System.out.println("종료");
		
		
		
		
	}

	private static void m1() {
		
		// 예외 발생 
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = scan.nextInt();
		
		// java.lang.ArithmeticException : 산술 연산 예외
		
		
		
		// 예외 처리
		if (num != 0) {
			// 비즈니스 코드, 업무 코드
			System.out.printf("100 / %d = %d\n"
							 , num, 100 / num); // 컴파일러는 100 나누기 int 로 보아서 컴파일러 중에는 오류가 발생하지않고 실행 중 발생한다.
		} else {
			// 예외 처리 코드
			System.out.println("0을 제외한 수를 입력하세요.");
		}
		
		// 부정적인 예외처리 코드를 else 절에 넣은것이좋다.
		if (num == 0) {
			// 예외 처리 코드
						System.out.println("0을 제외한 수를 입력하세요.");
		} else {
			// 비즈니스 코드, 업무 코드
						System.out.printf("100 / %d = %d\n"
										 , num, 100 / num);
		}
		
		// if : 선감시 -> 후실행
		// try : 선실행 -> 후처리 
		
		// try catch 문 // -> 오류를 일단 발생시키고 프로그램이 중단되지 못하게 그것을 잡는다. 
		try {	// 비즈니스 코드, 업무 코드
			System.out.println("시작");
			System.out.printf("100 / %d = %d\n", num, 100 / num); // 에러 발생시 바로 catch 문으로 넘어간다.
			System.out.println("끝");
			
				// 매개변수
		} catch (Exception e) {	   // 예외 처리 코드
			System.out.println("0을 제외한 수를 입력하세요.");
		}
		
		System.out.println("프로그램 종료");
		
		
		
	} 
	
} // class 







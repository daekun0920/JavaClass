package com.test.collection;

import java.util.Stack;

public class Ex83_Collection {
	
	private static Stack<String> back; // 이전 방문 기록
	private static Stack<String> forward; // 이전 방문 기록
	
	static {
		back = new Stack<String>();
		forward = new Stack<String>();
	}
	
	public static void main(String[] args) {
		
		// Ex83_Collection.java
		
		// stack 
		// 페이지 뒤로가기, 앞으로가기 구조 
		
		goUrl("구글");
		goUrl("네이버");
		goUrl("다음");
		
		history();
	
		goBack(); // 뒤로가기 1번 클릭
		goBack();
		history();
		
		goForward(); // 앞으로 가기 1번 클릭
		history();
		
		
		
		m1();
		
		
		
	} // main
	
	// 지역변수가 사라지는순서 -> stack (값형)
	// 참조형 변수는 주소값이 사라지는것이지 다른곳에서 주소로 참조하는한 객체자체가 사라지는것은 아니다.
	private static void m1() {
		int a = 10;
		m2();
		int f = 60;
		m5();
	}

	private static void m5() {
		int e = 50;
	}

	private static void m2() {
		int b = 20;
		m3();
		m4();
	}

	private static void m4() {
		int d = 40;
	}

	private static void m3() {
		int c = 30;
	}

	
	// 주소 입력하면 사이트 방문하기
	private static void goUrl(String url) {
		System.out.println(url + "접속함");
		back.push(url);
		
	}
	
	// 방문기록 확인하기 
	private static void history() {
		System.out.println("-------------------");
		System.out.println("back : " + back.toString());
		System.out.println("now : " + back.peek());
		System.out.println("forward : " + forward.toString());
		System.out.println("-------------------");
		
		
	}
		
	// 뒤로 가기
	private static void goBack() {
		// 뒤로가기 스택 -> (이동) -> 앞으로가기 스택 
		if (!back.isEmpty()) {
			forward.push(back.pop()); // 옮기기 
		}
		
	}
	
	// 앞으로 가기
	private static void goForward() {
		// 앞으로가기 스택 -> (이동) -> 뒤로가기 스택
		if (!forward.isEmpty()) {
			back.push(forward.pop());
		}
	}
}

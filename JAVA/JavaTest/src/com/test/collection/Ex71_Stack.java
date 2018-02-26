package com.test.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex71_Stack {
	
	public static void main(String[] args) {
		
		// Ex71_Stack.java
		
		// Queue, 큐
		//   - 선입선출 // 먼저 넣은게 먼저 나온다 
		//   - FIFO, First Input First Output
		//   - 데이터를 한번 확인하면(빼면) 사라진다 
		
		// Stack, 스택 
		//   - 후입선출 // 나중에 넣은게 먼저 나온다 
		//   - LIFO, Last Input First Output
		//   - 데이터를 한번 확인하면(빼면) 사라진다
		
		// Java 공부후 (C언어, C++ -> Win32API) 공부하면 많은 도움됨. 
		
		
		// m1();
		m2();
	}

	private static void m1() {
		//		   ===================
		//		-> 노랑   파랑   빨강  ->
		//		   ===================
							// Queue의 자식중 하나
		Queue<String> queue = new LinkedList<String>();
		
		// 1. 요소 추가
		queue.add("빨강");
		queue.add("파랑");
		queue.add("노랑");
		
		// 2. 요소 갯수
		System.out.println(queue.size()); // 3
		
		// 2.5 
		System.out.println(queue.peek()); // "빨강" 출력 - 임시확인용, 이번에 나올 공 딱 하나만 보임 "빨강" 사라지지 않음
		System.out.println(queue.size());
		
		
		// 3. 요소 접근
		System.out.println(queue.poll()); // "빨강" 출력하고 사라짐
		System.out.println(queue.size()); // 2
		
		System.out.println(queue.poll()); // "파랑" 출력하고 사라짐
		System.out.println(queue.size()); // 1
		
		System.out.println(queue.poll()); // "노랑" 출력하고 사라짐
		System.out.println(queue.size()); // 0
	
		System.out.println(queue.poll()); // Null 반환 
		System.out.println(queue.size()); // 0
	
	
		queue.add("빨강");
		queue.add("주황");
		queue.add("노랑");
		queue.add("초록");
		queue.add("파랑");
		queue.add("남색");
		queue.add("보라");
		
//		System.out.println(queue.size()); // 7 
//		// 큐 -> 루프
//		// 1. 일반 for
//		
//		// length나 size는 변수로 빼서 for문에 비교식으로 넣는것이 더 효율적이다
//		int size = queue.size();
//							// 2. 해결법 : 변수에 집어넣는다
//		for (int i = 0; i < size; i++) { // 1. 한번 루프가 돌때마다 queue에서 하나씩 빼기때문에 queue.size() 값이 감소해서 끝까지 나오지 않는다
//			System.out.println(queue.poll()); // 빨주노초
//		}
		
		// 2. 향상된 for
		
//		for (String color : queue) {
//			System.out.println(color);
//		}
//		System.out.println(queue.size());  // 공이 사라지지않고 남아있음 -> queue 사용 의미 x 
		
		// 3. while 문
		
//		while (true) {
//			System.out.println(queue.poll());
//			if (queue.size() == 0) {
//				break;
//			}
//		}
		
		
		/// queue 정석 반복문 ///
//		while (queue.size() > 0) {
//			System.out.println(queue.poll());
//		}
//		System.out.println(queue.size());
		
		// etc...
		queue.clear();
		queue.contains("빨강");
		queue.isEmpty();
		queue.remove("빨강");  // X  되도록 사용하면 안됨  
		
	}

	private static void m2() {
		//		   ===================
		//	  <->  노랑   파랑   빨강| 
		//		   ===================
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		System.out.println(stack.peek()); // 사이즈에 영향 미치지 않음 / 마지막에 넣은 공(나올 공) 보임 
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		System.out.println(stack.pop()); // "노랑" 꺼내기 
		System.out.println(stack.size());
		
		System.out.println(stack.pop()); // "파랑" 꺼내기 
		System.out.println(stack.size());
		
		System.out.println(stack.pop()); // "빨강" 꺼내기 
		System.out.println(stack.size());
		
		// EmptyStackException
		// System.out.println(stack.pop()); // 실행 오류 
		// System.out.println(stack.size());
		
		
	}
	
}

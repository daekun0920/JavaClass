package com.test.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Ex82_Collection {
	
	private static Queue<String> list;
	
	static {
		list = new LinkedList<String>();
	}
	
	public static void main(String[] args) {
		
		// 컬렉션 인터페이스 -> ArrayList -> 컬렉션 정렬 -> LinkedList -> Queue & Stack -> Set -> Map
		
		// Queue
		//   - 선입선출
		//   - 메시지큐, Message Queue
		//   - 사용자 명령 -> OS -> 프로그램 
		
		// 음식점에서 음식 주문하기
		// (주방장) <-> (주문목록) <-> (손님)
		
		input("짜장면");
		input("짬뽕");
		input("탕수육");
		
		output();
		output();
		output();
		
		input("깐풍기");
		input("깐쇼새우");
		input("양장피");
		
		check();
		
	} // main
	
	// 주문하기 
	private static void input(String item) {
		list.add(item); // 주문 목록에 음식 추가
	}
	
	// 조리하기
	private static void output() {
		System.out.printf("주방장이 %s을 만들었습니다.\n", list.poll());
	}
	
	// 주문목록을 확인하기
	private static void check() {
		// 1. 향상된 for  
		
		// 2. toString()  
		System.out.println("현재 주문 목록 : " + list);
		
	}
	
}

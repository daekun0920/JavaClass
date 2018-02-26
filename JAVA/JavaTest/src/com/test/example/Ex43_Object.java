package com.test.example;

import java.util.Scanner;

public class Ex43_Object {
	
	public static void main(String[] args) {
		
		// Ex43_Object.java
		
		// Object 클래스 
		Object o = new Object();
		
		Door door = new Door();
		
		
		Scanner scan = new Scanner(System.in); // 모든 클래스들은 Object 메소드들을 가지고 있다.
		
	}
}
// 부모를 명시하지않으면 컴파일러가 무조건 Object를 부모로 설정한다. // Object -> 최상위 클래스, 루트 클래스(Root Class)
// 구성 클래스들 -> 리프 클래스(Leaf Class), 노드(Node) // 가장 마지막 클래스 -> 터미널 노드 (Terminal Node)
class Door extends Object {
	
	
	
}
























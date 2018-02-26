package com.test.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Ex88_Collection {
	
	public static void main(String[] args) {
		
		// Ex88_Collection.java
		
		// Map : HashMap, TreeMap, Hashtable, Properties
		
		// Vector -> (JDK 1.5) -> ArrayList
		// Hashtable -> (JDK 1.5) -> HashMap
		
		// Properties
		//   - Hashtable을 상속받아 구현
		//   - key와 value가 모두 String 고정
		//   - 제네릭 버전이 제공 안됨 
		//   - 주로 프로그램의 환경값들을 관리하는 용도의 집합(***)
		
		// 컬렉션 특징
		// 1. Collection
		// 	 a. List
		//       1. ArrayList
		//          - 순차적인 입출력 
		// 			- index를 사용한 탐색(loop)
		//       2. LinkedList
		//			- 요소의 추가/삭제 빈번한 작업(중간 요소)
		//       3. Queue
		//			- 선입선출
		//       4. Stack
		//  		- 후입선출 
		//   b. Set
		//       1. HashSet
		//			- 중복값 없는 집합 
		//       2. TreeSet
		//			- HashSet + 정렬 + 부분 집합 추출 
		// 2. Map
		//   a. HashMap
		// 			- 키, 값으로 구성된 집합
		//   b. TreeMap
		// 			- 부분 맵을 추출
		//   c. Properties
		//			- 설정값 저장 + 외부 입출력
		
		
		//m1();
		m2();
	}

	private static void m2() {
		
		// 이전 저장된 설정값들을 복구
		Properties prop = new Properties();
		
		try {
			
			System.out.println(prop);
			
			//prop.load(new FileInputStream("setting.txt"));
			
			//System.out.println(prop);
			
			prop.loadFromXML(new FileInputStream("setting.xml"));
			System.out.println(prop);
			
		} catch (Exception e) {
			System.out.println("m2 : " + e.toString());
		}
		
	}

	private static void m1() {
		
		Properties prop = new Properties();
		
		// 프로그램 설정값
		// : 프로그램 종료 -> 세팅값 물리 저장 -> 프로그램 실행 -> 세팅값 읽기 -> 프로그램 적용
		
		prop.setProperty("path", "C:\\Util\\Run");
		prop.setProperty("language", "ko");
		prop.setProperty("autosave", "30");
		prop.setProperty("font-family", "나눔 고딕체");
		
		
		// 탐색
		System.out.println(prop);
		
		System.out.println(prop.getProperty("path"));
		
		
		// Enumeration > Iterator > ListIterator
		Enumeration e = prop.propertyNames();
		
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		// 저장
		try {
			
			//prop.store(new FileOutputStream("setting.ini"), "");
			prop.storeToXML(new FileOutputStream("setting.xml"), "");
			
			System.out.println("저장 완료");
			
		} catch (Exception e2) {
			System.out.println("m1 : " + e.toString());
		}
		
	}
	
}

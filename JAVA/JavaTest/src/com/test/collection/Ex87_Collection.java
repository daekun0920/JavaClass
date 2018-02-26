package com.test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Ex87_Collection {
	
	public static void main(String[] args) {
		
		// Ex87_Collection.java
		
		// 무난한 선택
		// List -> ArrayList
		// Set -> HashSet 
		// Map -> HashMap
		
		// Map 계열
		//   - HashMap
		//   - TreeMap -> TreeSet과 유사 구조 = Entry 노드를 가지는 트리구조 
		
		// F3 - 정의 
		ArrayList<String> list = new ArrayList<String>();
		
		User user = new User("홍길동", 100, 90);
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		
		
		TreeMap<String, String> tmap = new TreeMap<String, String>();
		
		tmap.put("one", "하나");
		tmap.put("two", "둘");
		tmap.put("three", "셋");
		tmap.put("zero", "영");
		
		
		System.out.println(tmap.size());
		
		System.out.println(tmap.get("two"));
		
		System.out.println(tmap.firstKey());
		System.out.println(tmap.lastKey());
		
		System.out.println(tmap.subMap("o", "z")); // o ~ z 전까지
		
		
		
	}
	
}

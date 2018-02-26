package com.test.collection;

import java.util.HashMap;

public class Ex68_HashMap {
	
	public static void main(String[] args) {
		
		// Ex68_HashMap.java
		
		// ArrayList
		//   - 요소 접근 -> 첨자(index) 사용
		//   - 첨자 : 정수(0이상)
		//   - 스칼라 배열
		//   - 일괄처리하기에 좋은구조, 하지만 들어있는 자료의 내용을 알기 어려움
		
		// HashMap
		//   - 요소 접근 -> 키(key) 사용
		//   - 키 : 숫자, 문자, 문자열(***).. 등 
		//   - 연관 배열, 사전 구조, Dictionary
		//   - 방에 첨자대신 각자의 이름(key)이 붙어있다
		//   - 키(Key)와 값(Value)으로 구성되어있다.
		//   - 들어있는 값의 내용을 알기 쉽지만 루프를 돌리지못한다.
		
		
		// HashMap map = new HashMap(); <- raw 타입(오래됨)
		HashMap<String, Integer> map = new HashMap<String, Integer>();
			//  방의 이름, 넣을 값
		
		// 요소 추가
		//       Key, Value
		map.put("국어", 100);
		map.put("영어", 90);
		map.put("수학", 80);
		
		// 요소 접근			  // Key
		System.out.println(map.get("국어"));
		
		HashMap<Integer, String> map2 = new HashMap<Integer, String>(); // HashMap 이 아닌 ArrayList 로 사용할 케이스이다.
		
		map2.put(1, "하나");
		map2.put(2, "둘");
		
		System.out.println(map2.get(1));
		
		HashMap<Boolean, String> map3 = new HashMap<Boolean, String>(); // 비효율적
		
		map3.put(true, "천사");
		map3.put(false, "악마");
		
		System.out.println(map3.get(true));
		
		// Key 는 자유도, 의미가 있게 지어야함 -> 99% 문자열(String)으로 짓는다. 
		
		
		System.out.println();
		
		// *** HashMap은 순서가 존재하지 않는다. ***
		
		// 1. 요소 추가
		map.put("과학", 100);
		map.put("윤리", 80);
		
		// 2. 요소 갯수
		System.out.println(map.size()); // size -> 추상 클래스 or 인터페이스로 만든 메소드(ArrayList에도 사용)
		
		// 3. 요소 접근
		System.out.println(map.get("국어"));
		System.out.println(map.get("도덕")); // null 
		
		// 4. 요소(Value) 수정 // 데이터를 집어넣을때와 같다.
		//   - HashMap의 key는 유일해야 한다. (절대로 중복 안됨)
 		map.put("과학", 90);   // 기존의 값을 덮어써버림 
		System.out.println(map.get("과학"));
		
		// 5. 요소 삭제
		map.remove("과학");
		System.out.println(map.size()); // 4 
		System.out.println(map.get("과학")); // null
		
		
		// 6. 요소 확인
		//   - ArrayList or 배열 -> contains
		System.out.println(map.containsKey("국어")); // HashMap map 에 "국어"라는 Key가 있는가?
		System.out.println(map.containsValue(100)); // 100점을 맞은 과목이 있는가? (100이라는 Value가 있는가?)
	
		// 7. 초기화
		map.clear();
		System.out.println(map.size());
		
		
		
	}	
}

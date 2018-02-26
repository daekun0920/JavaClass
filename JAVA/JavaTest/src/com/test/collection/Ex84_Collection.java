package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class Ex84_Collection {
	
	public static void main(String[] args) {
		
		// Ex84_Collection.java
		
		// enum, Enumeration : 열거형
		
		// Enumeration, Iterator, ListIterator : 탐색기(반복자)
		//   - 컬렉션의 요소에 접근하기 위한 인터페이스
		//   - Enumeration -> Iterator -> ListIterator (최신순) 
		
		//m1();
		m2();
	}

	private static void m2() {
		
		// Iterator -> ListIterator
		//   - Iterator : 단방향 -> 전진 커서
		//   - ListIterator : 양방향 -> 전진 + 후진 커서 (속도가 다소 느리다)
		//   - List 계열만 지원(Set 계열은 지원 안함 - 방번호 x)
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("빨강");
		list.add("주황");
		list.add("노랑");
		list.add("초록");
		list.add("파랑");
		list.add("남색");
		list.add("보라");
		
		Iterator<String> iter = list.iterator();
		ListIterator<String> liter = list.listIterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		while (liter.hasNext()) {
			System.out.println(liter.next());
		}
		System.out.println();
		
		// ListIterator 만의 기능 
		// liter.hasPrevious(); // 이전 방에 데이터가 있느냐
		// liter.previous();    // 이전 방으로 커서를 옮기고 그 데이터를 리턴한다
	
		while (liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
		
		
	}

	private static void m1() {
		
		// Iterator
		//   - 컬렉션 프레임워크에서 저장된 요소를 읽어오는(***) 방법을 표준화하기 위한 역할(인터페이스)
		//   - Collection의 하위 컬렉션들이 Iterator를 반환하는 메소드 제공 -> iterator() -> set.iterator()
		//   - List, Set에서 구현(Map에는 없음)
		//   - 읽기 전용으로 사용한다.
		
		// 1. boolean hasNext() : 다음 요소가 있는지 확인
		
		// 2. T next() : 다음 요소를 가져오기
		
		// 3. remove() : 다음 요소를 삭제하기 (잘 사용 안함)
		
		
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("귤");
		list.add("딸기");
		list.add("포도");
		list.add("바나나");
		
		// list 컬렉션을 'Iterator를 구현해서' 요소를 탐색
		Iterator<String> iter = list.iterator(); // 객체 생성시 cursor가 1번째 요소 전(BOF)을 가리키고있다.
		
		// System.out.println(iter.hasNext()); // true // cursor가 1번째 요소 전(BOF)을 가리키고있다.
		// System.out.println(iter.next()); 	// 사과 // cursor를 1칸 전진시킨다.(1번째 요소 리턴)
		
		// System.out.println(iter.hasNext()); // true (조건부로 많이 들어감)
		// System.out.println(iter.next());    // 귤 
		
		// 향상된 for문은 Iterator가 구현되어있는 컬렉션만 사용 가능하다 
		
		while (iter.hasNext()) {
			System.out.println(iter.next()); // 앞으로는가도 뒤로는 못간다. 전진가능 후진불가능(Stream과 똑같다)
		}
		
		// java.util.NoSuchElementException (다음 요소가 존재하지 않습니다.)
		// System.out.println(iter.next());
		
		
		// 부분 탐색x -> 전체 탐색에 용이 o 
		iter = list.iterator(); // 아까 커서 버리고 새 커서 생성 (커서 위치 초기화)
		
		iter.next();
		iter.next();
		iter.next();
		
		System.out.println(iter.next()); // 부분탐색에는 적합하지가 않다.
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		// Map -> 루프 X
		// 1. 방번호가 없어서... -> 일반 for문 사용 불가
		// 2. Iterator를 구현하지 않아서... -> 향상된 for문 사용 불가 
		
		Set<String> keys = map.keySet(); // 키만 담겨있는 배열을 리턴 (방의 번호가 없는 배열이다 리턴값 Set)
										 // 일반 for문은 돌릴수 없지만 Iterator가 구현되어있어서 향상된 for문은 돌릴수 있다
										 // Set 계열 
		
		Collection<String> values = map.values(); // 리턴값 Collection
		
		
		
		Iterator<String> iter2 = keys.iterator();
		
		while (iter2.hasNext()) {
			System.out.println(iter2.next()); // 집어넣은 순서대로 나오지는 않는다 
		}
		
		
		Iterator<String> iter3 = values.iterator();
		
		while (iter3.hasNext()) {
			System.out.println(iter3.next()); // 집어넣은 순서대로 나오지는 않는다 
		}
		
		
		
	}
	
}























package com.test.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex86_Collection {
	
	public static void main(String[] args) {
		
		// Ex86_Collection.java
		
		// TreeSet
		//   - Set : 중복값x, 순서x(-> 정렬X)  
		//   - 자동 정렬(데이터를 관리할 때 항상 정렬된 상태로 관리)
		//   - 트리구조(이진 트리 구조 -> 자식의 최대 갯수가 2개까지이다)
		//   - 정렬o + 검색, 범위 검색 용이(***)
		//   - 본인보다 큰 값을 가지는 자식은 우측에 붙인다.
		//   - 작은 값은 왼쪽에 붙인다.
		//m1();
		//m2();
		m3();
	}

	private static void m3() {
		
		// TreeSet<User> set = new TreeSet<User>();
		
		// 1. Comparator 사용해서 해결
//		TreeSet<User> set = new TreeSet<User>(new Comparator<User>() {
//			@Override
//			public int compare(User o1, User o2) {
//				return o1.getTotalPoint() - o2.getTotalPoint();
//			}
//			
//		});
		
		// 2. Comparable 사용해서 해결 (판단을 당하는 입장)
		TreeSet<User> set = new TreeSet<User>();
		
		
		// 복합타입이라서 TreeSet 내부에서 크기 비교가 되지않는다 -> 오류 발생 
		set.add(new User("가가가", 55, 19));
		set.add(new User("나나나", 35, 29));
		set.add(new User("다다다", 45, 69));
		set.add(new User("라라라", 53, 29));
		set.add(new User("마마마", 85, 49));
		set.add(new User("바바바", 64, 79));
		set.add(new User("사사사", 23, 59));
		set.add(new User("아아아", 74, 99));
		
		System.out.println(set);
		
		User u1 = new User("홍길동", 100, 100);
		User u2 = new User("아무개", 50, 50);
		
		System.out.println(u1.compareTo(u2));
		// System.out.println(u1 > u2);
		
			
	}

	private static void m2() {
		
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("다리");
		set.add("갑순이");
		set.add("나비");
		set.add("가방");
		set.add("나방");
		set.add("가다랭이");
		set.add("가위");
		set.add("다이소");
		set.add("나이테");
		set.add("가죽");
		set.add("강도");
		set.add("나이순");
		set.add("라면");
		set.add("강아지");
		set.add("라식");
		set.add("라디오");
		
		System.out.println(set);
		
		System.out.println(set.subSet("나", "라")); // 나부터 라 전까지 가져와라 (나 ~ 다)
		System.out.println(set.headSet("다")); // 처음부터 시작해서 여기 전까지 (가 ~ 나)
		System.out.println(set.tailSet("다")); // 다부터 끝까지 가져와라 (다 ~ )
		
		// Set -> iterator
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		iter = set.descendingIterator(); // 역순
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
	}

	private static void m1() {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for (int i = 0; i < 10; i++) {
			
			int num = (int)(Math.random() * 100) + 1; // 1 ~ 100
			set.add(num);
		}
		
		System.out.println(set);
		
	}
	
}

class User implements Comparable<User> {
	
	private String name;
	private int point;
	private int bonus;
	
	public User(String name, int point, int bonus) {
		this.name = name;
		this.point = point;
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", this.name, this.point + this.bonus);
	}
	
	public int getTotalPoint() {
		return this.point + this.bonus;
	}

	@Override
	public int compareTo(User user) {
		return user.getTotalPoint() - this.getTotalPoint();
	}
	
	
}

//class User {
//	
//	private String name;
//	private int point;
//	private int bonus;
//	
//	public User(String name, int point, int bonus) {
//		this.name = name;
//		this.point = point;
//		this.bonus = bonus;
//	}
//	
//	@Override
//	public String toString() {
//		return String.format("%s(%d)", this.name, this.point + this.bonus);
//	}
//	
//	public int getTotalPoint() {
//		return this.point + this.bonus;
//	}
//	
//	
//}

















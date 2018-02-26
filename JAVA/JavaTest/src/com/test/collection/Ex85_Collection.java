package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Ex85_Collection {
	
	public static void main(String[] args) {
		
		System.out.println((int)'∩');
		
		// Ex85_Collection.java
		
		// ArrayList, LinkedList, Queue, Stack -> List 계열
		
		// Set 계열
		//  - 순서가 없는 배열
		//  - 첨자가 없음(방번호가 없음)
		//  - 중복값을 가질 수 없다.
		
		// HashSet
		//  - Set 인터페이스 구현
		//  - 순서X, 중복값X
		
		//m1(); // 반드시
		//m2(); // 되도록
		m3(); // 추가
		System.out.println("홍길동20".hashCode()); 
		System.out.println("아무개25".hashCode());
		System.out.println("홍길동20".hashCode()); // 문자열이 같으면 해쉬코드도 같다.
	}

	private static void m3() {
		// 데이터
		Set<String> setA = new HashSet<String>();
		Set<String> setB = new HashSet<String>();
		
		// 결과
		Set<String> setHab = new HashSet<String>(); // 합집합
		Set<String> setGyo = new HashSet<String>(); // 교집합
		Set<String> setCha = new HashSet<String>(); // 차집합
		
		setA.add("빨강");
		setA.add("노랑");
		setA.add("파랑");
		setA.add("검정");
		setA.add("하양");
		
		setB.add("빨강");
		setB.add("노랑");
		setB.add("파랑");
		setB.add("주황");
		setB.add("보라");
		
		System.out.println("A = " + setA);
		System.out.println("B = " + setB);
		
		// 교집합
		Iterator<String> iter = setA.iterator();
		
		while (iter.hasNext()) {
			String color = iter.next();
			if (setB.contains(color)) {
				setGyo.add(color);
			}
		}
		
		System.out.println("A∩B = " + setGyo);
		
		
		// 차집합
		iter = setA.iterator();
		
		while (iter.hasNext()) {
			String color = iter.next();
			
			if(!setB.contains(color)) {
				setCha.add(color);
			}
		}
		
		System.out.println("A - B = " + setCha);
		
		
		// 합집합
		List<String> listHab = new ArrayList<String>(); // Set은 중복값 배제
		iter = setA.iterator();
		
		while (iter.hasNext()) {
			String color = iter.next();
			setHab.add(color);	
			listHab.add(color);
		}
		
		iter = setB.iterator();
		
		while (iter.hasNext()) {
			String color = iter.next();
			setHab.add(color);
			listHab.add(color);
		}
		
		System.out.println("A ∪ B = " + setHab);
		System.out.println("A ∪ B = " + listHab);
		
	}

	private static void m2() {
		
		// Set 성질 + 객체 성질
		
		// 단일값 Set
		//   - 중복값 배제
		Set<String> set1 = new HashSet<String>();
		
		set1.add("홍길동");
		set1.add("아무개");
		set1.add("홍길동"); // 중복값 배제
		
		System.out.println(set1);
		
		// 복합값(객체) Set
		Set<Person> set2 = new HashSet<Person>();
		
		set2.add(new Person("홍길동", 20));
		set2.add(new Person("아무개", 25));
		set2.add(new Person("홍길동", 20)); // 중복값 배제? -> 가능(각 객체 참조 주소값 비교라서)
		
		System.out.println(set2);
		
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("홍길동", 20);
		
		System.out.println(p1.equals(p2)); // false -> true
		System.out.println(p1 == p2);
		
	}

	private static void m1() {
		
		// ** 인터페이스를 구현한 클래스의 객체를 만들 때 참조변수는 인터페이스 변수로 만드는 것이 좋다.
		// HashSet<String> set = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		
		// ArrayList<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		
		
		// 요소 추가
		set.add("하나");
		set.add("둘");
		set.add("셋");
		set.add("넷");
		set.add("다섯");
		
		set.add("하나"); // X (중복된 데이터는 방번호가 없어서 추가하려 하면 아예 무시됨)
		
		System.out.println(set.size());
		
		// System.out.println(set);
		
		
		// 로또 번호 추출
		// 1. ArrayList
		// 2. HashSet
		
		Random rnd = new Random();
		
		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			
			int num = rnd.nextInt(45) + 1;
			
			// 로또 번호로서 유효한지? 기존의 숫자가 중첩되는지?
			boolean flag = true;
			
			for (int j = 0; j < nums1.size(); j++) {
				if (num == nums1.get(j)) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				nums1.add(num);
			} else {
				i--;
			}
		}
		
		// Collections.sort(nums1); // m1 (단일 타입 전용 => 객체의 배열에서는 사용하지 못함)
		
		nums1.sort(new Comparator<Integer>() { // m2 (객체의 배열의 정렬에 사용한다)

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
			
		});
		
		System.out.println(nums1);
		
		
		nums1.clear();
		
		// 위의 방법을 살짝 개량
		while (nums1.size() < 6) {
			
			int num = rnd.nextInt(45) + 1;
			
			boolean flag = true;
			for (int i = 0; i< nums1.size(); i++) {
				if (num == nums1.get(i)) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
			nums1.add(num);
			}
			
		}
		
		System.out.println(nums1);
		
		nums1.clear();
		
		// m3
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for (int i = 1; i <= 45; i++) {
			temp.add(i);
		}
		while (nums1.size() < 6) { // 번호 추출 			
			//int num = rnd.nextInt(45) + 1; // 중복값 발생
			
			int index = rnd.nextInt(temp.size());
			int num = temp.get(index);
			temp.remove(index);
			
			nums1.add(num);
		}
		
		System.out.println(nums1);
		
		
		
		// HashSet (중복값 존재 불가)
		HashSet<Integer> nums2 = new HashSet<Integer>();
		
		while (nums2.size() < 6) {
			
			int num = rnd.nextInt(45) + 1;
			nums2.add(num); // 중복값 배제 
			
		}
		
		// Collections.sort(nums2); -> Set 계열은 정렬이 불가능하다 -> List 타입으로 변환 or 순수배열로 변환
		
		
		System.out.println(nums2);
		
		// Set -> List 변환 (생성자에 대입)
		List<Integer> copy = new ArrayList<Integer>(nums2);
		
		Collections.sort(copy);
		System.out.println(copy);
		
		
	}
		
}

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", this.name, this.age);
	}
	
	// 객체의 비교는 주소값을 가지고 한다.(= 해시코드값 비교)
	//   -> 개량(재정의) 가능 -> 개발자가 의도하는 비교를 할 수 있도록...
	// 1. hashCode() 재정의
	// 2. equals() 재정의 
	
	@Override
	public int hashCode() { // 메모리 주소값

		// p1 -> "홍길동" + 20 -> "홍길동20" -> 100
		// p2 -> "아무개" + 25 -> "아무개25" -> 200
		// p3 -> "홍길동" + 20 -> "홍길동20" -> 100
		
		return (this.name + this.age).hashCode(); // 객체의 값 주소  
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Person) {
			Person p = (Person)obj; // 다운캐스팅
			
			return this.name.equals(p.name)
					&& this.age == p.age; // 원자값 비교 
					
		}
		
		
		return false;
	}
	
}
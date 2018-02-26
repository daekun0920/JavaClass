package com.test.collection;

import java.util.ArrayList;

public class Ex67_ArrayList {
	
	public static void main(String[] args) {
		
		// Ex67_ArrayList.java
		
			// 컬렉션, Collection
			//   - 배열의 업그레이드 버전
			//   - 배열을 사용 목적에 맞게 특화시켜 다양한 형태로 가공(=> 자료구조)
			//   - 길이 가변(늘리거나 줄이는게 가능)
			//   - 내부 자료형 -> Object형 
			
		
			// ArrayList 클래스
			//   - 사용 빈도가 가장 높음.
			//   - 순수 배열과 모습이 가장 비슷함
			//   - 첨자(index)를 사용해서 요소(Element)를 관리
			
		//m1();
		//m2();
		m3();
	} // main
	
	
	
	private static void m3() {
		
		ArrayList<String> list = new ArrayList<String>();
		
		// 1. 요소 추가하기
		//   - add()
		//   - 배열의 맨 끝에 추가하기(append)
		list.add("홍길동");
		list.add("아무개");
		list.add("테스트");
		list.add("하하하");
		
		// 2. 요소 몇개? (length와 같음) -> 가변이므로 기억하기 힘드니까 
		//   - size()
		System.out.println(list.size());   // 4
		
		// 3. 요소 접근 
		//   - get()
		System.out.println(list.get(0));
		System.out.println(list.get(3));
		System.out.println(list.get(list.size() - 1));
		// System.out.println(list.get(4)); // 인덱스 오류
		
		
		// 4. 요소 수정
		// list[0] = "김길동";
		// list.add("김길동"); -> append, 새로운 요소 추가 // 리턴 값(Boolean)이 존재 (데이터 추가 성공여부)
						
					
		String temp = list.set(0, "이길동"); // 0번째 요소를 "이길동"으로 수정 // 요소 수정 // 리턴 값(String)이 존재 
		
		System.out.println(list.get(0));
		System.out.println(temp); // 수정되기 바로 전값을 리턴해줌 
		
		// 5. 요소 삭제 
		//   - 순수 배열은 방삭제가 불가능
		//   - 컬렉션은 방삭제 가능
		
		System.out.println();
		
		// 향상된 for문
		for (String name : list) {
			System.out.println(name);
		}
		
		list.remove(2); // 방삭제(값과같이)
		System.out.println(list.size());
		
		for (String name : list) {
			System.out.println(name);
		}
		
		// 쓰기, 읽기, 수정, 삭제
		//   - 데이터를 조작하는 기본 행동
		//   - CRUD(Create, Read, Update, Delete)
		
		// 삭제할때 주의할점!!!!!!!!!!!!!!!!!!!@#@!#@!#!@$!@#!@#@!#@!#@!
		System.out.println(list.get(2));
		
		list.remove(0); // 이길동 탈퇴
		
		System.out.println(list.get(2)); // 방 삭제시 순서가 바뀐다 (방이 한칸씩 Shift 된다) // 후 방번호가 앞으로 밀린다
		
		// 6. 요소 추가
		//   - 삽입, Insert
		System.out.println();
		
		for (String name : list) {
			System.out.println(name);
		}
		
		list.add(1, "후후후"); // 1번째 방에다 "후후후"를 삽입한다 // 이 후 방번호가 뒤로 밀린다.
		
		System.out.println();
		
		for (String name : list) {
			System.out.println(name);
		}
		
		// 7. 초기화
		//   - 모든 요소 삭제
		list.clear();
		System.out.println(list.size()); // 한꺼번에 모두 지우기 
		
		// 8. 배열이 비었는지 물어보기
		System.out.println(list.size() == 0);
		// 둘다 같은 기능 
		System.out.println(list.isEmpty());
		
		
		// 9. 나머지..
		list.add("가가가");
		list.add("나나나");
		list.add("다다다");
		list.add("라라라");
		
		// String == char[] == 배열 == 컬렉션
		System.out.println(list.indexOf("나나나"));
		System.out.println(list.contains("다다다"));
		System.out.println(list.lastIndexOf("라라라"));
			
	
	}
	



	private static void m2() {
		
		
		// raw type : 옛날꺼... 향후 사라질 기능이 있는 문법.. -> 대체 자료형이 있음
		ArrayList list1 = new ArrayList();
		list1.add(100);
		System.out.println((int)list1.get(0) + 100);
//		list1.add("홍길동");
//		System.out.println(list1.get(1) + "님");
//		
//		for (int i = 0; i < 2; i++) {
//			System.out.println((int)list1.get(i) + 100); 	// 일괄처리할때 오브젝트 클래스 배열안에 타입이 다른값들이 들어있으면 곤란해진다.
//		} 
//		
//	
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(100); 
		System.out.println(list2.get(0) + 100);
		
	}
	private static void m1() {
		// 배열 생성
		//   - 타입 명시(int)
		//   - 길이 명시(3)
		int[] nums1 = new int[3];
	
		// 초기화 + 요소 접근 -> index 사용
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;
		
		// 탐색
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}
		//=====================================//
		// ArrayList 생성
		//   - 타입 없음(Object 배열)
		//   - 길이도 없음(가변이라서...)
		ArrayList nums2 = new ArrayList();
		
		// 초기화
		nums2.add(100);
		nums2.add(200);	// 넣을때는 방번호가 없다.
		nums2.add(300); // append 한다 (끝 열에 붙임)
		
		// 탐색
		for (int i = 0; i < 3; i++) {
			System.out.println((int)nums2.get(i) * 2); // 꺼낼때는 방번호가 있다 .
		}												// 산술 연산을 위해 다운캐스팅.
		
	}
	
} // Ex67

//class ArrayList<T> {
//	
//	public void add(T arg) {
//		
//	}
//	
//}








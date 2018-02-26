package com.test.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex70_Collection {
	//*** 프로젝트 회의때 적었던 메모나 동영상을 포트폴리오에 넣기 (중간과정 기록으로 남기기)***// 
	// 정적으로 바꿔줌
	private static Scanner scan; // = new Scanner(System.in);
	private static ArrayList<Member> list; // 회원 정보 집합(*******)
	
	static { // static 생성자 (초기화)
		scan = new Scanner(System.in);
		list = new ArrayList<Member>();
	}
	
	
	
	// 정적 멤버(static)에서는 객체 멤버가 접근할수없다 
	public static void main(String[] args) {
		
		// Ex70_Collection.java
		
		// 회원 정보 관리 프로그램 -> 프로그램 적용..
		
		// 1. 회원 정보
		//   - 이름
		//   - 나이
		//   - 주소
		//   - 연락처
		
		// 2. 기능
		//   - 회원 정보 추가
		//   - 회원 정보 보기
		//   - 회원 정보 검색
		//   - 회원 정보 삭제
		
		// 3. 추가
		//   - 회원 정보 -> 어떤 형태로? -> 클래스(o) vs HashMap
		//   - 회원들 -> 회원 정보의 집합 ? -> 배열(학생수가 늘거나 줄지않을때) vs ArrrayList(O // 가변 길이) vs HashMap
		
		// 4. 골격 -> (메뉴 -> 선택 -> 기능 실행 -> 완료) x N 반복 
		
		Member m = new Member("홍길동", "20", "서울시 강남구 역삼동", "010-1111-2222");
		
		// m : 회원 1명
		
//		System.out.println(m.getName());
//		System.out.println(m.getAddress());
//		System.out.println(m.getAge());
//		System.out.println(m.getTel());
//		
//		System.out.println(m);
		
		dummy();
		
		System.out.println("프로그램을 시작합니다.");
		
		boolean loop = true;
		
		// Scanner scan = new Scanner(System.in);
		
		while (loop) {
			
			// 메뉴 > 선택 > 해당 업무 실행 > 메뉴 > 선택 ... 
			System.out.println("==========================");
			System.out.println("회원 관리 프로그램");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 목록");
			System.out.println("3. 회원 검색");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			System.out.println("6. 회원 검색(나이)"); // 10대, 20대, 30대 // 10 ~ 19,  20 ~ 29, 30 ~ 39
			System.out.println("7. 회원 검색(주소)");
			System.out.println("8. 회원 검색(연락처)");
			System.out.println("==========================");
			System.out.print("선택(번호입력) : ");
			
			String sel = scan.nextLine();
			
			// 각 조건문이 길어질테니 메소드로 빼주는것이 좋다 
			if (sel.equals("1")) {
				addMember();
			} else if (sel.equals("2")) {
				listMember();
			} else if (sel.equals("3")) {
				searchMember();
			} else if (sel.equals("4")) {
				deleteMember();
			} else if (sel.equals("5")) {
				loop = false; // 다른 반복문이 있을때를 대비해서 break가 아닌 boolean 사용
			} else if (sel.equals("6")) {
				searchAge();
			} else if (sel.equals("7")) {
				searchAddress();
			} else if (sel.equals("8")) {
				searchContact();
			} // if
		
		} // while 
		
		System.out.println("프로그램을 종료합니다.");
		
		
	} // main

	private static void searchAge() {
		ArrayList<Member> temp = new ArrayList<Member>();
		System.out.println("[회원 검색(나이)]");
		
		System.out.print("검색어(나잇대) : ");
		String ageSearch = scan.nextLine();
		
		if (ageSearch.contains("1")) { // contains : 1, 10, 10대 를 넣어도 모두 출력됨 
			for (int i = 0; i < list.size(); i++) {
				Member m = list.get(i);
				int age = Integer.parseInt(m.getAge());
				if (10 <= age && 19 >= age) {
					temp.add(m);
				}
			}
		} else if (ageSearch.contains("2")) {
			for (int i = 0; i < list.size(); i++) {
				Member m = list.get(i);
				int age = Integer.parseInt(m.getAge());
				if (20 <= age && 29 >= age) {
					temp.add(m);
				}
			}
		} else if (ageSearch.contains("3")) {
			for (int i = 0; i < list.size(); i++) {
				Member m = list.get(i);
				int age = Integer.parseInt(m.getAge());
				if (30 <= age && 39 >= age) {
					temp.add(m);
				}
			}
		} else if (ageSearch.contains("4")) {
			for (int i = 0; i < list.size(); i++) {
				Member m = list.get(i);
				int age = Integer.parseInt(m.getAge());
				if (40 <= age && 49 >= age) {
					temp.add(m);
				}
			}
		} else if (ageSearch.contains("5")) {
			for (int i = 0; i < list.size(); i++) {
				Member m = list.get(i);
				int age = Integer.parseInt(m.getAge());
				if (50 <= age && 59 >= age) {
					temp.add(m);
				}
			}
		}
		
		if (temp.size() > 0) {
			
			System.out.printf("총 %d명의 회원이 검색되었습니다.\n", 
							  temp.size());
			
			for (Member m : temp) {
				System.out.println("이름: " + m.getName());
				System.out.println("나이: " + m.getAge());
				System.out.println("연락처: " + m.getTel());
				System.out.println("주소: " + m.getAddress());
				System.out.println();
			}
		}
		
		pause();
	}

	private static void searchAddress() {
		ArrayList<Member> temp = new ArrayList<Member>();
		System.out.println("[회원 검색(주소)]");
		
		System.out.println("검색어(주소) : ");
		String addressSearch = scan.nextLine();
		
		for (Member m : list) {
			if (m.getAddress().contains(addressSearch)) {
				temp.add(m);
				
			}
		}
		if (temp.size() > 0) {
			System.out.printf("총 %d명의 회원이 검색되었습니다.", 
							  temp.size());
			
			for (Member m : temp) {
				System.out.println("이름 : " + m.getName());
				System.out.println("나이 : " + m.getAge());
				System.out.println("연락처 : " + m.getTel());
				System.out.println("주소 : " + m.getAddress());
				System.out.println();
			}
		}
		
		
	}

	private static void searchContact() {
		
	}

	private static void dummy() {
		Random rnd = new Random();
		
		// 테스트용 데이터 
		String[] name1 = {"김", "이", "박", "정", "최", "동", "근", "채", "은", "창", "형", "대", "건", "준", "필", "미", "진"};
		String[] address1 = {"서울시", "부산시", "인천시", "대전시", "광주시"};
		String[] address2 = {"강동구", "강남구", "강서구", "강북구", "중구"};
		
		for (int i = 0; i < 10; i++) {
			String name = name1[rnd.nextInt(name1.length)] 
						+ name1[rnd.nextInt(name1.length)] 
						+ name1[rnd.nextInt(name1.length)] ; 
			String age = rnd.nextInt(40) + 20 + "";
			
			String address = address1[rnd.nextInt(address1.length)] 
					  + " " + address2[rnd.nextInt(address1.length)];
			String tel = "010-" + (rnd.nextInt(9000) + 1000) 		// 10000 으로 할경우 4자릿수가 아닌수가 나올 경우의수가 있기때문에 (0~ 999) 9000 (0 ~ 8999) 에 
								+ "-" + (rnd.nextInt(9000) + 1000); // 1000을 넣어서 (0 + (1000) ~ 8999 + (1000))로 1000 ~ 9999 를 만든다 
			
			Member m = new Member(name, age, address, tel);
			
			list.add(m);
		}
	}

	private static void addMember() {
		
		// 보기 쉽게 변수 미리 선언 
		String name = "";
		String age = "";
		String address = "";
		String tel = "";
		
		// 회원 정보 추가
		System.out.println("회원 정보 추가");
		
		
		System.out.print("이름 : ");
		name = scan.nextLine();
		
		System.out.print("나이 : ");
		age = scan.nextLine();
		
		System.out.print("주소 : ");
		address = scan.nextLine();
		
		System.out.print("연락처 : ");
		tel = scan.nextLine();
		
		// 회원 정보 수집 > 회원 정보 1개 단위 > Member 객체
		
		// 지역변수라서 메소드 종료시 죽는다 
		Member m = new Member(name, age, address, tel);
		
		// 회원 정보 > 리스트 추가
		list.add(m);
		
		pause(); // 일시중지 
		
	}

	private static void pause() {
		System.out.println("계속하시려면 엔터를 입력하세요.");
		scan.nextLine();
		
	}

	private static void listMember() {
		
		// 회원 정보 목록 출력하기
		System.out.println("[회원 목록]");
		
		list();
		
		pause(); // 정적 멤버(static) 들은 대부분 italic 으로 설정되어있다 
		
		
	}

	private static void list() {
		// 테이블 헤더 출력 
		System.out.println("[이름]\t[나이]\t[연락처]\t[주소]");
		
		// list -> Member -> 출력 
		for (Member m : list) {
			
			System.out.printf("%s\t%6s\t%s\t%s\t\n", m.getName(), m.getAge(), m.getTel(), m.getAddress());
			
		} // for 
	}

	private static void searchMember() {
		// 검색된 회원들만 임시 저장하기 위한 공간
		ArrayList<Member> temp = new ArrayList<Member>();
		
		
		
		// 회원 정보 검색
		System.out.println("[회원 검색]");
		
		// 검색 대상?
		System.out.print("검색어(이름) : ");
		
		String search = scan.nextLine();
		
		// 향상된 for 문 
		for (Member m : list) {
			
			// 1. 동등 검색 : 정확도 높음, 검색률 낮음 // 홍길동 -> 홍길동
			// 2. 포함 검색 : 정확도 낮음, 검색률 높음 // 길동 -> 홍길동
			
			// if (m.getName().equals(search)) {
			// if (m.getName().indexOf(search) > -1) {
			if (m.getName().contains(search)) {
				// 발견 -> 출력
//				System.out.println("이름: " + m.getName());
//				System.out.println("나이: " + m.getAge());
//				System.out.println("연락처: " + m.getTel());
//				System.out.println("주소: " + m.getAddress());
//				System.out.println();
				
				
				// 이곳에 검색된 회원들을 따로 저장할 집합 필요
				temp.add(m); // 이동 X  주소값 복사 O 
				
			} // if
			
		} // for
		
		// 출력
		if (temp.size() > 0) {
			
			System.out.printf("총 %d명의 회원이 검색되었습니다.\n", 
								temp.size());
			
			for (Member m : temp) {
				System.out.println("이름: " + m.getName());
				System.out.println("나이: " + m.getAge());
				System.out.println("연락처: " + m.getTel());
				System.out.println("주소: " + m.getAddress());
				System.out.println();
			}
			
		} else {
			System.out.println("검색된 회원이 없습니다.");
		}
		
		pause();
		
	} // searchMember
	
	

	private static void deleteMember() {
		
		// 회원 정보 삭제
		System.out.println("[회원 삭제]");
		
		// 목록 출력
		list();
		
		System.out.print("삭제할 회원(이름) : ");
		String name = scan.nextLine();
		
		// 검색 
		// for 문 
		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
			
			if (m.getName().equals(name)) {
				list.remove(i);
				break;
			}
			
		}	
		
		// 향상된 for문
		for (Member m : list) {
			if (m.getName().equals(name)) {
				list.remove(m);
				break;
			}
		}
		
		//list.remove(m)
		pause();
		
	}
	
} // Ex70
 
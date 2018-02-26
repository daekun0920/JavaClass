package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex76_Member {
	
	private static Scanner scan; // 모든 메소드에서 사용 
	private static final String FILEPATH = "member.dat"; // 파일 경로 상수 지정(바꾸지 못하게) 
	
	
	static {  // 정적 생성자 > 초기화
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		
//		try {
//			
//			// 드라이브명으로 시작 경로 : 절대 경로 
//			// "." 으로 시작 경로 : 상대 경로 (나를 중심으로 표현)
//			// - "." : 현재 프로그램이 실행 중인 디렉토리 (최상위 폴더 JavaTest에 생성, 다른사람에게 배포시 좋음, "." 생략 가능)
//			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\src\\member.dat", true));
//			// .\\member.txt == member.txt 둘이 같다 ( . 이 생략)
//			// .\\src\\member.txt 처럼 하위 폴더에도 생성 가능 
//		} catch (Exception e) {
//			System.out.println("main : " + e.toString());
//		}
		
		
		// Ex76_Member.java
		
		// 회원 정보 관리 프로그램
		//  : 컬렉션 + 파일입출력
		
		// 추가, 목록, 삭제
		
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("=======================");
			System.out.println("    회원 정보 관리");
			System.out.println("=======================");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 목록");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 종료");
			System.out.print("선택 : ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) addMember();
			else if (sel.equals("2")) listMember();
			else if (sel.equals("3")) deleteMember();
			else loop = false; // 메뉴 탈출
			
			
			
		}
		
		System.out.println("프로그램 종료");
		
	}

	private static void addMember() {
		
		System.out.println("[회원 추가]");
		
		String name = "";
		String age = "";
		String address = "";
		String tel = "";
		
		System.out.print("이름 : ");
		name = scan.nextLine();
		
		System.out.print("나이 : ");
		age = scan.nextLine();
		
		System.out.print("주소 : ");
		address = scan.nextLine();
		
		System.out.print("전화 : ");
		tel = scan.nextLine();
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true));
			
			// 파일 기록 
			// - 1명 = 1줄 
			// 홍길동,20,서울시,010-1111-2222
			
			writer.write(String.format("%s,%s,%s,%s"
									   , name, age, address, tel));
			writer.newLine(); // 엔터 
			
			writer.close();
			
			System.out.println("회원 추가 완료");
			
		} catch (Exception e) {
			System.out.println("addMember : " + e.toString());
		}
		
	}

	private static void listMember() {
		
		System.out.println("[회원 목록]");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				// 홍길동,19,서울시,010-1111-2222
				
				// split();		  		// 나누고 싶은 구분자
				String[] result = line.split(",");
				
				System.out.println("이름 : " + result[0]);
				System.out.println("나이 : " + result[1]);
				System.out.println("사는곳 : " + result[2]);
				System.out.println("전화 : " + result[3]);
				System.out.println();
			}
			
			reader.close();
			
			System.out.println("회원 목록 출력 완료");
			
		} catch (Exception e) {
			System.out.println("addMember : " + e.toString());
		}
		
		
	}

	private static void deleteMember() {
		
		// 파일 입출력 > 스트림은 수정 & 삭제 작업이 존재하지 않는다 > 새로 생성 + 데이터 추가 & 데이터 읽기
		// 우리가 메모장에 하는 삭제 & 수정후 저장은 삭제 & 수정한것이 아니라 새로 바뀐 형태로 기존의 것을 덮어쓴것이다.
		
		// 회원 삭제
		System.out.println("[회원 삭제]");
		
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
			
			String temp = ""; // 이곳에 기존의 내용을 옮겨놓기
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				// 삭제하려는 회원만 빼고 
				if (!line.startsWith(name)) { // 해당 이름으로 시작하는가?
					temp += line + "\r\n";
				}
			}
			
			System.out.println(temp);
			
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH)); // Create mode (덮어쓰기)
			
			writer.write(temp); // 삭제할 회원만 빠진 나머지 회원정보들 
			
			writer.close();
			
			System.out.println("회원 정보 삭제");
			
			
		} catch (Exception e) {
			System.out.println("deleteMember : " + e.toString());
		}
		
		
		
	}
	
}














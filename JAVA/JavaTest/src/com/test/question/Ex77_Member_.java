package com.test.question;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.test.io.Member;

public class Ex77_Member_ {
	
	private static Scanner scan;
	private static final String FILEPATH = "member.dat"; // 파일 경로 상수 지정(바꾸지 못하게) 
	private static ArrayList<Member> list;
	
	static {
		list = new ArrayList<Member>(); // Ex70 예제;
		scan = new Scanner(System.in);
	}
	public static void main(String[] args) {

	
	// Ex77_Member.java *****
	
	// Ex76_Member의 단점
	// 1. 파일 입출력이 너무 잦음. > 고비용
	// 2. 스트림은 사용하기가 불편
			
			// 해결법 
			// 특정 클래스를 만들고 객체화 시켜서 각 사람 관리 
			// 회원 정보 관리 프로그램
			//  : 컬렉션 + 파일입출력
			
			// 추가, 목록, 삭제
			
			load();
		
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
			
			
			save();
			
		}

		private static void save() { // 마지막에 덮어쓰기 (프로그램 종료시 새 내용으로)
			
			// 메모리 -> member.dat 옮기기
			try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH));
				
				// ArrayList -> Member 1개 -> member.dat -> 1줄
				
				for (Member m : list) {
					
					String line = String.format("%s,%s,%s,%s"
												, m.getName()
												, m.getAge()
												, m.getAddress()
												, m.getTel());	
					
					writer.write(line); // 메모리 > 텍스트 파일 복사
					writer.newLine();
					
				}
				
				writer.close();
				
			} catch (Exception e) {
				System.out.println("save : " + e.toString());
			}
			
		}

		private static void load() {
			// member.dat -> 메모리에 옮기기
			// 미리 읽어놓겠다  (복사본을 만들어서 마지막에 붙여넣겠다)
			try {
				
				BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
				
				String line = "";
				
				while ((line = reader.readLine()) != null) {
					// 텍스트 1줄 = 1명 회원 = Member 객체 1개 
					String[] temp = line.split(",");
					
					Member m = new Member();
					m.setName(temp[0]);
					m.setAge(temp[1]);
					m.setAddress(temp[2]);
					m.setTel(temp[3]);
					
					list.add(m);
				}
				reader.close();
			} catch (Exception e) {
				System.out.println("load : " + e.toString());
			}
			
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
			
			// 파일 쓰기 대신 > Member 객체를 ArrayList에 추가하기
			Member m = new Member();
			m.setName(name);
			m.setAge(age);
			m.setAddress(address);
			m.setTel(tel);
			
			list.add(m); // 회원 목록에 새 회원 추가하기 
			
			
			
			
		}

		private static void listMember() {
			
			System.out.println("[회원 목록]");
			
			for (Member m : list) {
				System.out.println("이름 : " + m.getName());
				System.out.println("나이 : " + m.getAge());
				System.out.println("주소 : " + m.getAddress());
				System.out.println("전화 : " + m.getTel() + "\n");
			}
			
			
		}

		private static void deleteMember() {
			
			// 파일 입출력 > 스트림은 수정 & 삭제 작업이 존재하지 않는다 > 새로 생성 + 데이터 추가 & 데이터 읽기
			// 우리가 메모장에 하는 삭제 & 수정후 저장은 삭제 & 수정한것이 아니라 새로 바뀐 형태로 기존의 것을 덮어쓴것이다.
			
			// 회원 삭제
			System.out.println("[회원 삭제]");
			
			System.out.print("이름 : ");
			String name = scan.nextLine();
			
			for (Member m : list) {
				if (m.getName().equals(name)) {
					list.remove(m);
				}
			}
			
		}
}

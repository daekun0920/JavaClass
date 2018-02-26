package com.test.mvc.member;

import java.util.Scanner;

import com.test.mvc.member.model.MemberDAO;
import com.test.mvc.member.model.MemberDTO;
import com.test.mvc.member.view.MemberView;
import com.test.mvc.memo.auth.Auth;

public class MemberClass {
	
	private MemberDAO dao;
	private MemberView view;
	private Auth auth;
	private Scanner scan;
	
	public MemberClass () {
		dao = new MemberDAO();
		view = new MemberView();
		auth = new Auth();
		scan = new Scanner(System.in);
	}

	public void start() {
		
		boolean loop = true;
		
		while (loop) {
			view.menu();
			int sel = scan.nextInt();
			scan.skip("\r\n"); // 해당 스캐너가 나중에 쓰일 소지가 있어 버리고 가기 
			switch(sel) {
				case 1 :
					if(!Auth.isAuth)
					add(); 
					break;
				case 2 :
					if (Auth.isAuth)
					del(); 
					auth.logout(); // **
					break;
				case 3 : 
					if(!Auth.isAuth)
					auth.login(); 
					break;
				case 4 : 
					if (Auth.isAuth)
					auth.logout(); 
					break;
				default : 
					loop = false;
			}
		}
	}

	
	private void del() {
		
		// 회원 탈퇴
		// 1. DELETE
		//  a. tbl_memo -> 게시물 삭제
		//	b. tbl_member -> 회원 삭제 
		// 2. UPDATE
		//  a. tbl_member -> 회원 삭제 상태로 변경
		
		System.out.println("[회원 탈퇴]");
		
		System.out.print("*** 탈퇴를 하면 작성하신 모든 게시물이 사라집니다.\n 계속 진행하시겠습니까? (Yes / No) : ");
		if (scan.nextLine().equals("Yes")) {
			if (dao.del(Auth.mseq) == 1) {
				System.out.println("*** 탈퇴 성공!!!");
			} else {
				System.out.println("*** 탈퇴 실패 :(");
			}
		} else {
			System.out.println("*** 탈퇴 취소");
		}
	}

	private void add() {
		view.header("회원 가입");
		System.out.println("이름 : ");
		String name = scan.nextLine();
		
		System.out.println("나이 : ");
		String age = scan.nextLine();
		
		System.out.println("전화 : ");
		String tel = scan.nextLine();
		
		System.out.println("이메일 : ");
		String email = scan.nextLine();
		
		System.out.println("비밀번호 : ");
		String pw = scan.nextLine();
		
		// 데이터 확보 -> MemberDAO에게 위임(DB Insert) 
		// dao.add(name, age, tel, email, pw);
		MemberDTO dto = new MemberDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setTel(tel);
		dto.setEmail(email);
		dto.setPw(pw);
		
		
		if (dao.add(dto) == 1) {
			view.result("성공했습니다.");
		} else {
			view.result("실패했습니다.");
		}
		
	} // MemberClass
	
}

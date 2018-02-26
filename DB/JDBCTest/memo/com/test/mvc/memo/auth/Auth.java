package com.test.mvc.memo.auth;

import java.util.Scanner;

import com.test.mvc.member.model.MemberDAO;
import com.test.mvc.member.model.MemberDTO;

public class Auth {
	
	private MemberDAO dao;
	public static boolean isAuth = false;
	public static String mseq;
	
	public Auth() {
		dao = new MemberDAO();
	}
	
	// MemberClass에서 호출
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[회원 로그인]");
		
		System.out.print("이메일 : ");
		String email = scan.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		MemberDTO dto = new MemberDTO();
		dto.setEmail(email);
		dto.setPw(pw);
		
		
		if (dao.auth(dto) == 1) {
			// 성공
			Auth.isAuth = true;
			Auth.mseq = dao.getMseq(dto);
			System.out.println("*** 로그인 성공");
		} else {
			// 실패
			Auth.isAuth = false;
			System.out.println("*** 로그인 실패");
		}
		
	}

	public void logout() {
		
		System.out.println("[회원 로그아웃]");
		
		// 로그아웃
		Auth.isAuth = false;
		Auth.mseq = null;
		
		System.out.println("*** 로그아웃 생공~~~");
		
	}

}

package com.test.mvc.memo;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.mvc.memo.auth.Auth;
import com.test.mvc.memo.model.MemoDAO;
import com.test.mvc.memo.model.MemoDTO;
import com.test.mvc.memo.view.MemoView;

import oracle.net.ns.DataDescriptorPacket;

public class MemoClass {
	
	private MemoDAO dao;
	private MemoView view;
	private Scanner scan;
	
	public MemoClass() {
		dao = new MemoDAO();
		view = new MemoView();
		scan = new Scanner(System.in);
	}

	public void start() {
		
		boolean loop = true;
		
		while (loop) {
			view.menu();
			int input = scan.nextInt();
			scan.skip("\r\n");
			switch (input) {
				case 1 : add(); break;
				case 2 : list(); break;
				case 3 : del(); break;
				case 4 : search(); break;
				default : loop = false; break;
			}
		}
	}
//	public static void main(String[] args) {
//		Auth.isAuth = true;
//		Auth.mseq = "2";
//		
//		MemoClass memo = new MemoClass();
//		//memo.add();
//		
//		
//		//memo.list();
//		//memo.del();
//		memo.search();
//		
//	}

	private void add() {
		
		// 메모 작성
		if (!Auth.isAuth) {
			System.out.println("*** 회원 전용 메뉴입니다.");
			return;
		}
		
		System.out.println("[메모 작성]");
		
		System.out.print("제목 : ");
		String subject = scan.nextLine();
		
		System.out.print("내용 : ");
		String content = scan.nextLine();
		
		// 메모 쓰기 위임 -> DAO
		MemoDTO dto = new MemoDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setMseq(Auth.mseq);
		
		if (dao.add(dto) == 1) {
			System.out.println("*** 메모 쓰기 성공");
		} else {
			System.out.println("*** 메모 쓰기 실패");
		}
		
	}

	private void list() {
		
		// *** 메모 목록 보기
		// ResultSet rs -> ?
		ArrayList<MemoDTO> list = dao.list("");
		
		// 테이블 하나당 DTO 1개 업무당 DAO 1개 
		// 테이블 조인하면 조인한 테이블 DTO도 추가 
		//System.out.println(list.size());
		
		System.out.println("(번호)\t(제목)\t(내용)\t(작성자)\t(작성시간)");
		
		for (MemoDTO dto : list) {
			System.out.printf("%s\t%s\t%s\t%s\t%s\n",
							  dto.getSeq(),
							  dto.getSubject(),
							  dto.getContent(),
							  dto.getMname(),
							  dto.getRegdate());
		}
		
		System.out.println("읽기 성공!");
	}

	private void del() {
		
		// 메모 삭제
		System.out.println("[메모 삭제]");
		
		System.out.println("번호 입력 : ");
		String seq = scan.nextLine();
		
		// 메모 작성자 = 로그인 회원
		if (dao.getMseq(seq).equals(Auth.mseq)) {
			dao.del(seq);
			System.out.println("*** 메모 삭제 성공");
		} else {
			System.out.println("*** 메모 삭제 실패");
		}
	}
	
	// 메모 검색 
	private void search() {
		if (!Auth.isAuth) {
			System.out.println("*** 회원 전용 메뉴입니다.");
			return;
		}
		System.out.println("[메모 검색]");
		System.out.println("검색어 : ");
		
		ArrayList<MemoDTO> list = dao.list(scan.nextLine());
				
				if (list.size() > 0) {
				System.out.println("(번호)\t(제목)\t(내용)\t(작성자)\t(작성시간)");
				
					for (MemoDTO dto : list) {
						System.out.printf("%s\t%s\t%s\t%s\t%s\n",
										  dto.getSeq(),
										  dto.getSubject(),
										  dto.getContent(),
										  dto.getMname(),
										  dto.getRegdate());
					}
				} else {
					System.out.println("*** 검색 결과 없어 ㅋㅋ");
				}
				System.out.println("읽기 성공!");
		
	}
	
}

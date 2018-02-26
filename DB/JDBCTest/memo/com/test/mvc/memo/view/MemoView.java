package com.test.mvc.memo.view;

public class MemoView {

	public void menu() {
		System.out.println("==================");
		System.out.println("메모");
		System.out.println("==================");
		System.out.println("1. 메모 쓰기(회원 전용)");
		System.out.println("2. 메모 읽기");
		System.out.println("3. 메모 삭제(작성자 전용)");
		System.out.println("4. 메모 검색(회원 전용)");
		System.out.println("5. 상위 메뉴로");
		System.out.print("선택 : ");
	}

}

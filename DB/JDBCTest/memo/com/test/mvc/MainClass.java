package com.test.mvc;

import java.util.Scanner;

import com.test.mvc.member.MemberClass;
import com.test.mvc.memo.MemoClass;
import com.test.mvc.view.MainView;

public class MainClass {
	public static void main(String[] args) {
		
		MemberClass member = new MemberClass();
		MemoClass memo = new MemoClass();
		MainView view = new MainView();
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while (loop) {
			view.menu();
			switch (scan.nextInt()) {
				case 1:
					// 회원 업무
					member.start();
					break;
				case 2:
					// 메모 업무
					memo.start();
					break;
				default:
					// 메인 종료 
					
					loop = false;
					break;
			}
		}
		
		view.close();
		
	}
}

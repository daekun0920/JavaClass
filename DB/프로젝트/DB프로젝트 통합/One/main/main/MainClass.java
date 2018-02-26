package main;

import java.util.Scanner;

import admin.AdminClass;
import main.view.MainView;
import member.MemberClass;
import member.auth.Auth;
import student.StudentClass;
import teacher.TeacherClass;

public class MainClass {

	public static void main(String[] args) {
		
		MemberClass member = new MemberClass();
		TeacherClass teacher = new TeacherClass();
		AdminClass admin = new AdminClass();
		StudentClass student = new StudentClass();
		Auth auth = new Auth();
		
		MainView view = new MainView();
		
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			view.menu();
			switch(scan.nextInt()) {
				case 1:
					//로그인 처리
					member.start(auth);
					break;
				case 2:
					if(Auth.type.equals("관리자")) {
						admin.start();
						break;
					} else {
						System.out.println("관리자 전용 메뉴입니다.");
						break;
					}
				case 3:
					//교사 모드
					if(Auth.type.equals("교사")) {
						teacher.start(auth);
						break;
					} else {
						System.out.println("교사 전용 메뉴입니다.");
						break;
					}
				case 4:
					//교육생 모드
					if(Auth.type.equals("교육생")) {
						student.start();
						break;
					} else {
						System.out.println("교육생 전용 메뉴입니다.");
						break;
					}
				default:
					loop = false;
					break;
			}
			
		}
		
		view.close();
	}
}

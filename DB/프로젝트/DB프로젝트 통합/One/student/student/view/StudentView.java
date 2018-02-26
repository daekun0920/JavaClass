package student.view;

import java.util.Scanner;

import main.view.MainView;
import studentreview.view.ReviewView;

public class StudentView {
	
	public void menu() {
	
	System.out.println("====================");
	System.out.println("교육생님 안녕하세요.");
	System.out.println("====================");
	System.out.println("1. 성적 정보");
	System.out.println("2. 출결관리");
	System.out.println("3. 수강평 관리");
	System.out.println("4. 돌아가기");
	System.out.print("선택 : ");
	
	}

	public void close() {
		
		System.out.println();
		System.out.println();
		System.out.println("==============================================");
		
	}
}

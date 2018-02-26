package studentinput;


import java.util.ArrayList;
import java.util.Scanner;

import member.auth.Auth;
import student.StudentClass;
import student.model.StudentDAO;
import student.model.StudentMyInfoListDTO;
import student.model.StudentMyScoreListDTO;
import student.view.StudentView;
import studentinout.model.StudentInoutdAddDTO;
import studentinout.model.StudentinoutDAO;
import studentinout.model.StudentinoutDTO;
import studentinout.view.StudentInOutView;
import studentreview.StudentReviewClass;
import studentreview.model.StudentReviewEditDTO;

public class StudentInputClass {
	
	public void start() {
		StudentInOutView view = new StudentInOutView();
		StudentView menu = new StudentView();
		Scanner scan = new Scanner(System.in);
		StudentClass back = new StudentClass();
		boolean loop = true;
		
		
		
		while (loop) {
			view.menu();
		
			switch (scan.nextInt()) {
				case 1:
					//출결 전체
					all(Auth.mseq);
					break;
				case 2:
					//출결 월
					
					mm(Auth.mseq);
					break;
				case 3:
					// 출결 일
					dd(Auth.mseq);
					break;
					
				case 4:
					
					in(Auth.mseq);
					break;
				case 5:
					
					out(Auth.mseq);
					break;
				
				case 6:
					//메인 종료
					loop = false;
					break;
			}
		}
		
	}

	private void out(String mseq) {
		StudentinoutDAO dao = new  StudentinoutDAO();
	
		StudentInoutdAddDTO dto = new StudentInoutdAddDTO();
		dto.setStudentseq(mseq);
		dao.outAdd(dto);
		System.out.println("퇴근완료");
	}

	private void in(String mseq) {
		StudentinoutDAO dao = new  StudentinoutDAO();


		StudentInoutdAddDTO dto = new StudentInoutdAddDTO();
		dto.setStudentseq(mseq);
		dao.inAdd(dto);
		System.out.println("출근완료");
		
		}

	private void dd(String mseq) {
		Scanner scan = new Scanner(System.in);
		
	
	   	System.out.print("월 입력 :");	   	
	   	String num = scan.nextLine();
	   	System.out.print("일 입력 :");	   	
	   	String num2 = scan.nextLine();
	   	
	   	if(num.length() == 1) {
	   		
	   		 num ="0"+ num;
	   		
	   	}
	   	
	  	if(num2.length() == 1) {
	   		
	   		 num2 ="0"+ num2;
	   		
	   	}
	   		
	   		
	
		StudentinoutDAO dao = new StudentinoutDAO();
		ArrayList<StudentinoutDTO> list = dao.myattendande(mseq);
		System.out.println("[학생명]\t\t\t\t\t[등원시간]\t\t\t\t\t\t\t[하원시간]\t\t\t\t\t\t[출결상태]");
	
		for (StudentinoutDTO dto : list) {
			
			if(dto.getIn().substring(5, 7).equals(num) && dto.getIn().substring(8, 10).equals(num2)) {
				
				System.out.println("──────────────────────────────────────────────────────────");
				
			      System.out.printf("%s\t\t|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\r\n"
			    		  																												 ,dto.getName()
			    		  																												 ,dto.getIn()
			    		  																												 ,dto.getOut()
			    		  																												 ,dto.getBigo());
			    		  																												 
				
				
	
				
			}
		
	}

	}
	private void mm(String mseq) {
		
		Scanner scan = new Scanner(System.in);

	   	System.out.print("월 입력 :");	   	
	   	String num = scan.nextLine();
	   	if(num.length() == 1) {
	   		
	   		 num ="0"+ num;
	   	}
	   		
	   		
	
		StudentinoutDAO dao = new StudentinoutDAO();
		ArrayList<StudentinoutDTO> list = dao.myattendande(mseq);
		System.out.println("[학생명]\t\t\t\t\t[등원시간]\t\t\t\t\t\t\t[하원시간]\t\t\t\t\t\t[출결상태]");
	
		for (StudentinoutDTO dto : list) {
			if(dto.getIn().substring(5, 7).equals(num)) {
				System.out.println("──────────────────────────────────────────────────────────");
				
			      System.out.printf("%s\t\t|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\r\n"
			    		  																												 ,dto.getName()
			    		  																												 ,dto.getIn()
			    		  																												 ,dto.getOut()
			    		  																												 ,dto.getBigo());
			    		  																												 
				
				
	
				
			}

		}
				
}
	
	private void all(String mseq) {
			
		StudentinoutDAO dao = new StudentinoutDAO();
		ArrayList<StudentinoutDTO> list = dao.myattendande(mseq);

System.out.println("[학생명]\t\t\t\t\t[등원시간]\t\t\t\t\t\t\t[하원시간]\t\t\t\t\t\t[출결상태]");
		
		for (StudentinoutDTO dto : list) {
			System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
		      System.out.printf("%s\t\t|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\r\n"
		    		  																												 ,dto.getName()
		    		  																												 ,dto.getIn()
		    		  																												 ,dto.getOut()
		    		  																												 ,dto.getBigo());
		    		  																												 


		
	}
		
	}
	
}
		

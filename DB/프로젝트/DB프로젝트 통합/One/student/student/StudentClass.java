package student;
import java.util.ArrayList;
import java.util.Scanner;

import main.view.MainView;
import member.auth.Auth;
import student.model.StudentDAO;
import student.model.StudentMyInfoListDTO;
import student.model.StudentMyScoreListDTO;
import student.view.StudentView;
import studentinput.StudentInputClass;
import studentreview.StudentReviewClass;

public class StudentClass {

	private Scanner scan;
	private StudentView menu;
	StudentReviewClass review;
	StudentInputClass input;
	
	public StudentClass() {

		scan = new Scanner(System.in);
		menu = new StudentView();
		
		review = new StudentReviewClass();
		input = new StudentInputClass();
	}
	
	public void start() {

		studentTitle(Auth.mseq);
			 
			boolean loop = true;

			while (loop) {
				menu.menu();
			
				switch (scan.nextInt()) {
					case 1:
						///과정/성적정보 조회
						grade(Auth.mseq);
		
						break;
					case 2:
						//출결
						input.start();						
					
						break;
					case 3:
						//수강평
						review.start();
					
						break;
						
					default:
						//메인 종료
						loop = false;
						break;
				}
				menu.close();
			}
			   
	}
	private static void studentTitle(String mseq) {
			   	
			   	  StudentDAO dao = new StudentDAO(); 
			      StudentMyInfoListDTO dto = new StudentMyInfoListDTO();
			      
			      System.out.println("==================================================");
			      System.out.println("교육생 정보");
			      System.out.println("==================================================");
			      System.out.println();
			      dto = dao.my(mseq);
			      System.out.printf("이    름 : %s\r\n",dto.getName());
			      System.out.printf("전화번호 : %s\r\n",dto.getTel());
			      System.out.printf("과 정 명 : %s\r\n",dto.getCourse());
			      System.out.printf("과정기간 : %s\r\n",dto.getDate());
			      System.out.printf("강 의 실 : %s\r\n",dto.getRoom());
 
			      System.out.println();
			
	}


	private static void grade(String mseq) {
		
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentMyScoreListDTO> list = dao.mysubject(mseq);
	

		for (StudentMyScoreListDTO dto : list) {
			System.out.println("------------------------------------------------------------");
			System.out.printf(" 과목명 : %s\r\n 교재명 :%s\r\n 과목기간 :%s\r\n 교사명 : %s\r\n [출석점수]%s/%s\r\n [필기점수]%s/%s\r\n [실기점수]%s/%s\r\n 시험일 :%s\r\n  "
			    		  																												 ,dto.getSubject()
			    		  																												 ,dto.getBook()
			    		  																												 ,dto.getDate()
			    		  																												 ,dto.getTeacher()
			    		  																												 ,dto.getAtten()	 
			    		  																												 ,dto.getGatten()
			    		  																												 ,dto.getWrite()
			    		  																												 ,dto.getGwrite()
			    		  																												 ,dto.getPrac()
			    		  																												 ,dto.getGprac()
			    		  																												 ,dto.getExam()
			    		  																										);
			    		  																										
			      

			
		}
			
	}
		
}
	

	



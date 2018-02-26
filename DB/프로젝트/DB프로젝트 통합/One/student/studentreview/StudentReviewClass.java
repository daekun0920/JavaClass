package studentreview;

import java.util.ArrayList;
import java.util.Scanner;

import member.auth.Auth;
import student.StudentClass;
import student.view.StudentView;
import studentreview.model.StudentReviewAddDTO;
import studentreview.model.StudentReviewDAO;
import studentreview.model.StudentReviewDelDTO;
import studentreview.model.StudentReviewEditDTO;
import studentreview.model.StudentReviewListDTO;
import studentreview.view.ReviewView;

public class StudentReviewClass {
	
	private static StudentReviewDAO dao;
	private static Scanner scan;
	private ReviewView view;
	private StudentView menu;
	
	public StudentReviewClass() {
		dao = new StudentReviewDAO();
		menu = new StudentView();
		view = new ReviewView(); 
		scan = new Scanner(System.in);
	}
	
	public void start() {

		boolean loop = true;
		StudentClass main = new StudentClass();
		StudentReviewDAO dao = new StudentReviewDAO();
		StudentClass back = new StudentClass();
		
		while (loop) {
			view.menu();
			switch (scan.nextInt()) {
				case 1:
					///전체 조회 
					list();
					break;
				case 2:
					///내 수강평 조회
					titel(Auth.mseq);
					break;
					
				case 3:
					add(Auth.mseq);
					// 내 수강평 등록
					break;
				case 4:
					//내 수강평 수정
					upd(Auth.mseq);
					break;
				case 5:
					del(Auth.mseq);
					break;
					
				default:
					//메인 종료
					loop = false;
					break;
			}
		}
		
	}

	private void upd(String mseq) {
		
		scan = new Scanner(System.in);

		System.out.println("[수강평 삭제]");

		System.out.print("수정할 내용 입력 :");
		String txt = scan.nextLine();

		StudentReviewEditDTO dto = new  StudentReviewEditDTO();
		
		dto.setStudent_enrollment_seq(mseq);
		dto.setCourse_review(txt);
		
		if (dao.reviewupd(dto) > 0) {
			System.out.println("**수강평 수정 성공");
		} else {
			System.out.println("**수강평 수정 실패");
		}
	
		
		System.out.println("완료");
		
	}

		
	private void del(String mseq) {
		
		scan = new Scanner(System.in);
		
		
		System.out.println("[수강평 삭제]");

		StudentReviewDelDTO dto = new  StudentReviewDelDTO();
		
		dto.setStudent_enrollment_seq(mseq);
		
		if (dao.reviewdle(dto) > 0) {
			System.out.println("**수강평 삭제 성공");
		} else {
			System.out.println("**수강평 삭제 실패");
		}
	
		
		System.out.println("완료");
		
	}

	private void add(String mseq) {
		
		scan = new Scanner(System.in);
	
		System.out.println("[수강평 작성]");
	
		System.out.print("내용 : ");
		String content = scan.nextLine();
		

		StudentReviewAddDTO dto = new StudentReviewAddDTO();
		
		dto.setStudent_enrollment_seq(mseq);
		dto.setCourse_review(content);
		
		
		if (dao.reviewAdd(dto) > 0) {
			System.out.println("**수강평 쓰기 성공");
		} else {
			System.out.println("**수강평 쓰기 실패");
		}
	
		
		System.out.println("완료");

	}

	private static void list() {

		ArrayList<StudentReviewListDTO> list = dao.list();
				
		System.out.println("[수강평 조회]");
				
		for (StudentReviewListDTO dto : list) {
					
			
			System.out.printf("%s\t\t\t%s\n"
										,dto.getStudent_enrollment_seq()
										,dto.getCourse_review());
			System.out.println();							
		}
				
			System.out.println("*완료*");
	}
	

private static void titel(String mseq) {

	ArrayList<StudentReviewListDTO> list = dao.list();

	for (StudentReviewListDTO dto : list) {
		if(dto.getStudent_enrollment_seq().equals(mseq))
		System.out.printf("%s\t\t\t%s\n"
										,dto.getStudent_enrollment_seq()
										,dto.getCourse_review());
			
	}


}
}



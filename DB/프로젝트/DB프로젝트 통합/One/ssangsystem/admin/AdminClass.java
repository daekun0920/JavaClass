package admin;

import java.util.Scanner;

import admin.view.AdminView;
import adminattendance.AdminAttendanceClass;
import admincourse.AdminCourseClass;
import admingrade.AdminGradeClass;
import adminreview.AdminReviewClass;
import adminstudent.AdminStudentClass;
import adminsubject.AdminSubjectClass;
import adminteacher.AdminTeacherClass;

public class AdminClass {
	AdminView view;
	AdminGradeClass grade; 
	AdminCourseClass course;
	AdminSubjectClass subject;
	AdminTeacherClass teacher;
	AdminStudentClass student;
	AdminAttendanceClass attend;
	AdminReviewClass review;
	
	Scanner scan;
	
	public AdminClass() {
		view = new AdminView(); 
		grade = new AdminGradeClass();
		course = new AdminCourseClass();
		subject = new AdminSubjectClass();
		teacher = new AdminTeacherClass();
		student = new AdminStudentClass();
		attend = new AdminAttendanceClass();
		review = new AdminReviewClass();
		scan = new Scanner(System.in);
	}

	public void start() {
		boolean loop = true;
		
		while (loop) {
			clearScreen();
			view.menu();
			String sel = scan.nextLine();
			
			switch(sel) {
				case "1" :
					// 개설과정 관리
					clearScreen();
					course.start();
					break;
				case "2" :
					// 개설과목 관리
					clearScreen();
					subject.start();
					break;
				case "3" :
					// 교사계정 관리
					clearScreen();
					teacher.start();
					break;
				case "4" :
					// 교육생 계정 관리
					clearScreen();
					student.start();
					break;	
				case "5" :
					// 성적 조회
					clearScreen();
					grade.start();
					break;
				case "6" :
					// 출결 관리 및 조회
					clearScreen();
					attend.start();
					break;
				case "7" :
					// 교육생 수강평 관리
					clearScreen();
					review.start();
					break;
				default :
					loop = false;
					clearScreen();
					scan.close();
			}
		}
	}

	private static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
}

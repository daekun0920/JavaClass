package admingrade;

import java.util.ArrayList;
import java.util.Scanner;

import admingrade.model.AdminCourseDTO;
import admingrade.model.AdminGradeDAO;
import admingrade.model.AdminStuSubGradeDTO;
import admingrade.model.AdminStudentGradeDTO;
import admingrade.model.AdminStudentInfoDTO;
import admingrade.model.AdminSubjectDTO;
import admingrade.model.AdminSubjectStatusDTO;
import admingrade.view.AdminGradeView;

public class AdminGradeClass {
	Scanner scan;
	AdminGradeView view;
	AdminGradeDAO dao;
	
	
	
	public AdminGradeClass() {
		scan = new Scanner(System.in);
		view = new AdminGradeView();
		dao = new AdminGradeDAO();
	}

	public void start() {
		boolean loop = true;
		
		while (loop) {
			clearScreen();
			view.menu();
			String sel = scan.nextLine();
			
			switch(sel) {
				case "1" :
					// 성적 & 시험날짜 등록 여부 조회
					clearScreen();
					if_grade_test();
					break;
				case "2" :
					// 과목별 성적정보 조회
					clearScreen();
					subject_grade_list();
					break;
				case "3" :
					// 개인별 성적정보 조회
					clearScreen();
					student_grade_list();
					break;
				default :	
					loop = false;
			}
			
		}
	}

	private void student_grade_list() { // 교육생 개인별 출력
		boolean loop = true;
		ArrayList<AdminStudentInfoDTO> list = dao.student_grade_list();
		int rec = 5;
		int num = 1;
		
		while (loop) {
				
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				System.out.println("-=-=-=-=-=-=-={개인별 성적 조회}=-=-=-=-=-=-=-");
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminStudentInfoDTO dto = list.get(i);
					
					System.out.println("[회원번호]   : " + dto.getStudent_seq() + "\n" +
								       "[학생이름]   : " + dto.getStudent_name() + "\n" +
									   "[주민번호]   : " + dto.getStudent_ssn() + "\n" +
								       "[과정명]     : " + dto.getCourse_name() + "\n" +
									   "[과정시작일] : " + dto.getCourse_start_date() + "\n" +
								       "[과정종료일] : " + dto.getCourse_end_date() + "\n" +
									   "[강의실명] : " + dto.getCourse_classroom());
					
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.printf("------------------------현재 페이지[%d] - 총 페이지[%d]------------------\n", num, page);
				System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"학생\" or (돌아가기 : 0)");
				System.out.print("[입력 해주세요] : ");
				String order = scan.nextLine();
				
				if (order.equals("0")) {
					clearScreen();
					break;
				} else if (!order.equals("페이지") && !order.equals("학생")) {
					clearScreen();
					System.out.println("올바르지 않은 옵션입니다.");
					continue;
				}
				
				System.out.println("번호를 입력해주세요.");
				System.out.print("[입력 해주세요] : ");
				int tempo = num;
				String temp = scan.nextLine();
				num = Integer.parseInt(temp);
				
				if (order.equals("페이지")) {
					if (num > page) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					rec = num * 5;
					clearScreen();
				} else if (order.startsWith("학생")) {
					if (num > list.size()) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					clearScreen();
					private_grade_list(dao.private_grade_list(num), getName(num, list));
					
				} else {
					clearScreen();
					System.out.println("올바르지 않습니다.");
				}
				
		}
		
	}

	private String getName(int num, ArrayList<AdminStudentInfoDTO> list) {
		String name = "Unknown";
		for (AdminStudentInfoDTO dto : list) {
			if (Integer.parseInt(dto.getStudent_seq()) == num) {
				name = dto.getStudent_name();
			}
		}
		
		return name;
	}

	private void private_grade_list(ArrayList<AdminStudentGradeDTO> list, String name) {
		boolean loop = true;
		int rec = 5;
		int num = 1;

		while (loop) {
			
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				System.out.printf("-=-=-=-=-=-={\'%s\'학생의 개인 성적 현황}=-=-=-=-=-=-\n");
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminStudentGradeDTO dto = list.get(i);
					
					System.out.println("[과목명]     : " + dto.getSubject_name() + "\n" +
									   "[과목시작일] : " + dto.getSubject_start_date() + "\n" +
									   "[과목종료일] : " + dto.getSubject_end_date() + "\n" +
									   "[교사명]     : " + dto.getSubject_teacher() + "\n" +
									   "[출결]       : " + dto.getStudent_attendance() + "\n" +
									   "[필기]       : " + dto.getStudent_writing() + "\n" +
									   "[실기]       : " + dto.getStudent_practical());
			
				
					
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.printf("------------------------현재 페이지[%d] - 총 페이지[%d]------------------\n", num, page);
				System.out.print("[입력 해주세요 (돌아가기 : 0)] : ");
				int temp = num;
				num = scan.nextInt();
				scan.skip("\r\n");
				if (num == 0) {
				    loop = false;
				    clearScreen();
				}
				
				if (num > page) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = temp;
					continue;
				}
				rec = num * 5;
				clearScreen();
		}
		
		
	}

	private void subject_grade_list() { // 과목별 출력
		boolean loop = true;
		ArrayList<AdminSubjectDTO> list = dao.subject_grade_list();
		int rec = 5;
		int num = 1;

		while (loop) {
			
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				System.out.println("-=-=-=-=-=-=-=-={과목별 성적 조회}=-=-=-=-=-=-=-=-=-");
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminSubjectDTO dto = list.get(i);
					
					System.out.println(
									"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
									"[번호]       : " + dto.getSubject_seq() + "\n" +
									"[과목명]     : " + dto.getSubject_name() + "\n" +
									"[교재명]     : " + dto.getSubject_book() + "\n" +
									"[강의실]     : " + dto.getSubject_classroom() + "\n" +
									"[교사명]     : " + dto.getSubject_teacher() + "\n" +
									"[과정명]     : " + dto.getCourse_name() + "\n" +
									"[과정시작일] : " + dto.getCourse_start_date() + "\n" +
									"[과정종료일] : " + dto.getCourse_end_date() + "\n");
					
					
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.printf("현재 페이지[%d] - 총 페이지[%d]\n", num, page);
				System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"과목\" or (돌아가기 : 0)");
				System.out.print("[입력 해주세요] : ");
				String order = scan.nextLine();
				
				if (order.equals("0")) {
					clearScreen();
					break;
				} else if (!order.equals("페이지") && !order.equals("과목")) {
					clearScreen();
					System.out.println("올바르지 않은 옵션입니다.");
					continue;
				}
				
				System.out.println("번호를 입력해주세요.");
				System.out.print("[입력 해주세요] : ");
				int tempo = num;
				String temp = scan.nextLine();
				num = Integer.parseInt(temp);
			
				if (order.equals("페이지")) {
					if (num > page) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					rec = num * 5;
				} else if (order.startsWith("과목")) {
					if (num > list.size()) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					clearScreen();
					substu_grade_list(dao.student_grade_list(num), getSubject(num, list));
				} else {
					clearScreen();
					System.out.println("올바르지 않습니다.");
				}
				
		}
		
	}

	

	private String getSubject(int num, ArrayList<AdminSubjectDTO> list) {
		String subject = "";
		for (AdminSubjectDTO dto : list) {
			if(Integer.parseInt(dto.getSubject_seq()) == num) {
				subject = dto.getSubject_name();
			}
		}
		
		
		
		return subject;
	
	}

	private void substu_grade_list(ArrayList<AdminStuSubGradeDTO> list, String name) {
		boolean loop = true;
		int rec = 5;
		int num = 1;

		while (loop) {
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				System.out.printf("-=-=-=-={\'%s\' 과목 성적 현황}=-=-=-=-");
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminStuSubGradeDTO dto = new AdminStuSubGradeDTO();
					
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
									 "[학생명]   : " + dto.getStudent_name() + "\n" +
									 "[주민번호] : " + dto.getStudent_ssn() + "\n" +
								     "[출결]     : " + dto.getStudent_attendance() + "\n" +
									 "[필기]     : " + dto.getStudent_writing() + "\n" + 
								     "[실기]     : " + dto.getStudent_practical() + "\n");
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
				System.out.printf("현재 페이지[%d] - 총 페이지[%d]\n", num, page);
				System.out.print("[입력 해주세요 (돌아가기 : 0)] : ");
				int temp = num;
				num = scan.nextInt();
				scan.skip("\r\n");
				if (num == 0) {
				    loop = false;
				    clearScreen();
				}
				
				if (num > page) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = temp;
					continue;
				}
				rec = num * 5;
				clearScreen();
		}
		
		
		
	}

	private void if_grade_test() { // 과정 목록
		boolean loop = true;
		ArrayList<AdminCourseDTO> list = dao.course_list();
		int rec = 5;
		int num = 1;
		
		while(loop) {
			int minus = 0;
			if (rec > list.size()) {
			    minus = rec - list.size();
			}
			System.out.println("-=-=-=-=-=-=-=-={성적 & 시험날짜 등록 여부}=-=-=-=-=-=-=-=-");
			for (int i = rec - 5; i < rec - minus; i++) {
				AdminCourseDTO dto = list.get(i);
				
				System.out.println( "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
									"[번호]       : " + dto.getCourse_seq() + "\n" +
								    "[과정명]     : " + dto.getCourse_name() + "\n" +
								    "[과정시작일] : " + dto.getCourse_start_date() + "\n" +
								    "[과정종료일] : " + dto.getCourse_end_date() + "\n" +
								    "[인원]       : " + dto.getCourse_stu_num() + "\n");
									
			}
			
			int page;
			
			if (list.size() % 5 == 0) {
				page = list.size() / 5;
			} else {
				page = (list.size() / 5) + 1;
			}
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
			System.out.printf("현재 페이지[%d] - 총 페이지[%d]\n", num, page);
			System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"과정\" or (돌아가기 : 0)");
			System.out.print("[입력 해주세요] : ");
			String order = scan.nextLine();
			
			if (order.equals("0")) {
				clearScreen();
				System.out.println("돌아갑니다.");
				break;
			} else if (!order.equals("페이지") && !order.equals("과정")) {
				clearScreen();
				System.out.println("올바르지 않은 옵션입니다.");
				continue;
			}
			
			System.out.println("번호를 입력해주세요.");
			System.out.print("[입력 해주세요] : ");
			int tempo = num;
			String temp = scan.nextLine();
			num = Integer.parseInt(temp);
			
			
		
			if (order.equals("페이지")) {
				if (num > page) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = tempo;
					continue;
				}
				rec = num * 5;
				clearScreen();
			} else if (order.startsWith("과정")) {
				if (num > list.size()) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = tempo;
					continue;
				}
				clearScreen();
				if_subject_list(dao.subject_list(num));
			} else {
				clearScreen();
				System.out.println("올바르지 않습니다.");
			}
			
		}
		
	}

	private void if_subject_list(ArrayList<AdminSubjectStatusDTO> list) {
		boolean loop = true;
		int rec = 5;
		int num = 1;

		while (loop) {
				
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				System.out.println("-=-=-=-=-=-=-=-={성적 & 시험날짜 등록 여부}=-=-=-=-=-=-=-=-");;
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminSubjectStatusDTO dto = list.get(i);
				
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
									   "[과목명]     : " + dto.getSubject_name() + "\n" +
									   "[과목시작일] : " + dto.getSubject_start_date() + "\n" +
									   "[과목종료일] : " + dto.getSubject_end_date() + "\n" +
									   "[성적등록]   : " + dto.getSubject_if_grade() + "\n" +
									   "[시험날짜]   : " + dto.getSubject_if_test());
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
				System.out.printf("현재 페이지[%d] - 총 페이지[%d]\n", num, page);
				System.out.print("[입력 해주세요 (돌아가기 : 0)] : ");
				int temp = num;
				num = scan.nextInt();
				scan.skip("\r\n");
				
				
				
				if (num == 0) {
				    loop = false;
				    clearScreen();
				}
				
				if (num > page) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = temp;
					continue;
				}
				rec = num * 5;
				clearScreen();
		}
	}
	private static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}


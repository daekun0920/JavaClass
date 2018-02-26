package adminsubject;

import java.util.ArrayList;
import java.util.Scanner;

import adminsubjectview.SubjectView;
import admincourse.AdminCourseClass;
import admincourse.model.AdminCourseListDTO;
import admincourse.model.admincoursedayDTO;
import adminsubject.model.AdminSelectedListDTO;
import adminsubject.model.AdminSubjectAddDTO;
import adminsubject.model.AdminSubjectDAO;
import adminsubject.model.AdminSubjectEditDTO;
import adminsubject.model.AdminSubjectListDTO;
import adminsubject.model.AdminbasicSubjectListDTO;
import adminsubject.model.AdminbasicbookDTO;
import adminsubject.model.AdmindetilteacherDTO;

public class AdminSubjectClass {

	private AdminSubjectDAO dao;
	private Scanner scan;
	private SubjectView view;

	public AdminSubjectClass() {

		dao = new AdminSubjectDAO();
		scan = new Scanner(System.in);
		view = new SubjectView();
	}
	

	public void start() {

		boolean loop = true;

		while (loop) {
			view.menu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			switch (sel) {
			case 1:
				// 1.개설 과목 조회
				subject_list();
				break;
			case 2:
				// 2.특정 과목 조회
				subject_selected_list();
				break;
			case 3:
				// 3.개설 과목 등록
				subject_add();
				break;
			case 4:
				// 4.개설 과목 수정
				subject_edit();
				break;
			case 5:
				// 5.개설 과목 삭제
				subject_del();
				break;
			default:
				loop = false;
				break;
			}

		}

	}

	private void subject_list() {

		ArrayList<AdminSubjectListDTO> list = dao.listsubject();

		System.out.println("===========================[과목 조회]===========================");

		for (AdminSubjectListDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[과정번호]	: " + dto.getCourseseq());
			System.out.println("[과정명]	: " + dto.getCoursename());
			System.out.println("[과정시작기간]	: " + dto.getCoursestart().substring(0, 10));
			System.out.println("[과정종료기간]	: " + dto.getCourseend().substring(0, 10));
			System.out.println("[강의실명]	: " + dto.getClassroom());
			System.out.println("[과목번호]	: " + dto.getSubjectseq());
			System.out.println("[과목명] 	: " + dto.getSubjectname());
			System.out.println("[과목시작기간]	: " + dto.getSubjectstart().substring(0, 10));
			System.out.println("[과목종료기간]	: " + dto.getSubjectend().substring(0, 10));
			System.out.println("[교재명] 	: " + dto.getBasicbook());
			System.out.println("[교사명] 	: " + dto.getTeaname());

			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");

	}

	private void subject_selected_list() {

		System.out.println("===========================[선택 조회]===========================");

		System.out.print("과목 선택(번호입력) : ");
		String subjectseq = scan.nextLine();

		ArrayList<AdminSelectedListDTO> listsubjectselect = dao.listsubjectselect(subjectseq);
		for (AdminSelectedListDTO dto : listsubjectselect) {

			System.out.println("=================================================================");
			System.out.println("[과정번호]	: " + dto.getCourseseq());
			System.out.println("[과정명]	: " + dto.getCoursename());
			System.out.println("[과정시작기간]	: " + dto.getCoursestart().substring(0, 10));
			System.out.println("[과정종료기간]	: " + dto.getCourseend().substring(0, 10));
			System.out.println("[강의실명]	: " + dto.getClassroom());
			System.out.println("[과목명] 	: " + dto.getSubjectname());
			System.out.println("[과목시작기간]	: " + dto.getSubjectstart().substring(0, 10));
			System.out.println("[과목종료기간]	: " + dto.getSubjectend().substring(0, 10));
			System.out.println("[교재명] 	: " + dto.getBasicbook());
			System.out.println("[교사명] 	: " + dto.getTeaname());

			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");

	}

	private void subject_add() {

		view.header("과목 등록");

		course_name_list();
		System.out.print("과정선택(번호) : ");
		String courseseq = scan.nextLine();

		subject_name_list();
		System.out.print("과목명선택(번호) : ");
		String baiscsubject = scan.nextLine();

		ArrayList<admincoursedayDTO> daystart = new ArrayList<admincoursedayDTO>();
		daystart = course_day_list();
		System.out.print("과목기간선택(번호) : ");
		String coursestart = scan.nextLine();
		int costart = Integer.parseInt(coursestart);
		int minus = Integer.parseInt(daystart.get(0).getDayseq());

		ArrayList<AdminbasicbookDTO> basicbooklist = new ArrayList<AdminbasicbookDTO>();
		basicbooklist = basic_book();
		System.out.print("교재명선택(번호) : ");
		String basicbook = scan.nextLine();

		ArrayList<AdmindetilteacherDTO> teacherlist = new ArrayList<AdmindetilteacherDTO>();
		teacherlist = teacher_list();
		System.out.print("교사명선택(번호) : ");
		String teaname = scan.nextLine();

		AdminSubjectAddDTO dto = new AdminSubjectAddDTO();

		dto.setCourse_seq(courseseq);
		dto.setBaiscsubjectseq(baiscsubject);
		dto.setSubjectstart(daystart.get(costart - minus).getDaystart().substring(0, 10));
		dto.setSubjectend(daystart.get(costart - minus).getDayend().substring(0, 10));
		dto.setBasicbook(basicbook);
		dto.setTeaseq(teaname);

		if (dao.add(dto) == 1) {
			view.result("등록 !!!");
		} else {
			view.result("등록 실패 !!!");
		}

	}

	private void subject_edit() {

		view.header("과목 수정");

		course_name_list();
		System.out.print("과정선택(번호) : ");
		String courseseq = scan.nextLine();
		
		subject_first();
		System.out.print("과목선택(번호) : ");
		String subjectseq = scan.nextLine();

		subject_name_list();
		System.out.print("과목명선택(번호) : ");
		String baiscsubject = scan.nextLine();

		ArrayList<admincoursedayDTO> daystart = new ArrayList<admincoursedayDTO>();
		daystart = course_day_list();
		System.out.print("과목기간선택(번호) : ");
		String coursestart = scan.nextLine();
		int costart = Integer.parseInt(coursestart);
		int minus = Integer.parseInt(daystart.get(0).getDayseq());

		ArrayList<AdminbasicbookDTO> basicbooklist = new ArrayList<AdminbasicbookDTO>();
		basicbooklist = basic_book();
		System.out.print("교재명선택(번호) : ");
		String basicbook = scan.nextLine();

		ArrayList<AdmindetilteacherDTO> teacherlist = new ArrayList<AdmindetilteacherDTO>();
		teacherlist = teacher_list();
		System.out.print("교사명선택(번호) : ");
		String teaname = scan.nextLine();

		AdminSubjectEditDTO dto = new AdminSubjectEditDTO();

		dto.setCourse_seq(courseseq);
		dto.setSubjectseq(subjectseq);
		dto.setBaiscsubjectseq(baiscsubject);
		dto.setSubjectstart(daystart.get(costart - minus).getDaystart().substring(0, 10));
		dto.setSubjectend(daystart.get(costart - minus).getDayend().substring(0, 10));
		dto.setBasicbook(basicbook);
		dto.setTeaseq(teaname);

		if (dao.edit(dto) == 1) {
			view.result("수정완료 !!!");
		} else {
			view.result("수정실패 !!!");
		}
	}

	private void subject_del() {

		view.header("과목 삭제");

		subject_first();
		System.out.print("과목 선택(번호입력) : ");
		String subjectseq = scan.nextLine();

		System.out.print("**삭제를 하면 과정이 사라집니다.\r\n 계속 진행하시겠습니까?(yes or no) : ");
		if (scan.nextLine().equals("yes")) {
			if (dao.del(subjectseq) == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} else {
			System.out.println("삭제 취소");
		}

	}

	private ArrayList<AdminCourseListDTO> course_name_list() {

		ArrayList<AdminCourseListDTO> list = dao.course_list();

		System.out.println("===========================[기초과정 조회]===========================");

		for (AdminCourseListDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[기초과정번호]     : " + dto.getCourseseq());
			System.out.println("[기초과정명]       : " + dto.getCoursename());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return list;
	}

	private ArrayList<AdminbasicSubjectListDTO> subject_name_list() {

		ArrayList<AdminbasicSubjectListDTO> list = dao.listbaiscsubject();

		System.out.println("===========================[기초과목 조회]===========================");

		for (AdminbasicSubjectListDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[기초과목번호]     : " + dto.getSubjectbasicseq());
			System.out.println("[기초과목명]       : " + dto.getSubjectbasicname());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return list;
	}

	private ArrayList<admincoursedayDTO> course_day_list() {

		ArrayList<admincoursedayDTO> daylist = dao.daylist();

		System.out.println("=============================[날짜 조회]=============================");

		for (admincoursedayDTO dto : daylist) {

			System.out.println("=================================================================");
			System.out.println("[날짜번호]     : " + dto.getDayseq());
			System.out.println("[등록가능시작기간] : " + dto.getDaystart().substring(0, 10));
			System.out.println("[등록가능종료기간] : " + dto.getDayend().substring(0, 10));
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return daylist;
	}

	private ArrayList<AdminbasicbookDTO> basic_book() {

		ArrayList<AdminbasicbookDTO> list = dao.listbasicbook();

		System.out.println("=============================[기초교재조회]=============================");

		for (AdminbasicbookDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[기초교재번호]	: " + dto.getBookseq());
			System.out.println("[기초교재이름]	: " + dto.getBookname());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return list;
	}

	private ArrayList<AdmindetilteacherDTO> teacher_list() {

		ArrayList<AdmindetilteacherDTO> list = dao.teachername();

		System.out.println("=============================[기초교사조회]=============================");

		for (AdmindetilteacherDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[기초교사번호]	: " + dto.getTeacherseq());
			System.out.println("[기초교사이름]	: " + dto.getTeachername());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return list;
	}

	private void subject_first() {

		ArrayList<AdminSubjectListDTO> list = dao.listsubject();

		System.out.println("===========================[과목 조회]===========================");

		for (AdminSubjectListDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[과목번호]	: " + dto.getSubjectseq());
			System.out.println("[과목명] 	: " + dto.getSubjectname());
			System.out.println("[과목시작기간]	: " + dto.getSubjectstart().substring(0, 10));
			System.out.println("[과목종료기간]	: " + dto.getSubjectend().substring(0, 10));
			System.out.println("[교재명] 	: " + dto.getBasicbook());
			System.out.println("[교사명] 	: " + dto.getTeaname());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");

	}
}

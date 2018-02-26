package admincourse;

import java.util.ArrayList;
import java.util.Scanner;

import admincourse.model.AdminCourseAddDTO;
import admincourse.model.AdminCourseDAO;
import admincourse.model.AdminCourseEditDTO;
import admincourse.model.AdminCourseListDTO;
import admincourse.model.AdminCourseSelectedListDTO;
import admincourse.model.AdminCoursebasicroomDTO;
import admincourse.model.AdminCoursestudentDTO;
import admincourse.model.admincoursedayDTO;
import admincourseview.CourseView;

public class AdminCourseClass {

	private AdminCourseDAO dao;
	private Scanner scan;
	private CourseView view;

	public AdminCourseClass() {
		dao = new AdminCourseDAO();
		scan = new Scanner(System.in);
		view = new CourseView();

	}
	
	

	public void start() {

		boolean loop = true;

		while (loop) {
			view.menu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			switch (sel) {
			case 1:
				// 1.개설 과정 조회
				course_list();
				break;
			case 2:
				// 2.특정 개설 과정 조회
				course_selected_list();
				break;
			case 3:
				// 3.개설 과정 등록
				course_add();
				break;
			case 4:
				// 4.개설 과정 수정
				course_edit();
				break;
			case 5:
				// 5.개설 과정 삭제
				course_del();
				break;
			case 6:
				// 6.수료 날짜 지정
				course_complete_day();
				break;
			default:
				loop = false;
				break;
			}

		}

	}

	private void course_list() {

		ArrayList<AdminCourseListDTO> list = dao.list();
 
		System.out.println("===========================[과정 조회]===========================");

		for (AdminCourseListDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[과정번호]     : " + dto.getCourseseq());
			System.out.println("[과정명]       : " + dto.getCoursename());
			System.out.println("[과정시작기간] : " + dto.getCoursestart().substring(0, 10));
			System.out.println("[과정종료기간] : " + dto.getCourseend().substring(0, 10));
			System.out.println("[과정강의실]   : " + dto.getBasicclassroom());
			System.out.println("[과목등록여부] : " + dto.getYesno());
			System.out.println("[수강인원]     : " + dto.getPeople());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
	}

	private void course_selected_list() {

		System.out.println("===========================[선택 조회]===========================");
		
		System.out.print("과정 선택(번호입력) : ");
		String courseseq = scan.nextLine();
		
		ArrayList<AdminCourseSelectedListDTO> listselect = dao.listselect(courseseq);
	
		for (AdminCourseSelectedListDTO dto : listselect) {

			System.out.println("=================================================================");
			System.out.println("[과정번호] : " + dto.getCourseseq());
			System.out.println("[과목번호] : " + dto.getSubjectseq());
			System.out.println("[과목명] : " + dto.getSubjectname());
			System.out.println("[과목시작기간] : " + dto.getSubjectstart().substring(0, 10));
			System.out.println("[과목종료기간] : " + dto.getSubjectend().substring(0, 10));
			System.out.println("[교재명] : " + dto.getBasicbook());
			System.out.println("[교사명] : " + dto.getTeaname());
			System.out.println("=================================================================");


		}
		System.out.println("*****************************조회 완료****************************");
		course_student_list();
	}

	private void course_add() {

		view.header("과정 등록");

		course_name_list();
		System.out.print("과정명선택(번호): ");
		String basiccourse = scan.nextLine();


		ArrayList<admincoursedayDTO> daystart = new ArrayList<admincoursedayDTO>();
		daystart = course_day_list();
		System.out.print("과정기간입력(번호) : ");
		String courserstart = scan.nextLine();
		int costart = Integer.parseInt(courserstart);
		int minus = Integer.parseInt(daystart.get(0).getDayseq());

		ArrayList<AdminCoursebasicroomDTO> courseclassroom = new ArrayList<AdminCoursebasicroomDTO>();
		courseclassroom = course_class_list();
		System.out.print("강의실선택(번호) : ");
		String basicclassroom = scan.nextLine();

	

		AdminCourseAddDTO dto = new AdminCourseAddDTO();

		dto.setBasiccourse(basiccourse);
		dto.setCoursestart(daystart.get(costart-minus).getDaystart().substring(0, 10));
		dto.setCourseend(daystart.get(costart-minus).getDayend().substring(0, 10));
		dto.setBasicclassroom(basicclassroom);

		if (dao.add(dto) == 1) {
			view.result("등록 !!!");
		} else {
			view.result("등록 실패 !!!");
		}

	}

	private void course_edit() {

		view.header("과정 수정");
		
		course_list();
		System.out.print("수정할 과정명선택(번호): ");
		String minicourseseq = scan.nextLine();

		ArrayList<AdminCourseListDTO> coursename = new ArrayList<AdminCourseListDTO>();
		coursename = course_name_list();
		System.out.print("과정명선택(번호): ");
		String basiccourse = scan.nextLine();

		ArrayList<admincoursedayDTO> daystart = new ArrayList<admincoursedayDTO>();
		daystart = course_day_list();
		System.out.print("과정기간입력(번호) : ");
		String courserstart = scan.nextLine();
		int costart = Integer.parseInt(courserstart);
		int minus = Integer.parseInt(daystart.get(0).getDayseq());

		daystart.get(costart - minus).getDaystart();
		daystart.get(costart - minus).getDayend();

		ArrayList<AdminCoursebasicroomDTO> courseclassroom = new ArrayList<AdminCoursebasicroomDTO>();
		courseclassroom = course_class_list();
		System.out.print("강의실선택(번호) : ");
		String basicclassroom = scan.nextLine();

		AdminCourseEditDTO dto = new AdminCourseEditDTO();

		dto.setCourseseq(minicourseseq);
		dto.setBasiccourse(basiccourse);
		dto.setCoursestart(daystart.get(costart - minus).getDaystart().substring(0, 10));
		dto.setCourseend(daystart.get(costart - minus).getDayend().substring(0, 10));
		dto.setBasicclassroom(basicclassroom);

		if (dao.edit(dto) == 1) {
			view.result("수정완료 !!!");
		} else {
			view.result("수정실패 !!!");
		}

	}

	private void course_del() {
		view.header("과정 삭제");

		course_list();
		System.out.print("과정 선택(번호입력) : ");
		String courseseq = scan.nextLine();

		System.out.print("**삭제를 하면 과정이 사라집니다. 계속 진행하시겠습니까?(yes or no) : ");
		if (scan.nextLine().equals("yes")) {
			if (dao.del(courseseq) == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} else {
			System.out.println("삭제 취소");
		}

	}

	private void course_complete_day() {

		System.out.print("과정 기간 선택(번호입력) : ");
		String completeday = scan.nextLine();

		System.out.println("수료날짜 지정이 완료되었습니다.");

	}

	private ArrayList<admincoursedayDTO> course_day_list() {

		ArrayList<admincoursedayDTO> daylist = dao.daylist();

		System.out.println("=========================[날짜 조회]=========================");

		for (admincoursedayDTO dto : daylist) {

			System.out.println("=================================================================");
			System.out.println("[등록가능날짜번호] : " + dto.getDayseq());
			System.out.println("[등록가능시작기간] : " + dto.getDaystart().substring(0, 10));
			System.out.println("[등록가능종료기간] : " + dto.getDayend().substring(0, 10));

			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return daylist;
	}

	private ArrayList<AdminCourseListDTO> course_name_list() {

		ArrayList<AdminCourseListDTO> list = dao.list();

		System.out.println("=========================[기초과정 조회]=========================");

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

	private ArrayList<AdminCoursebasicroomDTO> course_class_list() {

		ArrayList<AdminCoursebasicroomDTO> list = dao.roomlist();

		System.out.println("==========================[기초강의실조회]==========================");

		for (AdminCoursebasicroomDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[기초과정강의실번호]	: " + dto.getRoomseq());
			System.out.println("[기초과정강의실]		: " + dto.getRoomname());
			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");
		System.out.println();

		return list;
	}

	private ArrayList<AdminCoursestudentDTO> course_student_list() {

		System.out.println("===========================[등록된학생 조회]===========================");
		//
		System.out.print("과정 선택(번호입력) : ");
		String courseseq = scan.nextLine();

		ArrayList<AdminCoursestudentDTO> list = dao.liststudent(courseseq);
		for (AdminCoursestudentDTO dto : list) {

			System.out.println("=================================================================");
			System.out.println("[과정번호] : " + dto.getCourseseq());
			System.out.println("[교육생명] : " + dto.getStuname());
			System.out.println("[교육생주민번호] : " + dto.getStussn());
			System.out.println("[전화번호] : " + dto.getStutel());
			System.out.println("[등록일] : " + dto.getSturegdate().substring(0, 10));
			System.out.println("[수강현황] : " + dto.getStuing());

			System.out.println("=================================================================");

		}
		System.out.println("*****************************조회 완료****************************");

		return list;

	}
}

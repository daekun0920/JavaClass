package adminteacher;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import adminteacher.model.AdminBasicSubjectListDTO;
import adminteacher.model.AdminTeacherAddDTO;
import adminteacher.model.AdminTeacherDAO;
import adminteacher.model.AdminTeacherEditSubjectDTO;
import adminteacher.model.AdminTeacherEditTelDTO;
import adminteacher.model.AdminTeacherListDAO;
import adminteacher.model.AdminTeacherListDTO;
import adminteacher.model.AdminTeacherListEditDTO;
import adminteacher.model.AdminTeacherSelectedListDTO;
import adminteacher.model.AdminTeacherSubjectListDTO;
import adminteacher.view.AdminTeacherView;

public class AdminTeacherClass {

	private AdminTeacherView view;
	private AdminTeacherDAO dao;
	private AdminTeacherListDAO listDao;
	private Scanner scan;
	private static String teacher;
	
	public AdminTeacherClass() {
		
		view = new AdminTeacherView();
		dao = new AdminTeacherDAO();
		listDao = new AdminTeacherListDAO();
		scan = new Scanner(System.in);
		teacher = "교사";
	}

	public void start() {
		
		boolean loop = true;
		
		while (loop) {
			view.menu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			switch (sel) {
				case 1: add();
					break;
				case 2: selected_list();
					break;
				case 3: edit();
					break;
				case 4: del();
					break;
				default : loop = false; break;
				
			}
		}
		
	}

	//교사 추가
	private void add() {
		
		view.header("교사계정 추가");

		
		System.out.print(">> 아이디 : ");
		String id = scan.nextLine();
		
		System.out.print(">> 주민번호뒷자리 : ");
		String ssn = scan.nextLine();
		
		System.out.print(">> 이름 : ");
		String name = scan.nextLine();
		
		System.out.print(">> 전화번호 : ");
		String tel = scan.nextLine();
		
		ArrayList<AdminBasicSubjectListDTO> subjectName = new ArrayList<AdminBasicSubjectListDTO>();
		subjectName = basic_subject_list();
		System.out.print(">> 강의가능과목 : ");
		String subject = scan.nextLine();
		int inputSubjectNumber = Integer.parseInt(subject) - 1;
		
		AdminTeacherAddDTO dto = new AdminTeacherAddDTO();
		
		
		dto.setId(id);
		dto.setSsn(ssn);
		dto.setType(teacher);
		dto.setName(name);
		dto.setTel(tel);
		dto.setSubjectNum(subjectName.get(inputSubjectNumber).getSubjectNum());
		
		if (dao.add(dto) == 1) {
			view.header("교사계정추가성공");
		} else {
			view.header("교사계정추가실패");
		}
	}

	//교사 전체목록 조회
	private ArrayList<AdminTeacherListDTO> list() {

		ArrayList<AdminTeacherListDTO> list = listDao.list();
		
		view.header("교사 조회");
		

 		for (AdminTeacherListDTO dto : list) {
			System.out.println("=================================================");
			System.out.println("[교사번호]\t: " + dto.getSeq());
			System.out.println("[교사이름]\t: " + dto.getName());
			System.out.println("[주민번호]\t: " + dto.getSsn());
			System.out.println("[전화번호]\t: " + dto.getTel());
			System.out.println("[강의가능과목명]: " + dto.getSubjectName());
 		}

 		view.header("교사조회성공");
		
		return list;
	}

	//교사 수정
	private void edit() {
		
		boolean loop = true;
		
		while (loop) {
			view.editmenu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			switch (sel) {
				case 1: edit_tel();
					break;
				case 2: edit_subject();
					break;
				default : loop = false; break;
				
			}
		}
		
	}

	//교사 강의가능과목 추가
	private void edit_subject() {
		view.header("강의가능과목 추가");
		
		teacher_subject_list();
		System.out.print(">> 수정 할 교사번호를 선택 : ");
		String num = scan.nextLine();

		
		basic_subject_list();
		System.out.print(">> 추가할 강의가능과목 선택 : ");
		String snum = scan.nextLine();
		
		AdminTeacherEditSubjectDTO dto = new AdminTeacherEditSubjectDTO();
		
		
		dto.setSeq(num);
		dto.setSseq(snum);
		
		if (dao.edit_subject(dto) == 1) {
			view.header("강의가능과목추가성공");
		} else {
			view.header("강의가능과목추가실패");
		}
	}

	//교사 전화번호 수정
	private void edit_tel() {
		view.header("전화번호 수정");
		
		
		list();
		System.out.print(">> 수정 할 교사번호를 선택 : ");
		String num = scan.nextLine();
		
		System.out.print(">> 수정 할 전화번호 : ");
		String tel = scan.nextLine();
		
		AdminTeacherEditTelDTO dto = new AdminTeacherEditTelDTO();
		
		dto.setSeq(num);
		dto.setTel(tel);
		
		
		if (dao.edit_tel(dto) == 1) {
			view.header("전화번호수정성공");
		} else {
			view.header("전화번호수정성공");
		}
		

	}

	//교사삭제
	private void del() {
		view.header("교사 삭제");
		
		list();
		
		System.out.print(">> 번호 입력 : ");
		String num = scan.nextLine();

		
		 if (dao.del(num)==1) {
			 view.header("교사계정삭제성공");
		 } else {
			 view.header("교사계정삭제실패");
		 }
			
	}
	
	//기초과목 정보 조회
	private ArrayList<AdminBasicSubjectListDTO> basic_subject_list() {
		
		ArrayList<AdminBasicSubjectListDTO> list = listDao.basic_subject_list();
		
		view.header("기초과목조회");
		
		
		for (AdminBasicSubjectListDTO dto : list) {
			System.out.println("=================================================");
			System.out.println("[과목번호]	: " + dto.getSubjectNum());
			System.out.println("[과목명]		: " + dto.getSubjectName());
		}
		
		view.header("기초과목조회성공");
		
		return list;
	}
	
	//교사선택시 상세정보조회
	public void selected_list() {

		
		list();
		
		view.header("교사상세정보");
		
		System.out.print(">> 번호 선택 : ");
		ArrayList<AdminTeacherSelectedListDTO> list = listDao.selected_list(scan.nextLine());
		
		if (list.size() > 0) {
		
			for (AdminTeacherSelectedListDTO dto : list) {
				
				System.out.println("=================================================");
				System.out.println("[교사번호]\t: " + dto.getSeq());
				System.out.println("[교사이름]\t: " + dto.getName());
				System.out.println("[개설과목명]\t: " + dto.getSubjectName());
				System.out.println("[개설과목기간]\t: " + dto.getSubjectDate());
				System.out.println("[개설과정명]\t: " + dto.getCourseName());
				System.out.println("[개설과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t: " + dto.getClassroom());
				System.out.println("[교재명]\t: " + dto.getBook());
				System.out.println("[강의진행여부]\t: " + dto.getStatus());
			}
			view.header("교사상세정보조회성공");
		} else {
			view.header("검색결과X");
		}
		
	}
	
	//교사강의가능과목조회
	public ArrayList<AdminTeacherSubjectListDTO> teacher_subject_list() {
		
		ArrayList<AdminTeacherSubjectListDTO> list = listDao.teacher_subject_list();
		
		view.header("교사강의가능과목조회");
		
		for (AdminTeacherSubjectListDTO dto : list) {
			System.out.println("=================================================");
			System.out.println("[교사번호]\t: " + dto.getSeq());
			System.out.println("[교사명]\t: " + dto.getName());
			System.out.println("[과목명]\t: " + dto.getSubjectName());
		}
		view.header("교사강의가능과목조회성공");
		
		return list;
	}


}

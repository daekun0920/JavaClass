package adminstudent;

import java.util.ArrayList;
import java.util.Scanner;

import adminstudent.model.AdminStudentAddDTO;
import adminstudent.model.AdminStudentCourseListDTO;
import adminstudent.model.AdminStudentDAO;
import adminstudent.model.AdminStudentEditDTO;
import adminstudent.model.AdminStudentListDAO;
import adminstudent.model.AdminStudentListDTO;
import adminstudent.model.AdminStudentQuitDTO;
import adminstudent.model.AdminStudentSearchDTO;
import adminstudent.model.AdminStudentSelectedListDTO;
import adminstudent.model.AdminStudentStatusListDTO;
import adminstudent.view.AdminStudentView;



public class AdminStudentClass {

	private AdminStudentView view;
	private AdminStudentDAO dao;
	private AdminStudentListDAO listDao;
	private Scanner scan;
	private static String student;
	
	public AdminStudentClass() {
		view = new AdminStudentView();
		dao = new AdminStudentDAO();
		listDao = new AdminStudentListDAO();
		scan = new Scanner(System.in);
		student = "교육생";
	}
	


	
	//시작
	public void start() {
	
		boolean loop = true;
		
		while (loop) {
			view.menu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			switch (sel) {
				case 1 : add();
				break;
				case 2 : selected_list();
				break;
				case 3 : edit();
				break;
				case 4 : del();
				break;
				case 5 : search();
				break;
				case 6 : edit_enrollment_quit();
				break;
				default : loop = false; break;
				
			}
		}
	}
	//교육생추가
	private void add() {

		view.header("교육생계정 추가");
		
		System.out.print(">> 아이디 : ");
		String id = scan.nextLine();
		
		System.out.print(">> 주민번호 : ");
		String ssn = scan.nextLine();
		
		System.out.print(">> 이름 : ");
		String name = scan.nextLine();
		
		System.out.print(">> 전화번호 : ");
		String tel = scan.nextLine();
		
		ArrayList<AdminStudentCourseListDTO> courseNum = new ArrayList<AdminStudentCourseListDTO>();
		courseNum = courese_list();
		
		System.out.print(">> 과정번호 : ");
		String cnum = scan.nextLine();
		int inputCourseNumber = Integer.parseInt(cnum) - 1;
		
		AdminStudentAddDTO dto = new AdminStudentAddDTO();
		
		dto.setId(id);
		dto.setSsn(ssn);
		dto.setType(student);
		dto.setName(name);
		dto.setTel(tel);
		dto.setCseq(courseNum.get(inputCourseNumber).getCourseSeq());
		
		
		if (dao.add(dto) ==1 ) {
			System.out.println(">> 교육생계정추가성공");
		} else { 
			System.out.println(">> 교육생계정추가실패");
		}
		
	}
	//개설과정조회
	private ArrayList<AdminStudentCourseListDTO> courese_list() {
		
		ArrayList<AdminStudentCourseListDTO> list = listDao.course_list();
	
		view.header("개설과정조회");

		for (AdminStudentCourseListDTO dto : list) {
			System.out.println("==========================================");
			System.out.println("[과정번호]\t: " + dto.getCourseSeq());
			System.out.println("[과정명]\t: " + dto.getCourseName());
			System.out.println("[과정기간]\t: " + dto.getCourseDate());
			System.out.println("[강의실]\t: " + dto.getClassroom());
			System.out.println("[인원수]\t: " + dto.getPersonnel());
			System.out.println("[강의실정원]\t: " + dto.getCapacity());
		
		}
	
		view.header("개설과정조회성공");	
		return list;
	}
	
	//교육생조회
	private ArrayList<AdminStudentListDTO> list() {

		ArrayList<AdminStudentListDTO> list = listDao.list();
		
		view.header("교육생조회");
		
		for (AdminStudentListDTO dto : list) {
			System.out.println("==========================================");
			System.out.println("[교육생번호]\t: " + dto.getSeq());
			System.out.println("[교육생이름]\t: " + dto.getName());
			System.out.println("[주민번호]\t: " + dto.getSsn());
			System.out.println("[전화번호]\t: " + dto.getTel());
			System.out.println("[등록일]\t: " + dto.getRegdate().substring(0, 10));
			System.out.println("[수강신청횟수]\t: " + dto.getStatusCount());
		}
		
	
		view.header("교육생조회성공");
		return list;
	}

	//교육생상세정보
	private void selected_list() {
		list();
		
		view.header("교육생상세정보");
		
		System.out.print(">> 번호 선택 : ");
		
		ArrayList<AdminStudentSelectedListDTO> list = listDao.selected_list(scan.nextLine());
	
		if (list.size() > 0) {
			
			for (AdminStudentSelectedListDTO dto : list) {
				
				System.out.println("==========================================");
				System.out.println("[교육생번호]\t: " + dto.getSeq());
				System.out.println("[교육생이름]\t: " + dto.getName());
				System.out.println("[과정명]\t: " + dto.getCourseName());
				System.out.println("[과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t: " + dto.getClassroom());
				System.out.println("[수강현황]\t: " + dto.getStatus());
				System.out.println("[수료및중도탈락날짜]: " + dto.getStatusDate());
			}
			
			view.header("교육생상세정보조회성공");
			
		} else {
			view.header("검색결과X");
		}
		
		
	}
	
	//교육생수정
	private void edit() {

		view.header("교육생수정");
		
		
		list();
		System.out.print(">> 수정 할 교육생 번호 선택 : ");
		String num = scan.nextLine();
		
		
		System.out.print(">> 수정 할 전화번호 : ");
		String tel = scan.nextLine();
		
		AdminStudentEditDTO dto = new AdminStudentEditDTO();
		
		dto.setSeq(num);
		dto.setTel(tel);
		
		if (dao.edit(dto) == 1) {
			view.header("교육생수정성공");
		} else {
			view.header("교육생수정실패");
		}
		
	}

	//교육생삭제
	private void del() {

		view.header("교육생삭제");
		
		
		list();
		
		System.out.print(">> 교육생번호입력 : ");
		String num = scan.nextLine();
		
		System.out.print(">> 정말삭제하시겠습니까? (yes | no) : ");
		if(scan.nextLine().equals("yes")) {
			if(dao.del(num)==1) {
				view.header("교육생계정삭제성공");
			} else {
				view.header("교육생계정삭제성공");
			}
		} else {
			System.out.println("교육생계정삭제취소");
		}
		
		
		
	}

	//교육생검색
	private void search() {
		
		boolean loop = true;
		
		while(loop) {
			view.searchmenu();
			int sel = scan.nextInt();
			scan.skip("\r\n");
			switch (sel) {
			case 1: search_name();
			break;
			case 2: search_course();
			break;
			case 3: search_status();
			break;
			case 4: search_classroom();
			break;
			default : loop = false; break;
			}
		}
	}
	
	private void search_name() {
		view.header("교육생이름검색");
		
		System.out.print(">> 검색어 : ");
		
		ArrayList<AdminStudentSearchDTO> list = listDao.search(scan.nextLine());
		
		if (list.size() > 0) {
			
			for (AdminStudentSearchDTO dto : list) {
				
				System.out.println("==================================================");
				System.out.println("[교육생번호]\t: " + dto.getSeq());
				System.out.println("[교육생이름]\t: " + dto.getName());
				System.out.println("[과정명]\t\t: " + dto.getCourseName());
				System.out.println("[과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t\t: " + dto.getClassroom());
				System.out.println("[수강현황]\t: " + dto.getStatus());
				System.out.println("[수료및중도탈락여부]\t: " + dto.getStatusDate());
				
			}
		} else {
			view.header("검색결과X");
			
		}		
	}

	private void search_course() {
		view.header("과정명검색");
		
		courese_list();
		System.out.print(">> 검색어 : ");
		
		ArrayList<AdminStudentSearchDTO> list = listDao.search(scan.nextLine());
		
		if (list.size() > 0) {
			
			for (AdminStudentSearchDTO dto : list) {
				
				System.out.println("==================================================");
				System.out.println("[교육생번호]\t: " + dto.getSeq());
				System.out.println("[교육생이름]\t: " + dto.getName());
				System.out.println("[과정명]\t\t: " + dto.getCourseName());
				System.out.println("[과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t\t: " + dto.getClassroom());
				System.out.println("[수강현황]\t: " + dto.getStatus());
				System.out.println("[수료및중도탈락여부]\t: " + dto.getStatusDate());
				
			}
		} else {
			view.header("검색결과X");			
		}
		
	}

	private void search_status() {

		view.header("수강현황검색");
		
		System.out.println("[수료, 수강중, 수강예정, 중도탈락]");
		System.out.print(">> 검색어 : ");
		
		ArrayList<AdminStudentSearchDTO> list = listDao.search(scan.nextLine());
		
		if (list.size() > 0) {
			
			for (AdminStudentSearchDTO dto : list) {
				
				System.out.println("==================================================");
				System.out.println("[교육생번호]\t: " + dto.getSeq());
				System.out.println("[교육생이름]\t: " + dto.getName());
				System.out.println("[과정명]\t\t: " + dto.getCourseName());
				System.out.println("[과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t\t: " + dto.getClassroom());
				System.out.println("[수강현황]\t: " + dto.getStatus());
				System.out.println("[수료및중도탈락여부]\t: " + dto.getStatusDate());
				
			}
		} else {
			view.header("검색결과X");			
		}
		
		
	}

	private void search_classroom() {

		view.header("강의실검색");
		
		System.out.println("[1~6강의실]");
		System.out.print(">> 검색어 : ");
		
		ArrayList<AdminStudentSearchDTO> list = listDao.search(scan.nextLine());
		
		if (list.size() > 0) {
			
			for (AdminStudentSearchDTO dto : list) {
				
				System.out.println("==================================================");
				System.out.println("[교육생번호]\t: " + dto.getSeq());
				System.out.println("[교육생이름]\t: " + dto.getName());
				System.out.println("[과정명]\t\t: " + dto.getCourseName());
				System.out.println("[과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t\t: " + dto.getClassroom());
				System.out.println("[수강현황]\t: " + dto.getStatus());
				System.out.println("[수료및중도탈락여부]\t: " + dto.getStatusDate());
				
			}
		} else {
			view.header("검색결과X");			
		}
	}

	//중도탈락지정
	private void edit_enrollment_quit() {

		view.header("중도탈락지정");
		

		status_list();
		
		System.out.print(">> 교육생번호 : ");
		String seq = scan.nextLine();

		
		AdminStudentQuitDTO dto = new AdminStudentQuitDTO();
		
		
		dto.setSeq(seq);
		
		
		if (dao.quit_enrollment(dto) == 1) {
			view.header("중도탈락지정성공");
		} else {
			view.header("중도탈락지정실패");
		}
		
		
	}
	//수강중인 교육생조회
	private ArrayList<AdminStudentStatusListDTO> status_list() {
		
		ArrayList<AdminStudentStatusListDTO> list = listDao.status_list();
		
		view.header("수강중인 교육생 현황");
		
		if (list.size() > 0) {
			
			for (AdminStudentStatusListDTO dto : list) {
				
				System.out.println();
				System.out.println("==========================================");
				System.out.println();
				System.out.println("[교육생번호]\t: " + dto.getSeq());
				System.out.println("[수강생번호]\t: " + dto.getEseq());
				System.out.println("[교육생이름]\t: " + dto.getName());
				System.out.println("[과정명]\t\t: " + dto.getCourseName());
				System.out.println("[과정기간]\t: " + dto.getCourseDate());
				System.out.println("[강의실]\t\t: " + dto.getClassroom());
				System.out.println("[수강현황]\t: " + dto.getStatus());
				System.out.println("[수료및중도탈락날짜]\t: " + dto.getStatusDate());
				}
			
			view.header("수강생조회성공");
			} else {
				view.header("검색결과X");
			}
		
		
		
		return list;
	}
}
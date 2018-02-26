package adminstudent.view;

public class AdminStudentView {

	public void menu() {
	
		System.out.println("=================================================");
		System.out.println("		교육생계정관리");
		System.out.println("=================================================");
		System.out.println("\t\t1. 교육생 신규 등록");
		System.out.println("\t\t2. 교육생 목록 조회");
		System.out.println("\t\t3. 교육생 정보 수정");
		System.out.println("\t\t4. 교육생 삭제");
		System.out.println("\t\t5. 교육생 상세 검색");
		System.out.println("\t\t6. 교육생 중도탈락 지정");
		System.out.println("\t\t7. 돌아가기");
		System.out.println();
		System.out.print(">> 선택 : ");
		
	}
	
	public void header(String text) {
		System.out.println("=================================================");
		System.out.printf("		[%s]\n", text);
		System.out.println("=================================================");
	}

	public void searchmenu() {
		
		System.out.println("=================================================");
		System.out.println("		검색기능");
		System.out.println("=================================================");
		System.out.println("\t\t1. 교육생이름검색");
		System.out.println("\t\t2. 과정명검색");
		System.out.println("\t\t3. 수강현황검색");
		System.out.println("\t\t4. 강의실검색");
		System.out.println("\t\t5. 돌아가기");
		System.out.println();
		System.out.print(">> 선택 : ");
		
	}
	
	

}

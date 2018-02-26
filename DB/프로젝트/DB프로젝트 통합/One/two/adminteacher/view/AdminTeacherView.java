package adminteacher.view;

public class AdminTeacherView {

	public void menu() {

		System.out.println("=================================================");
		System.out.println("		교사계정관리");
		System.out.println("=================================================");
		System.out.println("\t\t1. 교사 신규 등록");
		System.out.println("\t\t2. 교사 목록 조회");
		System.out.println("\t\t3. 교사 정보 수정");
		System.out.println("\t\t4. 교사 삭제");
		System.out.println("\t\t5. 돌아가기");
		System.out.println();
		System.out.print(">> 선택 : ");

	}
	
	public void editmenu() {
		
		System.out.println("=================================================");
		System.out.println("		수정");
		System.out.println("=================================================");
		System.out.println("\t\t1. 전화번호 수정");
		System.out.println("\t\t2. 강의가능과목 추가");
		System.out.println("\t\t3. 돌아가기");
		System.out.println();
		System.out.print(">> 선택 : ");
	}
	
	public void header(String text) {
		System.out.println("=================================================");
		System.out.printf("		[%s]\n", text);
		System.out.println("=================================================");
	}
	
	
}

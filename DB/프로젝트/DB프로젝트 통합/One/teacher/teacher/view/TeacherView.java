package teacher.view;

public class TeacherView {

	public void menu() {
		
		System.out.println("\t\t\t\t"+">> 1. 강의 스케쥴 조회");
		System.out.println("\t\t\t\t"+">> 2. 배점 입출력");
		System.out.println("\t\t\t\t"+">> 3. 성적 관리");
		System.out.println("\t\t\t\t"+">> 4. 출결 조회");
		System.out.println("\t\t\t\t"+">> 5. 돌아가기");
		System.out.println();
		
		System.out.print("\t\t\t\t"+">> 선택 : ");
		
	}

	public void closeGrading() {
		System.out.println(">> 배점조회를 마치고 이전으로 돌아갑니다.");
		System.out.println("=============================================================");
	}

	public void inputRequest() {
		System.out.println("=============================================================");
		System.out.println();
		System.out.println(">> 종료를 입력하시면 이전메뉴로 돌아갑니다.");
		System.out.print(">> 배점조회를 하시려면 해당 과목번호를 입력하세요 : ");
		
	}

	public void closeScore() {
		System.out.println(">> 성적관리를 종료합니다. 이전 메뉴로 돌아갑니다.");
		System.out.println("=============================================================");
		System.out.println("\r\n\r\n");
		
	}

	public void commentStartForListAtt(String txt) {
		System.out.println("\t\t\t\t"+">>"+txt);
		
	}

	public void center(String txt) {
		System.out.println("\t\t\t\t"+">>"+txt);
		
	}

	public void inputcenter(String txt) {
		System.out.print("\t\t\t\t"+">>"+txt);
		
	}

	public void endFor() {
		System.out.println();
		System.out.println("=============================================================");
		System.out.println();
		
	}


}

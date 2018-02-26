package adminsubjectview;

public class SubjectView {

	public void menu() {

		System.out.println("==================================================================");
		System.out.println("			[개설과목관리]");
		System.out.println("==================================================================");
		System.out.println("			1.개설 과목 조회");
		System.out.println("			2.특정 과목 조회");
		System.out.println("			3.개설 과목 등록");
		System.out.println("			4.개설 과목 수정");
		System.out.println("			5.개설 과목 삭제");
		System.out.println("			6.돌아가기");
		System.out.println("==================================================================");
		System.out.println();
		System.out.print("		[번호선택] : ");
	}

	public void header(String text) {

		System.out.printf("[%s]\n", text);

	}

	public void result(String text) {

		System.out.printf("%s\n", text);

	}

}

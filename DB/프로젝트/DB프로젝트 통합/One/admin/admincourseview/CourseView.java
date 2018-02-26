package admincourseview;

public class CourseView {

	public static void menu() {

		System.out.println("==================================================================");
		System.out.println("			[개설과정관리]");
		System.out.println("==================================================================");
		System.out.println("			1.개설 과정 조회");
		System.out.println("			2.특정 개설 과정");
		System.out.println("			3.개설 과정 등록");
		System.out.println("			4.개설 과정 수정");
		System.out.println("			5.개설 과정 삭제");
		System.out.println("			6.수료 날짜 지정");
		System.out.println("			7.돌아가기");
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

package member.view;

public class MemberView {

	public void menu() {
		
		System.out.println("\r\n\r\n\t\t\t\t"+"1. 로그인");
		System.out.println("\t\t\t\t"+"2. 로그아웃");
		System.out.println("\t\t\t\t"+"3. 돌아가기");
		System.out.println();
		System.out.print("\t\t\t\t"+"선택 : ");
	}

	public void close() {

		System.out.println("\r\n");
		System.out.println("\r\n");
		
	}

	public void center(String txt) {
		System.out.println("\t\t\t\t"+">>"+txt);
		
	}

}

package actor;

import java.util.Scanner;

public class Admin extends Member {
	Admin(String memberId, String memberPw, String memberType) {
		super(memberId, memberPw, memberType);
	}

	private static Scanner scan;
	
	// get set reason private reason
	static {
		scan = new Scanner(System.in);
	}
	public static void adminScreen() {
		boolean loop = true;
		
		while (loop) {

			String sel = Title.adminScreenPt();
			
			if (sel.equals("1")) {
				Business.clearScreen(); // 화면 넘기기 메소드 
				storePlus(Business.m);//가게추가
			} else if (sel.equals("2")) {
				Business.clearScreen();
				storeDel();//가게삭제
			} else if (sel.equals("3")) {
				Business.clearScreen();
				memberOn(DataBase.memberList);//회원목록
			} else if (sel.equals("4")) {
				Business.clearScreen();
				memberOff();//회원삭제
			} else if (sel.equals("5")) {
				Business.clearScreen();
				BoardList.pageView(DataBase.boardList);
				//게시판조회메소드
			} else if (sel.equals("6")) {
				Business.clearScreen();
				BoardList.myBoardDelete(Business.m);
				//게시판삭제메소드
			} else if (sel.equals("7")){
				Business.m = null;
				Business.clearScreen();
				System.out.println("로그아웃 되었습니다.");
				Business.startScreen();	
			} else {
				Business.clearScreen();
				System.out.println("올바른 숫자를 입력해주세요.");
				adminScreen();
			}
		}

		System.out.println("프로그램 종료");
		
	}
}

package actor;

import java.util.ArrayList;
import java.util.Scanner;

import dataTable.StoreTable;

public class Owner extends Member {
	static Scanner sc;
	static ArrayList<StoreTable> storeTmp;
	
	static {
		sc = new Scanner(System.in);
		storeTmp = DataBase.storeList;
	}
	
	Owner(String memberId, String memberPw, String memberType) {
		super(memberId, memberPw, memberType);		
	}
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

	
	static void ownerMenu(Member m) {
		while (true) {
			Owner o = (Owner)m; // 자식 메소드를 사용하기 위한 다운 캐스팅
			String sel = Title.ownerMenuPt(o);
			
			if (sel.equals("1")) {
				clearScreen();
				o.storeAdd();
			} else if (sel.equals("2")) {
				clearScreen();
				o.storeDel();
			} else if (sel.equals("3")) {
				clearScreen();
				o.menuAdd();
			} else if (sel.equals("4")) {
				clearScreen();
				o.menuDel();
			} else if (sel.equals("0")) {
				m = null;
				clearScreen();
				System.out.println("로그아웃 되었습니다.");
				startScreen();
			} else if (sel.equals("5")) {
				
				clearScreen();
				o.tagAdd();
			} else if (sel.equals("6")) {
				
				clearScreen();
				o.tagDel();
			} else if (sel.equals("7")) {
				
				clearScreen();
				BoardList.pageView(BoardList.boardList);
			} else if (sel.equals("8")) {
				clearScreen();
				BoardList.myBoardWrite(m);
				
				clearScreen();
				System.out.println("게시물 작성이 완료되었습니다.");
				toBoard();
			} else if (sel.equals("9")) {
				clearScreen();
				BoardList.myBoardDelete(m);
			} else if (sel.equals("10")) {
				clearScreen();
				BoardList.myBoardModify(m.getMemberId());
			} else {
				clearScreen();
				System.out.println("올바른 번호를 입력해주세요.");
				
			}
		}		
	} // ownerMenu()
}

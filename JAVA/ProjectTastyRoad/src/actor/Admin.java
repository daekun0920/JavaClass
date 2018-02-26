package actor;


import java.util.ArrayList;
import java.util.Scanner;

import dataTable.Board;
import dataTable.MemberTable;
import dataTable.StoreTable;



public class Admin extends Member {

	Admin(String memberId, String memberPw, String memberType) {
		super(memberId, memberPw, memberType);
	}

	private static Scanner scan;
	
	
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
	
	public static void storePlus(Member m) { // 가게등록

		Business.title("가게등록");
		String storeId = "";
		String storeName = "";
		String storeAddress = "";
		String storeCategory = "";
		String storeTel = "";
		Integer favorite = 0;
		String storeTag = "";
		
		String menuName = "";
		String menuPrice = "";
		String singleMenu = "";
		
		String totalMenu = "";
		
		if (m.getMemberType().equals("점주")) {
			while (true) {
				System.out.print("아이디(점주) : ");
				storeId = scan.nextLine();
	
				if (storeId.length() >= 8 && storeId.length() <= 15) {
					break;
				} else {
					System.out.println("8 ~ 15 글자 사이로 입력해주세요.");
				}
			}
		} else {
			storeId = m.getMemberId();
		}
		
		while (true) {
			System.out.print("상호명 : ");
			storeName = scan.nextLine();

			if (storeName.length() >= 3 && storeName.length() <= 15) {
				break;
			} else {
				System.out.println("3 ~ 15 글자 사이로 입력해주세요.");
			}
		}

		while (true) {
			System.out.print("주소 : ");
			storeAddress = scan.nextLine();
			if (storeAddress.length() >= 6 && storeAddress.length() <= 30) {
				break;
			} else {
				System.out.println("6 ~ 30 글자사이로 입력해주세요.");
			}
		}

		while (true) {
			System.out.println("한식,중식,일식,양식,분식 중 입력해주세요.");
			System.out.print("음식 카테고리를 입력해 주세요 : ");
			storeCategory = scan.nextLine();

			if (storeCategory.equals("한식")) {
				break;
			}
			if (storeCategory.equals("양식")) {
				break;
			}
			if (storeCategory.equals("중식")) {
				break;
			}
			if (storeCategory.equals("일식")) {
				break;
			}
			if (storeCategory.equals("분식")) {
				break;
			} else {
				System.out.println("올바른 카테고리를 다시 입력해 주세요.");
			}
		}

		while (true) {
			System.out.print("전화번호 : ");
			storeTel = scan.nextLine();
			if (storeTel.length() >= 8 && storeTel.length() <= 11) {
				break;
			} else {
				System.out.println("8 ~ 11 글자 사이로 입력해주세요.");
			}
		}
		
		String str = "";
		
		while (true) {
			System.out.println("예) 맛있는, 혼밥가능, 포장가능, 줄서서먹는, 셀프바");
			System.out.print("맛집 태그 입력: ");
			for (int j = 0; j < 1; j++) {
				str = scan.nextLine();
				if (str.length() < 3 && str.length() > 10) {
					System.out.println("3 ~ 10 글자 사이로 입력해주세요.");
					j--;
					continue;
				} 
				storeTag = storeTag + str + ";";
			}
			break;
		}
		
	
		while (true) {
			System.out.println("예) \"만두라면 15,000원\"");

			for (int k = 0; k < 1; k++) {
				System.out.print("메뉴 입력 : ");
				menuName = scan.nextLine();// 메뉴명
				System.out.print("가격 입력 : ");
				menuPrice = scan.nextLine();// 가격
				
				if (menuName.length() < 4 || menuName.length() > 10) {
					Business.clearScreen();
					System.out.println("메뉴는 4 ~ 10글자 사이로 입력해주세요.");
					k--;
					continue;
				}
				if (menuPrice.length() < 4 || menuPrice.length() > 7) {
					Business.clearScreen();
					System.out.println("가격은 4 ~ 7글자 사이로 입력해주세요.");
					k--;
					continue;
				}
				menuPrice = menuPrice.replace("원", "");
				Integer price = Integer.parseInt(menuPrice);
				singleMenu = (String.format("%s-%,d", menuName, price)) + "원" + ";";
				totalMenu = totalMenu + singleMenu;
			}
			
			break;
		}
		
		StoreTable s = new StoreTable(storeId
								   , storeName
								   , storeAddress
								   , storeCategory
								   , storeTel
								   , favorite
								   , storeTag
								   , totalMenu);
		DataBase.storeList.add(s);
	
		Business.clearScreen();
		System.out.println("입력이 완료되었습니다.");
		
	} // storePlus
	
		

	public static void storeDel() {// 가게삭제

		Business.title("가게삭제");

		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("상호명 : ");
		String storeName = scan.nextLine();
		
		
		for (StoreTable s : DataBase.storeList) {
			
			if (s.getStoreId().equals(id) && s.getStoreName().equals(storeName)) {
				
				DataBase.storeList.remove(s);
				
				Business.clearScreen();
				System.out.println("삭제가 완료되었습니다.");
				adminScreen();
			}
			
		}
		System.out.println("올바른 정보를 입력해 주세요.");
		
	} // storeDel()

	public static void memberOn(ArrayList<MemberTable> list) {// 회원목록
		BoardList.pageView(list);
		
		adminScreen();
	}

	public static void memberOff() {// 회원삭제
		Business.clearScreen();
		Business.title("회원삭제");

		System.out.print("아이디 : ");
		String id = scan.nextLine();

		for (MemberTable m : DataBase.memberList) {
			if (m.getUserId().equals(id)) {
				DataBase.memberList.remove(m);
				System.out.println("회원정보가 삭제되었습니다.");
				adminScreen();
			}
		}
		System.out.println("올바른 정보를 입력해 주세요.");
		memberOff();

	}

}

package actor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/* 작성자 : 한대건 
 * 
 * 사용된 메소드 목록  *
 * 
 * 각 페이지 마다 while문으로 묶어주면 돌아오기 편하다 (System.exit 사용 필요 없)
 * 
 * main()
 * 
 * dataLoad() - 데이터 불러오기 
 * startScreen() - 초기 화면
 * register() - 회원 가입 초기화면
 * memberRegister() - 회원 가입 메인 창 
 * validCheck() - 회원 가입 정보 유효성 검사 
 * logIn() - 로그인 
 * getStore() - 자기 식당 객체 리턴 
 * memberMenu() - 일반 회원 메인 화면
 * adjustMyInfo() - 일반 회원 내 정보 수정
 * title() - 각 페이지 헤드 찍어주기 
 * deRegister() - 회원 탈퇴
 * ownerMenu() - 점주 회원 메인 화면
 * searchList() - 검색 초기 화면 
 * localSearch() - 지역 별 검색
 * totalSearch() - 통합 검색 
 * checkAndSearch() - 통합 검색 조건 별 분류 -> 각 식당 정보 인덱스 찍어주기 
 * checkPush() - 각 식당 정보 인덱스 찍어주기 
 * categorySearch() - 음식 종류별 검색 
 * wishReservePage() - 위시리스트 저장, 예약, 페이지 이동 
 * clearScreen() - 페이지 전환 
 * toBoard(); 게시판 이용 화면 
 */

import javax.swing.plaf.synth.SynthSeparatorUI;

import dataTable.MemberTable;
import dataTable.Reservation;
import dataTable.StoreTable;
import dataTable.Wish;

/*
 
 프로그램 종료시 수정사항 전부 덮어쓰기
 검색 결과 페이지 이동 구현
 회원 : 예약, 위시리스트, 페이지 이동
 비회원 : 페이지 이동 
 
 인터페이스 부모타입으로 업캐스팅 된 상태에서 자식 메소드를 사용가능한가?
 
 TODO 게시판 글 작성시 작성 날짜 % 시간 포맷 변경해야함
 TODO 프로그램 종료시 
 
 771 통합검색 
  
 */ 

public class Business {
	public static Scanner scan;
	static ArrayList<MemberTable> memberList; // 모든 회원(일반, 점주, 관리자 포함) 담은 리스트(프로그램 시작시 모두 읽어들임)
	public static ArrayList<StoreTable> storeList; // 모든 가게 정보를 담은 리스트 
	static int wrongPw; // 아이디 혹은 비밀번호 틀린횟수 카운트
	
	static Member m;
	
	static final String strMember = "회원";
	static final String strOwner = "점주";
	static final String strAdmin = "관리자";
	
	static {
		wrongPw = 0;
		
		scan = new Scanner(System.in);
		memberList = new ArrayList<MemberTable>();
		storeList = new ArrayList<StoreTable>();
	}
	
	public static void main(String[] args) {
		//dataLoad();
		
		DataBase.boardListLoad();
		DataBase.memberListLoad();
		DataBase.reservationListLoad();
		DataBase.storeListLoad();
		DataBase.wishListLoad();
		
		startScreen();
	}

//	private static void dataLoad() {
//		String path = "./src/회원통합.txt"; // 프로젝트 단위 상대경로 ( . = 현재 이 클래스가 속한 프로젝트)
//		try { // 회원 정보 읽어오기 
//			BufferedReader reader = new BufferedReader(new FileReader(path));
//			String line = "";
//			while ((line = reader.readLine()) != null) {
//				//knbdq097	rzcjby31	[점주]	황민민	1971년1월23일	010-9818-2342	knbdq097@naver.com
//				
//				String[] memberArray = line.split("\t");
//		
//				MemberTable m = new MemberTable(memberArray[0].trim()
//											  , memberArray[1].trim()
//											  , memberArray[2].trim()
//											  , memberArray[3].trim()
//											  , memberArray[4].trim()
//											  , memberArray[5].trim()
//											  , memberArray[6].trim());
//				memberList.add(m);	
//			}
//			reader.close();
//		} catch (Exception e) {
//			System.out.println("회원 정보를 읽어올 수 없습니다.");
//		}
//		
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("dataLoad : " + e.toString());
//		}
//	} // dataLoad()

	public static void startScreen() {
		
		boolean loop = true;
		while (loop) {
			title("Tasty_Road! (ver 0.1)");
			System.out.println("	1. 회원 로그인");
			System.out.println("	2. 비회원으로 로그인");
			System.out.println("	3. 회원 가입");
			System.out.println("	0. 프로그램 종료");
			System.out.println("==============================");
			System.out.print("원하시는 번호를 선택해주세요 : ");
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				clearScreen();
				logIn();
			} else if (sel.equals("2")) {
				String anony = "비회원";
				m = new Member(anony, anony, anony);
				
				clearScreen();
				searchList();
			} else if (sel.equals("3")) {
				clearScreen();
				register();
			} else if (sel.equals("0")) {
				clearScreen();
				
				// 프로그램 종료전 변경사항 메모장에 모두 덮어쓴후 종료해야함 
				saveChanges();
				scan.close();
				System.out.println("프로그램을 종료했습니다.");
				System.exit(0);
			} else {
				clearScreen();
				System.out.println("올바른 번호를 입력해주세요.\n");
			}
		} // while 
	} // startScreen (초기 화면)
	
	private static void saveChanges() { // 변경 내용 저장(프로그램 종료시)
		DataBase.reservationListSave();
		DataBase.memberListSave();
		DataBase.boardListSave();
		DataBase.wishListSave();
		DataBase.storeListSave();
	}
		
	private static void register() { // 회원가입
		title("회원 가입");
		System.out.println();
		System.out.println("   1. 일반 회원으로 가입");
		System.out.println();
		System.out.println("   2. 점주로 가입");
		System.out.println();
		System.out.println("==============================");
		System.out.print("   번호를 입력해주세요 : ");
		String sel = scan.nextLine();
		
		if (sel.equals("1")) {
			clearScreen();
			memberRegister("일반");
		} else if (sel.equals("2")) {
			clearScreen();
			memberRegister(strOwner);
		} else {
			clearScreen();
			System.out.println("올바른 번호를 입력해주세요.");
			register();
		}
		
	} // register()

	private static void memberRegister(String userType) {
		String userId = "";
		String userPw = "";
		String userName = "";
		String userBirth = "";
		String userTel = "";
		String userEmail = "";
		
		title(String.format(" %s 회원으로 가입", userType));
		Title.memberRegPt(userId, userPw, userName, userBirth, userTel, userEmail);
		
		if (userType.equals("일반")) {
			userType = strMember;
		}
		
		validCheck(userId, userPw, userName, userBirth, userEmail, userType); // 다시 되돌아오면 유효성 검사 통과 
		
		
		MemberTable m = new MemberTable(userId, userPw,  userType, userName, userBirth, userTel, userEmail);
		memberList.add(m);
		
		clearScreen();
		System.out.println("회원 가입이 완료 되었습니다.");
		
	} // memberRegister()
	
	private static void validCheck(String userId
								 , String userPw
								 , String userName
								 , String userBirth
								 , String userEmail
								 , String userType) {
		// 아이디 대소문자 검사 
		// 48 ~ 57 숫자
		// 65 ~ 90 대문자
		// 97 ~ 122 소문자 
		Boolean flag = false;
		for (int i = 0; i < userId.length(); i++) {
			char id = userId.charAt(i);
			if ((id < 48 || id > 57) 
			 || (id < 65 || id > 90)
			 || (id < 97 || id > 122)) {
				flag = true;
			}
			
		}
		
		// 생년월일 유효성 검사 하기 쉽게 변환
		// 생년월일 형식 : 1995년9월20일 d
		userBirth = userBirth.replace("년", "/");
		userBirth = userBirth.replace("월", "/");
		userBirth = userBirth.replace("일", "");
		
		String[] userBirthArray = userBirth.split("/"); // 생년월일 각각 잘라서 배열에 삽입
		
		boolean leapFlag = false; // 윤년 여부 
		boolean dateFlag = false; // 날짜 유효 여부 
		
		// 날짜 유효성 검사 /////////
		int year = Integer.parseInt(userBirthArray[0]);
		int day = Integer.parseInt(userBirthArray[2]);
		
		if ((year % 4 == 0 && year % 100 == 0) || year % 400 == 0) {
			leapFlag = true;
		} 
		
		if ("1,3,5,7,8,10,12".contains(userBirthArray[1])) {
			if (!(day > 0) || !(day < 32)) {
				dateFlag = true;
			}
		} else if ("4,6,9,11".contains(userBirthArray[1])) {
			if (!(day > 0) || !(day < 31)) {
				dateFlag = true;
			}
		} else if ("2".equals(userBirthArray[1]) && leapFlag == false) {
			if (day > 28) {
				dateFlag = true;
			}
		}
		////////////////////////
		
		// 이메일 유효성 검사 ////////
		boolean emailFlag = false;
		String fixedEmail = userEmail;
		for (int i = 0; i < userEmail.length(); i++) {
			char email = userEmail.charAt(i);
			if ((email < 48 || email > 57) 
			 || (email < 65 || email > 90)
			 || (email < 97 || email > 122)) {
				emailFlag = true;
			}
			
		}
		
		String[] smallArray = {"a", "b", "c","d","e","f","g","h","i","j","k","l","m","n"
								,"o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z",};
		String[] numsArray = {"1","2","3","4","5","6","7","8","9","0"};
		for (String s : smallArray) {
			fixedEmail = fixedEmail.replace(s, "");
		}
		
		for (String s : numsArray) {
			fixedEmail = fixedEmail.replace(s, "");
		}
		if (!(fixedEmail.equals("@."))) {
			emailFlag = true;
		}
		////////////////////////
		
		// 유효하지 않을시 
		if (!(userId.length() > 7 && userId.length() < 16) || flag) {
			clearScreen();
			System.out.println("아이디는 8~15자 이내, 영소문자만 사용해야 합니다.");
			memberRegister(userType);
		} else if (userPw.contains(" ")) {
			clearScreen();
			System.out.println("비밀번호에는 공백이 들어갈 수 없습니다.");
			memberRegister(userType);
		} else if (userName.contains(" ")) {
			clearScreen();
			System.out.println("이름에는 공백이 들어갈 수 없습니다.");
			memberRegister(userType);
		} else if (dateFlag) {
			clearScreen();
			System.out.println("올바르지 않은 날짜입니다.");
			memberRegister(userType);
		} else if (emailFlag) {
			clearScreen();
			System.out.println("올바르지 않은 이메일 입니다.");
			memberRegister(userType);
		}
	} // validcheck()
	
	/*
	 * 
	 * 작성자 : 한대건 
	 * 
	 */
	
	private static void logIn() {
		while (true) {
			title("로그인");
			System.out.println();
			System.out.print("	아이디 : ");
			String UserId = scan.nextLine();
			System.out.println();
			System.out.print("	비밀번호 : ");
			String UserPw = scan.nextLine();
			System.out.println();
			
			for (MemberTable e : memberList) {
				if (e.getUserId().equals(UserId) && e.getUserPw().equals(UserPw)) {
					String type = e.getMemberType();
					
					if (type.equals(strMember)) {
						m = new BasicMember(UserId, UserPw, type);
						
						clearScreen();
						System.out.printf("  %s 님이 일반 회원으로 로그인 하셨습니다.\n", UserId);
						memberMenu();
					} else if (type.equals(strOwner)) {
						m = new Owner(UserId, UserPw, type);
						
						clearScreen();
						System.out.printf("  %s 님이 점주 회원으로 로그인 하셨습니다.\n", UserId);
						ownerMenu();
					} else if (type.equals(strAdmin)) {
						m = new Admin(UserId, UserPw, type);
						
						clearScreen();
						System.out.printf("  %s 님이 관리자로 로그인 하셨습니다.\n", UserId);
						Admin.adminScreen();
					}
				} // if 
				if ((e.getUserId().equals(UserId) && !e.getUserPw().equals(UserPw)) ||
					(!e.getUserId().equals(UserId) && e.getUserPw().equals(UserPw))) { 
					wrongPw++; 
					clearScreen();
					System.out.printf("아이디 혹은 비밀번호 %d / 3회 오류입니다.\n", wrongPw);
					// 비밀번호 3번 틀리면 비밀번호 찾기로 가기
					if (wrongPw == 3) {
						wrongPw = 0;
						System.out.println("초기 화면으로 돌아갑니다.");
						startScreen();
					}
					logIn();
				}  // if 
				
			} // for 
			
			clearScreen();
			System.out.println("존재하지 않는 계정 입니다.");
			logIn();
		}
	} // logIn()

	static void ownerMenu() {
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

	public static void memberMenu() { // 5. 일반 회원 로그인 대기 탭 
		while (true) {
			String sel = Title.memberMenuPt(m);
			
			if (sel.equals("1")) { // 맛집 검색
				clearScreen();
				searchList();
			} else if (sel.equals("2")) { // 게시판 이용하기
				clearScreen();
				toBoard(); // 게시판 메뉴로 이동 
			} else if (sel.equals("3")) { // 내 예약 목록 조회 (reserveList)
				clearScreen();
				Reservation.reserveLoad(m);
			} else if (sel.equals("4")) { // 내 위시리스트 (wishList)
				clearScreen();
				Wish.wloadDelete(m);
			} else if (sel.equals("5")) { // 내 정보 수정 (전화번호, 생년월일)
				clearScreen();
				adjustMyInfo();
			} else if (sel.equals("6")) { // 로그아웃
				m = null;
				clearScreen();
				System.out.println("로그아웃 되었습니다.");
				startScreen();
			} else if (sel.equals("7")) {
				clearScreen();
				deRegister();
			} else { 
				clearScreen();
				System.out.println("올바른 번호를 입력해주세요.");
			}
		}
	}

	static void toBoard() {
		
		String sel = Title.toBoardPt();
		
		
		if (sel.equals("1")) {
			BoardList.myBoardWrite(m);
			
			clearScreen();
			System.out.println("게시물 작성이 완료되었습니다.");
			toBoard();
		} else if (sel.equals("2")) {
			
			clearScreen();
			BoardList.myBoardDelete(m);
		} else if (sel.equals("3")) {
			
			clearScreen();
			BoardList.myBoardModify(m.getMemberId());
		} else if (sel.equals("4")) {
			
			clearScreen();
			BoardList.pageView(BoardList.boardList);
		} else if (sel.equals("0")) {
			// 일반, 점주  
			
		} else {
			clearScreen();
			System.out.println("올바른 번호를 입력해주세요");
			toBoard();
		}
	}

	private static void adjustMyInfo() {
		title("내 정보 수정");
		System.out.println();
		System.out.print("   전화번호 : ");
		String newNum = scan.nextLine();
		System.out.println();
		System.out.print("   생년월일 : ");
		String newBirth = scan.nextLine();
		
		for (MemberTable e : memberList) {
			if (e.getUserId().equals(m.getMemberId())) {
				e.setUserTel(newNum);
				e.setUserBirth(newBirth);
				
				clearScreen();
				System.out.println("내 정보 수정이 완료되었습니다.");	
				memberMenu();
			}
		}
		
	} // adjustMyInfo
	
	
	
	private static void deRegister() { // 탈퇴 
		title("회원 탈퇴");
		System.out.println();
		System.out.print("   아이디 : ");
		String userId = scan.nextLine();
		System.out.println();
		System.out.print("   비밀번호 : ");
		String userPw = scan.nextLine();
		System.out.print("   이름 : ");
		String userName = scan.nextLine();
		System.out.println();
	    System.out.println("   예) 1995년3월12일");
		System.out.print("   생년월일 : ");
		String userBirth = scan.nextLine();
		System.out.println("==============================");
		System.out.print("   정말로 탈퇴하시겠습니까? Y / N : ");
		String yesOrNo = scan.nextLine();
		
		if (yesOrNo.equals("Y")) {
			for (MemberTable e : memberList) {
				if (e.getUserId().equals(userId) && e.getUserPw().equals(userPw)
					&& e.getUserBirth().equals(userBirth) && e.getUserName().equals(userName)) {
					memberList.remove(e);
					
					clearScreen();
					System.out.println("   성공적으로 탈퇴하였습니다.");
					startScreen();
				}
			}
			
			clearScreen();
			System.out.println("올바르지 않은 정보를 입력하셨습니다.");
			deRegister();
		} else if (yesOrNo.equals("N")) {
			clearScreen();
			System.out.println("메뉴 화면으로 돌아갑니다."); 
			memberMenu();
		}
	} // deRegister

	static void searchList() { // 맛집 검색 선택 탭 
		while (true) {
			title("맛집 검색하기");
			System.out.println();
			System.out.println("1. 지역 별 검색");
			System.out.println();
			System.out.println("2. 음식 종류 별 검색");
			System.out.println();
			System.out.println("3. 통합 검색");
			
			if (m.getMemberType().equals("비회원")) {
				System.out.println();
				System.out.println("4. 게시판 조회");
				System.out.println();
				System.out.println("5. 게시글 작성");
			}
			
			System.out.println();
			System.out.println("0. 뒤로 돌아가기");
			System.out.println("==============================");
			System.out.print("원하시는 검색을 선택해주세요 : ");
			String sel = scan.nextLine();
			
			if (sel.equals("1")) { // 지역 별 검색
				clearScreen();
				localSearch();
			} else if (sel.equals("2")) { // 음식 종류 별 검색
				clearScreen();
				categorySearch();
			} else if (sel.equals("3")) { // 통합 검색
				clearScreen();
				totalSearch();
			} else if (sel.equals("0")) { // 뒤로 돌아가기
				if (m.getMemberType().equals(strMember)) {
					clearScreen();
					memberMenu();
				} else { 				   // 비회원 일때
					clearScreen();
					startScreen();
				}
			} else if (m.getMemberType().equals("비회원") && sel.equals("4")) {
				clearScreen();
				System.out.println(BoardList.boardList.size()); 
				
				BoardList.pageView(BoardList.boardList);
			} else if (m.getMemberType().equals("비회원") && sel.equals("5")) {
				BoardList.myBoardWrite(m);
				
				clearScreen();
				System.out.println("게시글 작성이 완료 되었습니다.");
			}
			
		}
		
	} // searchList()

	private static void totalSearch() {
		String tags = "";
		
		title("통합검색");
		System.out.println("	지역 예) \"강남구\"");
		System.out.print("	지역 : ");
		String area = scan.nextLine();
		System.out.println("	종류 예) \"한식\"");
		System.out.print("	종류 : ");
		String category = scan.nextLine();
		System.out.println("   태그 예) 혼밥가능, 친구모임");
		System.out.println("   5개 이하는 입력 후 \"완료\"를 입력해주세요.");
		
		for (int i = 0; i < 5; i ++) {
			System.out.printf("	 태그 %d / 5개 : ", i);
			String tag = scan.nextLine();
			if (tag.equals("완료")) {
				break;
			}
			tags = tags + tag + ";";
		}
		if (tags.replace(";", "").equals("")) { // 빈 태그가 인지 확인 
			tags.replace(";", "");
		}
		System.out.println();
		System.out.println("==============================");
		
		HashMap<String, String> elements = new HashMap<String, String>(); // 검색 조건과 해당 검색어 저장 
		if (area.length() > 1) { // 지역에 값이 들어있다면 
			elements.put("storeAddress", area);
		} 
		if (category.length() > 1) {
			elements.put("storeCategory", category);
		} 
		if (tags.length() > 2) {
			elements.put("tag", tags);
		} 
		clearScreen(); // 화면 넘기기 
		checkAndSearch(elements);
	}

	public static void checkAndSearch(HashMap<String, String> elements) {
		
		int i = 0;
		ArrayList<String> list = new ArrayList<String>(); // 인덱스 붙은 정보들 
		ArrayList<String> listNames = new ArrayList<String>(); // 이름만 따로 저장 
		if (elements.size() == 0) {
			System.out.println("다시 입력해주세요.");
			totalSearch();
		} else if (elements.size() == 1) { 				// 조건이 한가지만 들어갔을때
			System.out.println("검색 결과");
			if (elements.containsKey("storeAddress")) { // 그 조건이 지역별 일때
				for (StoreTable s : storeList) {
					System.out.println(storeList.size());
					if (s.getStoreAddress().contains(elements.get("storeAddress"))) {
						i = checkPush(i, list, listNames, s);  
					}
				}
			} else if (elements.containsKey("storeCategory")) {
				for (StoreTable s : storeList) {
					if (s.getStoreCategory().equals(elements.get("storeCategory"))) {
						i = checkPush(i, list, listNames, s);  
					}
				}
			} else if (elements.containsKey("tag")) {
				String[] temp = elements.get("tag").split(";");
				int count = 0;
				for (StoreTable s : storeList) {
					for (int j = 0; j < temp.length; j++) { 
						if (s.getTag().contains(temp[j])) {
							count++;
							
							if (count == temp.length) {
								i = checkPush(i, list, listNames, s);  
							}  
						}
					}
				}
			}
		} else if (elements.size() == 2) { 				// 조건이 두가지 들어있을때
			System.out.println("검색 결과");
			if (elements.containsKey("storeAddress") && elements.containsKey("storeCategory")) { // 그 조건이 지역별 & 음식 종류일때
				
				for (StoreTable s : storeList) {
					if (s.getStoreAddress().contains(elements.get("storeAddress")) 
						&& s.getStoreCategory().equals(elements.get("storeCategory"))) {
						
						
							i = checkPush(i, list, listNames, s);  
					}
				}
			} else if (elements.containsKey("storeAddress") && elements.containsKey("tag")) { // 그 조건이 지역별 & 태그 일때
				String[] temp = elements.get("tag").split(";");
				int count = 0;
				for (StoreTable s : storeList) {
					for (int j = 0; j < temp.length; j++) {
						if (s.getStoreAddress().contains(elements.get("storeAddress")) 
								&& s.getTag().contains(temp[j])) {
							count++;
							
							if (count == temp.length) {
								i = checkPush(i, list, listNames, s);  
							}
						}
					}
					count = 0;
				}
			} else if (elements.containsKey("storeCategory") && elements.containsKey("tag")) { // 그 조건이 음식 종류 & 태그 일때
				String[] temp = elements.get("tag").split(";");
				
				int count = 0;
				
				for (StoreTable s : storeList) {
					for (int j = 0; j < temp.length; j++) {
						if (s.getStoreCategory().contains(elements.get("storeCategory")) 
							&&  s.getTag().contains(temp[j])) {
							count++;
							
							if (count == temp.length) {
								i = checkPush(i, list, listNames, s);  
							} 
						}
					}	
					count = 0;
				}
			}
		} else if (elements.size() == 3) { // 모든 조건이 들어있을때
		
			System.out.println("검색 결과");
			
			String[] temp = elements.get("tag").split(";");
			
			int count = 0;
			
			for (StoreTable s : storeList) {
				for (int j = 0; j < temp.length; j++) {
					
					if (s.getStoreAddress().contains(elements.get("storeAddress"))  
						&& s.getStoreCategory().equals(elements.get("storeCategory"))
						&& s.getTag().contains(temp[j])) {

						count++;
						
						if (count == temp.length) {
							i = checkPush(i, list, listNames, s);  
						}
					}
				}
				count = 0;
			}
		}
	

		if (m.getMemberType().equals(strMember)) { // 회원 
			BoardList.pageView(list, listNames, m);
			memberMenu();
			
		} 
		BoardList.pageViewExt(list); // 비회원
	} // checkAndSearch()

	public static int checkPush(int i, ArrayList<String> list, ArrayList<String> listNames, StoreTable s) {
		i++; // 인덱스 증가
		String comp = i + ". " + s.toString(); // 1. [toString] 
		listNames.add(s.getStoreName()); // 나중에 찾기 위해 이름만 따로 저장 
		list.add(comp); // 존재 검사를 위한 리스트에 저장 
		return i;
	} // checkPush

	private static void categorySearch() {
		title("음식 종류별 검색");
		System.out.println();
		System.out.println("	1. 한식");
		System.out.println();
		System.out.println("	2. 일식");
		System.out.println();
		System.out.println("	3. 중식");
		System.out.println();
		System.out.println("	4. 양식");
		System.out.println();
		System.out.println("	5. 분식");
		System.out.println();
		System.out.println("==============================");
		System.out.println("   예) \"1\" or \"한식\" ");
		System.out.print("원하시는 종류를 선택해주세요 : ");
		String category = scan.nextLine();
		
		if (category.equals("1")) {
			category = "한식";
		} else if (category.equals("2")) {
			category = "일식";
		} else if (category.equals("3")) {
			category = "중식";
		} else if (category.equals("4")) {
			category = "양식";
		} else if (category.equals("5")) {
			category = "분식";
		} 
		
		System.out.printf("   \"%s\" 검색 결과입니다.\n", category);
		clearScreen();
		int i = 0; // 인덱스 붙혀주기 
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listNames = new ArrayList<String>();
		for (StoreTable s : storeList) {
			
			if (s.getStoreCategory().equals(category)) {
				i = checkPush(i, list, listNames, s);
			}
		}
		
		if (m.getMemberType().equals(strMember)) { // 회원 
			BoardList.pageView(list, listNames, m);
			memberMenu();
			
		} 
		BoardList.pageViewExt(list); // 비회원
	} // categorySearch()

	private static void localSearch() { // 지역 별 검색
		
		System.out.println("==============================");
		System.out.println("	지역 별 맛집 검색");
		System.out.println("==============================");
		System.out.println("ㄱ: 강남구, 강동구, 강북구, 강서구\n"
						 + "관악구, 광진구, 구로구, 금천구\n"
						 + "ㄴ: 노원구\n"
						 + "ㄷ: 도봉구, 동대문구, 동작구\n"
						 + "ㅁ: 마포구\n"
						 + "ㅅ: 서대문구, 서초구, 성동구, 성북구, 송파구\n"
						 + "ㅇ: 양천구, 영등포구, 용산구, 은평구\n"
						 + "ㅈ: 종로구, 중구, 중랑구");
		System.out.println("==============================");
		System.out.println();
		System.out.println("   예) \"마포구\" ");
		System.out.print("원하시는 지역을 입력해주세요 : ");
		String dist = scan.nextLine();
		
		clearScreen();
		System.out.printf("   \"%s\" 검색 결과입니다.\n", dist);
		
		int i = 0; // 인덱스 붙혀주기 
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> listNames = new ArrayList<String>();
		for (StoreTable s : storeList) {
			if (s.getStoreAddress().contains(dist)) { // 입력한 지역과 객체의 지역이 같다면 
				i = checkPush(i, list, listNames, s);
				
			}
		}
		
		if (m.getMemberType().equals(strMember)) { // 회원 
			BoardList.pageView(list, listNames, m);
			memberMenu();
			
		} 
		BoardList.pageViewExt(list); // 비회원
	} // localSearch()

	public static void title(String title) { // 텍스트 헤드 찍어주기 
		System.out.println("==============================");
		System.out.printf("\t%s\n", title);
		System.out.println("==============================");
	} // title

	
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}// Business 
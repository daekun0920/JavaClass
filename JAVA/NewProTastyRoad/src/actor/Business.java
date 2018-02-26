package actor;

import java.util.Scanner;

import dataTable.MemberTable;

public class Business {
	public static Scanner scan;
	static int wrongIdPw; // 아이디 혹은 비밀번호 틀린횟수 카운트
	static Member m;
	
	static final String strMember = "회원";
	static final String strOwner = "점주";
	static final String strAdmin = "관리자";
	
	static {
		wrongIdPw = 0;
		scan = new Scanner(System.in);
	}
	public static void main(String[] args) {
		DataBase.boardListLoad();
		DataBase.memberListLoad();
		DataBase.reservationListLoad();
		DataBase.storeListLoad();
		DataBase.wishListLoad();
		
		startScreen();	
		
		
		
	}
	public static void title(String title) { // 텍스트 헤드 찍어주기 
		System.out.println("==============================");
		System.out.printf("\t%s\n", title);
		System.out.println("==============================");
	} // title
	public static void clearScreen() { // 화면 넘기기
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

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
				break;
			} else {
				clearScreen();
				System.out.println("올바른 번호를 입력해주세요.\n");
			}
		} // while 
	} // startScreen (초기 화면)
	
	private static void logIn() {
		Boolean flag = false;
		Boolean subFlag = false; // 아이디/비밀번호 틀렸을때
		while (true) {
			title("로그인");
			System.out.println();
			System.out.print("	아이디 : ");
			String UserId = scan.nextLine();
			System.out.println();
			System.out.print("	비밀번호 : ");
			String UserPw = scan.nextLine();
			System.out.println();
			
			for (MemberTable e : DataBase.memberList) {
				if (e.getUserId().equals(UserId) && e.getUserPw().equals(UserPw)) {
					String type = e.getMemberType();
					
					if (type.equals(strMember)) {
						m = new BasicMember(UserId, UserPw, type);
						
						clearScreen();
						System.out.printf("  %s 님이 일반 회원으로 로그인 하셨습니다.\n", UserId);
						BasicMember.memberMenu(m);
						flag = true; // 로그아웃시 while문 탈출용
						break;
					} else if (type.equals(strOwner)) {
						m = new Owner(UserId, UserPw, type);
						
						clearScreen();
						System.out.printf("  %s 님이 점주 회원으로 로그인 하셨습니다.\n", UserId);
						Owner.ownerMenu(m);
						flag = true;
						break;
					} else if (type.equals(strAdmin)) {
						m = new Admin(UserId, UserPw, type);
						
						clearScreen();
						System.out.printf("  %s 님이 관리자로 로그인 하셨습니다.\n", UserId);
						Admin.adminScreen();
						flag = true;
						break;
					}
				} // if 
				if ((e.getUserId().equals(UserId) && !e.getUserPw().equals(UserPw)) ||
					(!e.getUserId().equals(UserId) && e.getUserPw().equals(UserPw))) { 
					wrongIdPw++; 
					clearScreen();
					System.out.printf("아이디 혹은 비밀번호 %d / 3회 오류입니다.\n", wrongIdPw);
					// 비밀번호 3번 틀리면 비밀번호 찾기로 가기
					if (wrongIdPw == 3) {
						wrongIdPw = 0;
						System.out.println("초기 화면으로 돌아갑니다.");
						flag = true;
						break;
					}
					subFlag = true;
					break;
				}  // if 
				
			} // for 
			if (flag) {
				break;
			}
			if (subFlag) { // 아이디/비밀번호 틀림
				continue;
			}
			clearScreen();
			System.out.println("존재하지 않는 계정 입니다.");
			continue;
		}
	} // logIn()
	
	private static void register() { // 회원가입
		while (true) {
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
				break;
			} else if (sel.equals("2")) {
				clearScreen();
				memberRegister(strOwner);
				break;
			} else {
				clearScreen();
				System.out.println("올바른 번호를 입력해주세요.");
				register();
			}
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
		Title.memberRegPt(userId, userPw, userName, userBirth, userTel, userEmail); // 화면 출력
		
		if (userType.equals("일반")) {
			userType = strMember;
		}
		
		validCheck(userId, userPw, userName, userBirth, userEmail, userType); // 다시 되돌아오면 유효성 검사 통과 
		
		
		MemberTable m = new MemberTable(userId, userPw,  userType, userName, userBirth, userTel, userEmail);
		DataBase.memberList.add(m);
		
		clearScreen();
		System.out.println("회원 가입이 완료 되었습니다.");
		startScreen(); // 회원가입 후 초기화면으로 복귀 
		
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
			
		while (true) {
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
				continue;
			} else if (userPw.contains(" ")) {
				clearScreen();
				System.out.println("비밀번호에는 공백이 들어갈 수 없습니다.");
				continue;
			} else if (userName.contains(" ")) {
				clearScreen();
				System.out.println("이름에는 공백이 들어갈 수 없습니다.");
				continue;
			} else if (dateFlag) {
				clearScreen();
				System.out.println("올바르지 않은 날짜입니다.");
				continue;
			} else if (emailFlag) {
				clearScreen();
				System.out.println("올바르지 않은 이메일 입니다.");
				continue;
			}
			break; // 유효성 검사 통과시 while문 break; -> 전 화면으로 돌아감
		}
		
	} // validcheck()
	static void searchList() { // 맛집 검색 선택 탭 
		while (true) {
			title("맛집 검색하기");
			String sel = Title.searchListPt(m);
			
			if (sel.equals("1")) { // 지역 별 검색
				clearScreen();
				Search.localSearch(m);
			} else if (sel.equals("2")) { // 음식 종류 별 검색
				clearScreen();
				Search.categorySearch(m);
			} else if (sel.equals("3")) { // 통합 검색
				clearScreen();
				totalSearch();
			} else if (sel.equals("0")) { // 뒤로 돌아가기
								   // 비회원 일때
					clearScreen();
					break;
			} else if (m.getMemberType().equals("비회원") && sel.equals("4")) { //  비회원 게시판 조회
				clearScreen();
				
				
				BoardList.pageView();
			} else if (m.getMemberType().equals("비회원") && sel.equals("5")) { // 비회원 게시판 작성
				BoardList.myBoardWrite(m);
				
				clearScreen();
				System.out.println("게시글 작성이 완료 되었습니다.");
			}
			
		}
		
	} // searchList()		
	
	
	
} // Business

package actor;

import java.util.Scanner;

public class Title { // 출력부 출력 클래스
	static Scanner scan;
	
	
	static {
		scan = new Scanner(System.in);
	}
	
	// Admin 클래스 관리자 초기화면 출력부
	public static String adminScreenPt() {
		Business.title("관 리 자 모 드");
		System.out.println();
		System.out.println("1. 가게 등록");
		System.out.println();
		System.out.println("2. 가게 삭제");
		System.out.println();
		System.out.println("3. 회원 목록");
		System.out.println();
		System.out.println("4. 회원 삭제");
		System.out.println();
		System.out.println("5. 게시판 조회");
		System.out.println();
		System.out.println("6. 게시판 삭제");
		System.out.println();
		System.out.println("7. 로그아웃");
		System.out.println("===========================");
		System.out.print("번호를 선택해주세요 : ");

		String sel = scan.nextLine();
			
		return  sel;
	}
	
	// Business 클래스 회원가입 출력부
	public static void memberRegPt(String userId // 참조형 주소를 받아와서 리턴값없이 원래 메소드에 값 전달 가능
								 , String userPw
								 , String userName
								 , String userBirth
								 , String userTel
								 , String userEmail) {
		System.out.println();
		System.out.println("   [영소문자 8~15자 입력해주세요]");
		System.out.print("   아이디 : ");
		userId = scan.nextLine();
		System.out.println();
		System.out.println("   [공백불가]");
		System.out.print("   비밀번호 : ");
		userPw = scan.nextLine();
		System.out.println();
		System.out.println("   [공백불가]");
		System.out.print("   이름 : ");
		userName = scan.nextLine();
		System.out.println();
		System.out.print("   생년월일 : ");
		userBirth = scan.nextLine();
		System.out.println();
		System.out.print("   전화번호 : ");
		userTel = scan.nextLine();
		System.out.println();
		System.out.print("   이메일 : ");
		userEmail = scan.nextLine();
		System.out.println();
		System.out.println("==============================");
		
	} // memberRegPt
		
	// Business 클래스 점주 초기화면 출력부 	
	public static String ownerMenuPt(Owner o) {
		Business.title(String.format("환영합니다, %s님\n", o.getMemberId()));
		System.out.println();
		System.out.println("   1. 가게 등록");
		System.out.println();
		System.out.println("   2. 가게 탈퇴");
		System.out.println("==============================");
		System.out.println("   3. 메뉴 추가");
		System.out.println();
		System.out.println("   4. 메뉴 삭제");
		System.out.println("==============================");
		System.out.println("   5. 태그 추가");
		System.out.println();
		System.out.println("   6. 태그 삭제");
		System.out.println("==============================");
		System.out.println("   7. 게시판 조회");
		System.out.println();
		System.out.println("   8. 게시글 작성");
		System.out.println();
		System.out.println("   9. 게시글 삭제");
		System.out.println();
		System.out.println("   10. 게시글 수정");
		System.out.println("==============================");
		System.out.println("   0. 로그아웃");
		System.out.println("==============================");
		System.out.print("번호를 입력해주세요 : ");
		String sel = scan.nextLine();
		
		
		return sel;
	}
	
	// Business 클래스 일반 회원 초기화면 출력부
	public static String memberMenuPt(Member m) {
		Business.title(String.format("환영합니다, %s님\n", m.getMemberId()));
		System.out.println();
		System.out.println("1. 맛집 검색하기");
		System.out.println();
		System.out.println("2. 게시판 이용하기");   
		System.out.println();
		System.out.println("3. 내 예약 목록 조회"); 
		System.out.println();
		System.out.println("4. 내 위시리스트");     
		System.out.println();
		System.out.println("5. 내 정보 수정");      
		System.out.println();
		System.out.println("6. 로그아웃");
		System.out.println();
		System.out.println("7. 회원 탈퇴");
		System.out.println("==============================");
		System.out.print("번호를 입력해주세요 : ");
		String sel = scan.nextLine();
		
		return sel;
	}
	
	// Business 클래스 일반, 점주 게시판 초기화면
	public static String toBoardPt() {
		Business.title("게시판 이용");
		System.out.println();
		System.out.println("   1. 게시글 작성");
		System.out.println();
		System.out.println("   2. 게시글 삭제");
		System.out.println();
		System.out.println("   3. 게시글 수정");
		System.out.println();
		System.out.println("   4. 게시글 조회");
		System.out.println();
		System.out.println("   0. 뒤로 돌아가기");
		System.out.println("==============================");
		System.out.print("번호를 입력해주세요 : ");
		String sel = scan.nextLine();
		
		return sel;
		
	}
	
	
	// business 클래스 지역 별 검색
	public static String localSearchPt() {
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
		
		return dist;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

} // Title

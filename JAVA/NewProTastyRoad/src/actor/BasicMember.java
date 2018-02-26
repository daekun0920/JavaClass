package actor;

import java.util.ArrayList;

import dataTable.Reservation;
import dataTable.StoreTable;
import dataTable.Wish;

public class BasicMember extends Member {

	BasicMember(String memberId, String memberPw, String memberType) {
		super(memberId, memberPw, memberType);
	}
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	public static void memberMenu(Member m) { // 5. 일반 회원 로그인 대기 탭 
		while (true) {
			String sel = Title.memberMenuPt(m);
			
			if (sel.equals("1")) { // 맛집 검색
				clearScreen();
				Business.searchList();
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
	public static int wishReservePage(ArrayList<String> list
								  	, ArrayList<String> listNames
								  	, Member m
								  	, String order) {
		String[] orderList = order.split(", ");
		order = orderList[0];
		String num = orderList[1];
		
		// 예약, 위시리스트, 페이지 이동 - > 어떻게 한꺼번에 넣을것인가?
		// "예약, 1", "페이지 이동, 4" ?
		// 나중에 위시리스트 삭제할때 1 감소한 favorite을 StoreList, 다른 계정의 해당 식당 wishlist  favorite 지수에 적용 해야함 
		if (order.equals("위시리스트")) {
			for (String s : list) { // 리스트에서 1. [toString] 형식으로 한줄씩 뽑아온다 
				if(s.startsWith(num)) { // 입력한 숫자로 시작하는가? 
					for (StoreTable t : DataBase.storeList) { // 가게 목록을 하나씩 꺼내온다 
						int index = (Integer.parseInt(num)) - 1; // 해당 가게 이름의 인덱스를 저장.
						if (t.getStoreName().equals(listNames.get(index))) {; // 가게 목록에서 뽑아온 가게의 이름이랑 내가 이름 목록에서 뽑아온 이름과 같은가?
							t.setFavorite(t.getFavorite() + 1); // favorite 1 추가 
							Wish w = new Wish(m.getMemberId() // 각 가게 정보를 기반으로 Wish 객체 생성 
											  , t.getStoreName()
											  , t.getStoreAddress()
											  , t.getStoreCategory()
											  , t.getStoreTel());
							DataBase.wishList.add(w); // 위시리스트에 추가  // 나중에 위시리스트 삭제할때 1 감소한 favorite을 모든 계정의 favorite 지수에 적용 해야함 
							Business.clearScreen();
							System.out.println("위시리스트에 추가가 완료되었습니다");
							return 0;
						}
					}
				} 
			} // for 
		} else if (order.equals("예약")) {
			for (String s : list) { // 리스트에서 1. [toString] 형식으로 한줄씩 뽑아온다 
				if(s.startsWith(num)) { // 입력한 숫자로 시작하는가? 
					for (StoreTable t : DataBase.storeList) { // 가게 목록을 하나씩 꺼내온다 
						int index = (Integer.parseInt(num)) - 1; // 해당 가게 이름의 인덱스를 저장.
						if (t.getStoreName().equals(listNames.get(index))) {; // 가게 목록에서 뽑아온 가게의 이름이랑 내가 이름 목록에서 뽑아온 이름과 같은가?
							
							int count = 0;
							for (Reservation e : DataBase.reserveList) {
								if (e.getStoreName().equals(listNames.get(index))) {
									count++;
								}
							} // for
							if (count < 11) {
								Reservation r = new Reservation(m.getMemberId()
										  , t.getStoreName()
										  , t.getStoreAddress()
										  , t.getStoreTel());
									
								DataBase.reserveList.add(r);
								Business.clearScreen();
								System.out.println("예약이 완료되었습니다");
								return 0;
							} else {
								System.out.println("해당 점포의 예약이 만석입니다.");
								return 0;
							}
						}
					}
				} 
			} 
		
		
}
		return 0;

}
	
	
}

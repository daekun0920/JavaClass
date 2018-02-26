package actor;
import java.util.ArrayList;
import java.util.Scanner;

import dataTable.Reservation;
import dataTable.StoreTable;
import dataTable.Wish;

public class BasicMember extends Member {
	
	
	
	BasicMember(String memberId, String memberPw, String memberType) {
		super(memberId, memberPw, memberType);
		// TODO Auto-generated constructor stub
	}
	
	static void wishReservePage(ArrayList<String> list
							  , ArrayList<String> listNames
							  , BasicMember m
							  , String order) {
//		System.out.print("[명령어 : 예약, 위시리스트, 페이지 이동]\n"
//						 + " 예) \"예약, 1\" or \"페이지 이동, 3\"\n"
//						 + "원하시는 명령어와 숫자를 입력해주세요 : " );
		
		
		String[] orderList = order.split(", ");
		order = orderList[0];
		String num = orderList[1];
		
		// 예약, 위시리스트, 페이지 이동 - > 어떻게 한꺼번에 넣을것인가?
		// "예약, 1", "페이지 이동, 4" ?
		// 나중에 위시리스트 삭제할때 1 감소한 favorite을 StoreList, 다른 계정의 해당 식당 wishlist  favorite 지수에 적용 해야함 
		if (order.equals("위시리스트")) {
			for (String s : list) { // 리스트에서 1. [toString] 형식으로 한줄씩 뽑아온다 
				if(s.startsWith(num)) { // 입력한 숫자로 시작하는가? 
					for (StoreTable t : Business.storeList) { // 가게 목록을 하나씩 꺼내온다 
						int index = (Integer.parseInt(num)) - 1; // 해당 가게 이름의 인덱스를 저장.
						if (t.getStoreName().equals(listNames.get(index))) {; // 가게 목록에서 뽑아온 가게의 이름이랑 내가 이름 목록에서 뽑아온 이름과 같은가?
							t.setFavorite(t.getFavorite() + 1); // favorite 1 추가 
							Wish w = new Wish(m.getMemberId() // 각 가게 정보를 기반으로 Wish 객체 생성 
											  , t.getStoreName()
											  , t.getStoreAddress()
											  , t.getStoreCategory()
											  , t.getStoreTel());
							Wish.wishList.add(w); // 위시리스트에 추가  // 나중에 위시리스트 삭제할때 1 감소한 favorite을 모든 계정의 favorite 지수에 적용 해야함 
							Business.clearScreen();
							System.out.println("위시리스트에 추가가 완료되었습니다");
							Business.searchList();
						}
					}
				} 
			} // for 
		} else if (order.equals("예약")) {
			for (String s : list) { // 리스트에서 1. [toString] 형식으로 한줄씩 뽑아온다 
				if(s.startsWith(num)) { // 입력한 숫자로 시작하는가? 
					for (StoreTable t : Business.storeList) { // 가게 목록을 하나씩 꺼내온다 
						int index = (Integer.parseInt(num)) - 1; // 해당 가게 이름의 인덱스를 저장.
						if (t.getStoreName().equals(listNames.get(index))) {; // 가게 목록에서 뽑아온 가게의 이름이랑 내가 이름 목록에서 뽑아온 이름과 같은가?
							
							/*private String userId;
							private String storeName;
							private String storeAddress;
							private String storeCategory;
							private String storeTel;
							private Integer favorite;
							private String tag;
							private String menu;*/
						
							int count = 0;
							for (Reservation e : Reservation.reserveList) {
								if (e.getStoreName().equals(listNames.get(index))) {
									count++;
								}
								if (count < 11) {
									Reservation r = new Reservation(m.getMemberId()
																  , t.getStoreName()
																  , t.getStoreAddress()
																  , t.getStoreTel());
									
									Reservation.reserveList.add(r);
									Business.clearScreen();
									System.out.println("예약이 완료되었습니다");
									Business.searchList();
								} else {
									System.out.println("해당 점포의 예약이 만석입니다.");
									break;
								}
							} // for
							if (count == 0) {
								Reservation r = new Reservation(m.getMemberId()
										  , t.getStoreName()
										  , t.getStoreAddress()
										  , t.getStoreTel());
									
								Reservation.reserveList.add(r);
								Business.clearScreen();
								System.out.println("예약이 완료되었습니다");
								Business.searchList();
							}
						}
					}
				} 
			} 
		} 
		
	} // printAndWishlist()
	
	
	
}

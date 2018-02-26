package dataTable;
import java.util.ArrayList;
import java.util.Iterator;

import actor.Business;
import actor.Member;

public class Reservation {
	private String userId;
	private String storeName;
	private String storeAddress;
	private String storeTel;
	
	
	
	
	public static ArrayList<Reservation> reserveList;
	
	static {
		reserveList = new ArrayList<>();
	}
	
	public Reservation(String userId
					 , String storeName
					 , String storeAddress
					 
					 , String storeTel
					
					 ) {
		this.userId = userId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeTel = storeTel;
		
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	
	
	
	public static void reserveLoad(Member m) {
		Business.title(String.format("\t%s님의 예약 목록", m.getMemberId()));

		for (Reservation r : reserveList) {
			if (r.getUserId().equals(m.getMemberId())) {
				System.out.println(String.format("%s\t%s\t%s\n"
											  , r.getStoreName()
											  , r.getStoreAddress()
											  , r.getStoreTel()));
					
			}
			
		
		}
		System.out.println("============================================");
		System.out.print("삭제하실 상호명을 입력하세요 : ");
		String rdelete = Business.scan.nextLine();
		for (Iterator<Reservation> iterator = reserveList.iterator(); iterator.hasNext();) {
			
			if(iterator.next().getStoreName().equals(rdelete)) {
				iterator.remove();
				Business.clearScreen();
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
		Business.memberMenu();
	} // reserveLoad()
}

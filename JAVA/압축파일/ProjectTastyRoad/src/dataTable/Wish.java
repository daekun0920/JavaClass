package dataTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import actor.Business;
import actor.Member;




/*
 (String myId) 아이디
 (String mystoreName) 상호
 (String mystoreAddress) 주소
 (String mystoreCategore) 음식점 카테고리
 (String mystoreTel) 전화번
 */
public class Wish {
	public static ArrayList<Wish> wishList;	
	static String wishPath;
	
	static {
		wishList = new ArrayList<Wish>(); // 모든 위시리스트를 저장한곳
		wishPath = "D:\\wish.txt";
	}
	
	private String myId;
	private String myStoreName;
	private String myStoreAddress;
	private String myStoreCategory;
	private String myStoreTel;
	
	
	public Wish(String myId
				, String myStoreName
				, String myStoreAddress
				, String myStoreCategory
				, String myStoreTel) {
		
		this.myId = myId;
		this.myStoreName = myStoreName;
		this.myStoreAddress = myStoreAddress;
		this.myStoreCategory = myStoreCategory;
		this.myStoreTel = myStoreTel;
	
	}
	public static ArrayList<Wish> getWishList() {
		return wishList;
	}
	public static void setWishList(ArrayList<Wish> wishList) {
		Wish.wishList = wishList;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getMyStoreName() {
		return myStoreName;
	}
	public void setMyStoreName(String myStoreName) {
		this.myStoreName = myStoreName;
	}
	public String getMyStoreAddress() {
		return myStoreAddress;
	}
	public void setMyStoreAddress(String myStoreAddress) {
		this.myStoreAddress = myStoreAddress;
	}
	public String getMyStoreCategory() {
		return myStoreCategory;
	}
	public void setMyStoreCategory(String myStoreCategory) {
		this.myStoreCategory = myStoreCategory;
	}
	public String getMyStoreTel() {
		return myStoreTel;
	}
	public void setMyStoreTel(String myStoreTel) {
		this.myStoreTel = myStoreTel;
	}
	
	public static void wloadDelete(Member m) {
		System.out.println("============================================");
		System.out.println("               나의 위시리스트 보기");
		System.out.println("============================================");
		for (Wish w : wishList) {
			if (w.getMyId().equals(m.getMemberId())) {
				System.out.println(String.format("%s\t%s\t%s\t%s\n" 
												, w.getMyStoreName()
											    , w.getMyStoreAddress()
												, w.getMyStoreCategory()
												, w.getMyStoreTel()));

			}
		}
		System.out.println("============================================");
		System.out.print("삭제하실 상호명을 입력하세요. 돌아가시려면 \"0\"을 입력해주세요. :");
		String delete = Business.scan.nextLine();
		if (delete.equals("0")) {
			Business.clearScreen();
			System.out.println("   이전 화면으로 돌아갑니다.");
			Business.memberMenu();
		}
		
		/*
		 
		 List<String> list = new ArrayList<String>();
		 ...
		 for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
		     String value = iterator.next();
		     if (value.length() > 5) {
		         iterator.remove();
		     }
		 }
		 
		 */
		
		if (!wishList.isEmpty()) {
			for (Iterator<Wish> iterator = wishList.iterator(); iterator.hasNext(); ) {
				if (iterator.next().getMyStoreName().equals(delete)) {
					iterator.remove();
					Business.clearScreen();
					System.out.println("삭제가 완료되었습니다.");
					for (StoreTable t : Business.storeList) {
						if(t.getStoreName().equals(delete)) {
						t.setFavorite(t.getFavorite() - 1);
							//겟으로 가져와서 셋으로 바꿔준다.
							
						}	
					}
					Business.memberMenu();
				}
			}
		} // if
		Business.clearScreen();
		System.out.println("존재하지 않는 상호명 입니다.");
		wloadDelete(m);
		
	}
	
}
